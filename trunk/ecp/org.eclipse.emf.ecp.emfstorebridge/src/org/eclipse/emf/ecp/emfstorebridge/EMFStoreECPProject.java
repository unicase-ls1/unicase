/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.emfstorebridge;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.model.ECPMetaModelElementContext;
import org.eclipse.emf.ecp.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.model.workSpaceModel.impl.ECPProjectImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.observers.SimpleOperationListener;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.swt.widgets.Display;

/**
 * ECPproject for the EMFStore.
 * 
 * @author helming
 */
public class EMFStoreECPProject extends ECPProjectImpl implements ECPProject, ProjectChangeObserver {

	@Override
	public EObject getRootContainer() {
		return projectSpace.getProject();
	}

	private final ProjectSpace projectSpace;
	private SimpleOperationListener simpleOperationListener;

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace the project space
	 */
	public EMFStoreECPProject(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
		setRootObject(projectSpace);
		simpleOperationListener = new SimpleOperationListener() {

			@Override
			public void operationPerformed(AbstractOperation operation) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						projectChanged();
					}

				});
			}

		};
		projectSpace.addOperationListener(simpleOperationListener);
		projectSpace.getProject().addProjectChangeObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.ECPModelelementContext#getAllModelElements()
	 */
	public Collection<EObject> getAllModelElements() {
		ArrayList<EObject> ret = new ArrayList<EObject>();
		ret.addAll(projectSpace.getProject().getAllModelElements());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.ECPModelelementContext#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPProject#contains(org.eclipse.emf.ecore.EObject)
	 */
	public boolean contains(EObject eObject) {
		return projectSpace.getProject().containsInstance(eObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPProject#getMetaModelElementContext()
	 */
	public ECPMetaModelElementContext getMetaModelElementContext() {
		return EMFStoreMetaModelElementContext.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPProject#dispose()
	 */
	public void dispose() {
		projectSpace.removeOperationListener(simpleOperationListener);
		projectSpace.getProject().removeProjectChangeObserver(this);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementAdded(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementAdded(Project project, EObject modelElement) {
		// Do nothing

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementRemoved(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementRemoved(Project project, EObject modelElement) {
		super.modelelementDeleted(modelElement);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.eclipse.emf.emfstore.common.model.Project, org.eclipse.emf.ecore.EObject)
	 */
	public void notify(Notification notification, Project project, EObject modelElement) {
		// Do nothing

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#projectDeleted(org.eclipse.emf.emfstore.common.model.Project)
	 */
	public void projectDeleted(Project project) {
		super.projectDeleted();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.ECPProject#addModelElementToRoot(org.eclipse.emf.ecore.EObject)
	 */
	public void addModelElementToRoot(EObject eObject) {
		projectSpace.getProject().getModelElements().add(eObject);
	}
}
