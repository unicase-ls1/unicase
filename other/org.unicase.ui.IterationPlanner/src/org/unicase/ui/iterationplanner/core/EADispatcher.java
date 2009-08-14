/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
public class EADispatcher extends Dispatcher {

	/**
	 * @param tasks
	 *            tasks
	 * @param assignees
	 *            assignees
	 * @return plans
	 */
	@Override
	public List<Plan> dispatch(List<WorkItem> tasks, List<User> assignees) {
		return null;
	}

}
