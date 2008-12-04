package org.unicase.test.tests.change.randomchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.test.tests.change.ChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.Configuration;

public abstract class RandomChangeTestCase extends ChangeTestCase {

	private boolean isCompareTest;

	private static final String REUSLTS_SAVE_DIR = Configuration
			.getWorkspaceDirectory()
			+ "\\tmp\\errorneousTests\\";

	public RandomChangeTestCase(String testName,
			TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

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
	public void endTestCase(boolean outputToFile) {

		super.endTestCase(false);
		if (!(this instanceof IChangePackageTest)) {
			return;
		}

		if (((IChangePackageTest) this).isSuccessful()) {
			System.out.println("ok");
			return;
		}
		
		ChangePackage changePackage = ((IChangePackageTest) this)
				.getChangePackage(true);
		
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

}

// //====================================================0
// try {
//	
//	
//	
//	
// FileWriter fw = new FileWriter(resultsFile, true);
// BufferedWriter bw = new BufferedWriter(fw);
//
// bw.write("============== " + getTestName() + " ============="
// + Calendar.getInstance().getTime().toString());
// bw.newLine();
//
// bw.write(getTestProjParams().toString());
// bw.newLine();
//	
// bw.write("num of changes: " + changePackage.getOperations().size());
// bw.newLine();
//
// int i = 1;
// for (AbstractOperation op : changePackage.getOperations()) {
// bw.write("-------------------------------------");
// bw.newLine();
// bw.write(i + ". ");
// if (op instanceof CreateDeleteOperation) {
// bw.write(op.getName()
// + " ("
// + ((CreateDeleteOperation) op).getModelElement()
// .getName() + ")");
// bw.newLine();
// } else {
// bw.write(op.getName()
// + " ("
// + getTestProject().getModelElement(
// op.getModelElementId()).getName() + ")");
// bw.newLine();
//
// }
// bw.write(op.getDescription());
// bw.newLine();
// // System.out.println("-------------------------------------");
// i++;
//
// }
//
// bw.flush();
// bw.close();
// fw.close();
//
// } catch (FileNotFoundException e) {
//
// e.printStackTrace();
// } catch (IOException e) {
//
// e.printStackTrace();
// }
// }

