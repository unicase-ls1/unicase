/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.navigator;

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

/**
 * @generated
 */
public class UiModelingNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
	ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem
			&& !isOwnView(((org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup group = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) element;
			return org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().getBundledImage(
				group.getIcon());
		}

		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem navigatorItem = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) element;
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
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/uiModeling?Panel", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Panel_45); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?Window", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?Label", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?TextField", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?Button", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?Text", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?Image", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?Button", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?Image", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?Label", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?Text", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?TextField", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance()
			.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
			&& org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.isKnownElementType(elementType)) {
			image = org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.getImage(elementType);
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
		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup group = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem navigatorItem = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) element;
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
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_45Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return getWindow_2003Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return getLabel_2004Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return getTextField_2005Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return getButton_2006Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return getText_2007Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return getImage_2008Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return getButton_3001Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return getImage_3002Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return getLabel_3003Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return getText_3004Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return getTextField_3005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPanel_45Text(View view) {
		org.unicase.uiModeling.Panel domainModelElement = (org.unicase.uiModeling.Panel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 45); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getWindow_2003Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLabel_2004Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTextField_2005Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getButton_2006Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getText_2007Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getImage_2008Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getButton_3001Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getImage_3002Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLabel_3003Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getText_3004Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTextField_3005Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5010); //$NON-NLS-1$
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
		return org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID
			.equals(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getModelID(view));
	}

}
