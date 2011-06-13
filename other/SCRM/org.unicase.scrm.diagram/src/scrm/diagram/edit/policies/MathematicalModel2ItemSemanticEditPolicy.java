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

import scrm.diagram.edit.commands.MathematicalModelDependenciesCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelDependenciesReorientCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.MathematicalModelRefinedModelCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelRefinedModelReorientCommand;
import scrm.diagram.edit.commands.MathematicalModelRepresentedProblemCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelRepresentedProblemReorientCommand;
import scrm.diagram.edit.parts.MathematicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.MathematicalModelRefinedModelEditPart;
import scrm.diagram.edit.parts.MathematicalModelRepresentedProblemEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class MathematicalModel2ItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MathematicalModel2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.MathematicalModel_3003);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == MathematicalModelRefinedModelEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelRepresentedProblemEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelRefinedModelEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelNumericalMethodsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelDependenciesEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.MathematicalModelRepresentedProblem_4048 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelRepresentedProblemCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelRefinedModel_4058 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelRefinedModelCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelNumericalMethodsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelDependencies_4012 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelDependenciesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ScrmElementTypes.MathematicalModelRepresentedProblem_4048 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.MathematicalModelRefinedModel_4058 == req
				.getElementType()) {
			return getGEFWrapper(new MathematicalModelRefinedModelCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.MathematicalModelDependencies_4012 == req
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
		case MathematicalModelRepresentedProblemEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelRepresentedProblemReorientCommand(
					req));
		case MathematicalModelRefinedModelEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelRefinedModelReorientCommand(
					req));
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelNumericalMethodsReorientCommand(
					req));
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelDependenciesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
