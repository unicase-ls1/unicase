package org.unicase.test.tests.changetests.randomchange.testcases;

import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestSuite.RandomTestCases;

public class CompoundTest extends RandomChangeTestCase {

	public CompoundTest(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}

	@Override
	public void runTest() {
		
		int numOfLoops = getRandom().nextInt(5) + 5; 
		int maxTimesToRun = 3;
		RandomTestCases testCase;
		int timesToRun = 0;
		
		for(int i = 0; i < numOfLoops; i++){
			int numOfTestCases  = RandomTestCases.values().length;
			testCase = RandomTestCases.values()[getRandom().nextInt(numOfTestCases)];  
			timesToRun = getRandom().nextInt(maxTimesToRun) + 1;
			runTestCase(testCase, timesToRun);
		}
		
	}

	private void runTestCase(RandomTestCases testCase, int timesToRun) {
		switch(testCase){
		case ADD_TEST:
			System.out.println("**** CompoundTest: AddTest ****");
			renAddTest(timesToRun);
			System.out.println();
			break;
			
		case DELETE_TEST:
			System.out.println("**** CompoundTest: DeleteTest ****");
			renDeleteTest(timesToRun);
			System.out.println();
			break;
			
		case CHANGE_ATTRIBUTE_TEST:
			System.out.println("**** CompoundTest: ChangeSimpleAttributeTest ****");
			renChangeAttributeTest(timesToRun);
			System.out.println();
			break;
			
		case MOVE_TEST:
			System.out.println("**** CompoundTest: MoveTest ****");
			renMoveTest(timesToRun);
			System.out.println();
			break;
			
		}
		
	}

	private void renMoveTest(int timesToRun) {
		
		MoveTest moveTest = new MoveTest("Move", getRandom().nextInt());
		moveTest.setTestProject(getTestProject());
		
		for (int i = 0; i < timesToRun; i++) {
			moveTest.runTest();
		}
		
	}

	private void renChangeAttributeTest(int timesToRun) {
		ChangeSimpleAttributeTest changeAttributeTest = new ChangeSimpleAttributeTest("ChangeAttribute", getRandom().nextInt());
		changeAttributeTest.setTestProject(getTestProject());
		
		for (int i = 0; i < timesToRun; i++) {
			changeAttributeTest.runTest();
		}
		
	}

	private void renDeleteTest(int timesToRun) {
		DeleteTest deleteTest = new DeleteTest("Delete", getRandom().nextInt());
		deleteTest.setTestProject(getTestProject());
		
		for (int i = 0; i < timesToRun; i++) {
			deleteTest.runTest();
		}
		
	}

	private void renAddTest(int timesToRun) {
		AddTest addTest = new AddTest("Add", getRandom().nextInt());
		addTest.setTestProject(getTestProject());
		
		for (int i = 0; i < timesToRun; i++) {
			addTest.runTest();
		}
	}

	
}
