/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.AssociationClassElement;

/**
 * Context for a modelelement.
 * 
 * @author helming
 */
public interface ECPModelelementContext {
	/**
	 * returns all model elements in a context.
	 * 
	 * @return a list of model elements
	 */
	Collection<EObject> getAllModelElements();

	/**
	 * Returns the editing domain.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * Whether a {@link EObject} is a association class. Association classes are not displayed as dedicated elements. A
	 * link from one element to another which goes over an association class is displayed by a dedicated widget. This
	 * widgets allows to trace transparently without seeing the association class.
	 * 
	 * @param eObject the {@link EObject}
	 * @return if it is an association
	 */
	boolean isAssociationClassElement(EObject eObject);

	/**
	 * Returns an {@link AssociationClassElement} wrapper for a {@link EObject}.
	 * 
	 * @param eObject the {@link EObject}
	 * @return the wrapper, {@code null} if {@link EObject} not exists
	 */
	ECPAssociationClassElement getAssociationClassElement(EObject eObject);

	/**
	 * Returns the {@link MetaModelElementContext}.
	 * 
	 * @return the {@link MetaModelElementContext}.
	 */
	MetaModelElementContext getMetaModelElementContext();
}
