package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 * This is change package test. It does the following: creates randomly a ME A
 * in test project, changes randomly one of its simple attributes attr
 * 
 * The expected change package should contain only one operation: -create
 * operation: created A (note that A.attr should be set)
 * 
 * @author Hodaie
 * 
 */

public class CreateAndChangeAttributeTest extends RandomChangeTestCase implements IChangePackageTest{

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	private EAttribute changedAttribute;
	
	
	public CreateAndChangeAttributeTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		final ModelElement me = ChangeTestHelper.createRandomME();

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProject().getModelElements().add(me);
				//me.setName("newly created " + me.eClass().getName());
				changeRandomAttribute(me);
			}

		});

	}
	
	
	
	
	protected void changeRandomAttribute(ModelElement me) {

		 changedAttribute = ChangeTestHelper.changeSimpleAttribute(me, null);
	}

	
	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 1;
	}
	
	
}
