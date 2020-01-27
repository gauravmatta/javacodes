package javaimplant.junitTest;

import static org.junit.Assert.assertEquals;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class TestJunit {

	String message="Test String";
	MessageUtil msgutil = new MessageUtil(message);
	
	
	@Test
	public void printTestMessage()
	{
		System.out.println("Inside testPrintMessage()");
		assertEquals(message,msgutil.printMessage());
	}
	
	@Test
	public void checkTime()
	{
		assertTimeout(ofMillis(1000), () -> {
	        //Thread.sleep(100);
			msgutil.printMessage();
	    });
	}
	
	@Ignore
	@Test
	public void testSalutationMessage() 
	{
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Robert";
	      msgutil = new MessageUtil("Robert");
	      assertEquals(message,msgutil.salutationMessage());
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