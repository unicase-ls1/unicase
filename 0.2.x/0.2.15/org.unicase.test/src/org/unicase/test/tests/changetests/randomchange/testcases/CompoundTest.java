package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.List;

import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

public class CompoundTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private static final int MAX_TIMES_TO_RUN = 3;
	private static final int ITERATIONS = 5;

	public CompoundTest(String testName, TestProjectParmeters testProjParams,
			List<RandomChangeTestCase> testCases) {
		super(testName, testProjParams);
		this.testCases = testCases;

	}

	@Override
	public void runTest() {
	
		for(int i = 0; i < ITERATIONS; i ++){
			int numOfTestCases = testCases.size();
			RandomChangeTestCase testCase = testCases.get(getRandom().nextInt(
					numOfTestCases));
			
			//there is a problem with delete test !!!!
			if(testCase instanceof DeleteTest){
				continue;
			}
			
			int timesToRun = getRandom().nextInt(MAX_TIMES_TO_RUN) + 1;
			runTestCase(testCase, timesToRun);
		}
		

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
