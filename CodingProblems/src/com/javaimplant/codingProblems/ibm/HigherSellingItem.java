/*
Problem Statement:-
Your task is print these three things-
1. Higher selling item
2. Total selling price(up to 2 decimal places)
3. Average selling price(up to 2 decimal places)
sample test case:
Input
{["apple", 1.0, 5], 1*5 = 5
['orange", 10.0, 5], 10 * 5 = 50
["apple", 10.0, 5] 10 * 5 = 50
apple - 55
orange - 50
avg = total_price/no.item
avg = 105/3 = 35
output
apple
105.00
35.00
*/
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HigherSellingItem {	
	static void operations(List<String> products,List<Double> rates,List<Double> quantity) {
		double totalSell = 0;
		int frequency = 0;
		String higherSelling = null;
		int i=0;
		for(String p:products) {
			int f = Collections.frequency(products,p);
			if(f>frequency) {
				frequency=f;
				higherSelling=p;
			}
			totalSell+=rates.get(i)*quantity.get(i);
			
			i++;
		}
		double averagePrice = totalSell/products.size();
		System.out.println("Highest Selling Item is :" + higherSelling);
		System.out.println("Total Selling Price is :" + totalSell);
		System.out.println("Average Selling Price is :" + averagePrice);
	}
	
	
	public static void main(String[] args) {
		List<String> products = new ArrayList<>() {{
			add("apple");
			add("orange");
			add("apple");
		}};
		List<Double> rates = new ArrayList<>() {{
			add(5.0);
			add(5.0);
			add(5.0);
		}};
		
		List<Double> quantity = new ArrayList<>() {{
			add(1.0);
			add(10.0);
			add(10.0);
		}};
		operations(products,rates,quantity);
	}

}
