/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Shape;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.urml.UrmlDiagramFilter;

/**
 * Filter class for the urml diagram.
 * @author kterzieva
 *
 */
public class StakeholderDiagramFilter implements UrmlDiagramFilter{

	
	private boolean select(EObject modelElement, EMap<EClass, EList<EStructuralFeature>> filterSet){
		if (!(modelElement instanceof UrmlModelElement)) {
			return true;
		} 
		if(filterSet.containsKey(modelElement.eClass())){
			return true;
		}
		return false;
			
	}
	
	@Override
	public List filter(List elements) {
		StakeholderRole role = StakeholderView.getActiveRole();
		
		if(role == null){
			return elements;
		}
		
		
		List result = new ArrayList();
		
		for(Object o : elements){
			if(o instanceof Shape){
				Shape shape = (Shape) o;
				EObject elem = shape.getElement();
				if(select(elem, role.getFilterSet())){
					result.add(shape);
				}
				
			} else {
				result.add(o);
			}
		}
		
		
		return result;
	}

}
