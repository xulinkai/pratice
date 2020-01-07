package com.xulk.mashibing.netty.netty.tank.v01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description:
 *               tankMsgEncoder负责编码
 *               tankMsgDecoder负责解码
 *               将encoder加入客户端的channel处理链
 *               将decoder加入服务器的channel处理链
 *               在客户端channelActiave的时候发送一个tankMsg
 *               观察服务端是否接收正确
 * @author:
 * @create: 2020-01-05 16:07
 **/
public class TankMsgEncoder extends MessageToByteEncoder<TankMsg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, TankMsg tankMsg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(tankMsg.x);
        byteBuf.writeInt(tankMsg.y);
    }
}
