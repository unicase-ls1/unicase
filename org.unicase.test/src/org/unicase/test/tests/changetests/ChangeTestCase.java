package org.unicase.test.tests.changetests;

import java.util.Random;

import org.unicase.model.Project;
import org.unicase.test.lib.TestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class ChangeTestCase extends TestCase {

	private Random rnd;
	private TestProjectParmeters testProjParams;
	private Project testProject;
	private ProjectSpace testProjectSpace;
	
	
	public ChangeTestCase(String testName, TestProjectParmeters testProjParams) {
		super(testName);
		this.testProjParams = testProjParams;
		rnd = new Random(testProjParams.getRandomSeed());
		
	}

	@Override
	public void runTest() {
	}

	
	public Random getRandom() {
		return rnd;
	}
	
	public TestProjectParmeters getTestProjParams() {
		return testProjParams;
	}


	public void setTestProject(Project testProject) {
		this.testProject = testProject;
	}

	public Project getTestProject() {
		return testProject;
	}

	
	
	public void setTestProjectSpace(ProjectSpace testProjectSpace) {
		this.testProjectSpace = testProjectSpace;
	}

	public ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}
	
	
	
	@Override
	public void endTestCase(boolean outputToFile) {
		System.out.println("Done: " + getTestName());
	}

	
	
}
