package scrm.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.commands.ConstraintRestrictedFeatureCreateCommand;
import scrm.diagram.edit.commands.ConstraintRestrictedFeatureReorientCommand;
import scrm.diagram.edit.commands.FeatureDependenciesCreateCommand;
import scrm.diagram.edit.commands.FeatureDependenciesReorientCommand;
import scrm.diagram.edit.commands.FeatureExcludedFeaturesCreateCommand;
import scrm.diagram.edit.commands.FeatureExcludedFeaturesReorientCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesReorientCommand;
import scrm.diagram.edit.commands.FeatureRequiredFeaturesCreateCommand;
import scrm.diagram.edit.commands.FeatureRequiredFeaturesReorientCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesReorientCommand;
import scrm.diagram.edit.commands.FeatureSuperFeatureCreateCommand;
import scrm.diagram.edit.commands.FeatureSuperFeatureReorientCommand;
import scrm.diagram.edit.commands.RequirementSpecifiedFeatureCreateCommand;
import scrm.diagram.edit.commands.RequirementSpecifiedFeatureReorientCommand;
import scrm.diagram.edit.commands.ScientificProblemInfluencedFeatureCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemInfluencedFeatureReorientCommand;
import scrm.diagram.edit.parts.ConstraintRestrictedFeatureEditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureSuperFeatureEditPart;
import scrm.diagram.edit.parts.RequirementSpecifiedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
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
		super(ScrmElementTypes.Feature_3009);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == ScientificProblemInfluencedFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == RequirementSpecifiedFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == FeatureSuperFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == FeatureRequiredFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == FeatureExcludedFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == ConstraintRestrictedFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureSuperFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureDependenciesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureRequiredInterfacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureProvidedInterfacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureRequiredFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == FeatureExcludedFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
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
		if (ScrmElementTypes.ScientificProblemInfluencedFeature_4008 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementSpecifiedFeature_4052 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureSuperFeature_4053 == req.getElementType()) {
			return getGEFWrapper(new FeatureSuperFeatureCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureDependencies_4026 == req.getElementType()) {
			return getGEFWrapper(new FeatureDependenciesCreateCommand(req,
					req.getSource(), req.getTarget()));
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
		if (ScrmElementTypes.ConstraintRestrictedFeature_4051 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.ScientificProblemInfluencedFeature_4008 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificProblemInfluencedFeatureCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementSpecifiedFeature_4052 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementSpecifiedFeatureCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureSuperFeature_4053 == req.getElementType()) {
			return getGEFWrapper(new FeatureSuperFeatureCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.FeatureDependencies_4026 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureRequiredInterfaces_4023 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.FeatureProvidedInterfaces_4024 == req
				.getElementType()) {
			return null;
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
		if (ScrmElementTypes.ConstraintRestrictedFeature_4051 == req
				.getElementType()) {
			return getGEFWrapper(new ConstraintRestrictedFeatureCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
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
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificProblemInfluencedFeatureReorientCommand(
					req));
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementSpecifiedFeatureReorientCommand(
					req));
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureSuperFeatureReorientCommand(req));
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDependenciesReorientCommand(req));
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureRequiredInterfacesReorientCommand(
					req));
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureProvidedInterfacesReorientCommand(
					req));
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureRequiredFeaturesReorientCommand(req));
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureExcludedFeaturesReorientCommand(req));
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintRestrictedFeatureReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
