package java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one","two","three","four","five","six","seven","ten","twenty","three");
		List<String> len3List = list.stream().filter(s->s.length()>3).collect(Collectors.toList());
		System.out.println(len3List);
		Set<String> len4List = list.stream().filter(s->s.length()>4).collect(Collectors.toSet());
		System.out.println(len4List);
		Map<String, Integer> lengthMap = list.stream().filter(s->s.length()>4).distinct().collect(Collectors.toMap(Function.identity(),String::length));
		System.out.println(lengthMap);
		Map<Integer, String> lengthAsKey = list.stream().distinct().collect(Collectors.toMap(String::length,e->e,(oldvalue,newvalue)->oldvalue+" "+newvalue));
		System.out.println(lengthAsKey);
		TreeSet<String> numberTreeSet = list.stream().collect(Collectors.toCollection(()->new TreeSet<>()));
		System.out.println(numberTreeSet);
		Long count = list.stream().collect(Collectors.counting());
		System.out.println(count);
		String joinedStream1 = list.stream().collect(Collectors.joining());
		System.out.println(joinedStream1);
		String joinedStream2 = list.stream().collect(Collectors.joining("_"));
		System.out.println(joinedStream2);
		String joinedStream3 = list.stream().collect(Collectors.joining(",","<",">"));
		System.out.println(joinedStream3);
		
		int[] arr = {1,2,3,4,5,6};
		IntSummaryStatistics collect = Arrays.stream(arr).boxed().collect(Collectors.summarizingInt(no->no));
		System.out.println(collect.getMin()+"==>"+collect.getMax()+"==>"+collect.getCount()+"==>"+collect.getSum()+"==>"+collect.getAverage());
	}
}
