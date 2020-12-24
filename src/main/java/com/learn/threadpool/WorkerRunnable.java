package com.learn.threadpool;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;


public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            int count=0;
            try {
                /*int i=input.read();
                while (i!=-1)
                {
                    System.out.print((char)i);
                    i=input.read();
                }*/
                byte[] buf = new byte[8192];

                int length;
                while ((length = input.read(buf)) > 0) {
                    String data=new String(buf,0,length);
                    System.out.print(data);
                    Thread.sleep(100);
                }
            } catch (IOException  e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
