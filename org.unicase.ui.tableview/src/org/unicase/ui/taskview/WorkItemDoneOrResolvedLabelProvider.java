/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.taskview;

import org.eclipse.swt.graphics.Image;
import org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider;

/**
 * This is a label provider for Done/Resolved column in task view. It returns an image of checked/unchecked checkbox
 * according to Done/Resolved property of a WorkItem, and according to who is the currently logged on user.
 * 
 * @author zardosht
 */
public class WorkItemDoneOrResolvedLabelProvider extends AbstractCheckboxColumnLabelProvider {

	private Object currentUser;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		return null;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Object currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentUser
	 */
	public Object getCurrentUser() {
		return currentUser;
	}

}
