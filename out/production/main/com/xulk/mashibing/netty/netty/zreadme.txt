

netty自动是多线程的

1、在netty里面channel相当于网络里的socket，用于发消息、接收消息，
   也可以使用ctx来发送、接收，因为ctx内部也是调用的ctx.channel().writeAndFlush();