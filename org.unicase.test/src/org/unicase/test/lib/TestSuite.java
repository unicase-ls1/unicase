package org.unicase.test.lib;

import java.util.ArrayList;
import java.util.List;


public abstract class TestSuite {

	private List<TestCase> testcases;
	private boolean manualTests;

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest(int numOfIterations) {
		initTestSuite();
		initTestCases();
		
		for (int i = 0; i < numOfIterations; i++) {
			for (TestCase testCase : testcases) {
				System.out.println();
				System.out.println("========= Running TestCase: "
						+ testCase.getTestName() + " =========  " + i);
				testCase.runTest();
				testCase.endTest();
			}
			endTestSuite();
		}
	}

	public void initTestSuite() {
	}

	public void endTestSuite() {
	}

	public void initTestCases() {
	}

	public List<TestCase> getTestCases() {
		return testcases;
	}

		
	
}
