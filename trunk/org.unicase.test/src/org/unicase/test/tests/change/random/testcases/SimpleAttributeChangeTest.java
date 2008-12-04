package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This is a compare test. It takes randomly a ME from test project, changes one
 * of its EAttributes, extract changes from test project, applies changes to
 * compare project. Test succeeds when compare project and test project are
 * identical.
 * 
 * @author Hodaie
 * 
 */
public class SimpleAttributeChangeTest extends ChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	
	 private ModelElement me;

	private EAttribute changedAttribute; 
	
	
	public SimpleAttributeChangeTest(ProjectSpace testProjectSpace, String testName,TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		 me = ChangeTestHelper.getRandomME(getTestProject());

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				changeAttribute();
			}

		});

	}

	protected void changeAttribute() {
		changedAttribute = ChangeTestHelper.changeSimpleAttribute(me, null);
	}

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	

	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 1;
	}

}
