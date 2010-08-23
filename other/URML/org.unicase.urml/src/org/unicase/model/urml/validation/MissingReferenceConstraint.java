package org.unicase.model.urml.validation;

import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.danger.impl.DangerImpl;
import org.unicase.model.urml.danger.impl.ProceduralMitigationImpl;
import org.unicase.model.urml.feature.impl.FeatureImpl;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.urml.feature.impl.VariationPointInstanceImpl;
import org.unicase.model.urml.goal.impl.GoalImpl;
import org.unicase.model.urml.goal.impl.GoalReferenceImpl;
import org.unicase.model.urml.impl.StakeholderImpl;
import org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl;
import org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl;
import org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl;
import org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class MissingReferenceConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, String[]> checks;

	public MissingReferenceConstraint() {
		checks = new HashMap<Class<? extends EObject>, String[]>();
		checks.put(DangerImpl.class, new String[] { "mitigations", "harmedAssets" });
		checks.put(NonFunctionalRequirementImpl.class, new String[] { "implementingServices" });
		checks.put(FunctionalRequirementImpl.class, new String[] { "implementingServices" });
		checks.put(ProceduralMitigationImpl.class, new String[] { "mitigatedDangers" });
		checks.put(VariationPointInstanceImpl.class, new String[] { "products", "variationPoint", "selectedFeatures" });
		checks.put(VariationPointImpl.class, new String[] { "instances" });
		checks.put(GoalImpl.class, new String[] { "stakeholders" });
		checks.put(StakeholderImpl.class, new String[] { "goals" });
		checks.put(GoalReferenceImpl.class, new String[] { "source", "target" });
		checks.put(SolutionDomainUseCaseImpl.class, new String[] { "detailedFeature" });
		checks.put(ApplicationDomainUseCaseImpl.class, new String[] { "detailedGoal" });
		checks.put(FeatureImpl.class, new String[] { "products" });
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (checks.containsKey(eObj.getClass())) {
				for (String featureName : checks.get(eObj.getClass())) {
					EStructuralFeature feature = eObj.eClass().getEStructuralFeature(featureName);
					Object field = eObj.eGet(feature);
					if ((field instanceof EList<?> && ((EList<?>) field).isEmpty()) || field == null) {
						Object[] message = new Object[] {
							eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'",
							feature.getEType().getName() };
						EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
							(UnicaseModelElement) eObj, feature.getName());
						ctx.addResult(errorFeature);
						return ctx.createFailureStatus(message);
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
