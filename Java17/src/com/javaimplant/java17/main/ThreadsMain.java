package com.javaimplant.java17.main;

public class ThreadsMain extends Thread{
    public static void main(String[] args) {
        threadsDefinations();
        lambdaThreadDefinations();
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
