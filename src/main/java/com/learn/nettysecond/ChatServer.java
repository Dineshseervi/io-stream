package com.learn.nettysecond;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {

    private final int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public void run()
    {
        EventLoopGroup baseGroup= new NioEventLoopGroup();
        EventLoopGroup workerGroup= new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap=new ServerBootstrap()
                    .group(baseGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitilizer());
            System.out.println("--start server--");
            serverBootstrap.bind(port).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
                baseGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new ChatServer(8085).run();
    }
}
