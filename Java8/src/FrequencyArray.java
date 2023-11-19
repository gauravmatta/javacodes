import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyArray {

	
	public static void main(String args[]) {
			List<Integer> list = Arrays.asList(1,2,2,6,7,8,4,3);
		
			//Using a Set
			Set<Integer> distict = new HashSet<>(list);
			System.out.println("Using a Set =================>");
			for(int i : distict) {
				System.out.println( i + ":" + Collections.frequency(list, i));
			}
			System.out.println("Using a Set =================>");
			//Using a Set
			
			//Using a Map
			Map<Integer, Integer> frequencyMap = new HashMap<>();
			for(int i: list) {
				Integer count = frequencyMap.get(i);
				if (count == null) {
					count = 0;
				}	
				frequencyMap.put(i, count + 1);
			}
			System.out.println("Using a Map =================>");
			for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			System.out.println("Using a Map =================>");
			//Using a Map
			
			//Using Streams
			Map<Integer, Long> streamFrequencyMap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
			for (Map.Entry<Integer,Long> entry: streamFrequencyMap.entrySet()) {
				System.out.println(entry.getKey() +": "+entry.getValue());
			}
			//Using Streams
	}
}
