package org.unicase.model.orga.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.unicase.model.orga.diagram.providers.OrgaElementTypes;

/**
 * @generated
 */
public class TeamHasOrgUnitItemSemanticEditPolicy extends
		OrgaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TeamHasOrgUnitItemSemanticEditPolicy() {
		super(OrgaElementTypes.TeamHasOrgUnit_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
