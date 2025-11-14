package com.javaimplant.java17.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable{

    protected BlockingQueue<String> bQueue;

    public BlockingQueueProducer(BlockingQueue<String> b) {
        this.bQueue=b;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            bQueue.put("Baga Beach");
            Thread.sleep(6000);
            bQueue.put("Calangute Beach");
            Thread.sleep(5000);
            bQueue.put("Anjuna Beach");
            Thread.sleep(4000);
            bQueue.put("Ashwem Beach");
            Thread.sleep(3000);
            bQueue.put("Arambol Beach");
            Thread.sleep(2000);
            bQueue.put("Palolem Beach");
            Thread.sleep(1000);
            bQueue.put("Agonda Beach");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
