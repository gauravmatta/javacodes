package java8.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatmapImpl {

	public static void main(String[] args) {
		List<Customer> cl = getAll();
		List<String> emails = cl.stream().map(Customer::getEmail).collect(Collectors.toList());
		System.out.println(emails);
		List<List<String>> phoneNumbers = cl.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
		System.out.println(phoneNumbers);
		List<String> phones= cl.stream().flatMap(cu->cu.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phones);
	}
	
	public static List<Customer> getAll(){
		return Stream.of(
				new Customer(101,"john","j@g.com",Arrays.asList("123","345")),
				new Customer(102,"kohn","k@g.com",Arrays.asList("346","765")),
				new Customer(103,"lohn","l@g.com",Arrays.asList("987","146")),
				new Customer(104,"mohn","m@g.com",Arrays.asList("567","888"))
				).collect(Collectors.toList());
	}

}
