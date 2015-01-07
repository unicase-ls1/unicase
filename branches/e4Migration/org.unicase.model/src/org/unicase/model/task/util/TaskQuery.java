/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * This class offers queries for the task package.
 * 
 * @author helming
 */
public final class TaskQuery {

	private TaskQuery() {

	}

	/**
	 * This method returns all work items assigned to a user.
	 * 
	 * @param user
	 *            the user
	 * @return a set of work items.
	 */
	public static Set<WorkItem> getWorkItemsOfUser(User user) {
		Set<WorkItem> ret = new HashSet<WorkItem>();
		Project project = ModelUtil.getProject(user);
		// EList<WorkItem> allModelElementsbyClass = project
		// .getAllModelElementsbyClass(
		// TaskPackage.eINSTANCE.getWorkItem(),
		// new BasicEList<WorkItem>(), true);
		// for (WorkItem workItem : allModelElementsbyClass) {
		// OrgUnit assignee = workItem.getAssignee();
		// if (assignee != null && assignee.equals(user)) {
		// ret.add(workItem);
		// }
		//
		// }
		return ret;
	}
}
