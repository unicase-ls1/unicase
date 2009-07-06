package org.unicase.model.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.ModelElement;

/**
 * Helps with validation of modelelements.
 * 
 * @author naughton
 * 
 */
public final class ValidationConstraintHelper {

	private ValidationConstraintHelper() {

	}

	/**
	 * Returns the structural feature specified by the feature name belonging to
	 * the model element.
	 * 
	 * @param modelElement
	 *            the modelElement
	 * @param featureName
	 *            the featureName
	 * @return the structuralFeature
	 */
	public static EStructuralFeature getErrorFeatureForModelElement(
			ModelElement modelElement, String featureName) {
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IItemPropertyDescriptor itemPropertyDescriptor = adapterFactoryItemDelegator
				.getPropertyDescriptor(modelElement, featureName);
		EStructuralFeature errorFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(modelElement);
		return errorFeature;
	}
}
