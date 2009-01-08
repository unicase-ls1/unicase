package org.unicase.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.test.tests.change.ChangeTestSuite;
import org.unicase.test.tests.change.manual.ManualChangeTestSuite;
import org.unicase.test.tests.change.random.RandomChangeTestSuite;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplicationk#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {

		ChangeTestSuite changeTest;
		boolean randomTest = false;
		if (randomTest) {
			changeTest = new RandomChangeTestSuite();
		} else {
			changeTest = new ManualChangeTestSuite();
		}

		changeTest.runTest(1);

		return IApplication.EXIT_OK;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
