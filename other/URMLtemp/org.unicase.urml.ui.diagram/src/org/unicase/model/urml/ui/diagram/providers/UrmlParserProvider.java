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
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderNameEditPart;
import org.unicase.model.urml.ui.diagram.parsers.MessageFormatParser;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser stakeholderName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getStakeholderName_5008Parser() {
		if (stakeholderName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stakeholderName_5008Parser = parser;
		}
		return stakeholderName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getGoalName_5009Parser() {
		if (goalName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalName_5009Parser = parser;
		}
		return goalName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser functionalRequirementName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionalRequirementName_5010Parser() {
		if (functionalRequirementName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			functionalRequirementName_5010Parser = parser;
		}
		return functionalRequirementName_5010Parser;
	}

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
	private IParser proceduralMitigationName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getProceduralMitigationName_5006Parser() {
		if (proceduralMitigationName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			proceduralMitigationName_5006Parser = parser;
		}
		return proceduralMitigationName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser serviceProviderName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getServiceProviderName_5007Parser() {
		if (serviceProviderName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			serviceProviderName_5007Parser = parser;
		}
		return serviceProviderName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StakeholderNameEditPart.VISUAL_ID:
			return getStakeholderName_5008Parser();
		case GoalNameEditPart.VISUAL_ID:
			return getGoalName_5009Parser();
		case FunctionalRequirementNameEditPart.VISUAL_ID:
			return getFunctionalRequirementName_5010Parser();
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
		case ProceduralMitigationNameEditPart.VISUAL_ID:
			return getProceduralMitigationName_5006Parser();
		case ServiceProviderNameEditPart.VISUAL_ID:
			return getServiceProviderName_5007Parser();
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
