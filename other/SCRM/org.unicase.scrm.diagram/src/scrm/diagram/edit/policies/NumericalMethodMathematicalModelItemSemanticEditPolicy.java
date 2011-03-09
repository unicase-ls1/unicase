package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethodMathematicalModelItemSemanticEditPolicy extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NumericalMethodMathematicalModelItemSemanticEditPolicy() {
		super(ScrmElementTypes.NumericalMethodMathematicalModel_4003);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
