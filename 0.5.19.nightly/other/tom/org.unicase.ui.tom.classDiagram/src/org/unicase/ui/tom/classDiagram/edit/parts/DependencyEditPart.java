/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.tom.tools.TouchSelectConnectionEditPartTracker;

/**
 * @generated
 */
public class DependencyEditPart extends org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart implements
		ITreeBranchEditPart {

	public DependencyEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @generated NOT
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request req) {
		return new TouchSelectConnectionEditPartTracker(this);
	}

}
