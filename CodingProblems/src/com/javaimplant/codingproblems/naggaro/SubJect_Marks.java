/*
 * Given a list of N students, every student is marked for M subjects. Each student is denoted by an index 
 * value. Their teacher Ms. Margaret must ignore the marks of any 1 subject for every student. For this she 
 * decides to ignore the subject which has the lowest class average.Your task is to help her find that subject, 
 * calculate the total marks of each student in all the other subjects and then finally return the array of 
 * the total marks scored by each student.
 * Input Specification:
 * input1:
 * An integer value N denoting number of students
 * input2:
 * An integer value M denoting number of subjects
 * input3:
 * A 2-D integer array of size N'M containing the marks of all students in each subject.
 * Output Specification:
 * Return an integer array of size N containing the total marks of each student afte deducting the score for that one subject.
 */
package com.javaimplant.codingproblems.naggaro;

import java.util.Scanner;

public class SubJect_Marks {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();
		int avg[] = new int[row];
		int ans[] = new int[row];
		int arr[][] = new int[row][col];
		int res[] = new int[row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		/*
		 * //verifying i/p for(int i = 0; i <row; i++) { for(int j=0;j<col;j++) {
		 * System.out.print(arr[i][j]+" "); } System.out.println(""); }
		 */

		for (int i = 0; i < row; i++) { // calculating and storing average of each column
			for (int j = 0; j < row; j++) {
				ans[i] += arr[j][i];
			}
			avg[i] = ans[i] / row;

		}

		int min = avg[0];
		int eleminate_Index = 0;
		for (int i = 1; i < row; i++) { // minimum average calculated and ..
			if (avg[i] < min) {
				min = avg[i];
				eleminate_Index = i; // ..index of it stored.
			}
		}

		/*
		 * System.out.println(min); System.out.println(p);
		 */
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (eleminate_Index != j) {// calculating sum of remaining subjects
					res[i] += arr[i][j];
				}
			}

		}
		for (int j = 0; j < row; j++) {
			System.out.print(res[j] + " ");
		}

		sc.close();
	}
}