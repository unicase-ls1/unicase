/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol.associationclasscontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;

/**
 * This class is a simple widget that do not show any reference to a AssociationClassElement if it is not referenced by
 * source or target. (e.g. MEDiagram elements in MEEditor view)
 * 
 * @author Michael Haeger
 */
public class AssociationClassLinkNotShow extends MELinkControl {
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
			Object ref = itemPropertyDescriptor.getFeature(contextModelElement);
			if (getContext().isAssociationClassElement(link) && ref instanceof EReference) {
				ECPAssociationClassElement association = getContext().getAssociationClassElement(link);
				// display if the given reference opposite is not source or target feature: the given object can not be
				// source or target of the association
				if (!(association.getSourceFeature().equals(((EReference) ref).getEOpposite()) || association
					.getTargetFeature().equals(((EReference) ref).getEOpposite()))) {
					return PRIORITY;
				}
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl#createControl(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	protected Control createControl(final Composite parent, int style) {
		// display nothing
		return null;
	}
}
