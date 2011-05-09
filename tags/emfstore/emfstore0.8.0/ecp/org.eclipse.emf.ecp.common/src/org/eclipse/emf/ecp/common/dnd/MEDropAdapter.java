/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.dnd;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;

/**
 * This is the super class for all model element specific drop adapters. We can consider this class as if ModelElement
 * was drop target.
 * 
 * @author Hodaie
 */
public abstract class MEDropAdapter {

	private StructuredViewer viewer;

	/**
	 * Constructor.
	 */
	public MEDropAdapter() {

	}

	/**
	 * Initializes the adapter.
	 * 
	 * @param viewer the viewer
	 */
	public void init(StructuredViewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param source
	 * @param target
	 */

	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {

		dropContainment(target, source);

	}

	/**
	 * Determine the class the Drop adapter is for.
	 * 
	 * @return the EClass
	 */
	public abstract EClass isDropAdapterfor();

	/**
	 * @param targetContainer target's container
	 * @param target target
	 * @param source source
	 */
	@SuppressWarnings("unchecked")
	protected void dropAfter(EObject targetContainer, EObject target, List<EObject> source) {

		int targetIndex;
		EReference theRef = getTargetRef(targetContainer, source.get(0));
		if (theRef == null) {
			return;
		}

		Object object = targetContainer.eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		if (eList != null) {
			targetIndex = eList.indexOf(target);
		} else {
			targetIndex = -1;
		}

		if (targetIndex == -1) {
			return;
		}

		if (haveSameEContainer(target, source.get(0))) {
			// if we are moving some children within the same parent
			int sourceIndex = eList.indexOf(source.get(0));
			if (sourceIndex >= 0 && sourceIndex < targetIndex) {
				targetIndex--;
			}
			for (int i = source.size() - 1; i >= 0; i--) {
				eList.move(targetIndex + 1, source.get(i));
			}

		} else {
			// if we are moving some children from another parent here.
			eList.addAll(targetIndex + 1, source);
		}
	}

	/**
	 * This will be used by drop after and drop before. This returns the EReference of container of the target, matching
	 * type of source.
	 * 
	 * @param targetContainer drop target container
	 * @param dropee first element drag source
	 * @return the reference within container of target, which matches source. (Have in mind that we are moving elements
	 *         within container of target.)
	 */
	protected EReference getTargetRef(EObject targetContainer, EObject dropee) {

		List<EReference> refs = targetContainer.eClass().getEAllContainments();
		for (EReference ref : refs) {
			if (ref.isContainer()) {
				continue;
			}
			// checking for source reference type is based only on first element
			// of drag source. We suppose that elements with different types are
			// not allowed to be drag and dropped.
			if (ref.getEReferenceType().equals(dropee.eClass())
				|| ref.getEReferenceType().isSuperTypeOf(dropee.eClass())) {
				return ref;
			}
		}
		return null;

	}

	/**
	 * drop before.
	 * 
	 * @param targetContainer target container
	 * @param target target
	 * @param source source
	 */
	@SuppressWarnings("unchecked")
	protected void dropBefore(EObject targetContainer, EObject target, List<EObject> source) {

		int targetIndex;

		EReference theRef = getTargetRef(targetContainer, source.get(0));
		if (theRef == null) {
			return;
		}

		Object object = target.eContainer().eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		if (eList != null) {
			targetIndex = eList.indexOf(target);
		} else {
			targetIndex = -1;
		}

		if (targetIndex == -1) {
			return;
		}

		if (haveSameEContainer(target, source.get(0))) {
			// We are just changing the order of elements inside the same container.
			// In this case the change recording handles a move notification and creates MultiReferenceMoveOperation.
			int sourceIndex = eList.indexOf(source.get(0));
			if (sourceIndex >= 0 && sourceIndex < targetIndex) {
				targetIndex--;
			}
			for (int i = source.size() - 1; i >= 0; i--) {
				eList.move(targetIndex, source.get(i));
			}

		} else {
			// we are moving an element from its old container to new container and dropping before target.
			eList.addAll(targetIndex, source);
		}

	}

	/**
	 * @param target target
	 * @param dropee dropee
	 * @return boolean
	 */
	protected boolean haveSameEContainer(EObject target, EObject dropee) {

		return target.eContainer().equals(dropee.eContainer());
	}

	/**
	 * Drop containment. Note: if we drop a model element with a bidirectional reference, we set the parent for drop
	 * source, instead of just adding drop source to target (container). This is because of change recording.
	 * 
	 * @param target target
	 * @param source source
	 */
	@SuppressWarnings("unchecked")
	protected void dropContainment(final EObject target, final List<EObject> source) {

		EReference theRef = getTargetRef(target, source.get(0));
		if (theRef == null) {
			return;
		}

		if (theRef.getEOpposite() != null) {
			// if it is a bidirectional reference, instead of adding source to target, set target to the opposite
			// reference.
			EReference oppositeRef = theRef.getEOpposite();
			for (EObject me : source) {
				Object object = me.eGet(oppositeRef);
				if (oppositeRef.isMany()) {
					EList<EObject> eList = (EList<EObject>) object;
					eList.add(target);
				} else {
					me.eSet(oppositeRef, target);
				}
			}

		} else {
			if (theRef.isMany()) {

				Object object = target.eGet(theRef);
				EList<EObject> eList = (EList<EObject>) object;
				eList.addAll(source);
			} else {
				target.eSet(theRef, source.get(0));
			}

		}

	}

	/**
	 * This checks if this source can be dropped on this target (taking also the drop effect into consideration). The
	 * most general case is if the target has the appropriate containment reference for source. Also if all elements in
	 * drop source come from the same level in tree (have the same container). These cases are handled here. Sub-Classes
	 * can override this method, to implement their own conditions.
	 * 
	 * @param event drop target event
	 * @param source source collection
	 * @param target target model element
	 * @param dropee first element of source
	 * @param eventFeedback @see UCDropAdapter.eventFeedback
	 * @return if this source can be dropped on target
	 */
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<EObject> source, EObject target,
		EObject dropee) {

		// moved from ComposedDropAdapter
		if (source.size() > 1) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		// a container is not allowed to contain the same element twice
		if (target.eContents().contains(dropee)) {
			if (!((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER || (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE)) {
				event.detail = DND.DROP_NONE;
				return false;
			}

		}

		// do not drop an element on itself
		if (target == dropee) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		// do not drop an element on one of its children. this leads to circular
		// reference
		// in containment hierarchy and the element and all of its children get
		// lost
		// (this creates an island)
		if (EcoreUtil.isAncestor(dropee, target)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if (!haveSameEContainer(source)) {
			return false;
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
			|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			if (!hasThisContainmentReference(target.eContainer(), dropee.eClass())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This checks if all elements is drag source collection come from the same container (level in tree).
	 * 
	 * @param source source
	 * @return true or false
	 */
	protected boolean haveSameEContainer(List<EObject> source) {
		EObject first = source.get(0);
		for (EObject me : source) {
			if (!first.eContainer().equals(me.eContainer())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This checks if target has appropriate containment reference for source. Sub-Classes should override this.
	 * 
	 * @param target target
	 * @param refType refType
	 * @return true or false
	 */
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {

		boolean result = false;

		for (EReference ref : target.eClass().getEAllContainments()) {

			if (!ref.isContainer()
				&& (ref.getEReferenceType().equals(refType) || ref.getEReferenceType().isSuperTypeOf(refType))) {

				result = true;
				break;
			}
		}

		return result;
	}

	// TODO: DOD - do we need this?
	// /**
	// * This returns the TransactionalEditingDomain.
	// *
	// * @return TransactionalEditingDomain
	// */
	// protected TransactionalEditingDomain getEditingDomain() {
	// return domain;
	// }

	/**
	 * Drop after or before.
	 * 
	 * @param targetContainer target's container
	 * @param target target
	 * @param source source
	 * @param after drop after or drop before
	 */
	public void dropMove(final EObject targetContainer, final EObject target, final List<EObject> source,
		final boolean after) {

		// target is the model element after/before which we drop.
		if (!getTargetRef(targetContainer, target).equals(getTargetRef(targetContainer, source.get(0)))) {

			return;
		}

		if (after) {
			dropAfter(targetContainer, target, source);
		} else {
			dropBefore(targetContainer, target, source);
		}

	}

	/**
	 * Returns the viewer.
	 * 
	 * @return viewer
	 */
	public StructuredViewer getViewer() {
		return viewer;
	}

}
