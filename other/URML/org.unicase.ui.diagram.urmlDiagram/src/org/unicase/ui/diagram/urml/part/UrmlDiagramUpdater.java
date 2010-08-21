package org.unicase.ui.diagram.urml.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.Asset;
import org.unicase.model.urml.danger.Danger;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.Mitigation;
import org.unicase.model.urml.danger.ProceduralMitigation;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.requirement.FunctionalRequirement;
import org.unicase.model.urml.requirement.NonFunctionalRequirement;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.service.Service;
import org.unicase.model.urml.service.ServicePackage;
import org.unicase.model.urml.usecase.Actor;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureRequiredFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ActorEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FeatureEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementSubFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference4EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalSubGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementSubNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProceduralMitigationEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceSubServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.URMLDiagramEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointOptionalSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class UrmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = UrmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StakeholderEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GoalEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FunctionalRequirementEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FeatureEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ServiceEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NonFunctionalRequirementEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DangerEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ActorEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ProceduralMitigationEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == VariationPointEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == VariationPointInstanceEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ProductEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000ContainedLinks(view);
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002ContainedLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001ContainedLinks(view);
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006ContainedLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2012ContainedLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_2007ContainedLinks(view);
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return getNonFunctionalRequirement_2008ContainedLinks(view);
		case DangerEditPart.VISUAL_ID:
			return getDanger_2009ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2010ContainedLinks(view);
		case ProceduralMitigationEditPart.VISUAL_ID:
			return getProceduralMitigation_2011ContainedLinks(view);
		case VariationPointEditPart.VISUAL_ID:
			return getVariationPoint_2013ContainedLinks(view);
		case VariationPointInstanceEditPart.VISUAL_ID:
			return getVariationPointInstance_2014ContainedLinks(view);
		case ProductEditPart.VISUAL_ID:
			return getProduct_2015ContainedLinks(view);
		case GoalReferenceEditPart.VISUAL_ID:
			return getGoalReference_4016ContainedLinks(view);
		case GoalReference2EditPart.VISUAL_ID:
			return getGoalReference_4023ContainedLinks(view);
		case GoalReference3EditPart.VISUAL_ID:
			return getGoalReference_4024ContainedLinks(view);
		case GoalReference4EditPart.VISUAL_ID:
			return getGoalReference_4025ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002IncomingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001IncomingLinks(view);
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006IncomingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2012IncomingLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_2007IncomingLinks(view);
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return getNonFunctionalRequirement_2008IncomingLinks(view);
		case DangerEditPart.VISUAL_ID:
			return getDanger_2009IncomingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2010IncomingLinks(view);
		case ProceduralMitigationEditPart.VISUAL_ID:
			return getProceduralMitigation_2011IncomingLinks(view);
		case VariationPointEditPart.VISUAL_ID:
			return getVariationPoint_2013IncomingLinks(view);
		case VariationPointInstanceEditPart.VISUAL_ID:
			return getVariationPointInstance_2014IncomingLinks(view);
		case ProductEditPart.VISUAL_ID:
			return getProduct_2015IncomingLinks(view);
		case GoalReferenceEditPart.VISUAL_ID:
			return getGoalReference_4016IncomingLinks(view);
		case GoalReference2EditPart.VISUAL_ID:
			return getGoalReference_4023IncomingLinks(view);
		case GoalReference3EditPart.VISUAL_ID:
			return getGoalReference_4024IncomingLinks(view);
		case GoalReference4EditPart.VISUAL_ID:
			return getGoalReference_4025IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002OutgoingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001OutgoingLinks(view);
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006OutgoingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2012OutgoingLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_2007OutgoingLinks(view);
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return getNonFunctionalRequirement_2008OutgoingLinks(view);
		case DangerEditPart.VISUAL_ID:
			return getDanger_2009OutgoingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2010OutgoingLinks(view);
		case ProceduralMitigationEditPart.VISUAL_ID:
			return getProceduralMitigation_2011OutgoingLinks(view);
		case VariationPointEditPart.VISUAL_ID:
			return getVariationPoint_2013OutgoingLinks(view);
		case VariationPointInstanceEditPart.VISUAL_ID:
			return getVariationPointInstance_2014OutgoingLinks(view);
		case ProductEditPart.VISUAL_ID:
			return getProduct_2015OutgoingLinks(view);
		case GoalReferenceEditPart.VISUAL_ID:
			return getGoalReference_4016OutgoingLinks(view);
		case GoalReference2EditPart.VISUAL_ID:
			return getGoalReference_4023OutgoingLinks(view);
		case GoalReference3EditPart.VISUAL_ID:
			return getGoalReference_4024OutgoingLinks(view);
		case GoalReference4EditPart.VISUAL_ID:
			return getGoalReference_4025OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000ContainedLinks(View view) {
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_GoalReference_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GoalReference_4023(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GoalReference_4024(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GoalReference_4025(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002ContainedLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001ContainedLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_SubFunctionalRequirements_4044(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2012ContainedLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007ContainedLinks(View view) {
		Service modelElement = (Service) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Service_SubServices_4022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008ContainedLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_NonFunctionalRequirement_SubNonFunctionalRequirements_4043(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009ContainedLinks(View view) {
		Danger modelElement = (Danger) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Danger_HarmedAssets_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProceduralMitigation_2011ContainedLinks(View view) {
		ProceduralMitigation modelElement = (ProceduralMitigation) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getVariationPoint_2013ContainedLinks(View view) {
		VariationPoint modelElement = (VariationPoint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getVariationPointInstance_2014ContainedLinks(View view) {
		VariationPointInstance modelElement = (VariationPointInstance) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPointInstance_VariationPoint_4033(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct_2015ContainedLinks(View view) {
		Product modelElement = (Product) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Product_VariationPointInstances_4032(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Product_Features_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4023ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4024ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4025ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001IncomingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Goal_SubGoals_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_GoalReference_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_GoalReference_4023(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_GoalReference_4024(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_GoalReference_4025(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006IncomingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(
			modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_FunctionalRequirement_SubFunctionalRequirements_4044(
			modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2012IncomingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result
			.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Product_Features_4047(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007IncomingLinks(View view) {
		Service modelElement = (Service) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Danger_HarmedAssets_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Service_SubServices_4022(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008IncomingLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(
			modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NonFunctionalRequirement_SubNonFunctionalRequirements_4043(
			modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009IncomingLinks(View view) {
		Danger modelElement = (Danger) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result
			.addAll(getIncomingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010IncomingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Danger_HarmedAssets_4013(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProceduralMitigation_2011IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getVariationPoint_2013IncomingLinks(View view) {
		VariationPoint modelElement = (VariationPoint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result
			.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_VariationPointInstance_VariationPoint_4033(modelElement,
			crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(modelElement,
			crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getVariationPointInstance_2014IncomingLinks(View view) {
		VariationPointInstance modelElement = (VariationPointInstance) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Product_VariationPointInstances_4032(modelElement,
			crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct_2015IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4023IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4024IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4025IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002OutgoingLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001OutgoingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_GoalReference_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_GoalReference_4023(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_GoalReference_4024(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_GoalReference_4025(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_SubFunctionalRequirements_4044(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2012OutgoingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007OutgoingLinks(View view) {
		Service modelElement = (Service) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Service_SubServices_4022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008OutgoingLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_NonFunctionalRequirement_SubNonFunctionalRequirements_4043(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009OutgoingLinks(View view) {
		Danger modelElement = (Danger) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Danger_HarmedAssets_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProceduralMitigation_2011OutgoingLinks(View view) {
		ProceduralMitigation modelElement = (ProceduralMitigation) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getVariationPoint_2013OutgoingLinks(View view) {
		VariationPoint modelElement = (VariationPoint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getVariationPointInstance_2014OutgoingLinks(View view) {
		VariationPointInstance modelElement = (VariationPointInstance) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPointInstance_VariationPoint_4033(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct_2015OutgoingLinks(View view) {
		Product modelElement = (Product) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Product_VariationPointInstances_4032(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Product_Features_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4016OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4023OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4024OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoalReference_4025OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_GoalReference_4016(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReferenceEditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4016,
				GoalReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_GoalReference_4023(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4023,
				GoalReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_GoalReference_4024(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference3EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4024,
				GoalReference3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_GoalReference_4025(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference4EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4025,
				GoalReference4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4008(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE.getStakeholder_Goals()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.StakeholderGoals_4008,
					StakeholderGoalsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(
		AbstractFeature target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getAbstractFeature_SubFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AbstractFeatureSubFeatures_4034, AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(
		FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE
				.getAbstractFeature_DetailingFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035,
					AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(
		NonFunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE
				.getAbstractFeature_ConstrainingNonFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036,
					AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(
		AbstractFeature target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getAbstractFeature_RequiredFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AbstractFeatureRequiredFeatures_4045,
					AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(
		AbstractFeature target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getAbstractFeature_ExcludedFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AbstractFeatureExcludedFeatures_4038,
					AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(AbstractFeature target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == GoalPackage.eINSTANCE.getGoal_RealizedFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.GoalRealizedFeatures_4004, GoalRealizedFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Goal_SubGoals_4018(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == GoalPackage.eINSTANCE.getGoal_SubGoals()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.GoalSubGoals_4018,
					GoalSubGoalsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_GoalReference_4016(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != GoalPackage.eINSTANCE.getGoalReference_Target()
				|| false == setting.getEObject() instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) setting.getEObject();
			if (GoalReferenceEditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, target, link, UrmlElementTypes.GoalReference_4016,
				GoalReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_GoalReference_4023(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != GoalPackage.eINSTANCE.getGoalReference_Target()
				|| false == setting.getEObject() instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) setting.getEObject();
			if (GoalReference2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, target, link, UrmlElementTypes.GoalReference_4023,
				GoalReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_GoalReference_4024(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != GoalPackage.eINSTANCE.getGoalReference_Target()
				|| false == setting.getEObject() instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) setting.getEObject();
			if (GoalReference3EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, target, link, UrmlElementTypes.GoalReference_4024,
				GoalReference3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_GoalReference_4025(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != GoalPackage.eINSTANCE.getGoalReference_Target()
				|| false == setting.getEObject() instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) setting.getEObject();
			if (GoalReference4EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal src = link.getSource();
			result.add(new UrmlLinkDescriptor(src, target, link, UrmlElementTypes.GoalReference_4025,
				GoalReference4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(Service target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE.getRequirement_ImplementingServices()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.RequirementImplementingServices_4005,
					RequirementImplementingServicesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_NonFunctionalRequirement_SubNonFunctionalRequirements_4043(
		NonFunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
				.getNonFunctionalRequirement_SubNonFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.NonFunctionalRequirementSubNonFunctionalRequirements_4043,
					NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_FunctionalRequirement_SubFunctionalRequirements_4044(
		FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
				.getFunctionalRequirement_SubFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044,
					FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(Danger target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == DangerPackage.eINSTANCE.getMitigation_MitigatedDangers()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.MitigationMitigatedDangers_4012, MitigationMitigatedDangersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Danger_HarmedAssets_4013(Asset target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == DangerPackage.eINSTANCE.getDanger_HarmedAssets()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.DangerHarmedAssets_4013, DangerHarmedAssetsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(Danger target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == DangerPackage.eINSTANCE.getAsset_TriggeredDangers()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.AssetTriggeredDangers_4017, AssetTriggeredDangersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Service_SubServices_4022(Service target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == ServicePackage.eINSTANCE.getService_SubServices()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.ServiceSubServices_4022, ServiceSubServicesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(
		AbstractFeature target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getVariationPoint_OptionalSubFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.VariationPointOptionalSubFeatures_4046,
					VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_VariationPointInstance_VariationPoint_4033(
		VariationPoint target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getVariationPointInstance_VariationPoint()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.VariationPointInstanceVariationPoint_4033,
					VariationPointInstanceVariationPointEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(
		AbstractFeature target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE
				.getVariationPointInstance_SelectedFeatures()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040,
					VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Product_VariationPointInstances_4032(
		VariationPointInstance target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getProduct_VariationPointInstances()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.ProductVariationPointInstances_4032,
					ProductVariationPointInstancesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Product_Features_4047(Feature target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == FeaturePackage.eINSTANCE.getProduct_Features()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.ProductFeatures_4047,
					ProductFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4008(Stakeholder source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getGoals().iterator(); destinations.hasNext();) {
			Goal destination = (Goal) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.StakeholderGoals_4008,
				StakeholderGoalsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_AbstractFeature_SubFeatures_4034(AbstractFeature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.AbstractFeatureSubFeatures_4034,
				AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_AbstractFeature_DetailingFunctionalRequirements_4035(
		AbstractFeature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getDetailingFunctionalRequirements().iterator(); destinations.hasNext();) {
			FunctionalRequirement destination = (FunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035,
				AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_AbstractFeature_ConstrainingNonFunctionalRequirements_4036(
		AbstractFeature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainingNonFunctionalRequirements().iterator(); destinations
			.hasNext();) {
			NonFunctionalRequirement destination = (NonFunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036,
				AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_AbstractFeature_RequiredFeatures_4045(
		AbstractFeature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getRequiredFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.AbstractFeatureRequiredFeatures_4045,
				AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_AbstractFeature_ExcludedFeatures_4038(
		AbstractFeature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getExcludedFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.AbstractFeatureExcludedFeatures_4038,
				AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(Goal source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getRealizedFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.GoalRealizedFeatures_4004,
				GoalRealizedFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4018(Goal source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubGoals().iterator(); destinations.hasNext();) {
			Goal destination = (Goal) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.GoalSubGoals_4018,
				GoalSubGoalsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_GoalReference_4016(Goal source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReferenceEditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4016,
				GoalReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_GoalReference_4023(Goal source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4023,
				GoalReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_GoalReference_4024(Goal source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference3EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4024,
				GoalReference3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_GoalReference_4025(Goal source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GoalReference) {
				continue;
			}
			GoalReference link = (GoalReference) linkObject;
			if (GoalReference4EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getTarget();
			Goal src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new UrmlLinkDescriptor(src, dst, link, UrmlElementTypes.GoalReference_4025,
				GoalReference4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(Requirement source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getImplementingServices().iterator(); destinations.hasNext();) {
			Service destination = (Service) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.RequirementImplementingServices_4005,
				RequirementImplementingServicesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_NonFunctionalRequirement_SubNonFunctionalRequirements_4043(
		NonFunctionalRequirement source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubNonFunctionalRequirements().iterator(); destinations.hasNext();) {
			NonFunctionalRequirement destination = (NonFunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.NonFunctionalRequirementSubNonFunctionalRequirements_4043,
				NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_FunctionalRequirement_SubFunctionalRequirements_4044(
		FunctionalRequirement source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubFunctionalRequirements().iterator(); destinations.hasNext();) {
			FunctionalRequirement destination = (FunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044,
				FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(Mitigation source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getMitigatedDangers().iterator(); destinations.hasNext();) {
			Danger destination = (Danger) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.MitigationMitigatedDangers_4012,
				MitigationMitigatedDangersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Danger_HarmedAssets_4013(Danger source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getHarmedAssets().iterator(); destinations.hasNext();) {
			Asset destination = (Asset) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.DangerHarmedAssets_4013,
				DangerHarmedAssetsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Asset_TriggeredDangers_4017(Asset source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getTriggeredDangers().iterator(); destinations.hasNext();) {
			Danger destination = (Danger) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.AssetTriggeredDangers_4017,
				AssetTriggeredDangersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Service_SubServices_4022(Service source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubServices().iterator(); destinations.hasNext();) {
			Service destination = (Service) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.ServiceSubServices_4022,
				ServiceSubServicesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_VariationPoint_OptionalSubFeatures_4046(
		VariationPoint source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getOptionalSubFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.VariationPointOptionalSubFeatures_4046,
				VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_VariationPointInstance_VariationPoint_4033(
		VariationPointInstance source) {
		Collection result = new LinkedList();
		VariationPoint destination = source.getVariationPoint();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination,
			UrmlElementTypes.VariationPointInstanceVariationPoint_4033,
			VariationPointInstanceVariationPointEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_VariationPointInstance_SelectedFeatures_4040(
		VariationPointInstance source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSelectedFeatures().iterator(); destinations.hasNext();) {
			AbstractFeature destination = (AbstractFeature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040,
				VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Product_VariationPointInstances_4032(Product source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getVariationPointInstances().iterator(); destinations.hasNext();) {
			VariationPointInstance destination = (VariationPointInstance) destinations.next();
			result
				.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.ProductVariationPointInstances_4032,
					ProductVariationPointInstancesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Product_Features_4047(Product source) {
		Collection result = new LinkedList();
		Feature destination = source.getFeatures();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.ProductFeatures_4047,
			ProductFeaturesEditPart.VISUAL_ID));
		return result;
	}

}
