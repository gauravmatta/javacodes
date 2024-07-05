/*
 * A Mars rover is directed to move within a square matrix. It accepts a sequence of commands to move in any of the four directions from each cell: [UP, DOWN, LEFT or RIGHT]. The rover starts from cell 0. and may not move diagonally or outside of the boundary.
Each cell in the matrix has a position equal to:
(row size) + column
where row and column are zero-indexed, size = row length of the matrix.
Return the final position of the rover after all
moves.
Example n=4
commands [RIGHT, UP, DOWN, LEFT, DOWN, DOWN]
 */
package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class Rover {
	public static int roverMove(int matrixSize, List<String> cmds) {
		int result = 0;
		for (int i = 0; i < cmds.size(); i++) {
		  result = process(cmds.get(i), matrixSize, result);
		}
		return result;
	}

	static int process(String cmd, int n, int current) {
		if (cmd.equals("DOWN")) {
			if (current < (n * n) - n) {
				current += n;
			}
		} else if (cmd.equals("UP")) {
			if (current >= n) {
				current -= n;
			}
		} else if (cmd.equals("RIGHT")) {
			if (((current + 1) % n) != 0) {
				current = current + 1;
			}
		} else if (cmd.equals("LEFT")) {
			if (current % n != 0) {
				current = current - 1;
			}
		}
		return current;
	}

	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("RIGHT");
		l.add("UP");
		l.add("DOWN");
		l.add("LEFT");
		l.add("DOWN");
		l.add("DOWN");
		int result = roverMove(4, l);
		System.out.println(result);
	}
}