package com.learn.tcp.ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientScoketExample2 {
    public static void main(String[] args) throws IOException {
        //Socket socket=new Socket("jenkov.com",80);
        Socket socket=new Socket("localhost",8085);
        OutputStream output = socket.getOutputStream();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                try {
                    while (true && count <12) {
                        System.out.println("write");
                        String data = "Hello world ClientScoketExample2, pipe! count :" + count++ + " " + System.currentTimeMillis()+"\n";
                        output.write(data.getBytes());
                        Thread.sleep(9000);
                    }
                } catch (IOException | InterruptedException e) {
                }
            }
        });
        thread1.start();

    }
}
