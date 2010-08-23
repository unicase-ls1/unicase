package org.unicase.model.urml.validation;

import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.danger.impl.ProceduralMitigationImpl;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class WrongFieldDataConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, WrongData> checks;

	public WrongFieldDataConstraint() {
		checks = new HashMap<Class<? extends EObject>, WrongData>();
		checks.put(VariationPointImpl.class,
			new WrongIntegerData("multiplicity", "Multiplicity", -1, Integer.MIN_VALUE));
		checks.put(ProceduralMitigationImpl.class, new WrongStringData("mitigationProcedure", "Mitigation Procedure",
			""));
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (checks.containsKey(eObj.getClass())) {
				WrongData wData = checks.get(eObj.getClass());
				EStructuralFeature feature = eObj.eClass().getEStructuralFeature(wData.featureName);
				Object field = eObj.eGet(feature);
				if (wData.check(field)) {
					Object[] message = new Object[] {
						eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'", wData.fieldName };
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, feature.getName());
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(message);
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private abstract class WrongData {
		public String featureName;
		public String fieldName;

		public WrongData(String featureName, String fieldName) {
			this.featureName = featureName;
			this.fieldName = fieldName;
		}

		public abstract boolean check(Object obj);
	}

	private class WrongStringData extends WrongData {
		public String data;

		public WrongStringData(String featureName, String fieldName, String data) {
			super(featureName, fieldName);
			this.data = data;
		}

		@Override
		public boolean check(Object obj) {
			return data.equals(obj);
		}
	}

	private class WrongIntegerData extends WrongData {
		public int upperIndex, lowerIndex;

		public WrongIntegerData(String featureName, String fieldName, int upperIndex, int lowerIndex) {
			super(featureName, fieldName);
			this.upperIndex = upperIndex;
			this.lowerIndex = lowerIndex;
		}

		@Override
		public boolean check(Object obj) {
			if ((Integer) obj >= lowerIndex && (Integer) obj <= upperIndex) {
				return true;
			}
			return false;
		}
	}
}
