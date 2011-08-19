package org.unicase.test.tests.change;

import java.util.Random;

import org.unicase.metamodel.Project;
import org.unicase.projectgenerator.TestProjectParmeters;
import org.unicase.test.TestCase;
import org.unicase.workspace.ProjectSpace;

public abstract class ChangeTestCase extends TestCase {

	private Random rnd;
	private TestProjectParmeters testProjParams;
	private ProjectSpace testProjectSpace;

	public ChangeTestCase(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testName);
		this.testProjParams = testProjParams;
		this.testProjectSpace = testProjectSpace;
		rnd = new Random(testProjParams.getRandomSeed());

	}

	protected Random getRandom() {
		return rnd;
	}

	protected TestProjectParmeters getTestProjParams() {
		return testProjParams;
	}

	protected Project getTestProject() {
		return testProjectSpace.getProject();
	}

	protected ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}

	@Override
	public void outputResults(boolean outputToFile) {
		System.out.println("Done: " + getTestName());
	}

}
