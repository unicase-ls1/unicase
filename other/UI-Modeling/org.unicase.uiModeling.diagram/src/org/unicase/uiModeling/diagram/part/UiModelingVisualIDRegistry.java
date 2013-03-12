/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node,
 * ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class UiModelingVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.uiModeling.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(view.getType())) {
				return org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
					"Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getPanel().isSuperTypeOf(domainElement.eClass())
			&& isDiagram((org.unicase.uiModeling.Panel) domainElement)) {
			return org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getModelID(containerView);
		if (!org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getWindow().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getLabel().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getTextField().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getButton().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getText().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImage().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioGroup()
				.isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckboxGroup().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownList().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImageButton().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getButton().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImage().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getLabel().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getText().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getTextField().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioGroup()
				.isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckboxGroup().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownList().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID;
			}
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImageButton().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioButton().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckbox().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownItem().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioButton().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckbox().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownItem().isSuperTypeOf(
				domainElement.eClass())) {
				return org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getModelID(containerView);
		if (!org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(org.unicase.uiModeling.Panel element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return false;
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
		case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.checkNodeVisualID(containerView,
				domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
