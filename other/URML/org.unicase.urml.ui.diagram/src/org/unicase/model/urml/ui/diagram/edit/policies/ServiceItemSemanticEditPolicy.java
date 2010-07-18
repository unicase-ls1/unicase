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
import org.unicase.model.urml.ui.diagram.edit.commands.AssetTriggeredDangersCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AssetTriggeredDangersReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.DangerHarmedAssetsCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.DangerHarmedAssetsReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.RequirementImplementingServicesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.RequirementImplementingServicesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.ServiceSubServicesCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.ServiceSubServicesReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceSubServicesEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class ServiceItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ServiceItemSemanticEditPolicy() {
		super(UrmlElementTypes.Service_2007);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == RequirementImplementingServicesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == DangerHarmedAssetsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == ServiceSubServicesEditPart.VISUAL_ID) {
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
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == AssetTriggeredDangersEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == ServiceSubServicesEditPart.VISUAL_ID) {
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
		if (UrmlElementTypes.RequirementImplementingServices_4005 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.DangerHarmedAssets_4013 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.AssetTriggeredDangers_4017 == req.getElementType()) {
			return getGEFWrapper(new AssetTriggeredDangersCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.ServiceSubServices_4022 == req.getElementType()) {
			return getGEFWrapper(new ServiceSubServicesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.RequirementImplementingServices_4005 == req.getElementType()) {
			return getGEFWrapper(new RequirementImplementingServicesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.DangerHarmedAssets_4013 == req.getElementType()) {
			return getGEFWrapper(new DangerHarmedAssetsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.AssetTriggeredDangers_4017 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.ServiceSubServices_4022 == req.getElementType()) {
			return getGEFWrapper(new ServiceSubServicesCreateCommand(req, req.getSource(), req.getTarget()));
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
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementImplementingServicesReorientCommand(req));
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getGEFWrapper(new DangerHarmedAssetsReorientCommand(req));
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			return getGEFWrapper(new AssetTriggeredDangersReorientCommand(req));
		case ServiceSubServicesEditPart.VISUAL_ID:
			return getGEFWrapper(new ServiceSubServicesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
