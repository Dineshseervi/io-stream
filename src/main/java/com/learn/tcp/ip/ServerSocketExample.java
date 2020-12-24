package com.learn.tcp.ip;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8085);
            while (true)
            {
                System.out.println("--serverSocket started waiting for connection--");
                Socket socket= serverSocket.accept();
                System.out.println("--client connected--");
                 Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true)
                        {
                            try {
                                InputStream inputStream= socket.getInputStream();
                                int i=inputStream.read();
                                while (i!=-1)
                                {
                                    System.out.print((char)i);
                                    i=inputStream.read();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                 t1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
