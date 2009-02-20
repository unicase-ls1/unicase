/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ProjectSpace;

/**
 * Provides notifications.
 * 
 * @author koegel
 */
public interface NotificationProvider {

	/**
	 * Initializes the notification provider.
	 * 
	 * @param projectSpace the project space.
	 * @param operations the list of operations.
	 */
	void init(ProjectSpace projectSpace, List<AbstractOperation> operations);

	/**
	 * Process an operation. May result in a change in internal state.
	 * 
	 * @param operation the operation to process
	 */
	void processOperation(AbstractOperation operation);

	/**
	 * Get current result from provider. Result may change when processing more operations.
	 * 
	 * @return a list of notifications
	 */
	List<ESNotification> getResult();

	/**
	 * Clear the internal state of the provider including its current results.
	 */
	void clear();
}
