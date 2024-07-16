package javaimplant.argumentprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

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
		
		System.out.println(getPair());
		
		System.out.println(getTriple());
		
		System.out.println(getImmutablePair());
	}
	
	public static Triple<String, Integer, Employee> getTriple(){
		return Triple.of("Gaurav",123,new Employee("Gaurav","lop",34,50000));
	}
	
	public static Pair<Integer,String> getImmutablePair(){
		return ImmutablePair.of(130,"Test Data");
	} 
	
	public static Pair<Integer,String> getPair(){
		return Pair.of(130,"Test Data");
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
