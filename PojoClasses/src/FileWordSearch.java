import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWordSearch 
{
   public static void main(String[] args) throws IOException 
   {
	//Creation of File Descriptor for input file
      File f1=new File("src\\resources\\4171_114.5HH_tube_0.745_5_0.twr"); 
      //Creation of File Reader object
      FileReader fr = new FileReader(f1); 
	//Creation of BufferedReader object 
      BufferedReader br = new BufferedReader(fr); 
        
	// Input word to be searched
      String input="File Written by SDM"; 
      String line;
     //Seaching Content from the file
      while((line=br.readLine())!=null)   
      {
         System.out.println("line");
         System.out.println(line);
         System.out.println("input");
         
         if(line.contains(input))
         {
        	 System.out.println("File Written by SDM found");
        	 break;
         }
         
//         if(line.indexOf("Your String"))
//         {
//              //Perform logic
//         }
//         
         
         
//         if (line.equals(input))   //Search for the given word
//         {
//           System.out.println("File Written by SDM found");
//           break;
//         }
      		
	}
      
         fr.close();
   }


}