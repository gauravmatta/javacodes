package com.javaimplant.java17.main;

public class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+" $$$$Sqrt("+i+")="+Math.sqrt(i));
        }
    }
}
