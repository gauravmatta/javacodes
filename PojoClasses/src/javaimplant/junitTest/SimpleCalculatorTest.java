package javaimplant.junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleCalculatorTest {

	@Test
	public void twoPlustwoShouldEqualFour() {
		SimpleCalculator calculator= new SimpleCalculator();
		assertEquals(4,calculator.add(2, 2));
		assertNotEquals(5,calculator.add(1, 1));
		assertTrue(calculator.equals(calculator));
	}
	
	@Test
	public void threePlusSevenEqualsTen() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertEquals(10,calculator.add(3, 7));
	}
	
	@Test
	public void concatTest() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertEquals("HelloWorld", calculator.add("Hello", "World"));
	}

}
