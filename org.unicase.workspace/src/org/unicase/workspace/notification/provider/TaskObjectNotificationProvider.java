/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.organization.User;
import org.unicase.model.task.util.OpeningLinkHelper;
import org.unicase.model.util.ModelElementPath;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * This provider creates notifications about task objects.
 * 
 * @author helming
 */
public class TaskObjectNotificationProvider implements NotificationProvider {

	public String getName() {
		return "Task Object Change Notifier";
	}

	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
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
		Map<ModelElementId, ModelElementPath> objectsOfWork = OpeningLinkHelper.getObjectsOfWork(user);

		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				ModelElementId modelElementId = operation.getModelElementId();
				if (objectsOfWork.containsKey(modelElementId)) {

				}
			}
		}
		return result;
	}
}
