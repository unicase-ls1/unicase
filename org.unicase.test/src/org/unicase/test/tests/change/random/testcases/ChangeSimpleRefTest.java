package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * This is a change package test. It takes a random model element from test
 * project and changes one of its non-containment references, applies this
 * change to compare project. Test succeeds when both projects are identical,
 * and fails otherwise.
 * 
 * @author Hodaie
 * 
 */
public class ChangeSimpleRefTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 1;

	public ChangeSimpleRefTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {

		final ModelElement me = ChangeTestHelper.getRandomME(getTestProject());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				ChangeTestHelper.changeSimpleRef(me, getTestProject());
			}

		});
	}

	public int getExpectedNumOfChanges() {

		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {
		
		return EXPECTED_NUM_OF_CHANGES == 1;
	}

	public ChangePackage getChangePackage(boolean removeChanges) {
		return ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);

	}
}
