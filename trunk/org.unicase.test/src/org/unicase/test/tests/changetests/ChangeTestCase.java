package org.unicase.test.tests.changetests;

import java.util.Random;

import org.unicase.model.Project;
import org.unicase.test.lib.TestCase;

public class ChangeTestCase extends TestCase {

	private Random rnd;
	private Project testProject;
	
	public ChangeTestCase(String testName, long randomSeed) {
		super(testName);
		rnd = new Random(randomSeed);
		
	}

	@Override
	public void runTest() {
	}

	
	public Random getRandom() {
		return rnd;
	}

	public void setTestProject(Project testProject) {
		this.testProject = testProject;
	}

	public Project getTestProject() {
		return testProject;
	}


}
