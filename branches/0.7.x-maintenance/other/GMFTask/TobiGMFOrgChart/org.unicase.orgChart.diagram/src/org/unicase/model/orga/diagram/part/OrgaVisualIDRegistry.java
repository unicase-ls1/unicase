package org.unicase.model.orga.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.orga.OrgDiagram;
import org.unicase.model.orga.OrgaPackage;
import org.unicase.model.orga.diagram.edit.parts.EmployeeEditPart;
import org.unicase.model.orga.diagram.edit.parts.EmployeeNameEditPart;
import org.unicase.model.orga.diagram.edit.parts.OrgDiagramEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class OrgaVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.orgChart.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (OrgDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return OrgDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry
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
				OrgaDiagramEditorPlugin.getInstance().logError(
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
		if (OrgaPackage.eINSTANCE.getOrgDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((OrgDiagram) domainElement)) {
			return OrgDiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry
				.getModelID(containerView);
		if (!OrgDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (OrgDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = OrgDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case OrgDiagramEditPart.VISUAL_ID:
			if (OrgaPackage.eINSTANCE.getTeam().isSuperTypeOf(
					domainElement.eClass())) {
				return TeamEditPart.VISUAL_ID;
			}
			if (OrgaPackage.eINSTANCE.getEmployee().isSuperTypeOf(
					domainElement.eClass())) {
				return EmployeeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry
				.getModelID(containerView);
		if (!OrgDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (OrgDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = OrgDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case TeamEditPart.VISUAL_ID:
			if (TeamNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EmployeeEditPart.VISUAL_ID:
			if (EmployeeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OrgDiagramEditPart.VISUAL_ID:
			if (TeamEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EmployeeEditPart.VISUAL_ID == nodeVisualID) {
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
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(OrgDiagram element) {
		return true;
	}

}
