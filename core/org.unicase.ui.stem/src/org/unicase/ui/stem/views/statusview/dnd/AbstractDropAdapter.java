/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview.dnd;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Note that in methods dropXXOnYY(), YY actually means the currentOpenME and not drop target!
 * 
 * @author Hodaie
 */
public abstract class AbstractDropAdapter extends DropTargetAdapter {

	private UnicaseModelElement currentOpenME;
	private UnicaseModelElement dragSource;
	private Object dropTarget;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(final DropTargetEvent event) {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
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
		}.run();
	}

	/**
	 * This is when a WorkItem is dropped on flat/hierarchy tab as a WorkPackage is currently in status view. Subclasses
	 * may override this default behavior.
	 */
	protected void dropWorkItemOnWorkPackage() {
		// check if source (work item) is not hierarchical contained in
		// currentOpenME (work package) and if not add it to work items of currentOpenME
		Set<UnicaseModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(
			currentOpenME);
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
		// if one of work items annotating the source is assigned to the same team as work package and is not already
		// closed,
		// then add this work item to work package.
		// otherwise create an AI annotating source and add it to work items of currentOpenME

		Set<UnicaseModelElement> openersForSource = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(dragSource);
		int i = 0;
		for (UnicaseModelElement me : openersForSource) {
			if (me instanceof WorkItem) {
				try {
					if (!me.getMEState().getStatus().equals(MEState.CLOSED) && isAssignedToTheSameTeam((WorkItem) me)) {

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
			((WorkPackage) currentOpenME).getContainedWorkItems().add(ai);
			ai.setName("New Action Item relating " + dragSource.getName());
			ai.getAnnotatedModelElements().add(dragSource);

		}

	}

	/**
	 * This checks if currentOpenME and dropped ME are assigned to the same team.
	 * 
	 * @param me dropped model element
	 * @return true if currentOpenME and dropped ME are assigned to the same team.
	 */
	protected boolean isAssignedToTheSameTeam(WorkItem me) {
		WorkItem parent;
		if (currentOpenME instanceof WorkItem) {
			parent = (WorkItem) currentOpenME;
		} else {
			return false;
		}
		OrgUnit parentAssignee = parent.getAssignee();
		if (parentAssignee == null || me.getAssignee() == null) {
			return true;
		}
		if (parentAssignee.equals(me.getAssignee())) {
			return true;
		}
		Set<Group> allGroupsOfOrgUnit = OrgUnitHelper.getAllGroupsOfOrgUnit(me.getAssignee());
		for (Group group : allGroupsOfOrgUnit) {
			if (group.equals(parentAssignee) || group.getOrgUnits().contains(parentAssignee)) {
				return true;
			}
		}
		return false;
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
	 */
	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		boolean result = true;

		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder.getDragSource();

		if (tmpSource == null || tmpSource.size() != 1) {
			result = false;
		}

		if (!(tmpSource.get(0) instanceof UnicaseModelElement)) {
			result = false;
		}

		if (currentOpenME == null) {
			result = false;
		}

		// check if source and target are in the same project
		if (result) {
			dragSource = (UnicaseModelElement) tmpSource.get(0);
			if (!currentOpenME.getProject().equals(dragSource.getProject())) {
				result = false;
			}
		}

		if (event.item == null || event.item.getData() == null) {
			dropTarget = currentOpenME;
		}

		// TODO: The following lines are ugly code and just a result of extending this abstract
		// adapter to be able handling DnDs on the ActivityTab and UserTab..! (deser)
		else if (event.item.getData() instanceof UnicaseModelElement) {
			dropTarget = event.item.getData();
		} else if (event.item.getData() instanceof ActivityType) {
			dropTarget = event.item.getData();
		} else if (event.item.getData() instanceof EObject) {
			dropTarget = event.item.getData();
		}

		return result;
	}

	/**
	 * This checks currentOpenME and if source is not contained in opener of it, then it will be contained.
	 * 
	 * @param workItem drag source
	 */
	protected void addWorkItemToCurrentOpenME(WorkItem workItem) {

		Set<UnicaseModelElement> openersForCurrentOpenME = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(getCurrentOpenME());

		if (!openersForCurrentOpenME.contains(workItem)) {
			if (getCurrentOpenME() instanceof WorkPackage) {
				((WorkPackage) getCurrentOpenME()).getContainedWorkItems().add(workItem);

			} else {
				workItem.getAnnotatedModelElements().add(getCurrentOpenME());
			}

		}

	}

	/**
	 * @param currentOpenME the currentOpenME to set
	 */
	public void setCurrentOpenME(UnicaseModelElement currentOpenME) {
		this.currentOpenME = currentOpenME;
	}

	/**
	 * @return the currentOpenME
	 */
	public UnicaseModelElement getCurrentOpenME() {
		return currentOpenME;
	}

	/**
	 * @param dragSource the dragSource to set
	 */
	public void setDragSource(UnicaseModelElement dragSource) {
		this.dragSource = dragSource;
	}

	/**
	 * @return the dragSource
	 */
	public UnicaseModelElement getDragSource() {
		return dragSource;
	}

	/**
	 * @return the dropTarget
	 */
	public Object getDropTarget() {
		return dropTarget;
	}

}
