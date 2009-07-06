package org.unicase.test.lib;

import java.util.ArrayList;
import java.util.List;


public abstract class TestSuite {

	List<TestCase> testcases;

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest() {
		initTestSuite();
		initTestCases();
		for (TestCase testCase : testcases) {
			System.out.println("Running TestCase: " + testCase.getTestName());
			testCase.runTest();
			endTestCase(testCase.getTestName());
		}
		endTestSuite();
	}

	public void initTestSuite() {
	}

	public void endTestCase(String testName) {
	}

	public void endTestSuite() {
	}

	public void initTestCases() {
	}

	public List<TestCase> getTestCases() {
		return testcases;
	}
}
