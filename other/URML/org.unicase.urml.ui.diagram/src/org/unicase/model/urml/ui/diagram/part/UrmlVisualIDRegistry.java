package org.unicase.model.urml.ui.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureRequieredFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.CombineLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.CombineLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ExcludesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ExpressesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference3EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference4EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReferenceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReferenceWeight2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReferenceWeight3EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReferenceWeightEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalSubGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.HarmsLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.InfluencesLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.InfluencesLabel3EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.InfluencesLabel4EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.InfluencesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.InstantiateLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsConstraintLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsDetailedLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsDetailedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsImplementedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsRefinedLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsRefinedLabel5EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsRefinedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigatesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MotivatesLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MotivatesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequieresLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementSubRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.SelectLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceSubServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.TriggersLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointNameEditPart;
import org.unicase.model.urml.ui.diagram.expressions.UrmlAbstractExpression;
import org.unicase.model.urml.ui.diagram.expressions.UrmlOCLFactory;

import urml.danger.DangerPackage;
import urml.feature.FeaturePackage;
import urml.goal.GoalPackage;
import urml.goal.GoalReference;
import urml.requirement.RequirementPackage;
import urml.service.ServicePackage;
import urml.usecase.UsecasePackage;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node,
 * ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class UrmlVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.urml.ui.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UrmlAbstractExpression GoalReference_4016_Constraint;

	/**
	 * @generated
	 */
	private static UrmlAbstractExpression GoalReference_4023_Constraint;

	/**
	 * @generated
	 */
	private static UrmlAbstractExpression GoalReference_4024_Constraint;

	/**
	 * @generated
	 */
	private static UrmlAbstractExpression GoalReference_4025_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (URMLDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return URMLDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UrmlDiagramEditorPlugin.getInstance().logError(
					"Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UrmlPackage.eINSTANCE.getURMLDiagram().isSuperTypeOf(domainElement.eClass())
			&& isDiagram((URMLDiagram) domainElement)) {
			return URMLDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getModelID(containerView);
		if (!URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = URMLDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case URMLDiagramEditPart.VISUAL_ID:
			if (UrmlPackage.eINSTANCE.getStakeholder().isSuperTypeOf(domainElement.eClass())) {
				return StakeholderEditPart.VISUAL_ID;
			}
			if (GoalPackage.eINSTANCE.getGoal().isSuperTypeOf(domainElement.eClass())) {
				return GoalEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getFunctionalRequirement().isSuperTypeOf(domainElement.eClass())) {
				return FunctionalRequirementEditPart.VISUAL_ID;
			}
			if (FeaturePackage.eINSTANCE.getFeature().isSuperTypeOf(domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			if (ServicePackage.eINSTANCE.getService().isSuperTypeOf(domainElement.eClass())) {
				return ServiceEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getNonFunctionalRequirement().isSuperTypeOf(domainElement.eClass())) {
				return NonFunctionalRequirementEditPart.VISUAL_ID;
			}
			if (DangerPackage.eINSTANCE.getDanger().isSuperTypeOf(domainElement.eClass())) {
				return DangerEditPart.VISUAL_ID;
			}
			if (UsecasePackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return ActorEditPart.VISUAL_ID;
			}
			if (DangerPackage.eINSTANCE.getProceduralMitigation().isSuperTypeOf(domainElement.eClass())) {
				return ProceduralMitigationEditPart.VISUAL_ID;
			}
			if (FeaturePackage.eINSTANCE.getVariationPoint().isSuperTypeOf(domainElement.eClass())) {
				return VariationPointEditPart.VISUAL_ID;
			}
			if (FeaturePackage.eINSTANCE.getVariationPointInstance().isSuperTypeOf(domainElement.eClass())) {
				return VariationPointInstanceEditPart.VISUAL_ID;
			}
			if (FeaturePackage.eINSTANCE.getProduct().isSuperTypeOf(domainElement.eClass())) {
				return ProductEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getModelID(containerView);
		if (!URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = URMLDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case StakeholderEditPart.VISUAL_ID:
			if (StakeholderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalEditPart.VISUAL_ID:
			if (GoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionalRequirementEditPart.VISUAL_ID:
			if (FunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureEditPart.VISUAL_ID:
			if (FeatureNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServiceEditPart.VISUAL_ID:
			if (ServiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			if (NonFunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DangerEditPart.VISUAL_ID:
			if (DangerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorEditPart.VISUAL_ID:
			if (ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProceduralMitigationEditPart.VISUAL_ID:
			if (ProceduralMitigationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariationPointEditPart.VISUAL_ID:
			if (VariationPointNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariationPointInstanceEditPart.VISUAL_ID:
			if (VariationPointInstanceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProductEditPart.VISUAL_ID:
			if (ProductNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case URMLDiagramEditPart.VISUAL_ID:
			if (StakeholderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FunctionalRequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FeatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ServiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NonFunctionalRequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DangerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProceduralMitigationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariationPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariationPointInstanceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProductEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StakeholderGoalsEditPart.VISUAL_ID:
			if (ExpressesLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
			if (IsRefinedLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			if (IsDetailedLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			if (IsConstraintLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID:
			if (RequieresLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
			if (ExcludesLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			if (MotivatesLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalSubGoalsEditPart.VISUAL_ID:
			if (IsRefinedLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalReferenceEditPart.VISUAL_ID:
			if (IsDetailedLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InfluencesLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalReference2EditPart.VISUAL_ID:
			if (GoalReferenceWeightEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InfluencesLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalReference3EditPart.VISUAL_ID:
			if (GoalReferenceWeight2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InfluencesLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalReference4EditPart.VISUAL_ID:
			if (GoalReferenceWeight3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InfluencesLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			if (IsImplementedLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSubRequirementsEditPart.VISUAL_ID:
			if (IsRefinedLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			if (MitigatesLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			if (HarmsLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			if (TriggersLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServiceSubServicesEditPart.VISUAL_ID:
			if (MotivatesLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariationPointFeaturesEditPart.VISUAL_ID:
			if (CombineLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			if (InstantiateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			if (SelectLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProductVariationPointInstancesEditPart.VISUAL_ID:
			if (CombineLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (GoalPackage.eINSTANCE.getGoalReference().isSuperTypeOf(domainElement.eClass())
			&& isGoalReference_4016((GoalReference) domainElement)) {
			return GoalReferenceEditPart.VISUAL_ID;
		}
		if (GoalPackage.eINSTANCE.getGoalReference().isSuperTypeOf(domainElement.eClass())
			&& isGoalReference_4023((GoalReference) domainElement)) {
			return GoalReference2EditPart.VISUAL_ID;
		}
		if (GoalPackage.eINSTANCE.getGoalReference().isSuperTypeOf(domainElement.eClass())
			&& isGoalReference_4024((GoalReference) domainElement)) {
			return GoalReference3EditPart.VISUAL_ID;
		}
		if (GoalPackage.eINSTANCE.getGoalReference().isSuperTypeOf(domainElement.eClass())
			&& isGoalReference_4025((GoalReference) domainElement)) {
			return GoalReference4EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(URMLDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isGoalReference_4016(GoalReference domainElement) {
		if (GoalReference_4016_Constraint == null) { // lazy initialization
			GoalReference_4016_Constraint = UrmlOCLFactory.getExpression(
				"self.weight = GoalReferenceType::PLUS_PLUS", GoalPackage.eINSTANCE.getGoalReference()); //$NON-NLS-1$
		}
		Object result = GoalReference_4016_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isGoalReference_4023(GoalReference domainElement) {
		if (GoalReference_4023_Constraint == null) { // lazy initialization
			GoalReference_4023_Constraint = UrmlOCLFactory.getExpression(
				"self.weight = GoalReferenceType::PLUS", GoalPackage.eINSTANCE.getGoalReference()); //$NON-NLS-1$
		}
		Object result = GoalReference_4023_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isGoalReference_4024(GoalReference domainElement) {
		if (GoalReference_4024_Constraint == null) { // lazy initialization
			GoalReference_4024_Constraint = UrmlOCLFactory.getExpression(
				"self.weight = GoalReferenceType::MINUS", GoalPackage.eINSTANCE.getGoalReference()); //$NON-NLS-1$
		}
		Object result = GoalReference_4024_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isGoalReference_4025(GoalReference domainElement) {
		if (GoalReference_4025_Constraint == null) { // lazy initialization
			GoalReference_4025_Constraint = UrmlOCLFactory.getExpression(
				"self.weight = GoalReferenceType::MINUS_MINUS", GoalPackage.eINSTANCE.getGoalReference()); //$NON-NLS-1$
		}
		Object result = GoalReference_4025_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
