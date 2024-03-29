package javaimplant.junitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestResult;
import junit.framework.TestSuite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
 TestJunit1.class ,TestJunit2.class, SimpleCalculatorTest.class
})

public class JunitTestSuite {
	public static void main(String[] a) {
	      // add the test's in the suite
	      TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class );
	      TestResult result = new TestResult();
	      suite.run(result);
	      System.out.println("Number of test cases = " + result.runCount());
	   }
}
