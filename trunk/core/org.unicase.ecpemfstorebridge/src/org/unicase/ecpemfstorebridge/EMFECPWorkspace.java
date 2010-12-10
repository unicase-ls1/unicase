/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.util.observer.ObserverBus;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Provides an ECPWorspace for the EMFStore.
 * 
 * @author helming
 */
public class EMFECPWorkspace extends ECPWorkspaceImpl implements org.unicase.ecp.model.workSpaceModel.ECPWorkspace {

	private HashMap<ProjectSpace, EMFStoreECPProject> mapping = new HashMap<ProjectSpace, EMFStoreECPProject>();
	private AdapterImpl workspaceListenerAdapter;

	/**
	 * default constructor.
	 */
	public EMFECPWorkspace() {
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace projectSpace : projectSpaces) {
			EMFStoreECPProject emfStoreECPProject = new EMFStoreECPProject(projectSpace);
			getProjects().add(emfStoreECPProject);
			mapping.put(projectSpace, emfStoreECPProject);
		}
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__PROJECT_SPACES) {
					if (msg.getEventType() == Notification.ADD
						&& WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(msg.getNewValue())) {
						ProjectSpace projectSpace = (ProjectSpace) msg.getNewValue();
						EMFStoreECPProject emfStoreECPProject = new EMFStoreECPProject(projectSpace);
						getProjects().add(emfStoreECPProject);
						mapping.put(projectSpace, emfStoreECPProject);
					} else if (msg.getEventType() == Notification.REMOVE
						&& WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(msg.getOldValue())) {
						ProjectSpace projectSpace = (ProjectSpace) msg.getOldValue();
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
	 * @see org.unicase.ecp.model.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.ECPWorkspace#getProject(org.unicase.metamodel.ModelElement)
	 */
	@Override
	public ECPProject getProject(EObject me) {
		if (me instanceof EObject) {
			ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
			return mapping.get(projectSpace);
		}
		if (me instanceof ProjectSpace) {
			return mapping.get(me);
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.ECPWorkspace#getActiveProject()
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
		return org.unicase.workspace.WorkspaceManager.getObserverBus();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.ECPWorkspace#setActiveModelelement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void setActiveModelelement(EObject modelelement) {
		if (modelelement == null) {
			return;
		}
		final ProjectSpace projectSpace;
		if (modelelement instanceof EObject) {
			EObject me = modelelement;
			projectSpace = org.unicase.workspace.WorkspaceManager.getProjectSpace(me);
		} else if (modelelement instanceof ProjectSpace) {
			projectSpace = (ProjectSpace) modelelement;
		} else {
			projectSpace = null;
		}

		if (projectSpace == null) {
			// the active project space should NEVER be null
			return;
		}

		if (org.unicase.workspace.WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace() != null) {
			if (org.unicase.workspace.WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
				.equals(projectSpace)) {
				return;
			}
		}
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				org.unicase.workspace.WorkspaceManager.getInstance().getCurrentWorkspace().setActiveProjectSpace(
					projectSpace);
			}
		}.run();

	}

}
