package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java8.entity.Product;

public class FilterExample {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add(10);
		numbersList.add(15);
		numbersList.add(20);
		numbersList.add(25);
		numbersList.add(30);
		
		List<Integer> immutableList = Arrays.asList(10,15,20,25,30);
		List<Integer> evenNumbersList = immutableList.stream().filter(n -> n%2==0).toList();
		System.out.println(evenNumbersList);
		immutableList.stream().filter(n -> n%2==0).forEach(System.out::println);
		
		List<String> names  = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");
		List<String> filteredNames = names.stream().filter(n -> n.length()>6 && n.length()<8).toList();
		System.out.println(filteredNames);
		names.stream().filter(n -> n.length()>6 && n.length()<8).forEach(System.out::println);
		
		List<String> words = Arrays.asList("cup",null,"forest","sky","book",null,"theatre");
		List<String> cleanList = words.stream().filter(w -> w!=null).toList();
		System.out.println(cleanList);
		
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product(1,"HP Laptop", 25000));
		productsList.add(new Product(2,"Dell Laptop", 30000));
		productsList.add(new Product(3,"Lenovo Laptop", 28000));
		productsList.add(new Product(4,"Sony Laptop", 23000));
		productsList.add(new Product(5,"Apple Laptop", 90000));
		
		productsList.stream()
				.filter(p->p.getPrice()>25000)
				.forEach(System.out::println);
		List<Product> filteredList = productsList.stream()
				.filter(p->p.getPrice()>25000).toList();
		System.out.println(filteredList);
	}

}
