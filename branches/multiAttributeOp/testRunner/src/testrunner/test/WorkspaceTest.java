package testrunner.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Abstract Superclass for WOrkspace Tests. Provides Setup and Tear-down.
 * 
 * @author koegel
 */
public abstract class WorkspaceTest {
	private Project project;
	private ProjectSpace projectSpace;

	/**
	 * Setup a dummy project for testing.
	 */
	@Before
	public void setupProjectSpace() {
		Configuration.setTesting(true);
		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		new UnicaseCommand() {

			@Override
			protected void doRun() {

				ProjectSpace localProject = workspace.createLocalProject(
						"testProject", "test Project");
				setProjectSpace(localProject);
				setProject(getProjectSpace().getProject());
			}
		}.run();

	}

	/**
	 * Clean workspace.
	 */
	@After
	public void cleanProjectSpace() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					WorkspaceManager.getInstance().getCurrentWorkspace()
							.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					fail();
				}
			}
		}.run();
	}

	/**
	 * Delete all persisted data.
	 */
	@AfterClass
	public static void deleteData() {
		String workspacePath = Configuration.getWorkspaceDirectory();
		File workspaceDirectory = new File(workspacePath);
		FileFilter workspaceFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("ps-");
			}

		};
		File[] filesToDelete = workspaceDirectory.listFiles(workspaceFileFilter);
		for (int i = 0; i < filesToDelete.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDelete[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(workspacePath + "workspace.ucw").delete();
	}

	/**
	 * @param project
	 *            the project to set
	 */
	private void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param projectSpace
	 *            the projectSpace to set
	 */
	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * Clear all operations from project space.
	 */
	protected void clearOperations() {
		getProjectSpace().getOperations().clear();
	}
}
