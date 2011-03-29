package scrm.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
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
import scrm.diagram.edit.parts.MathematicalModel3EditPart;
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
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.edit.parts.ScientificProblemSolvingMethodsEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificKnowledge;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.Constraint;
import scrm.requirements.DataDefinition;
import scrm.requirements.DataFlow;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.IRequirement;
import scrm.requirements.Interface;
import scrm.requirements.Performance;
import scrm.requirements.Process;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;

/**
 * @generated
 */
public class ScrmDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<ScrmNodeDescriptor> getSemanticChildren(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmNodeDescriptor> getSCRMDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SCRMDiagram modelElement = (SCRMDiagram) view.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it
				.hasNext();) {
			SCRMModelElement childElement = (SCRMModelElement) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ScientificProblemEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MathematicalModelEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NumericalMethodEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AssumptionEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FeatureEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HardwareEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == UserInterfaceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SoftwareInterfaceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ProcessEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PerformanceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataFlowEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataDefinitionEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InputDataReadingEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataHandlingEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ResultsOutputEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ErrorHandlingEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StatusMonitoringEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getContainedLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000ContainedLinks(view);
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007ContainedLinks(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2005ContainedLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006ContainedLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008ContainedLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009ContainedLinks(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011ContainedLinks(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012ContainedLinks(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013ContainedLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2014ContainedLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015ContainedLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016ContainedLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017ContainedLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2018ContainedLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2019ContainedLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2020ContainedLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2021ContainedLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2022ContainedLinks(view);
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_4004ContainedLinks(view);
		case MathematicalModel3EditPart.VISUAL_ID:
			return getMathematicalModel_4010ContainedLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_4029ContainedLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_4036ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getIncomingLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007IncomingLinks(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2005IncomingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006IncomingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008IncomingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009IncomingLinks(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011IncomingLinks(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012IncomingLinks(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013IncomingLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2014IncomingLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015IncomingLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016IncomingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017IncomingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2018IncomingLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2019IncomingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2020IncomingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2021IncomingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2022IncomingLinks(view);
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_4004IncomingLinks(view);
		case MathematicalModel3EditPart.VISUAL_ID:
			return getMathematicalModel_4010IncomingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_4029IncomingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_4036IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getOutgoingLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007OutgoingLinks(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2005OutgoingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006OutgoingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008OutgoingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009OutgoingLinks(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011OutgoingLinks(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012OutgoingLinks(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013OutgoingLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2014OutgoingLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015OutgoingLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016OutgoingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017OutgoingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2018OutgoingLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2019OutgoingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2020OutgoingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2021OutgoingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2022OutgoingLinks(view);
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_4004OutgoingLinks(view);
		case MathematicalModel3EditPart.VISUAL_ID:
			return getMathematicalModel_4010OutgoingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_4029OutgoingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_4036OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSCRMDiagram_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_2007ContainedLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_SolvingMethods_4041(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_2005ContainedLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_2006ContainedLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_2008ContainedLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_2009ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Constraints_4025(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Feature_4029(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_2010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_2011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_2012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_2013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2014ContainedLinks(
			View view) {
		Process modelElement = (Process) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_DataFlow_4040(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015ContainedLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016ContainedLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017ContainedLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2018ContainedLinks(
			View view) {
		scrm.requirements.dataProcessing.InputDataReading modelElement = (scrm.requirements.dataProcessing.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2019ContainedLinks(
			View view) {
		scrm.requirements.dataProcessing.DataHandling modelElement = (scrm.requirements.dataProcessing.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2020ContainedLinks(
			View view) {
		scrm.requirements.dataProcessing.ResultsOutput modelElement = (scrm.requirements.dataProcessing.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2021ContainedLinks(
			View view) {
		scrm.requirements.dataProcessing.ErrorHandling modelElement = (scrm.requirements.dataProcessing.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2022ContainedLinks(
			View view) {
		scrm.requirements.dataProcessing.StatusMonitoring modelElement = (scrm.requirements.dataProcessing.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4004ContainedLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4010ContainedLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_4029ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Constraints_4025(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Feature_4029(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_4036ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_2007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_2005IncomingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_2006IncomingLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_SolvingMethods_4041(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_2008IncomingLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_2009IncomingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Feature_4029(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_2010IncomingLinks(
			View view) {
		Hardware modelElement = (Hardware) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Dependencies_4026(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_2011IncomingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Constraints_4025(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_2012IncomingLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_2013IncomingLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2014IncomingLinks(
			View view) {
		Process modelElement = (Process) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015IncomingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016IncomingLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_DataFlow_4040(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017IncomingLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_DefiningData_4038(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2018IncomingLinks(
			View view) {
		scrm.requirements.dataProcessing.InputDataReading modelElement = (scrm.requirements.dataProcessing.InputDataReading) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2019IncomingLinks(
			View view) {
		scrm.requirements.dataProcessing.DataHandling modelElement = (scrm.requirements.dataProcessing.DataHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2020IncomingLinks(
			View view) {
		scrm.requirements.dataProcessing.ResultsOutput modelElement = (scrm.requirements.dataProcessing.ResultsOutput) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2021IncomingLinks(
			View view) {
		scrm.requirements.dataProcessing.ErrorHandling modelElement = (scrm.requirements.dataProcessing.ErrorHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2022IncomingLinks(
			View view) {
		scrm.requirements.dataProcessing.StatusMonitoring modelElement = (scrm.requirements.dataProcessing.StatusMonitoring) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4004IncomingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4010IncomingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MathematicalModel_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_4029IncomingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Feature_4029(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_4036IncomingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Requirement_4036(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_2007OutgoingLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_SolvingMethods_4041(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_2005OutgoingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_2006OutgoingLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_2008OutgoingLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_2009OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Constraints_4025(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Feature_4029(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_2010OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_2011OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_2012OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_2013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2014OutgoingLinks(
			View view) {
		Process modelElement = (Process) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_DataFlow_4040(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015OutgoingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016OutgoingLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017OutgoingLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2018OutgoingLinks(
			View view) {
		scrm.requirements.dataProcessing.InputDataReading modelElement = (scrm.requirements.dataProcessing.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2019OutgoingLinks(
			View view) {
		scrm.requirements.dataProcessing.DataHandling modelElement = (scrm.requirements.dataProcessing.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2020OutgoingLinks(
			View view) {
		scrm.requirements.dataProcessing.ResultsOutput modelElement = (scrm.requirements.dataProcessing.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2021OutgoingLinks(
			View view) {
		scrm.requirements.dataProcessing.ErrorHandling modelElement = (scrm.requirements.dataProcessing.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2022OutgoingLinks(
			View view) {
		scrm.requirements.dataProcessing.StatusMonitoring modelElement = (scrm.requirements.dataProcessing.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4004OutgoingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_4010OutgoingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_MathematicalModel_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_4029OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Constraints_4025(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Feature_4029(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_4036OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Requirement_4036(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getContainedTypeModelFacetLinks_MathematicalModel_4004(
			MathematicalModel container) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getRefinements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) linkObject;
			if (MathematicalModel2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getRefinements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel dst = (MathematicalModel) theTarget;
			MathematicalModel src = link.getRefinedModel();
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.MathematicalModel_4004,
					MathematicalModel2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getContainedTypeModelFacetLinks_MathematicalModel_4010(
			MathematicalModel container) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getSubMathematicalModels()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) linkObject;
			if (MathematicalModel3EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSubMathematicalModels();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel dst = (MathematicalModel) theTarget;
			MathematicalModel src = link.getSuperMathematicalModel();
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.MathematicalModel_4010,
					MathematicalModel3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getContainedTypeModelFacetLinks_Feature_4029(
			Feature container) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getSubFeatures().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Feature) {
				continue;
			}
			Feature link = (Feature) linkObject;
			if (Feature2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSubFeatures();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Feature) {
				continue;
			}
			Feature dst = (Feature) theTarget;
			Feature src = link.getSupeFeature();
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.Feature_4029, Feature2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getContainedTypeModelFacetLinks_Requirement_4036(
			Requirement container) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getRefinements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Requirement) {
				continue;
			}
			Requirement link = (Requirement) linkObject;
			if (RequirementEditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getRefinements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Requirement) {
				continue;
			}
			Requirement dst = (Requirement) theTarget;
			Requirement src = link.getRefinedRequirement();
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.Requirement_4036,
					RequirementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
			IRequirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getScientificKnowledge_Requirements()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ScientificKnowledgeRequirements_4005,
						ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(
			MathematicalModel target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getScientificProblem_RepresentingModel()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.ScientificProblemRepresentingModel_4006,
						ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ScientificProblem_SolvingMethods_4041(
			NumericalMethod target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getScientificProblem_SolvingMethods()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ScientificProblemSolvingMethods_4041,
						ScientificProblemSolvingMethodsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getScientificProblem_InfluencedFeature()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.ScientificProblemInfluencedFeature_4008,
						ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingTypeModelFacetLinks_MathematicalModel_4004(
			MathematicalModel target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != KnowledgePackage.eINSTANCE
					.getMathematicalModel_Refinements()
					|| false == setting.getEObject() instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) setting.getEObject();
			if (MathematicalModel2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			MathematicalModel src = link.getRefinedModel();
			result.add(new ScrmLinkDescriptor(src, target, link,
					ScrmElementTypes.MathematicalModel_4004,
					MathematicalModel2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingTypeModelFacetLinks_MathematicalModel_4010(
			MathematicalModel target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != KnowledgePackage.eINSTANCE
					.getMathematicalModel_SubMathematicalModels()
					|| false == setting.getEObject() instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) setting.getEObject();
			if (MathematicalModel3EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			MathematicalModel src = link.getSuperMathematicalModel();
			result.add(new ScrmLinkDescriptor(src, target, link,
					ScrmElementTypes.MathematicalModel_4010,
					MathematicalModel3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(
			NumericalMethod target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematicalModel_NumericalMethods()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.MathematicalModelNumericalMethods_4011,
						MathematicalModelNumericalMethodsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(
			Assumption target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematicalModel_Dependencies()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.MathematicalModelDependencies_4012,
						MathematicalModelDependenciesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(
			Assumption target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getNumericalMethod_Dependencies()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.NumericalMethodDependencies_4015,
						NumericalMethodDependenciesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getNumericalMethod_RealizingRequirement()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.NumericalMethodRealizingRequirement_4016,
						NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
			Performance target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getNumericalMethod_Performance()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.NumericalMethodPerformance_4017,
						NumericalMethodPerformanceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_RequiredInterfaces()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureRequiredInterfaces_4023,
						FeatureRequiredInterfacesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_ProvidedInterfaces()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureProvidedInterfaces_4024,
						FeatureProvidedInterfacesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_Constraints_4025(
			Constraint target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_Constraints()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureConstraints_4025,
						FeatureConstraintsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_Dependencies_4026(
			Hardware target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_Dependencies()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureDependencies_4026,
						FeatureDependenciesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_DetailedRequirements()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureDetailedRequirements_4027,
						FeatureDetailedRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingTypeModelFacetLinks_Feature_4029(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RequirementsPackage.eINSTANCE
					.getFeature_SubFeatures()
					|| false == setting.getEObject() instanceof Feature) {
				continue;
			}
			Feature link = (Feature) setting.getEObject();
			if (Feature2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Feature src = link.getSupeFeature();
			result.add(new ScrmLinkDescriptor(src, target, link,
					ScrmElementTypes.Feature_4029, Feature2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_RequiredFeatures()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureRequiredFeatures_4030,
						FeatureRequiredFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_ExcludedFeatures()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureExcludedFeatures_4032,
						FeatureExcludedFeaturesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingTypeModelFacetLinks_Requirement_4036(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RequirementsPackage.eINSTANCE
					.getRequirement_Refinements()
					|| false == setting.getEObject() instanceof Requirement) {
				continue;
			}
			Requirement link = (Requirement) setting.getEObject();
			if (RequirementEditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Requirement src = link.getRefinedRequirement();
			result.add(new ScrmLinkDescriptor(src, target, link,
					ScrmElementTypes.Requirement_4036,
					RequirementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_DefiningData_4038(
			DataDefinition target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_DefiningData()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementDefiningData_4038,
						RequirementDefiningDataEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Process_DataFlow_4040(
			DataFlow target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getProcess_DataFlow()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ProcessDataFlow_4040,
						ProcessDataFlowEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ScientificKnowledge_Requirements_4005(
			ScientificKnowledge source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getRequirements().iterator(); destinations
				.hasNext();) {
			IRequirement destination = (IRequirement) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.ScientificKnowledgeRequirements_4005,
					ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4006(
			ScientificProblem source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		MathematicalModel destination = source.getRepresentingModel();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ScientificProblemRepresentingModel_4006,
				ScientificProblemRepresentingModelEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ScientificProblem_SolvingMethods_4041(
			ScientificProblem source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getSolvingMethods().iterator(); destinations
				.hasNext();) {
			NumericalMethod destination = (NumericalMethod) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.ScientificProblemSolvingMethods_4041,
					ScientificProblemSolvingMethodsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
			ScientificProblem source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Feature destination = source.getInfluencedFeature();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ScientificProblemInfluencedFeature_4008,
				ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingTypeModelFacetLinks_MathematicalModel_4004(
			MathematicalModel source) {
		MathematicalModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MathematicalModel) {
				container = (MathematicalModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getRefinements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) linkObject;
			if (MathematicalModel2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getRefinements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel dst = (MathematicalModel) theTarget;
			MathematicalModel src = link.getRefinedModel();
			if (src != source) {
				continue;
			}
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.MathematicalModel_4004,
					MathematicalModel2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingTypeModelFacetLinks_MathematicalModel_4010(
			MathematicalModel source) {
		MathematicalModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MathematicalModel) {
				container = (MathematicalModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getSubMathematicalModels()
				.iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel link = (MathematicalModel) linkObject;
			if (MathematicalModel3EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSubMathematicalModels();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof MathematicalModel) {
				continue;
			}
			MathematicalModel dst = (MathematicalModel) theTarget;
			MathematicalModel src = link.getSuperMathematicalModel();
			if (src != source) {
				continue;
			}
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.MathematicalModel_4010,
					MathematicalModel3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(
			MathematicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getNumericalMethods().iterator(); destinations
				.hasNext();) {
			NumericalMethod destination = (NumericalMethod) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.MathematicalModelNumericalMethods_4011,
					MathematicalModelNumericalMethodsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(
			MathematicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDependencies().iterator(); destinations
				.hasNext();) {
			Assumption destination = (Assumption) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.MathematicalModelDependencies_4012,
					MathematicalModelDependenciesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDependencies().iterator(); destinations
				.hasNext();) {
			Assumption destination = (Assumption) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.NumericalMethodDependencies_4015,
					NumericalMethodDependenciesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4016(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Requirement destination = source.getRealizingRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.NumericalMethodRealizingRequirement_4016,
				NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Performance destination = source.getPerformance();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.NumericalMethodPerformance_4017,
				NumericalMethodPerformanceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getRequiredInterfaces()
				.iterator(); destinations.hasNext();) {
			Interface destination = (Interface) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureRequiredInterfaces_4023,
					FeatureRequiredInterfacesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getProvidedInterfaces()
				.iterator(); destinations.hasNext();) {
			Interface destination = (Interface) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureProvidedInterfaces_4024,
					FeatureProvidedInterfacesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_Constraints_4025(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getConstraints().iterator(); destinations
				.hasNext();) {
			Constraint destination = (Constraint) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureConstraints_4025,
					FeatureConstraintsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDependencies().iterator(); destinations
				.hasNext();) {
			Hardware destination = (Hardware) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureDependencies_4026,
					FeatureDependenciesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_DetailedRequirements_4027(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDetailedRequirements()
				.iterator(); destinations.hasNext();) {
			Requirement destination = (Requirement) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureDetailedRequirements_4027,
					FeatureDetailedRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingTypeModelFacetLinks_Feature_4029(
			Feature source) {
		Feature container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Feature) {
				container = (Feature) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getSubFeatures().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Feature) {
				continue;
			}
			Feature link = (Feature) linkObject;
			if (Feature2EditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSubFeatures();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Feature) {
				continue;
			}
			Feature dst = (Feature) theTarget;
			Feature src = link.getSupeFeature();
			if (src != source) {
				continue;
			}
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.Feature_4029, Feature2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getRequiredFeatures().iterator(); destinations
				.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureRequiredFeatures_4030,
					FeatureRequiredFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getExcludedFeatures().iterator(); destinations
				.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureExcludedFeatures_4032,
					FeatureExcludedFeaturesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingTypeModelFacetLinks_Requirement_4036(
			Requirement source) {
		Requirement container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Requirement) {
				container = (Requirement) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> links = container.getRefinements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Requirement) {
				continue;
			}
			Requirement link = (Requirement) linkObject;
			if (RequirementEditPart.VISUAL_ID != ScrmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getRefinements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Requirement) {
				continue;
			}
			Requirement dst = (Requirement) theTarget;
			Requirement src = link.getRefinedRequirement();
			if (src != source) {
				continue;
			}
			result.add(new ScrmLinkDescriptor(src, dst, link,
					ScrmElementTypes.Requirement_4036,
					RequirementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_DefiningData_4038(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDefiningData().iterator(); destinations
				.hasNext();) {
			DataDefinition destination = (DataDefinition) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.RequirementDefiningData_4038,
					RequirementDefiningDataEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Process_DataFlow_4040(
			Process source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		DataFlow destination = source.getDataFlow();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ProcessDataFlow_4040,
				ProcessDataFlowEditPart.VISUAL_ID));
		return result;
	}

}
