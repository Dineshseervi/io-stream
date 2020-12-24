package com.learn.io.stream.file;

import java.io.*;

public class PipeExample {
    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream  input  = new PipedInputStream(output);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                try {
                    while (true && count <10) {
                        System.out.println("write");
                        String data = "Hello world, pipe! count :" + count++ + " " + System.currentTimeMillis()+"\n";
                        output.write(data.getBytes());
                        Thread.sleep(9000);
                    }
                } catch (IOException | InterruptedException e) {
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //int data = input.read();
                    /*while(data != -1){
                        System.out.print((char) data);
                        data = input.read();
                    }*/
                    PipeExample pipeExample=new PipeExample();
                    pipeExample.printData(input);
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
        thread2.start();


    }

    void copy(InputStream source, OutputStream target) throws IOException {
        //byte[] buf = new byte[8192];
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) > 0) {
            System.out.println("length--"+length);
            target.write(buf, 0, length);
        }
    }

    void printData(InputStream source) throws IOException {
        //byte[] buf = new byte[8192];

        byte[] buf = new byte[1];
        int length;
        while ((length = source.read(buf)) > 0) {
           // System.out.println("read--");
           // System.out.println("length--"+length);
           // System.out.println("read");

           String data=new String(buf);
            System.out.print(data);
        }
    }
}
