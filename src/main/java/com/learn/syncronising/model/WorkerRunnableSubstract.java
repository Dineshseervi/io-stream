package com.learn.syncronising.model;

public class WorkerRunnableSubstract implements Runnable {

    private Calculator calculator;

    public WorkerRunnableSubstract(Calculator calculator)
    {
        this.calculator=calculator;
    }

    @Override
    public void run() {

        for(int i=0;i<100;i++)
        {
            calculator.substract();
        }
        System.out.println("substract method :" + calculator.getResultValue());
    }
}
