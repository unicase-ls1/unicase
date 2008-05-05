package org.unicase.model.edit.uihint;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

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

		return featureUIHint;
	}

}
