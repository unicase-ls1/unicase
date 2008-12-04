package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

public class DeleteTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private ChangePackage changePackage;
	private ModelElement me;
	private int expectedNumOfOperations;

	public DeleteTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		me = ChangeTestHelper.getRandomME(getTestProject());
		expectedNumOfOperations = getExpectedNumOfChanges();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doDelete();

			}

		});

		changePackage = getChangePackage(true);

	}

	private void doDelete() {
		EcoreUtil.delete(me, true);
	}

	public ChangePackage getChangePackage(boolean removeChanges) {
		if (changePackage == null) {
			changePackage = ChangeTestHelper.getChangePackage(
					getTestProjectSpace().getOperations(), false, removeChanges);
		}
		return changePackage;
	}

	public int getExpectedNumOfChanges() {
		//a multiRefOp for container, 
		//a deleteOp for meToRemove
		//+ multiRefOp for meToRemove.crossrefs.size()
		//+ deleteOp for meToRemove.contents().size()
		//+ multiRefOp for each(content in contents) content.crossref.size()
		
		int numOfOps =  1 + 1 + me.eCrossReferences().size();
		for(TreeIterator<EObject> iter = me.eAllContents(); iter.hasNext(); ){
			numOfOps ++;
			numOfOps += iter.next().eCrossReferences().size();
			
		}
		return numOfOps;
	}

	public boolean isSuccessful() {

		return changePackage.getOperations().size() == expectedNumOfOperations;
	}

}
