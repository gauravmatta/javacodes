/*
 * Given an array of N request ids and a positive integer K. 
 * After all requests are recieved, find the k most recent requests.
 * Report the answer in order of most recent to least recent.
 * If there is a duplicate request skip it and get next distinct one.
 * Suppose n=5 and requests are i1,i2,i3,i1,i3 and K =3
 * Then response should be i3,i1,i2
 */
		
package com.javaimplant.codingProblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class RecentRequests {

	static Set<String> getLatestKRequest(List<String> requests,int k) {
		Set<String> s = new LinkedHashSet<>();
//		System.out.println(requests.toString());
//		reverseList(requests);
//		Collections.reverse(requests);
//		System.out.println(requests.toString());
		ListIterator<String> listIterator = requests.listIterator(requests.size());
		while(s.size()<=k && listIterator.hasPrevious()) {
//			System.out.println(listIterator.previous());
			s.add(listIterator.previous());
//			System.out.println(s.toString());
		}
		return s;
	}
	
	public static <T> void reverseList(List<T> list)
    {
        // base condition when the list size is 0 
        if (list.size() <= 1 || list == null)
            return;
 
       
        T value = list.remove(0);
       
        // call the recursive function to reverse 
        // the list after removing the first element 
        reverseList(list);
 
        // now after the rest of the list has been 
        // reversed by the upper recursive call, 
        // add the first value at the end
        list.add(value);
    }
	
	public static void main(String[] args) {
		List<String> requests = Arrays.asList("item1","item2","item3","item1","item3");
//		List<String> requests = new ArrayList<>() {{
//			add("item1");
//			add("item2");
//			add("item3");
//			add("item1");
//			add("item3");
//		}};
		int k =3;
		Set<String> response = getLatestKRequest(requests,k);
		response.forEach(l -> System.out.println(l));

	}

}
