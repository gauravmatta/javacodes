/*
 * A small frog wants to get to the other side of the road. The frog is currently located at 
 * position X and wants to get to a position greater than or equal to Y. The small frog always 
 * jumps a fixed distance, D.Count the minimal number of jumps that the small frog must perform 
 * to reach its target.
 */
package com.javaimplant.codingproblems.nab;

public class FrogJmp {

public static int solution(int x,int y,int d) {
	int distance=y-x;
	return (int) Math.ceil(distance/(double)d);
}
	
public static void main(String[] args) {
	System.out.println(solution(10,85,30));
	System.out.println(solution(10,10,30));
}
}
