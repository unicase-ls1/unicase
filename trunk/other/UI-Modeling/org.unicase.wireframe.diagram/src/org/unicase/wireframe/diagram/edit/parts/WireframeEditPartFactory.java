package org.unicase.wireframe.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry;

/**
 * @generated
 */
public class WireframeEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (WireframeVisualIDRegistry.getVisualID(view)) {

			case PanelEditPart.VISUAL_ID:
				return new PanelEditPart(view);

			case WindowEditPart.VISUAL_ID:
				return new WindowEditPart(view);

			case WindowTextEditPart.VISUAL_ID:
				return new WindowTextEditPart(view);

			case LabelEditPart.VISUAL_ID:
				return new LabelEditPart(view);

			case LabelTextEditPart.VISUAL_ID:
				return new LabelTextEditPart(view);

			case TextFieldEditPart.VISUAL_ID:
				return new TextFieldEditPart(view);

			case TextFieldTextEditPart.VISUAL_ID:
				return new TextFieldTextEditPart(view);

			case ButtonEditPart.VISUAL_ID:
				return new ButtonEditPart(view);

			case TextEditPart.VISUAL_ID:
				return new TextEditPart(view);

			case TextTextEditPart.VISUAL_ID:
				return new TextTextEditPart(view);

			case ImageEditPart.VISUAL_ID:
				return new ImageEditPart(view);

			case ImageTextEditPart.VISUAL_ID:
				return new ImageTextEditPart(view);

			case Button2EditPart.VISUAL_ID:
				return new Button2EditPart(view);

			case Image2EditPart.VISUAL_ID:
				return new Image2EditPart(view);

			case ImageText2EditPart.VISUAL_ID:
				return new ImageText2EditPart(view);

			case Label2EditPart.VISUAL_ID:
				return new Label2EditPart(view);

			case LabelText2EditPart.VISUAL_ID:
				return new LabelText2EditPart(view);

			case Text2EditPart.VISUAL_ID:
				return new Text2EditPart(view);

			case TextText2EditPart.VISUAL_ID:
				return new TextText2EditPart(view);

			case TextField2EditPart.VISUAL_ID:
				return new TextField2EditPart(view);

			case TextFieldText2EditPart.VISUAL_ID:
				return new TextFieldText2EditPart(view);

			case WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
				return new WindowWindowWidgetCompartmentEditPart(view);
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
