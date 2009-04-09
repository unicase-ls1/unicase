package org.unicase.test.tests.change.random.testcases;

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
	private static final int MAX_TIMES_TO_RUN = 4;
	private static final int ITERATIONS = 200;

	public CompositeTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams,
		List<RandomChangeTestCase> testCases) {
		super(testProjectSpace, testName, testProjParams);
		this.testCases = testCases;

	}

	@Override
	public void runTest() {

		for (int i = 0; i < ITERATIONS; i++) {
			int numOfTestCases = testCases.size();
			RandomChangeTestCase testCase = testCases.get(getRandom().nextInt(numOfTestCases));

			int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN) + 1;
			runTestCase(testCase, timesToRun);
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
