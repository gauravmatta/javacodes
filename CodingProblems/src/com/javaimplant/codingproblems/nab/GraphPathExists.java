/*
 * You are given an undirected graph consisting of N vertices, numbered from 1 to N, and M edges.
 * The graph is described by two arrays, A and B, both of length M. A pair (A[K], B[K]), for K 
 * from 0 to M-1, describes an edge between vertex A[K] and vertex B[K].Your task is to check 
 * whether the given graph contains a path from vertex 1 to vertex N going through all of the 
 * vertices, one by one, in increasing order of their numbers. All connections on the path should 
 * be direct.Write a function: that, given an integer N and two arrays A and B of M integers 
 * each, returns True if there exists a path from vertex 1 to N going through all vertices, one 
 * by one, in increasing order, or False otherwise.
 * Examples:
 * 1. Given N = 4, A = [1, 2, 4, 4, 3] and B = [2, 3, 1, 3, 1], the function should return True.
 * There is a path (1 → 2 → 3 → 4) using edges (1, 2), (2, 3) and (4,3).
 */

package com.javaimplant.codingproblems.nab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphPathExists {

	static int V;
	static ArrayList<ArrayList<Integer>> adj;

	public static boolean solution(int n, int[] a, int[] b) {
		V = a.length;
		adj = new ArrayList<>();
	    for(int i=0;i<V;i++)
	            adj.add(new ArrayList<>());
		for(int i=0;i<a.length;i++) {
			addEdge(a[i],b[i]);
		}
		return isReachable(1, n);
	}

	
	// A BFS based function to check whether d is reachable from s.
    static boolean isReachable(int s, int d)
    {
        // Base case
        if (s == d)
            return true;
 
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
 
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
 
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.remove();
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited  and enqueue it
            for (int i=0; i<adj.get(s).size();i++) {
 
                // If this adjacent node is the destination node,
                // then return true
                if (adj.get(s).get(i) == d)
                return true;
 
                // Else, continue to do BFS
                if (!visited[adj.get(s).get(i)]) {
                    visited[adj.get(s).get(i)] = true;
                    queue.add(adj.get(s).get(i));
                }
            }
        }
        // If BFS is complete without visiting d
        return false;
    }
	
	static void addEdge(int v, int w) {
		 adj.get(v).add(w);
	     adj.get(w).add(v);
	}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[] { 1, 2, 4, 4, 3 }, new int[] { 2, 3, 1, 3, 1 }));
	}

}
