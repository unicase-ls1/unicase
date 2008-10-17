package org.unicase.test.lib;


public abstract class TestCase {
	
	private String testName;
	
	public TestCase(String testName){
		this.testName = testName;
	}

	abstract public void runTest();
	
	public String getTestName() {
		return testName;
	}
}
