package org.unicase.model.edit.uihint;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface UIHintAdapter {
	FeatureUIHint getFeatureUIHint(EStructuralFeature feature);

	EObjectUIHint getEObjectUIHint(EObject eObject);
}
