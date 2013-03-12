/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class UiModelingEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {

			case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.PanelEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WindowEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.LabelEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ImageEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WrappingLabelEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.Button2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.Image2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.Label2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.Text2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart(view);

			case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
