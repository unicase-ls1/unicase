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
public class RadioGroupRadioButtonsCompartmentItemSemanticEditPolicy extends
	org.unicase.uiModeling.diagram.edit.policies.UiModelingBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RadioGroupRadioButtonsCompartmentItemSemanticEditPolicy() {
		super(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.RadioButtonCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
