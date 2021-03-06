/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.filtering;

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
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;

/**
 * Filter class for the URML diagram.
 * @author kterzieva
 * 
 */
public class DiagramFilter implements UrmlDiagramFilter {

	/**
	 * The construct.
	 */
	public DiagramFilter() {
		// TODO Auto-generated constructor stub
	}

	private boolean select(EObject modelElement,
			EMap<EClass, EList<EStructuralFeature>> filterSet) {
		if (!(modelElement instanceof UrmlModelElement)) {
			return true;
		}
		if (filterSet.containsKey(modelElement.eClass())) {
			return true;
		}
		return false;

	}

	@Override
	public List<?> filter(List<?> elements) {
		StakeholderRole role = UrmlSettingsManager.INSTANCE.getActiveRole();

		if (role == null) {
			return elements;
		}

		List<Object> result = new ArrayList<Object>();

		for (Object o : elements) {
			if (o instanceof Shape) {
				Shape shape = (Shape) o;
				EObject elem = shape.getElement();
				if (select(elem, role.getFilterSet())) {
					result.add(shape);
				}
			} else {
				//other elements stay unfiltered
				result.add(o);
			}
		}

		return result;
	}

}
