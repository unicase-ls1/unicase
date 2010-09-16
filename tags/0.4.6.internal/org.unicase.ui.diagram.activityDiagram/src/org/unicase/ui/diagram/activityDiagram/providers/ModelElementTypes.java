/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.providers;

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
import org.unicase.model.activity.ActivityPackage;
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
	public static final IElementType ActivityDiagram_1000 = getElementType("org.unicase.ui.diagram.activityDiagram.ActivityDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Activity_2002 = getElementType("org.unicase.ui.diagram.activityDiagram.Activity_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Fork_2003 = getElementType("org.unicase.ui.diagram.activityDiagram.Fork_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActivityInitial_2004 = getElementType("org.unicase.ui.diagram.activityDiagram.ActivityInitial_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActivityEnd_2005 = getElementType("org.unicase.ui.diagram.activityDiagram.ActivityEnd_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Branch_2006 = getElementType("org.unicase.ui.diagram.activityDiagram.Branch_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("org.unicase.ui.diagram.activityDiagram.Transition_4001"); //$NON-NLS-1$

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
				return org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin
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

			elements.put(ActivityDiagram_1000, DiagramPackage.eINSTANCE
					.getActivityDiagram());

			elements
					.put(Activity_2002, ActivityPackage.eINSTANCE.getActivity());

			elements.put(Fork_2003, ActivityPackage.eINSTANCE.getFork());

			elements.put(ActivityInitial_2004, ActivityPackage.eINSTANCE
					.getActivityInitial());

			elements.put(ActivityEnd_2005, ActivityPackage.eINSTANCE
					.getActivityEnd());

			elements.put(Branch_2006, ActivityPackage.eINSTANCE.getBranch());

			elements.put(Transition_4001, ActivityPackage.eINSTANCE
					.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(ActivityDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Activity_2002);
			KNOWN_ELEMENT_TYPES.add(Fork_2003);
			KNOWN_ELEMENT_TYPES.add(ActivityInitial_2004);
			KNOWN_ELEMENT_TYPES.add(ActivityEnd_2005);
			KNOWN_ELEMENT_TYPES.add(Branch_2006);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return ActivityDiagram_1000;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return Activity_2002;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return Fork_2003;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return ActivityInitial_2004;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return ActivityEnd_2005;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return Branch_2006;
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		}
		return null;
	}

}
