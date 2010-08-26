package org.unicase.model.urml.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.danger.ProceduralMitigation;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.util.ValidationConstraintHelper;

public class WrongFieldDataConstraint extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			Object[] message = null;
			EStructuralFeature errorFeature = null;
			if (eObj instanceof VariationPoint && ((VariationPoint) eObj).getMultiplicity() < 0) {
				message = new Object[] {
					eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'", "'Multiplicity'",
					"< 0" };
				errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement((UnicaseModelElement) eObj,
					"multiplicity");
			} else if (eObj instanceof ProceduralMitigation
				&& ((ProceduralMitigation) eObj).getMitigationProcedure().equals("")) {
				message = new Object[] {
					eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'",
					"'Mitigation Procedure'", "\"\"" };
				errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement((UnicaseModelElement) eObj,
					"mitigationProcedure");
			}
			if (message != null) {
				ctx.addResult(errorFeature);
				return ctx.createFailureStatus(message);
			}
		}
		return ctx.createSuccessStatus();
	}
}
