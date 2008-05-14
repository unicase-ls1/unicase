package org.unicase.meeditor;

import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.meeditor.mecontrols.MEBoolControl;
import org.unicase.meeditor.mecontrols.MEControl;
import org.unicase.meeditor.mecontrols.MEDateControl;
import org.unicase.meeditor.mecontrols.MEIntControl;
import org.unicase.meeditor.mecontrols.METextAreaControl;
import org.unicase.meeditor.mecontrols.METextControl;
import org.unicase.meeditor.mecontrols.melinkcontrol.MEMultiLinkControl;
import org.unicase.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;

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

	public MEControl createControl(IItemPropertyDescriptor itemPropertyDescriptor) {

		EStructuralFeature feature = (EStructuralFeature)itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute) {

			if (itemPropertyDescriptor.isMultiLine(modelElement)) {
				return createMETextAreaControl((EAttribute) feature);
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
				return createMELinkControl((EReference) feature, itemPropertyDescriptor);
			}
		}

		if (feature instanceof EReference && feature.getUpperBound() == 1) {
			EReference reference = (EReference) feature;
			return createMESingleLinkControl(reference);

		}

		return null;
		// TODO: Add other types
	}

	private MEControl createMESingleLinkControl(EReference reference) {
		return new MESingleLinkControl(editingDomain, modelElement, toolkit, reference);
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

	private MEControl createMELinkControl(EReference reference, IItemPropertyDescriptor itemPropertyDescriptor) {
		return new MEMultiLinkControl(modelElement, reference, toolkit, editingDomain,itemPropertyDescriptor);
	}

}
