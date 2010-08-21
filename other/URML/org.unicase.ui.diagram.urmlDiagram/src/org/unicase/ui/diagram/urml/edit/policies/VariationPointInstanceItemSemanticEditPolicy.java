package org.unicase.ui.diagram.urml.edit.policies;

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
import org.unicase.ui.diagram.urml.edit.commands.ProductVariationPointInstancesCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.ProductVariationPointInstancesReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.VariationPointInstanceSelectedFeaturesCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.VariationPointInstanceSelectedFeaturesReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.VariationPointInstanceVariationPointCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.VariationPointInstanceVariationPointReorientCommand;
import org.unicase.ui.diagram.urml.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class VariationPointInstanceItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VariationPointInstanceItemSemanticEditPolicy() {
		super(UrmlElementTypes.VariationPointInstance_2014);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == ProductVariationPointInstancesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == VariationPointInstanceVariationPointEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID) {
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
		if (UrmlElementTypes.VariationPointInstanceVariationPoint_4033 == req.getElementType()) {
			return getGEFWrapper(new VariationPointInstanceVariationPointCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040 == req.getElementType()) {
			return getGEFWrapper(new VariationPointInstanceSelectedFeaturesCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (UrmlElementTypes.ProductVariationPointInstances_4032 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.VariationPointInstanceVariationPoint_4033 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.ProductVariationPointInstances_4032 == req.getElementType()) {
			return getGEFWrapper(new ProductVariationPointInstancesCreateCommand(req, req.getSource(), req.getTarget()));
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
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			return getGEFWrapper(new VariationPointInstanceVariationPointReorientCommand(req));
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new VariationPointInstanceSelectedFeaturesReorientCommand(req));
		case ProductVariationPointInstancesEditPart.VISUAL_ID:
			return getGEFWrapper(new ProductVariationPointInstancesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
