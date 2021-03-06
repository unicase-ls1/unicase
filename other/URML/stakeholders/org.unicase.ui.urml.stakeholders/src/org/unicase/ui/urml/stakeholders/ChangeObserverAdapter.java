/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;

/**
 * 
 * @author kterzieva
 *
 */
public class ChangeObserverAdapter implements ProjectChangeObserver {

	@Override
	public void notify(Notification notification, Project project,
			EObject modelElement) {
	}

	@Override
	public void modelElementAdded(Project project, EObject modelElement) {
	}

	@Override
	public void modelElementRemoved(Project project, EObject modelElement) {
	}

	@Override
	public void projectDeleted(Project project) {
	}

}
