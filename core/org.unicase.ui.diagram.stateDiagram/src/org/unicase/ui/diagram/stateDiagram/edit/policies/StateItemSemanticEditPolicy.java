/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.unicasecommon.diagram.commands.DeleteFromModelCommand;

/**
 * @generated
 */
public class StateItemSemanticEditPolicy extends
	org.unicase.ui.diagram.stateDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

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
	 * @generated NOT
	 * @param req The {@link CreateRelationshipRequest} for the command
	 * @return A Command in response to the command
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.TransitionCreateCommand(req, req
				.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.TransitionCreateCommand(req, req
				.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.TransitionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
