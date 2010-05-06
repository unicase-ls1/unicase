package org.unicase.test;

import java.util.ArrayList;
import java.util.List;

public abstract class TestSuite {

	private List<TestCase> testcases;

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest(int numOfIterations) {
		initTestSuite();
		initTestCases();

		for (int i = 0; i < numOfIterations; i++) {
			for (TestCase testCase : testcases) {
				System.out.println();
				System.out.println("========= Running TestCase: " + testCase.getTestName() + " =========  " + i);
				testCase.runTest();
				testCase.outputResults(false);
			}
			endTestSuite();

		}
	}

	protected abstract void initTestSuite();

	protected abstract void endTestSuite();

	protected abstract void initTestCases();

	protected List<TestCase> getTestCases() {
		return testcases;
	}

}
