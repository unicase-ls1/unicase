package org.unicase.ui.usecaseDiagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
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
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.usecaseDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_79ContainedLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1001ContainedLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1001IncomingLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1001OutgoingLinks(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1002OutgoingLinks(view);
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
	public static List getUseCase_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_1001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_1002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_1001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_1002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
