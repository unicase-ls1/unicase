/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.emfstorebridge;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.Configuration;
import org.eclipse.emf.emfstore.client.ModelPackage;
import org.eclipse.emf.emfstore.client.Workspace;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.core.ProjectSpaceInternal;
import org.eclipse.emf.emfstore.client.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.observer.ObserverBus;

/**
 * Provides an ECPWorspace for the EMFStore.
 * 
 * @author helming
 */
public class EMFECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	private HashMap<ProjectSpaceInternal, EMFStoreECPProject> mapping = new HashMap<ProjectSpaceInternal, EMFStoreECPProject>();
	private AdapterImpl workspaceListenerAdapter;

	/**
	 * default constructor.
	 */
	public EMFECPWorkspace() {
		EList<ProjectSpaceInternal> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpaceInternal projectSpace : projectSpaces) {
			EMFStoreECPProject emfStoreECPProject = new EMFStoreECPProject(projectSpace);
			getProjects().add(emfStoreECPProject);
			mapping.put(projectSpace, emfStoreECPProject);
		}
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == ModelPackage.WORKSPACE__PROJECT_SPACES) {
					if (msg.getEventType() == Notification.ADD
						&& ModelPackage.eINSTANCE.getProjectSpace().isInstance(msg.getNewValue())) {
						ProjectSpaceInternal projectSpace = (ProjectSpaceInternal) msg.getNewValue();
						EMFStoreECPProject emfStoreECPProject = new EMFStoreECPProject(projectSpace);
						getProjects().add(emfStoreECPProject);
						mapping.put(projectSpace, emfStoreECPProject);
					} else if (msg.getEventType() == Notification.REMOVE
						&& ModelPackage.eINSTANCE.getProjectSpace().isInstance(msg.getOldValue())) {
						ProjectSpaceInternal projectSpace = (ProjectSpaceInternal) msg.getOldValue();
						ECPProject project = getProject(projectSpace);
						project.dispose();
						project.setWorkspace(null);
						mapping.remove(projectSpace);
					}
				}
				super.notifyChanged(msg);
			}
		};
		WorkspaceManager.getInstance().getCurrentWorkspace().eAdapters().add(workspaceListenerAdapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace#getProject(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public ECPProject getProject(EObject me) {
		if (me instanceof EObject) {
			ProjectSpaceInternal projectSpace = WorkspaceManager.getProjectSpace(me);
			return mapping.get(projectSpace);
		}
		if (me instanceof ProjectSpaceInternal) {
			return mapping.get(me);
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace#getActiveProject()
	 */
	@Override
	public ECPProject getActiveProject() {
		return mapping.get(WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace());
	}

	/**
	 * Preliminary way to pass ObserverBus to ECP.
	 * 
	 * @return observerbus
	 */
	public ObserverBus getObserverBus() {
		return org.eclipse.emf.emfstore.client.WorkspaceManager.getObserverBus();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace#setActiveModelelement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void setActiveModelelement(EObject modelelement) {
		if (modelelement == null) {
			return;
		}

		final ProjectSpaceInternal projectSpace;

		if (modelelement instanceof ProjectSpaceInternal) {
			projectSpace = (ProjectSpaceInternal) modelelement;
		} else if (modelelement instanceof EObject) {
			try {
				projectSpace = org.eclipse.emf.emfstore.client.WorkspaceManager.getProjectSpace(modelelement);
			} catch (IllegalArgumentException exception) {
				return;
			}
		} else {
			projectSpace = null;
		}

		if (projectSpace == null) {
			// the active project space should NEVER be null
			return;
		}

		if (org.eclipse.emf.emfstore.client.WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace() != null) {
			if (org.eclipse.emf.emfstore.client.WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace().equals(projectSpace)) {
				return;
			}
		}
		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				org.eclipse.emf.emfstore.client.WorkspaceManager.getInstance().getCurrentWorkspace()
					.setActiveProjectSpace(projectSpace);
			}
		}.run();

	}

}
