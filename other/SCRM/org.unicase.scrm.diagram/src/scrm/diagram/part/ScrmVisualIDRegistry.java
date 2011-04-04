package scrm.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import scrm.SCRMDiagram;
import scrm.ScrmPackage;
import scrm.diagram.edit.parts.*;
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataFlowEditPart;
import scrm.diagram.edit.parts.DataHandlingEditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureConstraintsEditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureDetailedRequirementsEditPart;
import scrm.diagram.edit.parts.FeatureEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.HardwareEditPart;
import scrm.diagram.edit.parts.InputDataReadingEditPart;
import scrm.diagram.edit.parts.MathematicalModel2EditPart;
import scrm.diagram.edit.parts.MathematicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.ProcessDataFlowEditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.RequirementDefiningDataEditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificProblemDescriptionEditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemNameEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.edit.parts.WrappingLabel10EditPart;
import scrm.diagram.edit.parts.WrappingLabel11EditPart;
import scrm.diagram.edit.parts.WrappingLabel12EditPart;
import scrm.diagram.edit.parts.WrappingLabel13EditPart;
import scrm.diagram.edit.parts.WrappingLabel14EditPart;
import scrm.diagram.edit.parts.WrappingLabel15EditPart;
import scrm.diagram.edit.parts.WrappingLabel16EditPart;
import scrm.diagram.edit.parts.WrappingLabel17EditPart;
import scrm.diagram.edit.parts.WrappingLabel18EditPart;
import scrm.diagram.edit.parts.WrappingLabel19EditPart;
import scrm.diagram.edit.parts.WrappingLabel20EditPart;
import scrm.diagram.edit.parts.WrappingLabel21EditPart;
import scrm.diagram.edit.parts.WrappingLabel22EditPart;
import scrm.diagram.edit.parts.WrappingLabel2EditPart;
import scrm.diagram.edit.parts.WrappingLabel3EditPart;
import scrm.diagram.edit.parts.WrappingLabel4EditPart;
import scrm.diagram.edit.parts.WrappingLabel5EditPart;
import scrm.diagram.edit.parts.WrappingLabel6EditPart;
import scrm.diagram.edit.parts.WrappingLabel7EditPart;
import scrm.diagram.edit.parts.WrappingLabel8EditPart;
import scrm.diagram.edit.parts.WrappingLabel9EditPart;
import scrm.diagram.edit.parts.WrappingLabelEditPart;
import scrm.knowledge.KnowledgePackage;
import scrm.requirements.RequirementsPackage;

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
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SCRMDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return SCRMDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return scrm.diagram.part.ScrmVisualIDRegistry.getVisualID(view
				.getType());
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
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ScrmPackage.eINSTANCE.getSCRMDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((SCRMDiagram) domainElement)) {
			return SCRMDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
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
			if (KnowledgePackage.eINSTANCE.getScientificProblem()
					.isSuperTypeOf(domainElement.eClass())) {
				return ScientificProblemEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getMathematicalModel()
					.isSuperTypeOf(domainElement.eClass())) {
				return MathematicalModelEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return NumericalMethodEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getAssumption().isSuperTypeOf(
					domainElement.eClass())) {
				return AssumptionEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getFeature().isSuperTypeOf(
					domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getHardware().isSuperTypeOf(
					domainElement.eClass())) {
				return HardwareEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getConstraint().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getUserInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return UserInterfaceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getSoftwareInterface()
					.isSuperTypeOf(domainElement.eClass())) {
				return SoftwareInterfaceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getProcess().isSuperTypeOf(
					domainElement.eClass())) {
				return ProcessEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getPerformance().isSuperTypeOf(
					domainElement.eClass())) {
				return PerformanceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataFlow().isSuperTypeOf(
					domainElement.eClass())) {
				return DataFlowEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getDataDefinition()
					.isSuperTypeOf(domainElement.eClass())) {
				return DataDefinitionEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
					.getInputDataReading()
					.isSuperTypeOf(domainElement.eClass())) {
				return InputDataReadingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
					.getDataHandling().isSuperTypeOf(domainElement.eClass())) {
				return DataHandlingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
					.getResultsOutput().isSuperTypeOf(domainElement.eClass())) {
				return ResultsOutputEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
					.getErrorHandling().isSuperTypeOf(domainElement.eClass())) {
				return ErrorHandlingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
					.getStatusMonitoring()
					.isSuperTypeOf(domainElement.eClass())) {
				return StatusMonitoringEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
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
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemSolvingMethodsEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MathematicalModel2EditPart.VISUAL_ID:
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
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
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
		case FeatureConstraintsEditPart.VISUAL_ID:
			if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Feature2EditPart.VISUAL_ID:
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
		case RequirementEditPart.VISUAL_ID:
			if (WrappingLabel18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementDefiningDataEditPart.VISUAL_ID:
			if (WrappingLabel19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProcessDataFlowEditPart.VISUAL_ID:
			if (WrappingLabel20EditPart.VISUAL_ID == nodeVisualID) {
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
		if (KnowledgePackage.eINSTANCE.getMathematicalModel().isSuperTypeOf(
				domainElement.eClass())) {
			return MathematicalModel2EditPart.VISUAL_ID;
		}
		if (RequirementsPackage.eINSTANCE.getFeature().isSuperTypeOf(
				domainElement.eClass())) {
			return Feature2EditPart.VISUAL_ID;
		}
		if (RequirementsPackage.eINSTANCE.getRequirement().isSuperTypeOf(
				domainElement.eClass())) {
			return RequirementEditPart.VISUAL_ID;
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
