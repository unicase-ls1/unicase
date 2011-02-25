package org.unicase.ui.urmlDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.hazard.Hazard;
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.hazard.Mitigation;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_66SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_66SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_66ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2001ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			return getMitigation_2002ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2003ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2004ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2005ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2001IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			return getMitigation_2002IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2003IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2004IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2005IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2001OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			return getMitigation_2002OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2003OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2004OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2005OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_66ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2001ContainedLinks(View view) {
		HazardCause modelElement = (HazardCause) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_HazardCause_Hazards_4016(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMitigation_2002ContainedLinks(View view) {
		Mitigation modelElement = (Mitigation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_Hazards_4013(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_Causes_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2004ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4012(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_Hazards_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_4003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_4015(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_Mitigations_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2001IncomingLinks(View view) {
		HazardCause modelElement = (HazardCause) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Mitigation_Causes_4014(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMitigation_2002IncomingLinks(View view) {
		Mitigation modelElement = (Mitigation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_FunctionalRequirement_Mitigations_4008(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2003IncomingLinks(View view) {
		Hazard modelElement = (Hazard) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Mitigation_Hazards_4013(
						modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Actor_Hazards_4010(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_HazardCause_Hazards_4016(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_4012(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_UseCase_IncludedUseCases_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_UseCase_ExtendedUseCases_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006IncomingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_4015(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2001OutgoingLinks(View view) {
		HazardCause modelElement = (HazardCause) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_HazardCause_Hazards_4016(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMitigation_2002OutgoingLinks(View view) {
		Mitigation modelElement = (Mitigation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_Hazards_4013(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Mitigation_Causes_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2004OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4012(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_Hazards_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_4003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_2006OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_4015(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_Mitigations_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_ParticipatedUseCases()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001,
								org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_4012(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_InitiatedUseCases()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4012,
								org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_UseCase_IncludedUseCases_4003(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getUseCase_IncludedUseCases()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003,
								org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_UseCase_ExtendedUseCases_4004(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getUseCase_ExtendedUseCases()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004,
								org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Mitigation_Hazards_4013(
			Hazard target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == HazardPackage.eINSTANCE
					.getMitigation_Hazards()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationHazards_4013,
								org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Mitigation_Causes_4014(
			HazardCause target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == HazardPackage.eINSTANCE
					.getMitigation_Causes()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014,
								org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_4015(
			FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getFunctionalRequirement_RefinedRequirement()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefinedRequirement_4015,
								org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_FunctionalRequirement_Mitigations_4008(
			Mitigation target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getFunctionalRequirement_Mitigations()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008,
								org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_Hazards_4010(
			Hazard target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_Hazards()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010,
								org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_HazardCause_Hazards_4016(
			Hazard target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == HazardPackage.eINSTANCE
					.getHazardCause_Hazards()) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016,
								org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getParticipatedUseCases()
				.iterator(); destinations.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001,
							org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4012(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getInitiatedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4012,
							org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_4003(
			UseCase source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getIncludedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003,
							org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_4004(
			UseCase source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getExtendedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004,
							org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Mitigation_Hazards_4013(
			Mitigation source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getHazards().iterator(); destinations
				.hasNext();) {
			Hazard destination = (Hazard) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationHazards_4013,
							org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Mitigation_Causes_4014(
			Mitigation source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getCauses().iterator(); destinations
				.hasNext();) {
			HazardCause destination = (HazardCause) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014,
							org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_4015(
			FunctionalRequirement source) {
		Collection result = new LinkedList();
		FunctionalRequirement destination = source.getRefinedRequirement();
		if (destination == null) {
			return result;
		}
		result
				.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
						source,
						destination,
						org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefinedRequirement_4015,
						org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_FunctionalRequirement_Mitigations_4008(
			FunctionalRequirement source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getMitigations().iterator(); destinations
				.hasNext();) {
			Mitigation destination = (Mitigation) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008,
							org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_Hazards_4010(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getHazards().iterator(); destinations
				.hasNext();) {
			Hazard destination = (Hazard) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010,
							org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_HazardCause_Hazards_4016(
			HazardCause source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getHazards().iterator(); destinations
				.hasNext();) {
			Hazard destination = (Hazard) destinations.next();
			result
					.add(new org.unicase.ui.urmlDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016,
							org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID));
		}
		return result;
	}

}
