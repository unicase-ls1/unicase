package org.unicase.ui.componentDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentPackage;
import org.unicase.model.component.ComponentService;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_99SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_99SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.componentDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.componentDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_99ContainedLinks(view);
		case org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponentService_1001ContainedLinks(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponentService_1001IncomingLinks(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponentService_1001OutgoingLinks(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_99ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponentService_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1002ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Component_OfferedServices_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Component_ConsumedServices_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentService_1001IncomingLinks(View view) {
		ComponentService modelElement = (ComponentService) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Component_OfferedServices_3001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Component_ConsumedServices_3002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponentService_1001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1002OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Component_OfferedServices_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Component_ConsumedServices_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Component_OfferedServices_3001(
			ComponentService target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ComponentPackage.eINSTANCE
					.getComponent_OfferedServices()) {
				result
						.add(new org.unicase.ui.componentDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_3001,
								org.unicase.ui.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Component_ConsumedServices_3002(
			ComponentService target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ComponentPackage.eINSTANCE
					.getComponent_ConsumedServices()) {
				result
						.add(new org.unicase.ui.componentDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_3002,
								org.unicase.ui.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Component_OfferedServices_3001(
			Component source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getOfferedServices().iterator(); destinations
				.hasNext();) {
			ComponentService destination = (ComponentService) destinations
					.next();
			result
					.add(new org.unicase.ui.componentDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_3001,
							org.unicase.ui.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Component_ConsumedServices_3002(
			Component source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConsumedServices().iterator(); destinations
				.hasNext();) {
			ComponentService destination = (ComponentService) destinations
					.next();
			result
					.add(new org.unicase.ui.componentDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_3002,
							org.unicase.ui.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID));
		}
		return result;
	}

}
