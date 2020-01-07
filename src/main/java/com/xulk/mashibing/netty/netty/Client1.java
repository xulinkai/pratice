package com.xulk.mashibing.netty.netty;

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
 * @author:
 * @create: 2020-01-04 09:55
 **/
public class Client1 {

    public static void main(String[] args) {
        //netty自动式多线程 多线程封装在 eventLoopGroup里面
        EventLoopGroup group = new NioEventLoopGroup();
        //辅助启动的类
        Bootstrap bootstrap = new Bootstrap();
        try {
            //写法1  使用同步的方式进行异常处理
            /*
            //指定使用线程池  处理
            bootstrap.group(group)
                    //指定模式类型 非阻塞版  也可以指定为阻塞版
                    .channel(NioSocketChannel.class)
                    //有事件的时候交给当前的hanlder处理
                    .handler(new ClientChannelInitializer())
                    //connect 是一个异步方法 如果不加sync()的话，方法直接往下走，连上连不上跟它没有关系
                    //netty里面所有的方法都是异步方法
                    .connect("localhost", 8888)
                    //异步方法设置为同步方法
                    .sync();
             */
            //写法2 使用异步的方式 判断处理结果是否成功 执行响应逻辑
            ChannelFuture future = bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer1())
                    .connect("localhost", 8888);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(channelFuture.isSuccess()){
                        System.out.println("connect successed");
                    }else{
                        System.out.println("not connect successed");
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
}

/**
* @Description:   上面的写法也可以直接使用 new ChannelInitializer   不采用匿名内部类的形式
* @Date: 2020/1/4  10:24
*/
class ClientChannelInitializer1 extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ClientHandler1());

    }
}

class  ClientHandler1 extends ChannelInboundHandlerAdapter {
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
            System.out.println("客户端读到的内容： "+new String(bytes));
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

