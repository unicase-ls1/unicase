package org.unicase.test.tests.changetests.randomchange.testcases;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.WorkspaceManager;

public class DeleteTest extends RandomChangeTestCase implements IChangePackageTest {

	
	
	public DeleteTest(String testName,TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {


		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");


		final ModelElement me = ChangeTestHelper.getRandomME(getTestProject());

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				System.out.println("deleting ME...");
				EcoreUtil.delete(me, true);
				// WorkspaceManager.getProjectSpace(getTestProject()).save();
				WorkspaceManager.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace().save();
				
			
			}

		});



	}

	public ChangePackage getChangePackage(boolean removeChanges) {
		
		return ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);
	}

	public int getExpectedNumOfChanges() {
		//compute number of changes:
		// 1. # of deletions = 1 + allContents().size()
		// 2. # of multirefs = me.crossrefs().size() 
		//                    + foreach(element in allContents){ element.crossrefs().size()}
		//
		return 0;
	}

	public boolean isSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
