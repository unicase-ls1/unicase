/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.provider.AssignmentNotificationProvider;

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
		providers.add(new AssignmentNotificationProvider());
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
		for (NotificationProvider provider : providers) {
			provider.init(projectSpace);
		}
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				for (NotificationProvider provider : providers) {
					provider.processOperation(operation);
				}
			}
		}
		for (NotificationProvider provider : providers) {
			result.addAll(provider.getCurrentResult());
			provider.clear();
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
}
