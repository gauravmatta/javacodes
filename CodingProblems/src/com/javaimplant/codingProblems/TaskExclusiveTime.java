/*
 * ALL When multiple tasks are executed on a single- threaded CPU, the tasks are scheduled based on the principle of pre-emption. 
 * When a higher- priority task arrives in the execution queue, then the lower-priority task is pre-empted, i.e. its execution is paused until
 * the higher-priority task is complete.
 * There are n functions to be executed on a single- threaded CPU, with each function having a unique ID between 0 and n- 1. Given an integer
 * n, representing the number of functions to be executed, and an execution log as an array of strings, logs, of size m, determine the 
 * exclusive times of each of the functions. Exclusive time is the sum of execution times for all calls to a function. Any string 
 * representing an execution log is of the form (function_id}:{"start"|"end"); (timestamp), indicating that the function with ID = 
 * function_id, either starts or ends at a time identified by the timestamp value. 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 
 * 38 39 40 41 42 43 44 45 46 47 Note: While calculating the execution time of a function call, both the starting and ending times of the 
 * function call have to be included. The log of the form (function_id):(start): (timestamp) means that the running function is preempted at 
 * the beginning of timestamp second.
 */
package com.javaimplant.codingProblems;

import java.util.Collections;
import java.util.List;

public class TaskExclusiveTime {
	
	List<Integer> getTotalExecutionTime(int n,List<String> logs){
		
		return Collections.emptyList()ull;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
