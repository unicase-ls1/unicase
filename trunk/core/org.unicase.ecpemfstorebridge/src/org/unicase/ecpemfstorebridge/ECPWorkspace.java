/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Provides an ECPWorspace for the EMFStore.
 * 
 * @author helming
 */
public class ECPWorkspace extends ECPWorkspaceImpl implements org.unicase.ui.navigator.workSpaceModel.ECPWorkspace {

	private HashMap<ProjectSpace, EMFStoreECPProject> mapping = new HashMap<ProjectSpace, EMFStoreECPProject>();

	/**
	 * default constructor.
	 */
	public ECPWorkspace() {
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace projectSpace : projectSpaces) {
			mapping.put(projectSpace, new EMFStoreECPProject(projectSpace));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getProject(org.unicase.metamodel.ModelElement)
	 */
	public ECPProject getProject(EObject me) {
		if (me instanceof ModelElement) {
			ProjectSpace projectSpace = WorkspaceManager.getProjectSpace((ModelElement) me);
			return mapping.get(projectSpace);
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getActiveProject()
	 */
	public ECPProject getActiveProject() {
		return mapping.get(WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#setActiveModelelement(org.eclipse.emf.ecore.EObject)
	 */
	public void setActiveModelelement(EObject modelelement) {
		if (modelelement == null) {
			return;
		}
		final ProjectSpace projectSpace;
		if (modelelement instanceof ModelElement) {
			ModelElement me = (ModelElement) modelelement;
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
