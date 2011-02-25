/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.requirement.RequirementPackage;

/**
 * @generated
 */
public class ModelElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private ModelElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType MEDiagram_77 = getElementType("org.unicase.ui.diagram.usecaseDiagram.MEDiagram_77"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_2001 = getElementType("org.unicase.ui.diagram.usecaseDiagram.Actor_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCase_2002 = getElementType("org.unicase.ui.diagram.usecaseDiagram.UseCase_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorParticipatedUseCases_4001 = getElementType("org.unicase.ui.diagram.usecaseDiagram.ActorParticipatedUseCases_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorInitiatedUseCases_4002 = getElementType("org.unicase.ui.diagram.usecaseDiagram.ActorInitiatedUseCases_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCaseIncludedUseCases_4003 = getElementType("org.unicase.ui.diagram.usecaseDiagram.UseCaseIncludedUseCases_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCaseExtendedUseCases_4004 = getElementType("org.unicase.ui.diagram.usecaseDiagram.UseCaseExtendedUseCases_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(MEDiagram_77, DiagramPackage.eINSTANCE.getMEDiagram());

			elements.put(Actor_2001, RequirementPackage.eINSTANCE.getActor());

			elements.put(UseCase_2002, RequirementPackage.eINSTANCE
					.getUseCase());

			elements.put(ActorParticipatedUseCases_4001,
					RequirementPackage.eINSTANCE
							.getActor_ParticipatedUseCases());

			elements.put(ActorInitiatedUseCases_4002,
					RequirementPackage.eINSTANCE.getActor_InitiatedUseCases());

			elements.put(UseCaseIncludedUseCases_4003,
					RequirementPackage.eINSTANCE.getUseCase_IncludedUseCases());

			elements.put(UseCaseExtendedUseCases_4004,
					RequirementPackage.eINSTANCE.getUseCase_ExtendedUseCases());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(MEDiagram_77);
			KNOWN_ELEMENT_TYPES.add(Actor_2001);
			KNOWN_ELEMENT_TYPES.add(UseCase_2002);
			KNOWN_ELEMENT_TYPES.add(ActorParticipatedUseCases_4001);
			KNOWN_ELEMENT_TYPES.add(ActorInitiatedUseCases_4002);
			KNOWN_ELEMENT_TYPES.add(UseCaseIncludedUseCases_4003);
			KNOWN_ELEMENT_TYPES.add(UseCaseExtendedUseCases_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return MEDiagram_77;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return Actor_2001;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return UseCase_2002;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return ActorParticipatedUseCases_4001;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return ActorInitiatedUseCases_4002;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return UseCaseIncludedUseCases_4003;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return UseCaseExtendedUseCases_4004;
		}
		return null;
	}

}
