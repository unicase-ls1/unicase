/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.MultiReferenceOperation;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.util.DashboardPropertyKeys;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.TaskQuery;

/**
 * Provides notifications for changes on assigned tasks.
 * 
 * @author shterev
 */
public class TaskChangeNotificationProvider extends AbstractNotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Task Change Notification Provider";
	private HashMap<WorkItem, AbstractOperation> workItems;
	private Set<WorkItem> workItemsOfUser;

	/**
	 * Default constructor.
	 */
	public TaskChangeNotificationProvider() {
		workItems = new HashMap<WorkItem, AbstractOperation>();
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
	 */
	@Override
	protected List<DashboardNotification> createNotifications() {
		ArrayList<DashboardNotification> notifications = new ArrayList<DashboardNotification>();
		Set<WorkItem> workItemsSet = workItems.keySet();
		if (workItemsSet.isEmpty()) {
			return notifications;
		}
		DashboardNotification notification = DashboardFactory.eINSTANCE.createDashboardNotification();
		notification.setName("Changed work items");
		notification.setProject(ModelUtil.clone(getProjectSpace().getProjectId()));
		notification.setRecipient(getUser().getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		StringBuilder stringBuilder = new StringBuilder();
		if (workItemsSet.size() == 1) {
			stringBuilder.append("Your task ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItemsSet.iterator().next(),
				getProjectSpace()));
			stringBuilder.append(" has changed.");

		} else if (workItemsSet.size() == 2) {
			stringBuilder.append("Your tasks ");
			Iterator<WorkItem> iterator = workItemsSet.iterator();
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(iterator.next(), getProjectSpace()));
			stringBuilder.append(" and ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(iterator.next(), getProjectSpace()));
			stringBuilder.append(" have changed.");
		} else {
			stringBuilder.append("<a href=\"more\">");
			stringBuilder.append(workItemsSet.size());
			stringBuilder.append(" of your tasks</a>");
			stringBuilder.append(" have been changed.");
		}

		String message = stringBuilder.toString();
		notification.setMessage(message);
		Date date = workItemsSet.iterator().next().getCreationDate();
		for (WorkItem workItem : workItemsSet) {
			ModelElementId workItemId = ModelUtil.getProject(workItem).getModelElementId(workItem);
			notification.getRelatedOperations().add(workItems.get(workItem).getOperationId());
			notification.getRelatedModelElements().add(workItemId);
			Date newDate = workItems.get(workItem).getClientDate();
			if (newDate != null && date != null && newDate.after(date)) {
				date = newDate;
			}
		}

		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		notifications.add(notification);
		return notifications;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getKey() {
		return DashboardPropertyKeys.TASK_CHANGE_PROVIDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleOperation(AbstractOperation operation) {
		ModelElementId modelElementId = operation.getModelElementId();
		EObject modelElement = getProjectSpace().getProject().getModelElement(modelElementId);
		if (modelElement == null) {
			return;
		}
		if (!TaskPackage.eINSTANCE.getWorkItem().isInstance(modelElement)) {
			return;
		}
		if (operation instanceof MultiReferenceOperation
			&& ((MultiReferenceOperation) operation).getFeatureName().equalsIgnoreCase("comments")) {
			// FIXME AS: think of a more generic solution
			return;
		}
		for (WorkItem workItem : workItemsOfUser) {
			ModelElementId workItemId = ModelUtil.getProject(workItem).getModelElementId(workItem);
			if (workItemId.equals(modelElementId)) {
				workItems.put(workItem, operation);
				getExcludedOperations().add(operation.getOperationId());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#init()
	 */
	@Override
	protected void init() {
		super.init();
		workItems.clear();
		workItemsOfUser = TaskQuery.getWorkItemsOfUser(getUser());
	}
}
