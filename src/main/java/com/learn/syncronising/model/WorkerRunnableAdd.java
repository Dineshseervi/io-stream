package com.learn.syncronising.model;

public class WorkerRunnableAdd implements Runnable {

    private Calculator calculator;

    public WorkerRunnableAdd(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            calculator.add();
        }
        System.out.println("add method :" + calculator.getResultValue());
    }
}
