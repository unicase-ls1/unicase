package org.unicase.model.diagram.part;

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
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement2EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement3EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart;
import org.unicase.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRefiningRequirements().iterator(); it
				.hasNext();) {
			FunctionalRequirement childElement = (FunctionalRequirement) it
					.next();
			int visualID = ModelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FunctionalRequirement2EditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_79ContainedLinks(view);
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getFunctionalRequirement_1001ContainedLinks(view);
		case FunctionalRequirement3EditPart.VISUAL_ID:
			return getFunctionalRequirement_3001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getFunctionalRequirement_1001IncomingLinks(view);
		case FunctionalRequirement3EditPart.VISUAL_ID:
			return getFunctionalRequirement_3001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getFunctionalRequirement_1001OutgoingLinks(view);
		case FunctionalRequirement3EditPart.VISUAL_ID:
			return getFunctionalRequirement_3001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_79ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionalRequirement_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_1001ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionalRequirement_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_3001ContainedLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionalRequirement_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_1001IncomingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_FunctionalRequirement_3001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_3001IncomingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_FunctionalRequirement_3001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_1001OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionalRequirement_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunctionalRequirement_3001OutgoingLinks(View view) {
		FunctionalRequirement modelElement = (FunctionalRequirement) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionalRequirement_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FunctionalRequirement_3001(
			FunctionalRequirement container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRefiningRequirements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FunctionalRequirement) {
				continue;
			}
			FunctionalRequirement link = (FunctionalRequirement) linkObject;
			if (FunctionalRequirement3EditPart.VISUAL_ID != ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FunctionalRequirement dst = link.getRefinedRequirement();
			result.add(new ModelLinkDescriptor(container, dst, link,
					ModelElementTypes.FunctionalRequirement_3001,
					FunctionalRequirement3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FunctionalRequirement_3001(
			FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ModelPackage.eINSTANCE
					.getFunctionalRequirement_RefinedRequirement()
					|| false == setting.getEObject() instanceof FunctionalRequirement) {
				continue;
			}
			FunctionalRequirement link = (FunctionalRequirement) setting
					.getEObject();
			if (FunctionalRequirement3EditPart.VISUAL_ID != ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof FunctionalRequirement) {
				continue;
			}
			FunctionalRequirement container = (FunctionalRequirement) link
					.eContainer();
			result.add(new ModelLinkDescriptor(container, target, link,
					ModelElementTypes.FunctionalRequirement_3001,
					FunctionalRequirement3EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(
			FunctionalRequirement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ModelPackage.eINSTANCE
					.getFunctionalRequirement_RefinedRequirement()) {
				result
						.add(new ModelLinkDescriptor(
								setting.getEObject(),
								target,
								ModelElementTypes.FunctionalRequirementRefinedRequirement_3002,
								FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_FunctionalRequirement_RefinedRequirement_3002(
			FunctionalRequirement source) {
		Collection result = new LinkedList();
		FunctionalRequirement destination = source.getRefinedRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ModelLinkDescriptor(source, destination,
				ModelElementTypes.FunctionalRequirementRefinedRequirement_3002,
				FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID));
		return result;
	}

}
