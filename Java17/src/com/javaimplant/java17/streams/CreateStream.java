package com.javaimplant.java17.streams;

import com.javaimplant.java17.streams.consumers.MyConsumer;

import java.util.ArrayList;
import java.util.List;
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
