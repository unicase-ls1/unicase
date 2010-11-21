/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.document.DocumentPackage;

/**
 * This is the drop adapter for Projects. Used to change order of first level composite sections.
 * 
 * @author Hodaie
 */
public class ProjectDropAdapter extends UCDropAdapter {

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
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#dropMove(org.eclipse.emf.ecore.EObject,
	 *      org.unicase.metamodel.ModelElement, java.util.List, boolean)
	 */
	@Override
	public void dropMove(EObject targetContainer, ModelElement target, List<ModelElement> source, boolean after) {
		super.dropMove(targetContainer, target, source, after);
		getViewer().refresh();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return MetamodelPackage.eINSTANCE.getProject();
	}

}
