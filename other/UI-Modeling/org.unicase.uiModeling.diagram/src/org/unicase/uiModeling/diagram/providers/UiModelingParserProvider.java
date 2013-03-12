/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class UiModelingParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser windowText_5003Parser;

	/**
	 * @generated
	 */
	private IParser getWindowText_5003Parser() {
		if (windowText_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			windowText_5003Parser = parser;
		}
		return windowText_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser labelText_5001Parser;

	/**
	 * @generated
	 */
	private IParser getLabelText_5001Parser() {
		if (labelText_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			labelText_5001Parser = parser;
		}
		return labelText_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser textFieldText_5004Parser;

	/**
	 * @generated
	 */
	private IParser getTextFieldText_5004Parser() {
		if (textFieldText_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			textFieldText_5004Parser = parser;
		}
		return textFieldText_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser buttonText_5012Parser;

	/**
	 * @generated
	 */
	private IParser getButtonText_5012Parser() {
		if (buttonText_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			buttonText_5012Parser = parser;
		}
		return buttonText_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser textText_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTextText_5002Parser() {
		if (textText_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			textText_5002Parser = parser;
		}
		return textText_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser imageText_5006Parser;

	/**
	 * @generated
	 */
	private IParser getImageText_5006Parser() {
		if (imageText_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			imageText_5006Parser = parser;
		}
		return imageText_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser radioGroupText_5014Parser;

	/**
	 * @generated
	 */
	private IParser getRadioGroupText_5014Parser() {
		if (radioGroupText_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			radioGroupText_5014Parser = parser;
		}
		return radioGroupText_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser checkboxGroupText_5015Parser;

	/**
	 * @generated
	 */
	private IParser getCheckboxGroupText_5015Parser() {
		if (checkboxGroupText_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			checkboxGroupText_5015Parser = parser;
		}
		return checkboxGroupText_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser buttonText_5011Parser;

	/**
	 * @generated
	 */
	private IParser getButtonText_5011Parser() {
		if (buttonText_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			buttonText_5011Parser = parser;
		}
		return buttonText_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser imageText_5007Parser;

	/**
	 * @generated
	 */
	private IParser getImageText_5007Parser() {
		if (imageText_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			imageText_5007Parser = parser;
		}
		return imageText_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser labelText_5008Parser;

	/**
	 * @generated
	 */
	private IParser getLabelText_5008Parser() {
		if (labelText_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			labelText_5008Parser = parser;
		}
		return labelText_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser textText_5009Parser;

	/**
	 * @generated
	 */
	private IParser getTextText_5009Parser() {
		if (textText_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			textText_5009Parser = parser;
		}
		return textText_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser textFieldText_5010Parser;

	/**
	 * @generated
	 */
	private IParser getTextFieldText_5010Parser() {
		if (textFieldText_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			textFieldText_5010Parser = parser;
		}
		return textFieldText_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser radioGroupText_5019Parser;

	/**
	 * @generated
	 */
	private IParser getRadioGroupText_5019Parser() {
		if (radioGroupText_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			radioGroupText_5019Parser = parser;
		}
		return radioGroupText_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser radioButtonText_5013Parser;

	/**
	 * @generated
	 */
	private IParser getRadioButtonText_5013Parser() {
		if (radioButtonText_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getRadioButton_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			radioButtonText_5013Parser = parser;
		}
		return radioButtonText_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser checkboxGroupText_5020Parser;

	/**
	 * @generated
	 */
	private IParser getCheckboxGroupText_5020Parser() {
		if (checkboxGroupText_5020Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getWidget_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			checkboxGroupText_5020Parser = parser;
		}
		return checkboxGroupText_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser checkboxText_5016Parser;

	/**
	 * @generated
	 */
	private IParser getCheckboxText_5016Parser() {
		if (checkboxText_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getCheckbox_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			checkboxText_5016Parser = parser;
		}
		return checkboxText_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser dropdownItemText_5017Parser;

	/**
	 * @generated
	 */
	private IParser getDropdownItemText_5017Parser() {
		if (dropdownItemText_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { org.unicase.uiModeling.UiModelingPackage.eINSTANCE
				.getDropdownItem_Text() };
			org.unicase.uiModeling.diagram.parsers.MessageFormatParser parser = new org.unicase.uiModeling.diagram.parsers.MessageFormatParser(
				features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dropdownItemText_5017Parser = parser;
		}
		return dropdownItemText_5017Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID:
			return getWindowText_5003Parser();
		case org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart.VISUAL_ID:
			return getLabelText_5001Parser();
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart.VISUAL_ID:
			return getTextFieldText_5004Parser();
		case org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart.VISUAL_ID:
			return getButtonText_5012Parser();
		case org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart.VISUAL_ID:
			return getTextText_5002Parser();
		case org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID:
			return getImageText_5006Parser();
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID:
			return getRadioGroupText_5014Parser();
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID:
			return getCheckboxGroupText_5015Parser();
		case org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart.VISUAL_ID:
			return getButtonText_5011Parser();
		case org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID:
			return getImageText_5007Parser();
		case org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart.VISUAL_ID:
			return getLabelText_5008Parser();
		case org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart.VISUAL_ID:
			return getTextText_5009Parser();
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart.VISUAL_ID:
			return getTextFieldText_5010Parser();
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart.VISUAL_ID:
			return getRadioGroupText_5019Parser();
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart.VISUAL_ID:
			return getRadioButtonText_5013Parser();
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart.VISUAL_ID:
			return getCheckboxGroupText_5020Parser();
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart.VISUAL_ID:
			return getCheckboxText_5016Parser();
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart.VISUAL_ID:
			return getDropdownItemText_5017Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
