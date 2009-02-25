/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.stem.views.statusview.dnd;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.EventUtil;

/**
 * This is the drop adapter for User tab in Status view.
 * 
 * @author Shterev
 */
public class WorkPackageTabDropAdapter extends DropTargetAdapter {

	private ModelElement currentOpenME;

	/**
	 * Constructor.
	 */
	public WorkPackageTabDropAdapter() {
	}

	/**
	 * This makes drop adapter aware of model element currently open in status view.
	 * 
	 * @param currentME model element that is currently opened in StatusView
	 */
	public void setCurrentOpenMe(ModelElement currentME) {
		this.currentOpenME = currentME;
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
		if (event.getSource() == null || !OrganizationPackage.eINSTANCE.getOrgUnit().isInstance(event.getSource())
			|| event.item == null || !TaskPackage.eINSTANCE.getWorkItem().isInstance(event.item.getData())) {
			event.detail = DND.DROP_NONE;
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(DropTargetEvent event) {

		final WorkItem source = (WorkItem) event.getSource();
		final Object target = event.item.getData();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				EventUtil.logStatusViewDropEvent(currentOpenME, source, "Unknown", "UserTab");
				if (target instanceof OrgUnit) {
					reassignWorkItem(source, (OrgUnit) target);
				}
			}

		});

	}

	private void reassignWorkItem(WorkItem workItem, OrgUnit orgUnit) {
		workItem.setAssignee(orgUnit);
	}

}
