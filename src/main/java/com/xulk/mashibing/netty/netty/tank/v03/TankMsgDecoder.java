package com.xulk.mashibing.netty.netty.tank.v03;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description:
 *                  tankMsgEncoder负责编码
 *  *               tankMsgDecoder负责解码
 *  *               将encoder加入客户端的channel处理链
 *  *               将decoder加入服务器的channel处理链
 *  *               在客户端channelActiave的时候发送一个tankMsg
 *  *               观察服务端是否接收正确
 * @author:
 * @create: 2020-01-05 16:08
 **/
public class TankMsgDecoder extends ByteToMessageDecoder {
    
    /** 
    * @Description: 负责把数组转换为消息
    * @Date: 2020/1/5  21:37
    */ 
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        //小于八个字节 还没有读全  解决TCP的拆包和粘包问题
        if(in.readableBytes() < 8){
            return;
        }
        in.markReaderIndex();
        //先写的先读
        int x = in.readInt();
        int y = in.readInt();
        out.add(new TankMsg(x, y));
    }
}
