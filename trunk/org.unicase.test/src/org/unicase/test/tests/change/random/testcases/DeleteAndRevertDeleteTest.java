package org.unicase.test.tests.change.random.testcases;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class DeleteAndRevertDeleteTest extends ChangePackageTest {

	public DeleteAndRevertDeleteTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				doTest();
			}
		});
	}

	private void doTest() {
		ModelElement modelElement = ChangeTestHelper.getRandomME(getTestProject());
		modelElement.delete();
		List<AbstractOperation> operations = getTestProjectSpace().getOperations();
		CreateDeleteOperation operation = (CreateDeleteOperation) operations.get(0);
		CreateDeleteOperation reverse = (CreateDeleteOperation) operation.reverse();
		reverse.apply(getTestProject());
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// TODO Auto-generated method stub
		return false;
	}

}
