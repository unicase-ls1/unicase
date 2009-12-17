/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.stem.views.statusview.dnd;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This is the drop adapter for the activity tab in the status view.
 * 
 * @author deser, karakoc
 */
public class ActivityTabDropAdapter extends AbstractDropAdapter {

	/**
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#dropWorkItemOnWorkPackage()
	 */
	@Override
	protected void dropWorkItemOnWorkPackage() {
		UnicaseModelElement source = getDragSource();
		ActivityType target = (ActivityType) getDropTarget();

		if (source instanceof WorkItem) {

			if (source instanceof ActionItem) {
				((ActionItem) source).setActivity(target);
			} else if (source instanceof Issue) {
				((Issue) source).setActivity(target);
			}

			addWorkItemToCurrentOpenME((WorkItem) getDragSource());
		}

	}

	/**
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#dropWorkItemOnNonWorkPackage()
	 */
	@Override
	protected void dropWorkItemOnNonWorkPackage() {
		if (getDragSource() instanceof WorkItem) {
			addWorkItemToCurrentOpenME((WorkItem) getDragSource());
		}
	}

	/**
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent)
	 * @param event the event to be checked
	 * @return if drop can be performed
	 */
	@Override
	public boolean canDrop(DropTargetEvent event) {

		event.feedback = event.feedback | DND.FEEDBACK_SCROLL;
		if (!super.canDrop(event)) {
			return false;
		}

		if (!(getDragSource() instanceof WorkItem) | !(getDropTarget() instanceof ActivityType)) {
			return false;
		}

		if (getDragSource() instanceof BugReport && !getDropTarget().equals(ActivityType.IMPLEMENTATION)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if (getDragSource() instanceof WorkPackage) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if (event.item != null && event.item.getData() != null && event.item.getData() instanceof WorkItem) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if (getDragSource().equals(getCurrentOpenME()) || EcoreUtil.isAncestor(getDragSource(), getCurrentOpenME())) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		return true;
	}

}
