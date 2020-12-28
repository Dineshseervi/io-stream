package com.learn.nettysecond;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClient2 {

    private final String host;
    private final int port;

    public static void main(String[] args) {
        new ChatClient2("localhost",8085).run();
    }
    public ChatClient2(String host, Integer port)
    {
        this.host=host;
        this.port=port;
    }

    public void run()
    {
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap()
                    .group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitilizer());

            Channel channel=bootstrap.connect(host,port).sync().channel();

            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                System.out.println("--write--");
                channel.write(reader.readLine()+"\r\n");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
