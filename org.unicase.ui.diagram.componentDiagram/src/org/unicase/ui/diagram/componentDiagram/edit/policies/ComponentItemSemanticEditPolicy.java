/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.unicasecommon.diagram.commands.DeleteFromModelCommand;

/**
 * @generated
 */
public class ComponentItemSemanticEditPolicy extends
	org.unicase.ui.diagram.componentDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DeleteFromModelCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
			: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_4001 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.componentDiagram.edit.commands.ComponentOfferedServicesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_4002 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.componentDiagram.edit.commands.ComponentConsumedServicesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_4001 == req
			.getElementType()) {
			return null;
		}
		if (org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_4002 == req
			.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.componentDiagram.edit.commands.ComponentOfferedServicesReorientCommand(
				req));
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.componentDiagram.edit.commands.ComponentConsumedServicesReorientCommand(
				req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
