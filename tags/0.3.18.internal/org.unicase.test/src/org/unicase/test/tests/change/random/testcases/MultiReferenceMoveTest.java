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
 * This move an element in a many reference list to another position.
 * 
 * @author zardosht
 */
public class MultiReferenceMoveTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;

	public MultiReferenceMoveTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
	}

	@Override
	public void runTest() {
		me = ChangeTestHelper.getRandomME(getTestProject());
		refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);

		while (refToChange == null || !refToChange.isMany()) {
			me = ChangeTestHelper.createRandomME();
			refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ChangeTestHelper.moveMultiReferenceValue(me, refToChange);
			}
		});

	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// TODO Auto-generated method stub
		return false;
	}

}
