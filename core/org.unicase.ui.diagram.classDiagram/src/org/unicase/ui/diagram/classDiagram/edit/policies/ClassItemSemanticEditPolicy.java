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
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassItemSemanticEditPolicy() {
		super(
				org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(node)) {
			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(),
										cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(),
										cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
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
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated NOT
	 * @param req The request which triggers the creation of the command
	 * @return The new RelationshipCreateCommand
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType elementType = req.getElementType();

		if (elementType == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001) {
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.AssociationCreateCommand(req,
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
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.AssociationCreateCommand(req,
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
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.AssociationReorientCommand(
					req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association2ReorientCommand(
					req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association3ReorientCommand(
					req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.Association4ReorientCommand(
					req));
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.DependencyReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.classDiagram.edit.commands.ClassSuperClassesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
