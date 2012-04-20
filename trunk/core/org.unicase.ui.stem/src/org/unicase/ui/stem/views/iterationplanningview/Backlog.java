/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * Object to show the Backlog in the Iteration planning view. The Backlog contains all workitems which are not contained
 * in a workpackage.
 * 
 * @author helming
 */
public class Backlog extends EObjectImpl {

	private Project project;

	/**
	 * Default constructor.
	 * 
	 * @param project The porject this backlog is from
	 */
	public Backlog(Project project) {
		this.setProject(project);
	}

	/**
	 * Sets the project.
	 * 
	 * @param project teh new project.
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * gets the current project.
	 * 
	 * @return the current project
	 */
	public Project getProject() {
		return project;
	}

}
