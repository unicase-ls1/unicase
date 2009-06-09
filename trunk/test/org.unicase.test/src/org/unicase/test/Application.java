package org.unicase.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.model.Project;
import org.unicase.test.servertests.ServerTestSuite;
import org.unicase.test.servertests.analyser.AnalyserTestSuite;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.projectGenerator.TestProjectGenerator;
import org.unicase.workspace.test.projectGenerator.TestProjectParmeters;

import java.io.IOException;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private final static int RANDOMTEST = 1;
	private final static int MANUALTEST = 2;
	private final static int SERVERTEST = 3;
	private final static int ANALYSERTEST = 4;

	private int DEFAULTITERATION = 1;

	/**
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplicationk#start(org.eclipse.equinox.app. IApplicationContext)
	 */
	 

	@SuppressWarnings("null")
	public Object start(IApplicationContext context) throws Exception {

		// ///////
		int testToRun = RANDOMTEST;
		// ///////

		TestSuite test = null;
		switch (testToRun) {
		case RANDOMTEST:
			// test = new RandomChangeTestSuite();
			// ((RandomChangeTestSuite) test).setTestProjectPath(null);
			break;

		case MANUALTEST:
			// test = new ManualChangeTestSuite();
			break;

		case SERVERTEST:
			ServerTestSuite testSuite = new ServerTestSuite();
			testSuite.runTest(1);
			break;
		case ANALYSERTEST:
			AnalyserTestSuite testSuite1 = new AnalyserTestSuite();
			testSuite1.runTest(1);
			break;
		}

		if (test != null) {
			test.runTest(DEFAULTITERATION);
		}

		return IApplication.EXIT_OK;
	}

	@SuppressWarnings("unused")
	private void createRandomProject() throws IOException {
		TestProjectParmeters param = new TestProjectParmeters(7, 1, 4, 3, 5, 20);
		TestProjectGenerator generator = new TestProjectGenerator(param);

		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace projectSpace = ChangeTestHelper.createEmptyProjectSpace("random project");
		projectSpace.setProjectDescription("random project with parameter: " + param.toString());

		Project project = generator.generateProject();
		projectSpace.setProject(project);
		workspace.exportProject(projectSpace, "C:\\Dokumente und Einstellungen\\Hodaie\\Desktop\\testProj.ucp");
		System.out.println(project.getAllModelElements().size());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
