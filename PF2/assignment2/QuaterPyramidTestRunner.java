package assignment2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Run each of the Test suite classes
 * Display result for when all cases return true
 * or fail message: false when failed 
 * */
public class QuaterPyramidTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(QuaterPyramidTestSuite.class);

	    for(Failure failure : result.getFailures()) {
		   	System.out.println(failure.toString());
		}
				
		System.out.println(result.wasSuccessful());
	}
}
