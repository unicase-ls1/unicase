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
 * 
 * This is a change package test. It creates randomly a ME A, changes one of its
 * non-containment references. The expected change package should contain two
 * operations - a create operation: created A - a change operation: either A.ref
 * changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 * 
 */
public class CreateAndChangeRefTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;

	public CreateAndChangeRefTest(ProjectSpace testProjectSpace,
			String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {
		me = ChangeTestHelper.createRandomME();
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

				doAddAndChangeRef();

			}

		});

	}

	protected void doAddAndChangeRef() {

		getTestProject().getModelElements().add(me);
		ChangeTestHelper.changeSimpleRef(me, refToChange, getTestProject());
		
	}

	public int getExpectedNumOfChanges() {
		return 2;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}

}
