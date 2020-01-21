package javaimplant.junitTest;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class TestJunit2 extends TestCase {
	
	protected double fValue1;
	protected double fValue2;
	   
	String message = "Robert";	
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Before
	protected void setUp() throws Exception {
		 fValue1 = 2.0;
	     fValue2 = 3.0;
	}

   @Test
   public void testAdd() 
   {
      //count the number of test cases
      System.out.println("No of Test Case = "+ this.countTestCases());
		
      //test getName 
      String name = this.getName();
      System.out.println("Test Case Name = "+ name);

      //test setName
      this.setName("testNewAdd");
      String newName = this.getName();
      System.out.println("Updated Test Case Name = "+ newName);
   }
		
   //tearDown used to close the connection or clean up activities
   public void tearDown(  ) 
   {
	   
   }

   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
}
