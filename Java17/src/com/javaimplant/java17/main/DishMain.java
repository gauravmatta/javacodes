package com.javaimplant.java17.main;

import com.javaimplant.java17.models.DishWasher;
import com.javaimplant.java17.records.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DishMain {
    public static void main(String[] args) {
        dishwashTester();
        Function<Integer, String> drawLine= "*"::repeat;
        System.out.println(drawLine.apply(50));
        IntStream.rangeClosed(1, 20).forEach(DishMain::prnVal);
        System.out.println(drawLine.apply(50));
        IntStream.range(1, 100).forEach(DishMain::prnVal);
        //[) right open range,left open range (],closed range [], open range ()
        Integer sum = IntStream.rangeClosed(1, 100).parallel().sum();
        System.out.println(sum);
        Stream<Integer> stra=IntStream.rangeClosed(1, 100).boxed();
        System.out.println(DishWasher.retDList().stream().mapToInt(Dish::cals).average().getAsDouble());
        Double[] dd= {11.333333,43.444444,65.666666,76.77777,87.88888};
        DoubleStream ds= Arrays.asList(dd).stream().mapToDouble(n->n);
		System.out.println(ds.sum());
        DoubleStream dl= Arrays.stream(dd).mapToDouble(n->n);
        System.out.println(dl.summaryStatistics());
    }
    private static void dishwashTester() {
        List<Dish> ld= DishWasher.retDList();
        int cals=ld.stream().map(Dish::cals).reduce(0, Integer::sum);
        System.out.println(cals);
        IntStream intStream=ld.stream().mapToInt(Dish::cals);
        int calsa=intStream.sum();
        System.out.println(calsa);
        //Convert back to normal stream
        IntStream intStreamv1=ld.stream().mapToInt(Dish::cals);
		Stream<Integer> stra=intStreamv1.boxed();
        Supplier<Double> sup=()->Math.sqrt(2);
        System.out.println(sup.get());
    }

    private static void prnVal(int i) {
        System.out.println(i);
    }
}
