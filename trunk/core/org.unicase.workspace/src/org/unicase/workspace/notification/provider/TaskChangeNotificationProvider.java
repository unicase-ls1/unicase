/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
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
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides assignment notifications.
 * 
 * @author koegel
 * @author shterev
 */
public class TaskChangeNotificationProvider implements NotificationProvider {

	private EClass clazz;

	private Set<ModelElement> elementsToExclude;

	/**
	 * The name.
	 */
	public static final String NAME = "Task Change Notification Provider";

	/**
	 * Default constructor.
	 * 
	 * @param assignmentClass the class of the assignment - e.g. ActionItem, BugReport, etc.
	 */
	public TaskChangeNotificationProvider(EClass assignmentClass) {
		this.clazz = assignmentClass;
		this.elementsToExclude = new HashSet<ModelElement>();
	}

	/**
	 * Add the given elements to the exclude filter. Excluding them from notification.
	 * 
	 * @param elements the elements to exclude
	 */
	public void addToFilter(Collection<? extends ModelElement> elements) {
		this.elementsToExclude.addAll(elements);
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

		Map<WorkItem, AbstractOperation> workItems = new HashMap<WorkItem, AbstractOperation>();

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
				if (this.elementsToExclude.contains(modelElement)) {
					continue;
				}
				for (WorkItem workItem : workItemsOfUser) {
					if (workItem.getModelElementId().equals(modelElementId)) {
						workItems.put(workItem, operation);
					}
				}
			}
		}

		if (workItems.isEmpty()) {
			return result;
		}

		// create a notification for the new work items
		ESNotification notification = createNotification(projectSpace, user, workItems);

		result.add(notification);
		return result;

	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user,
		Map<WorkItem, AbstractOperation> workItemMap) {
		Set<WorkItem> workItems = workItemMap.keySet();
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("Changed work items");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		StringBuilder stringBuilder = new StringBuilder();
		if (workItems.size() == 1) {
			stringBuilder.append("Your ");
			stringBuilder.append(clazz.getName());
			stringBuilder.append(" ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItems.iterator().next(),
				projectSpace));
			stringBuilder.append(" has changed.");

		} else if (workItems.size() == 2) {
			stringBuilder.append("Your ");
			stringBuilder.append(this.clazz.getName());
			stringBuilder.append("s ");
			Iterator<WorkItem> iterator = workItems.iterator();
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(iterator.next(), projectSpace));
			stringBuilder.append(" and ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(iterator.next(), projectSpace));
			stringBuilder.append(" have changed.");
		} else {
			stringBuilder.append("<a href=\"more\">");
			stringBuilder.append(workItems.size());
			stringBuilder.append(" of your ");
			stringBuilder.append(this.clazz.getName());
			stringBuilder.append("s</a> ");
			stringBuilder.append(" have been changed.");
		}

		String message = stringBuilder.toString();
		notification.setMessage(message);
		Date date = workItems.iterator().next().getCreationDate();
		for (WorkItem workItem : workItems) {
			notification.getRelatedOperations().add(workItemMap.get(workItem).getOperationId());
			notification.getRelatedModelElements().add(workItem.getModelElementId());
			Date newDate = workItemMap.get(workItem).getClientDate();
			if (newDate != null && newDate.after(date)) {
				date = newDate;
			}
		}
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		return notification;
	}
}
