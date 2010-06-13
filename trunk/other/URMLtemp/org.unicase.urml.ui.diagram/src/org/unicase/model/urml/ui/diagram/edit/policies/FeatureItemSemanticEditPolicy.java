package org.unicase.model.urml.ui.diagram.edit.policies;

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
import org.unicase.model.urml.ui.diagram.edit.commands.FeatureDetailingFunctionalRequirementsCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.FeatureDetailingFunctionalRequirementsReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.FeatureParentFeatureCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.FeatureParentFeatureReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.GoalRealizedFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.GoalRealizedFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class FeatureItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureItemSemanticEditPolicy() {
		super(UrmlElementTypes.Feature_2005);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == FeatureParentFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalRealizedFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == FeatureParentFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
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
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.FeatureParentFeature_4002 == req.getElementType()) {
			return getGEFWrapper(new FeatureParentFeatureCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006 == req.getElementType()) {
			return getGEFWrapper(new FeatureDetailingFunctionalRequirementsCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.FeatureParentFeature_4002 == req.getElementType()) {
			return getGEFWrapper(new FeatureParentFeatureCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return getGEFWrapper(new GoalRealizedFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureParentFeatureReorientCommand(req));
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new GoalRealizedFeaturesReorientCommand(req));
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDetailingFunctionalRequirementsReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
