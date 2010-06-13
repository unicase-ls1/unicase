package org.unicase.model.urml.ui.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.Feature;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalSubGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceServiceProviderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

import urml.danger.Asset;
import urml.danger.Danger;
import urml.danger.DangerPackage;
import urml.danger.Mitigation;
import urml.danger.ProceduralMitigation;
import urml.goal.Goal;
import urml.goal.GoalPackage;
import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.Requirement;
import urml.requirement.RequirementPackage;
import urml.service.Service;
import urml.service.ServicePackage;
import urml.service.ServiceProvider;
import urml.usecase.Actor;
import urml.usecase.UsecasePackage;

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
			if (visualID == ServiceProviderEditPart.VISUAL_ID) {
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
			return getFeature_2005ContainedLinks(view);
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
		case ServiceProviderEditPart.VISUAL_ID:
			return getServiceProvider_2012ContainedLinks(view);
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
			return getFeature_2005IncomingLinks(view);
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
		case ServiceProviderEditPart.VISUAL_ID:
			return getServiceProvider_2012IncomingLinks(view);
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
			return getFeature_2005OutgoingLinks(view);
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
		case ServiceProviderEditPart.VISUAL_ID:
			return getServiceProvider_2012OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2005ContainedLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ParentFeature_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailingFunctionalRequirements_4006(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_Feature_ConstrainingNonFunctionalRequirements_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007ContainedLinks(View view) {
		Service modelElement = (Service) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Service_ServiceProvider_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008ContainedLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Actor_TriggeredDangers_4014(modelElement));
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
	public static List getServiceProvider_2012ContainedLinks(View view) {
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
		result.addAll(getIncomingFeatureModelFacetLinks_Goal_SubGoals_4009(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006IncomingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailingFunctionalRequirements_4006(modelElement,
			crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2005IncomingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ParentFeature_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement, crossReferences));
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008IncomingLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ConstrainingNonFunctionalRequirements_4010(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Actor_TriggeredDangers_4014(modelElement, crossReferences));
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
	public static List getServiceProvider_2012IncomingLinks(View view) {
		ServiceProvider modelElement = (ServiceProvider) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Service_ServiceProvider_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Danger_HarmedAssets_4013(modelElement, crossReferences));
		return result;
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFeature_2005OutgoingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ParentFeature_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailingFunctionalRequirements_4006(modelElement));
		result
			.addAll(getOutgoingFeatureModelFacetLinks_Feature_ConstrainingNonFunctionalRequirements_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007OutgoingLinks(View view) {
		Service modelElement = (Service) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Service_ServiceProvider_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_MitigatedDangers_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008OutgoingLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Actor_TriggeredDangers_4014(modelElement));
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
	public static List getServiceProvider_2012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
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
	private static Collection getIncomingFeatureModelFacetLinks_Feature_ParentFeature_4002(Feature target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE.getFeature_ParentFeature()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.FeatureParentFeature_4002, FeatureParentFeatureEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(Feature target,
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
	private static Collection getIncomingFeatureModelFacetLinks_Feature_DetailingFunctionalRequirements_4006(
		FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE.getFeature_DetailingFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006,
					FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Goal_SubGoals_4009(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == GoalPackage.eINSTANCE.getGoal_SubGoals()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.GoalSubGoals_4009,
					GoalSubGoalsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Feature_ConstrainingNonFunctionalRequirements_4010(
		NonFunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE
				.getFeature_ConstrainingNonFunctionalRequirements()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010,
					FeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Service_ServiceProvider_4011(ServiceProvider target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == ServicePackage.eINSTANCE.getService_ServiceProvider()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.ServiceServiceProvider_4011, ServiceServiceProviderEditPart.VISUAL_ID));
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
	private static Collection getIncomingFeatureModelFacetLinks_Actor_TriggeredDangers_4014(Danger target,
		Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UsecasePackage.eINSTANCE.getActor_TriggeredDangers()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target,
					UrmlElementTypes.ActorTriggeredDangers_4014, ActorTriggeredDangersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4008(Stakeholder source) {
		Collection result = new LinkedList();
		Goal destination = source.getGoals();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.StakeholderGoals_4008,
			StakeholderGoalsEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Feature_ParentFeature_4002(Feature source) {
		Collection result = new LinkedList();
		Feature destination = source.getParentFeature();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.FeatureParentFeature_4002,
			FeatureParentFeatureEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(Goal source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getRealizedFeatures().iterator(); destinations.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.GoalRealizedFeatures_4004,
				GoalRealizedFeaturesEditPart.VISUAL_ID));
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
	private static Collection getOutgoingFeatureModelFacetLinks_Feature_DetailingFunctionalRequirements_4006(
		Feature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getDetailingFunctionalRequirements().iterator(); destinations.hasNext();) {
			FunctionalRequirement destination = (FunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006,
				FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Goal_SubGoals_4009(Goal source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubGoals().iterator(); destinations.hasNext();) {
			Goal destination = (Goal) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.GoalSubGoals_4009,
				GoalSubGoalsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Feature_ConstrainingNonFunctionalRequirements_4010(
		Feature source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainingNonFunctionalRequirements().iterator(); destinations
			.hasNext();) {
			NonFunctionalRequirement destination = (NonFunctionalRequirement) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination,
				UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010,
				FeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Service_ServiceProvider_4011(Service source) {
		Collection result = new LinkedList();
		ServiceProvider destination = source.getServiceProvider();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.ServiceServiceProvider_4011,
			ServiceServiceProviderEditPart.VISUAL_ID));
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
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_TriggeredDangers_4014(Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getTriggeredDangers().iterator(); destinations.hasNext();) {
			Danger destination = (Danger) destinations.next();
			result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.ActorTriggeredDangers_4014,
				ActorTriggeredDangersEditPart.VISUAL_ID));
		}
		return result;
	}

}
