/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ClassClassNode_attributesItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassNode_attributesItemSemanticEditPolicy() {
		super(
				org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Attribute_3001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.AttributeCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
