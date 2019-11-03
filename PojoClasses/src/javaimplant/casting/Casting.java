package javaimplant.casting;

import java.applet.Applet;
import java.util.Calendar;
import java.util.Date;

import firstapp.MyFirstApplet;

public class Casting {
	
	public static void main(String args[])
	{
		explicitCasting();	
		implicitCasting();
		testNumericPromotion();
		nonNumericPrimitiveCasting();
		objectCasting();
		checkInstance();
		checkInstanceOf();
	}
	
	static void checkInstanceOf()
	{
		System.out.println("Check Instance Of");
		Object obj = Calendar.getInstance();
		MyFirstApplet firstapplet=new MyFirstApplet();
		long time = 0;
		Date date=null;
		if(obj instanceof Calendar)
		{
			System.out.println("Date Output");
			date = ((Calendar)obj).getTime();
		}
		
		if(obj instanceof Date)
		{
			System.out.println("Time Output");
			time = ((Date)obj).getTime(); // This line will never be reached, obj is not a Date type.
		}
		System.out.println(date+"=>"+time);
		
		if(firstapplet instanceof Applet)
		{
			System.out.println("FirstApplet is instance of Applet");
		}
	}
	
	static void checkInstance()
	{
		System.out.println("Check Instance");
		Object obj = Calendar.getInstance();
		Date date;
		long time = 0;
		
		if(obj instanceof Calendar)
		{
			date = ((Calendar)obj).getTime();
			System.out.println(date);
		}
		
		if(obj instanceof Date)
		{
			time = ((Date)obj).getTime(); // This line will never be reached, obj is not a Date type.
			System.out.println(time);
		}
	}
	
	static void objectCasting()
	{
		System.out.println("Object Casting");
		Float floatVar = new Float(42.0f);
		Number n = floatVar; //Implicit (Float implements Number)
		Float floatVar2 = (Float) n; //Explicit
//		Double doubleVar = (Double) n; //Throws exception (the object is not Double)
		System.out.println(floatVar+"=>"+n+"=>"+floatVar2);
	}
	
	static void explicitCasting()
	{
		System.out.println("Explicit casting");
		double doubleVar = 42.0d;
		float floatVar = (float) doubleVar;
		long longVar = (long) floatVar;
		int intVar = (int) longVar;
		short shortVar = (short) intVar;
		byte byteVar = (byte) shortVar;
		System.out.println(doubleVar+"=>"+floatVar+"=>"+longVar+"=>"+intVar+"=>"+shortVar+"=>"+byteVar);
	}
	
	static void implicitCasting()
	{
		System.out.println("Implicit Casting");
		byte byteVar = 42;
		short shortVar = byteVar;
		int intVar = shortVar;
		long longVar = intVar;
		float floatVar = longVar;
		double doubleVar = floatVar;
		System.out.println(doubleVar+"=>"+floatVar+"=>"+longVar+"=>"+intVar+"=>"+shortVar+"=>"+byteVar);
	}
	
	static void nonNumericPrimitiveCasting()
	{
		System.out.println("Non Numeric Primitive Casting");
//		int badInt = (int) true; //Compiler error: incompatible types
		char char1 = (char) 65; // A
		byte byte1 = (byte) 'A'; // 65
		short short1 = (short) 'A'; // 65
		int int1 = (int) 'A'; // 65
		System.out.println(char1+"=>"+byte1+"=>"+short1+"=>"+int1);
		
		char char2 = (char) 8253;
		byte byte2 = (byte) char2; // 61 (truncated code-point into the ASCII range)
		short short2 = (short) char2; // 8253
		int int2 = (int) char2; // 8253
		System.out.println(char2+"=>"+byte2+"=>"+short2+"=>"+int2);
	}
	
	static void testNumericPromotion() 
	{
		System.out.println("Test Numeric Promotion");
		char char1 = 1, char2 = 2;
		short short1 = 1, short2 = 2;
		int int1 = 1, int2 = 2;
		float float1 = 1.0f, float2 = 2.0f;
//		 char1 = char1 + char2; // Error: Cannot convert from int to char;
//		 short1 = short1 + short2; // Error: Cannot convert from int to short;
		int1 = char1 + char2; // char is promoted to int.
		System.out.println(int1);
		int1 = short1 + short2; // short is promoted to int.
		System.out.println(int1);
		int1 = char1 + short2; // both char and short promoted to int.
		System.out.println(int1);
		float1 = short1 + float2; // short is promoted to float.
		System.out.println(float1);
		int1 = int1 + int2; // int is unchanged.
		System.out.println(int1);
	}
}