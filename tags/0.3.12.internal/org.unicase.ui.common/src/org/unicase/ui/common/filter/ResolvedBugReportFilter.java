/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * This filter prevents showing of resolved bug reports in viewers.
 *  
 * @author Hodaie
 *
 */
public class ResolvedBugReportFilter extends ViewerFilter {

	private final User user;
	
	/**
	 * Constructor.
	 * @param user the user, whose resolved work items must be filtered.
	 */
	public ResolvedBugReportFilter(User user){
		this.user = user;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		//false = don't show; true = show

		if(element instanceof WorkItem){
			WorkItem workItem = (WorkItem) element;
			
			OrgUnit assignee = workItem.getAssignee();
			if(assignee != null){
				return workItem.getAssignee().equals(user) && !workItem.isResolved();
			}
			
//			if(assignee.equals(user)){
//				
//				return !workItem.isResolved();
//			}
//			
//			if(workItem.getReviewer().equals(user)){
//				return workItem.isResolved();
//			}
			
						
//			if(currentUser.equals(assignee)&&workItem.isResolved()&&!workItem.getReviewer().equals(currentUser)){
//				//filter it out
//				return true;
//			}
		}
		
		return false;
	}

}
