package org.unicase.ui.diagram.urml.edit.policies;

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
import org.unicase.ui.diagram.urml.edit.commands.AbstractFeatureDetailingFunctionalRequirementsCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.AbstractFeatureDetailingFunctionalRequirementsReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.FunctionalRequirementSubFunctionalRequirementsCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.FunctionalRequirementSubFunctionalRequirementsReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.MitigationMitigatedDangersCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.MitigationMitigatedDangersReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.RequirementImplementingServicesCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.RequirementImplementingServicesReorientCommand;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementSubFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class FunctionalRequirementItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FunctionalRequirementItemSemanticEditPolicy() {
		super(UrmlElementTypes.FunctionalRequirement_2006);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID) {
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
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == RequirementImplementingServicesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID) {
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
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == MitigationMitigatedDangersEditPart.VISUAL_ID) {
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
		if (UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.RequirementImplementingServices_4005 == req.getElementType()) {
			return getGEFWrapper(new RequirementImplementingServicesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044 == req.getElementType()) {
			return getGEFWrapper(new FunctionalRequirementSubFunctionalRequirementsCreateCommand(req, req.getSource(),
				req.getTarget()));
		}
		if (UrmlElementTypes.MitigationMitigatedDangers_4012 == req.getElementType()) {
			return getGEFWrapper(new MitigationMitigatedDangersCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035 == req.getElementType()) {
			return getGEFWrapper(new AbstractFeatureDetailingFunctionalRequirementsCreateCommand(req, req.getSource(),
				req.getTarget()));
		}
		if (UrmlElementTypes.RequirementImplementingServices_4005 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044 == req.getElementType()) {
			return getGEFWrapper(new FunctionalRequirementSubFunctionalRequirementsCreateCommand(req, req.getSource(),
				req.getTarget()));
		}
		if (UrmlElementTypes.MitigationMitigatedDangers_4012 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractFeatureDetailingFunctionalRequirementsReorientCommand(req));
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementImplementingServicesReorientCommand(req));
		case FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new FunctionalRequirementSubFunctionalRequirementsReorientCommand(req));
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getGEFWrapper(new MitigationMitigatedDangersReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
