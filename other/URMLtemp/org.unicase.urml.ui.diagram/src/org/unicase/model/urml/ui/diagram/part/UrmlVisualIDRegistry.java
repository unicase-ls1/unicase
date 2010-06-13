package org.unicase.model.urml.ui.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ExpressesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;

import urml.danger.DangerPackage;
import urml.goal.GoalPackage;
import urml.requirement.RequirementPackage;
import urml.service.ServicePackage;
import urml.usecase.UsecasePackage;

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
			if (RequirementPackage.eINSTANCE.getFunctionalRequirement().isSuperTypeOf(domainElement.eClass())) {
				return FunctionalRequirementEditPart.VISUAL_ID;
			}
			if (UrmlPackage.eINSTANCE.getFeature().isSuperTypeOf(domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			if (ServicePackage.eINSTANCE.getService().isSuperTypeOf(domainElement.eClass())) {
				return ServiceEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getNonFunctionalRequirement().isSuperTypeOf(domainElement.eClass())) {
				return NonFunctionalRequirementEditPart.VISUAL_ID;
			}
			if (DangerPackage.eINSTANCE.getDanger().isSuperTypeOf(domainElement.eClass())) {
				return DangerEditPart.VISUAL_ID;
			}
			if (UsecasePackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return ActorEditPart.VISUAL_ID;
			}
			if (DangerPackage.eINSTANCE.getProceduralMitigation().isSuperTypeOf(domainElement.eClass())) {
				return ProceduralMitigationEditPart.VISUAL_ID;
			}
			if (ServicePackage.eINSTANCE.getServiceProvider().isSuperTypeOf(domainElement.eClass())) {
				return ServiceProviderEditPart.VISUAL_ID;
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
		case StakeholderEditPart.VISUAL_ID:
			if (StakeholderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalEditPart.VISUAL_ID:
			if (GoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionalRequirementEditPart.VISUAL_ID:
			if (FunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureEditPart.VISUAL_ID:
			if (FeatureNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServiceEditPart.VISUAL_ID:
			if (ServiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			if (NonFunctionalRequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DangerEditPart.VISUAL_ID:
			if (DangerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorEditPart.VISUAL_ID:
			if (ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProceduralMitigationEditPart.VISUAL_ID:
			if (ProceduralMitigationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServiceProviderEditPart.VISUAL_ID:
			if (ServiceProviderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case URMLDiagramEditPart.VISUAL_ID:
			if (StakeholderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FunctionalRequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FeatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ServiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NonFunctionalRequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DangerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProceduralMitigationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ServiceProviderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StakeholderGoalsEditPart.VISUAL_ID:
			if (ExpressesLabelEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(URMLDiagram element) {
		return true;
	}

}
