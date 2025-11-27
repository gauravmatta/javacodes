package com.javaimplant.java17.features;

public class MyResource implements AutoCloseable{

    public MyResource(){
        System.out.println("MyResource: Resource opened");
    }

    public void doSomething(){
        System.out.println("MyResource: Doing something with the resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyResource: Resource closed");
    }
}
