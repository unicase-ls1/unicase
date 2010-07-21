package org.unicase.model.urml.ui.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
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
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureConstrainingNonFunctionalRequirementsCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureConstrainingNonFunctionalRequirementsReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureDetailingFunctionalRequirementsCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureDetailingFunctionalRequirementsReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureExcludedFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureExcludedFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureRequieredFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureRequieredFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureSubFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AbstractFeatureSubFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.GoalRealizedFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.GoalRealizedFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.VariationPointInstanceSelectedFeaturesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.VariationPointInstanceSelectedFeaturesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.VariationPointInstanceVariationPointCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.VariationPointInstanceVariationPointReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureRequieredFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class VariationPointItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VariationPointItemSemanticEditPolicy() {
		super(UrmlElementTypes.VariationPoint_2013);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == AbstractFeatureSubFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID) {
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == VariationPointInstanceVariationPointEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AbstractFeatureSubFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID) {
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
		if (UrmlElementTypes.AbstractFeatureSubFeatures_4034 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureSubFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureDetailingFunctionalRequirementsCreateCommand(req, req.getSource(),
				req.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureConstrainingNonFunctionalRequirementsCreateCommand(req, req
				.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureRequieredFeatures_4037 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureRequieredFeaturesCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureExcludedFeatures_4038 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureExcludedFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.VariationPointInstanceVariationPoint_4033 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.AbstractFeatureSubFeatures_4034 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureSubFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.AbstractFeatureRequieredFeatures_4037 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureRequieredFeaturesCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (UrmlElementTypes.AbstractFeatureExcludedFeatures_4038 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureExcludedFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return getGEFWrapper(new GoalRealizedFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.VariationPointInstanceVariationPoint_4033 == req.getElementType()) {
			return getGEFWrapper(new VariationPointInstanceVariationPointCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040 == req.getElementType()) {
			return getGEFWrapper(new VariationPointInstanceSelectedFeaturesCreateCommand(req, req.getSource(), req
				.getTarget()));
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
		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureSubFeaturesReorientCommand(req));
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureDetailingFunctionalRequirementsReorientCommand(req));
		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureConstrainingNonFunctionalRequirementsReorientCommand(req));
		case AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureRequieredFeaturesReorientCommand(req));
		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureExcludedFeaturesReorientCommand(req));
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new GoalRealizedFeaturesReorientCommand(req));
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			return getGEFWrapper(new VariationPointInstanceVariationPointReorientCommand(req));
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new VariationPointInstanceSelectedFeaturesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
