/*For each element of an array, a counter is set to 0.
 * The element is compared to each element to its left.
* If the element to the left is greater, the absolute difference is subtracted
* from the counter. If the element to the left is less, the absolute difference is added to the
* counter. For each element of the array, determine the value of the counter. These values
* should be stored in an array and returned.
* e.g. input 1,2,2,3
* output 0,1,1,4
* input = 2,4,3
* output = 0,2,0
* input = 2,1,3
* output = 0,-1,3
*/
package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class AbsoluteLeftDifference {

	public static List<Long> arrayChallenge(List<Long> arr) {

		int len = arr.size();

		List<Long> ans = new ArrayList<>(len);

		for (int i = 0; i < len; i++) {

			ans.add(0L);

		}
		
		System.out.println(arr.toString());

		for (int i = 1; i < len; i++) {
			System.out.println(ans.get(i - 1)+" "+i+" "+arr.get(i - 1)+" "+arr.get(i));
			if (arr.get(i - 1) > arr.get(i)) {
				ans.set(i, ans.get(i - 1) - i * Math.abs(arr.get(i - 1) - arr.get(i)));
			} else if (arr.get(i - 1) < arr.get(i)) {
				ans.set(i, ans.get(i - 1) + i * Math.abs(arr.get(i - 1) - arr.get(i)));
			} else {
				ans.set(i, ans.get(i - 1));
			}
		}

		return ans;

	}
	
	public static List<Long> doubleLoop(List<Long> arr){
		System.out.println("Using Double Loop");
		int len = arr.size();
		List<Long> ans = new ArrayList<>(len);
		for (int i = 0; i < len; i++) {
			ans.add(0L);
		}
		for (int i=1;i<len;i++) {
			long sum=0;
			for(int j=0;j<i;j++) {
				long ele = arr.get(i) - arr.get(j);
				sum+=ele;
			}
			ans.set(i,sum);
		}
		return ans;
	}

	public static void main(String[] args) {

		List<Long> vec = List.of(2L, 1L, 3L, 4L, 7L, 1L);

		List<Long> ans = arrayChallenge(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}
		
		System.out.println();

		vec = List.of(2L, 4L, 3L);

		ans = arrayChallenge(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}
		
		System.out.println();

		vec = List.of(2L, 1L, 3L);

		ans = arrayChallenge(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}
		
		vec = List.of(2L, 1L, 3L, 4L, 7L, 1L);

		ans = doubleLoop(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}
		
		System.out.println();

		vec = List.of(2L, 4L, 3L);

		ans = doubleLoop(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}
		
		System.out.println();

		vec = List.of(2L, 1L, 3L);

		ans = doubleLoop(vec);

		for (Long value : ans) {

			System.out.print(value + " ");

		}

	}

}