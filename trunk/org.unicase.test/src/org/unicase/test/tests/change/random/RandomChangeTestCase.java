package org.unicase.test.tests.change.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.Project;
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

	@Override
	public void outputResults(boolean outputToFile) {

		super.outputResults(false);
		if (!(this instanceof IChangePackageTest)) {
			return;
		}

		if (((IChangePackageTest) this).isSuccessful()) {
			System.out.println("ok");
			return;
		}
		
		ChangePackage changePackage = getChangePackage(true);
		
		StringBuilder sb = new StringBuilder();
//		sb.append("============== " + getTestName() + " ============="
//				+ Calendar.getInstance().getTime().toString());
//		sb.append("\n");

//		sb.append(getTestProjParams().toString());
//		sb.append("\n");

		sb.append("num of changes: " + changePackage.getOperations().size());
		sb.append("\n");

		int i = 1;
		for (AbstractOperation op : changePackage.getOperations()) {
			sb.append("-------------------------------------");
			sb.append("\n");
			sb.append(i + ". ");
			if (op instanceof CreateDeleteOperation) {
				sb.append(op.getName()
						+ " ("
						+ ((CreateDeleteOperation) op).getModelElement()
								.getName() + ")");
				sb.append("\n");
			} else {
				sb.append(op.getName() + "(" + op.getClass().getSimpleName() + ")" 
						+ " ("
						+ getTestProject().getModelElement(
								op.getModelElementId()).getName() + ")");
				sb.append("\n");

			}
			sb.append(op.getDescription());
			sb.append("\n");
			i++;

		}

		if (outputToFile) {
			try {
				File resultsFile = new File(getResultsSavePath());
				FileWriter fw = new FileWriter(resultsFile, true);
				fw.write(sb.toString());
				fw.flush();
				fw.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(sb.toString());
		}

	}
	
	public ChangePackage getChangePackage(boolean removeChanges) {

		if(changePackage == null){
			changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);
		}
		 return changePackage;
	}

}