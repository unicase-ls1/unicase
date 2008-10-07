package org.unicase.test.lib;

import java.util.ArrayList;
import java.util.List;

public abstract class TestSuite {

	List<TestCase> testcases;

	public TestSuite() {
		testcases = new ArrayList<TestCase>();
	}

	public void runTest() {
		initialize();
		initTestCases();
		for (TestCase testCase : testcases) {
			testCase.runTest();
		}
		end();
	}

	public void initialize() {
	}

	public void initTestCases() {
	}

	public void end() {
	}

	public List<TestCase> getTestCases() {
		return testcases;
	}
}
