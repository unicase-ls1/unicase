/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * Observes deletes in a Project.
 * 
 * @author koegel
 */
public abstract class ProjectDeleteObserver implements ProjectChangeObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public abstract void modelElementDeleteCompleted(Project project, ModelElement modelElement);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public abstract void modelElementDeleteStarted(Project project, ModelElement modelElement);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		// do nothing
	}

}
