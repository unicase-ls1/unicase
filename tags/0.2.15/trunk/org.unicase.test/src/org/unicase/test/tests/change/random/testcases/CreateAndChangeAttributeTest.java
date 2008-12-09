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

public class CreateAndChangeAttributeTest extends ChangePackageTest{

	private ModelElement me;
	private EAttribute attributeToChange;
	
	
	public CreateAndChangeAttributeTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		me = ChangeTestHelper.createRandomME();
		attributeToChange = ChangeTestHelper.getRandomAttribute(me);
		
		while(attributeToChange == null){
			me = ChangeTestHelper.createRandomME();
			attributeToChange = ChangeTestHelper.getRandomAttribute(me);
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				
				doAddAndChangeAttribute();
				
			}

		});

	}
	
	
	
	
	private void doAddAndChangeAttribute() {
		getTestProject().getModelElements().add(me);
		ChangeTestHelper.changeSimpleAttribute(me, attributeToChange);
	}

	

		
	

	
	public int getExpectedNumOfChanges() {
		//only one CreateDeleteOp for newly created me.
		return 1;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		//temp impl
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}
	
	
}
