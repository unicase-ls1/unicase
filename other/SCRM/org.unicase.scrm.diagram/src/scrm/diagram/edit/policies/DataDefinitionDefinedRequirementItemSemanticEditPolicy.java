package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataDefinitionDefinedRequirementItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataDefinitionDefinedRequirementItemSemanticEditPolicy() {
		super(ScrmElementTypes.DataDefinitionDefinedRequirement_4055);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
