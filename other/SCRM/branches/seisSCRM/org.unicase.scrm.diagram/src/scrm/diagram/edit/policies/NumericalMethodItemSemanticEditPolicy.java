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

import scrm.diagram.edit.commands.Mathematical_GeophysicalModelUsedInNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelUsedInNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodSolvedProblemCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodSolvedProblemReorientCommand;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.NumericalMethodSolvedProblemEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethodItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NumericalMethodItemSemanticEditPolicy() {
		super(ScrmElementTypes.NumericalMethod_2006);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == NumericalMethodSolvedProblemEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == NumericalMethodDependenciesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == NumericalMethodRealizingRequirementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == NumericalMethodPerformanceEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodSolvedProblem_4057 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodSolvedProblemCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodDependencies_4015 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodDependenciesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4068 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodRealizingRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4069 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodPerformanceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelUsedInNumericalMethodsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodSolvedProblem_4057 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodDependencies_4015 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4068 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4069 == req
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
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new Mathematical_GeophysicalModelUsedInNumericalMethodsReorientCommand(
					req));
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodSolvedProblemReorientCommand(
					req));
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodDependenciesReorientCommand(
					req));
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodRealizingRequirementReorientCommand(
					req));
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodPerformanceReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
