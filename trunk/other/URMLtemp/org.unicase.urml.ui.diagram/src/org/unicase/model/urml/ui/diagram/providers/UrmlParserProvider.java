package org.unicase.model.urml.ui.diagram.providers;

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
import org.unicase.model.urml.ui.diagram.edit.parts.ActorNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.parsers.MessageFormatParser;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser featureName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureName_5001Parser() {
		if (featureName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5001Parser = parser;
		}
		return featureName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser serviceName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getServiceName_5002Parser() {
		if (serviceName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			serviceName_5002Parser = parser;
		}
		return serviceName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser nonFunctionalRequirementName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getNonFunctionalRequirementName_5003Parser() {
		if (nonFunctionalRequirementName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nonFunctionalRequirementName_5003Parser = parser;
		}
		return nonFunctionalRequirementName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser dangerName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getDangerName_5004Parser() {
		if (dangerName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dangerName_5004Parser = parser;
		}
		return dangerName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5005Parser() {
		if (actorName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5005Parser = parser;
		}
		return actorName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FeatureNameEditPart.VISUAL_ID:
			return getFeatureName_5001Parser();
		case ServiceNameEditPart.VISUAL_ID:
			return getServiceName_5002Parser();
		case NonFunctionalRequirementNameEditPart.VISUAL_ID:
			return getNonFunctionalRequirementName_5003Parser();
		case DangerNameEditPart.VISUAL_ID:
			return getDangerName_5004Parser();
		case ActorNameEditPart.VISUAL_ID:
			return getActorName_5005Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
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
			return getParser(UrmlVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UrmlVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UrmlElementTypes.getElement(hint) == null) {
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
