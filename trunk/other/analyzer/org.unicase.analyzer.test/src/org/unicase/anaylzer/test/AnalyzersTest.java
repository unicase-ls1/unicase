/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.anaylzer.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;

/**
 * Superclass for Analyzer Test.
 * 
 * @author liya
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
	public static void init() {

		// SetupHelper.startSever();
		setupHelper = new SetupHelper(TestProjectEnum.SUPERMARKET);
		SetupHelper.setupServerSpace();

		setupHelper.equals(null);

	}

	/**
	 * Get the project list on the test server.
	 * 
	 * @throws EmfStoreException problems occur when connecting to the server.
	 */
	@Before
	public void setup() throws EmfStoreException {
		setupHelper.loginServer();
		userSession = setupHelper.getUsersession();
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		projectList = connectionManager.getProjectList(userSession.getSessionId());
		if (projectList.size() == 0) {
			System.out.println("no projects on server.");
		}
	}

	/**
	 * Compare the list of {@link ChangePackage}.
	 * 
	 * @param projectId ProjectId
	 * @param data ProjectAnalysisData
	 * @param startPoint the version number to start with
	 * @param endPoint the version number to end with
	 * @param isForward true if iterate forwardly
	 * @return true if the list of ChangePackage from the {@link ProjectAnalysisData} and the one got from
	 *         {@link ConnectionManager} are the equal.
	 * @throws EmfStoreException problems occur when connecting to the server.
	 */
	public boolean compareChangePackage(ProjectId projectId, ProjectAnalysisData data, int startPoint, int endPoint,
		boolean isForward) throws EmfStoreException {
		List<ChangePackage> changePackageA = data.getChangePackages();
		List<ChangePackage> changePackageB = null;
		if (isForward) {
			PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			start.setIdentifier(startPoint);
			PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			end.setIdentifier(endPoint);

			changePackageB = connectionManager.getChanges(userSession.getSessionId(), projectId, start, end);

		} else {
			PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			start.setIdentifier(startPoint - 1);
			PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			if (endPoint > 0) {
				end.setIdentifier(endPoint - 1);
			} else {
				end.setIdentifier(0);
			}

			changePackageB = connectionManager.getChanges(userSession.getSessionId(), projectId, start, end);

		}
		if (changePackageA.size() != changePackageB.size()) {
			return false;
		} else {
			int i = 0;
			boolean dateIsEqual = true;
			while (i < changePackageA.size() && dateIsEqual) {
				Date dateA = changePackageA.get(i).getLogMessage().getDate();
				Date dateB = changePackageB.get(i).getLogMessage().getDate();
				dateIsEqual = dateA.equals(dateB);
				i++;
			}
			return dateIsEqual;
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
