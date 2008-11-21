package org.unicase.test.lib;


public abstract class TestCase {
	
	private String testName;
	
	public TestCase(String testName){
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}
	
	
	abstract public void runTest();
	abstract public void endTestCase();
	
	
}
