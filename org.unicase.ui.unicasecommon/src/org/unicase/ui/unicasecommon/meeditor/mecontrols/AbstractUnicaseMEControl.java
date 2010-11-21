/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Abstract Control only for use with unicase meta model. Ensures that model lement is a sub tsype of
 * {@link ModelElement}
 * 
 * @author helming
 */
public abstract class AbstractUnicaseMEControl extends AbstractMEControl {
	/**
	 * ensures that Modelelement is a subtype of {@link ModelElement}.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#getModelElement()
	 * @return the model element
	 */
	@Override
	public ModelElement getModelElement() {
		if (super.getModelElement() instanceof ModelElement) {
			return (ModelElement) super.getModelElement();
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Only accepts subtypes of {@link ModelElement}.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#setModelElement(org.eclipse.emf.ecore.EObject)
	 * @param modelElement the model element
	 */
	@Override
	public void setModelElement(EObject modelElement) {
		if (modelElement instanceof ModelElement) {
			super.setModelElement(modelElement);
		} else {
			throw new IllegalArgumentException("Unicase Controls are only usable with ModelElement, not with EObjects");
		}
	}

	/**
	 * Checks if model element is a subtype of {@link ModelElement} and return 0 if not.
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject) {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		if (modelElement instanceof ModelElement) {
			return canRender(itemPropertyDescriptor, (ModelElement) modelElement);
		}
		return DO_NOT_RENDER;
	}

	/**
	 * @param itemPropertyDescriptor the property descriptor
	 * @param modelElement the model element
	 * @return if the control can render a certain attribute.
	 */
	public abstract int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement);

}
