/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.test.servertests.analyser;

import java.util.List;

import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.test.TestCase;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * @author liya
 */
public class AnalyserTest extends TestCase {

	private ConnectionManager connectionManager;
	private SessionId sessionId;

	/**
	 * @param testName String
	 * @param sessionId SessionId
	 */
	public AnalyserTest(String testName, SessionId sessionId) {
		super(testName);

		this.sessionId = sessionId;
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();

	}

	/**
	 * @see org.unicase.test.TestCase#runTest()
	 */
	@Override
	public void runTest() {
		try {
			List<ProjectInfo> projectList = connectionManager.getProjectList(sessionId);
			if (projectList.size() == 0) {
				System.out.println("no projects on server.");
			}
			for (ProjectInfo pI : projectList) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				if (pI.getName().contains("test")) {
					@SuppressWarnings("unused")
					ProjectAnalysisData projectData = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
					Usersession usersession = WorkspaceFactory.eINSTANCE.createUsersession();
					usersession.setSessionId(sessionId);
					PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					start.setIdentifier(3);
					PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					end.setIdentifier(-1);

					int stepLength = 2;
					VersionIterator projectIt = new VersionIterator(usersession, pI.getProjectId(), stepLength);
					int it = 1;
					while (projectIt.hasNext()) {
						projectData = projectIt.next();
						System.out.println("At Iteration:" + it);
						it++;
					}
				}
			}
		} catch (EmfStoreException e) {
			e.printStackTrace();
		} catch (IteratorException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see org.unicase.test.TestCase#outputResults(boolean)
	 * @param outputToFile boolean
	 */
	@Override
	public void outputResults(boolean outputToFile) {

	}
}
