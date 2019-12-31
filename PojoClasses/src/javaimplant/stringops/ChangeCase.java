package javaimplant.stringops;

import java.util.Scanner;

public class ChangeCase {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = scanner.next();
		char[] a = s.toCharArray();
		System.out.println("Enter the character you are looking for");
		System.out.println(s);
		String c = scanner.next();
		char d = c.charAt(0);
		for (int i = 0; i < s.length(); i++) 
		{
			if(a[i] == d) 
			{
				if (a[i] >= 'a' && a[i] <= 'z') 
				{
					a[i] -= 32;
				} 
				else if (a[i] >= 'A' && a[i] <= 'Z') 
				{
					a[i] += 32;
				}
//				a[i] = d;
//				break;
			}
		}
		s = String.valueOf(a);
		System.out.println(s);
		
		String string="The Quick Brown Fox Jumps Over The Lazy Dog";
		String upper = string.toUpperCase();
		String lower = string.toLowerCase();
		System.out.println(string); // prints "This is a Random String"
		System.out.println(lower); // prints "this is a random string"
		System.out.println(upper); // prints "THIS IS A RANDOM STRING"
	}

}
