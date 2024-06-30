/*
 *  1 A password string, pwd, consists of binary characters (Os and 1s). 
 *  A cyber security expert is trying to determine the minimum number of changes required to make the password secure. 
 *  To do so, it must be divided into substrings of non-overlapping, even length substrings. 
 *  Each substring can only contain 1s or Os, not a mix. 
 *  This helps to ensure that the password is strong and less vulnerable to hacking attacks. 
 *  Find the minimum number of characters that must be flipped in the password string, 
 *  i.e. changed from 0 to 1 or 1 to 0 to allow the string to be divided as described.
 *  
 *  
 *  Solution
 *  Step 1: Count the number of 0s and 1s in the password string. Given the password string, count the number of 0s and 1s.
 *  Step 2: Determine the parity of the total count of 0s and 1s.Check if the total count of 0s and 1s is even or odd.
 *  Step 3: Calculate the minimum number of changes required.
 *  If the parity is odd, the minimum number of changes required is the count of the less frequent character (either 0s or 1s).
 *  If the parity is even, the minimum number of changes required is the count of the less frequent character divided by 2.
 *  
 */
package com.javaimplant.codingProblems.ibm;

public class PasswordFlipper {
	
	static int minFlips(String pwd){
		int countFlips = 0;
		char[] pwdArr = pwd.toCharArray();
		for(int i=0;i<pwd.length()-1;i+=2) {
			if(pwdArr[i]!= pwdArr[i+1]) {
				countFlips++;
			}
		}
		return countFlips;
	}

	public static void main(String[] args) {
		String pwd = "101011";
		int result = minFlips(pwd);
		System.out.println(result);
		pwd = "100110";
		result = minFlips(pwd);
		System.out.println(result);
	}

}
