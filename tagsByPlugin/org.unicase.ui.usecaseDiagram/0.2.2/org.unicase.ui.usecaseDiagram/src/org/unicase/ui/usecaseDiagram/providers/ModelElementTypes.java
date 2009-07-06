package org.unicase.ui.usecaseDiagram.providers;

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
	public static final IElementType MEDiagram_77 = getElementType("org.unicase.ui.usecaseDiagram.MEDiagram_77"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_1001 = getElementType("org.unicase.ui.usecaseDiagram.Actor_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCase_1002 = getElementType("org.unicase.ui.usecaseDiagram.UseCase_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorParticipatedUseCases_3001 = getElementType("org.unicase.ui.usecaseDiagram.ActorParticipatedUseCases_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorInitiatedUseCases_3002 = getElementType("org.unicase.ui.usecaseDiagram.ActorInitiatedUseCases_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCaseIncludedUseCases_3003 = getElementType("org.unicase.ui.usecaseDiagram.UseCaseIncludedUseCases_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCaseExtendedUseCases_3004 = getElementType("org.unicase.ui.usecaseDiagram.UseCaseExtendedUseCases_3004"); //$NON-NLS-1$

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
				return org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin
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

			elements.put(Actor_1001, RequirementPackage.eINSTANCE.getActor());

			elements.put(UseCase_1002, RequirementPackage.eINSTANCE
					.getUseCase());

			elements.put(ActorParticipatedUseCases_3001,
					RequirementPackage.eINSTANCE
							.getActor_ParticipatedUseCases());

			elements.put(ActorInitiatedUseCases_3002,
					RequirementPackage.eINSTANCE.getActor_InitiatedUseCases());

			elements.put(UseCaseIncludedUseCases_3003,
					RequirementPackage.eINSTANCE.getUseCase_IncludedUseCases());

			elements.put(UseCaseExtendedUseCases_3004,
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
			KNOWN_ELEMENT_TYPES.add(Actor_1001);
			KNOWN_ELEMENT_TYPES.add(UseCase_1002);
			KNOWN_ELEMENT_TYPES.add(ActorParticipatedUseCases_3001);
			KNOWN_ELEMENT_TYPES.add(ActorInitiatedUseCases_3002);
			KNOWN_ELEMENT_TYPES.add(UseCaseIncludedUseCases_3003);
			KNOWN_ELEMENT_TYPES.add(UseCaseExtendedUseCases_3004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
