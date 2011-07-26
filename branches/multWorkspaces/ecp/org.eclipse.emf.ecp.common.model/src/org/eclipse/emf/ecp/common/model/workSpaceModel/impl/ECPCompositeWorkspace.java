/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.model.workSpaceModel.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecp.common.model.Activator;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.ECPWorkspaceProvider;

/**
 * @author stute
 *
 */
public class ECPCompositeWorkspace extends ECPWorkspaceImpl{
	
	private List<ECPWorkspace> workspaceList;
	
	public ECPCompositeWorkspace(){
		super();
		workspaceList = getWorkspacesFromExtension();
	}
	
	public List<ECPWorkspace> getWorkspaceList() {
		if (workspaceList == null){
			workspaceList = getWorkspacesFromExtension();
		}
		return workspaceList;
	}
	
	private List<ECPWorkspace> getWorkspacesFromExtension() throws IllegalStateException{
		List<ECPWorkspace> result = new ArrayList<ECPWorkspace>();
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
		"org.eclipse.emf.ecp.model.workspaceprovider");
		if (confs.length < 1) {
			throw new IllegalStateException("No Workspace registered");
		}
		for (IConfigurationElement element : confs) {
			try {
				ECPWorkspace workspace = ((ECPWorkspaceProvider) element.createExecutableExtension("class"))
				.getECPWorkspace();
				result.add(workspace);
			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
		return result;
	}
	
/*	public EList<ECPProject> getProjects(){
		for( ECPWorkspace ws : workspaceList){
			if (projects == null){
				projects = new EObjectContainmentWithInverseEList<ECPProject>(null, (ECPWorkspaceImpl) ws, 0, 0);
			}
			projects.addAll(((ECPWorkspaceImpl) ws).projects);
		}
		return projects;
	}
*/	
//	public EList<ECPProject> getProjects() {
//		EList<ECPProject> result = new BasicEList<ECPProject>();
//
//		if (projects == null) {
//			for( ECPWorkspace ws : workspaceList){
//			result.addAll(((ECPWorkspaceImpl) ws).projects);
//			}
//			projects = (EList<ECPProject>) result;
//		}
//		return projects;
//	}

	@Override
	public EList<ECPProject> getProjects() {
		if (projects == null) {
			projects = new BasicEList<ECPProject>();
			for (ECPWorkspace ws : getWorkspaceList()) {
				projects.addAll(ws.getProjects());
			}
		}
		return projects;
	}

	
	
	@Override
	public ECPProject getProject(EObject me) {
		ECPProject result = null;
		for (ECPWorkspace ws : getWorkspaceList()) {

			for (ECPProject project : ws.getProjects()) {
				if (project.contains(me)) {
					result =  project;
				}
			}
		}
		if (result == null) {
			throw new IllegalStateException("Project for element not found!");
		}
		return result;
	}

	@Override
	public ECPProject getActiveProject() {
		
		for (ECPWorkspace ws : getWorkspaceList()) {
			ECPProject activeProject = ws.getActiveProject();
			if(activeProject != null){
				return activeProject;
			}
		}
		return null;
	}

	@Override
	public void setActiveProject(ECPProject newActiveProject) {
		ECPProject oldActiveProject = activeProject;
		activeProject = newActiveProject;
		if (eNotificationRequired()) {
			for (ECPWorkspace ws : getWorkspaceList()){
			eNotify(new ENotificationImpl((ECPWorkspaceImpl)ws, Notification.SET, WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT,
				oldActiveProject, activeProject));
			}
		}
	}
}