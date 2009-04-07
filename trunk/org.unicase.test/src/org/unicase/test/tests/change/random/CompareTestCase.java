package org.unicase.test.tests.change.random;

import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class CompareTestCase extends RandomChangeTestCase {

	private ProjectSpace compareProjectSpace;

	public CompareTestCase(ProjectSpace testProjectSpace, ProjectSpace compareProjectSpace, String testName,
		TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
		this.compareProjectSpace = compareProjectSpace;
	}

	@Override
	public void runTest() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param compareProjectSpace the compareProjectSpace to set
	 */
	public void setCompareProjectSpace(ProjectSpace compareProjectSpace) {
		this.compareProjectSpace = compareProjectSpace;
	}

	/**
	 * @return the compareProjectSpace
	 */
	public ProjectSpace getCompareProjectSpace() {
		return compareProjectSpace;
	}

}
