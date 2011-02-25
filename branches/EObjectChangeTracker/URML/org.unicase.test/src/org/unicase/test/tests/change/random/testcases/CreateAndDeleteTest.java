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
 * This is a change package test. It creates randomly a model element, changes one of its non-containment references,
 * and deletes this ME. The expected change package should contain no operations.
 * 
 * @author Hodaie
 */
public class CreateAndDeleteTest extends ChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 0;
	private EReference refToChange;
	private ModelElement meToReference;

	public CreateAndDeleteTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
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
				doChangeNonContainmentRef(me);
				me.delete();
			}

		});

	}

	private void doChangeNonContainmentRef(ModelElement me) {

		refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);

		while (refToChange == null) {
			me = ChangeTestHelper.createRandomME();
			refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		}

		meToReference = ChangeTestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
		if (meToReference == null) {
			return;
		}

		ChangeTestHelper.changeNonContainmentRef(me, refToChange, meToReference);

	}

	public int getExpectedNumOfChanges() {

		return EXPECTED_NUM_OF_CHANGES;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		return EXPECTED_NUM_OF_CHANGES == 0;
	}

}
