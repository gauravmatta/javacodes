package javaimplant.argumentprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnMultipleArgs {

	public static void main(String[] args) {
		for(Double amt: getAmountDetails()) {
			System.out.println(amt);
		}
		for(Number amt: getNumberArray()) {
			System.out.println(amt);
		}
		getNumberList().stream().forEach(System.out::println);
		System.out.println(getMap().toString());
		
		System.out.println(getCustomObject());
	}
	
	public static Employee getCustomObject(){
		return new Employee("Gaurav","lop",34,50000);
	}
	
	public static Map<String,Number> getMap(){
		Map<String,Number> maps = new HashMap<>();
		maps.put("int_value",500);
		maps.put("double_value",100.56);
		return maps;
	}
	
	public static List<Number> getNumberList(){
		List<Number> numbers = new ArrayList<>();
		numbers.add(50.87);
		numbers.add(100.56);
		return numbers;
	}
	
	public static double[] getAmountDetails() {
		double[] amounts = new double[2];
		amounts[0]=50.87;
		amounts[1]=100.87;
		return amounts;
	}
	
	public static Number[] getNumberArray() {
		Number[] amounts = new Number[2];
		amounts[0]=50;
		amounts[1]=100.56;
		return amounts;
	}

}
