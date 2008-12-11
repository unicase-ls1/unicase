package org.unicase.test.tests.change.random.testcases;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This test adds an existing model element to a unique reference.
 * There should be no operation recorded??? 
 * This is currently postponed.
 * 
 * 
 * @author Hodaie
 *
 */
public class NonContainmentReferenceUniqueTest extends ChangePackageTest {
	
//	private ModelElement me; 

	
	/**
	 * This test is currently postponed.
	 */
	public NonContainmentReferenceUniqueTest(ProjectSpace testProjectSpace, String testName,
			TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
		
	}
	
	
	/**
	 * This test is currently postponed.
	 */
	@Override
	public void runTest() {
//		me = ChangeTestHelper.getRandomME(getTestProject());
//		EReference ref = ChangeTestHelper.getRandomNonContainmentRef(me);
//		while(ref == null || !ref.isUnique()){
//			me = ChangeTestHelper.getRandomME(getTestProject());
//			ref = ChangeTestHelper.getRandomNonContainmentRef(me);
//		}
		
		
		
		
	}

	
	/**
	 * This test is currently postponed.
	 */
	public int getExpectedNumOfChanges() {
		return 0;
	}

	
	/**
	 * This test is currently postponed.
	 */
	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		return false;
	}

}
