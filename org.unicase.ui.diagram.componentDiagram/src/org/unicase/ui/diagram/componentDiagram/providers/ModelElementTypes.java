/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.providers;

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
import org.unicase.model.component.ComponentPackage;
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
	public static final IElementType ComponentDiagram_88 = getElementType("org.unicase.ui.diagram.componentDiagram.ComponentDiagram_88"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComponentService_2001 = getElementType("org.unicase.ui.diagram.componentDiagram.ComponentService_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Component_2002 = getElementType("org.unicase.ui.diagram.componentDiagram.Component_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComponentOfferedServices_4001 = getElementType("org.unicase.ui.diagram.componentDiagram.ComponentOfferedServices_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComponentConsumedServices_4002 = getElementType("org.unicase.ui.diagram.componentDiagram.ComponentConsumedServices_4002"); //$NON-NLS-1$

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
				return org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
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

			elements.put(ComponentDiagram_88, DiagramPackage.eINSTANCE
					.getComponentDiagram());

			elements.put(ComponentService_2001, ComponentPackage.eINSTANCE
					.getComponentService());

			elements.put(Component_2002, ComponentPackage.eINSTANCE
					.getComponent());

			elements.put(ComponentOfferedServices_4001,
					ComponentPackage.eINSTANCE.getComponent_OfferedServices());

			elements.put(ComponentConsumedServices_4002,
					ComponentPackage.eINSTANCE.getComponent_ConsumedServices());
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
			KNOWN_ELEMENT_TYPES.add(ComponentDiagram_88);
			KNOWN_ELEMENT_TYPES.add(ComponentService_2001);
			KNOWN_ELEMENT_TYPES.add(Component_2002);
			KNOWN_ELEMENT_TYPES.add(ComponentOfferedServices_4001);
			KNOWN_ELEMENT_TYPES.add(ComponentConsumedServices_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return ComponentDiagram_88;
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID:
			return ComponentService_2001;
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return Component_2002;
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return ComponentOfferedServices_4001;
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return ComponentConsumedServices_4002;
		}
		return null;
	}

}
