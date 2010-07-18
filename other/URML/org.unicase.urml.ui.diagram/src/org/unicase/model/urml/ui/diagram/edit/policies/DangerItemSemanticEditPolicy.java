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
import org.unicase.model.urml.ui.diagram.edit.commands.AssetTriggeredDangersCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.AssetTriggeredDangersReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.DangerHarmedAssetsCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.DangerHarmedAssetsReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.MitigationMitigatedDangersCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.MitigationMitigatedDangersReorientCommand;
import org.unicase.model.urml.ui.diagram.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class DangerItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DangerItemSemanticEditPolicy() {
		super(UrmlElementTypes.Danger_2009);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == MitigationMitigatedDangersEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == AssetTriggeredDangersEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == DangerHarmedAssetsEditPart.VISUAL_ID) {
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
		if (UrmlElementTypes.MitigationMitigatedDangers_4012 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.DangerHarmedAssets_4013 == req.getElementType()) {
			return getGEFWrapper(new DangerHarmedAssetsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.AssetTriggeredDangers_4017 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.MitigationMitigatedDangers_4012 == req.getElementType()) {
			return getGEFWrapper(new MitigationMitigatedDangersCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.DangerHarmedAssets_4013 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.AssetTriggeredDangers_4017 == req.getElementType()) {
			return getGEFWrapper(new AssetTriggeredDangersCreateCommand(req, req.getSource(), req.getTarget()));
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
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getGEFWrapper(new MitigationMitigatedDangersReorientCommand(req));
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getGEFWrapper(new DangerHarmedAssetsReorientCommand(req));
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			return getGEFWrapper(new AssetTriggeredDangersReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
