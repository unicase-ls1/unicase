/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;

/**
 * Provides notifications.
 * 
 * @author koegel
 */
public interface NotificationProvider {

	/**
	 * Return the name of the provider.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Provide notifications for a list of change packages.
	 * 
	 * @param projectSpace the project space.
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @return a list of notifications
	 */
	List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername);

}
