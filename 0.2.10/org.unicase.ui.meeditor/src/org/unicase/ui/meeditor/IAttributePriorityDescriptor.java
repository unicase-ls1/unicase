/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.ModelElement;

/**
 * Provides the priorities for a given attribute of a ME. 
 * @author shterevg
 *
 */
public interface IAttributePriorityDescriptor {
	
	/**
	 * @param propertyDescriptor the property descriptor
	 * @param modelElement the model element
	 * @return Returns the priority from a given propertyDescriptor as a double. 
	 */
	double getPriority(IItemPropertyDescriptor propertyDescriptor, ModelElement modelElement);
}