/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * A {@link IAttributeDescriptor} using the annotation in the genmodel.
 * 
 * @author Shterev
 */
public class AnnotationPriorityDescriptor implements IAttributeDescriptor<Double> {

	private double defaultValue = 100.0;

	/**
	 * {@inheritDoc}
	 */
	public Double getValue(IItemPropertyDescriptor propertyDescriptor, EObject modelElement) {
		EAnnotation priority = ((EStructuralFeature) propertyDescriptor.getFeature(modelElement))
			.getEAnnotation("org.unicase.ui.meeditor");
		if (priority == null || priority.getDetails() == null || priority.getDetails().get("priority") == null) {
			return defaultValue;
		}
		String s = priority.getDetails().get("priority");
		return Double.parseDouble(s);
	}

}
