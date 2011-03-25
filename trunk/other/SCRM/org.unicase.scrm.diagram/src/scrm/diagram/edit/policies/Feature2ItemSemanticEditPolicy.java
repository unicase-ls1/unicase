package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import scrm.diagram.edit.commands.Feature2CreateCommand;
import scrm.diagram.edit.commands.FeatureConstraintsCreateCommand;
import scrm.diagram.edit.commands.FeatureConstraintsReorientCommand;
import scrm.diagram.edit.commands.FeatureDependenciesCreateCommand;
import scrm.diagram.edit.commands.FeatureDependenciesReorientCommand;
import scrm.diagram.edit.commands.FeatureDetailedRequirementsCreateCommand;
import scrm.diagram.edit.commands.FeatureDetailedRequirementsReorientCommand;
import scrm.diagram.edit.commands.FeatureExcludedFeaturesCreateCommand;
import scrm.diagram.edit.commands.FeatureExcludedFeaturesReorientCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesReorientCommand;
import scrm.diagram.edit.commands.FeatureReorientCommand;
import scrm.diagram.edit.commands.FeatureRequiredFeaturesCreateCommand;
import scrm.diagram.edit.commands.FeatureRequiredFeaturesReorientCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesReorientCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsCreateCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsReorientCommand;
import scrm.diagram.edit.commands.ScientificProblemInfluencedFeatureCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemInfluencedFeatureReorientCommand;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureConstraintsEditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureDetailedRequirementsEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class Feature2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Feature2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.Feature_4029);
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
		if (ScrmElementTypes.ScientificProblemInfluencedFeature_4008 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureRequiredInterfaces_4023 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureRequiredInterfacesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureProvidedInterfaces_4024 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureProvidedInterfacesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureConstraints_4025 == req.getElementType()) {
			return getGEFWrapper(new FeatureConstraintsCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureDependencies_4026 == req.getElementType()) {
			return getGEFWrapper(new FeatureDependenciesCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureDetailedRequirements_4027 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureDetailedRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Feature_4029 == req.getElementType()) {
			return getGEFWrapper(new Feature2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureRequiredFeatures_4030 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureRequiredFeaturesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureExcludedFeatures_4032 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureExcludedFeaturesCreateCommand(req,
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
		if (ScrmElementTypes.ScientificProblemInfluencedFeature_4008 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificProblemInfluencedFeatureCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureRequiredInterfaces_4023 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureProvidedInterfaces_4024 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureConstraints_4025 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureDependencies_4026 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureDetailedRequirements_4027 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.Feature_4029 == req.getElementType()) {
			return getGEFWrapper(new Feature2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureRequiredFeatures_4030 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureRequiredFeaturesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureExcludedFeatures_4032 == req
				.getElementType()) {
			return getGEFWrapper(new FeatureExcludedFeaturesCreateCommand(req,
					req.getSource(), req.getTarget()));
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
		case Feature2EditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureReorientCommand(req));
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
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificProblemInfluencedFeatureReorientCommand(
					req));
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureRequiredInterfacesReorientCommand(
					req));
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureProvidedInterfacesReorientCommand(
					req));
		case FeatureConstraintsEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureConstraintsReorientCommand(req));
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDependenciesReorientCommand(req));
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDetailedRequirementsReorientCommand(
					req));
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureRequiredFeaturesReorientCommand(req));
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureExcludedFeaturesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
