/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.UseCaseDiagram;
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
	private static final String DEBUG_KEY = "org.unicase.ui.diagram.usecaseDiagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(view.getType())) {
				return org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
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
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
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
		if (DiagramPackage.eINSTANCE.getUseCaseDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((UseCaseDiagram) domainElement)) {
			return org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (RequirementPackage.eINSTANCE.getActor().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID;
			}
			if (RequirementPackage.eINSTANCE.getUseCase().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.ParticipateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.InitiateLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.IncludeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			if (org.unicase.ui.diagram.usecaseDiagram.edit.parts.ExtendLabelEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(UseCaseDiagram element) {
		return true;
	}

}
