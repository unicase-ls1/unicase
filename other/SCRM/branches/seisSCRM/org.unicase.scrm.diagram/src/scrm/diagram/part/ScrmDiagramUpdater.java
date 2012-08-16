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
import scrm.SCRMSpace;
import scrm.diagram.edit.parts.Assumption2EditPart;
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ComputationalMesh2EditPart;
import scrm.diagram.edit.parts.ComputationalMeshEditPart;
import scrm.diagram.edit.parts.Constraint2EditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.ConstraintRestrictedFeatureEditPart;
import scrm.diagram.edit.parts.ControlParameter2EditPart;
import scrm.diagram.edit.parts.ControlParameterControlledProcessEditPart;
import scrm.diagram.edit.parts.ControlParameterEditPart;
import scrm.diagram.edit.parts.DataDefinition2EditPart;
import scrm.diagram.edit.parts.DataDefinitionDefinedRequirementEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataDefinitionProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.DataDefinitionRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.DataProcessSpace2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.DataProcessSpaceEditPart;
import scrm.diagram.edit.parts.ErrorHandling2EditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.ErrorHandlingHandledProcessEditPart;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureSuperFeatureEditPart;
import scrm.diagram.edit.parts.Hardware2EditPart;
import scrm.diagram.edit.parts.HardwareEditPart;
import scrm.diagram.edit.parts.InputDataReading2EditPart;
import scrm.diagram.edit.parts.InputDataReadingEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.KnowledgeSpace2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModel2EditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelInvolvedDataEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelRefinementsEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart;
import scrm.diagram.edit.parts.MeshCreation2EditPart;
import scrm.diagram.edit.parts.MeshCreationEditPart;
import scrm.diagram.edit.parts.NumericalMethod2EditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.NumericalMethodSolvedProblemEditPart;
import scrm.diagram.edit.parts.Performance2EditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.PerformanceHardwareEditPart;
import scrm.diagram.edit.parts.PostProcessing2EditPart;
import scrm.diagram.edit.parts.PostProcessingEditPart;
import scrm.diagram.edit.parts.PreProcessing2EditPart;
import scrm.diagram.edit.parts.PreProcessingEditPart;
import scrm.diagram.edit.parts.Process2EditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.ProcessSuccessorEditPart;
import scrm.diagram.edit.parts.Requirement2EditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.RequirementProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.RequirementRefinedRequirementEditPart;
import scrm.diagram.edit.parts.RequirementRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.RequirementSpace2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceEditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.RequirementSpecifiedFeatureEditPart;
import scrm.diagram.edit.parts.ResultsOutput2EditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificProblem2EditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.edit.parts.SeismicSource2EditPart;
import scrm.diagram.edit.parts.SeismicSourceEditPart;
import scrm.diagram.edit.parts.SoftwareInterface2EditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.Solver2EditPart;
import scrm.diagram.edit.parts.SolverEditPart;
import scrm.diagram.edit.parts.Station2EditPart;
import scrm.diagram.edit.parts.StationEditPart;
import scrm.diagram.edit.parts.StatusMonitoring2EditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.StatusMonitoringMonitoredProcessEditPart;
import scrm.diagram.edit.parts.SyntheticSeismogram2EditPart;
import scrm.diagram.edit.parts.SyntheticSeismogramEditPart;
import scrm.diagram.edit.parts.UserInterface2EditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificKnowledge;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.IRequirement;
import scrm.requirements.Interface;
import scrm.requirements.Performance;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
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
		case KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID:
			return getKnowledgeSpaceKnowledgeSpaceCompartment_7001SemanticChildren(view);
		case KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID:
			return getKnowledgeSpaceKnowledgeSpaceCompartment_7002SemanticChildren(view);
		case RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID:
			return getRequirementSpaceRequirementSpaceCompartment_7003SemanticChildren(view);
		case RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID:
			return getRequirementSpaceRequirementSpaceCompartment_7004SemanticChildren(view);
		case DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID:
			return getDataProcessSpaceDataProcessSpaceCompartment_7005SemanticChildren(view);
		case DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID:
			return getDataProcessSpaceDataProcessSpaceCompartment_7006SemanticChildren(view);
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
			if (visualID == Mathematical_GeophysicalModelEditPart.VISUAL_ID) {
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
			if (visualID == RequirementEditPart.VISUAL_ID) {
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
			if (visualID == PerformanceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ProcessEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InputDataReadingEditPart.VISUAL_ID) {
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
			if (visualID == SolverEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MeshCreationEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PreProcessingEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PostProcessingEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataDefinitionEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SeismicSourceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComputationalMeshEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SyntheticSeismogramEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StationEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ControlParameterEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == KnowledgeSpaceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RequirementSpaceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataProcessSpaceEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: included indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getKnowledgeSpaceKnowledgeSpaceCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		KnowledgeSpace modelElement = (KnowledgeSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedScientificKnowledge()
				.iterator(); it.hasNext();) {
			ScientificKnowledge childElement = (ScientificKnowledge) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ScientificProblem2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == NumericalMethod2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Mathematical_GeophysicalModel2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Assumption2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == KnowledgeSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: included indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getKnowledgeSpaceKnowledgeSpaceCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		KnowledgeSpace modelElement = (KnowledgeSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedScientificKnowledge()
				.iterator(); it.hasNext();) {
			ScientificKnowledge childElement = (ScientificKnowledge) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ScientificProblem2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == NumericalMethod2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Mathematical_GeophysicalModel2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Assumption2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == KnowledgeSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: included indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getRequirementSpaceRequirementSpaceCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RequirementSpace modelElement = (RequirementSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement
				.getContainedInformationofRequirements().iterator(); it
				.hasNext();) {
			IRequirement childElement = (IRequirement) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Requirement2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Feature2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Hardware2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == UserInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SoftwareInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Performance2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Process2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == InputDataReading2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Solver2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == MeshCreation2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PreProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PostProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataDefinition2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SeismicSource2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ComputationalMesh2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SyntheticSeismogram2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Station2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ControlParameter2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == RequirementSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataProcessSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: included indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getRequirementSpaceRequirementSpaceCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RequirementSpace modelElement = (RequirementSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement
				.getContainedInformationofRequirements().iterator(); it
				.hasNext();) {
			IRequirement childElement = (IRequirement) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Requirement2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Feature2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Hardware2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == UserInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SoftwareInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Performance2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Process2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == InputDataReading2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Solver2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == MeshCreation2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PreProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PostProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataDefinition2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SeismicSource2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ComputationalMesh2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SyntheticSeismogram2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Station2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ControlParameter2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == RequirementSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataProcessSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: included indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getDataProcessSpaceDataProcessSpaceCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedDataProcessSteps()
				.iterator(); it.hasNext();) {
			scrm.requirements.dataProcess.Process childElement = (scrm.requirements.dataProcess.Process) it
					.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Process2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == InputDataReading2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataProcessSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Solver2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == MeshCreation2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PreProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PostProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: include indirect contents as well
	 */
	public static List<ScrmNodeDescriptor> getDataProcessSpaceDataProcessSpaceCompartment_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedDataProcessSteps()
				.iterator(); it.hasNext();) {
			scrm.requirements.dataProcess.Process childElement = (scrm.requirements.dataProcess.Process) it
					.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Process2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == InputDataReading2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataProcessSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Solver2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MeshCreation2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PreProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == PostProcessing2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT: custom method to include all contents of SCRMSpace
	 */
	private static Collection<ScrmNodeDescriptor> getAllContents(View view,
			EObject parent) {
		List<ScrmNodeDescriptor> allContents = new LinkedList<ScrmNodeDescriptor>();
		for (EObject child : parent.eContents()) {
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view, child);
			allContents.add(new ScrmNodeDescriptor(child, visualID));
			if (!(child instanceof SCRMSpace)) {
				allContents.addAll(getAllContents(view, child));
			}
		}
		return allContents;
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
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_2047ContainedLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006ContainedLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008ContainedLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034ContainedLinks(view);
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
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015ContainedLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2035ContainedLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036ContainedLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038ContainedLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039ContainedLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040ContainedLinks(view);
		case SolverEditPart.VISUAL_ID:
			return getSolver_2048ContainedLinks(view);
		case MeshCreationEditPart.VISUAL_ID:
			return getMeshCreation_2049ContainedLinks(view);
		case PreProcessingEditPart.VISUAL_ID:
			return getPreProcessing_2050ContainedLinks(view);
		case PostProcessingEditPart.VISUAL_ID:
			return getPostProcessing_2051ContainedLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2052ContainedLinks(view);
		case SeismicSourceEditPart.VISUAL_ID:
			return getSeismicSource_2053ContainedLinks(view);
		case ComputationalMeshEditPart.VISUAL_ID:
			return getComputationalMesh_2054ContainedLinks(view);
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return getSyntheticSeismogram_2055ContainedLinks(view);
		case StationEditPart.VISUAL_ID:
			return getStation_2056ContainedLinks(view);
		case ControlParameterEditPart.VISUAL_ID:
			return getControlParameter_2057ContainedLinks(view);
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getKnowledgeSpace_2044ContainedLinks(view);
		case RequirementSpaceEditPart.VISUAL_ID:
			return getRequirementSpace_2045ContainedLinks(view);
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getDataProcessSpace_2046ContainedLinks(view);
		case ScientificProblem2EditPart.VISUAL_ID:
			return getScientificProblem_3001ContainedLinks(view);
		case NumericalMethod2EditPart.VISUAL_ID:
			return getNumericalMethod_3002ContainedLinks(view);
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_3030ContainedLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004ContainedLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005ContainedLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012ContainedLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009ContainedLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006ContainedLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014ContainedLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013ContainedLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011ContainedLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3025ContainedLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3026ContainedLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3024ContainedLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3027ContainedLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3023ContainedLinks(view);
		case Solver2EditPart.VISUAL_ID:
			return getSolver_3031ContainedLinks(view);
		case MeshCreation2EditPart.VISUAL_ID:
			return getMeshCreation_3032ContainedLinks(view);
		case PreProcessing2EditPart.VISUAL_ID:
			return getPreProcessing_3033ContainedLinks(view);
		case PostProcessing2EditPart.VISUAL_ID:
			return getPostProcessing_3034ContainedLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3035ContainedLinks(view);
		case SeismicSource2EditPart.VISUAL_ID:
			return getSeismicSource_3036ContainedLinks(view);
		case ComputationalMesh2EditPart.VISUAL_ID:
			return getComputationalMesh_3037ContainedLinks(view);
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return getSyntheticSeismogram_3038ContainedLinks(view);
		case Station2EditPart.VISUAL_ID:
			return getStation_3039ContainedLinks(view);
		case ControlParameter2EditPart.VISUAL_ID:
			return getControlParameter_3040ContainedLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015ContainedLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3029ContainedLinks(view);
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
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_2047IncomingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006IncomingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008IncomingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034IncomingLinks(view);
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
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015IncomingLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2035IncomingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036IncomingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038IncomingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039IncomingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040IncomingLinks(view);
		case SolverEditPart.VISUAL_ID:
			return getSolver_2048IncomingLinks(view);
		case MeshCreationEditPart.VISUAL_ID:
			return getMeshCreation_2049IncomingLinks(view);
		case PreProcessingEditPart.VISUAL_ID:
			return getPreProcessing_2050IncomingLinks(view);
		case PostProcessingEditPart.VISUAL_ID:
			return getPostProcessing_2051IncomingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2052IncomingLinks(view);
		case SeismicSourceEditPart.VISUAL_ID:
			return getSeismicSource_2053IncomingLinks(view);
		case ComputationalMeshEditPart.VISUAL_ID:
			return getComputationalMesh_2054IncomingLinks(view);
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return getSyntheticSeismogram_2055IncomingLinks(view);
		case StationEditPart.VISUAL_ID:
			return getStation_2056IncomingLinks(view);
		case ControlParameterEditPart.VISUAL_ID:
			return getControlParameter_2057IncomingLinks(view);
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getKnowledgeSpace_2044IncomingLinks(view);
		case RequirementSpaceEditPart.VISUAL_ID:
			return getRequirementSpace_2045IncomingLinks(view);
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getDataProcessSpace_2046IncomingLinks(view);
		case ScientificProblem2EditPart.VISUAL_ID:
			return getScientificProblem_3001IncomingLinks(view);
		case NumericalMethod2EditPart.VISUAL_ID:
			return getNumericalMethod_3002IncomingLinks(view);
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_3030IncomingLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004IncomingLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005IncomingLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012IncomingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009IncomingLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006IncomingLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014IncomingLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013IncomingLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011IncomingLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3025IncomingLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3026IncomingLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3024IncomingLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3027IncomingLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3023IncomingLinks(view);
		case Solver2EditPart.VISUAL_ID:
			return getSolver_3031IncomingLinks(view);
		case MeshCreation2EditPart.VISUAL_ID:
			return getMeshCreation_3032IncomingLinks(view);
		case PreProcessing2EditPart.VISUAL_ID:
			return getPreProcessing_3033IncomingLinks(view);
		case PostProcessing2EditPart.VISUAL_ID:
			return getPostProcessing_3034IncomingLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3035IncomingLinks(view);
		case SeismicSource2EditPart.VISUAL_ID:
			return getSeismicSource_3036IncomingLinks(view);
		case ComputationalMesh2EditPart.VISUAL_ID:
			return getComputationalMesh_3037IncomingLinks(view);
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return getSyntheticSeismogram_3038IncomingLinks(view);
		case Station2EditPart.VISUAL_ID:
			return getStation_3039IncomingLinks(view);
		case ControlParameter2EditPart.VISUAL_ID:
			return getControlParameter_3040IncomingLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015IncomingLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3029IncomingLinks(view);
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
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_2047OutgoingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006OutgoingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008OutgoingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034OutgoingLinks(view);
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
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015OutgoingLinks(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2035OutgoingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036OutgoingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038OutgoingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039OutgoingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040OutgoingLinks(view);
		case SolverEditPart.VISUAL_ID:
			return getSolver_2048OutgoingLinks(view);
		case MeshCreationEditPart.VISUAL_ID:
			return getMeshCreation_2049OutgoingLinks(view);
		case PreProcessingEditPart.VISUAL_ID:
			return getPreProcessing_2050OutgoingLinks(view);
		case PostProcessingEditPart.VISUAL_ID:
			return getPostProcessing_2051OutgoingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2052OutgoingLinks(view);
		case SeismicSourceEditPart.VISUAL_ID:
			return getSeismicSource_2053OutgoingLinks(view);
		case ComputationalMeshEditPart.VISUAL_ID:
			return getComputationalMesh_2054OutgoingLinks(view);
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return getSyntheticSeismogram_2055OutgoingLinks(view);
		case StationEditPart.VISUAL_ID:
			return getStation_2056OutgoingLinks(view);
		case ControlParameterEditPart.VISUAL_ID:
			return getControlParameter_2057OutgoingLinks(view);
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getKnowledgeSpace_2044OutgoingLinks(view);
		case RequirementSpaceEditPart.VISUAL_ID:
			return getRequirementSpace_2045OutgoingLinks(view);
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getDataProcessSpace_2046OutgoingLinks(view);
		case ScientificProblem2EditPart.VISUAL_ID:
			return getScientificProblem_3001OutgoingLinks(view);
		case NumericalMethod2EditPart.VISUAL_ID:
			return getNumericalMethod_3002OutgoingLinks(view);
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_3030OutgoingLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004OutgoingLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005OutgoingLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012OutgoingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009OutgoingLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006OutgoingLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014OutgoingLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013OutgoingLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011OutgoingLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3025OutgoingLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3026OutgoingLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3024OutgoingLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3027OutgoingLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3023OutgoingLinks(view);
		case Solver2EditPart.VISUAL_ID:
			return getSolver_3031OutgoingLinks(view);
		case MeshCreation2EditPart.VISUAL_ID:
			return getMeshCreation_3032OutgoingLinks(view);
		case PreProcessing2EditPart.VISUAL_ID:
			return getPreProcessing_3033OutgoingLinks(view);
		case PostProcessing2EditPart.VISUAL_ID:
			return getPostProcessing_3034OutgoingLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3035OutgoingLinks(view);
		case SeismicSource2EditPart.VISUAL_ID:
			return getSeismicSource_3036OutgoingLinks(view);
		case ComputationalMesh2EditPart.VISUAL_ID:
			return getComputationalMesh_3037OutgoingLinks(view);
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return getSyntheticSeismogram_3038OutgoingLinks(view);
		case Station2EditPart.VISUAL_ID:
			return getStation_3039OutgoingLinks(view);
		case ControlParameter2EditPart.VISUAL_ID:
			return getControlParameter_3040OutgoingLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015OutgoingLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3029OutgoingLinks(view);
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
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_2047ContainedLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_2006ContainedLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4069(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_2008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_2034ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_2009ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
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
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_2012ContainedLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_2013ContainedLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015ContainedLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Performance_Hardware_4074(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2035ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2036ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2038ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2039ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2040ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_2048ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_2049ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_2050ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_2051ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2052ContainedLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_2053ContainedLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_2054ContainedLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_2055ContainedLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_2056ContainedLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_2057ContainedLinks(
			View view) {
		scrm.requirements.dataObject.ControlParameter modelElement = (scrm.requirements.dataObject.ControlParameter) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_2044ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_2045ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_2046ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_3001ContainedLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_3002ContainedLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4069(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_3030ContainedLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_3012ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_3009ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_3010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_3006ContainedLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_3014ContainedLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_3013ContainedLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_3011ContainedLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Performance_Hardware_4074(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3025ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3026ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3024ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3027ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3023ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3031ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3032ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3033ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3034ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_3035ContainedLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_3036ContainedLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_3037ContainedLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_3038ContainedLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_3039ContainedLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_3040ContainedLinks(
			View view) {
		scrm.requirements.dataObject.ControlParameter modelElement = (scrm.requirements.dataObject.ControlParameter) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_3015ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3029ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3018ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3019ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3017ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3020ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3022ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3041ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3042ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3043ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3044ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_2007IncomingLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_2047IncomingLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_2034IncomingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
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
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_SuperFeature_4053(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Dependencies_4026(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Performance_Hardware_4074(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_2011IncomingLinks(
			View view) {
		return Collections.emptyList();
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
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
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4069(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2035IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2036IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2038IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2039IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2040IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_2048IncomingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_2049IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_2050IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_2051IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2052IncomingLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_2053IncomingLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_2054IncomingLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_2055IncomingLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_2056IncomingLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_2057IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_2044IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_2045IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_2046IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_3001IncomingLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_3002IncomingLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_3030IncomingLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_3004IncomingLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_3005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_3012IncomingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_3009IncomingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_SuperFeature_4053(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_3010IncomingLinks(
			View view) {
		Hardware modelElement = (Hardware) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Dependencies_4026(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Performance_Hardware_4074(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_3006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_3014IncomingLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_3013IncomingLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_3011IncomingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4069(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3025IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3026IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3024IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3027IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3023IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3031IncomingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3032IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3033IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3034IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_3035IncomingLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_3036IncomingLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_3037IncomingLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_3038IncomingLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_3039IncomingLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_3040IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_3015IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3029IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3018IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3019IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3017IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3020IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3022IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3041IncomingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3042IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3043IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3044IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
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
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_2047OutgoingLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_2006OutgoingLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4069(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_2008OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_2034OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_2009OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
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
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_2012OutgoingLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_2013OutgoingLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015OutgoingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Performance_Hardware_4074(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_2035OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_2036OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_2038OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_2039OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_2040OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_2048OutgoingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_2049OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_2050OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_2051OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2052OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_2053OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_2054OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_2055OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_2056OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_2057OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.ControlParameter modelElement = (scrm.requirements.dataObject.ControlParameter) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_2044OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_2045OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_2046OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getScientificProblem_3001OutgoingLinks(
			View view) {
		ScientificProblem modelElement = (ScientificProblem) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getNumericalMethod_3002OutgoingLinks(
			View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4069(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematical_GeophysicalModel_3030OutgoingLinks(
			View view) {
		Mathematical_GeophysicalModel modelElement = (Mathematical_GeophysicalModel) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getAssumption_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getKnowledgeSpace_3005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_3012OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_3009OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getHardware_3010OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getConstraint_3006OutgoingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_3014OutgoingLinks(
			View view) {
		UserInterface modelElement = (UserInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_3013OutgoingLinks(
			View view) {
		SoftwareInterface modelElement = (SoftwareInterface) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_3011OutgoingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Performance_Hardware_4074(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3025OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3026OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3024OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3027OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3023OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3031OutgoingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3032OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3033OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3034OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_3035OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.DataDefinition modelElement = (scrm.requirements.dataObject.DataDefinition) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSeismicSource_3036OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.SeismicSource modelElement = (scrm.requirements.dataObject.SeismicSource) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getComputationalMesh_3037OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.ComputationalMesh modelElement = (scrm.requirements.dataObject.ComputationalMesh) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSyntheticSeismogram_3038OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.SyntheticSeismogram modelElement = (scrm.requirements.dataObject.SyntheticSeismogram) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStation_3039OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.Station modelElement = (scrm.requirements.dataObject.Station) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getControlParameter_3040OutgoingLinks(
			View view) {
		scrm.requirements.dataObject.ControlParameter modelElement = (scrm.requirements.dataObject.ControlParameter) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirementSpace_3015OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3029OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getProcess_3018OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getInputDataReading_3019OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.InputDataReading modelElement = (scrm.requirements.dataProcess.InputDataReading) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getResultsOutput_3017OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ResultsOutput modelElement = (scrm.requirements.dataProcess.ResultsOutput) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getErrorHandling_3020OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.ErrorHandling modelElement = (scrm.requirements.dataProcess.ErrorHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataProcessSpace_3022OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.DataProcessSpace modelElement = (scrm.requirements.dataProcess.DataProcessSpace) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSolver_3041OutgoingLinks(View view) {
		scrm.requirements.dataProcess.Solver modelElement = (scrm.requirements.dataProcess.Solver) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMeshCreation_3042OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.MeshCreation modelElement = (scrm.requirements.dataProcess.MeshCreation) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPreProcessing_3043OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PreProcessing modelElement = (scrm.requirements.dataProcess.PreProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPostProcessing_3044OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.PostProcessing modelElement = (scrm.requirements.dataProcess.PostProcessing) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(
			Mathematical_GeophysicalModel target,
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
						ScrmElementTypes.ScientificProblemRepresentingModel_4063,
						ScientificProblemRepresentingModelEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(
			Mathematical_GeophysicalModel target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematical_GeophysicalModel_Refinements()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064,
						Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(
			NumericalMethod target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematical_GeophysicalModel_UsedInNumericalMethods()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065,
						Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(
			Assumption target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematical_GeophysicalModel_Dependencies()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066,
						Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
			scrm.requirements.dataObject.DataDefinition target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematical_GeophysicalModel_InvolvedData()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067,
						Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(
			ScientificProblem target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getNumericalMethod_SolvedProblem()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.NumericalMethodSolvedProblem_4057,
						NumericalMethodSolvedProblemEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
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
						ScrmElementTypes.NumericalMethodRealizingRequirement_4068,
						NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4069(
			Performance target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getNumericalMethod_Performance()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.NumericalMethodPerformance_4069,
						NumericalMethodPerformanceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getInterface_DetailsOfProvidingFunctionsAndProperties()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070,
						InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getInterface_DetailsOfRequiringFunctionsAndProperties()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071,
						InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_RefinedRequirement()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementRefinedRequirement_4054,
						RequirementRefinedRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_SpecifiedFeature()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementSpecifiedFeature_4052,
						RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_ProvidedInterface()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementProvidedInterface_4072,
						RequirementProvidedInterfaceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_RequiredInterface()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementRequiredInterface_4073,
						RequirementRequiredInterfaceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_SuperFeature_4053(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getFeature_SuperFeature()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.FeatureSuperFeature_4053,
						FeatureSuperFeatureEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getConstraint_RestrictedFeature()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ConstraintRestrictedFeature_4051,
						ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Performance_Hardware_4074(
			Hardware target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getPerformance_Hardware()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.PerformanceHardware_4074,
						PerformanceHardwareEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Process_Successor_4047(
			scrm.requirements.dataProcess.Process target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getProcess_Successor()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ProcessSuccessor_4047,
						ProcessSuccessorEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
			scrm.requirements.dataProcess.Process target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getErrorHandling_HandledProcess()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.ErrorHandlingHandledProcess_4061,
						ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
			scrm.requirements.dataProcess.Process target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
					.getStatusMonitoring_MonitoredProcess()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.StatusMonitoringMonitoredProcess_4062,
						StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_DefinedRequirement()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.DataDefinitionDefinedRequirement_4075,
						DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_ProvidedInterface()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.DataDefinitionProvidedInterface_4076,
						DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getDataDefinition_RequiredInterface()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.DataDefinitionRequiredInterface_4077,
						DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
			scrm.requirements.dataProcess.Process target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
					.getControlParameter_ControlledProcess()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.ControlParameterControlledProcess_4078,
						ControlParameterControlledProcessEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ScientificProblem_RepresentingModel_4063(
			ScientificProblem source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getRepresentingModel()
				.iterator(); destinations.hasNext();) {
			Mathematical_GeophysicalModel destination = (Mathematical_GeophysicalModel) destinations
					.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.ScientificProblemRepresentingModel_4063,
					ScientificProblemRepresentingModelEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Refinements_4064(
			Mathematical_GeophysicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getRefinements().iterator(); destinations
				.hasNext();) {
			Mathematical_GeophysicalModel destination = (Mathematical_GeophysicalModel) destinations
					.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064,
					Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_UsedInNumericalMethods_4065(
			Mathematical_GeophysicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getUsedInNumericalMethods()
				.iterator(); destinations.hasNext();) {
			NumericalMethod destination = (NumericalMethod) destinations.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065,
					Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_Dependencies_4066(
			Mathematical_GeophysicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getDependencies().iterator(); destinations
				.hasNext();) {
			Assumption destination = (Assumption) destinations.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066,
					Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mathematical_GeophysicalModel_InvolvedData_4067(
			Mathematical_GeophysicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getInvolvedData().iterator(); destinations
				.hasNext();) {
			scrm.requirements.dataObject.DataDefinition destination = (scrm.requirements.dataObject.DataDefinition) destinations
					.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067,
					Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		ScientificProblem destination = source.getSolvedProblem();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.NumericalMethodSolvedProblem_4057,
				NumericalMethodSolvedProblemEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_RealizingRequirement_4068(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Requirement destination = source.getRealizingRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.NumericalMethodRealizingRequirement_4068,
				NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4069(
			NumericalMethod source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Performance destination = source.getPerformance();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.NumericalMethodPerformance_4069,
				NumericalMethodPerformanceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Interface_DetailsOfProvidingFunctionsAndProperties_4070(
			Interface source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source
				.getDetailsOfProvidingFunctionsAndProperties().iterator(); destinations
				.hasNext();) {
			Requirement destination = (Requirement) destinations.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070,
					InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Interface_DetailsOfRequiringFunctionsAndProperties_4071(
			Interface source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source
				.getDetailsOfRequiringFunctionsAndProperties().iterator(); destinations
				.hasNext();) {
			Requirement destination = (Requirement) destinations.next();
			result.add(new ScrmLinkDescriptor(
					source,
					destination,
					ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071,
					InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Requirement destination = source.getRefinedRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.RequirementRefinedRequirement_4054,
				RequirementRefinedRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Feature destination = source.getSpecifiedFeature();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.RequirementSpecifiedFeature_4052,
				RequirementSpecifiedFeatureEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_ProvidedInterface_4072(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Interface destination = source.getProvidedInterface();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.RequirementProvidedInterface_4072,
				RequirementProvidedInterfaceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_RequiredInterface_4073(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Interface destination = source.getRequiredInterface();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.RequirementRequiredInterface_4073,
				RequirementRequiredInterfaceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		for (Iterator<?> destinations = source.getSuperFeature().iterator(); destinations
				.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new ScrmLinkDescriptor(source, destination,
					ScrmElementTypes.FeatureSuperFeature_4053,
					FeatureSuperFeatureEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
			Constraint source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Feature destination = source.getRestrictedFeature();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ConstraintRestrictedFeature_4051,
				ConstraintRestrictedFeatureEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Performance_Hardware_4074(
			Performance source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Hardware destination = source.getHardware();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.PerformanceHardware_4074,
				PerformanceHardwareEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Process_Successor_4047(
			scrm.requirements.dataProcess.Process source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		scrm.requirements.dataProcess.Process destination = source
				.getSuccessor();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ProcessSuccessor_4047,
				ProcessSuccessorEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ErrorHandling_HandledProcess_4061(
			scrm.requirements.dataProcess.ErrorHandling source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		scrm.requirements.dataProcess.Process destination = source
				.getHandledProcess();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ErrorHandlingHandledProcess_4061,
				ErrorHandlingHandledProcessEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_StatusMonitoring_MonitoredProcess_4062(
			scrm.requirements.dataProcess.StatusMonitoring source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		scrm.requirements.dataProcess.Process destination = source
				.getMonitoredProcess();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.StatusMonitoringMonitoredProcess_4062,
				StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4075(
			scrm.requirements.dataObject.DataDefinition source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Requirement destination = source.getDefinedRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.DataDefinitionDefinedRequirement_4075,
				DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_DataDefinition_ProvidedInterface_4076(
			scrm.requirements.dataObject.DataDefinition source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Interface destination = source.getProvidedInterface();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.DataDefinitionProvidedInterface_4076,
				DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_DataDefinition_RequiredInterface_4077(
			scrm.requirements.dataObject.DataDefinition source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Interface destination = source.getRequiredInterface();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.DataDefinitionRequiredInterface_4077,
				DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_ControlParameter_ControlledProcess_4078(
			scrm.requirements.dataObject.ControlParameter source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		scrm.requirements.dataProcess.Process destination = source
				.getControlledProcess();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.ControlParameterControlledProcess_4078,
				ControlParameterControlledProcessEditPart.VISUAL_ID));
		return result;
	}

}
