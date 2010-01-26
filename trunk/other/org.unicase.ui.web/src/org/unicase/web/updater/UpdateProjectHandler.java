package org.unicase.web.updater;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.unicase.workspace.Usersession;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;

import org.unicase.web.util.Configuration;

/**
 * Project update handler.
 * 
 * @author Fatih Ulusoy
 */
public class UpdateProjectHandler implements UpdateObserver, Runnable {

	/** Default interval for project updates from emf-server. */
	private static int UPDATE_INTERVAL = 5 * 60 * 100;
	
	private Usersession usersession;
	
	private ProjectSpace projectSpace;
	
	private ServerUrl serverUrl;
	
	private ProjectUrlFragment projectUrlFrag;
	
	/**
	 * Default constructor.
	 */
	public UpdateProjectHandler(String projectName) {
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
		serverUrl.setHostName(Configuration.getProperties().getProperty("hostname"));
		try {
			serverUrl.setPort(Integer.parseInt(Configuration.getProperties().getProperty("port")));
		} catch (NumberFormatException e) {
			WorkspaceUtil.logException("Error on server port number:"
					+ Configuration.getProperties().getProperty("port"), e);
		}
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

	
	public void run() {
		try {
			UPDATE_INTERVAL = 60 * 10 * Integer.parseInt(Configuration
					.getProperties().getProperty("updateinterval"));
		} catch (NumberFormatException e) {
			WorkspaceUtil.logException("Error on project update interval:"
					+ Configuration.getProperties().getProperty("updateinterval"), e);
		}
		while(true) {
			try {
				if (projectSpace == null) {
					checkoutProjectFromServer();
				}
				
				update(projectSpace);
				System.out.println(new Date());
				Thread.sleep(UPDATE_INTERVAL);
				
				
			} catch (InterruptedException e) {
				WorkspaceUtil.logException("Project updater tread was crashed.", e);
			}
		}
	}
	
	/**
	 * Checks out the project from server.
	 */
	private void checkoutProjectFromServer() {
			
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				projectSpace = ProjectFacade.getInstance()
						.checkoutProjectFromServer(serverUrl, projectUrlFrag);
			}
		});
	}
	

	/**
	 * Updates the projectspace.
	 * 
	 * @param projectSpace the target project space
	 */
	private void update(final ProjectSpace projectSpace) {
		
		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			System.out.println("This project is not yet shared with a server, you cannot update.");
			return;
		}
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					PrimaryVersionSpec baseVersion = projectSpace
							.getBaseVersion();
					PrimaryVersionSpec targetVersion = projectSpace.update(
							VersionSpec.HEAD_VERSION, UpdateProjectHandler.this);
					WorkspaceUtil.logUpdate(projectSpace, baseVersion, targetVersion);

				} catch (ChangeConflictException e1) {
					handleChangeConflictException(e1);
					// TODO : what should we do if there conflict occurs?
					// maybe, we can delete the project and check out new one???
				} catch (NoChangesOnServerException e) {
					System.out.println("No need to update\n"
									+ "Your project is up to date, you do not need to update.");
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("Error during the project update.", e);
				}
			}
		});
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


