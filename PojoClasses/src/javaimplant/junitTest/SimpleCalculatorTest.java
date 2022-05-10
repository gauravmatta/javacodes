package javaimplant.junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleCalculatorTest {

	@Test
	public void twoPlustwoShouldEqualFour() {
		SimpleCalculator calculator= new SimpleCalculator();
		assertEquals(4,calculator.add(2, 2));
	}
	
	@Test
	public void concatTest() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertEquals("HelloWorld", calculator.add("Hello", "World"));
	}

}
