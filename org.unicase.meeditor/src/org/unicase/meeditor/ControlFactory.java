package org.unicase.meeditor;

import java.util.Date;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class ControlFactory {
	private final EObject modelElement;
	private final EditingDomain editingDomain;
	private FormToolkit toolkit;

	public ControlFactory(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}

	public MEControl createControl(EStructuralFeature feature) {
		EAnnotation annotation = feature
				.getEAnnotation("http://www.unicase.org/View");
		EMap<String, String> details = null;
		if (annotation != null) {
			details = annotation.getDetails();
		}
		if (feature instanceof EAttribute) {
			if (details != null) {
				if (details.get("type").equals("TEXT_AREA")) {
					return createMETextAreaControl((EAttribute) feature);
				}
			}
			if (feature.getEType().getInstanceClass().equals(boolean.class)) {
				return createMEBoolControl((EAttribute) feature);
			}

			if (feature.getEType().getInstanceClass().equals(int.class)) {
				return createMEIntControl((EAttribute) feature);
			}
			if (feature.getEType().getInstanceClass().equals(Date.class)) {
				return createMEDateControl((EAttribute) feature);
			}

			return createMETextControl((EAttribute) feature);
		}
		if (feature instanceof EReference && feature.getUpperBound() != 1) {
			EReference reference = (EReference) feature;
			if (reference.isMany()) {
				return createMELinkControl((EReference) feature);
			}

		}

		if (feature instanceof EReference && feature.getUpperBound() == 1) {
			EReference reference = (EReference) feature;

			//return createMESingleLinkControl((EReference) feature);

		}

		return null;
		// TODO: Add other types
	}

	private MEControl createMEDateControl(EAttribute attribute) {
		return new MEDateControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMEIntControl(EAttribute attribute) {
		return new MEIntControl(attribute, toolkit, modelElement, editingDomain);
	}

	private MEControl createMEBoolControl(EAttribute attribute) {
		return new MEBoolControl(attribute, toolkit, modelElement,
				editingDomain);

	}

	private MEControl createMETextAreaControl(EAttribute attribute) {
		return new METextAreaControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMETextControl(EAttribute attribute) {
		return new METextControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMELinkControl(EReference reference) {
		return new MELinkControl(modelElement, reference, toolkit);
	}

}
