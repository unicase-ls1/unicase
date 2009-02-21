/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * Provides notifications on updates of a project space.
 * 
 * @author koegel
 */
public class UpdateNotificationProvider implements NotificationProvider {

	private static final String NAME = "Update Notification Provider";

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
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setCreationDate(new Date());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You updated your project to version ");
		stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
		stringBuilder.append(".");
		notification.setMessage(stringBuilder.toString());
		notification.setName("Updated Project");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(currentUsername);
		notification.setSender(getName());
		List<ESNotification> result = new ArrayList<ESNotification>();
		result.add(notification);
		return result;
	}

}
