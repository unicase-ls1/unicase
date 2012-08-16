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
import scrm.diagram.edit.parts.*;
import scrm.diagram.parsers.MessageFormatParser;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.requirements.RequirementsPackage;

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
	private IParser mathematical_GeophysicalModelName_5156Parser;

	/**
	 * @generated
	 */
	private IParser getMathematical_GeophysicalModelName_5156Parser() {
		if (mathematical_GeophysicalModelName_5156Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mathematical_GeophysicalModelName_5156Parser = parser;
		}
		return mathematical_GeophysicalModelName_5156Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematical_GeophysicalModelDescription_5157Parser;

	/**
	 * @generated
	 */
	private IParser getMathematical_GeophysicalModelDescription_5157Parser() {
		if (mathematical_GeophysicalModelDescription_5157Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematical_GeophysicalModelDescription_5157Parser = parser;
		}
		return mathematical_GeophysicalModelDescription_5157Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodName_5002Parser() {
		if (numericalMethodName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			numericalMethodName_5002Parser = parser;
		}
		return numericalMethodName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodDescription_5023Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodDescription_5023Parser() {
		if (numericalMethodDescription_5023Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodDescription_5023Parser = parser;
		}
		return numericalMethodDescription_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser assumptionName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionName_5004Parser() {
		if (assumptionName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			assumptionName_5004Parser = parser;
		}
		return assumptionName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser assumptionDescription_5026Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionDescription_5026Parser() {
		if (assumptionDescription_5026Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			assumptionDescription_5026Parser = parser;
		}
		return assumptionDescription_5026Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementName_5072Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementName_5072Parser() {
		if (requirementName_5072Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementName_5072Parser = parser;
		}
		return requirementName_5072Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementDescription_5073Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementDescription_5073Parser() {
		if (requirementDescription_5073Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementDescription_5073Parser = parser;
		}
		return requirementDescription_5073Parser;
	}

	/**
	 * @generated
	 */
	private IParser featureName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureName_5005Parser() {
		if (featureName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5005Parser = parser;
		}
		return featureName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser featureDescription_5027Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureDescription_5027Parser() {
		if (featureDescription_5027Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			featureDescription_5027Parser = parser;
		}
		return featureDescription_5027Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareName_5006Parser() {
		if (hardwareName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			hardwareName_5006Parser = parser;
		}
		return hardwareName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareDescription_5028Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareDescription_5028Parser() {
		if (hardwareDescription_5028Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareDescription_5028Parser = parser;
		}
		return hardwareDescription_5028Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareProcessor_5029Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareProcessor_5029Parser() {
		if (hardwareProcessor_5029Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Processor() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Processor: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareProcessor_5029Parser = parser;
		}
		return hardwareProcessor_5029Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwarePlatform_5030Parser;

	/**
	 * @generated
	 */
	private IParser getHardwarePlatform_5030Parser() {
		if (hardwarePlatform_5030Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Platform() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Platform: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwarePlatform_5030Parser = parser;
		}
		return hardwarePlatform_5030Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareMemory_5031Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareMemory_5031Parser() {
		if (hardwareMemory_5031Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Memory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Memory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareMemory_5031Parser = parser;
		}
		return hardwareMemory_5031Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5007Parser() {
		if (constraintName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5007Parser = parser;
		}
		return constraintName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintDescription_5032Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintDescription_5032Parser() {
		if (constraintDescription_5032Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraintDescription_5032Parser = parser;
		}
		return constraintDescription_5032Parser;
	}

	/**
	 * @generated
	 */
	private IParser userInterfaceName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getUserInterfaceName_5008Parser() {
		if (userInterfaceName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			userInterfaceName_5008Parser = parser;
		}
		return userInterfaceName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser userInterfaceDescription_5033Parser;

	/**
	 * @generated
	 */
	private IParser getUserInterfaceDescription_5033Parser() {
		if (userInterfaceDescription_5033Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			userInterfaceDescription_5033Parser = parser;
		}
		return userInterfaceDescription_5033Parser;
	}

	/**
	 * @generated
	 */
	private IParser softwareInterfaceName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceName_5009Parser() {
		if (softwareInterfaceName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			softwareInterfaceName_5009Parser = parser;
		}
		return softwareInterfaceName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser softwareInterfaceDescription_5034Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceDescription_5034Parser() {
		if (softwareInterfaceDescription_5034Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			softwareInterfaceDescription_5034Parser = parser;
		}
		return softwareInterfaceDescription_5034Parser;
	}

	/**
	 * @generated
	 */
	private IParser performanceName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceName_5011Parser() {
		if (performanceName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			performanceName_5011Parser = parser;
		}
		return performanceName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser performanceDescription_5037Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceDescription_5037Parser() {
		if (performanceDescription_5037Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			performanceDescription_5037Parser = parser;
		}
		return performanceDescription_5037Parser;
	}

	/**
	 * @generated
	 */
	private IParser processName_5074Parser;

	/**
	 * @generated
	 */
	private IParser getProcessName_5074Parser() {
		if (processName_5074Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			processName_5074Parser = parser;
		}
		return processName_5074Parser;
	}

	/**
	 * @generated
	 */
	private IParser processDescription_5075Parser;

	/**
	 * @generated
	 */
	private IParser getProcessDescription_5075Parser() {
		if (processDescription_5075Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			processDescription_5075Parser = parser;
		}
		return processDescription_5075Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingName_5076Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingName_5076Parser() {
		if (inputDataReadingName_5076Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputDataReadingName_5076Parser = parser;
		}
		return inputDataReadingName_5076Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingDescription_5077Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingDescription_5077Parser() {
		if (inputDataReadingDescription_5077Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			inputDataReadingDescription_5077Parser = parser;
		}
		return inputDataReadingDescription_5077Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputName_5080Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputName_5080Parser() {
		if (resultsOutputName_5080Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resultsOutputName_5080Parser = parser;
		}
		return resultsOutputName_5080Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputDescription_5081Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputDescription_5081Parser() {
		if (resultsOutputDescription_5081Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			resultsOutputDescription_5081Parser = parser;
		}
		return resultsOutputDescription_5081Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingName_5082Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingName_5082Parser() {
		if (errorHandlingName_5082Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			errorHandlingName_5082Parser = parser;
		}
		return errorHandlingName_5082Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingDescription_5083Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingDescription_5083Parser() {
		if (errorHandlingDescription_5083Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			errorHandlingDescription_5083Parser = parser;
		}
		return errorHandlingDescription_5083Parser;
	}

	/**
	 * @generated
	 */
	private IParser statusMonitoringName_5084Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringName_5084Parser() {
		if (statusMonitoringName_5084Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			statusMonitoringName_5084Parser = parser;
		}
		return statusMonitoringName_5084Parser;
	}

	/**
	 * @generated
	 */
	private IParser statusMonitoringDescription_5085Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringDescription_5085Parser() {
		if (statusMonitoringDescription_5085Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			statusMonitoringDescription_5085Parser = parser;
		}
		return statusMonitoringDescription_5085Parser;
	}

	/**
	 * @generated
	 */
	private IParser solverName_5158Parser;

	/**
	 * @generated
	 */
	private IParser getSolverName_5158Parser() {
		if (solverName_5158Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			solverName_5158Parser = parser;
		}
		return solverName_5158Parser;
	}

	/**
	 * @generated
	 */
	private IParser solverDescription_5159Parser;

	/**
	 * @generated
	 */
	private IParser getSolverDescription_5159Parser() {
		if (solverDescription_5159Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			solverDescription_5159Parser = parser;
		}
		return solverDescription_5159Parser;
	}

	/**
	 * @generated
	 */
	private IParser meshCreationName_5160Parser;

	/**
	 * @generated
	 */
	private IParser getMeshCreationName_5160Parser() {
		if (meshCreationName_5160Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			meshCreationName_5160Parser = parser;
		}
		return meshCreationName_5160Parser;
	}

	/**
	 * @generated
	 */
	private IParser meshCreationDescription_5161Parser;

	/**
	 * @generated
	 */
	private IParser getMeshCreationDescription_5161Parser() {
		if (meshCreationDescription_5161Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			meshCreationDescription_5161Parser = parser;
		}
		return meshCreationDescription_5161Parser;
	}

	/**
	 * @generated
	 */
	private IParser preProcessingName_5162Parser;

	/**
	 * @generated
	 */
	private IParser getPreProcessingName_5162Parser() {
		if (preProcessingName_5162Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preProcessingName_5162Parser = parser;
		}
		return preProcessingName_5162Parser;
	}

	/**
	 * @generated
	 */
	private IParser preProcessingDescription_5163Parser;

	/**
	 * @generated
	 */
	private IParser getPreProcessingDescription_5163Parser() {
		if (preProcessingDescription_5163Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			preProcessingDescription_5163Parser = parser;
		}
		return preProcessingDescription_5163Parser;
	}

	/**
	 * @generated
	 */
	private IParser postProcessingName_5164Parser;

	/**
	 * @generated
	 */
	private IParser getPostProcessingName_5164Parser() {
		if (postProcessingName_5164Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			postProcessingName_5164Parser = parser;
		}
		return postProcessingName_5164Parser;
	}

	/**
	 * @generated
	 */
	private IParser postProcessingDescription_5165Parser;

	/**
	 * @generated
	 */
	private IParser getPostProcessingDescription_5165Parser() {
		if (postProcessingDescription_5165Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			postProcessingDescription_5165Parser = parser;
		}
		return postProcessingDescription_5165Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionName_5166Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionName_5166Parser() {
		if (dataDefinitionName_5166Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataDefinitionName_5166Parser = parser;
		}
		return dataDefinitionName_5166Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDescription_5167Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDescription_5167Parser() {
		if (dataDefinitionDescription_5167Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionDescription_5167Parser = parser;
		}
		return dataDefinitionDescription_5167Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionAccuracy_5168Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionAccuracy_5168Parser() {
		if (dataDefinitionAccuracy_5168Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionAccuracy_5168Parser = parser;
		}
		return dataDefinitionAccuracy_5168Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionFormat_5169Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionFormat_5169Parser() {
		if (dataDefinitionFormat_5169Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionFormat_5169Parser = parser;
		}
		return dataDefinitionFormat_5169Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionRange_5170Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionRange_5170Parser() {
		if (dataDefinitionRange_5170Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionRange_5170Parser = parser;
		}
		return dataDefinitionRange_5170Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceName_5171Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceName_5171Parser() {
		if (seismicSourceName_5171Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			seismicSourceName_5171Parser = parser;
		}
		return seismicSourceName_5171Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceDescription_5172Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceDescription_5172Parser() {
		if (seismicSourceDescription_5172Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			seismicSourceDescription_5172Parser = parser;
		}
		return seismicSourceDescription_5172Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceAccuracy_5173Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceAccuracy_5173Parser() {
		if (seismicSourceAccuracy_5173Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			seismicSourceAccuracy_5173Parser = parser;
		}
		return seismicSourceAccuracy_5173Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceFormat_5174Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceFormat_5174Parser() {
		if (seismicSourceFormat_5174Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			seismicSourceFormat_5174Parser = parser;
		}
		return seismicSourceFormat_5174Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceRange_5175Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceRange_5175Parser() {
		if (seismicSourceRange_5175Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			seismicSourceRange_5175Parser = parser;
		}
		return seismicSourceRange_5175Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshName_5176Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshName_5176Parser() {
		if (computationalMeshName_5176Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			computationalMeshName_5176Parser = parser;
		}
		return computationalMeshName_5176Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshDescription_5177Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshDescription_5177Parser() {
		if (computationalMeshDescription_5177Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			computationalMeshDescription_5177Parser = parser;
		}
		return computationalMeshDescription_5177Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshAccuracy_5178Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshAccuracy_5178Parser() {
		if (computationalMeshAccuracy_5178Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			computationalMeshAccuracy_5178Parser = parser;
		}
		return computationalMeshAccuracy_5178Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshFormat_5179Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshFormat_5179Parser() {
		if (computationalMeshFormat_5179Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			computationalMeshFormat_5179Parser = parser;
		}
		return computationalMeshFormat_5179Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshRange_5180Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshRange_5180Parser() {
		if (computationalMeshRange_5180Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			computationalMeshRange_5180Parser = parser;
		}
		return computationalMeshRange_5180Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramName_5181Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramName_5181Parser() {
		if (syntheticSeismogramName_5181Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			syntheticSeismogramName_5181Parser = parser;
		}
		return syntheticSeismogramName_5181Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramDescription_5182Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramDescription_5182Parser() {
		if (syntheticSeismogramDescription_5182Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			syntheticSeismogramDescription_5182Parser = parser;
		}
		return syntheticSeismogramDescription_5182Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramAccuracy_5183Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramAccuracy_5183Parser() {
		if (syntheticSeismogramAccuracy_5183Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			syntheticSeismogramAccuracy_5183Parser = parser;
		}
		return syntheticSeismogramAccuracy_5183Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramFormat_5184Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramFormat_5184Parser() {
		if (syntheticSeismogramFormat_5184Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			syntheticSeismogramFormat_5184Parser = parser;
		}
		return syntheticSeismogramFormat_5184Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramRange_5185Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramRange_5185Parser() {
		if (syntheticSeismogramRange_5185Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			syntheticSeismogramRange_5185Parser = parser;
		}
		return syntheticSeismogramRange_5185Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationName_5186Parser;

	/**
	 * @generated
	 */
	private IParser getStationName_5186Parser() {
		if (stationName_5186Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stationName_5186Parser = parser;
		}
		return stationName_5186Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationDescription_5187Parser;

	/**
	 * @generated
	 */
	private IParser getStationDescription_5187Parser() {
		if (stationDescription_5187Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stationDescription_5187Parser = parser;
		}
		return stationDescription_5187Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationAccuracy_5188Parser;

	/**
	 * @generated
	 */
	private IParser getStationAccuracy_5188Parser() {
		if (stationAccuracy_5188Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stationAccuracy_5188Parser = parser;
		}
		return stationAccuracy_5188Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationFormat_5189Parser;

	/**
	 * @generated
	 */
	private IParser getStationFormat_5189Parser() {
		if (stationFormat_5189Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stationFormat_5189Parser = parser;
		}
		return stationFormat_5189Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationRange_5190Parser;

	/**
	 * @generated
	 */
	private IParser getStationRange_5190Parser() {
		if (stationRange_5190Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			stationRange_5190Parser = parser;
		}
		return stationRange_5190Parser;
	}

	/**
	 * @generated
	 */
	private IParser controlParameterName_5191Parser;

	/**
	 * @generated
	 */
	private IParser getControlParameterName_5191Parser() {
		if (controlParameterName_5191Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			controlParameterName_5191Parser = parser;
		}
		return controlParameterName_5191Parser;
	}

	/**
	 * @generated
	 */
	private IParser controlParameterDescription_5192Parser;

	/**
	 * @generated
	 */
	private IParser getControlParameterDescription_5192Parser() {
		if (controlParameterDescription_5192Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			controlParameterDescription_5192Parser = parser;
		}
		return controlParameterDescription_5192Parser;
	}

	/**
	 * @generated
	 */
	private IParser controlParameterFormat_5193Parser;

	/**
	 * @generated
	 */
	private IParser getControlParameterFormat_5193Parser() {
		if (controlParameterFormat_5193Parser == null) {
			EAttribute[] features = new EAttribute[] { scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getControlParameter_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			controlParameterFormat_5193Parser = parser;
		}
		return controlParameterFormat_5193Parser;
	}

	/**
	 * @generated
	 */
	private IParser knowledgeSpaceName_5086Parser;

	/**
	 * @generated
	 */
	private IParser getKnowledgeSpaceName_5086Parser() {
		if (knowledgeSpaceName_5086Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			knowledgeSpaceName_5086Parser = parser;
		}
		return knowledgeSpaceName_5086Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementSpaceName_5140Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementSpaceName_5140Parser() {
		if (requirementSpaceName_5140Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementSpaceName_5140Parser = parser;
		}
		return requirementSpaceName_5140Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataProcessSpaceName_5142Parser;

	/**
	 * @generated
	 */
	private IParser getDataProcessSpaceName_5142Parser() {
		if (dataProcessSpaceName_5142Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataProcessSpaceName_5142Parser = parser;
		}
		return dataProcessSpaceName_5142Parser;
	}

	/**
	 * @generated
	 */
	private IParser scientificProblemName_5087Parser;

	/**
	 * @generated
	 */
	private IParser getScientificProblemName_5087Parser() {
		if (scientificProblemName_5087Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			scientificProblemName_5087Parser = parser;
		}
		return scientificProblemName_5087Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodName_5089Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodName_5089Parser() {
		if (numericalMethodName_5089Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			numericalMethodName_5089Parser = parser;
		}
		return numericalMethodName_5089Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematical_GeophysicalModelName_5194Parser;

	/**
	 * @generated
	 */
	private IParser getMathematical_GeophysicalModelName_5194Parser() {
		if (mathematical_GeophysicalModelName_5194Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mathematical_GeophysicalModelName_5194Parser = parser;
		}
		return mathematical_GeophysicalModelName_5194Parser;
	}

	/**
	 * @generated
	 */
	private IParser assumptionName_5097Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionName_5097Parser() {
		if (assumptionName_5097Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			assumptionName_5097Parser = parser;
		}
		return assumptionName_5097Parser;
	}

	/**
	 * @generated
	 */
	private IParser knowledgeSpaceName_5099Parser;

	/**
	 * @generated
	 */
	private IParser getKnowledgeSpaceName_5099Parser() {
		if (knowledgeSpaceName_5099Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			knowledgeSpaceName_5099Parser = parser;
		}
		return knowledgeSpaceName_5099Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementName_5120Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementName_5120Parser() {
		if (requirementName_5120Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementName_5120Parser = parser;
		}
		return requirementName_5120Parser;
	}

	/**
	 * @generated
	 */
	private IParser featureName_5110Parser;

	/**
	 * @generated
	 */
	private IParser getFeatureName_5110Parser() {
		if (featureName_5110Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5110Parser = parser;
		}
		return featureName_5110Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareName_5112Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareName_5112Parser() {
		if (hardwareName_5112Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			hardwareName_5112Parser = parser;
		}
		return hardwareName_5112Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5100Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5100Parser() {
		if (constraintName_5100Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5100Parser = parser;
		}
		return constraintName_5100Parser;
	}

	/**
	 * @generated
	 */
	private IParser userInterfaceName_5125Parser;

	/**
	 * @generated
	 */
	private IParser getUserInterfaceName_5125Parser() {
		if (userInterfaceName_5125Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			userInterfaceName_5125Parser = parser;
		}
		return userInterfaceName_5125Parser;
	}

	/**
	 * @generated
	 */
	private IParser softwareInterfaceName_5122Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceName_5122Parser() {
		if (softwareInterfaceName_5122Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			softwareInterfaceName_5122Parser = parser;
		}
		return softwareInterfaceName_5122Parser;
	}

	/**
	 * @generated
	 */
	private IParser performanceName_5117Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceName_5117Parser() {
		if (performanceName_5117Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			performanceName_5117Parser = parser;
		}
		return performanceName_5117Parser;
	}

	/**
	 * @generated
	 */
	private IParser processName_5147Parser;

	/**
	 * @generated
	 */
	private IParser getProcessName_5147Parser() {
		if (processName_5147Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			processName_5147Parser = parser;
		}
		return processName_5147Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingName_5149Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingName_5149Parser() {
		if (inputDataReadingName_5149Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputDataReadingName_5149Parser = parser;
		}
		return inputDataReadingName_5149Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputName_5145Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputName_5145Parser() {
		if (resultsOutputName_5145Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resultsOutputName_5145Parser = parser;
		}
		return resultsOutputName_5145Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingName_5151Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingName_5151Parser() {
		if (errorHandlingName_5151Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			errorHandlingName_5151Parser = parser;
		}
		return errorHandlingName_5151Parser;
	}

	/**
	 * @generated
	 */
	private IParser statusMonitoringName_5143Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringName_5143Parser() {
		if (statusMonitoringName_5143Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			statusMonitoringName_5143Parser = parser;
		}
		return statusMonitoringName_5143Parser;
	}

	/**
	 * @generated
	 */
	private IParser solverName_5196Parser;

	/**
	 * @generated
	 */
	private IParser getSolverName_5196Parser() {
		if (solverName_5196Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			solverName_5196Parser = parser;
		}
		return solverName_5196Parser;
	}

	/**
	 * @generated
	 */
	private IParser meshCreationName_5198Parser;

	/**
	 * @generated
	 */
	private IParser getMeshCreationName_5198Parser() {
		if (meshCreationName_5198Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			meshCreationName_5198Parser = parser;
		}
		return meshCreationName_5198Parser;
	}

	/**
	 * @generated
	 */
	private IParser preProcessingName_5200Parser;

	/**
	 * @generated
	 */
	private IParser getPreProcessingName_5200Parser() {
		if (preProcessingName_5200Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			preProcessingName_5200Parser = parser;
		}
		return preProcessingName_5200Parser;
	}

	/**
	 * @generated
	 */
	private IParser postProcessingName_5202Parser;

	/**
	 * @generated
	 */
	private IParser getPostProcessingName_5202Parser() {
		if (postProcessingName_5202Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			postProcessingName_5202Parser = parser;
		}
		return postProcessingName_5202Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionName_5204Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionName_5204Parser() {
		if (dataDefinitionName_5204Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataDefinitionName_5204Parser = parser;
		}
		return dataDefinitionName_5204Parser;
	}

	/**
	 * @generated
	 */
	private IParser seismicSourceName_5209Parser;

	/**
	 * @generated
	 */
	private IParser getSeismicSourceName_5209Parser() {
		if (seismicSourceName_5209Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			seismicSourceName_5209Parser = parser;
		}
		return seismicSourceName_5209Parser;
	}

	/**
	 * @generated
	 */
	private IParser computationalMeshName_5214Parser;

	/**
	 * @generated
	 */
	private IParser getComputationalMeshName_5214Parser() {
		if (computationalMeshName_5214Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			computationalMeshName_5214Parser = parser;
		}
		return computationalMeshName_5214Parser;
	}

	/**
	 * @generated
	 */
	private IParser syntheticSeismogramName_5219Parser;

	/**
	 * @generated
	 */
	private IParser getSyntheticSeismogramName_5219Parser() {
		if (syntheticSeismogramName_5219Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			syntheticSeismogramName_5219Parser = parser;
		}
		return syntheticSeismogramName_5219Parser;
	}

	/**
	 * @generated
	 */
	private IParser stationName_5224Parser;

	/**
	 * @generated
	 */
	private IParser getStationName_5224Parser() {
		if (stationName_5224Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stationName_5224Parser = parser;
		}
		return stationName_5224Parser;
	}

	/**
	 * @generated
	 */
	private IParser controlParameterName_5229Parser;

	/**
	 * @generated
	 */
	private IParser getControlParameterName_5229Parser() {
		if (controlParameterName_5229Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			controlParameterName_5229Parser = parser;
		}
		return controlParameterName_5229Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementSpaceName_5139Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementSpaceName_5139Parser() {
		if (requirementSpaceName_5139Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementSpaceName_5139Parser = parser;
		}
		return requirementSpaceName_5139Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataProcessSpaceName_5155Parser;

	/**
	 * @generated
	 */
	private IParser getDataProcessSpaceName_5155Parser() {
		if (dataProcessSpaceName_5155Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataProcessSpaceName_5155Parser = parser;
		}
		return dataProcessSpaceName_5155Parser;
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
		case Mathematical_GeophysicalModelNameEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelName_5156Parser();
		case Mathematical_GeophysicalModelDescriptionEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelDescription_5157Parser();
		case NumericalMethodNameEditPart.VISUAL_ID:
			return getNumericalMethodName_5002Parser();
		case NumericalMethodDescriptionEditPart.VISUAL_ID:
			return getNumericalMethodDescription_5023Parser();
		case AssumptionNameEditPart.VISUAL_ID:
			return getAssumptionName_5004Parser();
		case AssumptionDescriptionEditPart.VISUAL_ID:
			return getAssumptionDescription_5026Parser();
		case RequirementNameEditPart.VISUAL_ID:
			return getRequirementName_5072Parser();
		case RequirementDescriptionEditPart.VISUAL_ID:
			return getRequirementDescription_5073Parser();
		case FeatureNameEditPart.VISUAL_ID:
			return getFeatureName_5005Parser();
		case FeatureDescriptionEditPart.VISUAL_ID:
			return getFeatureDescription_5027Parser();
		case HardwareNameEditPart.VISUAL_ID:
			return getHardwareName_5006Parser();
		case HardwareDescriptionEditPart.VISUAL_ID:
			return getHardwareDescription_5028Parser();
		case HardwareProcessorEditPart.VISUAL_ID:
			return getHardwareProcessor_5029Parser();
		case HardwarePlatformEditPart.VISUAL_ID:
			return getHardwarePlatform_5030Parser();
		case HardwareMemoryEditPart.VISUAL_ID:
			return getHardwareMemory_5031Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5007Parser();
		case ConstraintDescriptionEditPart.VISUAL_ID:
			return getConstraintDescription_5032Parser();
		case UserInterfaceNameEditPart.VISUAL_ID:
			return getUserInterfaceName_5008Parser();
		case UserInterfaceDescriptionEditPart.VISUAL_ID:
			return getUserInterfaceDescription_5033Parser();
		case SoftwareInterfaceNameEditPart.VISUAL_ID:
			return getSoftwareInterfaceName_5009Parser();
		case SoftwareInterfaceDescriptionEditPart.VISUAL_ID:
			return getSoftwareInterfaceDescription_5034Parser();
		case PerformanceNameEditPart.VISUAL_ID:
			return getPerformanceName_5011Parser();
		case PerformanceDescriptionEditPart.VISUAL_ID:
			return getPerformanceDescription_5037Parser();
		case ProcessNameEditPart.VISUAL_ID:
			return getProcessName_5074Parser();
		case ProcessDescriptionEditPart.VISUAL_ID:
			return getProcessDescription_5075Parser();
		case InputDataReadingNameEditPart.VISUAL_ID:
			return getInputDataReadingName_5076Parser();
		case InputDataReadingDescriptionEditPart.VISUAL_ID:
			return getInputDataReadingDescription_5077Parser();
		case ResultsOutputNameEditPart.VISUAL_ID:
			return getResultsOutputName_5080Parser();
		case ResultsOutputDescriptionEditPart.VISUAL_ID:
			return getResultsOutputDescription_5081Parser();
		case ErrorHandlingNameEditPart.VISUAL_ID:
			return getErrorHandlingName_5082Parser();
		case ErrorHandlingDescriptionEditPart.VISUAL_ID:
			return getErrorHandlingDescription_5083Parser();
		case StatusMonitoringNameEditPart.VISUAL_ID:
			return getStatusMonitoringName_5084Parser();
		case StatusMonitoringDescriptionEditPart.VISUAL_ID:
			return getStatusMonitoringDescription_5085Parser();
		case SolverNameEditPart.VISUAL_ID:
			return getSolverName_5158Parser();
		case SolverDescriptionEditPart.VISUAL_ID:
			return getSolverDescription_5159Parser();
		case MeshCreationNameEditPart.VISUAL_ID:
			return getMeshCreationName_5160Parser();
		case MeshCreationDescriptionEditPart.VISUAL_ID:
			return getMeshCreationDescription_5161Parser();
		case PreProcessingNameEditPart.VISUAL_ID:
			return getPreProcessingName_5162Parser();
		case PreProcessingDescriptionEditPart.VISUAL_ID:
			return getPreProcessingDescription_5163Parser();
		case PostProcessingNameEditPart.VISUAL_ID:
			return getPostProcessingName_5164Parser();
		case PostProcessingDescriptionEditPart.VISUAL_ID:
			return getPostProcessingDescription_5165Parser();
		case DataDefinitionNameEditPart.VISUAL_ID:
			return getDataDefinitionName_5166Parser();
		case DataDefinitionDescriptionEditPart.VISUAL_ID:
			return getDataDefinitionDescription_5167Parser();
		case DataDefinitionAccuracyEditPart.VISUAL_ID:
			return getDataDefinitionAccuracy_5168Parser();
		case DataDefinitionFormatEditPart.VISUAL_ID:
			return getDataDefinitionFormat_5169Parser();
		case DataDefinitionRangeEditPart.VISUAL_ID:
			return getDataDefinitionRange_5170Parser();
		case SeismicSourceNameEditPart.VISUAL_ID:
			return getSeismicSourceName_5171Parser();
		case SeismicSourceDescriptionEditPart.VISUAL_ID:
			return getSeismicSourceDescription_5172Parser();
		case SeismicSourceAccuracyEditPart.VISUAL_ID:
			return getSeismicSourceAccuracy_5173Parser();
		case SeismicSourceFormatEditPart.VISUAL_ID:
			return getSeismicSourceFormat_5174Parser();
		case SeismicSourceRangeEditPart.VISUAL_ID:
			return getSeismicSourceRange_5175Parser();
		case ComputationalMeshNameEditPart.VISUAL_ID:
			return getComputationalMeshName_5176Parser();
		case ComputationalMeshDescriptionEditPart.VISUAL_ID:
			return getComputationalMeshDescription_5177Parser();
		case ComputationalMeshAccuracyEditPart.VISUAL_ID:
			return getComputationalMeshAccuracy_5178Parser();
		case ComputationalMeshFormatEditPart.VISUAL_ID:
			return getComputationalMeshFormat_5179Parser();
		case ComputationalMeshRangeEditPart.VISUAL_ID:
			return getComputationalMeshRange_5180Parser();
		case SyntheticSeismogramNameEditPart.VISUAL_ID:
			return getSyntheticSeismogramName_5181Parser();
		case SyntheticSeismogramDescriptionEditPart.VISUAL_ID:
			return getSyntheticSeismogramDescription_5182Parser();
		case SyntheticSeismogramAccuracyEditPart.VISUAL_ID:
			return getSyntheticSeismogramAccuracy_5183Parser();
		case SyntheticSeismogramFormatEditPart.VISUAL_ID:
			return getSyntheticSeismogramFormat_5184Parser();
		case SyntheticSeismogramRangeEditPart.VISUAL_ID:
			return getSyntheticSeismogramRange_5185Parser();
		case StationNameEditPart.VISUAL_ID:
			return getStationName_5186Parser();
		case StationDescriptionEditPart.VISUAL_ID:
			return getStationDescription_5187Parser();
		case StationAccuracyEditPart.VISUAL_ID:
			return getStationAccuracy_5188Parser();
		case StationFormatEditPart.VISUAL_ID:
			return getStationFormat_5189Parser();
		case StationRangeEditPart.VISUAL_ID:
			return getStationRange_5190Parser();
		case ControlParameterNameEditPart.VISUAL_ID:
			return getControlParameterName_5191Parser();
		case ControlParameterDescriptionEditPart.VISUAL_ID:
			return getControlParameterDescription_5192Parser();
		case ControlParameterFormatEditPart.VISUAL_ID:
			return getControlParameterFormat_5193Parser();
		case KnowledgeSpaceNameEditPart.VISUAL_ID:
			return getKnowledgeSpaceName_5086Parser();
		case RequirementSpaceNameEditPart.VISUAL_ID:
			return getRequirementSpaceName_5140Parser();
		case DataProcessSpaceNameEditPart.VISUAL_ID:
			return getDataProcessSpaceName_5142Parser();
		case ScientificProblemName2EditPart.VISUAL_ID:
			return getScientificProblemName_5087Parser();
		case NumericalMethodName2EditPart.VISUAL_ID:
			return getNumericalMethodName_5089Parser();
		case Mathematical_GeophysicalModelName2EditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelName_5194Parser();
		case AssumptionName2EditPart.VISUAL_ID:
			return getAssumptionName_5097Parser();
		case KnowledgeSpaceName2EditPart.VISUAL_ID:
			return getKnowledgeSpaceName_5099Parser();
		case RequirementName2EditPart.VISUAL_ID:
			return getRequirementName_5120Parser();
		case FeatureName2EditPart.VISUAL_ID:
			return getFeatureName_5110Parser();
		case HardwareName2EditPart.VISUAL_ID:
			return getHardwareName_5112Parser();
		case ConstraintName2EditPart.VISUAL_ID:
			return getConstraintName_5100Parser();
		case UserInterfaceName2EditPart.VISUAL_ID:
			return getUserInterfaceName_5125Parser();
		case SoftwareInterfaceName2EditPart.VISUAL_ID:
			return getSoftwareInterfaceName_5122Parser();
		case PerformanceName2EditPart.VISUAL_ID:
			return getPerformanceName_5117Parser();
		case ProcessName2EditPart.VISUAL_ID:
			return getProcessName_5147Parser();
		case InputDataReadingName2EditPart.VISUAL_ID:
			return getInputDataReadingName_5149Parser();
		case ResultsOutputName2EditPart.VISUAL_ID:
			return getResultsOutputName_5145Parser();
		case ErrorHandlingName2EditPart.VISUAL_ID:
			return getErrorHandlingName_5151Parser();
		case StatusMonitoringName2EditPart.VISUAL_ID:
			return getStatusMonitoringName_5143Parser();
		case SolverName2EditPart.VISUAL_ID:
			return getSolverName_5196Parser();
		case MeshCreationName2EditPart.VISUAL_ID:
			return getMeshCreationName_5198Parser();
		case PreProcessingName2EditPart.VISUAL_ID:
			return getPreProcessingName_5200Parser();
		case PostProcessingName2EditPart.VISUAL_ID:
			return getPostProcessingName_5202Parser();
		case DataDefinitionName2EditPart.VISUAL_ID:
			return getDataDefinitionName_5204Parser();
		case SeismicSourceName2EditPart.VISUAL_ID:
			return getSeismicSourceName_5209Parser();
		case ComputationalMeshName2EditPart.VISUAL_ID:
			return getComputationalMeshName_5214Parser();
		case SyntheticSeismogramName2EditPart.VISUAL_ID:
			return getSyntheticSeismogramName_5219Parser();
		case StationName2EditPart.VISUAL_ID:
			return getStationName_5224Parser();
		case ControlParameterName2EditPart.VISUAL_ID:
			return getControlParameterName_5229Parser();
		case RequirementSpaceName2EditPart.VISUAL_ID:
			return getRequirementSpaceName_5139Parser();
		case DataProcessSpaceName2EditPart.VISUAL_ID:
			return getDataProcessSpaceName_5155Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
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
