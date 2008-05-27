package org.unicase.model.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement2EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementEditPart;

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
			return getMEDiagram_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator
				.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (ModelVisualIDRegistry.getNodeVisualID(view, childElement) == FunctionalRequirement2EditPart.VISUAL_ID) {
				result.add(new ModelNodeDescriptor(childElement,
						FunctionalRequirement2EditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getMEDiagram_79ContainedLinks(view);
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getClass_1001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getClass_1001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case FunctionalRequirement2EditPart.VISUAL_ID:
			return getClass_1001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_79ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_1001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
