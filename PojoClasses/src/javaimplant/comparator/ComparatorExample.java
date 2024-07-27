package javaimplant.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(3);
		nums.add(7);
		nums.add(9);
		Collections.sort(nums);
		System.out.println(nums);
		List<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(43);
		nums2.add(31);
		nums2.add(72);
		nums2.add(29);
		Comparator<Integer> com = (i,j)->{
			if(i%10>j%10) {
				return 1;
			} else {
			return -1;
			}
		};
		Collections.sort(nums2,com);
		System.out.println(nums2);
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(21,"Navin"));
		students.add(new Student(12,"John"));
		students.add(new Student(18,"Parul"));
		students.add(new Student(20,"Kiran"));
		System.out.println(students);
		Comparator<Student> ageComparator = (i,j)->{
			if(i.age>j.age) {
				return 1;
			}
			return -1;
		};
		Collections.sort(students,ageComparator);
		System.out.println(students);
	}
}
