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

import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodSolvedProblemCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodSolvedProblemReorientCommand;
import scrm.diagram.edit.commands.PerformanceDescribedMethodCreateCommand;
import scrm.diagram.edit.commands.PerformanceDescribedMethodReorientCommand;
import scrm.diagram.edit.commands.RequirementRealizedMethodCreateCommand;
import scrm.diagram.edit.commands.RequirementRealizedMethodReorientCommand;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodSolvedProblemEditPart;
import scrm.diagram.edit.parts.PerformanceDescribedMethodEditPart;
import scrm.diagram.edit.parts.RequirementRealizedMethodEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethod2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NumericalMethod2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.NumericalMethod_3002);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == MathematicalModelNumericalMethodsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == RequirementRealizedMethodEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == PerformanceDescribedMethodEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.NumericalMethodSolvedProblem_4057 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodSolvedProblemCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodDependencies_4015 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodDependenciesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.RequirementRealizedMethod_4050 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.PerformanceDescribedMethod_4059 == req
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
		if (ScrmElementTypes.NumericalMethodSolvedProblem_4057 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelNumericalMethodsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodDependencies_4015 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.RequirementRealizedMethod_4050 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementRealizedMethodCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.PerformanceDescribedMethod_4059 == req
				.getElementType()) {
			return getGEFWrapper(new PerformanceDescribedMethodCreateCommand(
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
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodSolvedProblemReorientCommand(
					req));
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelNumericalMethodsReorientCommand(
					req));
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new NumericalMethodDependenciesReorientCommand(
					req));
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementRealizedMethodReorientCommand(
					req));
		case PerformanceDescribedMethodEditPart.VISUAL_ID:
			return getGEFWrapper(new PerformanceDescribedMethodReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
