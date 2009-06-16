/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.anaylzer.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;


/**
 * Superclass for Analyzer Test.
 * @author liya
 *
 */
public class AnalyzersTest {
	
	private static SetupHelper setupHelper;
	
	private Usersession userSession;
	private ConnectionManager connectionManager;
	private List<ProjectInfo> projectList;



	/**
	 * Set up the server.
	 */
	@BeforeClass
	public static void init()  {
		
	  //SetupHelper.startSever();
	  setupHelper = new SetupHelper(TestProjectEnum.NONE);
	  SetupHelper.setupServerSpace();
	  
	  setupHelper.equals(null);
		  
	}

	/**
	 * Get the project list on the test server.
	 */
	@Before
	public void setup() {
		setupHelper.loginServer();
		userSession = setupHelper.getUsersession();
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		try {
			projectList = connectionManager.getProjectList(userSession.getSessionId());
			if (projectList.size() == 0) {
				System.out.println("no projects on server.");
			}
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 
	 */
	@After
	public void cleanUp() {
		
		// here the code that must be run after every test case
	
	}

	/**
	 * @return the userSession
	 */
	public Usersession getUserSession() {
		return userSession;
	}
	

	/**
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}
	
	/**
	 * @return the projectList
	 */
	public List<ProjectInfo> getProjectList() {
		return projectList;
	}

}
