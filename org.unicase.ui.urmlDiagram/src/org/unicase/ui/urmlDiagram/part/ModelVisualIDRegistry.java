package org.unicase.ui.urmlDiagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.requirement.RequirementPackage;

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
	private static final String DEBUG_KEY = "org.unicase.ui.urmlDiagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(view.getType())) {
				return org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
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
				org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.getInstance().logError(
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
		if (DiagramPackage.eINSTANCE.getMEDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((MEDiagram) domainElement)) {
			return org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (HazardPackage.eINSTANCE.getHazardCause().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID;
			}
			if (HazardPackage.eINSTANCE.getMitigation().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID;
			}
			if (HazardPackage.eINSTANCE.getHazard().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getActor().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getUseCase().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getFunctionalRequirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.HazardCauseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.MitigationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.HazardNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.ParticipateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.ScenarioInstantiatedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.InitiateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.IncludeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.IncludeLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.HazardMitigationsEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.MitigateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseMitigationsEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefiningRequirementsEditPart.VISUAL_ID:
			if (org.unicase.ui.urmlDiagram.edit.parts.RefineLabelEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(MEDiagram element) {
		return true;
	}

}
