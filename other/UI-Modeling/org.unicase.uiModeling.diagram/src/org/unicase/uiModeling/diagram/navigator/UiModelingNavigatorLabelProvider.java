/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
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
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?RadioGroup", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?CheckboxGroup", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?DropdownList", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_2011); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/uiModeling?ImageButton", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.ImageButton_2012); //$NON-NLS-1$
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
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?RadioGroup", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_3009); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?RadioButton", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?CheckboxGroup", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_3010); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?Checkbox", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?DropdownList", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_3011); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?DropdownItem", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008); //$NON-NLS-1$
		case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Node?http://unicase.org/model/uiModeling?ImageButton", org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.ImageButton_3012); //$NON-NLS-1$
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
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return getRadioGroup_2009Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return getCheckboxGroup_2010Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return getDropdownList_2011Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return getImageButton_2012Text(view);
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
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
			return getRadioGroup_3009Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return getRadioButton_3006Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
			return getCheckboxGroup_3010Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return getCheckbox_3007Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
			return getDropdownList_3011Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return getDropdownItem_3008Text(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
			return getImageButton_3012Text(view);
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
	private String getRadioGroup_2009Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCheckboxGroup_2010Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDropdownList_2011Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_2011,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getImageButton_2012Text(View view) {
		org.unicase.uiModeling.ImageButton domainModelElement = (org.unicase.uiModeling.ImageButton) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 2012); //$NON-NLS-1$
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
	private String getRadioGroup_3009Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_3009,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRadioButton_3006Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCheckboxGroup_3010Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_3010,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCheckbox_3007Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDropdownList_3011Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_3011,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDropdownItem_3008Text(View view) {
		IParser parser = org.unicase.uiModeling.diagram.providers.UiModelingParserProvider.getParser(
			org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008,
			view.getElement() != null ? view.getElement() : view,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getImageButton_3012Text(View view) {
		org.unicase.uiModeling.ImageButton domainModelElement = (org.unicase.uiModeling.ImageButton) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 3012); //$NON-NLS-1$
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
