/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.filtering;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Filter set of urml model elements to a certain element type. 
 * @author kterzieva
 *
 */
public class ElementTypeFilter {

	private EClass filterToType;
	
	/**
	 * The construct.
	 * @param filterToType the type of model elements to be filtered out
	 */
	public ElementTypeFilter(EClass filterToType) {
		this.filterToType = filterToType;
	}
	
	/**
	 * Filters the type of model elements given in the construct.
	 * @param elements model elements to filtered from
	 * @return collection of filtered elements
	 */
	public Collection<UrmlModelElement> filter(Collection<UrmlModelElement> elements){
		Collection<UrmlModelElement> result = new ArrayList<UrmlModelElement>();
		if(filterToType == null){
			return result;
		}
		for (UrmlModelElement e : elements) {
			if (filterToType.isSuperTypeOf(e.eClass())) {
				result.add(e);
			}
		}
		return result;
	}
}
