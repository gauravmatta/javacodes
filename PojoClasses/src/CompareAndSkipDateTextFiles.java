import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareAndSkipDateTextFiles
{	
	public static void main(String[] args) throws IOException	{	
		BufferedReader reader1 = new BufferedReader(new FileReader("src\\resources\\4171_114.5HH_tube_0.745_5_0.twr"));		
		BufferedReader reader2 = new BufferedReader(new FileReader("src\\resources\\4171_114.5HH_tube_0.745_5_2.twr"));		
		String line1 = reader1.readLine();		
		String line2 = reader2.readLine();		
		boolean areEqual = true;
		boolean areMatcher = true;		
		int lineNum = 1;
		
	
		// date pattern
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
				
		while (line1 != null || line2 != null)
		{
			if(line1 == null || line2 == null)
			{
				areEqual = false;				
				break;
			}
									
			else if(! line1.equalsIgnoreCase(line2))
			{	
				
					areEqual = false;				
					break;
				
			}	
			Matcher matcher1 = pattern.matcher(line1);
			Matcher matcher2 = pattern.matcher(line2);				
			if(matcher1 != null || matcher2 != null)
			{		
				reader1.skip(lineNum);
				reader2.skip(lineNum);
				line1 = reader1.readLine();			
				line2 = reader2.readLine();			
				lineNum++;
				
			}
			
			
		}
		
		if(areEqual)
		{
			System.out.println("Two files have same content.");
		}
		else
		{
			System.out.println("Two files have different content. They differ at line "+lineNum);			
			System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
		}		
		reader1.close();		
		reader2.close();
	}
}