/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Abstract Control only for use with unicase meta model. Ensures that model elment is a sub type of {@link EObject}
 * 
 * @author helming
 */
public abstract class AbstractUnicaseMEControl extends AbstractMEControl {
	/**
	 * ensures that Modelelement is a subtype of {@link EObject}.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#getModelElement()
	 * @return the model element
	 */
	@Override
	public EObject getModelElement() {
		if (super.getModelElement() != null) {
			return super.getModelElement();
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Only accepts subtypes of {@link EObject}.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#setModelElement(org.eclipse.emf.ecore.EObject)
	 * @param modelElement the model element
	 */
	@Override
	public void setModelElement(EObject modelElement) {
		if (modelElement != null) {
			super.setModelElement(modelElement);
		} else {
			throw new IllegalArgumentException("Unicase Controls are only usable with ModelElement, not with EObjects");
		}
	}

	/**
	 * Checks if model element is a subtype of {@link EObject} and return 0 if not.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject) {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		if (modelElement != null) {
			return canRender(itemPropertyDescriptor, modelElement);
		}
		return DO_NOT_RENDER;
	}
}
