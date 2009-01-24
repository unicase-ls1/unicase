/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.document.DocumentPackage;

/**
 * This is the drop adapter for Projects.
 * 
 * @author Hodaie
 */
public class ProjectDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public ProjectDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);
	}

	// @Override
	// public boolean canDrop(int eventFeedback, DropTargetEvent event, List<ModelElement> source, ModelElement target,
	// ModelElement dropee) {
	// return
	// }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {

		if (refType.equals(DocumentPackage.eINSTANCE.getCompositeSection())) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.model.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#dropMove(org.eclipse.emf.ecore.EObject,
	 *      org.unicase.model.ModelElement, java.util.List, boolean)
	 */
	@Override
	public void dropMove(EObject targetContainer, ModelElement target, List<ModelElement> source, boolean after) {
		super.dropMove(targetContainer, target, source, after);
		getViewer().refresh();

	}

}
