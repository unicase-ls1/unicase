package org.unicase.changererecorder;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {

		// Before you use this method, you should deactivate containementcheck
		// in ModelUtil eObjecttoString and add the old apply method to
		// MultiReferenceOperation with an stacktrace based switch for create
		// version and you have to make
		// applyOperationsWithRecording to Public in the ProjectSpace.
		// Deactivate setDate from logmessage in server. modify creator name and
		// date step in projectchangetracker.

		final Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		final Usersession usersession = getUsersession();
		usersession.logIn();
		List<ProjectInfo> remoteProjectList = usersession
				.getRemoteProjectList();
		ProjectInfo tmpInfo = null;
		for (ProjectInfo projectInfo : remoteProjectList) {
			if (projectInfo.getProjectId().getId().equals(
					"_vJNjlI-jEd2NxKsJ-WbHVA")) {
				tmpInfo = projectInfo;
				break;
			}
		}

		final ProjectInfo info = tmpInfo;

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
							.createPrimaryVersionSpec();
					versionSpec.setIdentifier(0);
					info.setVersion(versionSpec);

					System.out.println("Checking out");
					ProjectSpace oldProjectSpace = currentWorkspace.checkout(
							usersession, info, versionSpec);
					ProjectSpace newProjectSpace = ((WorkspaceImpl) currentWorkspace)
							.importProject((Project) EcoreUtil
									.copy(oldProjectSpace.getProject()),
									oldProjectSpace.getProjectName(),
									oldProjectSpace.getProjectDescription());
					System.out.println("Sharing");
					newProjectSpace.shareProject(usersession);

					PrimaryVersionSpec from = VersioningFactory.eINSTANCE
							.createPrimaryVersionSpec();
					PrimaryVersionSpec too = VersioningFactory.eINSTANCE
							.createPrimaryVersionSpec();

					PrimaryVersionSpec headVersion = oldProjectSpace
							.resolveVersionSpec(VersionSpec.HEAD_VERSION);
					System.out.println("Starting: headVersion: "
							+ headVersion.getIdentifier());
					for (int i = 1; i <= headVersion.getIdentifier(); i++) {
						from.setIdentifier(i - 1);
						too.setIdentifier(i);
						HistoryQuery historyQuery = VersioningFactory.eINSTANCE
								.createHistoryQuery();
						historyQuery.setSource(from);
						historyQuery.setTarget(too);
						historyQuery.setIncludeChangePackage(true);
						List<HistoryInfo> historyInfo = usersession
								.getHistoryInfo(oldProjectSpace.getProjectId(),
										historyQuery);

						if (historyInfo == null
								|| historyInfo.size() != 2
								|| historyInfo.get(0).getChangePackage() == null) {
							throw new IllegalStateException();
						}

						LogMessage logMessage = historyInfo.get(0)
								.getLogMessage();
						ChangePackage changePackage = historyInfo.get(0)
								.getChangePackage();

						((ProjectSpaceImpl) newProjectSpace)
								.applyOperationsWithRecording(changePackage
										.getOperations(), true);
						newProjectSpace.commit(logMessage);
						System.out.print(".");
						if (i % 25 == 0) {
							System.out.println(" ");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}.run();
		return IApplication.EXIT_OK;
	}

	// private ProjectInfo getProjectInfo() {
	// ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
	// projectInfo.set
	//		
	// return null;
	// }

	public Usersession getUsersession() {
		Usersession usersession = WorkspaceFactory.eINSTANCE
				.createUsersession();
		ServerInfo serverInfo = getServerInfo();
		usersession.setServerInfo(serverInfo);
		usersession.setUsername("super");
		usersession.setPassword("super");
		return usersession;
	}

	public ServerInfo getServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("127.0.0.1");
		serverInfo
				.setCertificateAlias("unicase.org test test(!!!) certificate");
		return serverInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
