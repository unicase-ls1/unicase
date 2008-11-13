package org.unicase.test.tests.changetests.randomchange;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.test.lib.TestCase;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.ChangeTestSuite;
import org.unicase.test.tests.changetests.randomchange.testcases.CreateAndDeleteTest;
import org.unicase.test.tests.changetests.randomchange.testcases.RemoveTest;
import org.unicase.test.tests.changetests.randomchange.testcases.TransitivelyChangeAttributeTest;

public class RandomChangeTestSuite extends ChangeTestSuite {

	// private static Log logger = LogFactory.getLog("test");
	private boolean changePackageTest;

	public enum RandomTestCases {
		ADD_TEST, CHANGE_ATTRIBUTE_TEST, DELETE_TEST, MOVE_TEST, REFERENCE_TEST, REMOVE_TEST, CREATE_AND_DELETE_TEST, CREATE_AND_CHANGE_REF_TEST, CREATE_AND_CHANGE_ATTRIBUTE_TEST, TRANSITIVELY_CHANGE_ATTRIBUTE_TEST, COMPOUND_TEST
	}

	public RandomChangeTestSuite(boolean automaticTests) {
		this.changePackageTest = automaticTests;
	}

	@Override
	public void initTestCases() {

		// add test cases
		// getLogger().info("adding test cases");
		System.out.println("adding testcases...");

		// ChangeAttributeTest
		// ChangeAttributeTest changeAttributeTest = new
		// ChangeAttributeTest("Rename", randomSeed);
		// changeAttributeTest.setParameters();

		// DeleteTest
		// DeleteTest deleteTest = new DeleteTest("Delete", randomSeed);
		// deleteTest.setParameters();

		// MoveTest
		// MoveTest moveTest = new MoveTest("Move", randomSeed);
		// moveTest.setParameters();

		// AddTest
		// AddTest addTest = new AddTest("Add", randomSeed);
		// addTest.setParameters();

		// Reference Test
		// ReferenceTest referenceTest = new ReferenceTest("Reference",
		// randomSeed);
		// referenceTest.setParameters();

		// CreateAndDelete Test
		// CreateAndDeleteTest createAndDeleteTest = new
		// CreateAndDeleteTest("CreateAndDelete", getRandomSeed());
		// createAndDeleteTest.setParameters();

		// TransitivelyChangeAttributeTest Test
		// TransitivelyChangeAttributeTest transitivelyChangeAttribute = new
		// TransitivelyChangeAttributeTest("SimpleAttributeChange",
		// getRandomSeed());
		// createAndDeleteTest.setParameters();

		// Remove Test
		RemoveTest removeTest = new RemoveTest("Remove", getRandomSeed());
		// rmoveTest.setPrameters();

		// CompoundTest
		// CompoundTest compoundTest = new CompoundTest("Compound", randomSeed);
		// compoundTest.setParameters();

		// this.getTestCases().add(moveTest);
		// this.getTestCases().add(addTest);
		// this.getTestCases().add(changeAttributeTest);
		// this.getTestCases().add(deleteTest);
		// this.getTestCases().add(referenceTest);
		// this.getTestCases().add(compoundTest);
		// this.getTestCases().add(createAndDeleteTest);
		// this.getTestCases().add(transitivelyChangeAttribute);
		this.getTestCases().add(removeTest);

		for (TestCase test : getTestCases()) {
			if (test instanceof RandomChangeTestCase) {
				((RandomChangeTestCase) test)
						.setTestProject(getTestProjectSpace().getProject());
			}

		}

	}

	@Override
	public void endTestCase(String testName) {

		// if(ChangeTestHelper.compare(getTestProjectSpace(),
		// getCompareProjectSpace())){
		// System.out.println("Test succeeded: " + testName + "!");
		// }else{
		// logger.info("Test failed: " + testName + "!");
		// //System.out.println();
		// }

		System.out.println("Done: " + testName);
		// int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(),
		// getCompareProjectSpace());
		// //int[] result = ChangeTestHelper.linearCompare(testProject,
		// compareProject);
		// if(result[0] == 1){
		// System.out.println("Test succeeded: " + testName + "!");
		// }else{
		// logger.info("Test failed: " + testName + "!");
		// //System.out.println("Test failed: " + testName + "!");
		// System.out.println("position: " + result[1]);
		// System.out.println("character: " + (char)result[2]);
		// System.out.println("lineNum: " + result[3]);
		// System.out.println("colNum: " + result[4]);
		// }
	}

	@Override
	public void endTestSuite() {

		if (changePackageTest) {
			endTestSuiteChangePackageTests();
		} else {
			endTestSuiteCompareTests();

		}

	}

	/**
	 * Compare tests have a test project and a compare project. They make
	 * changes on test project, extract them, apply them on compare project, and
	 * compare both projects. If test project and compare project are identical
	 * test succeeds, otherwise test fails.
	 */
	private void endTestSuiteCompareTests() {
		int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(),
				getCompareProjectSpace());
		if (result[0] == 1) {
			System.out.println("Test succeeded!");
		} else {
			// logger.info("Test failed!");
			System.out
					.println("XXXXXXXXXXXXXXXXXXXX----  Test failed!  ----XXXXXXXXXXXXXXXXXXXX ");
			System.out.println("position: " + result[1]);
			System.out.println("character: " + (char) result[2]);
			System.out.println("lineNum: " + result[3]);
			System.out.println("colNum: " + result[4]);
			System.exit(0);
		}

	}

	/**
	 * ChangePackage tests make changes on test project, and then extract change
	 * packages. If change package is identical with what user expects, test has
	 * succeeded. It is up to user to investigate the change package after
	 * running test, and it up to user to say if test succeeded of failed.
	 */
	private void endTestSuiteChangePackageTests() {

		ChangePackage changePackage = ChangeTestHelper.getChangePackage(
				getTestProjectSpace().getOperations(), true);
		// if(changePackage.getOperations().size() == 1){
		// System.out.println("ok");
		// return;
		//			
		// }

		System.out.println("num of changes: "
				+ changePackage.getOperations().size());

		int i = 1;
		for (AbstractOperation op : changePackage.getOperations()) {
			System.out.println("-------------------------------------");
			System.out.print(i + ". ");
			if (op instanceof CreateDeleteOperation) {
				System.out.println(op.getName()
						+ " ("
						+ ((CreateDeleteOperation)op).getModelElement().getName() + ")");
			} else {
				System.out.println(op.getName()
						+ " ("
						+ getTestProject().getModelElement(
								op.getModelElementId()).getName() + ")");
			}
			System.out.println(op.getDescription());
			// System.out.println("-------------------------------------");
			i++;

		}
	}

}
