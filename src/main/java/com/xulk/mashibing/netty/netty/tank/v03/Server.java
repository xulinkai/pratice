package com.xulk.mashibing.netty.netty.tank.v03;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @description: nio版的server
 * @author:
 * @create: 2020-01-04 17:06
 **/
public class Server {


    /**
    * 记录所有客户端的通道组
    */
    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



    /** 
    * @Description: 启动服务端
    * @Date: 2020/1/5  15:41
    */ 
    public void serverStart() {
        // 1 代表是一个线程  只负责与客户端的连接   类似于饭店的迎宾
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //2 代表两个 线程  负责处理客户端的连接     类似于饭店的服务员
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            ChannelFuture channelFuture = serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println(socketChannel);
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //加上自己的处理
                            pipeline.addLast(new TankMsgDecoder())
                                    .addLast(new ServerChildHandler());
                        }
                    })
                    .bind(8888)
                    //如果不加sync();因为方法都是异步的，不管bind有没有报错，下面得语句都会正常输出，这是不行的
                    .sync();
            System.out.println("server started");
            ServerFrame.INSTANCE.updateServerMsg("server started!");
            //执行完这段代码  close Future之后，才会继续往下执行  不close的时候 将永远等待  类似于饭店的关门人员
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

class ServerChildHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //把当前客户端添加到通道组里面
        Server.clients.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //与上一个版本不同的是 引入了TankMsgDecoder的处理 这个的msg 直接就是tankMsg
        System.out.println("channel read...............");
        try {
            TankMsg tankMsg = (TankMsg) msg;
            System.out.println(tankMsg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
        /*ByteBuf byteBuf = null;
        try {
            byteBuf = (ByteBuf) msg;
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(byteBuf.readerIndex(), bytes);
            String acceptMsg = new String(bytes);
            System.out.println("服务端读到的内容： " + acceptMsg);
            //更新信息的展示
            ServerFrame.INSTANCE.updateClientMsg(acceptMsg);
            if("_bye_".equals(acceptMsg)){
                ServerFrame.INSTANCE.updateServerMsg("客户端请求退出........");
                System.out.println("客户端请求退出......");
                Server.clients.remove(ctx.channel());
                //ctx服务对应的channel
                ctx.close();
            }else{
                //写回到客户端  writeAndFlush会自动释放byteBuf，就不能再次释放了  不加这一行的时候就需要手动释放
                //也就是说只涉及到  读不涉及往客户端写的时候 ，需要手动释放byteBuf
                //ctx.writeAndFlush(msg);
                //把当前信息写到通道组里面的所有通道中
                Server.clients.writeAndFlush(msg);
            }
        } finally {
            if (byteBuf != null) {
                //释放掉byteBuf
                //ReferenceCountUtil.release(byteBuf);
            }
        }*/
    }

    /**
     * @Description: 当有异常的时候 打印异常信息
     * @Date: 2020/1/4  19:43
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //当当前通道产生异常的时候，把异常信息记录下来 并关闭ctx
        cause.printStackTrace();
        //删除出现异常的客户端channel 并关闭连接
        Server.clients.remove(ctx.channel());
        //ctx关闭的时候，里面的channel会close 并会通知client端，
        ctx.close();
    }
}
