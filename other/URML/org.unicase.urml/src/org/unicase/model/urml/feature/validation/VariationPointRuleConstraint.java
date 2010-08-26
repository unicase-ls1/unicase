package org.unicase.model.urml.feature.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.util.ValidationConstraintHelper;

public class VariationPointRuleConstraint extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			if (ctx.getTarget() instanceof VariationPointInstance) {
				VariationPointInstance vpi = (VariationPointInstance) ctx.getTarget();
				if (vpi.getVariationPoint() != null) {
					VariationPoint vp = vpi.getVariationPoint();
					if (vp.getMultiplicity() != 0 && vp.getMultiplicity() != vpi.getSelectedFeatures().size()) {
						ctx.addResult(ValidationConstraintHelper
							.getErrorFeatureForModelElement(vpi, "selectedFeatures"));
						return ctx.createFailureStatus(new Object[] {
							vpi.eClass().getName() + ": '" + vpi.getName() + "'",
							vp.eClass().getName() + ": '" + vp.getName() + "'" });
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
