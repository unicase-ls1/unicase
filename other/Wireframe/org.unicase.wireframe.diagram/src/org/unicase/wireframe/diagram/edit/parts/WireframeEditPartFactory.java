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
