/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.core;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

import java.util.List;

/**
 * @author Hodaie
 *
 */
public abstract class Dispatcher {
	
	
	
	public abstract List<Plan> dispatch(List<WorkItem> tasks, List<User> users);

}

