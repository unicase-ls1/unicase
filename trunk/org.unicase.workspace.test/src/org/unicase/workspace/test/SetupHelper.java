/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.test.integration.IntegrationTestHelper;

/**
 * Helper class for test fixtures.
 * 
 * @author hodaie
 */
public final class SetupHelper {

	private static TransactionalEditingDomain domain;
	private static Workspace workSpace;
	private static ProjectSpace testProjectSpace;
	private static Project testProject;
	private static Usersession usersession;
	private static ProjectId projectId;
	private static Project compareProject;

	private SetupHelper() {
	}

	/**
	 * Starts the server.
	 */
	public static void startSever() {
		try {
			ServerConfiguration.setTesting(true);
			Properties properties = ServerConfiguration.getProperties();
			properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.FALSE);
			EmfStoreController.runAsNewThread();
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the server.
	 */
	public static void stopServer() {
		EmfStoreController server = EmfStoreController.getInstance();
		if (server != null) {
			server.stop();
		}

	}

	/**
	 * Setups server space.
	 */
	public static void setupSeverSpace() {

	}

	/**
	 * Setups workspace.
	 */
	public static void setupWorkSpace() {

		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

	}

	/**
	 * Setups a new project space.
	 */
	public static void setupProjectSpace() {

	}

	/**
	 * Cleans server up.
	 */
	public static void cleanupServer() {

	}

	/**
	 * Cleans workspace up.
	 */
	public static void cleanupWorkspace() {

	}

	/**
	 * @return workspace
	 */
	public static Workspace getWorkSpace() {
		return workSpace;
	}

	/**
	 * @return editing domain
	 */
	public static TransactionalEditingDomain getDomain() {
		return domain;
	}

	/**
	 * Imports a project space from an exported project space file.
	 * 
	 * @param uri path to an exported project file
	 * @return project space
	 * @throws IOException IOException
	 */
	public static ProjectSpace importProject(String uri) throws IOException {
		return workSpace.importProjectSpace(uri);
		
	}

	/**
	 * Create test project space.
	 */
	public static void createTestProjectSapce() {

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

			testProjectSpace = SetupHelper.importProject(uriString);

			testProject = testProjectSpace.getProject();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	/**
	 * This shares test project with server.
	 */
	public static void shareProject() {
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

			SetupHelper.getDomain().getCommandStack().execute(new RecordingCommand(SetupHelper.getDomain()) {
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
	public static void commitChanges() {
		final LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setMessage("some message");
		SetupHelper.getDomain().getCommandStack().execute(new RecordingCommand(SetupHelper.getDomain()) {
			@Override
			protected void doExecute() {
				System.out.println(IntegrationTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true,
					false).getOperations().size()
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
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public static Project getCompareProject() throws EmfStoreException {

		final ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("CompareProject");
		projectInfo.setDescription("compare project description");
		projectInfo.setProjectId(projectId);
		SetupHelper.getDomain().getCommandStack().execute(new RecordingCommand(SetupHelper.getDomain()) {

			@Override
			protected void doExecute() {
				try {
					compareProject = WorkspaceManager.getInstance().getCurrentWorkspace().checkout(usersession,
						projectInfo).getProject();
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}

		});
		return compareProject;
	}



	/**
	 * @return the testProject
	 */
	public static Project getTestProject() {
		return testProject;
	}

	/**
	 * 
	 * @return test project space
	 */
	public static ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}

}
