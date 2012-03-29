/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.Package;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			return getClassClassNode_attributes_7001SemanticChildren(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			return getClassClassNode_methods_7002SemanticChildren(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassClassNode_attributes_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getAttributes().iterator(); it
				.hasNext();) {
			Attribute childElement = (Attribute) it.next();
			int visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.classDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassClassNode_methods_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMethods().iterator(); it.hasNext();) {
			Method childElement = (Method) it.next();
			int visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.classDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ClassDiagram modelElement = (ClassDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.classDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.classDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_2002ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_3002ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_4002ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_4003ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_4004ContainedLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_2002IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_3002IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_4002IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_4003IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_4004IncomingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_2002OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_3002OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_4002OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_4003OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_4004OutgoingLinks(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassDiagram_1000ContainedLinks(View view) {
		ClassDiagram modelElement = (ClassDiagram) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2001ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Class_SuperClasses_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2001IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Class_SuperClasses_4007(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2002IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2001OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Class_SuperClasses_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2002OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4001(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001,
							org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4002(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4003(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4004(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4006(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageElement dst = link.getTarget();
			PackageElement src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006,
							org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4001(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ClassesPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001,
							org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4002(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ClassesPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4003(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ClassesPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4004(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ClassesPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Class_SuperClasses_4007(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ClassesPackage.eINSTANCE
					.getClass_SuperClasses()) {
				result
						.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007,
								org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4006(
			PackageElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ClassesPackage.eINSTANCE
					.getDependency_Target()
					|| false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageElement src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006,
							org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4001(
			Class source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001,
							org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4002(
			Class source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4003(
			Class source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4004(
			Class source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004,
							org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Class_SuperClasses_4007(
			Class source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSuperClasses().iterator(); destinations
				.hasNext();) {
			Class destination = (Class) destinations.next();
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007,
							org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4006(
			PackageElement source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageElement dst = link.getTarget();
			PackageElement src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006,
							org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

}
