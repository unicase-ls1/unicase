package org.unicase.link.commands;

import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;

/**
 * Simple handler for checking out projects.
 * 
 * @author emueller
 * @author svetlana
 */
public class CheckoutProjectHandler extends ServerRequestCommandHandler{

	private ProjectInfo projectInfo;
	
	/**
	 * Creates a checkout handler.
	 * 
	 * @param userSession The user session, that will be used to check 
	 * 		  out the project
	 * @param projectInfo The project to be checked out
	 */
	public CheckoutProjectHandler(Usersession userSession, 
			ProjectInfo projectInfo) {
		super();
		setTaskTitle("Checking out project...");
		this.projectInfo = projectInfo;
		setUsersession(userSession);	
	}
	
	@Override
	protected Object run() throws EmfStoreException {
		ProjectSpace pSpace = getUsersession().checkout(projectInfo);
		return pSpace;
	}

}
