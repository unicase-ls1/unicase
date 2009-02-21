/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.unicase.emfstore.esmodel.notification.ESNotification;
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

	private ProjectSpace projectSpace;
	private HashSet<ModelElementId> workItems;
	private User user;
	private Map<ModelElementId, ModelElementPath> objectsOfWork;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#clear()
	 */
	public void clear() {
		this.user = null;
		this.projectSpace = null;
		if (this.workItems != null) {
			this.workItems.clear();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getResult()
	 */
	public List<ESNotification> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ProjectSpace projectSpace, List<AbstractOperation> operations) {
		clear();
		this.projectSpace = projectSpace;
		try {
			this.user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			clear();
			return;
		} catch (CannotMatchUserInProjectException e) {
			clear();
			return;
		}
		objectsOfWork = OpeningLinkHelper.getObjectsOfWork(user);

	}

	public void processOperation(AbstractOperation operation) {
		if (projectSpace == null || user == null) {
			return;
		}
		ModelElementId modelElementId = operation.getModelElementId();
		if (objectsOfWork.containsKey(modelElementId)) {

		}

	}
}
