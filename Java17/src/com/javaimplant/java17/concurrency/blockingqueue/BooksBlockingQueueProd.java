package com.javaimplant.java17.concurrency.blockingqueue;

import com.javaimplant.java17.models.Books;
import com.javaimplant.java17.utils.BookUtils;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class BooksBlockingQueueProd implements Runnable{
    BookUtils cls=new BookUtils();
    protected BlockingQueue<Books> bbQueue;
    public BooksBlockingQueueProd(BlockingQueue<Books> b) {
        this.bbQueue=b;
    }
    @Override
    public void run() {
        List<Books> lb=cls.retBooks();
        lb.forEach(n->{
            try {
                Thread.sleep(3000);
                bbQueue.put(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
