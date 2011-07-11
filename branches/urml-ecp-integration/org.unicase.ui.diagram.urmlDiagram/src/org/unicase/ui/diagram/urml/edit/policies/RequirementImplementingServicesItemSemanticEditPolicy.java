package org.unicase.ui.diagram.urml.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class RequirementImplementingServicesItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementImplementingServicesItemSemanticEditPolicy() {
		super(UrmlElementTypes.RequirementImplementingServices_4005);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
