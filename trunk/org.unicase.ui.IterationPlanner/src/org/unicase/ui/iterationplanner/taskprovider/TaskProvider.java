/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.taskprovider;

import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

import java.util.List;

/**
 * @author Hodaie
 *
 */
public class TaskProvider {
	
	/**
	 * sort tasks by priority.
	 * @param tasks tasks
	 * @return sorted task list
	 */
	public List<WorkItem> sortByPriority(List<WorkItem> tasks){
		return null;
	}
	
	
	/**
	 * extract list of work items form FRs.
	 * @param frs a list of functional requirements 
	 * @return a list of work items relating to these FRs.
	 */
	public List<WorkItem> getWorkItems(List<FunctionalRequirement> frs){
		return null;
	}
	
	
	/**
	 * find an appropriate assignee for this task based on some criteria.
	 * @param workItem task
	 * @return appropriate assignee for this task. 
	 */
	public User findAppropriateAssignee(WorkItem workItem){

		return null;
	}
	
	
	

}
