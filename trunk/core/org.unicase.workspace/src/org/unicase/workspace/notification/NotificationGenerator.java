/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.PreferenceManager;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.PropertyKey.DashboardKey;
import org.unicase.workspace.notification.provider.CommentsNotificationProvider;
import org.unicase.workspace.notification.provider.PushedNotificationProvider;
import org.unicase.workspace.notification.provider.SubscriptionNotificationProvider;
import org.unicase.workspace.notification.provider.TaskNotificationProvider;
import org.unicase.workspace.notification.provider.TaskObjectNotificationProvider;
import org.unicase.workspace.notification.provider.UpdateNotificationProvider;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Singleton class to generate notifications from change packages.
 * 
 * @author koegel
 * @author shterev
 */
public final class NotificationGenerator {

	private static HashMap<ProjectSpace, NotificationGenerator> instances;

	private List<NotificationProvider> providers;

	private ProjectSpace projectSpace;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space.
	 */
	private NotificationGenerator(ProjectSpace projectSpace) {
		providers = new ArrayList<NotificationProvider>();

		this.projectSpace = projectSpace;
		// update provider must be first in list
		addNotificationProvider(new UpdateNotificationProvider());

		addTaskProviders(projectSpace);

		if (projectSpace.hasProperty(DashboardKey.TASK_TRACE_PROVIDER)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.TASK_TRACE_PROVIDER);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new TaskObjectNotificationProvider());
			}
		}

		if (projectSpace.hasProperty(DashboardKey.COMMENTS_PROVIDER)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.COMMENTS_PROVIDER);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new CommentsNotificationProvider());
			}
		}

		if (projectSpace.hasProperty(DashboardKey.SUBSCRIPTION_PROVIDER)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.SUBSCRIPTION_PROVIDER);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new SubscriptionNotificationProvider());
			}
		}
		addNotificationProvider(new PushedNotificationProvider());
	}

	private void addTaskProviders(ProjectSpace projectSpace) {

		if (projectSpace.hasProperty(DashboardKey.SHOW_AI_TASKS)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_AI_TASKS);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new TaskNotificationProvider(TaskPackage.eINSTANCE.getActionItem()));
			}
		}

		if (projectSpace.hasProperty(DashboardKey.SHOW_BR_TASKS)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_BR_TASKS);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new TaskNotificationProvider(BugPackage.eINSTANCE.getBugReport()));
			}
		}

		if (projectSpace.hasProperty(DashboardKey.SHOW_ISSUE_TASKS)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.SHOW_ISSUE_TASKS);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new TaskNotificationProvider(RationalePackage.eINSTANCE.getIssue()));
			}
		}

		if (projectSpace.hasProperty(DashboardKey.SHOW_WP_TASKS)) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_WP_TASKS);
			if (property.getBooleanProperty()) {
				addNotificationProvider(new TaskNotificationProvider(TaskPackage.eINSTANCE.getWorkPackage()));
			}
		}
	}

	/**
	 * Get the instance of the {@link NotificationGenerator} singleton.
	 * 
	 * @param projectSpace the projetspace
	 * @return the singleton instance
	 */
	public static NotificationGenerator getInstance(ProjectSpace projectSpace) {
		if (instances == null) {
			instances = new HashMap<ProjectSpace, NotificationGenerator>();
		}
		NotificationGenerator notificationGenerator = instances.get(projectSpace);
		if (notificationGenerator == null) {
			notificationGenerator = new NotificationGenerator(projectSpace);
			instances.put(projectSpace, notificationGenerator);
		}
		return notificationGenerator;
	}

	/**
	 * Generate notifications for a list of change packages. Will also generate an event for the generated
	 * notifications.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @return a list of notification
	 */
	public List<ESNotification> generateNotifications(List<ChangePackage> changePackages, String currentUsername) {
		return generateNotifications(changePackages, currentUsername, true);
	}

	/**
	 * Generate notifications for a list of change packages.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @param createGenerationEvent true if an event should be generated about the notifications
	 * @return a list of notification
	 */
	public List<ESNotification> generateNotifications(List<ChangePackage> changePackages, String currentUsername,
		boolean createGenerationEvent) {
		List<ESNotification> result = new ArrayList<ESNotification>();

		// rectify client date if neccessary
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
					+ " threw an exception, its notifications where discarded", e);
			}
		}

		// create a notification generation event
		if (createGenerationEvent) {
			NotificationGenerationEvent generationEvent = EventsFactory.eINSTANCE.createNotificationGenerationEvent();
			generationEvent.setTimestamp(new Date());
			for (ESNotification notification : result) {
				ESNotification clone = EsModelUtil.clone(notification);
				generationEvent.getNotifications().add(clone);
			}
			projectSpace.addEvent(generationEvent);
		}
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

	/**
	 * @return the list of providers.
	 */
	public Collection<NotificationProvider> getProviders() {
		return Collections.unmodifiableCollection(providers);
	}
}
