package org.unicase.wireframe.diagram.providers;

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
import org.unicase.wireframe.WireframePackage;
import org.unicase.wireframe.diagram.edit.parts.ImageTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowTextEditPart;
import org.unicase.wireframe.diagram.parsers.MessageFormatParser;
import org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry;

/**
 * @generated
 */
public class WireframeParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser windowText_5003Parser;

	/**
	 * @generated
	 */
	private IParser getWindowText_5003Parser() {
		if (windowText_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { WireframePackage.eINSTANCE.getWidget_Text() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
			EAttribute[] features = new EAttribute[] { WireframePackage.eINSTANCE.getWidget_Text() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
			EAttribute[] features = new EAttribute[] { WireframePackage.eINSTANCE.getWidget_Text() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
	private IParser textText_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTextText_5002Parser() {
		if (textText_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { WireframePackage.eINSTANCE.getWidget_Text() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
			EAttribute[] features = new EAttribute[] { WireframePackage.eINSTANCE.getWidget_Text() };
			MessageFormatParser parser = new MessageFormatParser(features);
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
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WindowTextEditPart.VISUAL_ID:
			return getWindowText_5003Parser();
		case LabelTextEditPart.VISUAL_ID:
			return getLabelText_5001Parser();
		case TextFieldTextEditPart.VISUAL_ID:
			return getTextFieldText_5004Parser();
		case TextTextEditPart.VISUAL_ID:
			return getTextText_5002Parser();
		case ImageTextEditPart.VISUAL_ID:
			return getImageText_5006Parser();
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
			return getParser(WireframeVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(WireframeVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (WireframeElementTypes.getElement(hint) == null) {
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
