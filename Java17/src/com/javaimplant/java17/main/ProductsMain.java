package com.javaimplant.java17.main;

import com.javaimplant.java17.records.Products;
import com.javaimplant.java17.utils.ProductsUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductsMain {
    private static ProductsUtils pUtil=new ProductsUtils();
    public static void main(String[] args) {
        List<Products> lp=pUtil.retPList();
        Map<Integer, String> map=lp.stream().collect(Collectors.toMap(Products::id, Products::name));
		map.entrySet().forEach(System.out::println);
        drawLine();
		map.entrySet().iterator().forEachRemaining(n->{
			System.out.println(n.getKey()+" "+n.getValue());
		});
        drawLine();
		map.keySet().iterator().forEachRemaining(n->{
			System.out.println(n+" "+map.get(n));
		});
        drawLine();
		Arrays.asList(map.entrySet().toArray()).forEach(System.out::println);
        drawLine();
		var arr=map.keySet().toArray();
		Arrays.stream(arr).forEach(n->{
			System.out.println(n+" "+map.get(n));
		});
        drawLine();
		Arrays.asList(map.keySet().toArray()).listIterator().forEachRemaining(n->{
			System.out.println(n+" "+map.get(n));
		});
        drawLine();
        var aa= map.values().stream().toList();
        aa.forEach(System.out::println);
        drawLine();
        firstWay(lp);
        drawLine();
        secWay(lp);
        drawLine();
        thirdWay(lp);
        drawLine();
    }

    private static void thirdWay(List<Products> lp) {
        var totPriceB= (Integer) lp.stream().mapToInt(Products::ucost).sum();
        System.out.println("Total bill amount using sum is "+totPriceB+" ₹");
    }

    private static void secWay(List<Products> lp) {
        var totPriceB=lp.stream().collect(Collectors.summingInt(n->n.ucost()));
        System.out.println("Total bill amount assuming one item each is "+totPriceB+" ₹");
    }
    private static void firstWay(List<Products> lp) {
        var totPrice=lp.stream().map(n->n.ucost()).reduce(0,Integer::sum);
        System.out.println("Total bill amount is "+totPrice+"₹");
    }

    private static void drawLine() {
        System.out.println("*".repeat(50));
    }
}
