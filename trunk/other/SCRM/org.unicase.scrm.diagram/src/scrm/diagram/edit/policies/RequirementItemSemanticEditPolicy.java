package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import scrm.diagram.edit.commands.FeatureDetailedRequirementsCreateCommand;
import scrm.diagram.edit.commands.FeatureDetailedRequirementsReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementReorientCommand;
import scrm.diagram.edit.commands.RequirementCreateCommand;
import scrm.diagram.edit.commands.RequirementDefiningDataCreateCommand;
import scrm.diagram.edit.commands.RequirementDefiningDataReorientCommand;
import scrm.diagram.edit.commands.RequirementReorientCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsCreateCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsReorientCommand;
import scrm.diagram.edit.parts.FeatureDetailedRequirementsEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.RequirementDefiningDataEditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class RequirementItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementItemSemanticEditPolicy() {
		super(ScrmElementTypes.Requirement_4036);
	}

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
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4016 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureDetailedRequirements_4027 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.Requirement_4036 == req.getElementType()) {
			return getGEFWrapper(new RequirementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementDefiningData_4038 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementDefiningDataCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificKnowledgeRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4016 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodRealizingRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureDetailedRequirements_4027 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureDetailedRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Requirement_4036 == req.getElementType()) {
			return getGEFWrapper(new RequirementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementDefiningData_4038 == req
				.getElementType()) {
			return null;
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
		case RequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementReorientCommand(req));
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
		case ScientificKnowledgeRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificKnowledgeRequirementsReorientCommand(
					req));
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodRealizingRequirementReorientCommand(
					req));
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDetailedRequirementsReorientCommand(
					req));
		case RequirementDefiningDataEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementDefiningDataReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
