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
 * A {@link IAttributeDescriptor} using the category property in the genmodel.
 * 
 * @author shterevg
 */
public class CategoryDescriptor implements IAttributeDescriptor<Double> {

	/**
	 * {@inheritDoc}
	 */
	public Double getValue(IItemPropertyDescriptor propertyDescriptor, EObject modelElement) {
		String s = propertyDescriptor.getCategory(modelElement);
		if (s == null) {
			s = "100.0";
		}
		double ret = Double.parseDouble(s);
		return ret;
	}

}
