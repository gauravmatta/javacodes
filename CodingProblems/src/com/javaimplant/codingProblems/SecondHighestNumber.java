package com.javaimplant.codingProblems;

public class SecondHighestNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int highest = Integer.MIN_VALUE + 1;
        int sec_highest = Integer.MIN_VALUE;
        for (int i : numbers) {
        	System.out.println(highest+"==>"+sec_highest);
            if (i > highest) {
                sec_highest = highest;
                highest = i;
            } else if (i > sec_highest && i != highest) {
                sec_highest = i;
            }
        }
        System.out.println("Second highest number is: " + sec_highest);
    }
}