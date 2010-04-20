/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.updater;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.unicase.workspace.Usersession;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.workspace.exceptions.NoChangesOnServerException;

import config.ConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;

/**
 * Project update handler.
 * 
 * @author Fatih Ulusoy
 */
public class ProjectUpdater implements UpdateObserver, Runnable {
	
	private Usersession usersession;
	
	private ProjectSpace projectSpace;
	
	private ServerUrl serverUrl;
	
	private ProjectUrlFragment projectUrlFrag;
	
	/**
	 * The constructor.
	 * 
	 * @param projectName Name of the project to be updated.
	 */
	public ProjectUpdater(String projectName) {
		serverUrl = createServerUrl();
		projectUrlFrag = createProjectUrlFragment(projectName);
		usersession = getUsersession(serverUrl.getHostName());
		
		// TODO: use more efficient to retrieve project
		List<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
			.getCurrentWorkspace().getProjectSpaces();
		
		for (ProjectSpace projSpace : projectSpaces) {
			if ((projSpace.getProjectName() != null)
					&& projSpace.getProjectName().equals(projectName)) {
				projectSpace = projSpace;
			}
		}
	}
	
	private ServerUrl createServerUrl() {
		ServerUrl serverUrl = UrlFactory.eINSTANCE.createServerUrl();
		
		EMFServerSettingsConfigEntity configEntity = new EMFServerSettingsConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		
		serverUrl.setHostName((String) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_URL));
		serverUrl.setPort((Integer) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_PORT));

		return serverUrl;
	}

	private ProjectUrlFragment createProjectUrlFragment(String projectName) {
		ProjectUrlFragment projUrlFrag = UrlFactory.eINSTANCE.createProjectUrlFragment();
		projUrlFrag.setName(projectName);
		return projUrlFrag;
	}
	
	private Usersession getUsersession(String serverUrl) {
		Usersession currSession = null;
		EList<Usersession> sessions = WorkspaceManager.getInstance()
			.getCurrentWorkspace().getUsersessions();
		
		for(Usersession session: sessions){
			if(session.getServerInfo().getUrl().equals(serverUrl)){
				 currSession = session;
			}	
		}
		
		return currSession;
	}

	/**
	 * 
	 */
	public void run() {
		
		if (projectSpace == null) {
			checkoutProjectFromServer();
		}

		update(projectSpace);
		System.out.println(new Date());
	}
	
	/**
	 * Checks out the project from server.
	 */
	private void checkoutProjectFromServer() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ProjectFacade projectFacade = ProjectFacade.getInstance();
				projectSpace = projectFacade.checkoutProjectFromServer(serverUrl, projectUrlFrag);
			}
		}.run();
	}
	

	/**
	 * Updates the projectspace.
	 * 
	 * @param projectSpace the target project space
	 */
	private void update(final ProjectSpace projectSpace) {
		
		if (projectSpace == null) {
			return;
		}
		
		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			System.out.println("This project is not yet shared with a server, you cannot update.");
			return;
		}
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					PrimaryVersionSpec baseVersion = projectSpace.getBaseVersion();
					PrimaryVersionSpec targetVersion = projectSpace.update(VersionSpec.HEAD_VERSION,
						ProjectUpdater.this);
					WorkspaceUtil.logUpdate(projectSpace, baseVersion, targetVersion);

				} catch (ChangeConflictException e1) {
					handleChangeConflictException(e1);
					// TODO : what should we do if there conflict occurs?
					// maybe, we can delete the project and check out new one???
				} catch (NoChangesOnServerException e) {
					System.out
						.println("No need to update\n" + "Your project is up to date, you do not need to update.");
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("Error during the project update.", e);
				}
			}
		}.run();
	}

	/**
	 * Conflict resolver opens dialog to get user's decision. In web application, we don't
	 * open any dialog. Therefore, this method makes nothing. 
	 * 
	 * @param conflictException
	 */
	private void handleChangeConflictException(ChangeConflictException conflictException) {
		
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(List<ChangePackage> changePackages) {
		// don't need to user approve. There is no real user in web application.
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#updateCompleted()
	 */
	public void updateCompleted() {
		System.out.println("Update completed...");
	}

}


