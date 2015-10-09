/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview.dnd;

import java.util.Set;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * The drop adapter for the hierarchy view. Note that in methods dropXXOnYY(), YY actually means the currentOpenME and
 * not drop target!
 * 
 * @author helming
 */
public class HierarchyTabDropAdapter extends AbstractDropAdapter {

	/**
	 * {@inheritDoc} In hierarchy view: If a WorkItem is dropped on a root element (drop target), this element will be
	 * annotated (if it is not already (hierarchically) annotated by this WorkItem). If WorkItem is dropped some where
	 * in white area of viewer (not on a drop target) the currentOpenME will be annotated (if it is not already
	 * (hierarchically)annotated too).
	 * 
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#dropWorkItemOnNonWorkPackage()
	 */
	@Override
	protected void dropWorkItemOnNonWorkPackage() {
		if (getDropTarget() != null) {
			annotateNonWorkItemDropTarget();
		}
	}

	/**
	 * {@inheritDoc} When drop does not happen on the tree, but in free area of viewer, the drop target is equal
	 * currentOpenME. In this case just call dropWorkItemOnWorkPackage() of super. If WorkItem (drag source) is dropped
	 * on a non-WorkItem ME in the tree, then annotate this ME (if not already annotated). Note that in this case you
	 * cannot drop a WorkItem on another WorkItem in tree. The canDrop() method checks this.
	 * 
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#dropWorkItemOnWorkPackage()
	 */
	@Override
	protected void dropWorkItemOnWorkPackage() {

		if (getDropTarget().equals(getCurrentOpenME())) {
			// User has dropped on the white area. There's no real drop target and hence drop target is set to
			// currentOpenME
			super.dropWorkItemOnWorkPackage();

		} else if (getDropTarget() != null) {
			// annotate drop target (if not already annotated)
			annotateNonWorkItemDropTarget();
		}
	}

	private void annotateNonWorkItemDropTarget() {
		// drop WorkItem B on ME (non work package) A:
		// if B somewhere exists in annotations of A (hierachical),
		// do nothing; otherwise Annotate A with B

		if (getCurrentOpenME() instanceof WorkPackage) {
			WorkPackage workPackage = (WorkPackage) getCurrentOpenME();
			if (!workPackage.getAllContainedWorkItems().contains(getDragSource())) {
				workPackage.getContainedWorkItems().add((WorkItem) getDragSource());
			}

		}

		UnicaseModelElement dropTarget = (UnicaseModelElement) getDropTarget();
		UnicaseModelElement dragSource = getDragSource();

		Set<UnicaseModelElement> openersForDropTarget = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(dropTarget);
		if (!openersForDropTarget.contains(dragSource)) {
			((WorkItem) dragSource).getAnnotatedModelElements().add(dropTarget);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	protected boolean canDrop(DropTargetEvent event) {
		event.feedback = event.feedback | DND.FEEDBACK_EXPAND;
		if (!super.canDrop(event)) {
			return false;
		}
		if (getDropTarget() instanceof WorkItem && !getDropTarget().equals(getCurrentOpenME())) {
			return false;
		}

		return true;
	}

}
