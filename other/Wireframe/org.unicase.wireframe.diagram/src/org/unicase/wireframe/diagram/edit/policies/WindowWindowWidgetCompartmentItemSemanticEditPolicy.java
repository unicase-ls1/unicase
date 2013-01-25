/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.unicase.wireframe.diagram.edit.commands.Button2CreateCommand;
import org.unicase.wireframe.diagram.edit.commands.Image2CreateCommand;
import org.unicase.wireframe.diagram.edit.commands.Label2CreateCommand;
import org.unicase.wireframe.diagram.edit.commands.Text2CreateCommand;
import org.unicase.wireframe.diagram.edit.commands.TextField2CreateCommand;
import org.unicase.wireframe.diagram.providers.WireframeElementTypes;

/**
 * @generated
 */
public class WindowWindowWidgetCompartmentItemSemanticEditPolicy extends WireframeBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public WindowWindowWidgetCompartmentItemSemanticEditPolicy() {
		super(WireframeElementTypes.Window_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WireframeElementTypes.Button_3001 == req.getElementType()) {
			return getGEFWrapper(new Button2CreateCommand(req));
		}
		if (WireframeElementTypes.Image_3002 == req.getElementType()) {
			return getGEFWrapper(new Image2CreateCommand(req));
		}
		if (WireframeElementTypes.Label_3003 == req.getElementType()) {
			return getGEFWrapper(new Label2CreateCommand(req));
		}
		if (WireframeElementTypes.Text_3004 == req.getElementType()) {
			return getGEFWrapper(new Text2CreateCommand(req));
		}
		if (WireframeElementTypes.TextField_3005 == req.getElementType()) {
			return getGEFWrapper(new TextField2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
