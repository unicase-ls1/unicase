package scrm.diagram.edit.policies;

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

import scrm.diagram.edit.commands.Mathematical_GeophysicalModelDependenciesCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelDependenciesReorientCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelInvolvedDataCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelInvolvedDataReorientCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelRefinementsCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelRefinementsReorientCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelUsedInNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelUsedInNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.ScientificProblemRepresentingModelCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemRepresentingModelReorientCommand;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelInvolvedDataEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelRefinementsEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class Mathematical_GeophysicalModel2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Mathematical_GeophysicalModel2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == ScientificProblemRepresentingModelEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
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
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.ScientificProblemRepresentingModel_4063 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelRefinementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelUsedInNumericalMethodsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelDependenciesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelInvolvedDataCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.ScientificProblemRepresentingModel_4063 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificProblemRepresentingModelCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelRefinementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067 == req
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
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificProblemRepresentingModelReorientCommand(
					req));
		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelRefinementsReorientCommand(
					req));
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelUsedInNumericalMethodsReorientCommand(
					req));
		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelDependenciesReorientCommand(
					req));
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelInvolvedDataReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
