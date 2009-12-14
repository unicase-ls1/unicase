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
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;

/**
 * This is the drop adapter for LeafSections.
 * 
 * @author Hodaie
 */
public class LeafSectionDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public LeafSectionDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);

	}

	/**
	 * {@inheritDoc} Note: if we drop a model element with a bidirectional reference, we set the parent for drop source,
	 * instead of just adding drop source to target (container). This is because of change recording.
	 * 
	 * @see org.unicase.ui.unicasecommon.common.dnd.dropadapters.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, UnicaseModelElement target, List<UnicaseModelElement> source) {
		UnicaseModelElement dropee = source.get(0);
		if (!(dropee instanceof Annotation)) {
			super.drop(event, target, source);
		} else {
			for (UnicaseModelElement me : source) {
				((Annotation) me).setLeafSection((LeafSection) target);
			}
		}

	}

	/**
	 * {@inheritDoc} You cannot drop a Section (Composite- or LeafSection) on a LeafSection.
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {
		if (DocumentPackage.eINSTANCE.getSection().isSuperTypeOf(refType)) {
			return false;
		} else {
			return super.hasThisContainmentReference(target, refType);
		}

	}

}
