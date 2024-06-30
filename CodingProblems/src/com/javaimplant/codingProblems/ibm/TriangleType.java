/*
 * In the assembly line, the factory assembles three parts ' a ' ' b ' ' c ' of a triangle toy. A
 * valid toy is one where the three sides can connect at their endpoints.
 * There are two forms of valid triangles to identify.
 * If 2 parts are of equal length, the form is 'Isosceles'
 * If all 3 parts are of equal length, the form is 'Equilateral'
 * If a toy is not valid or is not one of those 2 forms, it is 'None of these'.
 * 
 * Example
 * 
 * triangleToy=['2 2 1','3 3 3','3 4 5','1 1 3']
 * The first triangle is valid and has 2 equal parts, so the form is 'Isosceles'
 * The second is valid and has 3 equal parts, so the form is 'Equilateral'
 * The third is valid but not one of the two specific forms.
 * The fourth is not valid.
 * The result is ["Isosceles", "Equilateral", "None of these", "None of these"]
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleType {
	
	private static String[] split;

	public static List<String> triangleType(List<String> arr) {
	List<String> result =	arr.stream().map(a->{
		split = a.split(" ");
		if(split.length !=3) {
			return "None of These";
		}
		else if((Integer.valueOf(split[0]) == Integer.valueOf(split[1])) && (Integer.valueOf(split[1]) == Integer.valueOf(split[2]))) {
			return "Equilateral";
		}
		else if((Integer.valueOf(split[0]) == Integer.valueOf(split[1])) && (Integer.valueOf(split[2])<(Integer.valueOf(split[0]) + Integer.valueOf(split[1])))){
			return "Isosceles";
		}
		else if((Integer.valueOf(split[1]) == Integer.valueOf(split[2])) && (Integer.valueOf(split[0])<(Integer.valueOf(split[1]) + Integer.valueOf(split[2])))) {
			return "Isosceles";
		}
		else if((Integer.valueOf(split[0]) == Integer.valueOf(split[2])) && (Integer.valueOf(split[1])<(Integer.valueOf(split[0]) + Integer.valueOf(split[2])))) {
			return "Isosceles";
		}
		else {
			return "None of These";
		}
		}).collect(Collectors.toList());
		return result;
	}

	public static void main(String[] args) {
		List<String> str = new ArrayList<>() {{
			  add("2 2 1");
              add("3 3 3");
              add("3 4 5");
              add("1 1 3");
		}};
		List<String> result = triangleType(str);
		result.forEach(r -> System.out.println(r));
	}

}
