/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			className_5001Parser = parser;
		}
		return className_5001Parser;
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
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			packageName_5002Parser = parser;
		}
		return packageName_5002Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAttribute_Label() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			attribute_3001Parser = parser;
		}
		return attribute_3001Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getMethod_Label() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			method_3002Parser = parser;
		}
		return method_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationType_6001Parser;

	/**
	 * @generated Not
	 */
	private IParser getAssociationType_6001Parser() {
		if (associationType_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationType_6001Parser = parser;
		}
		return associationType_6001Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationSourceMultiplicity_6002Parser = parser;
		}
		return associationSourceMultiplicity_6002Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationTargetMultiplicity_6003Parser = parser;
		}
		return associationTargetMultiplicity_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationType_6004Parser;

	/**
	 * @generated Not
	 */
	private IParser getAssociationType_6004Parser() {
		if (associationType_6004Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationType_6004Parser = parser;
		}
		return associationType_6004Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationSourceMultiplicity_6005Parser = parser;
		}
		return associationSourceMultiplicity_6005Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationTargetMultiplicity_6006Parser = parser;
		}
		return associationTargetMultiplicity_6006Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationType_6007Parser;

	/**
	 * @generated Not
	 */
	private IParser getAssociationType_6007Parser() {
		if (associationType_6007Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationType_6007Parser = parser;
		}
		return associationType_6007Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationSourceMultiplicity_6008Parser = parser;
		}
		return associationSourceMultiplicity_6008Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationTargetMultiplicity_6009Parser = parser;
		}
		return associationTargetMultiplicity_6009Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationType_6010Parser;

	/**
	 * @generated Not
	 */
	private IParser getAssociationType_6010Parser() {
		if (associationType_6010Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationType_6010Parser = parser;
		}
		return associationType_6010Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_SourceMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationSourceMultiplicity_6011Parser = parser;
		}
		return associationSourceMultiplicity_6011Parser;
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
			EAttribute[] features = new EAttribute[] { ClassesPackage.eINSTANCE.getAssociation_TargetMultiplicity() };
			org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.classDiagram.parsers.MessageFormatParser(
				features);
			associationTargetMultiplicity_6012Parser = parser;
		}
		return associationTargetMultiplicity_6012Parser;
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
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTypeEditPart.VISUAL_ID:
			return getAssociationType_6001Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6002Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6003Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType2EditPart.VISUAL_ID:
			return getAssociationType_6004Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6005Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6006Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType3EditPart.VISUAL_ID:
			return getAssociationType_6007Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6008Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6009Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType4EditPart.VISUAL_ID:
			return getAssociationType_6010Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
			return getAssociationSourceMultiplicity_6011Parser();
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
			return getAssociationTargetMultiplicity_6012Parser();
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
		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
