package org.unicase.ui.tom.classDiagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
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
public class ClassItemSemanticEditPolicy
		extends
		org.unicase.ui.tom.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
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
			switch (org.unicase.ui.tom.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(node)) {
			case org.unicase.ui.tom.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.tom.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.ui.tom.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case org.unicase.ui.tom.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.ui.tom.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.ui.tom.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
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
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.AssociationCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4002 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association2CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4003 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association3CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4004 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association4CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.ClassSubClasses_4005 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.ClassSubClassesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Dependency_4006 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.DependencyCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.AssociationCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4002 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association2CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4003 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association3CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Association_4004 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association4CreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.ClassSubClasses_4005 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.ClassSubClassesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.tom.classDiagram.providers.ModelElementTypes.Dependency_4006 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.DependencyCreateCommand(
					req, req.getSource(), req.getTarget()));
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
		case org.unicase.ui.tom.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.AssociationReorientCommand(
					req));
		case org.unicase.ui.tom.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association2ReorientCommand(
					req));
		case org.unicase.ui.tom.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association3ReorientCommand(
					req));
		case org.unicase.ui.tom.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.Association4ReorientCommand(
					req));
		case org.unicase.ui.tom.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.DependencyReorientCommand(
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
		case org.unicase.ui.tom.classDiagram.edit.parts.ClassSubClassesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.tom.classDiagram.edit.commands.ClassSubClassesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
