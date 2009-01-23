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
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.ui.stem.views.statusview.StatusView;

/**
 * This is drop adapter for flat tab in StatusView.
 * 
 * @author Hodaie
 */
public class FlatTabDropAdapter extends DropTargetAdapter {

	private ModelElement currentOpenME;
	private ModelElement source;
	private StatusView statusView;

	/**
	 * Constructor.
	 */
	public FlatTabDropAdapter() {
	}

	/**
	 * This makes drop adapter aware of model element currently open in status view.
	 * 
	 * @param currentME model element that is currently opened in StatusView
	 * @param statusView active status view
	 */
	public void setCurrentOpenMe(ModelElement currentME, StatusView statusView) {
		this.currentOpenME = currentME;
		this.statusView = statusView;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOver(DropTargetEvent event) {

		source = null;

		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (!(currentOpenME instanceof WorkPackage) && !(source instanceof WorkItem)) {
			event.detail = DND.DROP_NONE;
			return;
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
				if (currentOpenME instanceof WorkPackage) {
					if (source instanceof WorkItem) {
						dropWorkItemOnWorkPackage();
					} else {
						dropNonWorkItemOnWorkPackage();
					}
				} else {
					dropWorkItemOnNonWorkPackage();

				}
			}

		});

		statusView.setInput(currentOpenME);

	}

	private void dropWorkItemOnNonWorkPackage() {
		// dorp WorkItem B on ME (non work package) A:
		// if B somewhere exists in annotations of A (hierachical),
		// do nothing; otherwise Annotate A with B
		Set<ModelElement> openersForCurrentOpenME = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(currentOpenME);
		if (!openersForCurrentOpenME.contains(source)) {
			((WorkItem) source).getAnnotatedModelElements().add(currentOpenME);
		}
	}

	private void dropNonWorkItemOnWorkPackage() {
		// if some work item in currentOpenME (hierarchical) has already annotated source, do nothing
		// otherwise create an AI annotating source and add it to work items of currentOpenME
		Set<ModelElement> openersForSource = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(
			source);
		Set<ModelElement> openersForCurrenOpenME = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(currentOpenME);

		openersForCurrenOpenME.retainAll(openersForSource);
		if (openersForCurrenOpenME.size() == 0) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("New Action Item relating " + source.getName());
			ai.getAnnotatedModelElements().add(source);
			((WorkPackage) currentOpenME).getContainedWorkItems().add(ai);
		}

	}

	private void dropWorkItemOnWorkPackage() {

		// check if source (work item) is not hierarchical contained in
		// currentOpenME (work package) and if not add it to work items of currentOpenME
		Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(currentOpenME);
		if (!openers.contains(source)) {
			((WorkPackage) currentOpenME).getContainedWorkItems().add((WorkItem) source);
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
		if (!(tmpSource.get(0) instanceof ModelElement)) {
			result = false;
		}

		if (currentOpenME == null) {
			result = false;
		}

		// check if source and target are in the same project
		if (result) {
			source = (ModelElement) tmpSource.get(0);
			if (!currentOpenME.getProject().equals(source.getProject())) {
				result = false;
			}
		}

		return result;
	}

}
