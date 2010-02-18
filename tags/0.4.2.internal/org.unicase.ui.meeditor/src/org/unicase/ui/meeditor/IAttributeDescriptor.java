/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.metamodel.ModelElement;

/**
 * Provides the priorities for a given attribute of a ME.
 * 
 * @param <A> the type of description (integer/string/double/etc.) for this attribute
 * @author shterevg
 */
public interface IAttributeDescriptor<A> {

	/**
	 * @param propertyDescriptor the property descriptor
	 * @param modelElement the model element
	 * @return Returns the property from a given propertyDescriptor as an A value.
	 */
	A getValue(IItemPropertyDescriptor propertyDescriptor, ModelElement modelElement);
}