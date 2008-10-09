package org.unicase.test.tests.changetests.randomChnge;

import java.util.Random;

import org.unicase.model.Project;
import org.unicase.test.lib.TestCase;

public class RandomChangeTestCase extends TestCase {

	private Random rnd;
	private Project testProject;
	
	public RandomChangeTestCase(String testName, long randomSeed) {
		super(testName);
		rnd = new Random(randomSeed);
		
	}

	@Override
	public void runTest() {
		// TODO Auto-generated method stub

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
