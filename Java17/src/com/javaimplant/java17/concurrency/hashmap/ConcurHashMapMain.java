package com.javaimplant.java17.concurrency.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ConcurHashMapMain {
    public static void main(String[] args) {
        methA();
        Consumer<String> printStr= n-> System.out.println(n.repeat(100));
        printStr.accept("=");
        ConcurrentHashMap<Integer, String> chm= new ConcurrentHashMap<>();
        Integer[] arr1= {11,12,13,14,15};
        String[] arr2= {"Physics","Mathematics","Chemistry","Geology","Sociology"};
        for (int i = 0; i < arr2.length; i++) {
            chm.put(arr1[i], arr2[i]);
        }
        for (Map.Entry<Integer, String> integerStringEntry : chm.entrySet()) {
            chm.put(212, "Archaeology");
            System.out.println(integerStringEntry);
        }
        printStr.accept("*");
        chm.entrySet().stream().iterator().forEachRemaining(n->{
            chm.put(214, "Quantum Physics");
            chm.put(213, "Georgian Plains Geology");
            System.out.println(n.getKey()+" "+n.getValue());
        });
        printStr.accept("-");
        System.out.println(Arrays.deepToString(chm.entrySet().toArray()));
    }

    private static void methA() {
        HashMap<Integer, String> hm=new HashMap<Integer, String>();
        hm.put(21, "Physics");
        hm.put(22, "Nuclear Physics");
        var itr=hm.entrySet().iterator();
//        Gives ConcurrentModificationException when we modify the map during iteration
//        while(itr.hasNext()) {
//            hm.put(23, "Quantum Electro Dynamics");
//            System.out.println(itr.next());
//        }
    }
}
