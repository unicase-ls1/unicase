/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.provider.AssignmentNotificationProvider;
import org.unicase.workspace.notification.provider.TaskObjectNotificationProvider;
import org.unicase.workspace.notification.provider.UpdateNotificationProvider;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Singleton class to generate notifications from change packages.
 * 
 * @author koegel
 */
public final class NotificationGenerator {

	private static NotificationGenerator instance;

	private List<NotificationProvider> providers;

	/**
	 * Private constructor.
	 */
	private NotificationGenerator() {
		instance = this;
		providers = new ArrayList<NotificationProvider>();
		// update provider must be first in list
		providers.add(new UpdateNotificationProvider());

		TaskPackage taskPackage = TaskPackage.eINSTANCE;
		providers.add(new AssignmentNotificationProvider(taskPackage.getActionItem()));
		providers.add(new AssignmentNotificationProvider(RationalePackage.eINSTANCE.getIssue()));
		providers.add(new AssignmentNotificationProvider(BugPackage.eINSTANCE.getBugReport()));
		providers.add(new AssignmentNotificationProvider(taskPackage.getWorkPackage()));

		providers.add(new TaskObjectNotificationProvider());

		// providers.add(new TaskChangeNotificationProvider(TaskPackage.eINSTANCE.getActionItem()));
		// providers.add(new TaskChangeNotificationProvider(RationalePackage.eINSTANCE.getIssue()));
		// providers.add(new TaskChangeNotificationProvider(BugPackage.eINSTANCE.getBugReport()));

	}

	/**
	 * Get the instance of the {@link NotificationGenerator} singleton.
	 * 
	 * @return the singleton instance
	 */
	public static NotificationGenerator getInstance() {
		if (instance == null) {
			instance = new NotificationGenerator();
		}
		return instance;
	}

	/**
	 * Generate notifications for a list of change packages.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @param projectSpace the current project space
	 * @return a list of notification
	 */
	public List<ESNotification> generateNotifications(List<ChangePackage> changePackages, String currentUsername,
		ProjectSpace projectSpace) {
		List<ESNotification> result = new ArrayList<ESNotification>();

		// retify client date if neccessary
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation.getClientDate() == null) {
					operation.setClientDate(changePackage.getLogMessage().getDate());
				}
			}
		}

		for (NotificationProvider provider : providers) {
			try {
				result.addAll(provider.provideNotifications(projectSpace, changePackages, currentUsername));
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("Notification Provider " + provider.getName()
					+ "threw an exception, its notifications where discarded", e);
			}
		}

		// create a notification generation event
		NotificationGenerationEvent generationEvent = EventsFactory.eINSTANCE.createNotificationGenerationEvent();
		generationEvent.setTimestamp(new Date());
		for (ESNotification notification : result) {
			ESNotification clone = EsModelUtil.clone(notification);
			generationEvent.getNotifications().add(clone);
		}
		projectSpace.addEvent(generationEvent);

		return result;
	}

	/**
	 * Add a new notification provider to the generator.
	 * 
	 * @param provider the new provider
	 */
	public void addNotificationProvider(NotificationProvider provider) {
		this.providers.add(provider);
	}
}
