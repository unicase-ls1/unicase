package org.unicase.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.test.tests.changetests.ChangeTestSuite;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestSuite;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplicationk#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {

		
	
		ChangeTestSuite changeTest = new RandomChangeTestSuite();
		changeTest.runTest(1);
		
		return IApplication.EXIT_OK;
	}
	
	
	
	
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}






////===================================================================
//for(int i = 0; i < 5; i++){
//	System.out.println("==== test " + i + " ====");
//	long randomSeed = Calendar.getInstance().getTimeInMillis();
//	Project p = new TestProjectGenerator(5, randomSeed, 3, 2, 5, 10).generateProject();
//	System.out.println("project created: " + p.getAllModelElements().size() + " MEs");
//	int[] result = ChangeTestHelper.linearCompare(p, (Project)EcoreUtil.copy(p));
//	if(result[0] == 1){
//		System.out.println("Test succeeded: "  + "!");
//	}else{
//		System.out.println("Test failed: " + "!");
//		System.out.println("character: " + (char)result[2]);
//		System.out.println("position: " + result[1]);
//		System.out.println("lineNum: " + result[3]);
//		System.out.println("colNum: " + result[4]);
//	}
//}
