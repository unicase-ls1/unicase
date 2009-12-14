/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This is the drop adapter for WorkPackages.
 * 
 * @author Hodaie
 */
public class WorkPackageDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public WorkPackageDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);

	}

	/**
	 * {@inheritDoc} Note: if we drop a model element with a bidirectional reference, we set the parent for drop source,
	 * instead of just adding drop source to target (container). This is because of change recording.
	 */
	@Override
	public void drop(DropTargetEvent event, UnicaseModelElement target, List<UnicaseModelElement> source) {

		ModelElement dropee = source.get(0);
		if (dropee instanceof WorkItem) {
			for (ModelElement me : source) {
				if (me instanceof WorkItem) {
					// ((WorkPackage) target).getContainedWorkItems().add((WorkItem) me);

					// bidirectional reference
					((WorkItem) me).setContainingWorkpackage((WorkPackage) target);
				}
			}

		} else {
			dropMEOnWorkpackage(target, source);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.common.dnd.dropadapters.MEDropAdapter#dropMove(org.eclipse.emf.ecore.EObject,
	 *      org.unicase.metamodel.ModelElement, java.util.List, boolean)
	 */
	@Override
	public void dropMove(EObject targetContainer, UnicaseModelElement target, List<UnicaseModelElement> source,
		boolean after) {
		ModelElement dropee = source.get(0);
		if (dropee instanceof Annotation) {
			super.dropMove(targetContainer, target, source, after);
		} else {
			dropMEOnWorkpackage((UnicaseModelElement) targetContainer, source);
		}

	}

	/**
	 * When a ModelElement (which is not a WorkItem) is dropped on a WorkPackage, or one of WorkItems inside this
	 * WorkPackage, then an ActionItem relating the dropped ME is created and added to WorkPackage.
	 * 
	 * @param target
	 * @param source
	 */
	private void dropMEOnWorkpackage(final UnicaseModelElement target, final List<UnicaseModelElement> source) {

		String viewId = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite()
			.getId();
		for (UnicaseModelElement me : source) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("New Action Item relating " + me.getName());
			ai.getAnnotatedModelElements().add(me);
			// bidirectional reference
			// ((WorkPackage) target).getContainedWorkItems().add(ai);
			ai.setContainingWorkpackage((WorkPackage) target);
			ActionHelper.openModelElement(ai, viewId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.common.dnd.dropadapters.MEDropAdapter#canDrop(int, org.eclipse.swt.dnd.DropTargetEvent,
	 *      java.util.List, org.unicase.metamodel.ModelElement, org.unicase.metamodel.ModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<UnicaseModelElement> source,
		UnicaseModelElement target, UnicaseModelElement dropee) {

		return super.canDrop(eventFeedback, event, source, target, dropee);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.common.dnd.dropadapters.MEDropAdapter#hasThisContainmentReference(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {
		return true;
	}

}
