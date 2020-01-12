package javaimplant.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestJunit {
		
		@Test
	   public void testAdd() {
	      String str = "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	   }
}