package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 * This is a change package test. It creates randomly a ME A, changes one of its
 * non-containment references. The expected change package should contain two
 * operations - a create operation: created A - a change operation: either A.ref
 * changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 * 
 */
public class CreateAndChangeRefTest extends	ChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 2;

	public CreateAndChangeRefTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		// me.setName("newly created " + me.eClass().getName());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProject().getModelElements().add(me);
				ChangeTestHelper.changeSimpleRef(me, getTestProject());
			}

		});

	}

	

		

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	@Override
	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 1;
	}


}
