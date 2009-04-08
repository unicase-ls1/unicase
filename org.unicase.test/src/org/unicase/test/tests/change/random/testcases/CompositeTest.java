package org.unicase.test.tests.change.random.testcases;

import java.util.List;

import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class CompositeTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private static final int MAX_TIMES_TO_RUN = 50;
	private static final int ITERATIONS = 50;

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

			// there is a problem with delete test !!!!
			if (testCase instanceof DeleteTest) {
				continue;
			}

			int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN) + 1;
			runTestCase(testCase, timesToRun);
		}

	}

	private void runTestCase(RandomChangeTestCase testCase, int timesToRun) {
		for (int i = 0; i < timesToRun; i++) {
			System.out.println("**** CompositeTest: " + testCase.getTestName() + " ****");
			testCase.runTest();
			System.out.println();
		}

	}

}
