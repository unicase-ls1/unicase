package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class DeleteTest extends ChangePackageTest {

	private ModelElement me;
	private int expectedNumOfOperations;

	public DeleteTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		me = ChangeTestHelper.getRandomME(getTestProject());
		expectedNumOfOperations = calculateExpectedNumOfChanges();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doDelete();

			}

		});

	}

	private void doDelete() {
		me.delete();
	}

	private int calculateExpectedNumOfChanges() {
		// a multiRefOp for container,
		// a deleteOp for meToRemove
		// + multiRefOp for meToRemove.crossrefs.size()
		// + deleteOp for meToRemove.contents().size()
		// + multiRefOp for each(content in contents) content.crossref.size()

		int numOfOps = 1 + 1 + me.eCrossReferences().size();
		for (TreeIterator<EObject> iter = me.eAllContents(); iter.hasNext();) {
			numOfOps++;
			numOfOps += iter.next().eCrossReferences().size();

		}
		return numOfOps;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {

		return getChangePackage(true).getOperations().size() == expectedNumOfOperations;
	}

}
