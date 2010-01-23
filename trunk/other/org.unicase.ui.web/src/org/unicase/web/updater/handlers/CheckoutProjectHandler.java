/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.web.updater.handlers;

import org.unicase.workspace.Usersession;
import org.unicase.workspace.ProjectSpace;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Simple handler for checking out projects.
 * 
 * @author emueller, svetlana nogina
 */
public class CheckoutProjectHandler {

	private Usersession session;
	
	private ProjectInfo projectInfo;
	
	private ProjectSpace projectspace;
	
	/**
	 * Creates a checkout handler.
	 * 
	 * @param userSession The user session, that will be used to check 
	 * 		  out the project
	 * @param projectInfo The project to be checked out
	 */
	public CheckoutProjectHandler(Usersession userSession, ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
		this.projectspace = null;
		this.session = userSession;	
	}
	
	/**
	 * 
	 * 
	 */
	public void run() throws EmfStoreException {
		projectspace = session.checkout(projectInfo);
	}
	
	/**
	 * Gets the project space associated with the handler.
	 * 
	 * @return the project space checked out or null if the handler hasn't been run yet 
	 */
	public ProjectSpace getProjectSpace(){
		return projectspace;
	}

}
