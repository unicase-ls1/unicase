package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This is a change package test. It takes a random model element from test
 * project and changes one of its non-containment references, applies this
 * change to compare project. Test succeeds when both projects are identical,
 * and fails otherwise.
 * 
 * @author Hodaie
 * 
 */
public class NonContainmentReferenceAddTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;
	
	
	public NonContainmentReferenceAddTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		me = ChangeTestHelper.getRandomME(getTestProject());
		refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		
		while(refToChange == null){
			me = ChangeTestHelper.createRandomME();
			refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doChangeSimpleRef();
			}

		});
	}
	
	private void doChangeSimpleRef(){
		ChangeTestHelper.changeSimpleRef(me, refToChange, getTestProject());
	}

	public int getExpectedNumOfChanges() {

		return 1;
	}

	
	
	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}

	
}
