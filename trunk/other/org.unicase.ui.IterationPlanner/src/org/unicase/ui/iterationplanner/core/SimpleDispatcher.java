/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.core;

import java.util.List;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * Simple dispatcher.
 * @author hodaie
 *
 */
public class SimpleDispatcher extends Dispatcher {

	

	/**
	 * 
	 * {@inheritDoc}
	 * @see org.unicase.ui.iterationplanner.core.Dispatcher#dispatch()
	 */
	@Override
	public List<Plan> dispatch(List<WorkItem> tasks, List<User> assignees) {
		return null;
	}

}
