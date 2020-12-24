package com.learn.syncronising.model;

public class Calculator {
    private Integer resultValue = 200;

    public void add ()
    {
        synchronized ("Calculator.add")
        {
            System.out.println("in add method ");
            try {
                this.resultValue++;
                //Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("out add method ");
        }
    }

    public void substract()
    {
        synchronized ("Calculator.subtract")
        {
            System.out.println("-- in subtract block");
            try {
                this.resultValue--;
                //Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("-- out subtract block");
        }
    }

    public Integer getResultValue()
    {
        return resultValue;
    }
}
