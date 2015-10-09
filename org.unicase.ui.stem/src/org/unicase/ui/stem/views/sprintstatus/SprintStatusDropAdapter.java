/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering,Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.List;

import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.DragSourcePlaceHolder;
import org.unicase.ui.unicasecommon.observer.StatusViewDropEventObserver;

/**
 * This is the drop adapter for User tab in Status view.
 * 
 * @author Shterev
 */
public class SprintStatusDropAdapter extends DropTargetAdapter {

	private UnicaseModelElement source;
	private WorkItem target;

	/**
	 * Constructor.
	 */
	public SprintStatusDropAdapter() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		event.feedback = event.feedback | DND.FEEDBACK_SCROLL;
		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@SuppressWarnings("restriction")
	@Override
	public void drop(DropTargetEvent event) {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				ESWorkspaceProviderImpl
						.getObserverBus()
						.notify(StatusViewDropEventObserver.class)
						.onStatusViewDropEvent(target, source, "Unknown",
								"Sprint status view");
				reassignWorkItem(target, (OrgUnit) source);
			}
		}.run();

	}

	private void reassignWorkItem(WorkItem workItem, OrgUnit orgUnit) {
		workItem.setAssignee(orgUnit);
	}

	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		source = null;
		target = null;
		boolean result = true;

		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder
				.getDragSource();

		if (tmpSource == null) {
			result = false;
		}

		if (tmpSource.size() != 1) {
			result = false;
		}
		if (!(tmpSource.get(0) instanceof WorkItem)) {
			result = false;
		}

		if (event.item == null || event.item.getData() == null
				|| !(event.item.getData() instanceof WorkItem)) {
			result = false;
		}

		// check if source and currentOpenME are in the same project
		if (result) {
			source = (WorkItem) tmpSource.get(0);
			target = (WorkItem) event.item.getData();
		}

		return result;
	}

}
