package com.learn.tcp.ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientScoket {
    public static void main(String[] args) throws IOException {
        //Socket socket=new Socket("jenkov.com",80);
        Socket socket=new Socket("localhost",8085);
        OutputStream output = socket.getOutputStream();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                try {
                    while (true && count <100 && !socket.isClosed()) {
                        System.out.println("write : "+count);
                        String data = "Hello world, pipe! count :" + count++ + " " + System.currentTimeMillis()+"\n";
                        output.write(data.getBytes());
                        Thread.sleep(9000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    try {
                        output.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(30000);
            System.out.println("sleep is over");
            output.close();
            socket.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
