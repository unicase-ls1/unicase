package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ScientificProblemInfluencedFeatureItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ScientificProblemInfluencedFeatureItemSemanticEditPolicy() {
		super(ScrmElementTypes.ScientificProblemInfluencedFeature_4008);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
