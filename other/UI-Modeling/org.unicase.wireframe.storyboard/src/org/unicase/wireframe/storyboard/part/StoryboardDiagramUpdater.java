/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.storyboard.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.unicase.model.UnicaseModelElement;
import org.unicase.wireframe.Storyboard;
import org.unicase.wireframe.storyboard.edit.parts.PanelEditPart;
import org.unicase.wireframe.storyboard.edit.parts.StoryboardEditPart;

/**
 * @generated
 */
public class StoryboardDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<StoryboardNodeDescriptor> getSemanticChildren(View view) {
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case StoryboardEditPart.VISUAL_ID:
			return getStoryboard_44SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardNodeDescriptor> getStoryboard_44SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Storyboard modelElement = (Storyboard) view.getElement();
		LinkedList<StoryboardNodeDescriptor> result = new LinkedList<StoryboardNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = StoryboardVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PanelEditPart.VISUAL_ID) {
				result.add(new StoryboardNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getContainedLinks(View view) {
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case StoryboardEditPart.VISUAL_ID:
			return getStoryboard_44ContainedLinks(view);
		case PanelEditPart.VISUAL_ID:
			return getPanel_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getIncomingLinks(View view) {
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getPanel_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getOutgoingLinks(View view) {
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getPanel_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getStoryboard_44ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getPanel_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getPanel_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StoryboardLinkDescriptor> getPanel_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<StoryboardNodeDescriptor> getSemanticChildren(View view) {
			return StoryboardDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<StoryboardLinkDescriptor> getContainedLinks(View view) {
			return StoryboardDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<StoryboardLinkDescriptor> getIncomingLinks(View view) {
			return StoryboardDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<StoryboardLinkDescriptor> getOutgoingLinks(View view) {
			return StoryboardDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
