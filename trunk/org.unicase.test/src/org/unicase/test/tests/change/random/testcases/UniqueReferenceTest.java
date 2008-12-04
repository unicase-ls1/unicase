package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * This test adds an existing model element to a unique reference.
 * There should be no operation recorded??? 
 * 
 * 
 * @author Hodaie
 *
 */
public class UniqueReferenceTest extends RandomChangeTestCase implements
		IChangePackageTest {
	
	private ModelElement me; 

	public UniqueReferenceTest(String testName,
			TestProjectParmeters testProjParams) {
		super(testName, testProjParams);
		
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

	public ChangePackage getChangePackage(boolean removeChanges) {
		
		return null;
	}

	public int getExpectedNumOfChanges() {
		return 0;
	}

	

	public boolean isSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}

}
