/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;

/**
 * Utility class for ModelElements.
 * @author koegel
 *
 */
public final class ModelUtil {
	
	
	/**
	 * Private constructor.
	 */
	private ModelUtil() {
		//nothing to do
	}
	
	/**
	 * Clone the model element. 
	 * The model element id will be the same in the clone.
	 * @param modelElement the model element to clone
	 * @return a clone
	 */
	public static ModelElement clone(ModelElement modelElement) {
		EObject copy = EcoreUtil.copy(modelElement);
		return (ModelElement) copy;
	}

	/**
	 * Copy a model element.
	 * The new model element has a new unique id.
	 * @param modelElement the model element
	 * @return a copy of the given model element
	 */
	public static ModelElement copy(ModelElement modelElement) {
		ModelElement copy = (ModelElement) EcoreUtil.copy(modelElement);
		//reset id
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		copy.setIdentifier(modelElementId.getId());
		//FIXME what about the containment tree is it copied, do we have to change ids too?
		return copy;
	}
	
	/**
	 * Clone the model element id. 
	 * 
	 * @param modelElementId the model element id to clone
	 * @return a clone
	 */
	public static ModelElementId clone(ModelElementId modelElementId) {
		EObject copy = EcoreUtil.copy(modelElementId);
		return (ModelElementId) copy;
	}
}
