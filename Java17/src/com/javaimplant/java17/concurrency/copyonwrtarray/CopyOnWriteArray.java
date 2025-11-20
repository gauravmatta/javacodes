package com.javaimplant.java17.concurrency.copyonwrtarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArray extends Thread{

    static CopyOnWriteArrayList<String> coparr= new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        coparr.add("Sunny");
        String[] arr= {"Physics","nuclear physics","geo physics","Curvilinear Coordinates","polar coordinates"};
        Arrays.stream(arr).map(String::toUpperCase).forEach(n->{
            coparr.add(n);
        });
    }
    public static void main(String[] args) throws InterruptedException {
        coparr.add("Snowy");
        coparr.add("Chilly");
        coparr.add("dry");
        coparr.add("Autumn");
        coparr.add("Summer");
        coparr.add("Rainy");
        CopyOnWriteArray cls=new CopyOnWriteArray();
        cls.start();
        Thread.sleep(3000);
        Iterator<String> itr=coparr.iterator();
        while(itr.hasNext()) {
            String s= itr.next();
            System.out.println(s.toUpperCase());
            Thread.sleep(3000);
        }
        System.out.println(coparr);
    }
}
