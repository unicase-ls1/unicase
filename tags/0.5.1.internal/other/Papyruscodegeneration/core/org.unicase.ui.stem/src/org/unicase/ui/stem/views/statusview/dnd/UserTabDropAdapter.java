/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview.dnd;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.observer.StatusViewDropEventObserver;

/**
 * This is the drop adapter for User tab in Status view.
 * 
 * @author Hodaie, deser
 */
public class UserTabDropAdapter extends AbstractDropAdapter {

	/**
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent)
	 * @param event the event to be checked
	 * @return if it can be dropped
	 */
	@Override
	public boolean canDrop(DropTargetEvent event) {

		event.feedback = event.feedback | DND.FEEDBACK_SCROLL;
		if (!super.canDrop(event)) {
			return false;
		}

		if (!(getDragSource() instanceof WorkItem)) {
			return false;
		}

		if (event.item != null && event.item.getData() != null && (event.item.getData() instanceof WorkItem)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if (getDragSource().equals(getCurrentOpenME()) || EcoreUtil.isAncestor(getDragSource(), getCurrentOpenME())) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(DropTargetEvent event) {

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				ECPWorkspaceManager.getObserverBus().notify(StatusViewDropEventObserver.class)
					.onStatusViewDropEvent(getCurrentOpenME(), getDragSource(), "Unknown", "UserTab");
				if (!(getDropTarget() instanceof OrgUnit)) {
					// target is NotAssigned
					unassignWorkItem((WorkItem) getDragSource());
				} else if (getDropTarget() instanceof OrgUnit) {
					reassignWorkItem((WorkItem) getDragSource(), (OrgUnit) getDropTarget());
				}

				addWorkItemToCurrentOpenME((WorkItem) getDragSource());

			}

		}.run();

	}

	private void unassignWorkItem(WorkItem workItem) {
		// user has dropped a work item in NotAssigned
		if (workItem.getAssignee() != null) {
			workItem.setAssignee(null);
		}
	}

	private void reassignWorkItem(WorkItem workItem, OrgUnit orgUnit) {
		workItem.setAssignee(orgUnit);
	}

}
