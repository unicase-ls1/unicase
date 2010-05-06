package org.unicase.test;

public abstract class TestCase {

	private String testName;

	public TestCase(String testName) {
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public abstract void runTest();

	public abstract void outputResults(boolean outputToFile);

}
