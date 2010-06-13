package org.unicase.model.urml.ui.diagram.part;

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
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.Feature;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

import urml.goal.Goal;
import urml.goal.GoalPackage;
import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.Requirement;
import urml.requirement.RequirementPackage;
import urml.service.Service;

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
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001ContainedLinks(view);
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
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001IncomingLinks(view);
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
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000ContainedLinks(View view) {
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Stakeholder_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002ContainedLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001ContainedLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008ContainedLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001ContainedLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
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
		result.addAll(getIncomingTypeModelFacetLinks_Stakeholder_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement, crossReferences));
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
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002OutgoingLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001OutgoingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Goal_RealizedFeatures_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_2007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNonFunctionalRequirement_2008OutgoingLinks(View view) {
		NonFunctionalRequirement modelElement = (NonFunctionalRequirement) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ImplementingServices_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDanger_2009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001OutgoingLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Stakeholder_4001(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Stakeholder) {
				continue;
			}
			Stakeholder link = (Stakeholder) linkObject;
			if (Stakeholder2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Goal dst = link.getGoals();
			result.add(new UrmlLinkDescriptor(container, dst, link, UrmlElementTypes.Stakeholder_4001,
				Stakeholder2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Stakeholder_4001(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UrmlPackage.eINSTANCE.getStakeholder_Goals()
				|| false == setting.getEObject() instanceof Stakeholder) {
				continue;
			}
			Stakeholder link = (Stakeholder) setting.getEObject();
			if (Stakeholder2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof MEDiagram) {
				continue;
			}
			MEDiagram container = (MEDiagram) link.eContainer();
			result.add(new UrmlLinkDescriptor(container, target, link, UrmlElementTypes.Stakeholder_4001,
				Stakeholder2EditPart.VISUAL_ID));

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
	private static Collection getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4003(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE.getStakeholder_Goals()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.StakeholderGoals_4003,
					StakeholderGoalsEditPart.VISUAL_ID));
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
	private static Collection getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(Stakeholder source) {
		Collection result = new LinkedList();
		Goal destination = source.getGoals();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.StakeholderGoals_4003,
			StakeholderGoalsEditPart.VISUAL_ID));
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

}
