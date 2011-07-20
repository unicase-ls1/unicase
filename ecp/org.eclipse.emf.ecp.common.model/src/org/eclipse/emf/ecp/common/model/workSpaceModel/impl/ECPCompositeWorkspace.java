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

import java.util.Collection;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecp.common.model.Activator;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.ECPWorkspaceProvider;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author stute
 *
 */
public class ECPCompositeWorkspace extends ECPWorkspaceImpl{
	
	protected EList<ECPWorkspace> workspaceList;

	protected EList<ECPProject> projects;
	protected ECPProject activeProject;
	private EditingDomain editingDomain;
	
		
	public ECPCompositeWorkspace(){
		super();
		workspaceList = getWorkspacesFromExtension();
	}

	
	private EList<ECPWorkspace> getWorkspacesFromExtension() throws IllegalStateException{
		EList<ECPWorkspace> result = new BasicEList<ECPWorkspace>();
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
		return (EList<ECPWorkspace>) result;
	}


	public EList<ECPWorkspace> getWorkspaceList() {
		if (workspaceList == null){
			workspaceList = getWorkspacesFromExtension();
		}
		return workspaceList;
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
	public EList<ECPProject> getProjects() {
		EList<ECPProject> result = new BasicEList<ECPProject>();

		if (projects == null) {
			for( ECPWorkspace ws : workspaceList){
			result.addAll(((ECPWorkspaceImpl) ws).projects);
			}
			projects = (EList<ECPProject>) result;
		}
		return projects;
	}

/*	public EList<ECPProject> getProjects() {
		if (projects == null) {
			for( ECPWorkspace ws : workspaceList){
				EList<ECPProject> pr = new EObjectContainmentWithInverseEList<ECPProject>(ECPProject.class,  (ECPWorkspaceImpl) ws,
							WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS, WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE);
			projects.addAll(pr);
			}
		}
		return projects;
	}
*/
	
	
	@Override
	public ECPProject getProject(EObject me) {

		ECPProject result = null;
		for (ECPWorkspace ws : workspaceList) {

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

	public ECPProject getActiveProject() {
		if (activeProject != null && activeProject.eIsProxy()) {
			InternalEObject oldActiveProject = (InternalEObject) activeProject;
			activeProject = (ECPProject) eResolveProxy(oldActiveProject);
			if (activeProject != oldActiveProject) {
				if (eNotificationRequired())
					for (ECPWorkspace ws : workspaceList){
						eNotify(new ENotificationImpl((ECPWorkspaceImpl)ws, Notification.RESOLVE,
								WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT, oldActiveProject, activeProject));
					}
			}
		}
		return activeProject;
	}


	public ECPProject basicGetActiveProject() {
		return activeProject;
	}

	
	public void setActiveProject(ECPProject newActiveProject) {
		ECPProject oldActiveProject = activeProject;
		activeProject = newActiveProject;
		if (eNotificationRequired())
			for (ECPWorkspace ws : workspaceList){
			eNotify(new ENotificationImpl((ECPWorkspaceImpl)ws, Notification.SET, WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT,
				oldActiveProject, activeProject));
			}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProjects()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			return ((InternalEList<?>) getProjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			return getProjects();
		case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
			if (resolve)
				return getActiveProject();
			return basicGetActiveProject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			getProjects().clear();
			getProjects().addAll((Collection<? extends ECPProject>) newValue);
			return;
		case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
			setActiveProject((ECPProject) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			getProjects().clear();
			return;
		case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
			setActiveProject((ECPProject) null);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS:
			return projects != null && !projects.isEmpty();
		case WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT:
			return activeProject != null;
		}
		return super.eIsSet(featureID);
	}

	

	public void setActiveModelelement(EObject eobject) {
		if (eobject instanceof ECPProject) {
			setActiveProject((ECPProject) eobject);
		}
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	


	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public boolean isRootObject(EObject eObject) {
		for (ECPProject ecpProject : getProjects()) {
			if (ecpProject.getRootObject().equals(eObject)) {
				return true;
			}
		}
		return false;
	}
}