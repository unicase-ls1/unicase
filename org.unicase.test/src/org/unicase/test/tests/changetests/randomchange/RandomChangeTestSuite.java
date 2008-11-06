package org.unicase.test.tests.changetests.randomchange;

import java.util.Calendar;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.test.lib.TestCase;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.ChangeTestSuite;
import org.unicase.ui.test.TestProjectGenerator;

public class RandomChangeTestSuite extends ChangeTestSuite {

	private Project testProject;
	private Project compareProject;
	private Long randomSeed= Calendar.getInstance().getTimeInMillis();
	//private static Log logger = LogFactory.getLog("test");
	private boolean automaticTests;
	
	
	
	public enum AutomaticTestCases {
		ADD_TEST,
		CHANGE_ATTRIBUTE_TEST,
		DELETE_TEST, 
		MOVE_TEST,
		REFERENCE_TEST,
		COMPOUND_TEST
	}
	 
	
	public enum ManualTestCases {
		REMOVE_TEST,
		CREATE_AND_DELETE_TEST,
		CREATE_AND_CHANGE_REF_TEST,
		SIMPLE_ATTRIBUTE_CHANGE_TEST
	}
	
	
	public RandomChangeTestSuite(boolean automaticTests){
		this.automaticTests = automaticTests;
	}
	
	
	@Override
	public void initTestCases() {
		
		// add test cases
		//getLogger().info("adding test cases");
		System.out.println("adding testcases...");
		
		//ChangeAttributeTest
		//ChangeAttributeTest changeAttributeTest = new ChangeAttributeTest("Rename", randomSeed);
		//changeAttributeTest.setParameters();
		
		//DeleteTest
		//DeleteTest deleteTest = new DeleteTest("Delete",  randomSeed);
		//deleteTest.setParameters();
		
		//MoveTest
		//MoveTest moveTest = new MoveTest("Move", randomSeed);
		//moveTest.setParameters();

		//AddTest
		//AddTest addTest = new AddTest("Add", randomSeed);
		//addTest.setParameters();
		
		//Reference Test
		//ReferenceTest referenceTest = new ReferenceTest("Reference", randomSeed);
		//referenceTest.setParameters();
		
		//CreateAndDelete Test
		CreateAndDeleteTest createAndDeleteTest = new CreateAndDeleteTest("CreateAndDelete", randomSeed);
		//createAndDeleteTest.setParameters();
		
		
		//CompoundTest
		//CompoundTest compoundTest = new CompoundTest("Compound", randomSeed);
		//compoundTest.setParameters();
		
		//this.getTestCases().add(moveTest);
		//this.getTestCases().add(addTest);
		//this.getTestCases().add(changeAttributeTest);
		//this.getTestCases().add(deleteTest);
		//this.getTestCases().add(referenceTest);
		//this.getTestCases().add(compoundTest);
		this.getTestCases().add(createAndDeleteTest);
		
		for(TestCase test : getTestCases()){
			if(test instanceof RandomChangeTestCase){
				((RandomChangeTestCase)test).setTestProject(getTestProjectSpace().getProject());
			}
			
		}
		
		
	}

	@Override
	public void endTestCase(String testName) {
		
//		if(ChangeTestHelper.compare(getTestProjectSpace(), getCompareProjectSpace())){
//			System.out.println("Test succeeded: " + testName + "!");
//		}else{
//			logger.info("Test failed: " + testName + "!");
//			//System.out.println();
//		}
		
		System.out.println("Done: " + testName );
//		int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(), getCompareProjectSpace());
//		//int[] result = ChangeTestHelper.linearCompare(testProject, compareProject);
//		if(result[0] == 1){
//			System.out.println("Test succeeded: " + testName + "!");
//		}else{
//			logger.info("Test failed: " + testName + "!");
//			//System.out.println("Test failed: " + testName + "!");
//			System.out.println("position: " + result[1]);
//			System.out.println("character: " + (char)result[2]);
//			System.out.println("lineNum: " + result[3]);
//			System.out.println("colNum: " + result[4]);
//		}
	}
	
	
	@Override
	public void endTestSuite() {
		
		if(automaticTests){
			endTestSuiteAutomaticTests();
			
		}else{
			endTestSuiteManualTests();
		}
		
		
	}

	
	
	private void endTestSuiteAutomaticTests() {
		int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(), getCompareProjectSpace());
		if(result[0] == 1){
			System.out.println("Test succeeded!");
		}else{
			//logger.info("Test failed!");
			System.out.println("XXXXXXXXXXXXXXXXXXXX----  Test failed!  ----XXXXXXXXXXXXXXXXXXXX ");
			System.out.println("position: " + result[1]);
			System.out.println("character: " + (char)result[2]);
			System.out.println("lineNum: " + result[3]);
			System.out.println("colNum: " + result[4]);
			System.exit(0);
		}
		
	}


	private void endTestSuiteManualTests() {
		ChangePackage changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true);
		System.out.println("num of changes: " + changePackage.getOperations().size());
		
		int i = 0;
		for(AbstractOperation op : changePackage.getOperations()){
			System.out.println("-------------------------------------");
			System.out.print(i + ". ");
			System.out.println(op.getName());
			System.out.println(op.getDescription());
			//System.out.println("-------------------------------------");
			i++;
			
		}
	}


	@Override
	public Project getCompareProject() {
			
		if(testProject == null){
			testProject = getTestProject();
		}
		if(compareProject == null){
			System.out.println("coping test project");
			compareProject = (Project)EcoreUtil.copy(testProject);
			System.out.println("test project copied");
		}
		return compareProject;
		
	}

	@Override
	public Project getTestProject() {
		if(testProject == null){
			System.out.println("creating test project");
			testProject = new TestProjectGenerator(5, randomSeed, 3, 2, 3, 10).generateProject();
			System.out.println("test project created");
		}
		return testProject;
	}
	
}
