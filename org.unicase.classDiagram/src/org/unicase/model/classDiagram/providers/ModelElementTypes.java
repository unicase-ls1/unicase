package org.unicase.model.classDiagram.providers;

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
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.diagram.DiagramPackage;

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
	public static final IElementType MEDiagram_88 = getElementType("org.unicase.classDiagram.MEDiagram_88"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Class_1001 = getElementType("org.unicase.classDiagram.Class_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Attribute_2001 = getElementType("org.unicase.classDiagram.Attribute_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Method_2002 = getElementType("org.unicase.classDiagram.Method_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3001 = getElementType("org.unicase.classDiagram.Association_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3002 = getElementType("org.unicase.classDiagram.Association_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ClassSubClasses_3005 = getElementType("org.unicase.classDiagram.ClassSubClasses_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3004 = getElementType("org.unicase.classDiagram.Association_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Association_3003 = getElementType("org.unicase.classDiagram.Association_3003"); //$NON-NLS-1$

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
				return org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
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

			elements.put(MEDiagram_88, DiagramPackage.eINSTANCE.getMEDiagram());

			elements.put(Class_1001, ClassesPackage.eINSTANCE.getClass_());

			elements.put(Attribute_2001, ClassesPackage.eINSTANCE
					.getAttribute());

			elements.put(Method_2002, ClassesPackage.eINSTANCE.getMethod());

			elements.put(Association_3001, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_3002, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_3003, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_3004, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(ClassSubClasses_3005, ClassesPackage.eINSTANCE
					.getClass_SubClasses());
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
			KNOWN_ELEMENT_TYPES.add(MEDiagram_88);
			KNOWN_ELEMENT_TYPES.add(Class_1001);
			KNOWN_ELEMENT_TYPES.add(Attribute_2001);
			KNOWN_ELEMENT_TYPES.add(Method_2002);
			KNOWN_ELEMENT_TYPES.add(Association_3001);
			KNOWN_ELEMENT_TYPES.add(Association_3002);
			KNOWN_ELEMENT_TYPES.add(Association_3003);
			KNOWN_ELEMENT_TYPES.add(Association_3004);
			KNOWN_ELEMENT_TYPES.add(ClassSubClasses_3005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
