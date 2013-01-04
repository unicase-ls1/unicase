package org.unicase.wireframe.diagram.providers;

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
import org.unicase.wireframe.WireframePackage;
import org.unicase.wireframe.diagram.edit.parts.ButtonEditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelEditPart;
import org.unicase.wireframe.diagram.edit.parts.PanelEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowEditPart;
import org.unicase.wireframe.diagram.part.WireframeDiagramEditorPlugin;

/**
 * @generated
 */
public class WireframeElementTypes {

	/**
	 * @generated
	 */
	private WireframeElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Panel_1000 = getElementType("org.unicase.wireframe.diagram.Panel_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Window_2003 = getElementType("org.unicase.wireframe.diagram.Window_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Label_2004 = getElementType("org.unicase.wireframe.diagram.Label_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TextField_2005 = getElementType("org.unicase.wireframe.diagram.TextField_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Button_2006 = getElementType("org.unicase.wireframe.diagram.Button_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Text_2007 = getElementType("org.unicase.wireframe.diagram.Text_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Image_2008 = getElementType("org.unicase.wireframe.diagram.Image_2008"); //$NON-NLS-1$

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
				return WireframeDiagramEditorPlugin.getInstance().getItemImageDescriptor(
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
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Panel_1000, WireframePackage.eINSTANCE.getPanel());

			elements.put(Window_2003, WireframePackage.eINSTANCE.getWindow());

			elements.put(Label_2004, WireframePackage.eINSTANCE.getLabel());

			elements.put(TextField_2005, WireframePackage.eINSTANCE.getTextField());

			elements.put(Button_2006, WireframePackage.eINSTANCE.getButton());

			elements.put(Text_2007, WireframePackage.eINSTANCE.getText());

			elements.put(Image_2008, WireframePackage.eINSTANCE.getImage());
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
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Panel_1000);
			KNOWN_ELEMENT_TYPES.add(Window_2003);
			KNOWN_ELEMENT_TYPES.add(Label_2004);
			KNOWN_ELEMENT_TYPES.add(TextField_2005);
			KNOWN_ELEMENT_TYPES.add(Button_2006);
			KNOWN_ELEMENT_TYPES.add(Text_2007);
			KNOWN_ELEMENT_TYPES.add(Image_2008);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PanelEditPart.VISUAL_ID:
			return Panel_1000;
		case WindowEditPart.VISUAL_ID:
			return Window_2003;
		case LabelEditPart.VISUAL_ID:
			return Label_2004;
		case TextFieldEditPart.VISUAL_ID:
			return TextField_2005;
		case ButtonEditPart.VISUAL_ID:
			return Button_2006;
		case TextEditPart.VISUAL_ID:
			return Text_2007;
		case ImageEditPart.VISUAL_ID:
			return Image_2008;
		}
		return null;
	}

}
