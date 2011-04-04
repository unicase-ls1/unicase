/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.dnd.DragSourcePlaceHolder;
import org.eclipse.emf.ecp.model.ECPModelelementContext;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;

/**
 * @author Hodaie
 */
public class MEMultiLinkControlDropAdapter implements DropTargetListener {

	private List<EObject> source;
	private EObject dropee;
	private EObject target;
	private EReference reference;
	private final ECPModelelementContext modelElementContext;

	/**
	 * @param me MEEditor input
	 * @param reference EReference being shown in the section
	 * @param modelElementContext the {@link ECPModelelementContext}
	 */
	public MEMultiLinkControlDropAdapter(EObject me, EReference reference, ECPModelelementContext modelElementContext) {

		this.reference = reference;

		target = me;
		this.modelElementContext = modelElementContext;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragEnter(DropTargetEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void drop(DropTargetEvent event) {
		if (dropee != null) {
			new ECPCommand(dropee) {
				@Override
				protected void doRun() {
					addME();
				}
			};
		}
	}

	@SuppressWarnings("unchecked")
	private void addME() {
		if (reference == null) {
			return;
		}

		if (reference.getEOpposite() != null) {
			// if it is a bidirectional reference, instead of adding source to target, set target to the opposite
			// reference.
			EReference oppositeRef = reference.getEOpposite();
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

			if (reference.isMany()) {
				Object object = target.eGet(reference);
				EList<EObject> eList = (EList<EObject>) object;
				eList.addAll(source);

			} else {
				target.eSet(reference, source.get(0));
			}

		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragLeave(DropTargetEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragOperationChanged(DropTargetEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dragOver(DropTargetEvent event) {
		source = null;
		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget()) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (source.size() > 1) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (!canDrop(event)) {
			event.detail = DND.DROP_NONE;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	public void dropAccept(DropTargetEvent event) {
	}

	/**
	 * This checks if this source can be dropped on this target (taking also the drop effect into consideration). The
	 * most general case is if the target has the appropriate containment reference for source. Also if all elements in
	 * drop source come from the same level in tree (have the same container). These cases are handled here. Sub-Classes
	 * can override this method, to implement their own conditions.
	 * 
	 * @param event drop target event
	 * @return if this source can be dropped on target
	 */
	public boolean canDrop(DropTargetEvent event) {

		// do not drop an element on itself
		if (target == dropee) {
			return false;
		}

		// do not drop an element on one of its children. this leads to circular
		// reference
		// in containment hierarchy and the element and all of its children get
		// lost
		// (this creates an island)
		if (EcoreUtil.isAncestor(dropee, target)) {
			return false;
		}

		// only project admins are allowed to change document structure
		// TODO: Check if we need this
		// ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(target);
		// Usersession userSession = projectSpace.getUsersession();
		// if (dropee instanceof Section && !UiUtil.isProjectAdmin(userSession, projectSpace)) {
		// return false;
		// }

		// for the case of multi selection (not implemented yet) only allow drop, if all dropees come from the same
		// container
		if (!haveSameEContainer(source)) {
			return false;
		}

		// drop only allowed elements
		EClass eReferenceType = reference.getEReferenceType();
		if (!eReferenceType.isSuperTypeOf(dropee.eClass())
			&& !eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())) {
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
	 * This is called continually from dragOver() event handler. This checks drop target and drop source to be not Null,
	 * and sets the target, source, and dropee fields.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget() {
		boolean result = true;
		if (target == null) {
			return false;
		}
		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder.getDragSource();
		if (tmpSource == null) {
			result = false;
		}

		for (Object obj : tmpSource) {
			if (!(obj instanceof EObject)) {
				result = false;
			}
		}

		source = (List<EObject>) DragSourcePlaceHolder.getDragSource();
		if (source.size() == 0) {
			return false;
		}

		// check if source and target are in the same project
		if (result) {
			dropee = source.get(0);
			if (modelElementContext.contains(dropee)) {
				result = false;
			}
		}

		return result;
	}

}
