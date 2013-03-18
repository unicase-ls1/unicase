/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.uiModeling.diagram.UiModelingDiagramUtil;

/**
 * @generated
 */
public class UiModelingElementTypes {

	/**
	 * @generated
	 */
	private UiModelingElementTypes() {
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
	public static final IElementType Panel_45 = getElementType("org.unicase.uiModeling.diagram.Panel_45"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Window_2003 = getElementType("org.unicase.uiModeling.diagram.Window_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Label_2004 = getElementType("org.unicase.uiModeling.diagram.Label_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TextField_2005 = getElementType("org.unicase.uiModeling.diagram.TextField_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Button_2006 = getElementType("org.unicase.uiModeling.diagram.Button_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Text_2007 = getElementType("org.unicase.uiModeling.diagram.Text_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Image_2008 = getElementType("org.unicase.uiModeling.diagram.Image_2008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RadioGroup_2009 = getElementType("org.unicase.uiModeling.diagram.RadioGroup_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CheckboxGroup_2010 = getElementType("org.unicase.uiModeling.diagram.CheckboxGroup_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DropdownList_2011 = getElementType("org.unicase.uiModeling.diagram.DropdownList_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ImageButton_2012 = getElementType("org.unicase.uiModeling.diagram.ImageButton_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Button_3001 = getElementType("org.unicase.uiModeling.diagram.Button_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Image_3002 = getElementType("org.unicase.uiModeling.diagram.Image_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Label_3003 = getElementType("org.unicase.uiModeling.diagram.Label_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Text_3004 = getElementType("org.unicase.uiModeling.diagram.Text_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TextField_3005 = getElementType("org.unicase.uiModeling.diagram.TextField_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RadioGroup_3009 = getElementType("org.unicase.uiModeling.diagram.RadioGroup_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RadioButton_3006 = getElementType("org.unicase.uiModeling.diagram.RadioButton_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CheckboxGroup_3010 = getElementType("org.unicase.uiModeling.diagram.CheckboxGroup_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Checkbox_3007 = getElementType("org.unicase.uiModeling.diagram.Checkbox_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DropdownList_3011 = getElementType("org.unicase.uiModeling.diagram.DropdownList_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DropdownItem_3008 = getElementType("org.unicase.uiModeling.diagram.DropdownItem_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ImageButton_3012 = getElementType("org.unicase.uiModeling.diagram.ImageButton_3012"); //$NON-NLS-1$

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
				return org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance()
					.getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated NOT: use {@link EObject}s instead of {@link ENamedElement}s to support custom images for radio buttons
	 *            and checkboxes
	 */
	private static ImageDescriptor getProvidedImageDescriptor(EObject element) {
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
				return org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance()
					.getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		return org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().getItemImageDescriptor(
			element);
	}

	/**
	 * @generated NOT: customized keys for radio buttons and checkboxes
	 */
	private static String getImageRegistryKey(EObject element) {
		return UiModelingDiagramUtil.getImageKey(element);
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
	 * @generated NOT: use {@link EObject}s instead of {@link ENamedElement}s to support custom images for radio buttons
	 *            and checkboxes
	 */
	public static Image getImage(EObject parserElement) {
		String key = getImageRegistryKey(parserElement);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(parserElement);
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

			elements.put(Panel_45, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getPanel());

			elements.put(Window_2003, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getWindow());

			elements.put(Label_2004, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getLabel());

			elements.put(TextField_2005, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getTextField());

			elements.put(Button_2006, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getButton());

			elements.put(Text_2007, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getText());

			elements.put(Image_2008, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImage());

			elements.put(RadioGroup_2009, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioGroup());

			elements.put(CheckboxGroup_2010, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckboxGroup());

			elements.put(DropdownList_2011, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownList());

			elements.put(ImageButton_2012, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImageButton());

			elements.put(Button_3001, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getButton());

			elements.put(Image_3002, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImage());

			elements.put(Label_3003, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getLabel());

			elements.put(Text_3004, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getText());

			elements.put(TextField_3005, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getTextField());

			elements.put(RadioGroup_3009, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioGroup());

			elements.put(RadioButton_3006, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getRadioButton());

			elements.put(CheckboxGroup_3010, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckboxGroup());

			elements.put(Checkbox_3007, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getCheckbox());

			elements.put(DropdownList_3011, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownList());

			elements.put(DropdownItem_3008, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getDropdownItem());

			elements.put(ImageButton_3012, org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getImageButton());
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
			KNOWN_ELEMENT_TYPES.add(Panel_45);
			KNOWN_ELEMENT_TYPES.add(Window_2003);
			KNOWN_ELEMENT_TYPES.add(Label_2004);
			KNOWN_ELEMENT_TYPES.add(TextField_2005);
			KNOWN_ELEMENT_TYPES.add(Button_2006);
			KNOWN_ELEMENT_TYPES.add(Text_2007);
			KNOWN_ELEMENT_TYPES.add(Image_2008);
			KNOWN_ELEMENT_TYPES.add(RadioGroup_2009);
			KNOWN_ELEMENT_TYPES.add(CheckboxGroup_2010);
			KNOWN_ELEMENT_TYPES.add(DropdownList_2011);
			KNOWN_ELEMENT_TYPES.add(ImageButton_2012);
			KNOWN_ELEMENT_TYPES.add(Button_3001);
			KNOWN_ELEMENT_TYPES.add(Image_3002);
			KNOWN_ELEMENT_TYPES.add(Label_3003);
			KNOWN_ELEMENT_TYPES.add(Text_3004);
			KNOWN_ELEMENT_TYPES.add(TextField_3005);
			KNOWN_ELEMENT_TYPES.add(RadioGroup_3009);
			KNOWN_ELEMENT_TYPES.add(RadioButton_3006);
			KNOWN_ELEMENT_TYPES.add(CheckboxGroup_3010);
			KNOWN_ELEMENT_TYPES.add(Checkbox_3007);
			KNOWN_ELEMENT_TYPES.add(DropdownList_3011);
			KNOWN_ELEMENT_TYPES.add(DropdownItem_3008);
			KNOWN_ELEMENT_TYPES.add(ImageButton_3012);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return Panel_45;
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return Window_2003;
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return Label_2004;
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return TextField_2005;
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return Button_2006;
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return Text_2007;
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return Image_2008;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return RadioGroup_2009;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return CheckboxGroup_2010;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return DropdownList_2011;
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return ImageButton_2012;
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return Button_3001;
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return Image_3002;
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return Label_3003;
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return Text_3004;
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return TextField_3005;
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
			return RadioGroup_3009;
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return RadioButton_3006;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
			return CheckboxGroup_3010;
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return Checkbox_3007;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
			return DropdownList_3011;
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return DropdownItem_3008;
		case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
			return ImageButton_3012;
		}
		return null;
	}

}
