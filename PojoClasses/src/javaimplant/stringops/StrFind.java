package javaimplant.stringops;

public class StrFind 
{
	public static void main(String args[])
	{
		String str1 = "Hello World";
		String str2 = "Hello";
		String str3 = "helLO";
		System.out.println(str1.contains(str2)); //prints true
		System.out.println(str1.contains(str3)); //prints false
		String s = "this is a long sentence";
		int i = s.indexOf('i'); // the first 'i' in String is at index 2
		int j = s.indexOf("long"); // the index of the first occurrence of "long" in s is 10
		int k = s.indexOf('z'); // k is -1 because 'z' was not found in String s
		int h = s.indexOf("LoNg"); // h is -1 because "LoNg" was not found in String s
		
		String a = "alpha";
		String b = "alpha";
		String c = new String("alpha");
		//All three strings are equivalent
		System.out.println(a.equals(b) && b.equals(c));
		//Although only a and b reference the same heap object
		System.out.println(a == b);
		System.out.println(a != c);
		System.out.println(b != c);		
	}
}
