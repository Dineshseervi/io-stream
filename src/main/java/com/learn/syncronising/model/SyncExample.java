package com.learn.syncronising.model;

public class SyncExample {

    public static void main(String[] args) {

        Calculator calculator=new Calculator();
        new Thread(new WorkerRunnableAdd(calculator)).start();
        new Thread(new WorkerRunnableSubstract(calculator)).start();
    }
}
