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

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.test.SetupHelper;

/**
 * @author Hodaie
 */
public abstract class IntegrationTestCase {

	// private ProjectSpace testSpace;
	//private Project testProject;
	//private Project compareProject;

	//private static Usersession usersession;

	//private ProjectId projectId;

	/**
	 * set up test project.
	 * 
	 * @throws URISyntaxException URISyntaxException
	 */
	@BeforeClass
	public static void startServer() throws URISyntaxException {
		if (SetupHelper.getWorkSpace() != null) {
			return;
		}

		SetupHelper.startSever();

		

	}

	/**
	 * Before every test import test project and share it on the server.
	 */
	@Before
	public void setup() {

		SetupHelper.setupWorkSpace();
		
		SetupHelper.createTestProjectSapce();
		
		SetupHelper.shareProject();

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

	
	

	

	/**
	 * @return the testProject
	 */
	public Project getTestProject() {
		return SetupHelper.getTestProject();
	}

	/**
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public Project getCompareProject() throws EmfStoreException {
		return SetupHelper.getCompareProject();
		
	}
	
	/**
	 * Commits changes.
	 */
	protected void commitChanges(){
		SetupHelper.commitChanges();
	}

}
