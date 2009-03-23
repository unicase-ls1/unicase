/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.taskview;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider;

/**
 * This is a label provider for Done/Resolved column in task view. It returns an image of checked/unchecked checkbox
 * according to Done/Resolved property of a WorkItem, and according to who is the currently logged on user.
 * 
 * @author zardosht
 */
public class WorkItemDoneOrResolvedLabelProvider extends AbstractCheckboxColumnLabelProvider {

	private User currentUser;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (!(element instanceof WorkItem)) {
			return null;
		}

		WorkItem workItem = (WorkItem) element;
		if (currentUser == null) {
			return getDoneStateImage(workItem);
		}

		User reviewer = workItem.getReviewer();
		OrgUnit assignee = workItem.getAssignee();
		if (currentUser.equals(reviewer)) {
			return getDoneStateImage(workItem);
		}
		if (currentUser.equals(assignee)) {
			return getResolvedStateImage(workItem);
		}

		return getDoneStateImage(workItem);
	}

	private Image getResolvedStateImage(WorkItem workItem) {
		if (((Checkable) workItem).isChecked()) {
			return JFaceResources.getImage(CHECKED);
		}
		if (workItem.isResolved()) {
			return JFaceResources.getImage(CHECKED);
		} else {
			return JFaceResources.getImage(UNCHECK);
		}
	}

	private Image getDoneStateImage(WorkItem workItem) {
		if (((Checkable) workItem).isChecked()) {
			return JFaceResources.getImage(CHECKED);
		} else {
			return JFaceResources.getImage(UNCHECK);
		}

	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

}
