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
import scrm.diagram.edit.commands.DataDefinitionProvidedInterfaceCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionProvidedInterfaceReorientCommand;
import scrm.diagram.edit.commands.DataDefinitionRequiredInterfaceCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionRequiredInterfaceReorientCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelInvolvedDataCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelInvolvedDataReorientCommand;
import scrm.diagram.edit.parts.DataDefinitionDefinedRequirementEditPart;
import scrm.diagram.edit.parts.DataDefinitionProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.DataDefinitionRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelInvolvedDataEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataDefinition2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataDefinition2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.DataDefinition_3035);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == DataDefinitionDefinedRequirementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == DataDefinitionProvidedInterfaceEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == DataDefinitionRequiredInterfaceEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.DataDefinitionDefinedRequirement_4075 == req
				.getElementType()) {
			return getGEFWrapper(new DataDefinitionDefinedRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.DataDefinitionProvidedInterface_4076 == req
				.getElementType()) {
			return getGEFWrapper(new DataDefinitionProvidedInterfaceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.DataDefinitionRequiredInterface_4077 == req
				.getElementType()) {
			return getGEFWrapper(new DataDefinitionRequiredInterfaceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelInvolvedDataCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.DataDefinitionDefinedRequirement_4075 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.DataDefinitionProvidedInterface_4076 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.DataDefinitionRequiredInterface_4077 == req
				.getElementType()) {
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
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelInvolvedDataReorientCommand(
					req));
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new DataDefinitionDefinedRequirementReorientCommand(
					req));
		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID:
			return getGEFWrapper(new DataDefinitionProvidedInterfaceReorientCommand(
					req));
		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID:
			return getGEFWrapper(new DataDefinitionRequiredInterfaceReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
