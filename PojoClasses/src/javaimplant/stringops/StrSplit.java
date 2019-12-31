package javaimplant.stringops;

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
		
	}

}
