package com.javaimplant.java17.concurrency.skipList;

import com.javaimplant.java17.records.Books;

import javax.swing.*;
import java.util.Date;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class SkipList {
    public static void main(String[] args) {
        System.out.println("Skip List Example");
        ConcurrentNavigableMap<Integer,String> cnm=new ConcurrentSkipListMap<>();
        Integer[] arr1= {11,12,13,14,15};
        String[] arr2= {"Physics","nuclear physics","geo physics","Curvilinear Coordinates","polar coordinates"};
        for (int i = 0; i < arr2.length; i++) {
            cnm.put(arr1[i], arr2[i]);
        }
        NavigableSet<Integer> set=cnm.descendingKeySet();
        Iterator<Integer> itr=set.iterator();
        while(itr.hasNext()) {
            Integer i= itr.next();
            System.out.println(i);
        }
        System.out.println(cnm.firstEntry());
        System.out.println(cnm.lastEntry());
        System.out.println(cnm.pollFirstEntry());
        System.out.println(cnm.firstEntry());
        System.out.println(cnm.pollLastEntry());
        System.out.println(cnm.lastEntry());
        var dt=new Date();
        JOptionPane.showMessageDialog(null,dt.getMinutes());
        Books b;
        StringBuffer buf=new StringBuffer();
        for (int i=0; i<10000000;i++){
            b = new Books(i + 1, "Book-" + (i + 1), "Author-" + (i + 1));
            buf.append(b.toString());
            int finalI = i;
            new Thread("Thread-"+(finalI +1)){
                @Override
                public void run() {
                    cnm.put(finalI +100, "Book-"+(finalI +100));
                    System.out.println("Added: "+cnm.get(finalI +100)+" by "+Thread.currentThread().getName());
                }
            }.start();
        }
        System.out.println(buf);
        JOptionPane.showMessageDialog(null,dt.getMinutes());
    }
}
