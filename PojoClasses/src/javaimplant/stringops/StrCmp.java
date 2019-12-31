package javaimplant.stringops;

import java.util.Locale;

public class StrCmp {

	public static void main(String[] args) {
	
		String firstString = "Taki";
		String secondString = "TAKI";
		System.out.println(firstString.equalsIgnoreCase(secondString)); //prints true
		Locale locale = Locale.forLanguageTag("tr-TR");
		//prints false beacuse in Turkish Taki is different from TAKI
		System.out.println(firstString.toLowerCase(locale).equals(secondString.toLowerCase(locale)));
		
		
		String stringToSwitch = "A";
		switch (stringToSwitch) {
		case "a":
		System.out.println("a");
		break;
		case "A":
		System.out.println("A"); //the code goes here
		break;
		case "B":
		System.out.println("B");
		break;
		default:
		break;
		}
		
		String strObj = new String("Hello");
		String str = "Hello";
		
		// The two string references point two strings that are equal
		if (strObj.equals(str)) 
		{
			System.out.println("The strings are equal");
		}
		
		// The two string references do not point to the same object
		if (strObj != str) 
		{
			System.out.println("The strings are not the same object");
		}
		
		// If we intern a string that is equal to a given literal, the result is
		// a string that has the same reference as the literal.
		String internedStr = strObj.intern();
		if (internedStr == str) 
		{
			System.out.println("The interned string and the literal are the same object");
		}
		
	}

}
