package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.List;

import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

public class CompoundTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private static final int MAX_TIMES_TO_RUN = 3;
	//private static final int ITERATIONS = 5;

	public CompoundTest(String testName, long randomSeed,
			List<RandomChangeTestCase> testCases) {
		super(testName, randomSeed);
		this.testCases = testCases;

	}

	@Override
	public void runTest() {
	
		int numOfTestCases = testCases.size();
		RandomChangeTestCase testCase = testCases.get(getRandom().nextInt(numOfTestCases));
		int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN) + 1;
		runTestCase(testCase, timesToRun);

	}

	private void runTestCase(RandomChangeTestCase testCase, int timesToRun) {
		for (int i = 0; i < timesToRun; i++) {
			System.out.println("**** CompoundTest: " + testCase.getTestName()
					+ " ****");
			testCase.setTestProject(getTestProject());
			testCase.runTest();
			System.out.println();
		}

	}
	
	
}
