package org.unicase.test.tests.change;

import java.io.IOException;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.metamodel.Project;
import org.unicase.projectgenerator.TestProjectGenerator;
import org.unicase.projectgenerator.TestProjectParmeters;
import org.unicase.test.TestSuite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceImpl;

public abstract class ChangeTestSuite extends TestSuite {

	private Project testProject;
	private Project compareProject;

	private ProjectSpace testSpace;
	private ProjectSpace compareSpace;

	private Long randomSeed = new Long(1); // Calendar.getInstance().getTimeInMillis();
	private TestProjectParmeters params;

	private TransactionalEditingDomain domain;
	private String testProjectPath;

	protected ProjectSpace getTestProjectSpace() {
		return testSpace;
	}

	protected ProjectSpace getCompareProjectSpace() {
		return compareSpace;
	}

	/**
	 * This method initialize a test and a compare project space. If you provided path to an exported project as test
	 * project this will be imported. Otherwise a random project is generated. Compare project is a copy of test
	 * project. In the case an already existing project is imported as test project, TestProjectPrameters has all its
	 * field except randomSeed equal 0.
	 * 
	 * @see org.unicase.test.TestSuite#initTestSuite()
	 */
	@Override
	public void initTestSuite() {
		System.out.println("initializing test projectSpaces");
		params = new TestProjectParmeters(50, randomSeed, 5, 5, 10, 20);
		ChangeTestHelper.setRandom(new Random(randomSeed));
		final WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		if (testProjectPath != null) {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						testSpace = currentWorkspace.importProject(testProjectPath);
						testProject = testSpace.getProject();
						params = new TestProjectParmeters(0, randomSeed, 0, 0, 0, 0);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		}

		compareSpace = ChangeTestHelper.createEmptyProjectSpace("compare");
		((ProjectSpaceImpl) compareSpace).stopChangeRecording();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				EList<ProjectSpace> projectSpaces = currentWorkspace.getProjectSpaces();
				if (testProjectPath == null) {
					getTestProjectSpace().setProject(getTestProject());
					testSpace.initResources(currentWorkspace.getWorkspaceResourceSet());
					projectSpaces.add(testSpace);
				}

				getCompareProjectSpace().setProject(getCompareProject());
				compareSpace.initResources(currentWorkspace.getWorkspaceResourceSet());
				projectSpaces.add(compareSpace);

				currentWorkspace.save();

			}

		});
	}

	public void setTestProjectPath(String path) {
		testProjectPath = path;
	}

	public String getTestProjectPath() {
		return testProjectPath;
	}

	/**
	 * This creates a copy of test project as compare project.
	 * 
	 * @return a copy of test project.
	 */
	protected Project getCompareProject() {

		if (testProject == null) {
			testProject = getTestProject();
		}
		if (compareProject == null) {
			System.out.println("coping test project");
			compareProject = (Project) EcoreUtil.copy(testProject);
			System.out.println("test project copied");
		}
		return compareProject;
	}

	protected Project getTestProject() {

		if (testProject == null) {
			System.out.println("creating test project");
			testProject = new TestProjectGenerator(params).generateProject();
			System.out.println("test project created");
		}
		return testProject;
	}

	protected TestProjectParmeters getTestProjectParams() {
		return params;
	}

}
