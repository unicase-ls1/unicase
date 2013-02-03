/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.storyboard.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.unicase.model.UnicaseModelElement;

/**
 * @generated
 */
public class StoryboardDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor> getSemanticChildren(View view) {
		switch (org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID:
			return getStoryboard_44SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor> getStoryboard_44SemanticChildren(
		View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.Storyboard modelElement = (org.unicase.uiModeling.Storyboard) view.getElement();
		LinkedList<org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getContainedLinks(View view) {
		switch (org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID:
			return getStoryboard_44ContainedLinks(view);
		case org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getIncomingLinks(View view) {
		switch (org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getOutgoingLinks(View view) {
		switch (org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.storyboard.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getStoryboard_44ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getPanel_2001ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getPanel_2001IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getPanel_2001OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.storyboard.part.StoryboardNodeDescriptor> getSemanticChildren(View view) {
			return StoryboardDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getContainedLinks(View view) {
			return StoryboardDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getIncomingLinks(View view) {
			return StoryboardDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.storyboard.part.StoryboardLinkDescriptor> getOutgoingLinks(View view) {
			return StoryboardDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
