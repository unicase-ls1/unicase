package org.unicase.model.urml.ui.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;

/**
 * @generated
 */
public class UrmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_69SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_69SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = UrmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == GoalEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_69ContainedLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_69ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
