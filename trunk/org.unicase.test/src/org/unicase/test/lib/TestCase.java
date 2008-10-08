package org.unicase.test.lib;

import java.util.Random;

import org.unicase.model.Project;

public abstract class TestCase {
	
	private Project testProject;
	private String testName;
	private Random rnd;
	
	abstract public void runTest();
	
	public TestCase(String testName, int randomSeed){
		this.testName = testName;
		rnd = new Random(randomSeed);
	}

	public void setTestProject(Project testProject) {
		this.testProject = testProject;
	}

	public Project getTestProject() {
		return testProject;
	}

	
	public String getTestName() {
		return testName;
	}

	

	public Random getRandom() {
		return rnd;
	}

}
