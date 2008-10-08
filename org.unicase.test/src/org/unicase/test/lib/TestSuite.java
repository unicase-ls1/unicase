package org.unicase.test.lib;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.test.tests.changetests.ChangeTest;

public abstract class TestSuite {

	List<TestCase> testcases;
	//private static Log logger = LogFactory.getLog(ChangeTest.class);
	

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest() {
		initialize();
		initTestCases();
		for (TestCase testCase : testcases) {
			//logger.info("Running " + testCase.getTestName() + " test...");
			System.out.println("Running " + testCase.getTestName() + " test...");
			testCase.runTest();
			
			compare(testCase.getTestName());
		}

		//end();		

	}

	
	public void initialize() {   };
	
	public void end() {   };
	
	public void compare(String testName) {  };



	public void initTestCases() {
	}

	
	public List<TestCase> getTestCases() {
		return testcases;
	}

	
//	public static Log getLogger() {
//		return logger;
//	}
}
