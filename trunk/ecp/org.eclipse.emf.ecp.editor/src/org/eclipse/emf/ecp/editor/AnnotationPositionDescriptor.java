/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * A {@link IAttributeDescriptor} using the annotation in the genmodel.
 * 
 * @author Shterev
 */
public class AnnotationPositionDescriptor implements IAttributeDescriptor<String> {

	private String defaultValue = "left";

	/**
	 * {@inheritDoc}
	 */
	public String getValue(IItemPropertyDescriptor propertyDescriptor, EObject modelElement) {
		EAnnotation priority = ((EStructuralFeature) propertyDescriptor.getFeature(modelElement))
			.getEAnnotation("org.unicase.ui.meeditor");
		if (priority == null || priority.getDetails() == null || priority.getDetails().get("position") == null) {
			return defaultValue;
		}
		String s = priority.getDetails().get("position");
		return s;
	}

}
