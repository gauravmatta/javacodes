package com.javaimplant.java17.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQueueTester {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(7);
        BlockingQueueProducer prod = new BlockingQueueProducer(blockingQueue);
        BlockingQueueConsumer cons = new BlockingQueueConsumer(blockingQueue);
        (new Thread(prod)).start();
        (new Thread(cons)).start();
    }
}
