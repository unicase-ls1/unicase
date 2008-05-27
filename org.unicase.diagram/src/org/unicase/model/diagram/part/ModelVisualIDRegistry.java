package org.unicase.model.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement2EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirement3EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementName2EditPart;
import org.unicase.model.diagram.edit.parts.FunctionalRequirementNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FunctionalRequirementEditPart.MODEL_ID.equals(view.getType())) {
				return FunctionalRequirementEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.diagram.part.ModelVisualIDRegistry
				.getVisualID(view.getType());
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				ModelDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
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
		if (ModelPackage.eINSTANCE.getFunctionalRequirement().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((FunctionalRequirement) domainElement)) {
			return FunctionalRequirementEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.model.diagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!FunctionalRequirementEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (FunctionalRequirementEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.diagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FunctionalRequirementEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case FunctionalRequirementEditPart.VISUAL_ID:
			if (ModelPackage.eINSTANCE.getFunctionalRequirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return FunctionalRequirement2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.diagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!FunctionalRequirementEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (FunctionalRequirementEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.diagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FunctionalRequirementEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case FunctionalRequirement2EditPart.VISUAL_ID:
			if (FunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionalRequirementEditPart.VISUAL_ID:
			if (FunctionalRequirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionalRequirement3EditPart.VISUAL_ID:
			if (FunctionalRequirementName2EditPart.VISUAL_ID == nodeVisualID) {
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
		if (ModelPackage.eINSTANCE.getFunctionalRequirement().isSuperTypeOf(
				domainElement.eClass())) {
			return FunctionalRequirement3EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(FunctionalRequirement element) {
		return true;
	}

}
