/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.melinkcontrol.associationclasscontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;

/**
 * This class is a simple widget that do not show any delete button on source or target feature in an association. (An
 * AssociationClassElement could not exist without source or target.)
 * 
 * @author Michael Haeger
 */
public class AssociationClassLinkNoDelete extends MELinkControl {
	private static final int PRIORITY = 2;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link, EObject contextModelElement) {
		if (getContext() != null) {
			if (getContext().getMetaModelElementContext().isAssociationClassElement(contextModelElement)) {
				ECPAssociationClassElement association = getContext().getMetaModelElementContext()
					.getAssociationClassElement(contextModelElement);
				// display if given reference is equal to source or target feature
				if (association.getSourceFeature().equals(itemPropertyDescriptor.getFeature(link))
					|| association.getTargetFeature().equals(itemPropertyDescriptor.getFeature(link))) {
					return PRIORITY;
				}
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl#createDeleteAction(int)
	 */
	@Override
	protected void createDeleteAction(int style) {
		// display nothing
	}
}
