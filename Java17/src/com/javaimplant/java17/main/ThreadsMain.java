package com.javaimplant.java17.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreadsMain extends Thread{
    public static void main(String[] args) {
        threadsDefinations();
        lambdaThreadDefinations();
        parameterizedThreads();
    }

    private static void parameterizedThreads() {
        Runnable runc = new Runnable() {
            private int i;

            public int getI() {
                return i;
            }

            public void setI(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                this.setI(20);
                for(int j=0;j<=i;j++){
                    System.out.println("!!!!!!"+Math.log(j));
                }
            }
        };
        runc.run();
    }

    private static void lambdaThreadDefinations() {
        Runnable runa=()->{
            for(int i = 0; i< 10; i++){
                System.out.println(Thread.currentThread().getName()+" Running "+(i+1));
            }
        };
        runa.run();
        var threadb = new Thread(()->{
            for(int i = 0; i< 10; i++){
                System.out.println(Thread.currentThread().getName()+" ####Running "+(i+1));
            }
        });
        threadb.start();
        new Thread(()->{
            for(int i = 0; i< 10; i++){
                System.out.println(Thread.currentThread().getName()+" @@@@@Running "+(i+1));
            }
        }).start();
        var threadGroup = new Runnable[] {runa,threadb};
        for(Runnable r:threadGroup){
            r.run();
        }
        System.out.println("*".repeat(50));
        List<Runnable> lir = Arrays.asList(runa,threadb);
        for (Runnable aa : lir) {
            aa.run();
        }
    }

    private static void threadsDefinations() {
        var thread = new ThreadsMain();
        thread.start();
        var runnableThread = new MyThread();
        runnableThread.run();
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println(Thread.currentThread().getName()+" &&&&Log10("+i+")="+Math.log10(i));
                }
            }
        };
        myRun.run();
        Thread thrc = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Thread with Runnable passed in Thread");
            }
        });
        thrc.start();
        new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Direct Runnable Thread");
            }
        }.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Anonymous Thread with Runnable passed in Thread");
            }
        }).start();
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+" ****Log("+i+")="+Math.log(i));
        }
    }
}
