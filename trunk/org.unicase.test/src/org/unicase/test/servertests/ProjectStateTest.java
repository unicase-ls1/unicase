package org.unicase.test.servertests;

import java.util.Iterator;
import java.util.List;

import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
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
				if (pI.getName().contains("DOLLI2")) {

					PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					source.setIdentifier(0);
					PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					target.setIdentifier(50);
					Project project = connectionManager.getProject(sessionId, pI.getProjectId(), target);

					Project Project = connectionManager.getProject(sessionId, pI.getProjectId(), target);
					List<ChangePackage> changes = connectionManager.getChanges(sessionId, pI.getProjectId(), source,
						target);

					int i = 0;
					boolean found = false;
					for (ChangePackage changePackage : changes) {
						Iterator<AbstractOperation> iter = changePackage.getOperations().iterator();
						while (iter.hasNext()) {
							AbstractOperation abstractOperation = iter.next();
							if (abstractOperation instanceof CreateDeleteOperation) {
								if (abstractOperation.getModelElementId().getId().equals("__q0UYJUkEd2FG-kzr70dNg")) {
									System.out.println("Version: " + i + " delete found");
									if (false && found) {
										iter.remove();
									} else {
										found = true;
									}
								}
							}
						}
						target.setIdentifier(i);
						// connectionManager.setChangePackage(sessionId, changePackage, pI.getProjectId(), target);
						i++;
					}

					// for (int i = 1; i < pI.getVersion().getIdentifier(); i++) {
					// Project nextProject = connectionManager.getProject(sessionId, pI.getProjectId(), target);
					//
					// List<ChangePackage> changes = connectionManager.getChanges(sessionId, pI.getProjectId(),
					// source, target);
					//
					// if (changes.size() == 0) {
					// System.out.println("no changes");
					// System.exit(0);
					// }
					//						
					// changes.get(0).apply(project);
					//						
					// int[] linearCompare = ChangeTestHelper.linearCompare(project, nextProject);
					// if (linearCompare[0] != 1) {
					// System.out.println("collision between" + source.getIdentifier() + " and "
					// + primaryVersionSpec.getIdentifier());
					// System.exit(0);
					// }
					// project = nextProject;
					// System.out.println("CHECKED: " + source.getIdentifier() + " and "
					// + target.getIdentifier());
					// }

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
	//
	// private void getProjectStates(ProjectInfo pi) {
	// PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
	// for (int i = 1350; i <= pi.getVersion().getIdentifier(); i++) {
	// primaryVersionSpec.setIdentifier(i);
	// try {
	// System.out.print("getting version " + i + ": ");
	// Project project = connectionManager.getProject(sessionId, pi.getProjectId(), primaryVersionSpec);
	// System.out.println(project);
	// } catch (NullPointerException e) {
	// e.printStackTrace();
	// } catch (EmfStoreException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// }

	@Override
	public void outputResults(boolean outputToFile) {

	}
}
