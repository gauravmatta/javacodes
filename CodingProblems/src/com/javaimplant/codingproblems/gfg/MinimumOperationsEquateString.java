/*
Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character
*/
		
package com.javaimplant.codingproblems.gfg;

import java.io.IOException;

class MinimumOperationsEquateString {
  public static void main(String[] args) throws IOException {
          String s="geek";
          String t="gesek";
          Solution ob = new Solution();
          int ans = ob.editDistance(s, t);
          System.out.println(ans);
          String s1 = "AGGTAB";
          String s2 = "GXTXAYB";
          ans = ob.editDistance(s1, s2);
          System.out.println(ans);
      }
  }

//} Driver Code Ends
class Solution {

	int lcs(char[] x, char[] y, int m, int n)
	{
	    if (m == 0 || n == 0)
	        return 0;
	    if (x[m - 1] == y[n - 1])
	        return 1 + lcs(x, y, m - 1, n - 1);
	    else
	        return max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
	}

	int max(int a, int b)
	{
	    return (a > b) ? a : b;
	}
	
	
  public int editDistance(String str1, String str2) {
      int result =0;
      char[] x = str1.toCharArray();
      char[] y = str2.toCharArray();
      int m = x.length;
      int n = y.length;
      System.out.println("Length of LCS is"
                         + " " + lcs(x, y, m, n));
      result = m+n-2*lcs(x, y, m, n);
      return result;
  }
}
