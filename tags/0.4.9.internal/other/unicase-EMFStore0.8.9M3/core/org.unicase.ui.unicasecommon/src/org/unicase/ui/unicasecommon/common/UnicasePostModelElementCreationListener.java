/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.observers.PostCreationListener;
import org.eclipse.emf.emfstore.client.model.util.NoCurrentUserException;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Change listener, that sets the creation date and, if available, the creator attribute on UNICASE model elements.
 * 
 * @author emueller
 */
public class UnicasePostModelElementCreationListener implements PostCreationListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.PostCreationListener#onCreation(org.unicase.workspace.ProjectSpace,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void onCreation(ProjectSpace projectSpace, EObject modelElement) {
		if (modelElement instanceof UnicaseModelElement) {
			UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;

			// if model element already has a creation date, leave it as is
			if (unicaseModelElement.getCreationDate() != null) {
				return;
			}

			unicaseModelElement.setCreationDate(new Date());
			User user;
			try {
				user = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance().getCurrentWorkspace());
				if (user != null) {
					unicaseModelElement.setCreator(user.getName());
				}
			} catch (NoCurrentUserException e) {
				// do nothing
			} catch (CannotMatchUserInProjectException e) {
				// do nothing
			}
		}
	}
}
