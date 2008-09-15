package org.unicase.model.classDiagram.part;

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
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Method;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			return getClassClassNode_attributes_5001SemanticChildren(view);
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			return getClassClassNode_methods_5002SemanticChildren(view);
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_88SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassClassNode_attributes_5001SemanticChildren(
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
			int visualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.model.classDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassClassNode_methods_5002SemanticChildren(View view) {
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
			int visualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.model.classDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_88SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.model.classDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_88ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1001ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_2001ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_2002ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			return getAssociation_3001ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3002ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_3004ContainedLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1001IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_2001IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_2002IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			return getAssociation_3001IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3002IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_3004IncomingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1001OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_2001OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_2002OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			return getAssociation_3001OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3002OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_3004OutgoingLinks(view);
		case org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_88ContainedLinks(View view) {
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Association_3001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_3002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Class_SubClasses_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Class_SubClasses_3005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3002(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Class_SubClasses_3005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAttribute_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3001(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001,
							org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3002(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3002,
							org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3004(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3004,
							org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3003(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3003,
							org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3001(
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
			if (org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001,
							org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3002(
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
			if (org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3002,
							org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Class_SubClasses_3005(
			Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ClassesPackage.eINSTANCE
					.getClass_SubClasses()) {
				result
						.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3005,
								org.unicase.model.classDiagram.edit.parts.ClassSubClassesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3004(
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
			if (org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3004,
							org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3003(
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
			if (org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3003,
							org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3001(
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
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001,
							org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3002(
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
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3002,
							org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Class_SubClasses_3005(
			Class source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubClasses().iterator(); destinations
				.hasNext();) {
			Class destination = (Class) destinations.next();
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3005,
							org.unicase.model.classDiagram.edit.parts.ClassSubClassesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3004(
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
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3004,
							org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3003(
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
		for (Iterator links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.model.classDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3003,
							org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

}
