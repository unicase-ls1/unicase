package scrm.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import scrm.SCRMDiagram;
import scrm.ScrmPackage;
import scrm.diagram.edit.parts.*;
import scrm.knowledge.KnowledgePackage;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ScrmVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.scrm.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SCRMDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return SCRMDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				ScrmDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated NOT
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ScrmPackage.eINSTANCE.getSCRMDiagram().equals(
				domainElement.eClass())
				&& isDiagram((SCRMDiagram) domainElement)) {
			return SCRMDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated NOT
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = scrm.diagram.part.ScrmVisualIDRegistry
				.getModelID(containerView);
		if (!SCRMDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (SCRMDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = scrm.diagram.part.ScrmVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SCRMDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case SCRMDiagramEditPart.VISUAL_ID:
			if (KnowledgePackage.eINSTANCE.getScientificProblem().equals(
					domainElement.eClass())) {
				return ScientificProblemEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getMathematicalModel().equals(
					domainElement.eClass())) {
				return MathematicalModelEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().equals(
					domainElement.eClass())) {
				return NumericalMethodEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getAssumption().equals(
					domainElement.eClass())) {
				return AssumptionEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getFeature().equals(
					domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getHardware().equals(
					domainElement.eClass())) {
				return HardwareEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getConstraint().equals(
					domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getUserInterface().equals(
					domainElement.eClass())) {
				return UserInterfaceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getSoftwareInterface().equals(
					domainElement.eClass())) {
				return SoftwareInterfaceEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getProcess().equals(
					domainElement.eClass())) {
				return ProcessEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getPerformance().equals(
					domainElement.eClass())) {
				return PerformanceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataFlow().equals(
					domainElement.eClass())) {
				return DataFlowEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataDefinition().equals(
					domainElement.eClass())) {
				return DataDefinitionEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getInputDataReading().equals(
					domainElement.eClass())) {
				return InputDataReadingEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getDataHandling().equals(
					domainElement.eClass())) {
				return DataHandlingEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getResultsOutput().equals(
					domainElement.eClass())) {
				return ResultsOutputEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getErrorHandling().equals(
					domainElement.eClass())) {
				return ErrorHandlingEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getStatusMonitoring().equals(
					domainElement.eClass())) {
				return StatusMonitoringEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirement().equals(
					domainElement.eClass())) {
				return RequirementEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getKnowledgeSpace().equals(
					domainElement.eClass())) {
				return KnowledgeSpaceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirementSpace().equals(
					domainElement.eClass())) {
				return RequirementSpaceEditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getDataProcessSpace().equals(
					domainElement.eClass())) {
				return DataProcessSpaceEditPart.VISUAL_ID;
			}
			break;
		case KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID:
		case KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID:
			if (KnowledgePackage.eINSTANCE.getScientificProblem().equals(
					domainElement.eClass())) {
				return ScientificProblem2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().equals(
					domainElement.eClass())) {
				return NumericalMethod2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getMathematicalModel().equals(
					domainElement.eClass())) {
				return MathematicalModel2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getAssumption().equals(
					domainElement.eClass())) {
				return Assumption2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getKnowledgeSpace().equals(
					domainElement.eClass())) {
				return KnowledgeSpace2EditPart.VISUAL_ID;
			}
			break;
		case RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID:
		case RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID:
			if (RequirementsPackage.eINSTANCE.getConstraint().equals(
					domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataDefinition().equals(
					domainElement.eClass())) {
				return DataDefinition2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataFlow().equals(
					domainElement.eClass())) {
				return DataFlow2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getFeature().equals(
					domainElement.eClass())) {
				return Feature2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getHardware().equals(
					domainElement.eClass())) {
				return Hardware2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getPerformance().equals(
					domainElement.eClass())) {
				return Performance2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirement().equals(
					domainElement.eClass())) {
				return Requirement2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getSoftwareInterface().equals(
					domainElement.eClass())) {
				return SoftwareInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getUserInterface().equals(
					domainElement.eClass())) {
				return UserInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirementSpace().equals(
					domainElement.eClass())) {
				return RequirementSpace2EditPart.VISUAL_ID;
			}
		case DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID:
		case DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID:
			if (DataProcessPackage.eINSTANCE.getStatusMonitoring().equals(
					domainElement.eClass())) {
				return StatusMonitoring2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getResultsOutput().equals(
					domainElement.eClass())) {
				return ResultsOutput2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getProcess().equals(
					domainElement.eClass())) {
				return Process2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getInputDataReading().equals(
					domainElement.eClass())) {
				return InputDataReading2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getErrorHandling().equals(
					domainElement.eClass())) {
				return ErrorHandling2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getDataHandling().equals(
					domainElement.eClass())) {
				return DataHandling2EditPart.VISUAL_ID;
			}
			if (DataProcessPackage.eINSTANCE.getDataProcessSpace().equals(
					domainElement.eClass())) {
				return DataProcessSpace2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated NOT
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = scrm.diagram.part.ScrmVisualIDRegistry
				.getModelID(containerView);
		if (!SCRMDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (SCRMDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = scrm.diagram.part.ScrmVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SCRMDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case SCRMDiagramEditPart.VISUAL_ID:
			if (ScientificProblemEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssumptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FeatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HardwareEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PerformanceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataFlowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReadingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataHandlingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandlingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (KnowledgeSpaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemEditPart.VISUAL_ID:
			if (ScientificProblemNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScientificProblemDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModelEditPart.VISUAL_ID:
			if (MathematicalModelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModelDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModelTheoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModelMathematicalExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodEditPart.VISUAL_ID:
			if (NumericalMethodNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethodDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethodTheoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethodAlgorithmEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssumptionEditPart.VISUAL_ID:
			if (AssumptionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssumptionDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureEditPart.VISUAL_ID:
			if (FeatureNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FeatureDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HardwareEditPart.VISUAL_ID:
			if (HardwareNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HardwareDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HardwareProcessorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HardwarePlatformEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HardwareMemoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if (ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UserInterfaceEditPart.VISUAL_ID:
			if (UserInterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterfaceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SoftwareInterfaceEditPart.VISUAL_ID:
			if (SoftwareInterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterfaceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterfaceDataTypesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProcessEditPart.VISUAL_ID:
			if (ProcessNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PerformanceEditPart.VISUAL_ID:
			if (PerformanceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PerformanceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PerformanceProblemSizeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataFlowEditPart.VISUAL_ID:
			if (DataFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataFlowDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDefinitionEditPart.VISUAL_ID:
			if (DataDefinitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionAccuracyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionFormatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionRangeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputDataReadingEditPart.VISUAL_ID:
			if (InputDataReadingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReadingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataHandlingEditPart.VISUAL_ID:
			if (DataHandlingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataHandlingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResultsOutputEditPart.VISUAL_ID:
			if (ResultsOutputNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutputDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ErrorHandlingEditPart.VISUAL_ID:
			if (ErrorHandlingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandlingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatusMonitoringEditPart.VISUAL_ID:
			if (StatusMonitoringNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoringDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementEditPart.VISUAL_ID:
			if (RequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case KnowledgeSpaceEditPart.VISUAL_ID:
			if (KnowledgeSpaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpaceEditPart.VISUAL_ID:
			if (RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceEditPart.VISUAL_ID:
			if (DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblem2EditPart.VISUAL_ID:
			if (ScientificProblemName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethod2EditPart.VISUAL_ID:
			if (NumericalMethodName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModel2EditPart.VISUAL_ID:
			if (MathematicalModelName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Assumption2EditPart.VISUAL_ID:
			if (AssumptionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case KnowledgeSpace2EditPart.VISUAL_ID:
			if (KnowledgeSpaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Constraint2EditPart.VISUAL_ID:
			if (ConstraintName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDefinition2EditPart.VISUAL_ID:
			if (DataDefinitionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataFlow2EditPart.VISUAL_ID:
			if (DataFlowName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Feature2EditPart.VISUAL_ID:
			if (FeatureName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Hardware2EditPart.VISUAL_ID:
			if (HardwareName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Performance2EditPart.VISUAL_ID:
			if (PerformanceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Requirement2EditPart.VISUAL_ID:
			if (RequirementName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SoftwareInterface2EditPart.VISUAL_ID:
			if (SoftwareInterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UserInterface2EditPart.VISUAL_ID:
			if (UserInterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpace2EditPart.VISUAL_ID:
			if (RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatusMonitoring2EditPart.VISUAL_ID:
			if (StatusMonitoringName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResultsOutput2EditPart.VISUAL_ID:
			if (ResultsOutputName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Process2EditPart.VISUAL_ID:
			if (ProcessName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputDataReading2EditPart.VISUAL_ID:
			if (InputDataReadingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ErrorHandling2EditPart.VISUAL_ID:
			if (ErrorHandlingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataHandling2EditPart.VISUAL_ID:
			if (DataHandlingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpace2EditPart.VISUAL_ID:
			if (DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID:
			if (ScientificProblem2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethod2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Assumption2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (KnowledgeSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID:
			if (ScientificProblem2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethod2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MathematicalModel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Assumption2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (KnowledgeSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID:
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataFlow2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Feature2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Hardware2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Performance2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID:
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataFlow2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Feature2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Hardware2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Performance2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID:
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID:
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModelRepresentedProblemEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModelRefinedModelEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PerformanceDescribedMethodEditPart.VISUAL_ID:
			if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			if (WrappingLabel10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			if (WrappingLabel11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			if (WrappingLabel15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			if (WrappingLabel16EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			if (WrappingLabel17EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			if (WrappingLabel18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementDefiningDataEditPart.VISUAL_ID:
			if (WrappingLabel19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataFlowSpecifiedProcessEditPart.VISUAL_ID:
			if (WrappingLabel20EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProcessSuccessorEditPart.VISUAL_ID:
			if (WrappingLabel21EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ErrorHandlingHandledProcessEditPart.VISUAL_ID:
			if (WrappingLabel22EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatusMonitoringMonitoredProcessEditPart.VISUAL_ID:
			if (WrappingLabel23EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(SCRMDiagram element) {
		return true;
	}

}
