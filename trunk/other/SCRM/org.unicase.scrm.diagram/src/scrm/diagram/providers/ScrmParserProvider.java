package scrm.diagram.providers;

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

import scrm.ScrmPackage;
import scrm.diagram.edit.parts.AssumptionDescriptionNameEditPart;
import scrm.diagram.edit.parts.ConstraintDescriptionNameEditPart;
import scrm.diagram.edit.parts.DataDefinitionDescriptionNameEditPart;
import scrm.diagram.edit.parts.DataFlowDescriptionNameEditPart;
import scrm.diagram.edit.parts.DataHandlingDescriptionNameEditPart;
import scrm.diagram.edit.parts.ErrorHandlingDescriptionNameEditPart;
import scrm.diagram.edit.parts.FeatureDescriptionNameEditPart;
import scrm.diagram.edit.parts.HardwareDescriptionNameEditPart;
import scrm.diagram.edit.parts.InputDataReadingDescriptionNameEditPart;
import scrm.diagram.edit.parts.MathematicalModelDescriptionNameEditPart;
import scrm.diagram.edit.parts.NumericalMethodDescriptionNameEditPart;
import scrm.diagram.edit.parts.PerformanceDescriptionNameEditPart;
import scrm.diagram.edit.parts.ProcessDescriptionNameEditPart;
import scrm.diagram.edit.parts.ResultsOutputDescriptionNameEditPart;
import scrm.diagram.edit.parts.ScientificProblemDescriptionEditPart;
import scrm.diagram.edit.parts.ScientificProblemNameEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceDescriptionNameEditPart;
import scrm.diagram.edit.parts.StatusMonitoringDescriptionNameEditPart;
import scrm.diagram.edit.parts.UserInterfaceDescriptionNameEditPart;
import scrm.diagram.parsers.MessageFormatParser;
import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class ScrmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser scientificProblemName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getScientificProblemName_5003Parser() {
		if (scientificProblemName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			scientificProblemName_5003Parser = parser;
		}
		return scientificProblemName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser scientificProblemDescription_5019Parser;

	/**
	 * @generated
	 */
	private IParser getScientificProblemDescription_5019Parser() {
		if (scientificProblemDescription_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			scientificProblemDescription_5019Parser = parser;
		}
		return scientificProblemDescription_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelDescriptionName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelDescriptionName_5001Parser() {
		if (mathematicalModelDescriptionName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mathematicalModelDescriptionName_5001Parser = parser;
		}
		return mathematicalModelDescriptionName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodDescriptionName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodDescriptionName_5002Parser() {
		if (numericalMethodDescriptionName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			numericalMethodDescriptionName_5002Parser = parser;
		}
		return numericalMethodDescriptionName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser assumptionDescriptionName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionDescriptionName_5004Parser() {
		if (assumptionDescriptionName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			assumptionDescriptionName_5004Parser = parser;
		}
		return assumptionDescriptionName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser featureDescriptionName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureDescriptionName_5005Parser() {
		if (featureDescriptionName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureDescriptionName_5005Parser = parser;
		}
		return featureDescriptionName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareDescriptionName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareDescriptionName_5006Parser() {
		if (hardwareDescriptionName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			hardwareDescriptionName_5006Parser = parser;
		}
		return hardwareDescriptionName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintDescriptionName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintDescriptionName_5007Parser() {
		if (constraintDescriptionName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintDescriptionName_5007Parser = parser;
		}
		return constraintDescriptionName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser userInterfaceDescriptionName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getUserInterfaceDescriptionName_5008Parser() {
		if (userInterfaceDescriptionName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			userInterfaceDescriptionName_5008Parser = parser;
		}
		return userInterfaceDescriptionName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser softwareInterfaceDescriptionName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceDescriptionName_5009Parser() {
		if (softwareInterfaceDescriptionName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			softwareInterfaceDescriptionName_5009Parser = parser;
		}
		return softwareInterfaceDescriptionName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser processDescriptionName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getProcessDescriptionName_5010Parser() {
		if (processDescriptionName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			processDescriptionName_5010Parser = parser;
		}
		return processDescriptionName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser performanceDescriptionName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceDescriptionName_5011Parser() {
		if (performanceDescriptionName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			performanceDescriptionName_5011Parser = parser;
		}
		return performanceDescriptionName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataFlowDescriptionName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getDataFlowDescriptionName_5012Parser() {
		if (dataFlowDescriptionName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataFlowDescriptionName_5012Parser = parser;
		}
		return dataFlowDescriptionName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDescriptionName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDescriptionName_5013Parser() {
		if (dataDefinitionDescriptionName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataDefinitionDescriptionName_5013Parser = parser;
		}
		return dataDefinitionDescriptionName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingDescriptionName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingDescriptionName_5014Parser() {
		if (inputDataReadingDescriptionName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputDataReadingDescriptionName_5014Parser = parser;
		}
		return inputDataReadingDescriptionName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingDescriptionName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingDescriptionName_5015Parser() {
		if (dataHandlingDescriptionName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataHandlingDescriptionName_5015Parser = parser;
		}
		return dataHandlingDescriptionName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputDescriptionName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputDescriptionName_5016Parser() {
		if (resultsOutputDescriptionName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resultsOutputDescriptionName_5016Parser = parser;
		}
		return resultsOutputDescriptionName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingDescriptionName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingDescriptionName_5017Parser() {
		if (errorHandlingDescriptionName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			errorHandlingDescriptionName_5017Parser = parser;
		}
		return errorHandlingDescriptionName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser statusMonitoringDescriptionName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringDescriptionName_5018Parser() {
		if (statusMonitoringDescriptionName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ScrmPackage.eINSTANCE.getSCRMModelElement_Description(),
					ScrmPackage.eINSTANCE.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			statusMonitoringDescriptionName_5018Parser = parser;
		}
		return statusMonitoringDescriptionName_5018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ScientificProblemNameEditPart.VISUAL_ID:
			return getScientificProblemName_5003Parser();
		case ScientificProblemDescriptionEditPart.VISUAL_ID:
			return getScientificProblemDescription_5019Parser();
		case MathematicalModelDescriptionNameEditPart.VISUAL_ID:
			return getMathematicalModelDescriptionName_5001Parser();
		case NumericalMethodDescriptionNameEditPart.VISUAL_ID:
			return getNumericalMethodDescriptionName_5002Parser();
		case AssumptionDescriptionNameEditPart.VISUAL_ID:
			return getAssumptionDescriptionName_5004Parser();
		case FeatureDescriptionNameEditPart.VISUAL_ID:
			return getFeatureDescriptionName_5005Parser();
		case HardwareDescriptionNameEditPart.VISUAL_ID:
			return getHardwareDescriptionName_5006Parser();
		case ConstraintDescriptionNameEditPart.VISUAL_ID:
			return getConstraintDescriptionName_5007Parser();
		case UserInterfaceDescriptionNameEditPart.VISUAL_ID:
			return getUserInterfaceDescriptionName_5008Parser();
		case SoftwareInterfaceDescriptionNameEditPart.VISUAL_ID:
			return getSoftwareInterfaceDescriptionName_5009Parser();
		case ProcessDescriptionNameEditPart.VISUAL_ID:
			return getProcessDescriptionName_5010Parser();
		case PerformanceDescriptionNameEditPart.VISUAL_ID:
			return getPerformanceDescriptionName_5011Parser();
		case DataFlowDescriptionNameEditPart.VISUAL_ID:
			return getDataFlowDescriptionName_5012Parser();
		case DataDefinitionDescriptionNameEditPart.VISUAL_ID:
			return getDataDefinitionDescriptionName_5013Parser();
		case InputDataReadingDescriptionNameEditPart.VISUAL_ID:
			return getInputDataReadingDescriptionName_5014Parser();
		case DataHandlingDescriptionNameEditPart.VISUAL_ID:
			return getDataHandlingDescriptionName_5015Parser();
		case ResultsOutputDescriptionNameEditPart.VISUAL_ID:
			return getResultsOutputDescriptionName_5016Parser();
		case ErrorHandlingDescriptionNameEditPart.VISUAL_ID:
			return getErrorHandlingDescriptionName_5017Parser();
		case StatusMonitoringDescriptionNameEditPart.VISUAL_ID:
			return getStatusMonitoringDescriptionName_5018Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ScrmVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ScrmVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ScrmElementTypes.getElement(hint) == null) {
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
