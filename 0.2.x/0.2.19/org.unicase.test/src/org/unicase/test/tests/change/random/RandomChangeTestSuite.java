package org.unicase.test.tests.change.random;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.test.TestCase;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.ChangeTestSuite;
import org.unicase.test.tests.change.random.testcases.AttributeChangeTest;
import org.unicase.test.tests.change.random.testcases.AttributeTransitiveChangeTest;
import org.unicase.test.tests.change.random.testcases.CompositeTest;
import org.unicase.test.tests.change.random.testcases.ContainmentReferenceAddNewTest;
import org.unicase.test.tests.change.random.testcases.ContainmentReferenceMoveTest;
import org.unicase.test.tests.change.random.testcases.CreateAndChangeAttributeTest;
import org.unicase.test.tests.change.random.testcases.CreateAndChangeRefTest;
import org.unicase.test.tests.change.random.testcases.CreateAndDeleteTest;
import org.unicase.test.tests.change.random.testcases.DeleteTest;
import org.unicase.test.tests.change.random.testcases.NonContainmentReferenceAddTest;
import org.unicase.test.tests.change.random.testcases.NonContainmentReferenceRemoveTest;

public class RandomChangeTestSuite extends ChangeTestSuite {

	@Override
	public void initTestCases() {

		List<RandomChangeTestCase> testCases = new ArrayList<RandomChangeTestCase>();

		// add test cases
		System.out.println("adding testcases...");

		// AttributeChangeTest
		AttributeChangeTest attributeChangeTest = new AttributeChangeTest(getTestProjectSpace(), 
				"AttributeChangeTest", getTestProjectPrams());
		testCases.add(attributeChangeTest);

		// DeleteTest
		 DeleteTest deleteTest = new DeleteTest(getTestProjectSpace(), "Delete", getTestProjectPrams());
		 testCases.add(deleteTest);

		
		// ContainmentReferenceMoveTest
		ContainmentReferenceMoveTest moveTest = new ContainmentReferenceMoveTest(getTestProjectSpace(), "Move", getTestProjectPrams());
		testCases.add(moveTest);

		
		// ContainmentReferenceAddNewTest
		ContainmentReferenceAddNewTest containmentReferenceAddNewTest = new ContainmentReferenceAddNewTest(getTestProjectSpace(), "ContainmentReferenceAddNewTest", getTestProjectPrams());
		testCases.add(containmentReferenceAddNewTest);

		
		// Reference Test
		NonContainmentReferenceAddTest changeSimpleRefTest = new NonContainmentReferenceAddTest(getTestProjectSpace(), "Reference",
				getTestProjectPrams());
		testCases.add(changeSimpleRefTest);

		
		// CreateAndDelete Test
		CreateAndDeleteTest createAndDeleteTest = new CreateAndDeleteTest(
				getTestProjectSpace(), "CreateAndDelete", getTestProjectPrams());
		testCases.add(createAndDeleteTest);

		
		// AttributeTransitiveChangeTest Test
		AttributeTransitiveChangeTest attributeTransitiveChangeTest = new AttributeTransitiveChangeTest(getTestProjectSpace(), 
				"AttributeTransitiveChangeTest", getTestProjectPrams());
		testCases.add(attributeTransitiveChangeTest);


		// RemoveSimpleRef Test
		NonContainmentReferenceRemoveTest removeSimpleRefTest = new NonContainmentReferenceRemoveTest(getTestProjectSpace(), "RemoveSimpleRef", getTestProjectPrams());
		testCases.add(removeSimpleRefTest);
		
		// CreateAndChangeRef Test
		CreateAndChangeRefTest createAndChangeRefTest = new CreateAndChangeRefTest(
				getTestProjectSpace(), "CreateAndChangeRef", getTestProjectPrams());
		testCases.add(createAndChangeRefTest);

		
		// CreateAndChangeAttribute Test
		CreateAndChangeAttributeTest createAndChangeAttrTest = new CreateAndChangeAttributeTest(
				getTestProjectSpace(), "CrateAndChangeAttribute", getTestProjectPrams());
		testCases.add(createAndChangeAttrTest);

		
		// CompositeTest
		@SuppressWarnings("unused")
		CompositeTest compoundTest = new CompositeTest(getTestProjectSpace(), "Compound",
				getTestProjectPrams() , testCases);

		
		
		// CommitTest
		// CommitTest commitTest = new CommitTest("Commit", getRandomSeed(),
		// testCases);

		
		
		
		// this.getTestCases().add(moveTest);
		// this.getTestCases().add(containmentReferenceAddNewTest);
		// this.getTestCases().add(compoundTest);
		// this.getTestCases().add(deleteTest);
		// this.getTestCases().add(referenceTest);
		// this.getTestCases().add(compoundTest);
		// this.getTestCases().add(createAndDeleteTest);
		// this.getTestCases().add(attributeTransitiveChangeTest);
	    // this.getTestCases().add(removeContainmentTest);
		// this.getTestCases().add(removeSimpleRefTest);
		 this.getTestCases().add(createAndChangeRefTest);
		// this.getTestCases().add(attributeChangeTest);
		// this.getTestCases().add(createAndChangeAttrTest);
		// this.getTestCases().add(commitTest);

		

	}

	

	@Override
	public void endTestSuite() {

//		if (containsCompareTest()) {
//			endTestSuiteCompareTests();
//			//endTestSuiteChangePackageTests();
//		} else {
//			endTestSuiteChangePackageTests();
//			
//		}

	}

	@SuppressWarnings("unused")
	private boolean containsCompareTest() {
		for(TestCase testCase : getTestCases()){
			if(!(testCase instanceof ChangePackageTest)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Compare tests have a test project and a compare project. They make
	 * changes on test project, extract them, apply them on compare project, and
	 * compare both projects. If test project and compare project are identical
	 * test succeeds, otherwise test fails.
	 */
	@SuppressWarnings("unused")
	private void endTestSuiteCompareTests() {
		int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(),
				getCompareProjectSpace());
		if (result[0] == 1) {
			System.out.println("Test succeeded!");
		} else {
			// logger.info("Test failed!");
			System.out
					.println("XXXXXXXXXXXXXXXXXXXX----  Test failed!  ----XXXXXXXXXXXXXXXXXXXX ");
			
			System.out.println(getTestProjectPrams().toString());
			
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
	@SuppressWarnings("unused")
	private void endTestSuiteChangePackageTests() {

		ChangePackage changePackage = ChangeTestHelper.getChangePackage(
				getTestProjectSpace().getOperations(), true, true);
		if (changePackage.getOperations().size() == 3) {
			System.out.println("ok");
			return;

		}

		System.out.println("num of changes: "
				+ changePackage.getOperations().size());

		int i = 1;
		for (AbstractOperation op : changePackage.getOperations()) {
			System.out.println("-------------------------------------");
			System.out.print(i + ". ");
			if (op instanceof CreateDeleteOperation) {
				System.out.println(op.getName()
						+ " ("
						+ ((CreateDeleteOperation) op).getModelElement()
								.getName() + ")");
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
