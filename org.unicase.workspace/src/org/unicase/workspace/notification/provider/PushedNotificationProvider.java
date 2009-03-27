/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications pushed from one user to another.
 * 
 * @author shterev
 */
public class PushedNotificationProvider implements NotificationProvider {

	/**
	 * Default constructor.
	 */
	public PushedNotificationProvider() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Pushed Notification Provider";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		// sanity checks
		List<ESNotification> result = new ArrayList<ESNotification>();
		User user = null;
		try {
			user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}
		if (projectSpace == null || user == null) {
			return result;
		}

		for (ChangePackage cp : changePackages) {
			for (ESNotification notification : cp.getNotifications()) {
				if (notification.getRecipient().equals(user.getName())) {
					result.add(notification);
				} else {
					EList<Group> groups = new BasicEList<Group>();
					projectSpace.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getGroup(),
						groups);
					for (Group group : groups) {
						if (group.getName().equals(notification.getRecipient()) && group.getOrgUnits().contains(user)) {
							result.add(notification);
						}
					}
				}
			}
		}
		return result;
	}
}
