package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class MultiAttributeMoveTest extends ChangePackageTest {

	private ModelElement me;
	private EAttribute attributeToChange;
	private int tries;

	public MultiAttributeMoveTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
	}

	@Override
	public void runTest() {
		me = ChangeTestHelper.getRandomME(getTestProject());
		attributeToChange = ChangeTestHelper.getRandomAttribute(me);

		while (attributeToChange == null || !attributeToChange.isMany()) {
			me = ChangeTestHelper.createRandomME();
			attributeToChange = ChangeTestHelper.getRandomAttribute(me);
			tries++;
			if (tries > 2000) {
				return;
			}
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ChangeTestHelper.moveMultiAttributeValue(me, attributeToChange);
			}
		});

	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// TODO Auto-generated method stub
		return false;
	}

}
