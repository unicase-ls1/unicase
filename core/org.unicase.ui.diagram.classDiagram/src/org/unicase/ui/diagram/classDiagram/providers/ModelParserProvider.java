/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.providers;

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
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_5001Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5001Parser() {
		if (className_5001Parser == null) {
			className_5001Parser = createClassName_5001Parser();
		}
		return className_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createClassName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5002Parser() {
		if (packageName_5002Parser == null) {
			packageName_5002Parser = createPackageName_5002Parser();
		}
		return packageName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPackageName_5002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser attribute_3001Parser;

	/**
	 * @generated
	 */
	private IParser getAttribute_3001Parser() {
		if (attribute_3001Parser == null) {
			attribute_3001Parser = createAttribute_3001Parser();
		}
		return attribute_3001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAttribute_3001Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAttribute_Label(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser method_3002Parser;

	/**
	 * @generated
	 */
	private IParser getMethod_3002Parser() {
		if (method_3002Parser == null) {
			method_3002Parser = createMethod_3002Parser();
		}
		return method_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createMethod_3002Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getMethod_Label(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if (associationName_6001Parser == null) {
			associationName_6001Parser = createAssociationName_6001Parser();
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_6002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_6002Parser() {
		if (associationSourceMultiplicity_6002Parser == null) {
			associationSourceMultiplicity_6002Parser = createAssociationSourceMultiplicity_6002Parser();
		}
		return associationSourceMultiplicity_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_6002Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_6003Parser() {
		if (associationTargetMultiplicity_6003Parser == null) {
			associationTargetMultiplicity_6003Parser = createAssociationTargetMultiplicity_6003Parser();
		}
		return associationTargetMultiplicity_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_6003Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			associationName_6004Parser = createAssociationName_6004Parser();
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6004Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_6005Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_6005Parser() {
		if (associationSourceMultiplicity_6005Parser == null) {
			associationSourceMultiplicity_6005Parser = createAssociationSourceMultiplicity_6005Parser();
		}
		return associationSourceMultiplicity_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_6005Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_6006Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_6006Parser() {
		if (associationTargetMultiplicity_6006Parser == null) {
			associationTargetMultiplicity_6006Parser = createAssociationTargetMultiplicity_6006Parser();
		}
		return associationTargetMultiplicity_6006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_6006Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6007Parser() {
		if (associationName_6007Parser == null) {
			associationName_6007Parser = createAssociationName_6007Parser();
		}
		return associationName_6007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6007Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_6008Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_6008Parser() {
		if (associationSourceMultiplicity_6008Parser == null) {
			associationSourceMultiplicity_6008Parser = createAssociationSourceMultiplicity_6008Parser();
		}
		return associationSourceMultiplicity_6008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_6008Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_6009Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_6009Parser() {
		if (associationTargetMultiplicity_6009Parser == null) {
			associationTargetMultiplicity_6009Parser = createAssociationTargetMultiplicity_6009Parser();
		}
		return associationTargetMultiplicity_6009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_6009Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6010Parser() {
		if (associationName_6010Parser == null) {
			associationName_6010Parser = createAssociationName_6010Parser();
		}
		return associationName_6010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_6010Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationSourceMultiplicity_6011Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationSourceMultiplicity_6011Parser() {
		if (associationSourceMultiplicity_6011Parser == null) {
			associationSourceMultiplicity_6011Parser = createAssociationSourceMultiplicity_6011Parser();
		}
		return associationSourceMultiplicity_6011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationSourceMultiplicity_6011Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationTargetMultiplicity_6012Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationTargetMultiplicity_6012Parser() {
		if (associationTargetMultiplicity_6012Parser == null) {
			associationTargetMultiplicity_6012Parser = createAssociationTargetMultiplicity_6012Parser();
		}
		return associationTargetMultiplicity_6012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationTargetMultiplicity_6012Parser() {
		EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity(), };
		org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_5001Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID:
			return getPackageName_5002Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_3002Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6002Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6003Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6005Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6006Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID:
			return getAssociationName_6007Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6008Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6009Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID:
			return getAssociationName_6010Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6011Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6012Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.getElement(hint) == null) {
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
		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
