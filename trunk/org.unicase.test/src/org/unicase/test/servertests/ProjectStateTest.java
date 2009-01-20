package org.unicase.test.servertests;

import java.util.List;

import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.test.TestCase;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

public class ProjectStateTest extends TestCase {

	private SessionId sessionId;
	private ConnectionManager connectionManager;

	public ProjectStateTest(String testName, SessionId sessionId) {
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
				if (pI.getName().contains("unicase")) {
					// getChanges(pI, false);
					// getChanges(pI, true);
					getProjectStates(pI);

				}
			}
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
	}

	// private void getChanges(ProjectInfo pi, boolean turned) {
	// PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
	// primaryVersionSpec.setIdentifier(0);
	// try {
	//
	// List<ChangePackage> changes = null;
	//
	// if (turned) {
	// changes = connectionManager.getChanges(sessionId, pi.getProjectId(), pi.getVersion(),
	// primaryVersionSpec);
	// } else {
	// changes = connectionManager.getChanges(sessionId, pi.getProjectId(), primaryVersionSpec, pi
	// .getVersion());
	// }
	//
	// int i = 1;
	// for (ChangePackage cp : changes) {
	// System.out.println("change " + (i++) + ": " + cp.getLogMessage().getDate());
	// }
	// } catch (EmfStoreException e) {
	// e.printStackTrace();
	// }
	// }

	private void getProjectStates(ProjectInfo pi) {
		PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		for (int i = 1350; i <= pi.getVersion().getIdentifier(); i++) {
			primaryVersionSpec.setIdentifier(i);
			try {
				System.out.print("getting version " + i + ": ");
				Project project = connectionManager.getProject(sessionId, pi.getProjectId(), primaryVersionSpec);
				System.out.println(project);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (EmfStoreException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void outputResults(boolean outputToFile) {

	}
}
