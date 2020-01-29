package javaimplant.junitTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestJunit.class})
public class TestRunner {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestJunit.class);  
	      Result resultEmp = JUnitCore.runClasses(TestEmployeeDetails.class);
	      Result resultTestSuit = JUnitCore.runClasses(JunitTestSuite.class);
	      
	      Result resultParams = JUnitCore.runClasses(PrimeNumberCheckerTest.class);

	      for (Failure failure : resultParams.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	      
	      for (Failure failure : resultEmp.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
	      System.out.println(resultEmp.wasSuccessful());
	      
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());

	      for (Failure failure : resultTestSuit.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}