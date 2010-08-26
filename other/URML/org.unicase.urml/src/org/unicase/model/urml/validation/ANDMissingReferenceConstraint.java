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
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.impl.DangerImpl;
import org.unicase.model.urml.danger.impl.ProceduralMitigationImpl;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.urml.feature.impl.VariationPointInstanceImpl;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.impl.GoalImpl;
import org.unicase.model.urml.goal.impl.GoalReferenceImpl;
import org.unicase.model.urml.impl.StakeholderImpl;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl;
import org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl;
import org.unicase.model.urml.usecase.UsecasePackage;
import org.unicase.model.urml.usecase.impl.ApplicationDomainUseCaseImpl;
import org.unicase.model.urml.usecase.impl.SolutionDomainUseCaseImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class ANDMissingReferenceConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, EStructuralFeature[]> featuresToCheck;

	public ANDMissingReferenceConstraint() {
		featuresToCheck = new HashMap<Class<? extends EObject>, EStructuralFeature[]>();
		featuresToCheck.put(DangerImpl.class, new EStructuralFeature[] {
			DangerPackage.eINSTANCE.getDanger_Mitigations(), DangerPackage.eINSTANCE.getDanger_HarmedAssets() });
		featuresToCheck.put(NonFunctionalRequirementImpl.class, new EStructuralFeature[] { RequirementPackage.eINSTANCE
			.getRequirement_ImplementingServices() });
		featuresToCheck.put(FunctionalRequirementImpl.class, new EStructuralFeature[] { RequirementPackage.eINSTANCE
			.getRequirement_ImplementingServices() });
		featuresToCheck.put(ProceduralMitigationImpl.class, new EStructuralFeature[] { DangerPackage.eINSTANCE
			.getMitigation_MitigatedDangers() });
		featuresToCheck.put(VariationPointImpl.class, new EStructuralFeature[] {
			FeaturePackage.eINSTANCE.getVariationPoint_Instances(),
			FeaturePackage.eINSTANCE.getVariationPoint_OptionalSubFeatures() });
		featuresToCheck.put(VariationPointInstanceImpl.class, new EStructuralFeature[] {
			FeaturePackage.eINSTANCE.getVariationPointInstance_Products(),
			FeaturePackage.eINSTANCE.getVariationPointInstance_VariationPoint(),
			FeaturePackage.eINSTANCE.getVariationPointInstance_SelectedFeatures() });
		featuresToCheck.put(GoalImpl.class, new EStructuralFeature[] { GoalPackage.eINSTANCE.getGoal_Stakeholders() });
		featuresToCheck.put(StakeholderImpl.class, new EStructuralFeature[] { UrmlPackage.eINSTANCE
			.getStakeholder_Goals() });
		featuresToCheck.put(GoalReferenceImpl.class, new EStructuralFeature[] {
			GoalPackage.eINSTANCE.getGoalReference_Source(), GoalPackage.eINSTANCE.getGoalReference_Target() });
		featuresToCheck.put(SolutionDomainUseCaseImpl.class, new EStructuralFeature[] { UsecasePackage.eINSTANCE
			.getSolutionDomainUseCase_DetailedFeature() });
		featuresToCheck.put(ApplicationDomainUseCaseImpl.class, new EStructuralFeature[] { UsecasePackage.eINSTANCE
			.getApplicationDomainUseCase_DetailedGoal() });
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (featuresToCheck.containsKey(eObj.getClass())) {
				for (EStructuralFeature feature : featuresToCheck.get(eObj.getClass())) {
					Object field = eObj.eGet(feature);
					if ((field instanceof EList<?> && ((EList<?>) field).isEmpty()) || field == null) {
						String featureName = "";
						if (!feature.isMany()) {
							featureName += "a(n) ";
						}
						featureName += "'" + feature.getName() + "'";
						Object[] message = new Object[] {
							eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'", featureName };
						try {
							EStructuralFeature errorFeature = ValidationConstraintHelper
								.getErrorFeatureForModelElement((UnicaseModelElement) eObj, feature.getName());
							ctx.addResult(errorFeature);
						} catch (NullPointerException e) {
							// this happens if we try to get the parent feature : ignore
						}
						return ctx.createFailureStatus(message);
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
