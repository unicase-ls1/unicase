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

import java.lang.reflect.Method;
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
import org.eclipse.emf.ecp.common.model.PostECPWorkspaceInitiator;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.ECPWorkspaceProvider;
import org.eclipse.emf.emfstore.common.observer.ObserverBus;


/**
 * @author stute
 *
 */
public class ECPCompositeWorkspace extends ECPWorkspaceImpl{
	
	private List<ECPWorkspace> workspaceList;
	private ObserverBus observerBus;
	
	public ECPCompositeWorkspace(){
		super();
		workspaceList = getWorkspacesFromExtension();
		//notifyECPPostWorkspaceInitiators();
	}
	
	public List<ECPWorkspace> getWorkspaceList() {
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
				initObserverBus(workspace);
				result.add(workspace);
			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
		return result;
	}
	
	private void initObserverBus(ECPWorkspace currentWorkspace) {
		// TODO make more general
		if ("org.eclipse.emf.ecp.emfstorebridge.EMFECPWorkspace".equals(currentWorkspace.getClass().getName())) {
			try {

				Method method = currentWorkspace.getClass().getMethod("getObserverBus");
				Object invoke = method.invoke(currentWorkspace);
				if (invoke instanceof ObserverBus) {
					observerBus = (ObserverBus) invoke;
				}
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (Exception e) {
				// fail silently
			}
			// END SUPRESS CATCH EXCEPTION
		}
		if (observerBus == null) {
			observerBus = new ObserverBus();
		}
	}
	

	public void notifyECPPostWorkspaceInitiators() {
		IConfigurationElement[] workspaceObservers = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.ecp.model.postinit");
		for (IConfigurationElement element : workspaceObservers) {
			try {
				PostECPWorkspaceInitiator workspaceObserver = (PostECPWorkspaceInitiator) element
					.createExecutableExtension("class");
				for (ECPWorkspace ws : getWorkspaceList()){
				workspaceObserver.workspaceInitComplete(ws);
				}
			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
	}
	
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
			result = ws.getProject(me);
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

	public ObserverBus getObserverBus() {
		return observerBus;
	}
}