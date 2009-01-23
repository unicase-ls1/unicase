/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.dnd.dropadapters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.document.Section;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * This is the super class for all model element specific drop adapters. We can consider this class as if ModelElement
 * was drop target.
 * 
 * @author Hodaie
 */
public class MEDropAdapter {

	private TransactionalEditingDomain domain;
	private StructuredViewer viewer;

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public MEDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		this.domain = domain;
		this.viewer = viewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param source
	 * @param target
	 */

	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {

		if (source.get(0) instanceof Annotation) {
			annotateME(source, target);
		} else {
			dropContainment(target, source);
		}

	}

	private void annotateME(List<ModelElement> source, final ModelElement target) {
		Annotation[] arr = source.toArray(new Annotation[source.size()]);
		List<Annotation> newAnnotations = Arrays.asList(arr);
		target.getAnnotations().addAll(newAnnotations);
	}

	/**
	 * @param targetContainer target's container
	 * @param target target
	 * @param source source
	 */
	@SuppressWarnings("unchecked")
	protected void dropAfter(EObject targetContainer, ModelElement target, List<ModelElement> source) {

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
	protected EReference getTargetRef(EObject targetContainer, ModelElement dropee) {

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
	protected void dropBefore(EObject targetContainer, ModelElement target, List<ModelElement> source) {

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
			int sourceIndex = eList.indexOf(source.get(0));
			if (sourceIndex >= 0 && sourceIndex < targetIndex) {
				targetIndex--;
			}
			for (int i = source.size() - 1; i >= 0; i--) {
				eList.move(targetIndex, source.get(i));
			}

		} else {
			eList.addAll(targetIndex, source);
		}

	}

	/**
	 * @param target target
	 * @param dropee dropee
	 * @return boolean
	 */
	protected boolean haveSameEContainer(ModelElement target, ModelElement dropee) {

		return target.eContainer().equals(dropee.eContainer());
	}

	/**
	 * Drop containment.
	 * 
	 * @param target target
	 * @param source source
	 */
	@SuppressWarnings("unchecked")
	protected void dropContainment(final ModelElement target, final List<ModelElement> source) {

		EReference theRef = getTargetRef(target, source.get(0));
		if (theRef == null) {
			return;
		}

		Object object = target.eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		eList.addAll(source);

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
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<ModelElement> source, ModelElement target,
		ModelElement dropee) {

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

		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(target);
		Usersession userSession = projectSpace.getUsersession();
		if (dropee instanceof Section && !UnicaseUiUtil.isProjectAdmin(userSession, projectSpace)) {
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
		} else if (!(dropee instanceof Annotation) && !hasThisContainmentReference(target, dropee.eClass())) {
			return false;
		}

		return true;
	}

	/**
	 * This checks if all elements is drag source collection come from the same container (level in tree).
	 * 
	 * @param source source
	 * @return true or false
	 */
	protected boolean haveSameEContainer(List<ModelElement> source) {
		ModelElement first = source.get(0);
		for (ModelElement me : source) {
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

	/**
	 * This returns the TransactionalEditingDomain.
	 * 
	 * @return TransactionalEditingDomain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return domain;
	}

	/**
	 * Drop after or before.
	 * 
	 * @param targetContainer target's container
	 * @param target target
	 * @param source source
	 * @param after drop after or drop before
	 */
	public void dropMove(final EObject targetContainer, final ModelElement target, final List<ModelElement> source,
		final boolean after) {

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
