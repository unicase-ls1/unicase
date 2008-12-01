package org.unicase.test.tests.changetests.randomchange.testcases;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

public class DeleteTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private ChangePackage changePackage;
	private ModelElement me;

	public DeleteTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		me = ChangeTestHelper.getRandomME(getTestProject());

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
					getTestProjectSpace().getOperations(), true, removeChanges);
		}
		return changePackage;
	}

	public int getExpectedNumOfChanges() {
		// compute number of changes:
		// 1. # of deletions = 1 + allContents().size()
		// 2. # of multirefs = me.crossrefs().size()
		// + foreach(element in allContents){ element.crossrefs().size()}
		//
		
		int numOfOps = 1 + me.eCrossReferences().size();
		for(TreeIterator<EObject> iter = me.eAllContents(); iter.hasNext(); ){
			numOfOps ++;
			numOfOps += iter.next().eCrossReferences().size();
			
		}
		return numOfOps;
	}

	public boolean isSuccessful() {

		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}

}
