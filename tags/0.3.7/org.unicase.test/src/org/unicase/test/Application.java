package org.unicase.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.test.servertests.ServerTestSuite;
import org.unicase.test.tests.change.manual.ManualChangeTestSuite;
import org.unicase.test.tests.change.random.RandomChangeTestSuite;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private final static int RANDOMTEST = 1;
	private final static int CHANGETEST = 2;
	private final static int SERVERTEST = 3;

	private int DEFAULTITERATION = 10;

	/*
	 * (non-Javadoc)
	 * @seeorg.eclipse.equinox.app.IApplicationk#start(org.eclipse.equinox.app. IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {

		// ///////
		int testToRun = SERVERTEST;
		// ///////

		TestSuite test = null;
		switch (testToRun) {
		case RANDOMTEST:
			test = new RandomChangeTestSuite();
			break;

		case CHANGETEST:
			test = new ManualChangeTestSuite();
			break;

		case SERVERTEST:
			ServerTestSuite testSuite = new ServerTestSuite();
			testSuite.runTest(1);
			break;
		}

		if (test != null) {
			test.runTest(DEFAULTITERATION);
		}

		return IApplication.EXIT_OK;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
