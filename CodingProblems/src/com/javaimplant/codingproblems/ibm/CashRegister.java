/*
 * There is a shop with old-style cash registers. the price of each item is typed manually. 
 * Given a list of items and their correct prices, compare the prices to those entered when each item 
 * was sold. Determine the number of errors in the selling price.
 * Input:
 * products = ['eggs','milk','cheese']
 * productPrices = [2.89,3.29,5.79]
 * productsSold = ['eggs','eggs','milk','cheese']
 * sellingPrices = [2.89,2.99,3.29,5.97]
 * Output: errors = 2
 */
package com.javaimplant.codingproblems.ibm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class CashRegister {
	
static int priceCheck(List<String> products,List<Double> productPrices,List<String> productSold,List<Double> soldPrice) {
	int error =0;
	Map<String,Double> priceMap = new HashMap<>();
	ListIterator<String> productIterator = products.listIterator();
	ListIterator<Double> productPricesIterator = productPrices.listIterator();
	ListIterator<String> productSoldIterator = productSold.listIterator();
	ListIterator<Double> soldPriceIterator = soldPrice.listIterator();
	while(productIterator.hasNext() && productPricesIterator.hasNext()) {
		priceMap.put(productIterator.next(),productPricesIterator.next());
	}
	while(productSoldIterator.hasNext() && soldPriceIterator.hasNext()) {
		String product = productSoldIterator.next();
		Double markedPrice = priceMap.get(product);
		Double sellingPrice = soldPriceIterator.next();
		if(priceMap.containsKey(product) && (markedPrice.floatValue() != sellingPrice.floatValue())) {
			error++;
		}
	}	
	return error;
}
	
public static void main(String args[]) {
	List<String> products = Arrays.asList("eggs","milk","cheese");
	List<Double> productPrices = Arrays.asList(2.89,3.29,5.79);
	List<String> productSold = Arrays.asList("eggs","eggs","cheese","milk");
	List<Double> soldPrice = Arrays.asList(2.89,2.99,5.97,3.29);
	int errors = priceCheck(products,productPrices,productSold,soldPrice);
	System.out.println(errors);
}
}
