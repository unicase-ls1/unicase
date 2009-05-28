package org.unicase.ui.urmlDiagram.part;

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
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_69SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_69SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.urmlDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_69ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2001ContainedLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2001IncomingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2001OutgoingLinks(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_69ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazard_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHazardCause_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
