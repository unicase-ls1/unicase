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
public class CheckboxGroupCheckboxesCompartmentItemSemanticEditPolicy extends
	org.unicase.uiModeling.diagram.edit.policies.UiModelingBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CheckboxGroupCheckboxesCompartmentItemSemanticEditPolicy() {
		super(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.CheckboxCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
