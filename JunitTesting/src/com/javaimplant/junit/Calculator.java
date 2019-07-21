package com.javaimplant.junit;

public class Calculator {
	public static int add(int number1,int number2)
	{
		return number1+number2;
	}
	
	public static int sub(int number1,int number2)
	{
		return number1-number2;
	}
	
	public static int multiply(int number1,int number2)
	{
		return number1*number2;
	}
	
	public static double divide(double number1,double number2)
	{
		if(number2==0)
		{
			throw new IllegalArgumentException("Number can't be zero");
		}
		return number1/number2;
	}
}
