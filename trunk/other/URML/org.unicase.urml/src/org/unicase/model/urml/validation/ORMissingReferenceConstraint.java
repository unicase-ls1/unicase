package org.unicase.model.urml.validation;

import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.urml.feature.impl.FeatureImpl;
import org.unicase.model.urml.feature.impl.ProductImpl;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.urml.goal.impl.GoalImpl;
import org.unicase.model.urml.usecase.impl.ActorImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class ORMissingReferenceConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, String[][]> checks;

	public ORMissingReferenceConstraint() {
		checks = new HashMap<Class<? extends EObject>, String[][]>();
		checks.put(GoalImpl.class, new String[][] { { "realizedFeatures", "Sub_" } });
		checks.put(FeatureImpl.class, new String[][] { { "goals", "Parent_" },
			{ "detailingFunctionalRequirements", "constrainingNonFunctionalRequirements", "Sub_" },
			{ "products", "variationPointInstances", "Sub_" } });
		checks.put(VariationPointImpl.class, new String[][] { { "goals", "Parent_" },
			{ "detailingFunctionalRequirements", "constrainingNonFunctionalRequirements", "Sub_" } });
		checks.put(ActorImpl.class, new String[][] { { "useCases", "triggeredDangers" } });
		checks.put(ProductImpl.class, new String[][] { { "features", "variationPointInstances" } });
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (checks.containsKey(eObj.getClass())) {
				for (String[] orFeatureNames : checks.get(eObj.getClass())) {
					boolean failed = true;
					for (String featureName : orFeatureNames) {
						Object field;
						if (featureName.equals("Sub_")) {
							field = eObj.eContents();
						} else if (featureName.equals("Parent_")) {
							field = eObj.eContainer();
							if (field instanceof LeafSection) {
								field = null;
							}
						} else {
							EStructuralFeature feature = eObj.eClass().getEStructuralFeature(featureName);
							field = eObj.eGet(feature);
							EStructuralFeature errorFeature = ValidationConstraintHelper
								.getErrorFeatureForModelElement((UnicaseModelElement) eObj, feature.getName());
							ctx.addResult(errorFeature);
						}
						if (!((field instanceof EList<?> && ((EList<?>) field).isEmpty()) || field == null)) {
							failed = false;
						}
					}
					if (failed) {
						Object[] message = new Object[] {
							eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'",
							"'" + Arrays.toString(orFeatureNames).replaceAll("_", eObj.eClass().getName()) + "'" };
						return ctx.createFailureStatus(message);
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
