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
				.getAttribute_Label(), };
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
	private IParser associationSourceMultiplicity_4003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_4003Parser() {
		if (associationSourceMultiplicity_4003Parser == null) {
			associationSourceMultiplicity_4003Parser = createAssociationSourceMultiplicity_4003Parser();
		}
		return associationSourceMultiplicity_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_4003Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_SourceMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_4004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_4004Parser() {
		if (associationTargetMultiplicity_4004Parser == null) {
			associationTargetMultiplicity_4004Parser = createAssociationTargetMultiplicity_4004Parser();
		}
		return associationTargetMultiplicity_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_4004Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_TargetMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4005Parser() {
		if (associationName_4005Parser == null) {
			associationName_4005Parser = createAssociationName_4005Parser();
		}
		return associationName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_4005Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_4006Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_4006Parser() {
		if (associationSourceMultiplicity_4006Parser == null) {
			associationSourceMultiplicity_4006Parser = createAssociationSourceMultiplicity_4006Parser();
		}
		return associationSourceMultiplicity_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_4006Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_SourceMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_4007Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_4007Parser() {
		if (associationTargetMultiplicity_4007Parser == null) {
			associationTargetMultiplicity_4007Parser = createAssociationTargetMultiplicity_4007Parser();
		}
		return associationTargetMultiplicity_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_4007Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_TargetMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4008Parser() {
		if (associationName_4008Parser == null) {
			associationName_4008Parser = createAssociationName_4008Parser();
		}
		return associationName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_4008Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_4009Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_4009Parser() {
		if (associationSourceMultiplicity_4009Parser == null) {
			associationSourceMultiplicity_4009Parser = createAssociationSourceMultiplicity_4009Parser();
		}
		return associationSourceMultiplicity_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_4009Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_SourceMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_4010Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_4010Parser() {
		if (associationTargetMultiplicity_4010Parser == null) {
			associationTargetMultiplicity_4010Parser = createAssociationTargetMultiplicity_4010Parser();
		}
		return associationTargetMultiplicity_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_4010Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_TargetMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4011Parser() {
		if (associationName_4011Parser == null) {
			associationName_4011Parser = createAssociationName_4011Parser();
		}
		return associationName_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_4011Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_4012Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_4012Parser() {
		if (associationSourceMultiplicity_4012Parser == null) {
			associationSourceMultiplicity_4012Parser = createAssociationSourceMultiplicity_4012Parser();
		}
		return associationSourceMultiplicity_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_4012Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_SourceMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_4013Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_4013Parser() {
		if (associationTargetMultiplicity_4013Parser == null) {
			associationTargetMultiplicity_4013Parser = createAssociationTargetMultiplicity_4013Parser();
		}
		return associationTargetMultiplicity_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_4013Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE
				.getAssociation_TargetMultiplicity(), };
		org.unicase.model.classDiagram.parsers.MessageFormatParser parser = new org.unicase.model.classDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.model.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_4001Parser();
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_2001Parser();
		case org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_2002Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_4002Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_4003Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_4004Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_4005Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_4006Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_4007Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_4008Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_4009Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_4010Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_4011Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_4012Parser();
		case org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_4013Parser();
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
