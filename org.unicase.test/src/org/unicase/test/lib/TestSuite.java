package org.unicase.test.lib;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.unicase.test.tests.changetests.randomchange.RandomChangeTestSuite.TestCases;


public abstract class TestSuite {

	List<TestCase> testcases;

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest(int numOfIterations, EnumSet<TestCases> testCases) {
		initTestSuite();
		initTestCases(testCases);
		
		for (int i = 0; i < numOfIterations; i++) {
			for (TestCase testCase : testcases) {
				System.out.println("========= Running TestCase: "
						+ testCase.getTestName() + " =========  " + i);
				testCase.runTest();
				endTestCase(testCase.getTestName());
			}
			endTestSuite();
		}
	}

	public void initTestSuite() {
	}

	public void endTestCase(String testName) {
	}

	public void endTestSuite() {
	}

	public void initTestCases(EnumSet<TestCases> testCases) {
	}

	public List<TestCase> getTestCases() {
		return testcases;
	}
}
