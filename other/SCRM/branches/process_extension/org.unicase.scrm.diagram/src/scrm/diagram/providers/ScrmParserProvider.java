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
import scrm.diagram.edit.parts.AssumptionDescriptionEditPart;
import scrm.diagram.edit.parts.AssumptionName2EditPart;
import scrm.diagram.edit.parts.AssumptionNameEditPart;
import scrm.diagram.edit.parts.ConstraintDescriptionEditPart;
import scrm.diagram.edit.parts.ConstraintNameEditPart;
import scrm.diagram.edit.parts.DataDefinitionAccuracyEditPart;
import scrm.diagram.edit.parts.DataDefinitionDataTypeEditPart;
import scrm.diagram.edit.parts.DataDefinitionDescriptionEditPart;
import scrm.diagram.edit.parts.DataDefinitionFormatEditPart;
import scrm.diagram.edit.parts.DataDefinitionNameEditPart;
import scrm.diagram.edit.parts.DataDefinitionRangeEditPart;
import scrm.diagram.edit.parts.DataFlowDescriptionEditPart;
import scrm.diagram.edit.parts.DataFlowNameEditPart;
import scrm.diagram.edit.parts.DataHandlingDescriptionEditPart;
import scrm.diagram.edit.parts.DataHandlingNameEditPart;
import scrm.diagram.edit.parts.ErrorHandlingDescriptionEditPart;
import scrm.diagram.edit.parts.ErrorHandlingNameEditPart;
import scrm.diagram.edit.parts.FeatureDescriptionEditPart;
import scrm.diagram.edit.parts.FeatureNameEditPart;
import scrm.diagram.edit.parts.HardwareDescriptionEditPart;
import scrm.diagram.edit.parts.HardwareMemoryEditPart;
import scrm.diagram.edit.parts.HardwareNameEditPart;
import scrm.diagram.edit.parts.HardwarePlatformEditPart;
import scrm.diagram.edit.parts.HardwareProcessorEditPart;
import scrm.diagram.edit.parts.InputDataReadingDescriptionEditPart;
import scrm.diagram.edit.parts.InputDataReadingNameEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceName2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceNameEditPart;
import scrm.diagram.edit.parts.MathematicalModelDescriptionEditPart;
import scrm.diagram.edit.parts.MathematicalModelMathematicalExpressionEditPart;
import scrm.diagram.edit.parts.MathematicalModelName2EditPart;
import scrm.diagram.edit.parts.MathematicalModelNameEditPart;
import scrm.diagram.edit.parts.MathematicalModelTheoryEditPart;
import scrm.diagram.edit.parts.NumericalMethodAlgorithmEditPart;
import scrm.diagram.edit.parts.NumericalMethodDescriptionEditPart;
import scrm.diagram.edit.parts.NumericalMethodName2EditPart;
import scrm.diagram.edit.parts.NumericalMethodNameEditPart;
import scrm.diagram.edit.parts.NumericalMethodTheoryEditPart;
import scrm.diagram.edit.parts.PerformanceDescriptionEditPart;
import scrm.diagram.edit.parts.PerformanceNameEditPart;
import scrm.diagram.edit.parts.PerformanceProblemSizeEditPart;
import scrm.diagram.edit.parts.ProcessDescriptionEditPart;
import scrm.diagram.edit.parts.ProcessNameEditPart;
import scrm.diagram.edit.parts.RequirementDescriptionEditPart;
import scrm.diagram.edit.parts.RequirementNameEditPart;
import scrm.diagram.edit.parts.ResultsOutputDescriptionEditPart;
import scrm.diagram.edit.parts.ResultsOutputNameEditPart;
import scrm.diagram.edit.parts.ScientificProblemDescriptionEditPart;
import scrm.diagram.edit.parts.ScientificProblemName2EditPart;
import scrm.diagram.edit.parts.ScientificProblemNameEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceDataTypesEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceDescriptionEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceNameEditPart;
import scrm.diagram.edit.parts.StatusMonitoringDescriptionEditPart;
import scrm.diagram.edit.parts.StatusMonitoringNameEditPart;
import scrm.diagram.edit.parts.UserInterfaceDescriptionEditPart;
import scrm.diagram.edit.parts.UserInterfaceNameEditPart;
import scrm.diagram.parsers.MessageFormatParser;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.knowledge.KnowledgePackage;
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
	private IParser mathematicalModelName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelName_5001Parser() {
		if (mathematicalModelName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mathematicalModelName_5001Parser = parser;
		}
		return mathematicalModelName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelDescription_5020Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelDescription_5020Parser() {
		if (mathematicalModelDescription_5020Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelDescription_5020Parser = parser;
		}
		return mathematicalModelDescription_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelTheory_5021Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelTheory_5021Parser() {
		if (mathematicalModelTheory_5021Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getMathematicalModel_Theory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Theory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelTheory_5021Parser = parser;
		}
		return mathematicalModelTheory_5021Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelMathematicalExpression_5022Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelMathematicalExpression_5022Parser() {
		if (mathematicalModelMathematicalExpression_5022Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getMathematicalModel_MathematicalExpression() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Mathematical Expression: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelMathematicalExpression_5022Parser = parser;
		}
		return mathematicalModelMathematicalExpression_5022Parser;
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
	private IParser numericalMethodTheory_5024Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodTheory_5024Parser() {
		if (numericalMethodTheory_5024Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getNumericalMethod_Theory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Theory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodTheory_5024Parser = parser;
		}
		return numericalMethodTheory_5024Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodAlgorithm_5025Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodAlgorithm_5025Parser() {
		if (numericalMethodAlgorithm_5025Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getNumericalMethod_Algorithm() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Algorithm: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodAlgorithm_5025Parser = parser;
		}
		return numericalMethodAlgorithm_5025Parser;
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
	private IParser softwareInterfaceDataTypes_5035Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceDataTypes_5035Parser() {
		if (softwareInterfaceDataTypes_5035Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getSoftwareInterface_DataTypes() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Data Types: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			softwareInterfaceDataTypes_5035Parser = parser;
		}
		return softwareInterfaceDataTypes_5035Parser;
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
	private IParser performanceProblemSize_5038Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceProblemSize_5038Parser() {
		if (performanceProblemSize_5038Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getPerformance_ProblemSize() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Problem Size: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			performanceProblemSize_5038Parser = parser;
		}
		return performanceProblemSize_5038Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataFlowName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getDataFlowName_5012Parser() {
		if (dataFlowName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataFlowName_5012Parser = parser;
		}
		return dataFlowName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataFlowDescription_5039Parser;

	/**
	 * @generated
	 */
	private IParser getDataFlowDescription_5039Parser() {
		if (dataFlowDescription_5039Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataFlowDescription_5039Parser = parser;
		}
		return dataFlowDescription_5039Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionName_5013Parser() {
		if (dataDefinitionName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataDefinitionName_5013Parser = parser;
		}
		return dataDefinitionName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDescription_5040Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDescription_5040Parser() {
		if (dataDefinitionDescription_5040Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionDescription_5040Parser = parser;
		}
		return dataDefinitionDescription_5040Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionAccuracy_5041Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionAccuracy_5041Parser() {
		if (dataDefinitionAccuracy_5041Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionAccuracy_5041Parser = parser;
		}
		return dataDefinitionAccuracy_5041Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionFormat_5042Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionFormat_5042Parser() {
		if (dataDefinitionFormat_5042Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionFormat_5042Parser = parser;
		}
		return dataDefinitionFormat_5042Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionRange_5043Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionRange_5043Parser() {
		if (dataDefinitionRange_5043Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionRange_5043Parser = parser;
		}
		return dataDefinitionRange_5043Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDataType_5044Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDataType_5044Parser() {
		if (dataDefinitionDataType_5044Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_DataType() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Data Type: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionDataType_5044Parser = parser;
		}
		return dataDefinitionDataType_5044Parser;
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
	private IParser dataHandlingName_5078Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingName_5078Parser() {
		if (dataHandlingName_5078Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataHandlingName_5078Parser = parser;
		}
		return dataHandlingName_5078Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingDescription_5079Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingDescription_5079Parser() {
		if (dataHandlingDescription_5079Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataHandlingDescription_5079Parser = parser;
		}
		return dataHandlingDescription_5079Parser;
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
	private IParser scientificProblemDescription_5088Parser;

	/**
	 * @generated
	 */
	private IParser getScientificProblemDescription_5088Parser() {
		if (scientificProblemDescription_5088Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			scientificProblemDescription_5088Parser = parser;
		}
		return scientificProblemDescription_5088Parser;
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
	private IParser numericalMethodDescription_5090Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodDescription_5090Parser() {
		if (numericalMethodDescription_5090Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodDescription_5090Parser = parser;
		}
		return numericalMethodDescription_5090Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodTheory_5091Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodTheory_5091Parser() {
		if (numericalMethodTheory_5091Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getNumericalMethod_Theory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Theory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodTheory_5091Parser = parser;
		}
		return numericalMethodTheory_5091Parser;
	}

	/**
	 * @generated
	 */
	private IParser numericalMethodAlgorithm_5092Parser;

	/**
	 * @generated
	 */
	private IParser getNumericalMethodAlgorithm_5092Parser() {
		if (numericalMethodAlgorithm_5092Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getNumericalMethod_Algorithm() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Algorithm: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			numericalMethodAlgorithm_5092Parser = parser;
		}
		return numericalMethodAlgorithm_5092Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelName_5093Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelName_5093Parser() {
		if (mathematicalModelName_5093Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mathematicalModelName_5093Parser = parser;
		}
		return mathematicalModelName_5093Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelDescription_5094Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelDescription_5094Parser() {
		if (mathematicalModelDescription_5094Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelDescription_5094Parser = parser;
		}
		return mathematicalModelDescription_5094Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelTheory_5095Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelTheory_5095Parser() {
		if (mathematicalModelTheory_5095Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getMathematicalModel_Theory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Theory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelTheory_5095Parser = parser;
		}
		return mathematicalModelTheory_5095Parser;
	}

	/**
	 * @generated
	 */
	private IParser mathematicalModelMathematicalExpression_5096Parser;

	/**
	 * @generated
	 */
	private IParser getMathematicalModelMathematicalExpression_5096Parser() {
		if (mathematicalModelMathematicalExpression_5096Parser == null) {
			EAttribute[] features = new EAttribute[] { KnowledgePackage.eINSTANCE
					.getMathematicalModel_MathematicalExpression() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Mathematical Expression: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mathematicalModelMathematicalExpression_5096Parser = parser;
		}
		return mathematicalModelMathematicalExpression_5096Parser;
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
	private IParser assumptionDescription_5098Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionDescription_5098Parser() {
		if (assumptionDescription_5098Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			assumptionDescription_5098Parser = parser;
		}
		return assumptionDescription_5098Parser;
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
	private IParser constraintDescription_5101Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintDescription_5101Parser() {
		if (constraintDescription_5101Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraintDescription_5101Parser = parser;
		}
		return constraintDescription_5101Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionName_5102Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionName_5102Parser() {
		if (dataDefinitionName_5102Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataDefinitionName_5102Parser = parser;
		}
		return dataDefinitionName_5102Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDescription_5103Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDescription_5103Parser() {
		if (dataDefinitionDescription_5103Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionDescription_5103Parser = parser;
		}
		return dataDefinitionDescription_5103Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionAccuracy_5104Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionAccuracy_5104Parser() {
		if (dataDefinitionAccuracy_5104Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Accuracy() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Accuracy: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionAccuracy_5104Parser = parser;
		}
		return dataDefinitionAccuracy_5104Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionFormat_5105Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionFormat_5105Parser() {
		if (dataDefinitionFormat_5105Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Format() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Format: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionFormat_5105Parser = parser;
		}
		return dataDefinitionFormat_5105Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionRange_5106Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionRange_5106Parser() {
		if (dataDefinitionRange_5106Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_Range() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Range: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionRange_5106Parser = parser;
		}
		return dataDefinitionRange_5106Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataDefinitionDataType_5107Parser;

	/**
	 * @generated
	 */
	private IParser getDataDefinitionDataType_5107Parser() {
		if (dataDefinitionDataType_5107Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getDataDefinition_DataType() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Data Type: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataDefinitionDataType_5107Parser = parser;
		}
		return dataDefinitionDataType_5107Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataFlowName_5108Parser;

	/**
	 * @generated
	 */
	private IParser getDataFlowName_5108Parser() {
		if (dataFlowName_5108Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataFlowName_5108Parser = parser;
		}
		return dataFlowName_5108Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataFlowDescription_5109Parser;

	/**
	 * @generated
	 */
	private IParser getDataFlowDescription_5109Parser() {
		if (dataFlowDescription_5109Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataFlowDescription_5109Parser = parser;
		}
		return dataFlowDescription_5109Parser;
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
	private IParser hardwareDescription_5113Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareDescription_5113Parser() {
		if (hardwareDescription_5113Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareDescription_5113Parser = parser;
		}
		return hardwareDescription_5113Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareProcessor_5114Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareProcessor_5114Parser() {
		if (hardwareProcessor_5114Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Processor() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Processor: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareProcessor_5114Parser = parser;
		}
		return hardwareProcessor_5114Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwarePlatform_5115Parser;

	/**
	 * @generated
	 */
	private IParser getHardwarePlatform_5115Parser() {
		if (hardwarePlatform_5115Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Platform() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Platform: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwarePlatform_5115Parser = parser;
		}
		return hardwarePlatform_5115Parser;
	}

	/**
	 * @generated
	 */
	private IParser hardwareMemory_5116Parser;

	/**
	 * @generated
	 */
	private IParser getHardwareMemory_5116Parser() {
		if (hardwareMemory_5116Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getHardware_Memory() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Memory: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			hardwareMemory_5116Parser = parser;
		}
		return hardwareMemory_5116Parser;
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
	private IParser performanceDescription_5118Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceDescription_5118Parser() {
		if (performanceDescription_5118Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			performanceDescription_5118Parser = parser;
		}
		return performanceDescription_5118Parser;
	}

	/**
	 * @generated
	 */
	private IParser performanceProblemSize_5119Parser;

	/**
	 * @generated
	 */
	private IParser getPerformanceProblemSize_5119Parser() {
		if (performanceProblemSize_5119Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getPerformance_ProblemSize() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Problem Size: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			performanceProblemSize_5119Parser = parser;
		}
		return performanceProblemSize_5119Parser;
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
	private IParser requirementDescription_5121Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementDescription_5121Parser() {
		if (requirementDescription_5121Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementDescription_5121Parser = parser;
		}
		return requirementDescription_5121Parser;
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
	private IParser softwareInterfaceDescription_5123Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceDescription_5123Parser() {
		if (softwareInterfaceDescription_5123Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			softwareInterfaceDescription_5123Parser = parser;
		}
		return softwareInterfaceDescription_5123Parser;
	}

	/**
	 * @generated
	 */
	private IParser softwareInterfaceDataTypes_5124Parser;

	/**
	 * @generated
	 */
	private IParser getSoftwareInterfaceDataTypes_5124Parser() {
		if (softwareInterfaceDataTypes_5124Parser == null) {
			EAttribute[] features = new EAttribute[] { RequirementsPackage.eINSTANCE
					.getSoftwareInterface_DataTypes() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Data Types: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			softwareInterfaceDataTypes_5124Parser = parser;
		}
		return softwareInterfaceDataTypes_5124Parser;
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
	private IParser userInterfaceDescription_5126Parser;

	/**
	 * @generated
	 */
	private IParser getUserInterfaceDescription_5126Parser() {
		if (userInterfaceDescription_5126Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			userInterfaceDescription_5126Parser = parser;
		}
		return userInterfaceDescription_5126Parser;
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
	private IParser statusMonitoringDescription_5144Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringDescription_5144Parser() {
		if (statusMonitoringDescription_5144Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			statusMonitoringDescription_5144Parser = parser;
		}
		return statusMonitoringDescription_5144Parser;
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
	private IParser resultsOutputDescription_5146Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputDescription_5146Parser() {
		if (resultsOutputDescription_5146Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			resultsOutputDescription_5146Parser = parser;
		}
		return resultsOutputDescription_5146Parser;
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
	private IParser processDescription_5148Parser;

	/**
	 * @generated
	 */
	private IParser getProcessDescription_5148Parser() {
		if (processDescription_5148Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			processDescription_5148Parser = parser;
		}
		return processDescription_5148Parser;
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
	private IParser inputDataReadingDescription_5150Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingDescription_5150Parser() {
		if (inputDataReadingDescription_5150Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			inputDataReadingDescription_5150Parser = parser;
		}
		return inputDataReadingDescription_5150Parser;
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
	private IParser errorHandlingDescription_5152Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingDescription_5152Parser() {
		if (errorHandlingDescription_5152Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			errorHandlingDescription_5152Parser = parser;
		}
		return errorHandlingDescription_5152Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingName_5153Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingName_5153Parser() {
		if (dataHandlingName_5153Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataHandlingName_5153Parser = parser;
		}
		return dataHandlingName_5153Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingDescription_5154Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingDescription_5154Parser() {
		if (dataHandlingDescription_5154Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataHandlingDescription_5154Parser = parser;
		}
		return dataHandlingDescription_5154Parser;
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
	private IParser statusMonitoringName_5127Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringName_5127Parser() {
		if (statusMonitoringName_5127Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			statusMonitoringName_5127Parser = parser;
		}
		return statusMonitoringName_5127Parser;
	}

	/**
	 * @generated
	 */
	private IParser statusMonitoringDescription_5128Parser;

	/**
	 * @generated
	 */
	private IParser getStatusMonitoringDescription_5128Parser() {
		if (statusMonitoringDescription_5128Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			statusMonitoringDescription_5128Parser = parser;
		}
		return statusMonitoringDescription_5128Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputName_5129Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputName_5129Parser() {
		if (resultsOutputName_5129Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resultsOutputName_5129Parser = parser;
		}
		return resultsOutputName_5129Parser;
	}

	/**
	 * @generated
	 */
	private IParser resultsOutputDescription_5130Parser;

	/**
	 * @generated
	 */
	private IParser getResultsOutputDescription_5130Parser() {
		if (resultsOutputDescription_5130Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			resultsOutputDescription_5130Parser = parser;
		}
		return resultsOutputDescription_5130Parser;
	}

	/**
	 * @generated
	 */
	private IParser processName_5131Parser;

	/**
	 * @generated
	 */
	private IParser getProcessName_5131Parser() {
		if (processName_5131Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			processName_5131Parser = parser;
		}
		return processName_5131Parser;
	}

	/**
	 * @generated
	 */
	private IParser processDescription_5132Parser;

	/**
	 * @generated
	 */
	private IParser getProcessDescription_5132Parser() {
		if (processDescription_5132Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			processDescription_5132Parser = parser;
		}
		return processDescription_5132Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingName_5133Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingName_5133Parser() {
		if (inputDataReadingName_5133Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputDataReadingName_5133Parser = parser;
		}
		return inputDataReadingName_5133Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputDataReadingDescription_5134Parser;

	/**
	 * @generated
	 */
	private IParser getInputDataReadingDescription_5134Parser() {
		if (inputDataReadingDescription_5134Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			inputDataReadingDescription_5134Parser = parser;
		}
		return inputDataReadingDescription_5134Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingName_5135Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingName_5135Parser() {
		if (errorHandlingName_5135Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			errorHandlingName_5135Parser = parser;
		}
		return errorHandlingName_5135Parser;
	}

	/**
	 * @generated
	 */
	private IParser errorHandlingDescription_5136Parser;

	/**
	 * @generated
	 */
	private IParser getErrorHandlingDescription_5136Parser() {
		if (errorHandlingDescription_5136Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			errorHandlingDescription_5136Parser = parser;
		}
		return errorHandlingDescription_5136Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingName_5137Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingName_5137Parser() {
		if (dataHandlingName_5137Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataHandlingName_5137Parser = parser;
		}
		return dataHandlingName_5137Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataHandlingDescription_5138Parser;

	/**
	 * @generated
	 */
	private IParser getDataHandlingDescription_5138Parser() {
		if (dataHandlingDescription_5138Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Description: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			dataHandlingDescription_5138Parser = parser;
		}
		return dataHandlingDescription_5138Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataProcessSpaceName_5141Parser;

	/**
	 * @generated
	 */
	private IParser getDataProcessSpaceName_5141Parser() {
		if (dataProcessSpaceName_5141Parser == null) {
			EAttribute[] features = new EAttribute[] { ScrmPackage.eINSTANCE
					.getSCRMModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataProcessSpaceName_5141Parser = parser;
		}
		return dataProcessSpaceName_5141Parser;
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
		case MathematicalModelNameEditPart.VISUAL_ID:
			return getMathematicalModelName_5001Parser();
		case MathematicalModelDescriptionEditPart.VISUAL_ID:
			return getMathematicalModelDescription_5020Parser();
		case MathematicalModelTheoryEditPart.VISUAL_ID:
			return getMathematicalModelTheory_5021Parser();
		case MathematicalModelMathematicalExpressionEditPart.VISUAL_ID:
			return getMathematicalModelMathematicalExpression_5022Parser();
		case NumericalMethodNameEditPart.VISUAL_ID:
			return getNumericalMethodName_5002Parser();
		case NumericalMethodDescriptionEditPart.VISUAL_ID:
			return getNumericalMethodDescription_5023Parser();
		case NumericalMethodTheoryEditPart.VISUAL_ID:
			return getNumericalMethodTheory_5024Parser();
		case NumericalMethodAlgorithmEditPart.VISUAL_ID:
			return getNumericalMethodAlgorithm_5025Parser();
		case AssumptionNameEditPart.VISUAL_ID:
			return getAssumptionName_5004Parser();
		case AssumptionDescriptionEditPart.VISUAL_ID:
			return getAssumptionDescription_5026Parser();
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
		case SoftwareInterfaceDataTypesEditPart.VISUAL_ID:
			return getSoftwareInterfaceDataTypes_5035Parser();
		case ProcessNameEditPart.VISUAL_ID:
			return getProcessName_5074Parser();
		case ProcessDescriptionEditPart.VISUAL_ID:
			return getProcessDescription_5075Parser();
		case PerformanceNameEditPart.VISUAL_ID:
			return getPerformanceName_5011Parser();
		case PerformanceDescriptionEditPart.VISUAL_ID:
			return getPerformanceDescription_5037Parser();
		case PerformanceProblemSizeEditPart.VISUAL_ID:
			return getPerformanceProblemSize_5038Parser();
		case DataFlowNameEditPart.VISUAL_ID:
			return getDataFlowName_5012Parser();
		case DataFlowDescriptionEditPart.VISUAL_ID:
			return getDataFlowDescription_5039Parser();
		case DataDefinitionNameEditPart.VISUAL_ID:
			return getDataDefinitionName_5013Parser();
		case DataDefinitionDescriptionEditPart.VISUAL_ID:
			return getDataDefinitionDescription_5040Parser();
		case DataDefinitionAccuracyEditPart.VISUAL_ID:
			return getDataDefinitionAccuracy_5041Parser();
		case DataDefinitionFormatEditPart.VISUAL_ID:
			return getDataDefinitionFormat_5042Parser();
		case DataDefinitionRangeEditPart.VISUAL_ID:
			return getDataDefinitionRange_5043Parser();
		case DataDefinitionDataTypeEditPart.VISUAL_ID:
			return getDataDefinitionDataType_5044Parser();
		case InputDataReadingNameEditPart.VISUAL_ID:
			return getInputDataReadingName_5076Parser();
		case InputDataReadingDescriptionEditPart.VISUAL_ID:
			return getInputDataReadingDescription_5077Parser();
		case DataHandlingNameEditPart.VISUAL_ID:
			return getDataHandlingName_5078Parser();
		case DataHandlingDescriptionEditPart.VISUAL_ID:
			return getDataHandlingDescription_5079Parser();
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
		case RequirementNameEditPart.VISUAL_ID:
			return getRequirementName_5072Parser();
		case RequirementDescriptionEditPart.VISUAL_ID:
			return getRequirementDescription_5073Parser();
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
		case MathematicalModelName2EditPart.VISUAL_ID:
			return getMathematicalModelName_5093Parser();
		case AssumptionName2EditPart.VISUAL_ID:
			return getAssumptionName_5097Parser();
		case KnowledgeSpaceName2EditPart.VISUAL_ID:
			return getKnowledgeSpaceName_5099Parser();
		case ConstraintName2EditPart.VISUAL_ID:
			return getConstraintName_5100Parser();
		case DataDefinitionName2EditPart.VISUAL_ID:
			return getDataDefinitionName_5102Parser();
		case DataFlowName2EditPart.VISUAL_ID:
			return getDataFlowName_5108Parser();
		case FeatureName2EditPart.VISUAL_ID:
			return getFeatureName_5110Parser();
		case HardwareName2EditPart.VISUAL_ID:
			return getHardwareName_5112Parser();
		case PerformanceName2EditPart.VISUAL_ID:
			return getPerformanceName_5117Parser();
		case RequirementName2EditPart.VISUAL_ID:
			return getRequirementName_5120Parser();
		case SoftwareInterfaceName2EditPart.VISUAL_ID:
			return getSoftwareInterfaceName_5122Parser();
		case UserInterfaceName2EditPart.VISUAL_ID:
			return getUserInterfaceName_5125Parser();
		case RequirementSpaceName2EditPart.VISUAL_ID:
			return getRequirementSpaceName_5139Parser();
		case StatusMonitoringName2EditPart.VISUAL_ID:
			return getStatusMonitoringName_5143Parser();
		case ResultsOutputName2EditPart.VISUAL_ID:
			return getResultsOutputName_5145Parser();
		case ProcessName2EditPart.VISUAL_ID:
			return getProcessName_5147Parser();
		case InputDataReadingName2EditPart.VISUAL_ID:
			return getInputDataReadingName_5149Parser();
		case ErrorHandlingName2EditPart.VISUAL_ID:
			return getErrorHandlingName_5151Parser();
		case DataHandlingName2EditPart.VISUAL_ID:
			return getDataHandlingName_5153Parser();
		case DataProcessSpaceName2EditPart.VISUAL_ID:
			return getDataProcessSpaceName_5155Parser();
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
