package com.learn.threadpool;

public class MainThreadPool {
    public static void main(String[] args) {
        ThreadPooledServer server = new ThreadPooledServer(8085);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
