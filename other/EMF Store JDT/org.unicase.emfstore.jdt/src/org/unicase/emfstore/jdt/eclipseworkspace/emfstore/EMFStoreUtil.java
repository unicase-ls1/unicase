/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace.emfstore;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommandWithResult;
import org.eclipse.emf.emfstore.client.ui.commands.UpdateProjectVersionHandler;
import org.eclipse.emf.emfstore.client.ui.dialogs.LoginDialog;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.accesscontrol.AccessControlImpl;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.SessionTimedOutException;
import org.eclipse.emf.emfstore.server.exceptions.UnknownSessionException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.exception.ProjectInfoNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;

/**
 * Utility class to handle with an EMF Store.
 * 
 * @author Adrian Staudt
 */
public final class EMFStoreUtil {

	private EMFStoreUtil() {
	}

	/**
	 * Gets a wanted ProjectSpace by defining its remote and local location.
	 * 
	 * @param serverInfo A server info.
	 * @param projectInfo A project info.
	 * @return A ProjectSpace.
	 * @throws ProjectSpaceNotFoundException Will be thrown if the ProjectSpace is not locally available.
	 */
	public static ProjectSpace getProjectSpace(ServerInfo serverInfo, ProjectInfo projectInfo)
		throws ProjectSpaceNotFoundException {
		String projectID = projectInfo.getProjectId().getId();
		EList<ProjectSpace> localProjectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getProjectSpaces();
		for (ProjectSpace localProjectSpace : localProjectSpaces) {
			boolean isSame = true;

			// compare projectIDs
			isSame = projectID.equals(localProjectSpace.getProjectId().getId()) & isSame;
			if (!isSame) {
				continue;
			}

			// projectID match together - check also if it is the same user name
			isSame = localProjectSpace.getUsersession().getUsername()
				.equals(serverInfo.getLastUsersession().getUsername())
				& isSame;
			if (!isSame) {
				continue;
			}

			// check now if there are stored on the same server location
			ServerInfo localProjectSpaceServerInfo = localProjectSpace.getUsersession().getServerInfo();

			// host
			isSame = serverInfo.getUrl().equals(localProjectSpaceServerInfo.getUrl()) & isSame;
			if (!isSame) {
				continue;
			}

			// port
			isSame = serverInfo.getPort() == localProjectSpaceServerInfo.getPort() & isSame;
			if (!isSame) {
				continue;
			}

			// certificate
			isSame = serverInfo.getCertificateAlias().equals(localProjectSpaceServerInfo.getCertificateAlias())
				& isSame;
			if (!isSame) {
				continue;
			}

			// passed all matching tests
			return localProjectSpace;
		}

		throw new ProjectSpaceNotFoundException();
	}

