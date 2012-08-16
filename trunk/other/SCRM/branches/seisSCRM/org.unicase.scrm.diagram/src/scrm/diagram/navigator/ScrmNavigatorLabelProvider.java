package scrm.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import scrm.SCRMDiagram;
import scrm.diagram.edit.parts.*;
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.diagram.providers.ScrmParserProvider;

/**
 * @generated
 */
public class ScrmNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ScrmDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ScrmDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ScrmNavigatorItem
				&& !isOwnView(((ScrmNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ScrmNavigatorGroup) {
			ScrmNavigatorGroup group = (ScrmNavigatorGroup) element;
			return ScrmDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem navigatorItem = (ScrmNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case DataDefinition2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?DataDefinition", ScrmElementTypes.DataDefinition_3035); //$NON-NLS-1$
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?dependencies", ScrmElementTypes.NumericalMethodDependencies_4015); //$NON-NLS-1$
		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel?dependencies", ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066); //$NON-NLS-1$
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?SyntheticSeismogram", ScrmElementTypes.SyntheticSeismogram_2055); //$NON-NLS-1$
		case AssumptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?Assumption", ScrmElementTypes.Assumption_2008); //$NON-NLS-1$
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?DataProcessSpace", ScrmElementTypes.DataProcessSpace_2046); //$NON-NLS-1$
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?excludedFeatures", ScrmElementTypes.FeatureExcludedFeatures_4032); //$NON-NLS-1$
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?performance", ScrmElementTypes.NumericalMethodPerformance_4069); //$NON-NLS-1$
		case Hardware2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Hardware", ScrmElementTypes.Hardware_3010); //$NON-NLS-1$
		case SeismicSourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?SeismicSource", ScrmElementTypes.SeismicSource_2053); //$NON-NLS-1$
		case ControlParameterControlledProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataObject?ControlParameter?controlledProcess", ScrmElementTypes.ControlParameterControlledProcess_4078); //$NON-NLS-1$
		case ScientificProblem2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?ScientificProblem", ScrmElementTypes.ScientificProblem_3001); //$NON-NLS-1$
		case ResultsOutput2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?ResultsOutput", ScrmElementTypes.ResultsOutput_3024); //$NON-NLS-1$
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel", ScrmElementTypes.Mathematical_GeophysicalModel_2047); //$NON-NLS-1$
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataObject?DataDefinition?definedRequirement", ScrmElementTypes.DataDefinitionDefinedRequirement_4075); //$NON-NLS-1$
		case HardwareEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Hardware", ScrmElementTypes.Hardware_2010); //$NON-NLS-1$
		case StatusMonitoringEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?StatusMonitoring", ScrmElementTypes.StatusMonitoring_2040); //$NON-NLS-1$
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?KnowledgeSpace", ScrmElementTypes.KnowledgeSpace_3005); //$NON-NLS-1$
		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel?refinements", ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064); //$NON-NLS-1$
		case Station2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?Station", ScrmElementTypes.Station_3039); //$NON-NLS-1$
		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataObject?DataDefinition?providedInterface", ScrmElementTypes.DataDefinitionProvidedInterface_4076); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Constraint", ScrmElementTypes.Constraint_2011); //$NON-NLS-1$
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?SyntheticSeismogram", ScrmElementTypes.SyntheticSeismogram_3038); //$NON-NLS-1$
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredInterfaces", ScrmElementTypes.FeatureRequiredInterfaces_4023); //$NON-NLS-1$
		case Process2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?Process", ScrmElementTypes.Process_3025); //$NON-NLS-1$
		case RequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Requirement", ScrmElementTypes.Requirement_2034); //$NON-NLS-1$
		case StationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?Station", ScrmElementTypes.Station_2056); //$NON-NLS-1$
		case ControlParameter2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?ControlParameter", ScrmElementTypes.ControlParameter_3040); //$NON-NLS-1$
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?representingModel", ScrmElementTypes.ScientificProblemRepresentingModel_4063); //$NON-NLS-1$
		case SCRMDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/scrm?SCRMDiagram", ScrmElementTypes.SCRMDiagram_1000); //$NON-NLS-1$
		case NumericalMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_2006); //$NON-NLS-1$
		case Feature2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_3009); //$NON-NLS-1$
		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Interface?detailsOfRequiringFunctionsAndProperties", ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071); //$NON-NLS-1$
		case RequirementRequiredInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?requiredInterface", ScrmElementTypes.RequirementRequiredInterface_4073); //$NON-NLS-1$
		case ScientificProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?ScientificProblem", ScrmElementTypes.ScientificProblem_2007); //$NON-NLS-1$
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?StatusMonitoring", ScrmElementTypes.StatusMonitoring_3023); //$NON-NLS-1$
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?influencedFeature", ScrmElementTypes.ScientificProblemInfluencedFeature_4008); //$NON-NLS-1$
		case InputDataReadingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?InputDataReading", ScrmElementTypes.InputDataReading_2036); //$NON-NLS-1$
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?KnowledgeSpace", ScrmElementTypes.KnowledgeSpace_2044); //$NON-NLS-1$
		case Performance2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Performance", ScrmElementTypes.Performance_3011); //$NON-NLS-1$
		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Interface?detailsOfProvidingFunctionsAndProperties", ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070); //$NON-NLS-1$
		case UserInterface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?UserInterface", ScrmElementTypes.UserInterface_3014); //$NON-NLS-1$
		case MeshCreation2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?MeshCreation", ScrmElementTypes.MeshCreation_3032); //$NON-NLS-1$
		case ComputationalMesh2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?ComputationalMesh", ScrmElementTypes.ComputationalMesh_3037); //$NON-NLS-1$
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Constraint?restrictedFeature", ScrmElementTypes.ConstraintRestrictedFeature_4051); //$NON-NLS-1$
		case FeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_2009); //$NON-NLS-1$
		case PerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Performance", ScrmElementTypes.Performance_2015); //$NON-NLS-1$
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?DataProcessSpace", ScrmElementTypes.DataProcessSpace_3029); //$NON-NLS-1$
		case UserInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?UserInterface", ScrmElementTypes.UserInterface_2012); //$NON-NLS-1$
		case Assumption2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?Assumption", ScrmElementTypes.Assumption_3004); //$NON-NLS-1$
		case PreProcessing2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?PreProcessing", ScrmElementTypes.PreProcessing_3033); //$NON-NLS-1$
		case InputDataReading2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?InputDataReading", ScrmElementTypes.InputDataReading_3026); //$NON-NLS-1$
		case SeismicSource2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataObject?SeismicSource", ScrmElementTypes.SeismicSource_3036); //$NON-NLS-1$
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?superFeature", ScrmElementTypes.FeatureSuperFeature_4053); //$NON-NLS-1$
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?specifiedFeature", ScrmElementTypes.RequirementSpecifiedFeature_4052); //$NON-NLS-1$
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?refinedRequirement", ScrmElementTypes.RequirementRefinedRequirement_4054); //$NON-NLS-1$
		case ProcessSuccessorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataProcess?Process?successor", ScrmElementTypes.ProcessSuccessor_4047); //$NON-NLS-1$
		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataObject?DataDefinition?requiredInterface", ScrmElementTypes.DataDefinitionRequiredInterface_4077); //$NON-NLS-1$
		case ControlParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?ControlParameter", ScrmElementTypes.ControlParameter_2057); //$NON-NLS-1$
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel?usedInNumericalMethods", ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065); //$NON-NLS-1$
		case MeshCreationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?MeshCreation", ScrmElementTypes.MeshCreation_2049); //$NON-NLS-1$
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?solvedProblem", ScrmElementTypes.NumericalMethodSolvedProblem_4057); //$NON-NLS-1$
		case PostProcessing2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?PostProcessing", ScrmElementTypes.PostProcessing_3034); //$NON-NLS-1$
		case RequirementProvidedInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?providedInterface", ScrmElementTypes.RequirementProvidedInterface_4072); //$NON-NLS-1$
		case PostProcessingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?PostProcessing", ScrmElementTypes.PostProcessing_2051); //$NON-NLS-1$
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel", ScrmElementTypes.Mathematical_GeophysicalModel_3030); //$NON-NLS-1$
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?Mathematical_GeophysicalModel?involvedData", ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067); //$NON-NLS-1$
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?SoftwareInterface", ScrmElementTypes.SoftwareInterface_2013); //$NON-NLS-1$
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?realizingRequirement", ScrmElementTypes.NumericalMethodRealizingRequirement_4068); //$NON-NLS-1$
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredFeatures", ScrmElementTypes.FeatureRequiredFeatures_4030); //$NON-NLS-1$
		case RequirementSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?RequirementSpace", ScrmElementTypes.RequirementSpace_2045); //$NON-NLS-1$
		case SolverEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?Solver", ScrmElementTypes.Solver_2048); //$NON-NLS-1$
		case NumericalMethod2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_3002); //$NON-NLS-1$
		case ErrorHandling2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?ErrorHandling", ScrmElementTypes.ErrorHandling_3027); //$NON-NLS-1$
		case ComputationalMeshEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?ComputationalMesh", ScrmElementTypes.ComputationalMesh_2054); //$NON-NLS-1$
		case Requirement2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Requirement", ScrmElementTypes.Requirement_3012); //$NON-NLS-1$
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?dependencies", ScrmElementTypes.FeatureDependencies_4026); //$NON-NLS-1$
		case PreProcessingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?PreProcessing", ScrmElementTypes.PreProcessing_2050); //$NON-NLS-1$
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?SoftwareInterface", ScrmElementTypes.SoftwareInterface_3013); //$NON-NLS-1$
		case ResultsOutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?ResultsOutput", ScrmElementTypes.ResultsOutput_2038); //$NON-NLS-1$
		case Constraint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Constraint", ScrmElementTypes.Constraint_3006); //$NON-NLS-1$
		case StatusMonitoringMonitoredProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataProcess?StatusMonitoring?monitoredProcess", ScrmElementTypes.StatusMonitoringMonitoredProcess_4062); //$NON-NLS-1$
		case PerformanceHardwareEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Performance?hardware", ScrmElementTypes.PerformanceHardware_4074); //$NON-NLS-1$
		case DataDefinitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataObject?DataDefinition", ScrmElementTypes.DataDefinition_2052); //$NON-NLS-1$
		case Solver2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?Solver", ScrmElementTypes.Solver_3031); //$NON-NLS-1$
		case RequirementSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?RequirementSpace", ScrmElementTypes.RequirementSpace_3015); //$NON-NLS-1$
		case ProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?Process", ScrmElementTypes.Process_2035); //$NON-NLS-1$
		case ErrorHandlingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?ErrorHandling", ScrmElementTypes.ErrorHandling_2039); //$NON-NLS-1$
		case ErrorHandlingHandledProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataProcess?ErrorHandling?handledProcess", ScrmElementTypes.ErrorHandlingHandledProcess_4061); //$NON-NLS-1$
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?providedInterfaces", ScrmElementTypes.FeatureProvidedInterfaces_4024); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ScrmDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& ScrmElementTypes.isKnownElementType(elementType)) {
			image = ScrmElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof ScrmNavigatorGroup) {
			ScrmNavigatorGroup group = (ScrmNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem navigatorItem = (ScrmNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3035Text(view);
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getNumericalMethodDependencies_4015Text(view);
		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelDependencies_4066Text(view);
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return getSyntheticSeismogram_2055Text(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008Text(view);
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getDataProcessSpace_2046Text(view);
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getFeatureExcludedFeatures_4032Text(view);
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getNumericalMethodPerformance_4069Text(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010Text(view);
		case SeismicSourceEditPart.VISUAL_ID:
			return getSeismicSource_2053Text(view);
		case ControlParameterControlledProcessEditPart.VISUAL_ID:
			return getControlParameterControlledProcess_4078Text(view);
		case ScientificProblem2EditPart.VISUAL_ID:
			return getScientificProblem_3001Text(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3024Text(view);
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_2047Text(view);
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getDataDefinitionDefinedRequirement_4075Text(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010Text(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040Text(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005Text(view);
		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelRefinements_4064Text(view);
		case Station2EditPart.VISUAL_ID:
			return getStation_3039Text(view);
		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID:
			return getDataDefinitionProvidedInterface_4076Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011Text(view);
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return getSyntheticSeismogram_3038Text(view);
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getFeatureRequiredInterfaces_4023Text(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3025Text(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034Text(view);
		case StationEditPart.VISUAL_ID:
			return getStation_2056Text(view);
		case ControlParameter2EditPart.VISUAL_ID:
			return getControlParameter_3040Text(view);
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getScientificProblemRepresentingModel_4063Text(view);
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000Text(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006Text(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009Text(view);
		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getInterfaceDetailsOfRequiringFunctionsAndProperties_4071Text(view);
		case RequirementRequiredInterfaceEditPart.VISUAL_ID:
			return getRequirementRequiredInterface_4073Text(view);
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007Text(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3023Text(view);
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getScientificProblemInfluencedFeature_4008Text(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036Text(view);
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getKnowledgeSpace_2044Text(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011Text(view);
		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID:
			return getInterfaceDetailsOfProvidingFunctionsAndProperties_4070Text(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014Text(view);
		case MeshCreation2EditPart.VISUAL_ID:
			return getMeshCreation_3032Text(view);
		case ComputationalMesh2EditPart.VISUAL_ID:
			return getComputationalMesh_3037Text(view);
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return getConstraintRestrictedFeature_4051Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009Text(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015Text(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3029Text(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012Text(view);
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004Text(view);
		case PreProcessing2EditPart.VISUAL_ID:
			return getPreProcessing_3033Text(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3026Text(view);
		case SeismicSource2EditPart.VISUAL_ID:
			return getSeismicSource_3036Text(view);
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return getFeatureSuperFeature_4053Text(view);
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getRequirementSpecifiedFeature_4052Text(view);
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return getRequirementRefinedRequirement_4054Text(view);
		case ProcessSuccessorEditPart.VISUAL_ID:
			return getProcessSuccessor_4047Text(view);
		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID:
			return getDataDefinitionRequiredInterface_4077Text(view);
		case ControlParameterEditPart.VISUAL_ID:
			return getControlParameter_2057Text(view);
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelUsedInNumericalMethods_4065Text(view);
		case MeshCreationEditPart.VISUAL_ID:
			return getMeshCreation_2049Text(view);
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getNumericalMethodSolvedProblem_4057Text(view);
		case PostProcessing2EditPart.VISUAL_ID:
			return getPostProcessing_3034Text(view);
		case RequirementProvidedInterfaceEditPart.VISUAL_ID:
			return getRequirementProvidedInterface_4072Text(view);
		case PostProcessingEditPart.VISUAL_ID:
			return getPostProcessing_2051Text(view);
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return getMathematical_GeophysicalModel_3030Text(view);
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			return getMathematical_GeophysicalModelInvolvedData_4067Text(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013Text(view);
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getNumericalMethodRealizingRequirement_4068Text(view);
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getFeatureRequiredFeatures_4030Text(view);
		case RequirementSpaceEditPart.VISUAL_ID:
			return getRequirementSpace_2045Text(view);
		case SolverEditPart.VISUAL_ID:
			return getSolver_2048Text(view);
		case NumericalMethod2EditPart.VISUAL_ID:
			return getNumericalMethod_3002Text(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3027Text(view);
		case ComputationalMeshEditPart.VISUAL_ID:
			return getComputationalMesh_2054Text(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012Text(view);
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getFeatureDependencies_4026Text(view);
		case PreProcessingEditPart.VISUAL_ID:
			return getPreProcessing_2050Text(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013Text(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038Text(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006Text(view);
		case StatusMonitoringMonitoredProcessEditPart.VISUAL_ID:
			return getStatusMonitoringMonitoredProcess_4062Text(view);
		case PerformanceHardwareEditPart.VISUAL_ID:
			return getPerformanceHardware_4074Text(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2052Text(view);
		case Solver2EditPart.VISUAL_ID:
			return getSolver_3031Text(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015Text(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2035Text(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039Text(view);
		case ErrorHandlingHandledProcessEditPart.VISUAL_ID:
			return getErrorHandlingHandledProcess_4061Text(view);
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getFeatureProvidedInterfaces_4024Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPreProcessing_2050Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.PreProcessing_2050,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(PreProcessingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5162); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHardware_3010Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Hardware_3010,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(HardwareName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5112); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureProvidedInterfaces_4024Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureProvidedInterfaces_4024,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel11EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResultsOutput_2038Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ResultsOutput_2038,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ResultsOutputNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5080); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSolver_3031Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Solver_3031,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(SolverName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5196); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataProcessSpace_3029Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataProcessSpace_3029,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataProcessSpaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5155); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinition_3035Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataDefinition_3035,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataDefinitionName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5204); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinition_2052Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataDefinition_2052,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataDefinitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5166); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinitionDefinedRequirement_4075Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.DataDefinitionDefinedRequirement_4075,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel28EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6073); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethodDependencies_4015Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethodDependencies_4015,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getErrorHandling_2039Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ErrorHandling_2039,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ErrorHandlingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5082); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getKnowledgeSpace_3005Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.KnowledgeSpace_3005,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(KnowledgeSpaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5099); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethodSolvedProblem_4057Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethodSolvedProblem_4057,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6055); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSyntheticSeismogram_2055Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SyntheticSeismogram_2055,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SyntheticSeismogramNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5181); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssumption_2008Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Assumption_2008,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(AssumptionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getScientificProblemInfluencedFeature_4008Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblemInfluencedFeature_4008,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSyntheticSeismogram_3038Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SyntheticSeismogram_3038,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SyntheticSeismogramName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5219); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getKnowledgeSpace_2044Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.KnowledgeSpace_2044,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(KnowledgeSpaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5086); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHardware_2010Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Hardware_2010,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(HardwareNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementSpace_2045Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.RequirementSpace_2045,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(RequirementSpaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5140); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureRequiredInterfaces_4023Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureRequiredInterfaces_4023,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel10EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethod_2006Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethod_2006,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(NumericalMethodNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResultsOutput_3024Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ResultsOutput_3024,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ResultsOutputName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5145); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getControlParameter_3040Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ControlParameter_3040,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ControlParameterName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5229); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataProcessSpace_2046Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataProcessSpace_2046,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataProcessSpaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5142); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethod_3002Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethod_3002,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(NumericalMethodName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5089); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureRequiredFeatures_4030Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureRequiredFeatures_4030, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel16EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSolver_2048Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Solver_2048,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(SolverNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5158); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatusMonitoringMonitoredProcess_4062Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.StatusMonitoringMonitoredProcess_4062,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel23EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6060); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeature_3009Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Feature_3009,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(FeatureName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5110); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getControlParameterControlledProcess_4078Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.ControlParameterControlledProcess_4078,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel31EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6076); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModel_3030Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.Mathematical_GeophysicalModel_3030,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(Mathematical_GeophysicalModelName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5194); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSoftwareInterface_2013Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SoftwareInterface_2013,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SoftwareInterfaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethodPerformance_4069Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.NumericalMethodPerformance_4069,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel19EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6067); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeature_2009Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Feature_2009,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(FeatureNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProcess_2035Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Process_2035,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(ProcessNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureDependencies_4026Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureDependencies_4026, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel13EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementRefinedRequirement_4054Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.RequirementRefinedRequirement_4054,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel18EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6052); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSoftwareInterface_3013Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SoftwareInterface_3013,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SoftwareInterfaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5122); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPerformance_2015Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Performance_2015,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(PerformanceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getControlParameter_2057Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ControlParameter_2057,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ControlParameterNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5191); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputDataReading_3026Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.InputDataReading_3026,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(InputDataReadingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5149); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStation_2056Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Station_2056,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(StationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5186); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSeismicSource_3036Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SeismicSource_3036,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SeismicSourceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5209); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputDataReading_2036Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.InputDataReading_2036,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(InputDataReadingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5076); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModelDependencies_4066Text(
			View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6064); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSeismicSource_2053Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.SeismicSource_2053,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(SeismicSourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5171); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModelInvolvedData_4067Text(
			View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel8EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6065); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getErrorHandlingHandledProcess_4061Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.ErrorHandlingHandledProcess_4061,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel22EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6059); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPerformanceHardware_4074Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.PerformanceHardware_4074, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel27EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6072); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterfaceDetailsOfRequiringFunctionsAndProperties_4071Text(
			View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel24EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6069); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirement_3012Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Requirement_3012,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(RequirementName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5120); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureExcludedFeatures_4032Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureExcludedFeatures_4032, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel17EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementRequiredInterface_4073Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.RequirementRequiredInterface_4073,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel26EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6071); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getScientificProblemRepresentingModel_4063Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblemRepresentingModel_4063,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6061); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getErrorHandling_3027Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ErrorHandling_3027,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ErrorHandlingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5151); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatusMonitoring_3023Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.StatusMonitoring_3023,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(StatusMonitoringName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5143); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComputationalMesh_2054Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ComputationalMesh_2054,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ComputationalMeshNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5176); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStation_3039Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Station_3039,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(StationName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5224); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirement_2034Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Requirement_2034,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(RequirementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5072); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementSpace_3015Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.RequirementSpace_3015,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(RequirementSpaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5139); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProcessSuccessor_4047Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.ProcessSuccessor_4047, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel21EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUserInterface_2012Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.UserInterface_2012,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(UserInterfaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModelUsedInNumericalMethods_4065Text(
			View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6063); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getScientificProblem_2007Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblem_2007,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ScientificProblemNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModelRefinements_4064Text(
			View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6062); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureSuperFeature_4053Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureSuperFeature_4053, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel15EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6051); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterfaceDetailsOfProvidingFunctionsAndProperties_4070Text(
			View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel20EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6068); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematical_GeophysicalModel_2047Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.Mathematical_GeophysicalModel_2047,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(Mathematical_GeophysicalModelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5156); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraintRestrictedFeature_4051Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.ConstraintRestrictedFeature_4051,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel12EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6049); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPostProcessing_3034Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.PostProcessing_3034,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(PostProcessingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5202); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUserInterface_3014Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.UserInterface_3014,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(UserInterfaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5125); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPerformance_3011Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Performance_3011,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(PerformanceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5117); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinitionProvidedInterface_4076Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.DataDefinitionProvidedInterface_4076,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel29EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6074); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_3006Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Constraint_3006,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(ConstraintName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5100); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMeshCreation_3032Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MeshCreation_3032,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(MeshCreationName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5198); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinitionRequiredInterface_4077Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.DataDefinitionRequiredInterface_4077,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel30EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6075); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMeshCreation_2049Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MeshCreation_2049,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(MeshCreationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5160); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPostProcessing_2051Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.PostProcessing_2051,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(PostProcessingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5164); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2011Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Constraint_2011,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComputationalMesh_3037Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ComputationalMesh_3037,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ComputationalMeshName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5214); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethodRealizingRequirement_4068Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethodRealizingRequirement_4068,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6066); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementProvidedInterface_4072Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.RequirementProvidedInterface_4072,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel25EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6070); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatusMonitoring_2040Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.StatusMonitoring_2040,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(StatusMonitoringNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5084); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProcess_3025Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Process_3025,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(ProcessName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5147); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSCRMDiagram_1000Text(View view) {
		SCRMDiagram domainModelElement = (SCRMDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssumption_3004Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Assumption_3004,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(AssumptionName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5097); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getScientificProblem_3001Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblem_3001,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ScientificProblemName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5087); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPreProcessing_3033Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.PreProcessing_3033,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(PreProcessingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5200); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementSpecifiedFeature_4052Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.RequirementSpecifiedFeature_4052,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel14EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6050); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return SCRMDiagramEditPart.MODEL_ID.equals(ScrmVisualIDRegistry
				.getModelID(view));
	}

}
