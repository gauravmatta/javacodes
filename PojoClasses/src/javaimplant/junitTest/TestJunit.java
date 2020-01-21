package javaimplant.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestJunit {

	String message="Test String";
	MessageUtil msgutil = new MessageUtil(message);
	
	@Test
	public void printTestMessage()
	{
		assertEquals(message,msgutil.printMessage());
	}
	
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