
public class stringOps 
{
	public void checkNull(String str)
	{
		if(str==null)
		{
			System.out.println("This has no reference");
		}
	}
	
	public void traceArray(String[] arr)
	{
		System.out.println("Players in Team are : ");
		for(String str:arr)
		{
			System.out.println(str);
		}
	}
	
	public void joinStrings(String str1,String str2)
	{
		System.out.println(str1+" "+str2);
	}
	
	public void compareStrings(String str1,String str2)
	{
		if(str1==str2)
		{
			System.out.println("Both Strings are same and belong to same object");
		}
		else
		{
			if(str1.equals(str2)) 
			{
				System.out.println("Both Strings are same but belong to different objects");
			}
			else
			{
				System.out.println("Both Strings are different");
			}
		}
	}
	
	public int checkCharacterOccurance(String str,char c)
	{
		int aIndex=-1;
		int count=0;
		while((aIndex=str.indexOf(c,++aIndex))>-1)
		{
			++count;
		}
		return count;
	}
	
	public static void main(String args[])
	{
		String myString="This is a maiden String"; //A reference to a new String is created
		String nullString=null;
		stringOps s1=new stringOps();
		s1.checkNull(nullString);
		
		//Array of Strings
		String []players={"RG Sharma","S Dhawan","RR Pant","SK Raina","MK Pandey","KD Karthik","V Shankar","Washington Sundar","SN Thakur","JD Unadkat","YS Chahal"};
		s1.traceArray(players);
		String str1="Empty in String is represented as";
		
		// Null String
		s1.joinStrings(str1,nullString);
		String myString1="This is a maiden String"; //A reference to a new String is created
		String myString2="This is a maiden String copy";
		String myString3=myString2.substring(0,23);
		
		// compare Strings
		s1.compareStrings(myString, myString1);
		s1.compareStrings(myString, myString2);
		s1.compareStrings(myString, myString3);
		
		// Intern Example
		myString3=myString3.intern();
		s1.compareStrings(myString, myString3);
		
		//Starts With
		if(myString.startsWith("An"))
		{
			System.out.println("Second letter starts with a vowel");
		}
		else
		{
			System.out.println("Second letter does not start with a vowel");
		}
		
		//Ends With
		if(myString2.endsWith("copy"))
		{
			System.out.println("Ends With Copy");
		}
		
		//character At 
		int pos=3;
		char ch=myString1.charAt(pos);
		System.out.println("Character at position "+pos+" is "+ch);
		
		//Index of
		ch='s';
		pos=myString1.indexOf(ch);
		int lpos=myString1.lastIndexOf(ch);
		System.out.println("Position of "+ch+" is "+pos);
		System.out.println("Last Position of "+ch+" is "+lpos);
		
		//check Character Occurance
		int inl=s1.checkCharacterOccurance(myString,'i');
		System.out.println("Occurance of character is "+inl);
		
		//Substring
		String name="Java Implant";
		String substr1=name.substring(5);
		System.out.println(substr1);
		String substr=myString.substring(10,16);
		System.out.println(substr);
		
		//Tokenizing a String
		String [] nameArr=name.split(" ");
		for(String str:nameArr)
		{
			System.out.println(str);
		}
		nameArr=myString.split(" ",3);
		for(String str:nameArr)
		{
			System.out.println(str);
		}
		
		//Replacing characters
		String text="There are a boy";
		System.out.println(text);
		text=text.replace("are","is");
		System.out.println(text);
		
		//Trim
		String text1="    These whitespaces in a sentence needs to be removed     ";
		System.out.println(text1);
		text1=text1.trim();
		System.out.println(text1);
		
		//Character Array
		char [] textArray=new char[30];
		textArray=text1.toCharArray();
		for(char ch1:textArray)
		{
			System.out.println(ch1);
		}
		System.out.println("=================>");
		char [] textArray1=new char[12];
		text1.getChars(6,17,textArray1,0);
		for(char ch1:textArray1)
		{
			System.out.println(ch1);
		}
		
		//String from array of chars
		String halfString=new String(textArray1);	
		System.out.println(halfString);
		
		//Array of Bytes from String
		byte[] byteArray=halfString.getBytes();
		for(byte b1:byteArray)
		{
			System.out.println(b1);
		}
		
		//StringBuffer
		StringBuffer buffStr=new StringBuffer("Golden Eggs");
		int len=buffStr.length();
		int cap=buffStr.capacity();
		System.out.println(len+" is length amd capacity is adding 16 to it i.e. "+cap);
		
		//Increasing length of StringBuffer.
		buffStr.setLength(40);
		len=buffStr.length();
		cap=buffStr.capacity();
		System.out.println(len+" is length amd capacity is adding 16 to it i.e. "+cap);
		
	}
}