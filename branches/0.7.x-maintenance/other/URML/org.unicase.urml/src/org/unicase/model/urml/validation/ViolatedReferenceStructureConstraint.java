package org.unicase.model.urml.validation;

import java.util.HashMap;
import java.util.Iterator;

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
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.FeatureImpl;
import org.unicase.model.urml.feature.impl.ProductImpl;
import org.unicase.model.urml.feature.impl.VariationPointImpl;
import org.unicase.model.urml.feature.impl.VariationPointInstanceImpl;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.impl.GoalImpl;
import org.unicase.model.urml.impl.StakeholderImpl;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl;
import org.unicase.model.urml.requirement.impl.NonFunctionalRequirementImpl;
import org.unicase.model.util.ValidationConstraintHelper;

public class ViolatedReferenceStructureConstraint extends AbstractModelConstraint {
	private HashMap<Class<? extends EObject>, EStructuralFeature[]> featuresToCheck;

	public ViolatedReferenceStructureConstraint() {
		featuresToCheck = new HashMap<Class<? extends EObject>, EStructuralFeature[]>();
		featuresToCheck.put(GoalImpl.class,
			new EStructuralFeature[] { GoalPackage.eINSTANCE.getGoal_RealizedFeatures() });
		featuresToCheck.put(FeatureImpl.class, new EStructuralFeature[] {
			FeaturePackage.eINSTANCE.getAbstractFeature_DetailingFunctionalRequirements(),
			FeaturePackage.eINSTANCE.getAbstractFeature_ConstrainingNonFunctionalRequirements() });
		featuresToCheck.put(VariationPointImpl.class, new EStructuralFeature[] {
			FeaturePackage.eINSTANCE.getAbstractFeature_DetailingFunctionalRequirements(),
			FeaturePackage.eINSTANCE.getAbstractFeature_ConstrainingNonFunctionalRequirements(),
			FeaturePackage.eINSTANCE.getVariationPoint_OptionalSubFeatures() });
		featuresToCheck.put(VariationPointInstanceImpl.class, new EStructuralFeature[] { FeaturePackage.eINSTANCE
			.getVariationPointInstance_SelectedFeatures() });
		featuresToCheck.put(FunctionalRequirementImpl.class, new EStructuralFeature[] { RequirementPackage.eINSTANCE
			.getRequirement_ImplementingServices() });
		featuresToCheck.put(NonFunctionalRequirementImpl.class, new EStructuralFeature[] { RequirementPackage.eINSTANCE
			.getRequirement_ImplementingServices() });
		featuresToCheck.put(StakeholderImpl.class, new EStructuralFeature[] { UrmlPackage.eINSTANCE
			.getStakeholder_Goals() });
		featuresToCheck.put(ProductImpl.class, new EStructuralFeature[] { FeaturePackage.eINSTANCE
			.getProduct_Features() });
		featuresToCheck.put(DangerImpl.class, new EStructuralFeature[] {
			DangerPackage.eINSTANCE.getDanger_HarmedAssets(), DangerPackage.eINSTANCE.getDanger_TriggeringAssets(),
			DangerPackage.eINSTANCE.getDanger_Mitigations() });
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (featuresToCheck.containsKey(eObj.getClass())) {
				for (EStructuralFeature feature : featuresToCheck.get(eObj.getClass())) {
					Object field = eObj.eGet(feature);
					if ((field instanceof EList<?> && ((EList<?>) field).size() > 1)) {
						for (Object ref : (EList<?>) field) {
							if (ref instanceof EObject) {
								Iterator<EObject> eChilds = ((EObject) ref).eAllContents();
								while (eChilds.hasNext()) {
									if (((EList<?>) field).contains(eChilds.next())) {
										Object[] message = new Object[] {
											eObj.eClass().getName() + ": '" + ((UnicaseModelElement) eObj).getName()
												+ "'", "'" + feature.getName() + "'" };
										try {
											EStructuralFeature errorFeature = ValidationConstraintHelper
												.getErrorFeatureForModelElement((UnicaseModelElement) eObj, feature
													.getName());
											ctx.addResult(errorFeature);
										} catch (NullPointerException e) {
											// this happens if we try to get the parent feature : ignore
										}
										return ctx.createFailureStatus(message);
									}
								}
							}
						}
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
