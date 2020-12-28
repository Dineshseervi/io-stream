package com.learn.nettysecond;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
//import io.netty.channel.SimpleChannelInboundHandler;

public class ChatClientHandler extends ChannelInboundMessageHandlerAdapter<String> {


    /*@Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        System.out.println(msg.toString());
    }*/

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        System.out.println(msg.toString());
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("---");
        System.out.println(s);
    }


}
