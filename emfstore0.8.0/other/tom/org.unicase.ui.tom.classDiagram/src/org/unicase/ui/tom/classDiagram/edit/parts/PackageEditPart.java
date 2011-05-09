/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
