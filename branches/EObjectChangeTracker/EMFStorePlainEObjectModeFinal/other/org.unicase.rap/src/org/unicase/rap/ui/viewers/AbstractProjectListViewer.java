/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.viewers;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.common.notify.Notification;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ProjectChangeObserver;

import org.unicase.workspace.ProjectSpace;

/**
 * 
 * 
 * @author Fatih Ulusoy, Edgar Müller
 */
public abstract class AbstractProjectListViewer extends AbstractETableViewer implements ProjectChangeObserver {
	
	private ProjectSpace projectSpace;

	/**
	 * The constructor.
	 * 
	 * @param projectSpace Project space.
	 * @param parent Parent.
	 */
	public AbstractProjectListViewer(ProjectSpace projectSpace, Composite parent) {
		super(parent);
		this.projectSpace = projectSpace;
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	// TODO: where do we call this?
	public abstract ArrayList<EStructuralFeature> getFeatureList();
	

	/**
	 * 
	 * @param project The project that is added.
	 * @param modelElement The model element that is updated.
	 */
	public abstract void update(Project project, ModelElement modelElement);
	
	/**
	 * 
	 */
	public void refreshView() {
		// do nothing, since there's another update method
	}
	
	/**
	 * 
	 * @return Project space.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	/**
	 * 
	 * @return Project.
	 */
	public Project getProject() {
		return projectSpace.getProject();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {
		super.init();
		getProject().addProjectChangeObserver(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		update(project, modelElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

}

