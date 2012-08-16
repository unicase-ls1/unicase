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

import scrm.diagram.edit.commands.DataDefinitionProvidedInterfaceCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionProvidedInterfaceReorientCommand;
import scrm.diagram.edit.commands.DataDefinitionRequiredInterfaceCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionRequiredInterfaceReorientCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureProvidedInterfacesReorientCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesCreateCommand;
import scrm.diagram.edit.commands.FeatureRequiredInterfacesReorientCommand;
import scrm.diagram.edit.commands.InterfaceDetailsOfProvidingFunctionsAndPropertiesCreateCommand;
import scrm.diagram.edit.commands.InterfaceDetailsOfProvidingFunctionsAndPropertiesReorientCommand;
import scrm.diagram.edit.commands.InterfaceDetailsOfRequiringFunctionsAndPropertiesCreateCommand;
import scrm.diagram.edit.commands.InterfaceDetailsOfRequiringFunctionsAndPropertiesReorientCommand;
import scrm.diagram.edit.commands.RequirementProvidedInterfaceCreateCommand;
import scrm.diagram.edit.commands.RequirementProvidedInterfaceReorientCommand;
import scrm.diagram.edit.commands.RequirementRequiredInterfaceCreateCommand;
import scrm.diagram.edit.commands.RequirementRequiredInterfaceReorientCommand;
import scrm.diagram.edit.parts.DataDefinitionProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.DataDefinitionRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.RequirementProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.RequirementRequiredInterfaceEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class UserInterface2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public UserInterface2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.UserInterface_3014);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == RequirementProvidedInterfaceEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == RequirementRequiredInterfaceEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == FeatureRequiredInterfacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == FeatureProvidedInterfacesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == DataDefinitionProvidedInterfaceEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == DataDefinitionRequiredInterfaceEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070 == req
				.getElementType()) {
			return getGEFWrapper(new InterfaceDetailsOfProvidingFunctionsAndPropertiesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071 == req
				.getElementType()) {
			return getGEFWrapper(new InterfaceDetailsOfRequiringFunctionsAndPropertiesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementProvidedInterface_4072 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementRequiredInterface_4073 == req
				.getElementType()) {
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
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementProvidedInterface_4072 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementProvidedInterfaceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementRequiredInterface_4073 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementRequiredInterfaceCreateCommand(
					req, req.getSource(), req.getTarget()));
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
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getGEFWrapper(new InterfaceDetailsOfProvidingFunctionsAndPropertiesReorientCommand(
					req));
		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getGEFWrapper(new InterfaceDetailsOfRequiringFunctionsAndPropertiesReorientCommand(
					req));
		case RequirementProvidedInterfaceEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementProvidedInterfaceReorientCommand(
					req));
		case RequirementRequiredInterfaceEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementRequiredInterfaceReorientCommand(
					req));
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureRequiredInterfacesReorientCommand(
					req));
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureProvidedInterfacesReorientCommand(
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
