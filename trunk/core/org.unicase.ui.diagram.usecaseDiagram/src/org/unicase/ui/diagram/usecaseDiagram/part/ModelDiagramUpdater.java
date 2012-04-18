/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.part;

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
import org.unicase.model.diagram.UseCaseDiagram;
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
		switch (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getUseCaseDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCaseDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCaseDiagram modelElement = (UseCaseDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getUseCaseDiagram_1000ContainedLinks(view);
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2001ContainedLinks(view);
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2001IncomingLinks(view);
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2001OutgoingLinks(view);
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCaseDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2001ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2002ContainedLinks(View view) {
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
	public static List getActor_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2002IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_4002(
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
	public static List getActor_2001OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_ParticipatedUseCases_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2002OutgoingLinks(View view) {
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
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001,
								org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Actor_InitiatedUseCases_4002(
			UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == RequirementPackage.eINSTANCE
					.getActor_InitiatedUseCases()) {
				result
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002,
								org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
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
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003,
								org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
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
						.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004,
								org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
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
					.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001,
							org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Actor_InitiatedUseCases_4002(
			Actor source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getInitiatedUseCases().iterator(); destinations
				.hasNext();) {
			UseCase destination = (UseCase) destinations.next();
			result
					.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002,
							org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID));
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
					.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003,
							org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID));
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
					.add(new org.unicase.ui.diagram.usecaseDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004,
							org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID));
		}
		return result;
	}

}
