/*
 * There are n friends standing in a line, each numbered from 1 through n inclusive. 
 * The first one, friend 1, holds a baton. Each second, the baton is passed to the next friend in line.
 * Once it reaches the end of the line, the direction of passing is reversed and passing continues.
 * Determine who will pass and who will receive the baton at a given time.
 * Example
 * friends = 4
 * time = 5
 * Friends are numbered 1 through 4. Friend 1 holds the baton at time 0. At time 1, it is passed to 
 * friend 2. Over 5 seconds, the baton is passed as 1-2-3-4-3->2. The friend passing the baton at time 
 * 5 is friend 3. The friend receiving the baton is friend 2. Return [3, 2]
 * Function Description
 * Complete the function batonPass in the editor below. The function must return an integer array.
 * batonPass has the following parameters: int friends the number of friends write java code for this
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class BatonPass {
	
	static List<Integer> batonPass(int friends,long time){
		int cycleLength = (friends-1)*2;
		long effectiveTime = (time-1)%cycleLength+1;
		int position;
		if(effectiveTime<=friends) {
			position= (int)effectiveTime;
		} else {
			position = 2*friends-(int)effectiveTime;
		}
		int passer,receiver;
		if(effectiveTime <= friends) {
			passer = position;
			receiver = (position < friends)?position + 1:friends;
		} else {
			passer = position;
			receiver = (position>1)?position-1:1;
		}
		
		return new ArrayList<Integer>() {{
			add(passer);
			add(receiver);
		}};
	}

	public static void main(String[] args) {
		int friends = 4;
		long time =5;
		List<Integer> result = batonPass(friends,time);
		result.forEach(i->System.out.println(i));
	}

}
