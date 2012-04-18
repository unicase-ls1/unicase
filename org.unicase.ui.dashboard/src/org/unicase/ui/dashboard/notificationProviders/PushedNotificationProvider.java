/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * Provides notifications pushed from one user to another.
 * 
 * @author shterev
 */
public class PushedNotificationProvider implements NotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Pushed Notification Provider";
	private Set<OperationId> excludedOperations;

	/**
	 * Default constructor.
	 */
	public PushedNotificationProvider() {
		excludedOperations = new HashSet<OperationId>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		List<ESNotification> result = new ArrayList<ESNotification>();

		try {
			User currentUser = OrgUnitHelper.getUser(projectSpace);
			return provideNotifications(projectSpace, changePackages, currentUser.getName());
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace,
			List<ChangePackage> changePackages, String username) {
		// sanity checks
		List<ESNotification> result = new ArrayList<ESNotification>();
		if (projectSpace == null || username == null) {
			return result;
		}
		
		User user;
		try {
			user = OrgUnitHelper.getUser(projectSpace, username);
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}

		for (ChangePackage cp : changePackages) {
			for (ESNotification notification : cp.getNotifications()) {
				if (notification.getRecipient().equals(user.getName())) {
					notification.setProvider(getName());
					result.add(notification);
					getExcludedOperations().addAll(
							notification.getRelatedOperations());
				} else {
					EList<Group> groups = new BasicEList<Group>();
					projectSpace.getProject().getAllModelElementsbyClass(
							OrganizationPackage.eINSTANCE.getGroup(), groups);
					for (Group group : groups) {
						if (group.getName().equals(notification.getRecipient())
								&& group.getOrgUnits().contains(user)) {
							notification.setProvider(getName());
							result.add(notification);
							getExcludedOperations().addAll(
									notification.getRelatedOperations());
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getExcludedOperations()
	 */
	public Set<OperationId> getExcludedOperations() {
		return excludedOperations;
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.PUSHED_PROVIDER;
	}
}
