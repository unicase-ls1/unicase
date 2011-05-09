/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

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
	A getValue(IItemPropertyDescriptor propertyDescriptor, EObject modelElement);
}
