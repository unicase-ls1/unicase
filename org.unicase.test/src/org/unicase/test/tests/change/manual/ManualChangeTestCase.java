package org.unicase.test.tests.change.manual;

import org.unicase.test.tests.change.ChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public abstract class ManualChangeTestCase extends ChangeTestCase {

	public ManualChangeTestCase(ProjectSpace testProjectSpace, String testName,TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
	}

}
