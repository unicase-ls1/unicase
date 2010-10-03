/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import org.unicase.metamodel.util.ProjectChangeObserver;

/**
 * Command for notifying PRojectChangeObservers of changes in a project.
 * @author koegel
 *
 */
public interface ProjectChangeObserverNotificationCommand {

	/**
	 * Run the command on a project change observer.
	 * @param projectChangeObserver the observer
	 */
	void run(ProjectChangeObserver projectChangeObserver);
}
