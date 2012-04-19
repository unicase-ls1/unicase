/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * This adapter will listen to the creation of {@link UnicaseModelElement UnicaseModelElements} and properly initialize
 * creation date and creator.
 * 
 * @author mharut
 */
public class ModelElementInitAdapter extends EContentAdapter {

	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof UnicaseModelElement;
	}

	@Override
	public void notifyChanged(Notification msg) {
		super.notifyChanged(msg);
		Object feature = msg.getFeature();

		if (feature instanceof EReference) {
			EReference reference = (EReference) feature;
			if (!reference.isContainment() || msg.getOldValue() != null) {
				return;
			}
			Object value = msg.getNewValue();
			if (value instanceof UnicaseModelElement) {
				UnicaseModelElement unicaseModelElement = (UnicaseModelElement) value;

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

}
