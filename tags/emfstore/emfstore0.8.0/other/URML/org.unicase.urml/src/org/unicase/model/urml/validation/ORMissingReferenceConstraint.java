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
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.FeatureImpl;
import org.unicase.model.urml.feature.impl.ProductImpl;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.impl.GoalImpl;
import org.unicase.model.urml.usecase.UsecasePackage;
import org.unicase.model.urml.usecase.impl.ActorImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class ORMissingReferenceConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, EStructuralFeature[][]> featuresToCheck;

	public ORMissingReferenceConstraint() {
		featuresToCheck = new HashMap<Class<? extends EObject>, EStructuralFeature[][]>();
		featuresToCheck.put(GoalImpl.class, new EStructuralFeature[][] { {
			GoalPackage.eINSTANCE.getGoal_RealizedFeatures(), GoalPackage.eINSTANCE.getGoal_SubGoals() } });
		featuresToCheck.put(FeatureImpl.class, new EStructuralFeature[][] {
			{ FeaturePackage.eINSTANCE.getAbstractFeature_Goals(),
				FeaturePackage.eINSTANCE.getAbstractFeature_ParentFeature() },
			{ FeaturePackage.eINSTANCE.getAbstractFeature_DetailingFunctionalRequirements(),
				FeaturePackage.eINSTANCE.getAbstractFeature_ConstrainingNonFunctionalRequirements(),
				FeaturePackage.eINSTANCE.getAbstractFeature_SubFeatures() },
			{ FeaturePackage.eINSTANCE.getFeature_Products(),
				FeaturePackage.eINSTANCE.getAbstractFeature_VariationPointInstances(),
				FeaturePackage.eINSTANCE.getAbstractFeature_SubFeatures() } });
		featuresToCheck.put(VariationPointImpl.class, new EStructuralFeature[][] {
			{ FeaturePackage.eINSTANCE.getAbstractFeature_Goals(),
				FeaturePackage.eINSTANCE.getAbstractFeature_ParentFeature() },
			{ FeaturePackage.eINSTANCE.getAbstractFeature_DetailingFunctionalRequirements(),
				FeaturePackage.eINSTANCE.getAbstractFeature_ConstrainingNonFunctionalRequirements() } });
		featuresToCheck.put(ActorImpl.class, new EStructuralFeature[][] { {
			UsecasePackage.eINSTANCE.getActor_UseCases(), DangerPackage.eINSTANCE.getAsset_TriggeredDangers() } });
		featuresToCheck.put(ProductImpl.class, new EStructuralFeature[][] { {
			FeaturePackage.eINSTANCE.getProduct_Features(),
			FeaturePackage.eINSTANCE.getProduct_VariationPointInstances() } });
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (featuresToCheck.containsKey(eObj.getClass())) {
				for (EStructuralFeature[] features : featuresToCheck.get(eObj.getClass())) {
					boolean failed = true;
					String featureNames = "";
					for (EStructuralFeature feature : features) {
						Object field = eObj.eGet(feature);
						if (!((field instanceof EList<?> && ((EList<?>) field).isEmpty()) || field == null)) {
							failed = false;
						} else {
							featureNames += ", or ";
							if (!feature.isMany()) {
								featureNames += "a(n) ";
							}
							featureNames += "'" + feature.getName() + "'";
							try {
								EStructuralFeature errorFeature = ValidationConstraintHelper
									.getErrorFeatureForModelElement((UnicaseModelElement) eObj, feature.getName());
								ctx.addResult(errorFeature);
							} catch (NullPointerException e) {
								// this happens if we try to get the parent feature : ignore
							}
						}
					}
					if (failed) {
						Object[] message = new Object[] {
							eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName() + "'",
							featureNames.replaceFirst(", or ", "") };
						return ctx.createFailureStatus(message);
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
