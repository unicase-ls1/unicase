package org.unicase.model.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.diagram.edit.commands.FunctionalRequirement2CreateCommand;
import org.unicase.model.diagram.edit.commands.FunctionalRequirementRefinedRequirementCreateCommand;
import org.unicase.model.diagram.edit.commands.FunctionalRequirementRefinedRequirementReorientCommand;
import org.unicase.model.diagram.edit.commands.FunctionalRequirementReorientCommand;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement3EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart;
import org.unicase.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class FunctionalRequirement3ItemSemanticEditPolicy extends
		ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
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
		if (ModelElementTypes.FunctionalRequirement_3001 == req
				.getElementType()) {
			return getGEFWrapper(new FunctionalRequirement2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ModelElementTypes.FunctionalRequirementRefinedRequirement_3002 == req
				.getElementType()) {
			return getGEFWrapper(new FunctionalRequirementRefinedRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ModelElementTypes.FunctionalRequirement_3001 == req
				.getElementType()) {
			return getGEFWrapper(new FunctionalRequirement2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ModelElementTypes.FunctionalRequirementRefinedRequirement_3002 == req
				.getElementType()) {
			return getGEFWrapper(new FunctionalRequirementRefinedRequirementCreateCommand(
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
		case FunctionalRequirement3EditPart.VISUAL_ID:
			return getGEFWrapper(new FunctionalRequirementReorientCommand(req));
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
		case FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new FunctionalRequirementRefinedRequirementReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
