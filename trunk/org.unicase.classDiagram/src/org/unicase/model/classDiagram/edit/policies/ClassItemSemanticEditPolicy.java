package org.unicase.model.classDiagram.edit.policies;

import java.util.Iterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
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
		org.unicase.model.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

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
			switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(node)) {
			case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
							.getVisualID(cnode)) {
					case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
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
	 * @generated NOT
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.AssociationCreateCommand(
					req, req.getSource(), req.getTarget(), (EObject) getHost()
							.getModel()));
		}
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3002 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.ClassSubClassesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.AssociationCreateCommand(
					req, req.getSource(), req.getTarget(), (EObject) getHost()
							.getModel()));
		}
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3002 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.ClassSubClassesCreateCommand(
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
		case org.unicase.model.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.AssociationReorientCommand(
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
		case org.unicase.model.classDiagram.edit.parts.ClassSubClassesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.ClassSubClassesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
