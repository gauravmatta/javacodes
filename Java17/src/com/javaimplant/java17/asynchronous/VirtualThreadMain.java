package com.javaimplant.java17.asynchronous;

public class VirtualThreadMain {
    public static void main(String[] args) {
        // Uses Java 19 and above features
        Runnable task = () -> {
            System.out.println("Virtual Thread: " + Thread.currentThread().getName());
        };
        Thread.startVirtualThread(task);
        Runnable threadTask = () -> {
            System.out.println("Another Virtual Thread: " + Thread.currentThread().getName());
        };
        Thread.ofVirtual().start(threadTask);
        Thread virtualThread = Thread.ofVirtual().unstarted(threadTask);
        virtualThread.start();
    }
}
