package org.unicase.ui.activityDiagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ActivityInitialItemSemanticEditPolicy
		extends
		org.unicase.ui.activityDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

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
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.activityDiagram.providers.ModelElementTypes.Transition_4001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.activityDiagram.edit.commands.TransitionCreateCommand(
					req, req.getSource(), req.getTarget(), (EObject) getHost()
					.getModel()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.activityDiagram.providers.ModelElementTypes.Transition_4001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.activityDiagram.edit.commands.TransitionCreateCommand(
					req, req.getSource(), req.getTarget(), (EObject) getHost()
					.getModel()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.activityDiagram.edit.commands.TransitionReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
