package org.unicase.ui.usecaseDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class UseCaseItemSemanticEditPolicy extends
	org.unicase.ui.usecaseDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
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
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001 == req
			.getElementType()) {
			return null;
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002 == req
			.getElementType()) {
			return null;
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.ActorParticipatedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.ActorInitiatedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004 == req
			.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesCreateCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element
	 * associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.ActorParticipatedUseCasesReorientCommand(
				req));
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.ActorInitiatedUseCasesReorientCommand(
				req));
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesReorientCommand(
				req));
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesReorientCommand(
				req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
