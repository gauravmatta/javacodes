package com.javaimplant.java17.streams;

import com.javaimplant.java17.streams.consumers.MyConsumer;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        List<String> lia = listProducer();
        System.out.println(lia);
        stringStream();
        drawLine();
        integerStream();
        drawLine();
        floatStream();
        drawLine();
        doubleStream();
        drawLine();
        booleanStream();
        drawLine();
        nonTransientStreams();
        drawLine();
        hashSetStream();
        drawLine();
        hashmapStream();
        drawLine();
        hashTableStream();
        drawLine();
        doubleArrayStream();
        drawLine();
        booleanArrayStream();
        drawLine();
        byteArrayStream();

    }

    private static void doubleArrayStream() {
        Double[] arrD={12.33,45.67,78.89,90.12,34.56,67.89,23.45,89.01,11.22,44.55};
        Arrays.asList(arrD).stream().forEach(System.out::println);
    }

    private static void booleanArrayStream() {
        Boolean[] arrB={true,false,true,false,true,false,true,false,true,false};
        Arrays.asList(arrB).stream().forEach(System.out::println);
    }

    private static void byteArrayStream() {
        String str="This is a string to be converted to stream";
        byte[] bArr=str.getBytes();
        Arrays.asList(bArr).stream().forEach(System.out::println);
        drawLine();
    }

    private static void hashTableStream() {
        Hashtable<Integer,Character> ht=new Hashtable<>();
        for(int i=0;i<10;i++) {
            ht.put(i+1, (char) ('K'+i));
        }
        ht.forEach(new BiConsumer<Integer, Character>() {
            @Override
            public void accept(Integer integer, Character character) {
                System.out.println("Hashtable Key: "+integer+" Value: "+character);
            }
        });
    }

    private static void hashmapStream() {
        HashMap<Integer,Character> hm=new HashMap<>();
        Integer[] arr1={1,2,3,4,5,6,7,8,9,10};
        Character[] arr2={'A','B','C','D','E','F','G','H','I','J'};
        for(int i=0;i<arr1.length;i++) {
            hm.put(arr1[i], arr2[i]);
        }
        BiConsumer<Integer,Character> biConsumer=new BiConsumer<Integer, Character>() {
            @Override
            public void accept(Integer integer, Character character) {
                System.out.println("Key: "+integer+" Value: "+character);
            }
        };
        hm.forEach(biConsumer);
        hm.forEach((k,v)->{;
            System.out.println("Key in lambda: "+k+" Value in lambda: "+v);
        });
    }

    private static void hashSetStream() {
        Integer[] arr={12,12,12,12,12,12,12,12,34,45,56,56,67,78,89,90,91,92,92,93,94,95,96,97,97,97,97,98,99,100};
        HashSet<Integer> hs=new HashSet<Integer>();
        Arrays.asList(arr).stream().forEach(n->hs.add(n));
        System.out.println("Unique values in the array: "+hs);
        hs.stream().forEach(System.out::println);
    }

    private static void nonTransientStreams() {
        Stream<Double> strc = Stream.of(2.2224242424,7.77373737,8.757575775,99.8748747747,45.545454545);
        var arr = strc.toArray();
        for(var v:arr){
            Double d=(Double)v;
            System.out.println("Sqrt("+d+")="+Math.sqrt(d));
        }
    }

    private static void booleanStream() {
        Stream.of(true,false,true,false,true).forEach(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) {
                System.out.println("Value: "+aBoolean);
                System.out.println("Negation: "+!aBoolean);
            }
        });
    }

    private static void doubleStream() {
        Stream.of(2.2224242424,7.77373737,8.757575775,99.8748747747,45.545454545).forEach(new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("Rounding("+aDouble+")="+Math.round(aDouble));
                System.out.println("Log("+aDouble+")="+Math.log(aDouble));
                System.out.println("Log10("+aDouble+")="+Math.log10(aDouble));
            }
        });
    }

    private static void floatStream() {
        Stream<Float> stria=liaFloatProducer().stream();
        stria.forEach(System.out::println);
        Stream.of(liaFloatProducer().toArray()).forEach(System.out::println);
    }

    private static List<Float> liaFloatProducer() {
        List<Float> lia = new ArrayList<>();
        for(int i=1;i<=100;i++){
            lia.add((i+1.66336f));
        }
        return lia;
    }

    private static void integerStream() {
        Stream<Integer> stria = producerInt().stream();
        Stream striaOf = Stream.of(producerInt().toArray());
        stria.forEach(System.out::println);
        striaOf.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer o) {
                System.out.println(Math.log(o));
            }
        });
        drawLine();
        producerInt().stream().forEach(o->System.err.println(o));
    }

    private static void drawLine(){
        Function<Integer,String> funa = (i)->"-".repeat(i);
        System.out.println(funa.apply(50));
    }

    private static List<Integer> producerInt() {
        List<Integer> lia = new ArrayList<>();
        for(int i=1;i<=100;i++){
            lia.add(i+1);
        }
        return lia;
    }

    private static void stringStream() {

        // Two ways to create stream
        Stream stream =listProducer().stream();
        Stream streamOf = Stream.of(listProducer().toArray());
        // Two ways to create stream

        //reading Stream
        MyConsumer con = new MyConsumer();
        stream.forEach(con);
        listProducer().stream().forEach(new MyConsumer());


        Consumer<String> cona=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consuming in anonymous class "+s.toLowerCase());
            }
        };
        listProducer().stream().forEach(cona);

        listProducer().stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consuming in anonymous class "+s.toLowerCase());
            }
        });

        Consumer<String> conb=(s)->{
            System.out.println("Consuming in lambda "+s.toLowerCase());
        };
        listProducer().stream().forEach(conb);

        listProducer().stream().forEach((s)->{
            System.out.println("Consuming in lambda "+s);
        });

        listProducer().stream().forEach(s-> System.out.println("Consuming in lambda shorter "+s));

        listProducer().stream().forEach(System.out::println); //method reference

        streamOf.forEach(new MyConsumer());

        //reading Stream
    }

    private static List<String> listProducer() {
        List<String> lia = new ArrayList<>();
        for(int i=1;i<=10;i++){
            lia.add("Item "+(i+1));
        }
        return lia;
    }
}
