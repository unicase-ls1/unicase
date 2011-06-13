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

import scrm.diagram.edit.commands.DataDefinitionDefinedRequirementCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionDefinedRequirementReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceReorientCommand;
import scrm.diagram.edit.commands.RequirementRealizedMethodCreateCommand;
import scrm.diagram.edit.commands.RequirementRealizedMethodReorientCommand;
import scrm.diagram.edit.commands.RequirementRefinedRequirementCreateCommand;
import scrm.diagram.edit.commands.RequirementRefinedRequirementReorientCommand;
import scrm.diagram.edit.commands.RequirementSpecifiedFeatureCreateCommand;
import scrm.diagram.edit.commands.RequirementSpecifiedFeatureReorientCommand;
import scrm.diagram.edit.parts.DataDefinitionDefinedRequirementEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.RequirementRealizedMethodEditPart;
import scrm.diagram.edit.parts.RequirementRefinedRequirementEditPart;
import scrm.diagram.edit.parts.RequirementSpecifiedFeatureEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class PerformanceItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PerformanceItemSemanticEditPolicy() {
		super(ScrmElementTypes.Performance_2015);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == NumericalMethodPerformanceEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == RequirementRefinedRequirementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == DataDefinitionDefinedRequirementEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == RequirementRealizedMethodEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == RequirementSpecifiedFeatureEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == RequirementRefinedRequirementEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.RequirementRealizedMethod_4050 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementRealizedMethodCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4017 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementSpecifiedFeature_4052 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementSpecifiedFeatureCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementRefinedRequirement_4054 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementRefinedRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.DataDefinitionDefinedRequirement_4055 == req
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
		if (ScrmElementTypes.RequirementRealizedMethod_4050 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4017 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodPerformanceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementSpecifiedFeature_4052 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementRefinedRequirement_4054 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementRefinedRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.DataDefinitionDefinedRequirement_4055 == req
				.getElementType()) {
			return getGEFWrapper(new DataDefinitionDefinedRequirementCreateCommand(
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
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementRealizedMethodReorientCommand(
					req));
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodPerformanceReorientCommand(
					req));
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementSpecifiedFeatureReorientCommand(
					req));
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementRefinedRequirementReorientCommand(
					req));
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new DataDefinitionDefinedRequirementReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