	/**
	 * Checks out a project and returns its ProjectSpace.
	 * 
	 * @param usersession A valid usersession.
	 * @param projectInfo A project info to identify the wanted project to be checked out.
	 * @return A ProjectSpace.
	 * @throws ProjectInfoNotFoundException Will be thrown if the ProjectInfo is unknown.
	 */
	public static ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo)
		throws ProjectInfoNotFoundException {
		return checkout(usersession, projectInfo, null);
	}

	/**
	 * Checks out a project in a certain version and returns its ProjectSpace.
	 * 
	 * @param usersession A valid usersession.
	 * @param projectInfo A project info to identify the wanted project to be checked out.
	 * @param emfStoreRevision A target revision.
	 * @return A ProjectSpace.
	 * @throws ProjectInfoNotFoundException Will be thrown if the ProjectInfo is unknown.
	 */
	public static ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo, Integer emfStoreRevision)
		throws ProjectInfoNotFoundException {
		ProjectSpace projectSpace = new CheckoutProjectSpaceCommand(usersession, projectInfo, emfStoreRevision)
			.run(false);

		if (projectSpace != null) {
			return projectSpace;
		}
		throw new ProjectInfoNotFoundException();
	}

	/**
	 * Returns a ServerInfo by a StructuredEMFStoreURI.
	 * 
	 * @param structuredEMFStoreURI A structured EMF Store URI.
	 * @return A ServerInfo.
	 */
	public static ServerInfo getServerInfo(final StructuredEMFStoreURI structuredEMFStoreURI) {
		final Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		EList<ServerInfo> serverInfos = workspace.getServerInfos();
		for (ServerInfo serverInfo : serverInfos) {
			if (structuredEMFStoreURI.equals(serverInfo)) {
				return serverInfo;
			}
		}

		// the required ServerInfo wasn't found. Create this ServerInfo.
		ServerInfo serverInfo = new UnicaseCommandWithResult<ServerInfo>() {
			@Override
			protected ServerInfo doRun() {
				ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
				serverInfo.setName(structuredEMFStoreURI.getHost());
				serverInfo.setUrl(structuredEMFStoreURI.getHost());
				serverInfo.setPort(structuredEMFStoreURI.getPort());
				serverInfo.setCertificateAlias(structuredEMFStoreURI.getCertificate());

				workspace.getServerInfos().add(serverInfo);
				workspace.save();

				return serverInfo;
			}
		}.run(false);

		return serverInfo;
	}

	/**
	 * Updates the ProjectSpace to the head version.
	 * 
	 * @param projectSpace The project space that should be updated.
	 */
	public static void update(final ProjectSpace projectSpace) {
		update(projectSpace, null);
	}

	/**
	 * Updates a ProjectSpace to a defined version. If the target version is missing, the ProjectSpace will be updated
	 * to the HEAD version.
	 * 
	 * @param projectSpace The project space that should be updated.
	 * @param emfStoreRevision The target version number. Can be null, than the HEAD version is assumed.
	 */
	public static void update(final ProjectSpace projectSpace, final Integer emfStoreRevision) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				new UpdateProjectSpaceCommand(projectSpace, emfStoreRevision).run(false);
			}
		});
	}

	/**
	 * Returns the current checked out revision of an project space.
	 * 
	 * @param projectSpace The project space.
	 * @return The current revision.
	 */
	public static int getLocalProjectSpaceRevision(ProjectSpace projectSpace) {
		PrimaryVersionSpec baseVersion = projectSpace.getBaseVersion();
		int localVersion = baseVersion.getIdentifier();
		return localVersion;
	}

	/**
	 * Checks if the usersession is still valid.
	 * 
	 * @param usersession The usersession that has to be verified.
	 */
	public static void checkSanity(final Usersession usersession) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				new SanityCheckCommand(usersession).run(false);
			}
		});
	}

	/**
	 * A UnicaseCommand to checkout a project.
	 */
	private static final class CheckoutProjectSpaceCommand extends UnicaseCommandWithResult<ProjectSpace> {

		private final Usersession usersession;
		private final ProjectInfo projectInfo;
		private final Integer emfStoreRevision;

		private CheckoutProjectSpaceCommand(Usersession usersession, ProjectInfo projectInfo, Integer emfStoreRevision) {
			this.usersession = usersession;
			this.projectInfo = projectInfo;
			this.emfStoreRevision = emfStoreRevision;
		}

		@Override
		protected ProjectSpace doRun() {
			try {
				String projectID = projectInfo.getProjectId().getId();
				List<ProjectInfo> remoteProjectList = usersession.getRemoteProjectList();
				for (ProjectInfo remoteProjectInfo : remoteProjectList) {
					if (remoteProjectInfo.getProjectId().getId().equals(projectID)) {
						ProjectSpace projectSpace;
						if (emfStoreRevision == null) {
							projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
								.checkout(usersession, remoteProjectInfo);

						} else {
							PrimaryVersionSpec version = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
							version.setIdentifier(emfStoreRevision);
							projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
								.checkout(usersession, remoteProjectInfo, version);
						}

						return projectSpace;
					}
				}

			} catch (EmfStoreException e) {
				// TODO: LogException
				e.printStackTrace();
			}

			return null;
		}
	}

	/**
	 * A UnicaseCommand to update a project to a certain version.
	 */
	private static final class UpdateProjectSpaceCommand extends UnicaseCommand {

		private final ProjectSpace projectSpace;
		private final Integer emfStoreRevision;

		private UpdateProjectSpaceCommand(ProjectSpace projectSpace, Integer emfStoreRevision) {
			this.projectSpace = projectSpace;
			this.emfStoreRevision = emfStoreRevision;
		}

		@Override
		protected void doRun() {
			try {
				VersionSpec targetVersion;
				if (emfStoreRevision == null) {
					targetVersion = VersionSpec.HEAD_VERSION;

				} else {
					PrimaryVersionSpec targetPrimaryVersion = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					targetPrimaryVersion.setIdentifier(emfStoreRevision);
					targetVersion = targetPrimaryVersion;
				}

				// Check if it is necessary to update to the target version.
				PrimaryVersionSpec resolvedTargetVersion = projectSpace.resolveVersionSpec(targetVersion);
				PrimaryVersionSpec baseVersion = projectSpace.getBaseVersion();
				if (resolvedTargetVersion.compareTo(baseVersion) == 0) {
					// nothing to update
					return;
				}

				UpdateProjectVersionHandler updateProjectVersionHandler = new EMFStoreJDTUpdateProjectVersionHandler();
				updateProjectVersionHandler.update(projectSpace, resolvedTargetVersion);

			} catch (EmfStoreException e) {
				ModelUtil.logException(e);
			}
		}
	}

	/**
	 * A UnicaseCommand that checks if the usersession is still valid.
	 */
	private static final class SanityCheckCommand extends UnicaseCommand {

		private final Usersession usersession;

		private SanityCheckCommand(Usersession usersession) {
			this.usersession = usersession;
		}

		@Override
		protected void doRun() {
			Shell activeShell = Display.getDefault().getActiveShell();

			try {
				// usersession.isLoggedIn() is not enough,
				// UnknownSessionException "Session unknown to Connection manager" can regardless occur
				AccessControlImpl access = new AccessControlImpl(null);
				access.checkSession(usersession.getSessionId());

			} catch (EmfStoreException e) {
				if (e instanceof UnknownSessionException || e instanceof SessionTimedOutException) {
					try {
						usersession.logIn();

					} catch (AccessControlException ex) {
						if (ex.getMessage().equals("Username or Password not set!")) {
							LoginDialog loginDialog = new LoginDialog(activeShell, usersession,
								usersession.getServerInfo());
							loginDialog.open();
						}

					} catch (EmfStoreException ex) {
						if (ex.getMessage().equals("Server could not be reached.")) {
							LoginDialog loginDialog = new LoginDialog(activeShell, usersession,
								usersession.getServerInfo());
							loginDialog.open();
						}
					}

				} else {
					ModelUtil.logException(e);
				}

			} catch (FatalEmfStoreException e) {
				ModelUtil.logException(e);
			}
		}
	};

}
