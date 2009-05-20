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

public class AnalyserTest extends TestCase {

	private ConnectionManager connectionManager;
	private SessionId sessionId;

	public AnalyserTest(String testName, SessionId sessionId) {
		super(testName);

		this.sessionId = sessionId;
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();

	}

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
					VersionIterator projectIt = new VersionIterator(usersession, pI.getProjectId(), stepLength, start,
						end, true, false);
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

	@Override
	public void outputResults(boolean outputToFile) {

	}
}
