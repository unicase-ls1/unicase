package org.unicase.test.tests.change.random;

import java.io.File;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.test.tests.change.ChangeTestCase;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;

public abstract class RandomChangeTestCase extends ChangeTestCase {
	
	private ChangePackage changePackage; 
	
	private static final String REUSLTS_SAVE_DIR = Configuration
			.getWorkspaceDirectory()
			+ "\\tmp\\errorneousTests\\";

	public RandomChangeTestCase(ProjectSpace testProjectSpace, String testName,
			TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	public String getResultsSavePath() {
		File file = new File(REUSLTS_SAVE_DIR);
		if (!file.exists()) {
			new File(REUSLTS_SAVE_DIR).mkdir();
		}

		return REUSLTS_SAVE_DIR + getClass().getSimpleName() + ".txt";
	}
	
	public ChangePackage getChangePackage(boolean removeChanges) {

		if(changePackage == null){
			changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);
		}
		 return changePackage;
	}

}