/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview.dnd;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.workspace.util.EventUtil;

/**
 * Note that in methods dropXXOnYY(), YY actually means the currentOpenME and not drop target!
 * 
 * @author Hodaie
 */
public abstract class AbstractFlatHierarchyTabDropAdapter extends DropTargetAdapter {

	private ModelElement currentOpenME;
	private ModelElement dragSource;
	private ModelElement dropTarget;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(final DropTargetEvent event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				// TODO: Log source view.
				EventUtil.logStatusViewDropEvent(currentOpenME, dragSource, "Unknown", "FlatTab");
				if (currentOpenME instanceof WorkPackage) {
					if (dragSource instanceof WorkItem) {
						dropWorkItemOnWorkPackage();
					} else {
						dropNonWorkItemOnWorkPackage();
					}
				} else {
					dropWorkItemOnNonWorkPackage();

				}
			}

		});

	}

	/**
	 * This is when a WorkItem is dropped on flat/hierarchy tab as a WorkPackage is currently in status view. Subclasses
	 * may override this default behavior.
	 */
	protected void dropWorkItemOnWorkPackage() {
		// check if source (work item) is not hierarchical contained in
		// currentOpenME (work package) and if not add it to work items of currentOpenME
		Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(currentOpenME);
		if (!openers.contains(dragSource)) {
			((WorkPackage) currentOpenME).getContainedWorkItems().add((WorkItem) dragSource);
		}

	}

	/**
	 * This is when a WorkItem is dropped on flat/hierarchy tab as a non-WorkPackage is currently open in status view.
	 * Subclasses may override this default behavior.
	 */
	protected void dropWorkItemOnNonWorkPackage() {

	}

	/**
	 * This is when a non-WorkItem is dropped on flat/hierarchy tab as a WorkPackage is currently in status view.
	 * Subclasses may override this default behavior.
	 */
	protected void dropNonWorkItemOnWorkPackage() {
		// if some work item in currentOpenME (hierarchical) has already annotated source, do nothing
		// otherwise create an AI annotating source and add it to work items of currentOpenME
		Set<ModelElement> openersForSource = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(
			dragSource);
		int i = 0;
		for (ModelElement me : openersForSource) {
			if (me instanceof WorkItem) {
				try {
					if (!me.getMEState().equals(MEState.CLOSED) && isAssignedToTheSameTeam(me)) {

						((WorkPackage) currentOpenME).getContainedWorkItems().add((WorkItem) me);
						i++;
					}

				} catch (CircularDependencyException e) {
					// Do nothing
				}

			}
		}
		if (i == 0) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("New Action Item relating " + dragSource.getName());
			ai.getAnnotatedModelElements().add(dragSource);
			((WorkPackage) currentOpenME).getContainedWorkItems().add(ai);
		}

	}

	/**
	 * This checks if currentOpenME and dropped ME are assigned to the same team.
	 * 
	 * @param me dropped model element
	 * @return true if currentOpenME and dropped ME are assigned to the same team.
	 */
	protected boolean isAssignedToTheSameTeam(ModelElement me) {

		// TODO: implement
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		dragSource = null;
		dropTarget = null;

		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (dragSource.equals(currentOpenME) || EcoreUtil.isAncestor(dragSource, currentOpenME)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (!canDrop(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}
	}

	/**
	 * This checks if dropping is valid. Subclasses (flat tab and hierarchy tab drop adapters) may override this.
	 * 
	 * @param event drop target event
	 * @return if dragSource can be dropped for this currently open ME
	 */
	protected boolean canDrop(DropTargetEvent event) {
		if (!(currentOpenME instanceof WorkPackage) && !(dragSource instanceof WorkItem)) {
			return false;
		}
		return true;
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

		if (tmpSource == null || tmpSource.size() != 1) {
			result = false;
		}

		if (!(tmpSource.get(0) instanceof ModelElement)) {
			result = false;
		}

		if (currentOpenME == null) {
			result = false;
		}

		// check if source and target are in the same project
		if (result) {
			dragSource = (ModelElement) tmpSource.get(0);
			if (!currentOpenME.getProject().equals(dragSource.getProject())) {
				result = false;
			}
		}

		if (event.item == null || event.item.getData() == null) {
			dropTarget = currentOpenME;
		} else if (event.item.getData() instanceof ModelElement) {
			dropTarget = (ModelElement) event.item.getData();
		}

		return result;
	}

	/**
	 * @param currentOpenME the currentOpenME to set
	 */
	public void setCurrentOpenME(ModelElement currentOpenME) {
		this.currentOpenME = currentOpenME;
	}

	/**
	 * @return the currentOpenME
	 */
	public ModelElement getCurrentOpenME() {
		return currentOpenME;
	}

	/**
	 * @param dragSource the dragSource to set
	 */
	public void setDragSource(ModelElement dragSource) {
		this.dragSource = dragSource;
	}

	/**
	 * @return the dragSource
	 */
	public ModelElement getDragSource() {
		return dragSource;
	}

	/**
	 * @return the dropTarget
	 */
	public ModelElement getDropTarget() {
		return dropTarget;
	}

}
