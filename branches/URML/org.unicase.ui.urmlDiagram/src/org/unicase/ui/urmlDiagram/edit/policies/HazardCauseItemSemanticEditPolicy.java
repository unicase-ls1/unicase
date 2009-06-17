package org.unicase.ui.urmlDiagram.edit.policies;

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
public class HazardCauseItemSemanticEditPolicy
		extends
		org.unicase.ui.urmlDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

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
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014 == req
				.getElementType()) {
			return null;
		}
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCauseHazardsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.MitigationCausesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016 == req
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
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.MitigationCausesReorientCommand(
					req));
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCauseHazardsReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
