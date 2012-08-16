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

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
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
			if (KnowledgePackage.eINSTANCE.getMathematical_GeophysicalModel()
					.equals(domainElement.eClass())) {
				return Mathematical_GeophysicalModelEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().equals(
					domainElement.eClass())) {
				return NumericalMethodEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getAssumption().equals(
					domainElement.eClass())) {
				return AssumptionEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirement().equals(
					domainElement.eClass())) {
				return RequirementEditPart.VISUAL_ID;
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
			if (RequirementsPackage.eINSTANCE.getPerformance().equals(
					domainElement.eClass())) {
				return PerformanceEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess().equals(domainElement.eClass())) {
				return ProcessEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getInputDataReading().equals(domainElement.eClass())) {
				return InputDataReadingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getResultsOutput().equals(domainElement.eClass())) {
				return ResultsOutputEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling().equals(domainElement.eClass())) {
				return ErrorHandlingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring().equals(domainElement.eClass())) {
				return StatusMonitoringEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getSolver().equals(domainElement.eClass())) {
				return SolverEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getMeshCreation().equals(domainElement.eClass())) {
				return MeshCreationEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPreProcessing().equals(domainElement.eClass())) {
				return PreProcessingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPostProcessing().equals(domainElement.eClass())) {
				return PostProcessingEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition().equals(domainElement.eClass())) {
				return DataDefinitionEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSeismicSource().equals(domainElement.eClass())) {
				return SeismicSourceEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getComputationalMesh().equals(domainElement.eClass())) {
				return ComputationalMeshEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSyntheticSeismogram().equals(domainElement.eClass())) {
				return SyntheticSeismogramEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getStation().equals(domainElement.eClass())) {
				return StationEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getControlParameter().equals(domainElement.eClass())) {
				return ControlParameterEditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getKnowledgeSpace().equals(
					domainElement.eClass())) {
				return KnowledgeSpaceEditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirementSpace().equals(
					domainElement.eClass())) {
				return RequirementSpaceEditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getDataProcessSpace().equals(domainElement.eClass())) {
				return DataProcessSpaceEditPart.VISUAL_ID;
			}
			break;
		case KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID:
			if (KnowledgePackage.eINSTANCE.getScientificProblem().equals(
					domainElement.eClass())) {
				return ScientificProblem2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().equals(
					domainElement.eClass())) {
				return NumericalMethod2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getMathematical_GeophysicalModel()
					.equals(domainElement.eClass())) {
				return Mathematical_GeophysicalModel2EditPart.VISUAL_ID;
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
		case KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID:
			if (KnowledgePackage.eINSTANCE.getScientificProblem().equals(
					domainElement.eClass())) {
				return ScientificProblem2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getNumericalMethod().equals(
					domainElement.eClass())) {
				return NumericalMethod2EditPart.VISUAL_ID;
			}
			if (KnowledgePackage.eINSTANCE.getMathematical_GeophysicalModel()
					.equals(domainElement.eClass())) {
				return Mathematical_GeophysicalModel2EditPart.VISUAL_ID;
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
			if (RequirementsPackage.eINSTANCE.getRequirement().equals(
					domainElement.eClass())) {
				return Requirement2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getFeature().equals(
					domainElement.eClass())) {
				return Feature2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getHardware().equals(
					domainElement.eClass())) {
				return Hardware2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getConstraint().equals(
					domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getUserInterface().equals(
					domainElement.eClass())) {
				return UserInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getSoftwareInterface().equals(
					domainElement.eClass())) {
				return SoftwareInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getPerformance().equals(
					domainElement.eClass())) {
				return Performance2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess().equals(domainElement.eClass())) {
				return Process2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getInputDataReading().equals(domainElement.eClass())) {
				return InputDataReading2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getResultsOutput().equals(domainElement.eClass())) {
				return ResultsOutput2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling().equals(domainElement.eClass())) {
				return ErrorHandling2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring().equals(domainElement.eClass())) {
				return StatusMonitoring2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getSolver().equals(domainElement.eClass())) {
				return Solver2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getMeshCreation().equals(domainElement.eClass())) {
				return MeshCreation2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPreProcessing().equals(domainElement.eClass())) {
				return PreProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPostProcessing().equals(domainElement.eClass())) {
				return PostProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition().equals(domainElement.eClass())) {
				return DataDefinition2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSeismicSource().equals(domainElement.eClass())) {
				return SeismicSource2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getComputationalMesh().equals(domainElement.eClass())) {
				return ComputationalMesh2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSyntheticSeismogram().equals(domainElement.eClass())) {
				return SyntheticSeismogram2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getStation().equals(domainElement.eClass())) {
				return Station2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getControlParameter().equals(domainElement.eClass())) {
				return ControlParameter2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirementSpace().equals(
					domainElement.eClass())) {
				return RequirementSpace2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getDataProcessSpace().equals(domainElement.eClass())) {
				return DataProcessSpace2EditPart.VISUAL_ID;
			}
			break;
		case RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID:
			if (RequirementsPackage.eINSTANCE.getRequirement().equals(
					domainElement.eClass())) {
				return Requirement2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getFeature().equals(
					domainElement.eClass())) {
				return Feature2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getHardware().equals(
					domainElement.eClass())) {
				return Hardware2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getConstraint().equals(
					domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getUserInterface().equals(
					domainElement.eClass())) {
				return UserInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getSoftwareInterface().equals(
					domainElement.eClass())) {
				return SoftwareInterface2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getPerformance().equals(
					domainElement.eClass())) {
				return Performance2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess().equals(domainElement.eClass())) {
				return Process2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getInputDataReading().equals(domainElement.eClass())) {
				return InputDataReading2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getResultsOutput().equals(domainElement.eClass())) {
				return ResultsOutput2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling().equals(domainElement.eClass())) {
				return ErrorHandling2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring().equals(domainElement.eClass())) {
				return StatusMonitoring2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getSolver().equals(domainElement.eClass())) {
				return Solver2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getMeshCreation().equals(domainElement.eClass())) {
				return MeshCreation2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPreProcessing().equals(domainElement.eClass())) {
				return PreProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPostProcessing().equals(domainElement.eClass())) {
				return PostProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition().equals(domainElement.eClass())) {
				return DataDefinition2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSeismicSource().equals(domainElement.eClass())) {
				return SeismicSource2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getComputationalMesh().equals(domainElement.eClass())) {
				return ComputationalMesh2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getSyntheticSeismogram().equals(domainElement.eClass())) {
				return SyntheticSeismogram2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getStation().equals(domainElement.eClass())) {
				return Station2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getControlParameter().equals(domainElement.eClass())) {
				return ControlParameter2EditPart.VISUAL_ID;
			}
			if (RequirementsPackage.eINSTANCE.getRequirementSpace().equals(
					domainElement.eClass())) {
				return RequirementSpace2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getDataProcessSpace().equals(domainElement.eClass())) {
				return DataProcessSpace2EditPart.VISUAL_ID;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID:
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess().equals(domainElement.eClass())) {
				return Process2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getInputDataReading().equals(domainElement.eClass())) {
				return InputDataReading2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getResultsOutput().equals(domainElement.eClass())) {
				return ResultsOutput2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling().equals(domainElement.eClass())) {
				return ErrorHandling2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring().equals(domainElement.eClass())) {
				return StatusMonitoring2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getDataProcessSpace().equals(domainElement.eClass())) {
				return DataProcessSpace2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getSolver().equals(domainElement.eClass())) {
				return Solver2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getMeshCreation().equals(domainElement.eClass())) {
				return MeshCreation2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPreProcessing().equals(domainElement.eClass())) {
				return PreProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPostProcessing().equals(domainElement.eClass())) {
				return PostProcessing2EditPart.VISUAL_ID;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID:
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess().equals(domainElement.eClass())) {
				return Process2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getInputDataReading().equals(domainElement.eClass())) {
				return InputDataReading2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getResultsOutput().equals(domainElement.eClass())) {
				return ResultsOutput2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling().equals(domainElement.eClass())) {
				return ErrorHandling2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring().equals(domainElement.eClass())) {
				return StatusMonitoring2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getDataProcessSpace().equals(domainElement.eClass())) {
				return DataProcessSpace2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getSolver().equals(domainElement.eClass())) {
				return Solver2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getMeshCreation().equals(domainElement.eClass())) {
				return MeshCreation2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPreProcessing().equals(domainElement.eClass())) {
				return PreProcessing2EditPart.VISUAL_ID;
			}
			if (scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getPostProcessing().equals(domainElement.eClass())) {
				return PostProcessing2EditPart.VISUAL_ID;
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
			if (Mathematical_GeophysicalModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NumericalMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssumptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementEditPart.VISUAL_ID == nodeVisualID) {
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
			if (PerformanceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReadingEditPart.VISUAL_ID == nodeVisualID) {
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
			if (SolverEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMeshEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ControlParameterEditPart.VISUAL_ID == nodeVisualID) {
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
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			if (Mathematical_GeophysicalModelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Mathematical_GeophysicalModelDescriptionEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case AssumptionEditPart.VISUAL_ID:
			if (AssumptionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssumptionDescriptionEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case PerformanceEditPart.VISUAL_ID:
			if (PerformanceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PerformanceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
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
		case InputDataReadingEditPart.VISUAL_ID:
			if (InputDataReadingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReadingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
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
		case SolverEditPart.VISUAL_ID:
			if (SolverNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolverDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MeshCreationEditPart.VISUAL_ID:
			if (MeshCreationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreationDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreProcessingEditPart.VISUAL_ID:
			if (PreProcessingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PostProcessingEditPart.VISUAL_ID:
			if (PostProcessingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessingDescriptionEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case SeismicSourceEditPart.VISUAL_ID:
			if (SeismicSourceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSourceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSourceAccuracyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSourceFormatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSourceRangeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComputationalMeshEditPart.VISUAL_ID:
			if (ComputationalMeshNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMeshDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMeshAccuracyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMeshFormatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMeshRangeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SyntheticSeismogramEditPart.VISUAL_ID:
			if (SyntheticSeismogramNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogramDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogramAccuracyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogramFormatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogramRangeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StationEditPart.VISUAL_ID:
			if (StationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StationDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StationAccuracyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StationFormatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StationRangeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ControlParameterEditPart.VISUAL_ID:
			if (ControlParameterNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ControlParameterDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ControlParameterFormatEditPart.VISUAL_ID == nodeVisualID) {
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
			if (RequirementSpaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceEditPart.VISUAL_ID:
			if (DataProcessSpaceNameEditPart.VISUAL_ID == nodeVisualID) {
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
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			if (Mathematical_GeophysicalModelName2EditPart.VISUAL_ID == nodeVisualID) {
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
		case Requirement2EditPart.VISUAL_ID:
			if (RequirementName2EditPart.VISUAL_ID == nodeVisualID) {
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
		case Constraint2EditPart.VISUAL_ID:
			if (ConstraintName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UserInterface2EditPart.VISUAL_ID:
			if (UserInterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SoftwareInterface2EditPart.VISUAL_ID:
			if (SoftwareInterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Performance2EditPart.VISUAL_ID:
			if (PerformanceName2EditPart.VISUAL_ID == nodeVisualID) {
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
		case ResultsOutput2EditPart.VISUAL_ID:
			if (ResultsOutputName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ErrorHandling2EditPart.VISUAL_ID:
			if (ErrorHandlingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatusMonitoring2EditPart.VISUAL_ID:
			if (StatusMonitoringName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Solver2EditPart.VISUAL_ID:
			if (SolverName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MeshCreation2EditPart.VISUAL_ID:
			if (MeshCreationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PreProcessing2EditPart.VISUAL_ID:
			if (PreProcessingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PostProcessing2EditPart.VISUAL_ID:
			if (PostProcessingName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDefinition2EditPart.VISUAL_ID:
			if (DataDefinitionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SeismicSource2EditPart.VISUAL_ID:
			if (SeismicSourceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComputationalMesh2EditPart.VISUAL_ID:
			if (ComputationalMeshName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			if (SyntheticSeismogramName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Station2EditPart.VISUAL_ID:
			if (StationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ControlParameter2EditPart.VISUAL_ID:
			if (ControlParameterName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpace2EditPart.VISUAL_ID:
			if (RequirementSpaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpace2EditPart.VISUAL_ID:
			if (DataProcessSpaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
			if (Mathematical_GeophysicalModel2EditPart.VISUAL_ID == nodeVisualID) {
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
			if (Mathematical_GeophysicalModel2EditPart.VISUAL_ID == nodeVisualID) {
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
			if (Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Feature2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Hardware2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Performance2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Solver2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSource2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMesh2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogram2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Station2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ControlParameter2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID:
			if (Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Feature2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Hardware2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UserInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SoftwareInterface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Performance2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Solver2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDefinition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SeismicSource2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComputationalMesh2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SyntheticSeismogram2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Station2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ControlParameter2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID:
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Solver2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID:
			if (Process2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputDataReading2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResultsOutput2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ErrorHandling2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StatusMonitoring2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataProcessSpace2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Solver2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MeshCreation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PreProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PostProcessing2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			if (WrappingLabel19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID:
			if (WrappingLabel20EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID:
			if (WrappingLabel24EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			if (WrappingLabel18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementProvidedInterfaceEditPart.VISUAL_ID:
			if (WrappingLabel25EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementRequiredInterfaceEditPart.VISUAL_ID:
			if (WrappingLabel26EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			if (WrappingLabel15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureDependenciesEditPart.VISUAL_ID:
			if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
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
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PerformanceHardwareEditPart.VISUAL_ID:
			if (WrappingLabel27EditPart.VISUAL_ID == nodeVisualID) {
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
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			if (WrappingLabel28EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID:
			if (WrappingLabel29EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID:
			if (WrappingLabel30EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ControlParameterControlledProcessEditPart.VISUAL_ID:
			if (WrappingLabel31EditPart.VISUAL_ID == nodeVisualID) {
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
