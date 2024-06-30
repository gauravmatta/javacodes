/*
 * Given a list of n URLs visited as an array of strings, urls, 
 * determine the minimum time taken to resolve each DNS request. in Java
 * from a DNS server. 
 * Retrieving data from the cache is often faster than retrieving it from a DNS server.
 * This task aims to simulate DNS resolution and determine the time taken to process different URLs.
 * Assume that the DNS cache can store a maximum of the cache_size most recent DNS requests,i.e., URL-IP mappings. 
 * The cache is initially empty. it takes cache_time units of time to fetch data from the DNS cache, 
 * and server_time units of time to fetch data from the DNS server.
 * Given a list of n URLs visited as an array of strings. Uri, determine the minimum time taken to resolve each DNS request.
 * Note: New DNS requests are dynamically added to
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DomainNameSystem {

	static List<Integer> getMinTime(int cache_size,int cache_time,int server_time,List<String> urls){
		List<Integer> timetaken = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		for(String url:urls) {
			if(queue.contains(url)) {
				timetaken.add(cache_time);
			}else {
				if(queue.size()>=cache_size) {
					queue.poll();
				}
				timetaken.add(server_time);
				queue.add(url);
			}
		}
		return timetaken;		
	}
	
	public static void main(String[] args) {
		int cache_size=2;
		int cache_time=2;
		int server_time=3;
		
		List<String> urls = new ArrayList<>() {{
			add("google");
			add("yahoo");
			add("google");
			add("yahoo");
			add("courseera");
		}};
		
		List<Integer> result = getMinTime(cache_size,cache_time,server_time,urls);
		result.forEach(i->System.out.println(i));		
	}

}
