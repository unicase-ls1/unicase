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

			case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
				return new org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart(view);
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
