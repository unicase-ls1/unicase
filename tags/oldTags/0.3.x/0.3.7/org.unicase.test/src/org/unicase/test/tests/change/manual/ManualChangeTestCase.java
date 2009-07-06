package org.unicase.test.tests.change.manual;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.test.tests.change.ChangeTestCase;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public abstract class ManualChangeTestCase extends ChangeTestCase {

	public ManualChangeTestCase(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
	}

	@Override
	public void outputResults(boolean outputToFile) {
		ChangePackage changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true,
			true);
		int i = 1;
		for (AbstractOperation op : changePackage.getOperations()) {

			System.out.println(i + ". " + op.getName() + " (" + op.getClass().getSimpleName() + ")("
				+ getTestProject().getModelElement(op.getModelElementId()).getName() + ")");
			i++;
		}
	}

}
