/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.notification.NotificationProvider;
import org.eclipse.emf.emfstore.client.model.preferences.DashboardKey;
import org.eclipse.emf.emfstore.client.model.util.NoCurrentUserException;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.emf.emfstore.server.model.notification.NotificationFactory;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Provides notifications on updates of a project space.
 * 
 * @author koegel
 * @author shterev
 */
public class UpdateNotificationProvider implements NotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Update Notification Provider";

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
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String usersername) {

		// sanity checks
		if (projectSpace == null || changePackages == null || usersername == null) {
			return Collections.emptyList();
		}

		List<ESNotification> result = new ArrayList<ESNotification>();

		List<ChangePackage> newChangePackages = new ArrayList<ChangePackage>();
		for (ChangePackage cp : changePackages) {
			if (cp != null) {
				newChangePackages.add(cp);
			}
		}

		// do not generate an update notification for a commit
		if ((newChangePackages.size() == 1 && newChangePackages.get(0).getLogMessage() == null)) {
			return result;
		}

		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setProject(ModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(usersername);
		notification.setProvider(getName());

		if (newChangePackages.isEmpty()) {
			notification.setCreationDate(new Date());
			notification.setMessage("You checked out the project in version "
				+ projectSpace.getBaseVersion().getIdentifier());
			notification.setName("Project checkout");
		} else {
			Date date = newChangePackages.get(0).getLogMessage().getClientDate();
			for (ChangePackage cp : newChangePackages) {
				if (cp.getLogMessage().getClientDate().after(date)) {
					date = cp.getLogMessage().getClientDate();
				}
			}
			notification.setCreationDate(date);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You updated your project to version ");
			stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
			notification.setMessage(stringBuilder.toString());
			notification.setName("Updated Project");
		}
		result.add(notification);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getExcludedOperations()
	 */
	public Set<OperationId> getExcludedOperations() {
		return new HashSet<OperationId>();
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.UPDATE_PROVIDER;
	}
}
