package org.unicase.model.urml.ui.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;

import urml.goal.GoalPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UrmlVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.urml.ui.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (URMLDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return URMLDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UrmlDiagramEditorPlugin.getInstance().logError(
					"Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UrmlPackage.eINSTANCE.getURMLDiagram().isSuperTypeOf(domainElement.eClass())
			&& isDiagram((URMLDiagram) domainElement)) {
			return URMLDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getModelID(containerView);
		if (!URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = URMLDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case URMLDiagramEditPart.VISUAL_ID:
			if (UrmlPackage.eINSTANCE.getStakeholder().isSuperTypeOf(domainElement.eClass())) {
				return StakeholderEditPart.VISUAL_ID;
			}
			if (GoalPackage.eINSTANCE.getGoal().isSuperTypeOf(domainElement.eClass())) {
				return GoalEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getModelID(containerView);
		if (!URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (URMLDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = URMLDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case URMLDiagramEditPart.VISUAL_ID:
			if (StakeholderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UrmlPackage.eINSTANCE.getStakeholder().isSuperTypeOf(domainElement.eClass())) {
			return Stakeholder2EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(URMLDiagram element) {
		return true;
	}

}
