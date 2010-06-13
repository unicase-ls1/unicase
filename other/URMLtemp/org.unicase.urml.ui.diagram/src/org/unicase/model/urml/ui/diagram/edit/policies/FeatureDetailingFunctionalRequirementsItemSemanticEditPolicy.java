package org.unicase.model.urml.ui.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class FeatureDetailingFunctionalRequirementsItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureDetailingFunctionalRequirementsItemSemanticEditPolicy() {
		super(UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
