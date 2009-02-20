/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package analyzer;

import java.util.Iterator;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * @author koegel
 *
 */
public class ProjectVersionIterator implements Iterator<ProjectAnalysisData> {

	
	private final Usersession usersession;
	private final ProjectId projectId;
	private final int stepLength;
	private ConnectionManager connectionManager;

	public ProjectVersionIterator(Usersession usersession, ProjectId projectId, int stepLength) {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.connectionManager=WorkspaceManager.getInstance().getConnectionManager();
	}
	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#next()
	 */
	public ProjectAnalysisData next() {
		// TODO Auto-generated method stub
		//connectionManager.getChanges(usersession.getSessionId(), projectId, source, target)
		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		// TODO Auto-generated method stub

	}

}
