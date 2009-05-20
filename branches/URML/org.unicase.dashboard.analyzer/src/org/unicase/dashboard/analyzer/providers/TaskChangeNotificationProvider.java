/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.analyzer.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.dashboard.analyzer.DashboardAnalyzerHelper;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.TaskQuery;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * Provides assignment notifications.
 * 
 * @author koegel
 * @author shterev
 */
public class TaskChangeNotificationProvider implements NotificationProvider {

	private EClass clazz;

	private Set<ModelElementId> elementsToExclude;

	/**
	 * Default constructor.
	 * 
	 * @param assignmentClass the class of the assignment - e.g. ActionItem, BugReport, etc.
	 */
	public TaskChangeNotificationProvider(EClass assignmentClass) {
		this.clazz = assignmentClass;
		this.elementsToExclude = new HashSet<ModelElementId>();
	}

	/**
	 * Add the given elements to the exclude filter. Excluding them from notification.
	 * 
	 * @param elements the elements to exclude
	 */
	public void addToFilter(Collection<ModelElementId> elements) {
		this.elementsToExclude.addAll(elements);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Assignement Notification Provider";
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
		User user = DashboardAnalyzerHelper.getUser(projectSpace, currentUsername);
		if (projectSpace == null || user == null) {
			return result;
		}

		Map<WorkItem, Date> workItems = new HashMap<WorkItem, Date>();

		Set<WorkItem> workItemsOfUser = TaskQuery.getWorkItemsOfUser(user);

		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				ModelElementId modelElementId = operation.getModelElementId();
				ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
				if (modelElement == null) {
					continue;
				}
				if (!this.clazz.isInstance(modelElement)) {
					continue;
				}
				if (this.elementsToExclude.contains(modelElementId)) {
					continue;
				}
				for (WorkItem workItem : workItemsOfUser) {
					if (workItem.getModelElementId().equals(modelElementId)) {
						workItems.put(workItem, operation.getClientDate());
					}
				}
			}
		}

		if (workItems.isEmpty()) {
			return result;
		}

		// create a notification for the new work items
		for (WorkItem wi : workItems.keySet()) {
			ESNotification notification = createNotification(projectSpace, user, wi, workItems.get(wi));
			result.add(notification);
		}

		return result;

	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user, WorkItem workItem, Date date) {
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("Changed work items");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setSender(getName());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Your ");
		stringBuilder.append(clazz.getName());
		stringBuilder.append(" ");
		stringBuilder.append(workItem.getName());
		stringBuilder.append(" has changed.");

		String message = stringBuilder.toString();
		notification.setMessage(message);
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		ModelElementId modelElementId = (ModelElementId) EcoreUtil.copy(workItem.getModelElementId());
		notification.getRelatedModelElements().add(modelElementId);
		return notification;
	}
}
