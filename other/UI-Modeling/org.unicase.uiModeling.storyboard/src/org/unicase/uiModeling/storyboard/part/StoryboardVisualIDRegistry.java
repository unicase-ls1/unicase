/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.storyboard.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node,
 * ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class StoryboardVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.uiModeling.storyboard/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID.equals(view.getType())) {
				return org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view.getType());
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
				org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance().logError(
					"Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getStoryboard().isSuperTypeOf(domainElement.eClass())
			&& isDiagram((org.unicase.uiModeling.Storyboard) domainElement)) {
			return org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry
			.getModelID(containerView);
		if (!org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry
				.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.UiModelingPackage.eINSTANCE.getPanel().isSuperTypeOf(domainElement.eClass())) {
				return org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry
			.getModelID(containerView);
		if (!org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry
				.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID:
			if (org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(org.unicase.uiModeling.Storyboard element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID:
			return false;
		case org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.checkNodeVisualID(containerView,
				domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
