/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.stem.views.statusview.dnd;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.workspace.util.EventUtil;

/**
 * This is the drop adapter for User tab in Status view.
 * 
 * @author Hodaie
 */
public class UserTabDropAdapter extends DropTargetAdapter {

	private ModelElement currentOpenME;
	private WorkItem source;

	// target can be either OrgUnit or NotAssigned
	private EObject target;

	/**
	 * Constructor.
	 */
	public UserTabDropAdapter() {
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

		source = null;

		event.feedback = event.feedback | DND.FEEDBACK_SCROLL;
		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (event.item != null && event.item.getData() != null && event.item.getData() instanceof ModelElement) {
			if (event.item.getData() instanceof WorkItem) {
				event.detail = DND.DROP_NONE;
				return;
			}
		}

		if (source.equals(currentOpenME) || EcoreUtil.isAncestor(source, currentOpenME)) {
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

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				EventUtil.logStatusViewDropEvent(currentOpenME, source, "Unknown", "UserTab");
				if (!(target instanceof OrgUnit)) {
					// target is NotAssigned
					unassignWorkItem(source);
				} else if (target instanceof OrgUnit) {
					reassignWorkItem(source, (OrgUnit) target);
				}

				addWorkItemToCurrentOpenME(source);

			}

		});

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

	/**
	 * This checks currentOpenME and if source is not contained in opener of it, then it will be contained.
	 * 
	 * @param workItem drag source
	 */
	private void addWorkItemToCurrentOpenME(WorkItem workItem) {

		Set<ModelElement> openersForCurrentOpenME = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(currentOpenME);

		if (!openersForCurrentOpenME.contains(workItem)) {
			if (currentOpenME instanceof WorkPackage) {
				((WorkPackage) currentOpenME).getContainedWorkItems().add(workItem);

			} else {
				workItem.getAnnotatedModelElements().add(currentOpenME);
			}

		}

	}

	/**
	 * This is called continually from dragOver() event handler. This checks drop target and drop source to be not Null,
	 * and sets the target, source, and dropee fields.
	 * 
	 * @param event DropTargetEvent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		boolean result = true;

		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder.getDragSource();

		if (tmpSource == null) {
			result = false;
		}

		if (tmpSource.size() != 1) {
			result = false;
		}
		if (!(tmpSource.get(0) instanceof WorkItem)) {
			result = false;
		}

		if (currentOpenME == null) {
			result = false;
		}

		if (event.item == null || event.item.getData() == null || !(event.item.getData() instanceof EObject)) {
			result = false;
		}

		// check if source and currentOpenME are in the same project
		if (result) {
			source = (WorkItem) tmpSource.get(0);
			target = (EObject) event.item.getData();

			if (!currentOpenME.getProject().equals(source.getProject())) {
				result = false;
			}
		}

		return result;
	}

}
