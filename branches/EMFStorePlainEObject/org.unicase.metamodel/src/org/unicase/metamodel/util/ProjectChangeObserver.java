/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.metamodel.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;

/**
 * Observes changes to a Project. Can be registered with {@link Project}.
 * 
 * @author koegel
 */
public interface ProjectChangeObserver {

	/**
	 * A notification on a model element of the project occured. See {@link Notification} documentation for details on
	 * the notifications. This method will be called even if the given notification results from an add or remove of a
	 * model element of the project.
	 * 
	 * @param notification the notification
	 * @param project the project
	 * @param modelElement the model element the notification originates from
	 */
	void notify(Notification notification, Project project, EObject modelElement);

	/**
	 * The given model element was added to the project. This means it is now in the projects containment tree.
	 * 
	 * @param project the project
	 * @param modelElement the modelElement
	 */
	void modelElementAdded(Project project, EObject modelElement);

	/**
	 * The given model element and its siblings is starting to be deleted now. Note that you will NOT receive a separate
	 * notification for each sibling.
	 * 
	 * @param project the project
	 * @param modelElement the model element
	 */
	void modelElementDeleteStarted(Project project, EObject modelElement);

	/**
	 * The given model element has been completely deleted. Note that you will NOT receive a separate notification for
	 * each sibling.
	 * 
	 * @param project the project
	 * @param modelElement the model element
	 */
	void modelElementDeleteCompleted(Project project, EObject modelElement);

	/**
	 * The project of has been deleted including all contained model elements.
	 * 
	 * @param project the deleted project
	 */
	void projectDeleted(Project project);

}
