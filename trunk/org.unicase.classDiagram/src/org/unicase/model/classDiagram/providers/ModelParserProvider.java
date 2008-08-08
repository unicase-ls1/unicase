package org.unicase.model.classDiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelPackage;
import org.unicase.model.classes.ClassesPackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_4001Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_4001Parser() {
		if (className_4001Parser == null) {
			className_4001Parser = createClassName_4001Parser();
		}
		return className_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_4001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser attribute_2001Parser;

	/**
	 * @generated
	 */
	private IParser getAttribute_2001Parser() {
		if (attribute_2001Parser == null) {
			attribute_2001Parser = createAttribute_2001Parser();
		}
		return attribute_2001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAttribute_2001Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAttribute_Signature(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser method_2002Parser;

	/**
	 * @generated
	 */
	private IParser getMethod_2002Parser() {
		if (method_2002Parser == null) {
			method_2002Parser = createMethod_2002Parser();
		}
		return method_2002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createMethod_2002Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getMethod_Label(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4002Parser() {
		if (associationName_4002Parser == null) {
			associationName_4002Parser = createAssociationName_4002Parser();
		}
		return associationName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_4002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.model.classDiagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getClassName_4001Parser();
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_2001Parser();
		case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_2002Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_4002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.model.classDiagram.providers.ModelElementTypes
					.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

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
