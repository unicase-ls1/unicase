package org.unicase.ui.diagram.urml.edit.policies;

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
import org.unicase.ui.diagram.urml.edit.commands.GoalRealizedFeaturesCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalRealizedFeaturesReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference2CreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference2ReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference3CreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference3ReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference4CreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReference4ReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReferenceCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalReferenceReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalSubGoalsCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.GoalSubGoalsReorientCommand;
import org.unicase.ui.diagram.urml.edit.commands.StakeholderGoalsCreateCommand;
import org.unicase.ui.diagram.urml.edit.commands.StakeholderGoalsReorientCommand;
import org.unicase.ui.diagram.urml.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference4EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalSubGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderGoalsEditPart;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class GoalItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public GoalItemSemanticEditPolicy() {
		super(UrmlElementTypes.Goal_2001);
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == StakeholderGoalsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
					incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalSubGoalsEditPart.VISUAL_ID) {
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
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalReference3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(incomingLink) == GoalReference4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalRealizedFeaturesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
					outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalSubGoalsEditPart.VISUAL_ID) {
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
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalReference3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (UrmlVisualIDRegistry.getVisualID(outgoingLink) == GoalReference4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
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
	 * @generated NOT
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.StakeholderGoals_4008 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return getGEFWrapper(new GoalRealizedFeaturesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalSubGoals_4018 == req.getElementType()) {
			return getGEFWrapper(new GoalSubGoalsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalReference_4016 == req.getElementType()) {
			return getGEFWrapper(new GoalReferenceCreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4023 == req.getElementType()) {
			return getGEFWrapper(new GoalReference2CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4024 == req.getElementType()) {
			return getGEFWrapper(new GoalReference3CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4025 == req.getElementType()) {
			return getGEFWrapper(new GoalReference4CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UrmlElementTypes.StakeholderGoals_4008 == req.getElementType()) {
			return getGEFWrapper(new StakeholderGoalsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalRealizedFeatures_4004 == req.getElementType()) {
			return null;
		}
		if (UrmlElementTypes.GoalSubGoals_4018 == req.getElementType()) {
			return getGEFWrapper(new GoalSubGoalsCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UrmlElementTypes.GoalReference_4016 == req.getElementType()) {
			return getGEFWrapper(new GoalReferenceCreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4023 == req.getElementType()) {
			return getGEFWrapper(new GoalReference2CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4024 == req.getElementType()) {
			return getGEFWrapper(new GoalReference3CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		if (UrmlElementTypes.GoalReference_4025 == req.getElementType()) {
			return getGEFWrapper(new GoalReference4CreateCommand(req, req.getSource(), req.getTarget(),
			/* user code */
			(EObject) getHost().getModel()));
			/* user code */
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case GoalReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new GoalReferenceReorientCommand(req));
		case GoalReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new GoalReference2ReorientCommand(req));
		case GoalReference3EditPart.VISUAL_ID:
			return getGEFWrapper(new GoalReference3ReorientCommand(req));
		case GoalReference4EditPart.VISUAL_ID:
			return getGEFWrapper(new GoalReference4ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getGEFWrapper(new StakeholderGoalsReorientCommand(req));
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGEFWrapper(new GoalRealizedFeaturesReorientCommand(req));
		case GoalSubGoalsEditPart.VISUAL_ID:
			return getGEFWrapper(new GoalSubGoalsReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
