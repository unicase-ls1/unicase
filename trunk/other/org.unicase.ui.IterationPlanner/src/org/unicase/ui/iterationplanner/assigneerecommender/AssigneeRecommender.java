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
package org.unicase.ui.iterationplanner.assigneerecommender;

import org.unicase.model.organization.User;

import java.util.List;

/**
 * @author Hodaie
 */
public interface AssigneeRecommender {

	/**
	 * @param assignee
	 */
	void addAssignee(User assignee);

	/**
	 * @param obj
	 */
	void removeAssignee(User obj);

	/**
	 * @return
	 */
	List<User> getAssignees();

}
