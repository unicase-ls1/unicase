/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.intergerationtest.tests;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.BeforeClass;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.Activator;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Hodaie
 */
public abstract class IntegrationTestCase {

	private static ProjectSpace testSpace;
	private static Project testProject;

	private static Usersession usersession;
	private static TransactionalEditingDomain domain;

	private static ProjectId projectId;
	private static long randomSeed = 1;
	private static Workspace workSpace;


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

	/**
	 * Create test project space.
	 */
	private static void createTestProjectSapce() {

		boolean createRandomProject = false;

		
		TestHelper.setRandom(new Random(randomSeed));

		if (createRandomProject) {
			createRandomTestProjet();
		} else {

			try {
				// use already created random project with parameter(100, randomSeed, 5, 5, 10, 20)
				// testSpace = currentWorkspace.importProject("/TestProjects/randomProj.ucp");

				// use unicase project
				String uriString = Activator.getDefault().getBundle().getLocation() + "TestProjects/unicase.ucp";
				uriString = uriString.replace("reference:file:/", "");
				testSpace = workSpace.importProject(uriString);

				testProject = testSpace.getProject();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		
		shareProject();
		projectId = getTestProjectSpace().getProjectId();
	}

	/**
	 * This shares test project with server.
	 */
	private static void shareProject() {
		usersession = WorkspaceFactory.eINSTANCE.createUsersession();

		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("127.0.0.1");

		usersession.setServerInfo(serverInfo);
		usersession.setUsername("super");
		usersession.setPassword("super");

		try {
			usersession.logIn();
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
		testSpace = TestHelper.createEmptyProjectSpace("test");

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
		 
		Project comparePrject = ((WorkspaceImpl) WorkspaceManager.getInstance().getCurrentWorkspace()).checkout(usersession, projectId);
		return comparePrject;
	}
}
