package org.unicase.ui.diagram.urml.providers;

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
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.ui.diagram.urml.edit.parts.ActorNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FeatureNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeight2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeight3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeightEditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsDetailedLabel2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointNameEditPart;
import org.unicase.ui.diagram.urml.parsers.MessageFormatParser;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;

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
	private IParser featureName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureName_5011Parser() {
		if (featureName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5011Parser = parser;
		}
		return featureName_5011Parser;
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
	private IParser variationPointName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getVariationPointName_5012Parser() {
		if (variationPointName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			variationPointName_5012Parser = parser;
		}
		return variationPointName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser variationPointInstanceName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getVariationPointInstanceName_5013Parser() {
		if (variationPointInstanceName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			variationPointInstanceName_5013Parser = parser;
		}
		return variationPointInstanceName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser productName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getProductName_5014Parser() {
		if (productName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			productName_5014Parser = parser;
		}
		return productName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalReferenceWeight_6013Parser;

	/**
	 * @generated
	 */
	private IParser getGoalReferenceWeight_6013Parser() {
		if (goalReferenceWeight_6013Parser == null) {
			EAttribute[] features = new EAttribute[] { GoalPackage.eINSTANCE.getGoalReference_Weight() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalReferenceWeight_6013Parser = parser;
		}
		return goalReferenceWeight_6013Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalReferenceWeight_6019Parser;

	/**
	 * @generated
	 */
	private IParser getGoalReferenceWeight_6019Parser() {
		if (goalReferenceWeight_6019Parser == null) {
			EAttribute[] features = new EAttribute[] { GoalPackage.eINSTANCE.getGoalReference_Weight() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalReferenceWeight_6019Parser = parser;
		}
		return goalReferenceWeight_6019Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalReferenceWeight_6020Parser;

	/**
	 * @generated
	 */
	private IParser getGoalReferenceWeight_6020Parser() {
		if (goalReferenceWeight_6020Parser == null) {
			EAttribute[] features = new EAttribute[] { GoalPackage.eINSTANCE.getGoalReference_Weight() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalReferenceWeight_6020Parser = parser;
		}
		return goalReferenceWeight_6020Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalReferenceWeight_6021Parser;

	/**
	 * @generated
	 */
	private IParser getGoalReferenceWeight_6021Parser() {
		if (goalReferenceWeight_6021Parser == null) {
			EAttribute[] features = new EAttribute[] { GoalPackage.eINSTANCE.getGoalReference_Weight() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalReferenceWeight_6021Parser = parser;
		}
		return goalReferenceWeight_6021Parser;
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
			return getFeatureName_5011Parser();
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
		case VariationPointNameEditPart.VISUAL_ID:
			return getVariationPointName_5012Parser();
		case VariationPointInstanceNameEditPart.VISUAL_ID:
			return getVariationPointInstanceName_5013Parser();
		case ProductNameEditPart.VISUAL_ID:
			return getProductName_5014Parser();
		case IsDetailedLabel2EditPart.VISUAL_ID:
			return getGoalReferenceWeight_6013Parser();
		case GoalReferenceWeightEditPart.VISUAL_ID:
			return getGoalReferenceWeight_6019Parser();
		case GoalReferenceWeight2EditPart.VISUAL_ID:
			return getGoalReferenceWeight_6020Parser();
		case GoalReferenceWeight3EditPart.VISUAL_ID:
			return getGoalReferenceWeight_6021Parser();
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
