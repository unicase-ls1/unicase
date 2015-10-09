/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.providers;

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
	public static final IElementType ClassDiagram_99 = getElementType("org.unicase.ui.diagram.classDiagram.ClassDiagram_99"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2001 = getElementType("org.unicase.ui.diagram.classDiagram.Class_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Package_2002 = getElementType("org.unicase.ui.diagram.classDiagram.Package_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Attribute_3001 = getElementType("org.unicase.ui.diagram.classDiagram.Attribute_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Method_3002 = getElementType("org.unicase.ui.diagram.classDiagram.Method_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4001 = getElementType("org.unicase.ui.diagram.classDiagram.Association_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4002 = getElementType("org.unicase.ui.diagram.classDiagram.Association_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4003 = getElementType("org.unicase.ui.diagram.classDiagram.Association_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4004 = getElementType("org.unicase.ui.diagram.classDiagram.Association_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassSuperClasses_4007 = getElementType("org.unicase.ui.diagram.classDiagram.ClassSuperClasses_4007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Dependency_4006 = getElementType("org.unicase.ui.diagram.classDiagram.Dependency_4006"); //$NON-NLS-1$

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
				return org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
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

			elements.put(ClassDiagram_99, DiagramPackage.eINSTANCE
					.getClassDiagram());

			elements.put(Class_2001, ClassesPackage.eINSTANCE.getClass_());

			elements.put(Package_2002, ClassesPackage.eINSTANCE.getPackage());

			elements.put(Attribute_3001, ClassesPackage.eINSTANCE
					.getAttribute());

			elements.put(Method_3002, ClassesPackage.eINSTANCE.getMethod());

			elements.put(Association_4001, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_4002, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_4003, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(Association_4004, ClassesPackage.eINSTANCE
					.getAssociation());

			elements.put(ClassSuperClasses_4007, ClassesPackage.eINSTANCE
					.getClass_SuperClasses());

			elements.put(Dependency_4006, ClassesPackage.eINSTANCE
					.getDependency());
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
			KNOWN_ELEMENT_TYPES.add(ClassDiagram_99);
			KNOWN_ELEMENT_TYPES.add(Class_2001);
			KNOWN_ELEMENT_TYPES.add(Package_2002);
			KNOWN_ELEMENT_TYPES.add(Attribute_3001);
			KNOWN_ELEMENT_TYPES.add(Method_3002);
			KNOWN_ELEMENT_TYPES.add(Association_4001);
			KNOWN_ELEMENT_TYPES.add(Association_4002);
			KNOWN_ELEMENT_TYPES.add(Association_4003);
			KNOWN_ELEMENT_TYPES.add(Association_4004);
			KNOWN_ELEMENT_TYPES.add(ClassSuperClasses_4007);
			KNOWN_ELEMENT_TYPES.add(Dependency_4006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return ClassDiagram_99;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return Class_2001;
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return Package_2002;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return Attribute_3001;
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return Method_3002;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return Association_4001;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return Association_4002;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return Association_4003;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return Association_4004;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return ClassSuperClasses_4007;
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return Dependency_4006;
		}
		return null;
	}

}
