import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.javaimplant.junit.Calculator;

class CalTest {

	@Test
	public void calTest() {
		assertEquals("error in add()",3,Calculator.add(1,2));
		assertEquals("error in add()",-3,Calculator.add(-1,-2));
		assertEquals("error in add()",9,Calculator.add(9,0));
	}
	
	public void calTestFail()
	{
		assertEquals("error in add()",0,Calculator.add(1,2));
	}
	
	public void calTestSubPass()
	{
		assertEquals("error in sub()",1,Calculator.add(1,2));
		assertEquals("error in sub()",-1,Calculator.add(-1,-2));
		assertEquals("error in sub()",0,Calculator.add(9,0));
	}
	
	public void calTestSubFail()
	{
		assertEquals("error in add()",0,Calculator.add(2,1));
	}

}
