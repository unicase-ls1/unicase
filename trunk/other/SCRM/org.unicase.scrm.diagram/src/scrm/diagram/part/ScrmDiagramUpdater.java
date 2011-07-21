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
import scrm.diagram.edit.parts.Constraint2EditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.ConstraintRestrictedFeatureEditPart;
import scrm.diagram.edit.parts.DataDefinition2EditPart;
import scrm.diagram.edit.parts.DataDefinitionDefinedRequirementEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataFlow2EditPart;
import scrm.diagram.edit.parts.DataFlowEditPart;
import scrm.diagram.edit.parts.DataFlowSpecifiedProcessEditPart;
import scrm.diagram.edit.parts.DataHandling2EditPart;
import scrm.diagram.edit.parts.DataHandlingEditPart;
import scrm.diagram.edit.parts.DataProcessSpace2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.DataProcessSpaceEditPart;
import scrm.diagram.edit.parts.ErrorHandling2EditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
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
import scrm.diagram.edit.parts.KnowledgeSpace2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.MathematicalModel2EditPart;
import scrm.diagram.edit.parts.MathematicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.MathematicalModelRefinedModelEditPart;
import scrm.diagram.edit.parts.MathematicalModelRepresentedProblemEditPart;
import scrm.diagram.edit.parts.NumericalMethod2EditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodSolvedProblemEditPart;
import scrm.diagram.edit.parts.Performance2EditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.Process2EditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.ProcessSuccessorEditPart;
import scrm.diagram.edit.parts.Requirement2EditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.RequirementRealizedMethodEditPart;
import scrm.diagram.edit.parts.RequirementRefinedRequirementEditPart;
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
import scrm.diagram.edit.parts.SoftwareInterface2EditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.StatusMonitoring2EditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.UserInterface2EditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
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
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;
import scrm.requirements.UserInterface;
import scrm.requirements.dataProcess.DataProcessSpace;

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
			if (visualID == RequirementEditPart.VISUAL_ID) {
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
	 * @generated NOT: include indirect contents as well
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
			if (visualID == MathematicalModel2EditPart.VISUAL_ID) {
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
	 * @generated NOT: include indirect contents as well
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
			if (visualID == MathematicalModel2EditPart.VISUAL_ID) {
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
	 * @generated NOT: include indirect contents as well
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
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataDefinition2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataFlow2EditPart.VISUAL_ID) {
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
			if (visualID == Performance2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Requirement2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SoftwareInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == UserInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == RequirementSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
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
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
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
	 * @generated NOT: include indirect contents as well
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
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataDefinition2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataFlow2EditPart.VISUAL_ID) {
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
			if (visualID == Performance2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == Requirement2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == SoftwareInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == UserInterface2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == RequirementSpace2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
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
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
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
		DataProcessSpace modelElement = (DataProcessSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedDataProcessSteps()
				.iterator(); it.hasNext();) {
			scrm.requirements.dataProcess.Process childElement = (scrm.requirements.dataProcess.Process) it
					.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
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
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
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
	 * @generated NOT: include indirect contents as well
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
		DataProcessSpace modelElement = (DataProcessSpace) containerView
				.getElement();
		LinkedList<ScrmNodeDescriptor> result = new LinkedList<ScrmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainedDataProcessSteps()
				.iterator(); it.hasNext();) {
			scrm.requirements.dataProcess.Process childElement = (scrm.requirements.dataProcess.Process) it
					.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StatusMonitoring2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == ResultsOutput2EditPart.VISUAL_ID) {
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
			if (visualID == ErrorHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
				continue;
			}
			if (visualID == DataHandling2EditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				result.addAll(getAllContents(view, childElement));
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
	 * @generated NOT: custom method to include all contents of SCRMSpace
	 */
	private static Collection<ScrmNodeDescriptor> getAllContents(
			View view, EObject parent) {
		List<ScrmNodeDescriptor> allContents = new LinkedList<ScrmNodeDescriptor>();
		for(EObject child : parent.eContents()) {
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view,
					child);
			allContents.add(new ScrmNodeDescriptor(child, visualID));
			if(!(child instanceof SCRMSpace)) {
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
			return getProcess_2035ContainedLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015ContainedLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016ContainedLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017ContainedLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036ContainedLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2037ContainedLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038ContainedLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039ContainedLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040ContainedLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034ContainedLinks(view);
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
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_3003ContainedLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004ContainedLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006ContainedLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3007ContainedLinks(view);
		case DataFlow2EditPart.VISUAL_ID:
			return getDataFlow_3008ContainedLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009ContainedLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010ContainedLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011ContainedLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012ContainedLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013ContainedLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014ContainedLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015ContainedLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3016ContainedLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3017ContainedLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3018ContainedLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3019ContainedLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3020ContainedLinks(view);
		case DataHandling2EditPart.VISUAL_ID:
			return getDataHandling_3021ContainedLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3022ContainedLinks(view);
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
			return getProcess_2035IncomingLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015IncomingLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016IncomingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017IncomingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036IncomingLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2037IncomingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038IncomingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039IncomingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040IncomingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034IncomingLinks(view);
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
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_3003IncomingLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004IncomingLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006IncomingLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3007IncomingLinks(view);
		case DataFlow2EditPart.VISUAL_ID:
			return getDataFlow_3008IncomingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009IncomingLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010IncomingLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011IncomingLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012IncomingLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013IncomingLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014IncomingLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015IncomingLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3016IncomingLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3017IncomingLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3018IncomingLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3019IncomingLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3020IncomingLinks(view);
		case DataHandling2EditPart.VISUAL_ID:
			return getDataHandling_3021IncomingLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3022IncomingLinks(view);
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
			return getProcess_2035OutgoingLinks(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015OutgoingLinks(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016OutgoingLinks(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017OutgoingLinks(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036OutgoingLinks(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2037OutgoingLinks(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038OutgoingLinks(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039OutgoingLinks(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040OutgoingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034OutgoingLinks(view);
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
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_3003OutgoingLinks(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004OutgoingLinks(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006OutgoingLinks(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3007OutgoingLinks(view);
		case DataFlow2EditPart.VISUAL_ID:
			return getDataFlow_3008OutgoingLinks(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009OutgoingLinks(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010OutgoingLinks(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011OutgoingLinks(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012OutgoingLinks(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013OutgoingLinks(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014OutgoingLinks(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015OutgoingLinks(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3016OutgoingLinks(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3017OutgoingLinks(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3018OutgoingLinks(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3019OutgoingLinks(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3020OutgoingLinks(view);
		case DataHandling2EditPart.VISUAL_ID:
			return getDataHandling_3021OutgoingLinks(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3022OutgoingLinks(view);
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
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
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
	public static List<ScrmLinkDescriptor> getFeature_2009ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
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
	public static List<ScrmLinkDescriptor> getProcess_2035ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015ContainedLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016ContainedLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017ContainedLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2037ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_2034ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_3003ContainedLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
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
	public static List<ScrmLinkDescriptor> getDataDefinition_3007ContainedLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_3008ContainedLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_3009ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
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
	public static List<ScrmLinkDescriptor> getPerformance_3011ContainedLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_3012ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_3014ContainedLinks(
			View view) {
		return Collections.emptyList();
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
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_3021ContainedLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(
				modelElement, crossReferences));
		return result;
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
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
		result.addAll(getIncomingFeatureModelFacetLinks_ScientificProblem_InfluencedFeature_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_SuperFeature_4053(
				modelElement, crossReferences));
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
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Dependencies_4026(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017IncomingLinks(
			View view) {
		return Collections.emptyList();
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2037IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		return result;
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(
				modelElement, crossReferences));
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_3003IncomingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(
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
		result.addAll(getIncomingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(
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
	public static List<ScrmLinkDescriptor> getConstraint_3006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_3007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_3008IncomingLinks(
			View view) {
		return Collections.emptyList();
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
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_RestrictedFeature_4051(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_SuperFeature_4053(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredFeatures_4030(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ExcludedFeatures_4032(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		return result;
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		return result;
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
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(
				modelElement, crossReferences));
		return result;
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
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_3021IncomingLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Process_Successor_4047(
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
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_SolvedProblem_4057(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Dependencies_4015(modelElement));
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
	public static List<ScrmLinkDescriptor> getFeature_2009OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
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
	public static List<ScrmLinkDescriptor> getProcess_2035OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.Process modelElement = (scrm.requirements.dataProcess.Process) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getPerformance_2015OutgoingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_2016OutgoingLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataDefinition_2017OutgoingLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_2037OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_2034OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getMathematicalModel_3003OutgoingLinks(
			View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_NumericalMethods_4011(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_MathematicalModel_Dependencies_4012(modelElement));
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
	public static List<ScrmLinkDescriptor> getDataDefinition_3007OutgoingLinks(
			View view) {
		DataDefinition modelElement = (DataDefinition) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataFlow_3008OutgoingLinks(
			View view) {
		DataFlow modelElement = (DataFlow) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getFeature_3009OutgoingLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_RequiredInterfaces_4023(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_ProvidedInterfaces_4024(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Dependencies_4026(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(modelElement));
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
	public static List<ScrmLinkDescriptor> getPerformance_3011OutgoingLinks(
			View view) {
		Performance modelElement = (Performance) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getRequirement_3012OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getSoftwareInterface_3013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getUserInterface_3014OutgoingLinks(
			View view) {
		return Collections.emptyList();
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
	public static List<ScrmLinkDescriptor> getStatusMonitoring_3016OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.StatusMonitoring modelElement = (scrm.requirements.dataProcess.StatusMonitoring) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ScrmLinkDescriptor> getDataHandling_3021OutgoingLinks(
			View view) {
		scrm.requirements.dataProcess.DataHandling modelElement = (scrm.requirements.dataProcess.DataHandling) view
				.getElement();
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_SpecifiedFeature_4052(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedRequirement_4054(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Process_Successor_4047(modelElement));
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(
			MathematicalModel target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematicalModel_RefinedModel()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.MathematicalModelRefinedModel_4058,
						MathematicalModelRefinedModelEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(
			ScientificProblem target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE
					.getMathematicalModel_RepresentedProblem()) {
				result.add(new ScrmLinkDescriptor(
						setting.getEObject(),
						target,
						ScrmElementTypes.MathematicalModelRepresentedProblem_4048,
						MathematicalModelRepresentedProblemEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(
			NumericalMethod target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getRequirement_RealizedMethod()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.RequirementRealizedMethod_4050,
						RequirementRealizedMethodEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
			NumericalMethod target,
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
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getDataDefinition_DefinedRequirement()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.DataDefinitionDefinedRequirement_4055,
						DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getIncomingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
			scrm.requirements.dataProcess.Process target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RequirementsPackage.eINSTANCE
					.getDataFlow_SpecifiedProcess()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
						ScrmElementTypes.DataFlowSpecifiedProcess_4056,
						DataFlowSpecifiedProcessEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_MathematicalModel_RefinedModel_4058(
			MathematicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		MathematicalModel destination = source.getRefinedModel();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.MathematicalModelRefinedModel_4058,
				MathematicalModelRefinedModelEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_MathematicalModel_RepresentedProblem_4048(
			MathematicalModel source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		ScientificProblem destination = source.getRepresentedProblem();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.MathematicalModelRepresentedProblem_4048,
				MathematicalModelRepresentedProblemEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_RealizedMethod_4050(
			Requirement source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		NumericalMethod destination = source.getRealizedMethod();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.RequirementRealizedMethod_4050,
				RequirementRealizedMethodEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_NumericalMethod_Performance_4017(
			Performance source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		NumericalMethod destination = source.getDescribedMethod();
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_SuperFeature_4053(
			Feature source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Feature destination = source.getSuperFeature();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.FeatureSuperFeature_4053,
				FeatureSuperFeatureEditPart.VISUAL_ID));
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
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_DataDefinition_DefinedRequirement_4055(
			DataDefinition source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		Requirement destination = source.getDefinedRequirement();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.DataDefinitionDefinedRequirement_4055,
				DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ScrmLinkDescriptor> getOutgoingFeatureModelFacetLinks_DataFlow_SpecifiedProcess_4056(
			DataFlow source) {
		LinkedList<ScrmLinkDescriptor> result = new LinkedList<ScrmLinkDescriptor>();
		scrm.requirements.dataProcess.Process destination = source
				.getSpecifiedProcess();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination,
				ScrmElementTypes.DataFlowSpecifiedProcess_4056,
				DataFlowSpecifiedProcessEditPart.VISUAL_ID));
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

}
