package org.unicase.ui.urmlDiagram.providers;

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

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser hazardCauseName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getHazardCauseName_5003Parser() {
		if (hazardCauseName_5003Parser == null) {
			hazardCauseName_5003Parser = createHazardCauseName_5003Parser();
		}
		return hazardCauseName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createHazardCauseName_5003Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser mitigationName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getMitigationName_5004Parser() {
		if (mitigationName_5004Parser == null) {
			mitigationName_5004Parser = createMitigationName_5004Parser();
		}
		return mitigationName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createMitigationName_5004Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser hazardName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getHazardName_5005Parser() {
		if (hazardName_5005Parser == null) {
			hazardName_5005Parser = createHazardName_5005Parser();
		}
		return hazardName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createHazardName_5005Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5001Parser() {
		if (actorName_5001Parser == null) {
			actorName_5001Parser = createActorName_5001Parser();
		}
		return actorName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActorName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5002Parser() {
		if (useCaseName_5002Parser == null) {
			useCaseName_5002Parser = createUseCaseName_5002Parser();
		}
		return useCaseName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser functionalRequirementName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionalRequirementName_5006Parser() {
		if (functionalRequirementName_5006Parser == null) {
			functionalRequirementName_5006Parser = createFunctionalRequirementName_5006Parser();
		}
		return functionalRequirementName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createFunctionalRequirementName_5006Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.urmlDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.urmlDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseNameEditPart.VISUAL_ID:
			return getHazardCauseName_5003Parser();
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationNameEditPart.VISUAL_ID:
			return getMitigationName_5004Parser();
		case org.unicase.ui.urmlDiagram.edit.parts.HazardNameEditPart.VISUAL_ID:
			return getHazardName_5005Parser();
		case org.unicase.ui.urmlDiagram.edit.parts.ActorNameEditPart.VISUAL_ID:
			return getActorName_5001Parser();
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID:
			return getUseCaseName_5002Parser();
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementNameEditPart.VISUAL_ID:
			return getFunctionalRequirementName_5006Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
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
			if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes
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
