/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
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
import org.unicase.model.diagram.ComponentDiagram;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?ComponentDiagram", org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentDiagram_1000); //$NON-NLS-1$
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/component?ComponentService", org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentService_2001); //$NON-NLS-1$
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/component?Component", org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.Component_2002); //$NON-NLS-1$
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/component?Component?offeredServices", org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_4001); //$NON-NLS-1$
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/component?Component?consumedServices", org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes
					.getImage(elementType);
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
		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000Text(view);
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID:
			return getComponentService_2001Text(view);
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_2002Text(view);
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return getComponentOfferedServices_4001Text(view);
		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return getComponentConsumedServices_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getComponentDiagram_1000Text(View view) {
		ComponentDiagram domainModelElement = (ComponentDiagram) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponentService_2001Text(View view) {
		IParser parser = org.unicase.ui.diagram.componentDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentService_2001,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponent_2002Text(View view) {
		IParser parser = org.unicase.ui.diagram.componentDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.Component_2002,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponentOfferedServices_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getComponentConsumedServices_4002Text(View view) {
		return ""; //$NON-NLS-1$
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
		return org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
