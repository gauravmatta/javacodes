package javaimplant.stringops;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StrSplit {

	public static void main(String[] args) {
		String lineFromCsvFile = "Mickey;Bolton;12345;121216";
		String[] dataCells = lineFromCsvFile.split(";");
		
		for(String data:dataCells)
		{
			System.out.println(data);
		}
		
		String lineFromInput = "What do you need from me?";
		String[] words = lineFromInput.split("\\s+");
		
		for(String word:words)
		{
			System.out.println(word);
		}
		
		String[] firstNames = "Mickey, Frank, Alicia, Tom".split(", ");
		
		for(String name:firstNames)
		{
			System.out.println(name);
		}
		
		// This returns an empty array
		String[] str="aaa.bbb".split(".");
		for(String st:str)
		{
			System.out.println(st);
		}
		
		
		String regex = Pattern.quote(".");
		str="aaa.bbb".split(regex);
		for(String st:str)
		{
			System.out.println(st);
		}
		
		String mystr = "the lazy fox jumped over the brown fence";
		StringTokenizer tokenizer = new StringTokenizer(mystr);
		while (tokenizer.hasMoreTokens()) 
		{
			System.out.println(tokenizer.nextToken());
		}
		
	}

}
