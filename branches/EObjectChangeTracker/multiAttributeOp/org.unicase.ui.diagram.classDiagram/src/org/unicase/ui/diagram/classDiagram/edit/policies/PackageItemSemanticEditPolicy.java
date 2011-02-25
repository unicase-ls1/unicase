/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends
	org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
			: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated NOT Generates the relationship and passes the diagram to the custom constructor
	 * @param req The request that triggered the command
	 * @return The created command
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyCreateCommand(req, req
				.getSource(), req.getTarget(),
			// custom code
				(EObject) getHost().getModel()));
		}
		return null;
	}

	/**
	 * @generated NOT Generates the relationship and passes the diagram to the custom constructor
	 * @param req The request that triggered the command
	 * @return The created command
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyCreateCommand(req, req
				.getSource(), req.getTarget(),
			// custom code
				(EObject) getHost().getModel()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
