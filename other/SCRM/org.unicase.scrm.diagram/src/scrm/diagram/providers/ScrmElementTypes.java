package scrm.diagram.providers;

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

import scrm.ScrmPackage;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodMathematicalModelEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.knowledge.KnowledgePackage;

/**
 * @generated
 */
public class ScrmElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private ScrmElementTypes() {
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
	public static final IElementType SCRMDiagram_1000 = getElementType("org.unicase.scrm.diagram.SCRMDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModel_2001 = getElementType("org.unicase.scrm.diagram.MathematicalModel_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethod_2002 = getElementType("org.unicase.scrm.diagram.NumericalMethod_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodMathematicalModel_4003 = getElementType("org.unicase.scrm.diagram.NumericalMethodMathematicalModel_4003"); //$NON-NLS-1$

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
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return ScrmDiagramEditorPlugin.getInstance().getItemImageDescriptor(
					eClass.getEPackage().getEFactoryInstance().create(eClass));
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

			elements.put(SCRMDiagram_1000, ScrmPackage.eINSTANCE.getSCRMDiagram());

			elements.put(MathematicalModel_2001, KnowledgePackage.eINSTANCE.getMathematicalModel());

			elements.put(NumericalMethod_2002, KnowledgePackage.eINSTANCE.getNumericalMethod());

			elements.put(NumericalMethodMathematicalModel_4003, KnowledgePackage.eINSTANCE
				.getNumericalMethod_MathematicalModel());
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
			KNOWN_ELEMENT_TYPES.add(SCRMDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(MathematicalModel_2001);
			KNOWN_ELEMENT_TYPES.add(NumericalMethod_2002);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodMathematicalModel_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return SCRMDiagram_1000;
		case MathematicalModelEditPart.VISUAL_ID:
			return MathematicalModel_2001;
		case NumericalMethodEditPart.VISUAL_ID:
			return NumericalMethod_2002;
		case NumericalMethodMathematicalModelEditPart.VISUAL_ID:
			return NumericalMethodMathematicalModel_4003;
		}
		return null;
	}

}
