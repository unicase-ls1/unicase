package org.unicase.test.tests.change.random.testcases;

import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

import java.util.ArrayList;
import java.util.List;

/**
 * This runs a list of test cases randomly.
 * 
 * @author zardosht
 */
public class CompositeTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private boolean testAll;
	private int maxTimesToRunATestCase = 3;
	private int randomSelectIterations = 10;
	private int testAllIterations = 10;

	public CompositeTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams,
		List<RandomChangeTestCase> testCases, boolean testAll) {
		super(testProjectSpace, testName, testProjParams);
		this.testCases = testCases;
		this.setTestAll(testAll);

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
		for (int i = 0; i < randomSelectIterations; i++) {
			int numOfTestCases = testCases.size();
			RandomChangeTestCase testCase = testCases.get(getRandom().nextInt(numOfTestCases));

			int timesToRun = getRandom().nextInt(maxTimesToRunATestCase);
			runTestCase(testCase, timesToRun);
		}
	}

	private void testAll() {
		for (int i = 0; i < testAllIterations; i++) {
			List<RandomChangeTestCase> testCasesCopy = new ArrayList<RandomChangeTestCase>();
			testCasesCopy.addAll(testCases);

			while (testCasesCopy.size() > 0) {
				int numOfTestCases = testCasesCopy.size();
				RandomChangeTestCase testCase = testCasesCopy.get(getRandom().nextInt(numOfTestCases));

				int timesToRun = getRandom().nextInt(maxTimesToRunATestCase);
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

	/**
	 * @param testAll the testAll to set
	 */
	public void setTestAll(boolean testAll) {
		this.testAll = testAll;
	}

	/**
	 * @return the testAll
	 */
	public boolean isTestAll() {
		return testAll;
	}

	/**
	 * @param testAllIterations the testAllIterations to set
	 */
	public void setTestAllIterations(int testAllIterations) {
		this.testAllIterations = testAllIterations;
	}

	/**
	 * @return the testAllIterations
	 */
	public int getTestAllIterations() {
		return testAllIterations;
	}

	/**
	 * @param randomSelectIterations the randomSelectIterations to set
	 */
	public void setRandomSelectIterations(int randomSelectIterations) {
		this.randomSelectIterations = randomSelectIterations;
	}

	/**
	 * @return the randomSelectIterations
	 */
	public int getRandomSelectIterations() {
		return randomSelectIterations;
	}

	/**
	 * @param maxTimesToRunATestCase the maxTimesToRunATestCase to set
	 */
	public void setMaxTimesToRunATestCase(int maxTimesToRunATestCase) {
		this.maxTimesToRunATestCase = maxTimesToRunATestCase;
	}

	/**
	 * @return the maxTimesToRunATestCase
	 */
	public int getMaxTimesToRunATestCase() {
		return maxTimesToRunATestCase;
	}

}
