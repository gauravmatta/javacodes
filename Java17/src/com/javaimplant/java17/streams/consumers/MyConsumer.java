package com.javaimplant.java17.streams.consumers;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println("Consuming "+s.toUpperCase());
    }
}
