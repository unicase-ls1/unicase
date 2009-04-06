/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.Project;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 *
 */
public class ProjectVersionIterator implements Iterator<ProjectAnalysisData> {

	
	private final Usersession usersession;
	private final ProjectId projectId;
	private final int stepLength;
	private ConnectionManager connectionManager;
	private PrimaryVersionSpec targetSpec;
	private final String direction;
	private final int start;
	private final int end;

	public ProjectVersionIterator(Usersession usersession, ProjectId projectId, int stepLength) {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.connectionManager=WorkspaceManager.getInstance().getConnectionManager();
		this.targetSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		this.direction = "forward";
		this.start = 0;
		this.end = -1;
	}
	
	public ProjectVersionIterator(Usersession usersession, ProjectId projectId, int stepLength,
		int start, int end, String direction) {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.connectionManager=WorkspaceManager.getInstance().getConnectionManager();
		this.targetSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		this.direction = direction;
		this.start = start;
		this.end = end;
		this.targetSpec.setIdentifier(start);
	}
	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {

		PrimaryVersionSpec resolvedSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		if(direction == "forward"){
			if(end == -1){
				try {
					resolvedSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), 
							projectId, VersioningFactory.eINSTANCE.createHeadVersionSpec());
				} catch (InvalidVersionSpecException e) {
					WorkspaceUtil.logException("Couldn't be resolved", e);
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("Couldn't be resolved", e);
					e.printStackTrace();
				}
			}
			else{
				resolvedSpec.setIdentifier(end);
			}
			
			return targetSpec.compareTo(resolvedSpec)<0;
		}
		else{
			if(end == -1){
				resolvedSpec.setIdentifier(0);
			}
			else{
				resolvedSpec.setIdentifier(end);
			}
			
			return targetSpec.compareTo(resolvedSpec)>0;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#next()
	 */
	public ProjectAnalysisData next() {
		ProjectAnalysisData projectdata = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
		List<ChangePackage> changepackage = new ArrayList<ChangePackage>();
		changepackage = projectdata.getChangePackages();
		
		PrimaryVersionSpec sourceSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		
		int step;
		if(direction == "backward"){
			step = -stepLength;
		}
		else{
			step = stepLength;
		}
		
		if(!hasNext()){
			throw new NoSuchElementException("Has no next");
		}
		else{
			Project project = null;
			try {
				project = connectionManager.getProject(usersession.getSessionId(), projectId, targetSpec);
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't get project", e);
				e.printStackTrace();
			}
			projectdata.setProjectState(project);

			if(targetSpec.getIdentifier() == start){
				//changepackage.add(null);
				//projectdata.getChangePackages().add(null);
			}
			else{
				try {
					sourceSpec.setIdentifier(targetSpec.getIdentifier() - step);
					changepackage.addAll(connectionManager.getChanges(usersession.getSessionId(), projectId, sourceSpec, targetSpec));
				} catch (EmfStoreException e) {
						WorkspaceUtil.logException("Couldn't get Changes", e);
						e.printStackTrace();
				}
			}
			
			projectdata.getProjectState();
			targetSpec.setIdentifier(targetSpec.getIdentifier() + step);
		}
		return projectdata;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		// TODO Auto-generated method stub

	}

}
