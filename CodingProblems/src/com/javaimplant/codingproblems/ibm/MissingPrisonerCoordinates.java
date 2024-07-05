/*
 * Prisoners are standing on a Cartesian coordinate system present inside a jail. Each prisoner stands 
 * at a unique point with both the coordinates (x,y) being integers. Each prisoner should be at a 
 * position that forms a rectangle or square with 3 other prisoners. 1 More formally, every prisoner at
 * a coordinates pair [x, y] should have: 
 * ⚫ at least one prisoner standing at integer coordinates (x, ay] where ay != y. 
 * ⚫ at least one prisoner standing at integer coordinates [bx, y] where bx != x 
 * Unfortunately, one prisoner has escaped. Find the coordinates of that prisoner. 
 * write the code in Java
 */
package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingPrisonerCoordinates {

	static List<Integer> missingPrisoner(List<List<Integer>> map){
		Set<Integer> x_coords = new HashSet<>();
		Set<Integer> y_coords = new HashSet<>();
		for(List<Integer> val:map){
		x_coords.add(val.get(0));
		y_coords.add(val.get(1));
		}
		
		int missing_x =0;
		for(int x : x_coords) {
			int count = 0;
			for(List<Integer> val:map){
				if(val.get(0)==x) {
					count++;
				}
			}
			if(count==1) {
				missing_x=x;
				break;
			}
		}
		
		int missing_y =0;
		for(int y : y_coords) {
			int count = 0;
			for(List<Integer> val:map){
				if(val.get(1)==y) {
					count++;
				}
			}
			if(count==1) {
				missing_y=y;
				break;
			}
		}
		List<Integer> result = new ArrayList<>();
		result.add(missing_x);
		result.add(missing_y);
		return result;
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> map =  new ArrayList<>();
		map.add(Arrays.asList(1, 1));
	    map.add(Arrays.asList(1, 2));
	    map.add(Arrays.asList(2, 1));
	    map.add(Arrays.asList(4, 4));
	    map.add(Arrays.asList(4, 6));
	    map.add(Arrays.asList(9, 4));
	    map.add(Arrays.asList(9, 6));
	    List<Integer> result = missingPrisoner(map);
	    result.forEach(i -> System.out.print(i+","));
	}
}
