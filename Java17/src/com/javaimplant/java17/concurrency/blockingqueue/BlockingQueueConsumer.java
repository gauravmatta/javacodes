package com.javaimplant.java17.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable{

    protected BlockingQueue<String> blockingQueue;

    public BlockingQueueConsumer(BlockingQueue<String> b) {
        this.blockingQueue=b;
    }

    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
