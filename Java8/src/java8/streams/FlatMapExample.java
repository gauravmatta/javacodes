package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java8.entity.Pupil;

public class FlatMapExample {

	public static void main(String[] args) {
		List<Integer> immutableList = Arrays.asList(1,2,3,4,5,6);
		List<Integer> addList = immutableList.stream().map(n->n+10).collect(Collectors.toList());
		System.out.println(addList);
		List<Integer> tasksTimePool1 = Arrays.asList(10,20,30,40);
		List<Integer> tasksTimePool2 = Arrays.asList(15,25,35,45);
		List<Integer> tasksTimePool3 = Arrays.asList(5,10,15,20);
		List<Integer> tasksTimePool4 = Arrays.asList(4,8,12,16);
		List<List<Integer>> combinedList = Arrays.asList(tasksTimePool1,tasksTimePool2,tasksTimePool3,tasksTimePool4);
		List<Integer> flattenedList = combinedList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
		System.out.println(flattenedList);
		List<Integer> flattenedListUpdated = combinedList.stream().flatMap(x->x.stream()).map(n->n+10).collect(Collectors.toList());
		System.out.println(flattenedListUpdated);
		
		List<String> teamA = Arrays.asList("Scott","David","John");
		List<String> teamB = Arrays.asList("Mary","Luna","Tom");
		List<String> teamC = Arrays.asList("Ken","Jony","Kitty");
		List<List<String>> playersInWorldCup=Arrays.asList(teamA,teamB,teamC);
		playersInWorldCup.stream().flatMap(x->x.stream()).forEach(System.out::println);
		
		List<Pupil> pupilList1 = new ArrayList<Pupil>();
		pupilList1.add(new Pupil("Smith",101,'A'));
		pupilList1.add(new Pupil("John",102,'B'));
		pupilList1.add(new Pupil("Kenedy",103,'C'));
		List<Pupil> pupilList2 = new ArrayList<Pupil>();
		pupilList2.add(new Pupil("Scott",104,'A'));
		pupilList2.add(new Pupil("Mary",105,'B'));
		pupilList2.add(new Pupil("Kitty",106,'C'));
		
		List<List<Pupil>> allPupils = Arrays.asList(pupilList1,pupilList2);
		List<String> names = allPupils.stream().flatMap(x->x.stream()).map(s->s.getName()).collect(Collectors.toList());
		System.out.println(names);
	}
}
