package org.unicase.test.tests.change.random.testcases;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.CompareTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class DeleteAndRevertDeleteTest extends CompareTestCase {

	public DeleteAndRevertDeleteTest(ProjectSpace testProjectSpace, ProjectSpace compareProjectSpace, String testName,
		TestProjectParmeters testProjParams) {
		super(testProjectSpace, compareProjectSpace, testName, testProjParams);

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

		CreateDeleteOperation operation;

		try {
			operation = (CreateDeleteOperation) operations.get(0);
			CreateDeleteOperation reverse = (CreateDeleteOperation) operation.reverse();
			reverse.apply(getTestProject());
			boolean success = ChangeTestHelper.compare(getTestProjectSpace(), getCompareProjectSpace());

			if (success) {
				System.out.println("DeleteAndRevertDeleteTest successful");
			} else {
				System.err.println("DeleteAndRevertDeleteTest failed");
			}
		} catch (Exception e) {
			System.err.println("Wrong or no operation.");
			e.printStackTrace();
		}
	}
}
