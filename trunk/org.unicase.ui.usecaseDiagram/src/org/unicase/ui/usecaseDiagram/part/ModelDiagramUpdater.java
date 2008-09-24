package org.unicase.ui.usecaseDiagram.part;

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
import org.unicase.model.requirement.Actor;
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
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_77SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_77SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_77ContainedLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1001ContainedLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1001IncomingLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1001OutgoingLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_77ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_1001ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_1002ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_3003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_3004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_1001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_1002IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_ParticipatedUseCases_3001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_3002(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_UseCase_IncludedUseCases_3003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_UseCase_ExtendedUseCases_3004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_1001OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_1002OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_3003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_3004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_ParticipatedUseCases_3001(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_ParticipatedUseCases()) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001,
								org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_3002(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_InitiatedUseCases()) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002,
								org.unicase.ui.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_UseCase_IncludedUseCases_3003(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getUseCase_IncludedUseCases()) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003,
								org.unicase.ui.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_UseCase_ExtendedUseCases_3004(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getUseCase_ExtendedUseCases()) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004,
								org.unicase.ui.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_3001(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getParticipatedUseCases()
				.iterator(); destinations.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001,
							org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_3002(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getInitiatedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002,
							org.unicase.ui.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_UseCase_IncludedUseCases_3003(
			UseCase source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getIncludedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003,
							org.unicase.ui.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_UseCase_ExtendedUseCases_3004(
			UseCase source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getExtendedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004,
							org.unicase.ui.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

}
