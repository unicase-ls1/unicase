/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassItemSemanticEditPolicy extends
	org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
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
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(node)) {
			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(cnode)) {
					case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(cnode)) {
					case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
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
	 * @param req The request which triggers the creation of the command
	 * @return The new RelationshipCreateCommand
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType elementType = req.getElementType();

		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association1CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association2CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association3CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association4CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.ClassSuperClassesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyCreateCommand(req, req
				.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	/**
	 * @param req The request that triggers the command creation
	 * @return The new {@link CreateElementCommand}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType elementType = req.getElementType();

		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association1CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association2CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association3CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}
		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association4CreateCommand(req,
				req.getSource(), req.getTarget(), (EObject) getHost().getModel()));
		}

		if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.ClassSuperClassesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}

		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyCreateCommand(req, req
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
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association1ReorientCommand(req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association2ReorientCommand(req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association3ReorientCommand(req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association4ReorientCommand(req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
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
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.ClassSuperClassesReorientCommand(
				req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
