package com.xulk.mashibing.netty.netty.tank.v02;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

/**
 * @description:
 *
 * @author:
 * @create: 2020-01-04 09:55
 **/
public class Client {
    /**
    * 每一个客户端连接到服务器上之后会有一个channel存在
     * 连接成功之后 初始化channel
     * 客户端需要发送内容到服务端，发送内容的地方需要持有channel
    */
    private Channel channel = null;

    public void connect(){
        //netty自动式多线程 多线程封装在 eventLoopGroup里面
        EventLoopGroup group = new NioEventLoopGroup();
        //辅助启动的类
        Bootstrap bootstrap = new Bootstrap();
        try {
            //写法2 使用异步的方式 判断处理结果是否成功 执行响应逻辑
            ChannelFuture future = bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer())
                    .connect("localhost", 8888);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(channelFuture.isSuccess()){
                        System.out.println("connect successed");
                        //连接成功之后进行初始化channel 在netty里面，发送、接收信息都是利用channel来操作的
                        channel = future.channel();
                    }else{
                        System.out.println("connect failed");
                    }
                }
            });

            //不加的话，程序直接结束了·
            future.sync();
            System.out.println("........");
            //
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //结束的时候也很方便   优雅的结束
            group.shutdownGracefully();
        }
    }

    public void send(String msg){
        //msg转换成一个byteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer(msg.getBytes());
        //将当前msg写给服务器
        channel.writeAndFlush(byteBuf);
    }

    public static void main(String[] args) {
       Client client = new Client();
       client.connect();
    }
}

/**
* @Description:   上面的写法也可以直接使用 new ChannelInitializer   不采用匿名内部类的形式
* @Date: 2020/1/4  10:24
*/
class ClientChannelInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ClientHandler());

    }
}

class  ClientHandler extends ChannelInboundHandlerAdapter {
    /**
    * @Description: 处理客户端写回来的内容
    * @Date: 2020/1/4  19:31
    */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = null;
        try {
            byteBuf = (ByteBuf) msg;
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(byteBuf.readerIndex(), bytes);
            System.out.println("客户端读到服务器返回的内容： "+new String(bytes));
            //服务器返回的字符串
            String msgAccept = new String(bytes);
            ClientFrame.INSTANCE.updateText(msgAccept);
        } finally {
            if (byteBuf != null) {
                //释放掉byteBuf
                ReferenceCountUtil.release(byteBuf);
            }
        }
    }

    /** 
    * @Description: 发送数据到服务端
    * @Date: 2020/1/4  19:41
    */ 
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
        * byteBuf  跳过了垃圾回收机制  内容越来越多 需要手动释放
        */
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello this is client writing".getBytes());
        //自动释放 内存(byteBuf)
        ctx.writeAndFlush(byteBuf);
    }
}

