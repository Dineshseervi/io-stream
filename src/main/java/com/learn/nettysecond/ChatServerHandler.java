package com.learn.nettysecond;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
//import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;

public class ChatServerHandler extends ChannelInboundMessageHandlerAdapter<String> {

    //private static final ChannelGroup CHANNEL_GROUP =new DefaultChannelGroup(new DefaultEventExecutor());
    private static final ChannelGroup CHANNEL_GROUP =new DefaultChannelGroup();
    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }*/

    /*@Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incomming= ctx.channel();
        for(Channel channel:CHANNEL_GROUP)
        {
            if(incomming!=channel)
            {
                channel.write("["+incomming.remoteAddress()+" ]"+msg+"\n");
            }
        }
        System.out.println("channelRead0 method has been called");
    }*/

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //super.handlerAdded(ctx);
        System.out.println("handlerAdded method has been called");
        Channel incomming= ctx.channel();
        for (Channel channel:CHANNEL_GROUP)
        {
            channel.write("[SERVER]- "+incomming.remoteAddress()+" has joined! \n");
        }
        CHANNEL_GROUP.add(incomming);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved method has been called");
        Channel incomming= ctx.channel();
        for (Channel channel:CHANNEL_GROUP)
        {
            channel.write("[SERVER]- "+incomming.remoteAddress()+" has left! \n");
        }
        CHANNEL_GROUP.remove(incomming);
    }

  /*  @Override
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
        Channel incomming= channelHandlerContext.channel();
        for(Channel channel:CHANNEL_GROUP)
        {
            if(incomming!=channel)
            {
                channel.write("["+incomming.remoteAddress()+" ]"+s+"\n");
            }
        }
        System.out.println("channelRead0 method has been called");

    }


}
