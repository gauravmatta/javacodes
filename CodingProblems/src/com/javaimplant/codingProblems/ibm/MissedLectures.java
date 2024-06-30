/*
 * A new Chemistry teacher is very strict and wants the students to do well in class. To aid this, 
 * lectures on each chapter will be repeated periodically through the semester. In each class, the next
 * chapter is presented. When they reach the end of the book, the lectures start over with chapter 0. 
 * More formally, if there are numChapters in the book, then on the ith day, the lecture will be 
 * on chapter i%numChapters. The first day of class is class[0], and the first chapter is chapter 0. If there are 3
 * chapters, daily lectures are on chapters class = [0, 1, 2, 0, 1, 2, ...]. At class[4], the lecture will be on 
 * chapter 4%3 = 1. One of the students is going to be out of class for a wedding, and the teacher is concerned 
 * about missed lectures. Given the first and last days the student will be out, determine the number of chapters 
 * for which the student will miss lectures. For example, there are numChapters = 4 chapters in the book. The 
 * student is out of class beginning on day b = 3 through ending day e = 5. The series of lectures are on chapters 
 * class = [0, 1, 2, 3, 0, 1, 2, 3,...] starting from day 0. For class[3] through class[5], lectures are given on 
 * chapters 3, 0 and 1. The student will miss lectures on 3 chapters. Function Description Complete the function 
 * missedLectures in the editor below. The function must return an integer. missed Lectures has the following 
 * parameters: numChapters: an integer b: an integer e: an integer
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class MissedLectures {

	static int missedLectures(int numChapters,int b,int e) {
		List<Integer> classes= new  ArrayList<>();
		int noOfLectures = numChapters*(e-1);
		for(int i=0;i<noOfLectures;i++) {
			classes.add(i%numChapters);
		}
		List<Integer> rangeClasses = new ArrayList<>(classes.subList(b, e+1));
		long missedCount = rangeClasses.stream().distinct().count();
		
		return (int) missedCount;
	}
	
	public static void main(String args[]) {
		int numChapters = 4;
		int b=3;
		int e=5;
		
		int missed = missedLectures(numChapters, b, e);
		System.out.println(missed);
		
		numChapters = 5;
		b=13;
		e=98;
		missed = missedLectures(numChapters, b, e);
		System.out.println(missed);
	}
}
