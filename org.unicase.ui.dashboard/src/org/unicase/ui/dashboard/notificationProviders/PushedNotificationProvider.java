/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
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
import org.eclipse.emf.emfstore.client.ESUsersession;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.internal.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.internal.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.util.DashboardPropertyKeys;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

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
	public List<DashboardNotification> provideNotifications(
			ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		List<DashboardNotification> result = new ArrayList<DashboardNotification>();
		ESUsersession userSession;
		try {
			userSession = OrgUnitHelper.getUserSession(projectSpace
					.getProject());
			return provideNotifications(projectSpace, changePackages,
					userSession.getUsername());

		} catch (UnkownProjectException e) {
			ModelUtil.logWarning(e.getMessage());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<DashboardNotification> provideNotifications(
			ProjectSpace projectSpace, List<ChangePackage> changePackages,
			String username) {
		// sanity checks
		List<DashboardNotification> result = new ArrayList<DashboardNotification>();
		if (projectSpace == null || username == null) {
			return result;
		}
		User user = OrgUnitHelper.getUser(projectSpace.getProject(), username);
		EMFStoreProperty property = projectSpace.getPropertyManager()
				.getLocalProperty(DashboardPropertyKeys.NOTIFICATION_COMPOSITE);
		if (property != null) {
			DashboardNotificationComposite notificationComposite = (DashboardNotificationComposite) property
					.getValue();
			for (DashboardNotification notification : notificationComposite
					.getNotifications()) {
				if (notification.getRecipient().equals(user.getName())
						&& notification.getProvider() == null) {
					notification.setProvider(getName());
					result.add(notification);
					getExcludedOperations().addAll(
							notification.getRelatedOperations());
				} else {
					EList<Group> groups = new BasicEList<Group>();
					projectSpace.getProject().getAllModelElementsByClass(
							Group.class, true);
					for (Group group : groups) {
						if (group.getName().equals(notification.getRecipient())
								&& group.getOrgUnits().contains(user)
								&& notification.getProvider() == null) {
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
	public String getKey() {
		return DashboardPropertyKeys.PUSHED_PROVIDER;
	}
}
