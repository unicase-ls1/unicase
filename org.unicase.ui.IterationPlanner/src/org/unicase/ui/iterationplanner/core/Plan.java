/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.core;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

import java.util.Map;

/**
 * @author Hodaie
 *
 */
public class Plan {

	
	private Map<WorkItem, User> plan;

	public Plan(Map<WorkItem, User> plan){
		this.plan = plan;
	}
	
	/**
	 * @return the plan
	 */
	public Map<WorkItem, User> getPlan() {
		return plan;
	}
}
