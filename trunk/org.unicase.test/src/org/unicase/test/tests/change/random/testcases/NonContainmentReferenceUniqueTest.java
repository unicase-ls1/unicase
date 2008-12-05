package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This test adds an existing model element to a unique reference.
 * There should be no operation recorded??? 
 * 
 * 
 * @author Hodaie
 *
 */
public class NonContainmentReferenceUniqueTest extends ChangePackageTest {
	
	private ModelElement me; 

	public NonContainmentReferenceUniqueTest(ProjectSpace testProjectSpace, String testName,
			TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
		
	}
	
	
	@Override
	public void runTest() {
		me = ChangeTestHelper.getRandomME(getTestProject());
		EReference ref = ChangeTestHelper.getRandomNonContainmentRef(me);
		while(!ref.isUnique()){
			me = ChangeTestHelper.getRandomME(getTestProject());
			ref = ChangeTestHelper.getRandomNonContainmentRef(me);
		}
		
		
		
		
	}

	

	public int getExpectedNumOfChanges() {
		return 0;
	}

	

	@Override
	public boolean isSuccessful() {
		return false;
	}

}
