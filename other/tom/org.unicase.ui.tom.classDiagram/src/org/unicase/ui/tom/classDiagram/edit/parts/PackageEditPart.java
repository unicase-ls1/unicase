package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.tom.classDiagram.edit.policies.TouchResizableShapeEditPolicy;

/**
 * @generated
 */
public class PackageEditPart extends org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart {

	public PackageEditPart(View view) {
		super(view);
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new TouchResizableShapeEditPolicy();
	}

}
