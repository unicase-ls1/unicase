/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * A filter to filter workitems lists to a certain user. 
 * 
 * @author helming
 */
public class UserFilter extends ViewerFilter {

	private  User user;

	/**
	 * default constructor.
	 * 
	 * @param user The user on which workitems should be filtered
	 */
	public UserFilter(User user) {
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 *  The filter should only show the following:
	 * - Tasks the user created which are *not* assigned yet
	 * - Tasks the user is Assignee
	 * - Tasks the user is Reviewer and status "resolved"
	 * - Tasks the user is Participant.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		//false = don't show, true = show
		if (user == null) {
			return true; 
		}
		if (element instanceof WorkItem) { 
			//if user participates in this work item
			WorkItem workItem = (WorkItem)element;
			if(workItem.getParticipants().contains(user)){
				return true;
			}
			
			//or if user is assignee of this work item 
			OrgUnit assignee = workItem.getAssignee();
			if (assignee != null && assignee.equals(user)) {
				return true;
			}
			
			//or if this work item is resolved, and user is its reviewer
			if(workItem.isResolved() && workItem.getReviewer() != null && workItem.getReviewer().equals(user)){
				return true;
			}
			
			if(user.getName().equals(workItem.getCreator()) && workItem.getAssignee() == null){
				return true;
			}

		}else if (element instanceof ModelElement) {
			String creator = ((ModelElement) element).getCreator();
			if (user.getName().equals(creator)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
