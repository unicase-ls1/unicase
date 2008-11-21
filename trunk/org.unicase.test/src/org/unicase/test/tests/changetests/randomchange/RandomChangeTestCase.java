package org.unicase.test.tests.changetests.randomchange;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.test.tests.changetests.ChangeTestCase;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.workspace.Configuration;

public abstract class RandomChangeTestCase extends ChangeTestCase {

	private boolean isCompareTest;
	
	private static final String REUSLTS_SAVE_DIR = Configuration
			.getWorkspaceDirectory()
			+ "\\tmp\\errorneousTests\\";

	public RandomChangeTestCase(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	
	public void setCompareTest(boolean isCompareTest) {
		this.isCompareTest = isCompareTest;
	}

	
	public boolean isCompareTest() {
		return isCompareTest;
	}

	
	public boolean isChangePackageTest() {
		return this instanceof IChangePackageTest;
	}

	
	public String getResultsSavePath() {
		File file = new File(REUSLTS_SAVE_DIR);
		if (!file.exists()) {
			new File(REUSLTS_SAVE_DIR).mkdir();
		}

		return REUSLTS_SAVE_DIR + getClass().getSimpleName() + ".txt";
	}

	
	
	
	@Override
	public void endTestCase() {
		
		super.endTestCase();
		if (!(this instanceof IChangePackageTest)) {
			return;
		}

		File resultsFile = new File(getResultsSavePath());
		ChangePackage changePackage = ChangeTestHelper.getChangePackage(
				getTestProjectSpace().getOperations(), true);
		if (changePackage.getOperations().size() == ((IChangePackageTest)this).getExpectedNumOfChanges()) {
			System.out.println("ok");
			return;
		}

		try {
			FileWriter fw = new FileWriter(resultsFile, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("============== " + getTestName() + " ============="
					+ Calendar.getInstance().getTime().toString());
			bw.newLine();

			bw.write("num of changes: " + changePackage.getOperations().size());
			bw.newLine();

			int i = 1;
			for (AbstractOperation op : changePackage.getOperations()) {
				bw.write("-------------------------------------");
				bw.newLine();
				bw.write(i + ". ");
				if (op instanceof CreateDeleteOperation) {
					bw.write(op.getName()
							+ " ("
							+ ((CreateDeleteOperation) op).getModelElement()
									.getName() + ")");
					bw.newLine();
				} else {
					bw.write(op.getName()
							+ " ("
							+ getTestProject().getModelElement(
									op.getModelElementId()).getName() + ")");
					bw.newLine();

				}
				bw.write(op.getDescription());
				bw.newLine();
				// System.out.println("-------------------------------------");
				i++;

			}

			bw.flush();
			bw.close();
			fw.close();	
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	
}
