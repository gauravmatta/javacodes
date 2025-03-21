package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        List<String> mylist = Arrays.asList("arm", "nose", "toe", "leg", "lip", "hand", "eye", "ear", "head");
        Stream<String> myStream = mylist.stream();
        String[] array = {"apple", "banana", "cherry"};
        Stream<String> arrayStream = Arrays.stream(array);
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 1).limit(100);
        Stream<Integer> generateStream = Stream.generate(() -> (int) (Math.random() * 100)).limit(5);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 4322, 9, 5, 44, 23, 433, 0, 1, 2);
        List<Integer> filteredList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .peek(System.out::println)
                .distinct()
                .sorted((a, b) -> (b - a))
                .limit(4)
                .skip(1)
                .toList();
        System.out.println(filteredList);

        List<Integer> collect = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .peek(System.out::println)
                .filter(x->x%2==0)
                .map(x->x/10)
                .distinct()
                .sorted()
                .toList();
        System.out.println(collect);

        Integer max = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .peek(System.out::println)
                .max((a,b)->a-b)
                .orElse(null);
        System.out.println(max);
        long count = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .count();
        System.out.println(count);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> parallelStream = list1.parallelStream();
    }


}
