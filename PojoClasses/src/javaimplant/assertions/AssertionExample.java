package javaimplant.assertions;

import java.util.Scanner;

public class AssertionExample {

	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your age");
		int value=scanner.nextInt();
		assert value>=18:"Not Valid";
		System.out.println("value is"+value);
		scanner.close();
	}
}
