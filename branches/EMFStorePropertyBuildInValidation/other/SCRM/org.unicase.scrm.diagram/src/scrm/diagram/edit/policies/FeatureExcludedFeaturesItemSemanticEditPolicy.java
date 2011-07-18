package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class FeatureExcludedFeaturesItemSemanticEditPolicy extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureExcludedFeaturesItemSemanticEditPolicy() {
		super(ScrmElementTypes.FeatureExcludedFeatures_4032);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
