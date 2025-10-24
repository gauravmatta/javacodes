package com.javaimplant.java17.consumers;

import com.javaimplant.java17.records.Books;

import java.util.function.Consumer;

public class BooksConsumer implements Consumer<Books> {
    @Override
    public void accept(Books t) {
        System.out.println("The record is "+t.toString());
    }
}