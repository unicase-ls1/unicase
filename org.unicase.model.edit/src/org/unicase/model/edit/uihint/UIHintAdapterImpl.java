package org.unicase.model.edit.uihint;

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class UIHintAdapterImpl implements UIHintAdapter {

	public EObjectUIHint getEObjectUIHint(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	public FeatureUIHint getFeatureUIHint(EStructuralFeature feature) {
		FeatureUIHint featureUIHint = new FeatureUIHint(feature.getName());

		EAnnotation annotation = feature
				.getEAnnotation("http://www.unicase.org/UIHints");
		EMap<String, String> details = null;
		if (annotation != null) {
			details = annotation.getDetails();
			if (details.containsKey("type")) {
				String type = details.get("type");
				if (type != null) {
					featureUIHint.setType(type);
				}
			}
		}
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ModelItemProviderAdapterFactory());
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
				.getPropertyDescriptors(feature);
		for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
			System.out.println(itemPropertyDescriptor.getDisplayName(feature));
		}

		return featureUIHint;
	}

}
