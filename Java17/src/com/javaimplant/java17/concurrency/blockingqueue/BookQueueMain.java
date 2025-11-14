package com.javaimplant.java17.concurrency.blockingqueue;

import com.javaimplant.java17.models.Books;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BookQueueMain {
    public static void main(String[] args) {
        BlockingQueue<Books> bb= new ArrayBlockingQueue<>(15);
        BooksBlockingQueueProd prod=new BooksBlockingQueueProd(bb);
        BooksBlockingQueueConsumer cons=new BooksBlockingQueueConsumer(bb);
        Thread thProd=new Thread(prod);
        Thread thCons=new Thread(cons);
        thProd.start();
        thCons.start();
    }

}
