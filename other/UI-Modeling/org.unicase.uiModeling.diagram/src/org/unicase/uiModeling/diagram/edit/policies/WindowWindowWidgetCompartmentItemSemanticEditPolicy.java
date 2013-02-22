/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class WindowWindowWidgetCompartmentItemSemanticEditPolicy extends
	org.unicase.uiModeling.diagram.edit.policies.UiModelingBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public WindowWindowWidgetCompartmentItemSemanticEditPolicy() {
		super(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.Button2CreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.Image2CreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.Label2CreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.Text2CreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.TextField2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
