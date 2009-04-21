/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.integration;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
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
import org.unicase.workspace.test.Activator;

/**
 * @author Hodaie
 */
public abstract class IntegrationTestCase {

	private ProjectSpace testSpace;
	private Project testProject;
	private Project compareProject;

	private static Usersession usersession;
	private static TransactionalEditingDomain domain;

	private ProjectId projectId;
	private static Workspace workSpace;

	/**
	 * set up test project.
	 * 
	 * @throws URISyntaxException URISyntaxException
	 */
	@BeforeClass
	public static void startServer() throws URISyntaxException {
		if (workSpace != null) {
			return;
		}

		ServerConfiguration.setTesting(true);
		new Thread(new EmfStoreController()).start();

		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

	}

	/**
	 * Before every test import test project and share it on the server.
	 */
	@Before
	public void setup() {

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				createTestProjectSapce();
			}
		});

		shareProject();
		projectId = getTestProjectSpace().getProjectId();
	}

	/**
	 * Create test project space.
	 */
	private void createTestProjectSapce() {

		try {
			String path;

			// use a random generated project (with about 6000 elements) with these parameter(10, 12345, 5, 3, 15, 20)
			// path = "TestProjects/randomProject6";

			// use a random generated project (with about 8000 elements) with these parameter(15, 12345, 5, 3, 15, 20)
			// path = "TestProjects/randomProject8";

			// use a random generated project (with about 12000 elements) with these parameter(20, 12345, 5, 5, 10, 20)
			// path = "TestProjects/randomProject12";

			// use a random generated project (with about 14000 elements) with these parameter(30, 123, 5, 5, 10, 20)
			// path = "TestProjects/randomProject14";

			// use a random generated project (with about 25000 elements) with these parameter(70, 123, 5, 5, 10, 20)
			// path = "TestProjects/randomProject25";

			// use dolli2 project
			// path = "TestProjects/dolli2.ucp";

			// use unicase project
			path = "TestProjects/unicase.ucp";

			String uriString = Activator.getDefault().getBundle().getLocation() + path;
			if (File.separator.equals("/")) {
				uriString = uriString.replace("reference:file:", "");

			} else {
				uriString = uriString.replace("reference:file:/", "");
			}

			testSpace = workSpace.importProject(uriString);

			testProject = testSpace.getProject();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This shares test project with server.
	 */
	private void shareProject() {
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
	 * @return the testSpace
	 */
	public ProjectSpace getTestProjectSpace() {
		return testSpace;
	}

	/**
	 * @return the testProject
	 */
	public Project getTestProject() {
		return testProject;
	}

	/**
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public Project getCompareProject() throws EmfStoreException {

		// Project compareProject = ((WorkspaceImpl)
		// WorkspaceManager.getInstance().getCurrentWorkspace()).checkout(usersession, projectId);

		final ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("CompareProject");
		projectInfo.setDescription("compare project description");
		projectInfo.setProjectId(projectId);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					compareProject = WorkspaceManager.getInstance().getCurrentWorkspace().checkout(usersession,
						projectInfo).getProject();
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		return compareProject;
	}

	/**
	 * cleans server and workspace after tests are run.
	 */
	@After
	public void cleanUp() {
		String serverPath = ServerConfiguration.getServerHome();
		File serverDirectory = new File(serverPath);
		FileFilter serverFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("project-");
			}

		};
		File[] filesToDeleteOnServer = serverDirectory.listFiles(serverFileFilter);
		for (int i = 0; i < filesToDeleteOnServer.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDeleteOnServer[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(serverPath + "storage.uss").delete();

		String workspacePath = Configuration.getWorkspaceDirectory();
		File workspaceDirectory = new File(workspacePath);
		FileFilter workspaceFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("ps-");
			}

		};
		File[] filesToDelete2 = workspaceDirectory.listFiles(workspaceFileFilter);
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
