package javaimplant.stringops;

import java.util.Locale;

public class StrCmp {

	public static void main(String[] args) {
	
		String firstString = "Taki";
		String secondString = "TAKI";
		System.out.println(firstString.equalsIgnoreCase(secondString)); //prints true
		Locale locale = Locale.forLanguageTag("tr-TR");
		System.out.println(firstString.toLowerCase(locale).equals(secondString.toLowerCase(locale))); //prints false
		
		
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
		
	}

}
