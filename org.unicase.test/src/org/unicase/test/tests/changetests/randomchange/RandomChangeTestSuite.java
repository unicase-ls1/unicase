package org.unicase.test.tests.changetests.randomchange;

import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.application.ApplicationDescriptor;
import org.osgi.service.application.ApplicationHandle;
import org.unicase.model.Project;
import org.unicase.test.Activator;
import org.unicase.test.Application;
import org.unicase.test.lib.TestCase;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.ChangeTestSuite;
import org.unicase.ui.test.TestProjectGenerator;

public class RandomChangeTestSuite extends ChangeTestSuite {

	private Project testProject;
	private Project compareProject;
	private Long randomSeed= Calendar.getInstance().getTimeInMillis();
	private static Log logger = LogFactory.getLog("test");
	
	
	@Override
	public void initTestCases() {
		
		// add test cases
		//getLogger().info("adding testcases");
		System.out.println("adding testcases...");
		
		//RenameTest
		//RenameTest renameTest = new RenameTest("Rename", randomSeed);
		//renameTest.setParameters();
		
		//DeleteTest
		//DeleteTest deleteTest = new DeleteTest("Delete",  randomSeed);
		//deleteTest.setParameters();
		
		//MoveTest
		MoveTest moveTest = new MoveTest("Move", randomSeed);
		//moveTest.setParameters();

		//AddTest
		//AddTest addTest = new AddTest();
		//addTest.setParameters();
		
		
		this.getTestCases().add(moveTest);
		//this.getTestCases().add(addTest);
		//this.getTestCases().add(renameTest);
		//this.getTestCases().add(deleteTest);
		
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
		int[] result = ChangeTestHelper.linearCompare(getTestProjectSpace(), getCompareProjectSpace());
		//int[] result = ChangeTestHelper.linearCompare(testProject, compareProject);
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
