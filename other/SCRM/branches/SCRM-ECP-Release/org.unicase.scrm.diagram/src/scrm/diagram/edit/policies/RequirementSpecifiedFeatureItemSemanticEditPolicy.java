package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class RequirementSpecifiedFeatureItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementSpecifiedFeatureItemSemanticEditPolicy() {
		super(ScrmElementTypes.RequirementSpecifiedFeature_4052);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
