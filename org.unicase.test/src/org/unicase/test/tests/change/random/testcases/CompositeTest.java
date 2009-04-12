package org.unicase.test.tests.change.random.testcases;

import java.util.ArrayList;
import java.util.List;

import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This runs a list of test cases randomly.
 * 
 * @author zardosht
 */
public class CompositeTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private boolean testAll;
	private static final int MAX_TIMES_TO_RUN = 5;
	private static final int RANDOM_SELECT_ITERATIONS = 150;
	private static final int TEST_ALL_ITERATIONS = 10;

	public CompositeTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams,
		List<RandomChangeTestCase> testCases, boolean testAll) {
		super(testProjectSpace, testName, testProjParams);
		this.testCases = testCases;
		this.testAll = testAll;

	}

	@Override
	public void runTest() {

		if (testAll) {
			testAll();
		} else {
			randomSelectTest();
		}
	}

	private void randomSelectTest() {
		for (int i = 0; i < RANDOM_SELECT_ITERATIONS; i++) {
			int numOfTestCases = testCases.size();
			RandomChangeTestCase testCase = testCases.get(getRandom().nextInt(numOfTestCases));

			int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN);
			runTestCase(testCase, timesToRun);
		}
	}

	private void testAll() {
		for (int i = 0; i < TEST_ALL_ITERATIONS; i++) {
			List<RandomChangeTestCase> testCasesCopy = new ArrayList<RandomChangeTestCase>();
			testCasesCopy.addAll(testCases);

			while (testCasesCopy.size() > 0) {
				int numOfTestCases = testCasesCopy.size();
				RandomChangeTestCase testCase = testCasesCopy.get(getRandom().nextInt(numOfTestCases));

				int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN);
				runTestCase(testCase, timesToRun);

				testCasesCopy.remove(testCase);
			}

		}

	}

	private void runTestCase(RandomChangeTestCase testCase, int timesToRun) {
		// make sure the test runs at least once
		if (timesToRun == 0) {
			timesToRun += 1;
		}

		for (int i = 0; i < timesToRun; i++) {
			System.out.println("**** CompositeTest: " + testCase.getTestName() + " ****");
			testCase.runTest();
			System.out.println();
		}

	}

}
