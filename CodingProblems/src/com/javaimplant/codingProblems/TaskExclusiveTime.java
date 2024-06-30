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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TaskExclusiveTime {
	
	static List<Integer> getTotalExecutionTime(int n,List<String> logs){
		int[] resultArray = new int[n] ;
		List<Integer> result = Arrays.stream(resultArray).boxed().collect(Collectors.toList());
		Stack<Integer> functionStack = new Stack<>();
		int prevTime =0;
		for(String log: logs) {
			String[] logParts = log.split(":");
			Integer functionid = Integer.valueOf(logParts[0]);
			String action = logParts[1];
			Integer timestamp = Integer.valueOf(logParts[2]);
			if(action.equals("start")) {
				if(!functionStack.empty()) {
					result.set(functionStack.peek(),result.get(functionStack.peek())+timestamp-prevTime);
				}
				functionStack.push(functionid);
				prevTime=timestamp;
			}else if(action.equals("end")) {
				result.set(functionStack.peek(),result.get(functionStack.peek())+timestamp-prevTime+1);
				functionStack.pop();
				prevTime=timestamp+1;
			}
		}		
		return result;
	}

	public static void main(String[] args) {
		int n=3;
		List<String> logs = new ArrayList<>() {{
			add("0:start:0");
			add("1:start:2");
			add("2:start:3");
			add("2:end:4");
			add("1:end:5");
			add("0:end:6");
		}};
		List<Integer> result =  getTotalExecutionTime(n,logs);
		result.forEach(a -> System.out.println(a));
	}
}
