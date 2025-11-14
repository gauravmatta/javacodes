package com.javaimplant.java17.concurrency.blockingqueue;

import com.javaimplant.java17.models.Books;
import com.javaimplant.java17.utils.BookUtils;

import java.util.concurrent.BlockingQueue;

public class BooksBlockingQueueConsumer implements Runnable {
    BookUtils cls=new BookUtils();
    protected BlockingQueue<Books> bbQueue;
    public BooksBlockingQueueConsumer(BlockingQueue<Books> bb){
        this.bbQueue=bb;
    }
    @Override
    public void run() {
        var s=cls.retBooks().size();
        for (int i = 0; i < s; i++) {
            try {
                System.out.println(bbQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
