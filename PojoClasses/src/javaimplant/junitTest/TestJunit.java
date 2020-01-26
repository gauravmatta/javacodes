package javaimplant.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

@Ignore
public class TestJunit {

	String message="Test String";
	MessageUtil msgutil = new MessageUtil(message);
	
	@Ignore
	@Test
	public void printTestMessage()
	{
		System.out.println("Inside testPrintMessage()");
		assertEquals(message,msgutil.printMessage());
	}
	
	@Test
	public void testSalutationMessage() 
	{
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Robert";
	      msgutil = new MessageUtil("Robert");
	      assertEquals(message,msgutil.salutationMessage());
	}
	
	@Ignore
	@Test
	public void failTestMessage()
	{
		message="Hello World";
		assertEquals(message,msgutil.printMessage());
	}
	
	@Test
	public void testAdd() 
	{
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
	}
}