
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
	
	public static void main(String args[])
	{
		String myString="This is a maiden String"; //A reference to a new String is created
		String nullString=null;
		stringOps s1=new stringOps();
		s1.checkNull(nullString);
		String []players={"RG Sharma","S Dhawan","RR Pant","SK Raina","MK Pandey","KD Karthik","V Shankar","Washington Sundar","SN Thakur","JD Unadkat","YS Chahal"};
		s1.traceArray(players);
		String str1="Empty in String is represented as";
		s1.joinStrings(str1,nullString);
	}
}
