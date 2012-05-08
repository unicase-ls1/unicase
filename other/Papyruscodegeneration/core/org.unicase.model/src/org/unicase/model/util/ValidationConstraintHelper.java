/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.UnicaseModelElement;

/**
 * Helps with validation of modelelements.
 * 
 * @author naughton
 */
public final class ValidationConstraintHelper {

	private static AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	private ValidationConstraintHelper() {
	}

	/**
	 * Returns the structural feature specified by the feature name belonging to the model element.
	 * 
	 * @param modelElement the modelElement
	 * @param featureName the featureName
	 * @return the structuralFeature
	 */
	public static EStructuralFeature getErrorFeatureForModelElement(UnicaseModelElement modelElement, String featureName) {
		init();
		IItemPropertyDescriptor itemPropertyDescriptor = adapterFactoryItemDelegator.getPropertyDescriptor(
			modelElement, featureName);
		EStructuralFeature errorFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		return errorFeature;
	}

	private static void init() {
		if (adapterFactoryItemDelegator == null) {
			adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}
	}
}
