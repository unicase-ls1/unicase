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

import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodDependenciesReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodPerformanceReorientCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodRealizingRequirementReorientCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsCreateCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsReorientCommand;
import scrm.diagram.edit.commands.ScientificProblemSolvingMethodCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemSolvingMethodReorientCommand;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.edit.parts.ScientificProblemSolvingMethodEditPart;
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
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == ScientificProblemSolvingMethodEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == MathematicalModelNumericalMethodsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == ScientificKnowledgeRequirementsEditPart.VISUAL_ID) {
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
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == NumericalMethodDependenciesEditPart.VISUAL_ID) {
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
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificKnowledgeRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.ScientificProblemSolvingMethod_4007 == req
				.getElementType()) {
			return null;
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
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4016 == req
				.getElementType()) {
			return getGEFWrapper(new NumericalMethodRealizingRequirementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4017 == req
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
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.ScientificProblemSolvingMethod_4007 == req
				.getElementType()) {
			return getGEFWrapper(new ScientificProblemSolvingMethodCreateCommand(
					req, req.getSource(), req.getTarget()));
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
		if (ScrmElementTypes.NumericalMethodRealizingRequirement_4016 == req
				.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.NumericalMethodPerformance_4017 == req
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
		case ScientificKnowledgeRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificKnowledgeRequirementsReorientCommand(
					req));
		case ScientificProblemSolvingMethodEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificProblemSolvingMethodReorientCommand(
					req));
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelNumericalMethodsReorientCommand(
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
