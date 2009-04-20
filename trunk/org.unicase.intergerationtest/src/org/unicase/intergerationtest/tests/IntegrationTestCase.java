/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.Activator;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.Project;
import org.unicase.model.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceImpl;

/**
 * @author Hodaie
 */
public abstract class IntegrationTestCase {

	private static ProjectSpace testSpace;
	private static Project testProject;

	private static Usersession usersession;
	private static TransactionalEditingDomain domain;

	private static ProjectId projectId;
	private static Workspace workSpace;
	private static Project testProjectBackup;

	private static int executedTestsCounter;

	/**
	 * set up test project.
	 * 
	 * @throws URISyntaxException URISyntaxException
	 */
	@BeforeClass
	public static void setup() throws URISyntaxException {
		if (testSpace != null) {
			return;
		}

		startServer();

		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				createTestProjectSapce();
			}
		});

	}

	private static void startServer() {

		ServerConfiguration.setTesting(true);
		new Thread(new EmfStoreController()).start();

	}

	/**
	 * Create test project space.
	 */
	private static void createTestProjectSapce() {

		boolean createRandomProject = false;

		if (createRandomProject) {
			createRandomTestProjet();
		} else {

			try {
				// use already created random project with parameter(100, randomSeed, 5, 5, 10, 20)
				// testSpace = currentWorkspace.importProject("/TestProjects/randomProj.ucp");
				// String path = "TestProjects/randomProject";
				String path = "TestProjects/unicase.ucp";

				// use unicase project
				String uriString = Activator.getDefault().getBundle().getLocation() + path;
				if (File.separator.equals("/")) {
					uriString = uriString.replace("reference:file:", "");

				} else {
					uriString = uriString.replace("reference:file:/", "");
				}

				testSpace = workSpace.importProject(uriString);

				testProjectBackup = testSpace.getProject();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Before every test make sure test project and compare project (which lies on the server) are equal.
	 */
	@Before
	public void resetCompareProject() {
		// if a compare project already exists on the server {
		// this is only in first test not the case!
		// delete compare project on the server
		// }
		testProject = (Project) EcoreUtil.copy(testProjectBackup);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				((ProjectSpaceImpl) getTestProjectSpace()).stopChangeRecording();

				getTestProjectSpace().setProject(testProject);

				getTestProjectSpace().init();
			}
		});

		shareProject();
		projectId = getTestProjectSpace().getProjectId();
	}

	/**
	 * This shares test project with server.
	 */
	private static void shareProject() {
		if (usersession == null) {
			usersession = WorkspaceFactory.eINSTANCE.createUsersession();

			ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
			serverInfo.setPort(1099);
			serverInfo.setUrl("127.0.0.1");

			usersession.setServerInfo(serverInfo);
			usersession.setUsername("super");
			usersession.setPassword("super");

		}

		try {
			if (!usersession.isLoggedIn()) {
				usersession.logIn();
			}

			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						getTestProjectSpace().shareProject(usersession);

					} catch (EmfStoreException e) {
						e.printStackTrace();
					}
				}
			});

		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Commits the changes to server.
	 */
	public void commitChanges() {
		final LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setMessage("some message");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				System.out.println(TestHelper.getChangePackage(getTestProjectSpace().getOperations(), true, false)
					.getOperations().size()
					+ " operations.");
				try {
					getTestProjectSpace().commit(logMessage);
					System.out.println("commit successful!");
				} catch (NoLocalChangesException e) {
					// do nothing
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * 
	 */
	private static void createRandomTestProjet() {
		// TODO
		// testSpace = TestHelper.createEmptyProjectSpace("test");
		// ....

	}

	/**
	 * @return the testSpace
	 */
	public static ProjectSpace getTestProjectSpace() {
		return testSpace;
	}

	/**
	 * @return the testProject
	 */
	public static Project getTestProject() {
		return testProject;
	}

	/**
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public static Project getCompareProject() throws EmfStoreException {

		Project comparePrject = ((WorkspaceImpl) WorkspaceManager.getInstance().getCurrentWorkspace()).checkout(
			usersession, projectId);
		return comparePrject;
	}

	/**
	 * cleans server and workspace after tests are run.
	 */
	@After
	public void cleanUp() {
		executedTestsCounter++;
		if (executedTestsCounter == 14) {
			doCleanUp();
		}
	}

	private void doCleanUp() {
		String serverPath = ServerConfiguration.getServerHome();
		File serverDirectory = new File(serverPath);
		FileFilter filter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("project-");
			}

		};
		File[] filesToDelete = serverDirectory.listFiles(filter);
		for (int i = 0; i < filesToDelete.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDelete[i]);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		new File(serverPath + "storage.uss").delete();
		
		String workspacePath = Configuration.getWorkspaceDirectory();
		File workspaceDirectory = new File(workspacePath);
		FileFilter filter2 = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("ps-");
			}

		};
		File[] filesToDelete2 = workspaceDirectory.listFiles(filter2);
		for (int i = 0; i < filesToDelete2.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDelete2[i]);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		new File(workspacePath + "workspace.ucw").delete();
		
		
	}
}
