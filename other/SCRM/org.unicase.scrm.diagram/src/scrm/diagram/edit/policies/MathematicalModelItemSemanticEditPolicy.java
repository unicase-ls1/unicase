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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.commands.MathematicalModel2CreateCommand;
import scrm.diagram.edit.commands.MathematicalModel2ReorientCommand;
import scrm.diagram.edit.commands.MathematicalModel3CreateCommand;
import scrm.diagram.edit.commands.MathematicalModelDependenciesCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelDependenciesReorientCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelNumericalMethodsReorientCommand;
import scrm.diagram.edit.commands.MathematicalModelReorientCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsCreateCommand;
import scrm.diagram.edit.commands.ScientificKnowledgeRequirementsReorientCommand;
import scrm.diagram.edit.commands.ScientificProblemRepresentingModelCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemRepresentingModelReorientCommand;
import scrm.diagram.edit.parts.MathematicalModel2EditPart;
import scrm.diagram.edit.parts.MathematicalModel3EditPart;
import scrm.diagram.edit.parts.MathematicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class MathematicalModelItemSemanticEditPolicy extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MathematicalModelItemSemanticEditPolicy() {
		super(ScrmElementTypes.MathematicalModel_2005);
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
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == ScientificProblemRepresentingModelEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == MathematicalModel2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(incomingLink) == MathematicalModel3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == ScientificKnowledgeRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModel2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModel3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelNumericalMethodsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ScrmVisualIDRegistry.getVisualID(outgoingLink) == MathematicalModelDependenciesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
						throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
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
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req.getElementType()) {
			return getGEFWrapper(new ScientificKnowledgeRequirementsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.ScientificProblemRepresentingModel_4006 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.MathematicalModel_4004 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModel2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModel_4010 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModel3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModelNumericalMethodsCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelDependencies_4012 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModelDependenciesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (ScrmElementTypes.ScientificKnowledgeRequirements_4005 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.ScientificProblemRepresentingModel_4006 == req.getElementType()) {
			return getGEFWrapper(new ScientificProblemRepresentingModelCreateCommand(req, req.getSource(), req
				.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModel_4004 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModel2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModel_4010 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModel3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ScrmElementTypes.MathematicalModelNumericalMethods_4011 == req.getElementType()) {
			return null;
		}
		if (ScrmElementTypes.MathematicalModelDependencies_4012 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MathematicalModel2EditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelReorientCommand(req));
		case MathematicalModel3EditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModel2ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ScientificKnowledgeRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificKnowledgeRequirementsReorientCommand(req));
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getGEFWrapper(new ScientificProblemRepresentingModelReorientCommand(req));
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelNumericalMethodsReorientCommand(req));
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getGEFWrapper(new MathematicalModelDependenciesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
