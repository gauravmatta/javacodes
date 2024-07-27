package javaimplant.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(4);
		nums.add(3);
		nums.add(7);
		nums.add(9);
		Collections.sort(nums);
		System.out.println(nums);
		List<Integer> nums2 = new ArrayList<>();
		nums2.add(43);
		nums2.add(31);
		nums2.add(72);
		nums2.add(29);
		List<Student> students = new ArrayList<>();
		students.add(new Student(21,"Navin"));
		students.add(new Student(12,"John"));
		students.add(new Student(18,"Parul"));
		students.add(new Student(20,"Kiran"));
		Collections.sort(students);
		System.out.println(students);
		
	}
}
