/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.metamodel.ModelElement;

/**
 * A {@link IAttributeDescriptor} using the category property in the genmodel.
 * 
 * @author shterevg
 */
public class CategoryDescriptor implements IAttributeDescriptor<Double> {

	/**
	 * {@inheritDoc}
	 */
	public Double getValue(IItemPropertyDescriptor propertyDescriptor, ModelElement modelElement) {
		String s = propertyDescriptor.getCategory(modelElement);
		if (s == null) {
			s = "100.0";
		}
		double ret = Double.parseDouble(s);
		return ret;
	}

}
