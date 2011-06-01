/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.notification;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.emfstore.client.core.ProjectSpaceInternal;
import org.eclipse.emf.emfstore.client.preferences.DashboardKey;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;

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
	List<ESNotification> provideNotifications(ProjectSpaceInternal projectSpace, List<ChangePackage> changePackages,
		String currentUsername);

	/**
	 * Provides a list of AbstractOperations to be excluded from providers pending in the generator queue. Every
	 * Provider should offer such a list to its direct successor (see the <i>after</i> parameter for the extension
	 * point).
	 * 
	 * @return the set of operations
	 */
	Set<OperationId> getExcludedOperations();

	/**
	 * @return the Enum key for this provider's settings
	 */
	DashboardKey getKey();

}
