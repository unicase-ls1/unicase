/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.storyboard.navigator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.Storyboard;
import org.unicase.wireframe.storyboard.edit.parts.PanelEditPart;
import org.unicase.wireframe.storyboard.edit.parts.StoryboardEditPart;
import org.unicase.wireframe.storyboard.part.StoryboardDiagramEditorPlugin;
import org.unicase.wireframe.storyboard.part.StoryboardVisualIDRegistry;
import org.unicase.wireframe.storyboard.providers.StoryboardElementTypes;

/**
 * @generated
 */
public class StoryboardNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
	ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StoryboardDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StoryboardDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StoryboardNavigatorItem && !isOwnView(((StoryboardNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StoryboardNavigatorGroup) {
			StoryboardNavigatorGroup group = (StoryboardNavigatorGroup) element;
			return StoryboardDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof StoryboardNavigatorItem) {
			StoryboardNavigatorItem navigatorItem = (StoryboardNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case StoryboardEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/wireframe?Storyboard", StoryboardElementTypes.Storyboard_44); //$NON-NLS-1$
		case PanelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Panel", StoryboardElementTypes.Panel_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StoryboardDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && StoryboardElementTypes.isKnownElementType(elementType)) {
			image = StoryboardElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof StoryboardNavigatorGroup) {
			StoryboardNavigatorGroup group = (StoryboardNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StoryboardNavigatorItem) {
			StoryboardNavigatorItem navigatorItem = (StoryboardNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (StoryboardVisualIDRegistry.getVisualID(view)) {
		case StoryboardEditPart.VISUAL_ID:
			return getStoryboard_44Text(view);
		case PanelEditPart.VISUAL_ID:
			return getPanel_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getStoryboard_44Text(View view) {
		Storyboard domainModelElement = (Storyboard) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StoryboardDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 44); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPanel_2001Text(View view) {
		Panel domainModelElement = (Panel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StoryboardDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return StoryboardEditPart.MODEL_ID.equals(StoryboardVisualIDRegistry.getModelID(view));
	}

}
