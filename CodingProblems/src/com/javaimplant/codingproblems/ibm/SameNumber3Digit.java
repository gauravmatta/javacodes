/*You are given a string num representing a large integer.0 An integer is good if it meets the following 
 * conditions:
 * It is a substring of num with length 3.
 * It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 * Note:
 * A substring is a contiguous sequence of characters within a string.
 * There may be leading zeroes in num or a good integer.
 * Input: num = "6777133339"
 * Output: "777"
 * Explanation: There are two distinct good integers: "777" and "333".
 * "777" is the largest, so we return "777".
 * Input: num = "2300019"
 * Output: "000"
 * Explanation: "000" is the only good integer.
 * Input: num = "42352338"
 * Output: ""
 * Explanation: No substring of length 3 consists of only one unique digit.
 * Therefore, there are no good integers.
*/

package com.javaimplant.codingproblems.ibm;

public class SameNumber3Digit {
	class Solution {
	    public String largestGoodInteger(String num) {
	        for (int i = 9; i >= 0; i--) {
	            String s = String.valueOf(i).repeat(3);
	            if (num.contains(s)) {
	                return s;
	            }
	        }
	        return "";
	    }
	}
}
