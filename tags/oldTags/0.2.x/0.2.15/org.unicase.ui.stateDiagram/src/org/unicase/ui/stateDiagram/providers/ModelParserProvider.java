package org.unicase.ui.stateDiagram.providers;

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
	private IParser stateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5001Parser() {
		if (stateName_5001Parser == null) {
			stateName_5001Parser = createStateName_5001Parser();
		}
		return stateName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.stateDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6001Parser() {
		if (transitionName_6001Parser == null) {
			transitionName_6001Parser = createTransitionName_6001Parser();
		}
		return transitionName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionName_6001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.stateDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID:
			return getStateName_5001Parser();
		case org.unicase.ui.stateDiagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_6001Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
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
			if (org.unicase.ui.stateDiagram.providers.ModelElementTypes
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
