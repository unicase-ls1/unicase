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
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataFlowEditPart;
import scrm.diagram.edit.parts.DataHandlingEditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
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
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemNameEditPart;
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
import scrm.diagram.edit.parts.WrappingLabel2EditPart;
import scrm.diagram.edit.parts.WrappingLabel3EditPart;
import scrm.diagram.edit.parts.WrappingLabel4EditPart;
import scrm.diagram.edit.parts.WrappingLabel5EditPart;
import scrm.diagram.edit.parts.WrappingLabel6EditPart;
import scrm.diagram.edit.parts.WrappingLabel7EditPart;
import scrm.diagram.edit.parts.WrappingLabel8EditPart;
import scrm.diagram.edit.parts.WrappingLabel9EditPart;
import scrm.diagram.edit.parts.WrappingLabelEditPart;
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
		case Assumption2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?Assumption", ScrmElementTypes.Assumption_3004); //$NON-NLS-1$
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredFeatures", ScrmElementTypes.FeatureRequiredFeatures_4030); //$NON-NLS-1$
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?solvedProblem", ScrmElementTypes.NumericalMethodSolvedProblem_4057); //$NON-NLS-1$
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Constraint?restrictedFeature", ScrmElementTypes.ConstraintRestrictedFeature_4051); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Constraint", ScrmElementTypes.Constraint_2011); //$NON-NLS-1$
		case Constraint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Constraint", ScrmElementTypes.Constraint_3006); //$NON-NLS-1$
		case AssumptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?Assumption", ScrmElementTypes.Assumption_2008); //$NON-NLS-1$
		case RequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Requirement", ScrmElementTypes.Requirement_2034); //$NON-NLS-1$
		case MathematicalModelRefinedModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?refinedModel", ScrmElementTypes.MathematicalModelRefinedModel_4058); //$NON-NLS-1$
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?DataDefinition?definedRequirement", ScrmElementTypes.DataDefinitionDefinedRequirement_4055); //$NON-NLS-1$
		case ErrorHandling2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?ErrorHandling", ScrmElementTypes.ErrorHandling_3020); //$NON-NLS-1$
		case ScientificProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?ScientificProblem", ScrmElementTypes.ScientificProblem_2007); //$NON-NLS-1$
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?dependencies", ScrmElementTypes.MathematicalModelDependencies_4012); //$NON-NLS-1$
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?SoftwareInterface", ScrmElementTypes.SoftwareInterface_2013); //$NON-NLS-1$
		case MathematicalModelRepresentedProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?representedProblem", ScrmElementTypes.MathematicalModelRepresentedProblem_4048); //$NON-NLS-1$
		case NumericalMethod2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_3002); //$NON-NLS-1$
		case DataHandlingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?DataHandling", ScrmElementTypes.DataHandling_2037); //$NON-NLS-1$
		case DataHandling2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?DataHandling", ScrmElementTypes.DataHandling_3021); //$NON-NLS-1$
		case RequirementSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?RequirementSpace", ScrmElementTypes.RequirementSpace_2045); //$NON-NLS-1$
		case UserInterface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?UserInterface", ScrmElementTypes.UserInterface_3014); //$NON-NLS-1$
		case Process2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?Process", ScrmElementTypes.Process_3018); //$NON-NLS-1$
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?refinedRequirement", ScrmElementTypes.RequirementRefinedRequirement_4054); //$NON-NLS-1$
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?specifiedFeature", ScrmElementTypes.RequirementSpecifiedFeature_4052); //$NON-NLS-1$
		case Performance2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Performance", ScrmElementTypes.Performance_3011); //$NON-NLS-1$
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?realizedMethod", ScrmElementTypes.RequirementRealizedMethod_4050); //$NON-NLS-1$
		case NumericalMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_2006); //$NON-NLS-1$
		case Hardware2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Hardware", ScrmElementTypes.Hardware_3010); //$NON-NLS-1$
		case ProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?Process", ScrmElementTypes.Process_2035); //$NON-NLS-1$
		case DataDefinitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?DataDefinition", ScrmElementTypes.DataDefinition_2017); //$NON-NLS-1$
		case SCRMDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/scrm?SCRMDiagram", ScrmElementTypes.SCRMDiagram_1000); //$NON-NLS-1$
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?KnowledgeSpace", ScrmElementTypes.KnowledgeSpace_2044); //$NON-NLS-1$
		case ResultsOutput2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?ResultsOutput", ScrmElementTypes.ResultsOutput_3017); //$NON-NLS-1$
		case InputDataReading2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?InputDataReading", ScrmElementTypes.InputDataReading_3019); //$NON-NLS-1$
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?excludedFeatures", ScrmElementTypes.FeatureExcludedFeatures_4032); //$NON-NLS-1$
		case FeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_2009); //$NON-NLS-1$
		case MathematicalModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?MathematicalModel", ScrmElementTypes.MathematicalModel_2005); //$NON-NLS-1$
		case Requirement2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Requirement", ScrmElementTypes.Requirement_3012); //$NON-NLS-1$
		case DataFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?DataFlow", ScrmElementTypes.DataFlow_2016); //$NON-NLS-1$
		case ErrorHandlingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?ErrorHandling", ScrmElementTypes.ErrorHandling_2039); //$NON-NLS-1$
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredInterfaces", ScrmElementTypes.FeatureRequiredInterfaces_4023); //$NON-NLS-1$
		case Feature2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_3009); //$NON-NLS-1$
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?performance", ScrmElementTypes.NumericalMethodPerformance_4017); //$NON-NLS-1$
		case DataFlowSpecifiedProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?DataFlow?specifiedProcess", ScrmElementTypes.DataFlowSpecifiedProcess_4056); //$NON-NLS-1$
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?DataProcessSpace", ScrmElementTypes.DataProcessSpace_2046); //$NON-NLS-1$
		case RequirementSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?RequirementSpace", ScrmElementTypes.RequirementSpace_3015); //$NON-NLS-1$
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?SoftwareInterface", ScrmElementTypes.SoftwareInterface_3013); //$NON-NLS-1$
		case MathematicalModel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?MathematicalModel", ScrmElementTypes.MathematicalModel_3003); //$NON-NLS-1$
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?numericalMethods", ScrmElementTypes.MathematicalModelNumericalMethods_4011); //$NON-NLS-1$
		case UserInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?UserInterface", ScrmElementTypes.UserInterface_2012); //$NON-NLS-1$
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?superFeature", ScrmElementTypes.FeatureSuperFeature_4053); //$NON-NLS-1$
		case StatusMonitoringEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?StatusMonitoring", ScrmElementTypes.StatusMonitoring_2040); //$NON-NLS-1$
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?influencedFeature", ScrmElementTypes.ScientificProblemInfluencedFeature_4008); //$NON-NLS-1$
		case ResultsOutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?ResultsOutput", ScrmElementTypes.ResultsOutput_2038); //$NON-NLS-1$
		case DataDefinition2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?DataDefinition", ScrmElementTypes.DataDefinition_3007); //$NON-NLS-1$
		case HardwareEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Hardware", ScrmElementTypes.Hardware_2010); //$NON-NLS-1$
		case ScientificProblem2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?ScientificProblem", ScrmElementTypes.ScientificProblem_3001); //$NON-NLS-1$
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/knowledge?KnowledgeSpace", ScrmElementTypes.KnowledgeSpace_3005); //$NON-NLS-1$
		case DataFlow2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements?DataFlow", ScrmElementTypes.DataFlow_3008); //$NON-NLS-1$
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?dependencies", ScrmElementTypes.NumericalMethodDependencies_4015); //$NON-NLS-1$
		case PerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Performance", ScrmElementTypes.Performance_2015); //$NON-NLS-1$
		case InputDataReadingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements/dataProcess?InputDataReading", ScrmElementTypes.InputDataReading_2036); //$NON-NLS-1$
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?providedInterfaces", ScrmElementTypes.FeatureProvidedInterfaces_4024); //$NON-NLS-1$
		case ProcessSuccessorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements/dataProcess?Process?successor", ScrmElementTypes.ProcessSuccessor_4047); //$NON-NLS-1$
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?DataProcessSpace", ScrmElementTypes.DataProcessSpace_3022); //$NON-NLS-1$
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?dependencies", ScrmElementTypes.FeatureDependencies_4026); //$NON-NLS-1$
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/scrm/requirements/dataProcess?StatusMonitoring", ScrmElementTypes.StatusMonitoring_3016); //$NON-NLS-1$
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
		case Assumption2EditPart.VISUAL_ID:
			return getAssumption_3004Text(view);
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getFeatureRequiredFeatures_4030Text(view);
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return getNumericalMethodSolvedProblem_4057Text(view);
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return getConstraintRestrictedFeature_4051Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011Text(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3006Text(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008Text(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_2034Text(view);
		case MathematicalModelRefinedModelEditPart.VISUAL_ID:
			return getMathematicalModelRefinedModel_4058Text(view);
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return getDataDefinitionDefinedRequirement_4055Text(view);
		case ErrorHandling2EditPart.VISUAL_ID:
			return getErrorHandling_3020Text(view);
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007Text(view);
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getMathematicalModelDependencies_4012Text(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013Text(view);
		case MathematicalModelRepresentedProblemEditPart.VISUAL_ID:
			return getMathematicalModelRepresentedProblem_4048Text(view);
		case NumericalMethod2EditPart.VISUAL_ID:
			return getNumericalMethod_3002Text(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2037Text(view);
		case DataHandling2EditPart.VISUAL_ID:
			return getDataHandling_3021Text(view);
		case RequirementSpaceEditPart.VISUAL_ID:
			return getRequirementSpace_2045Text(view);
		case UserInterface2EditPart.VISUAL_ID:
			return getUserInterface_3014Text(view);
		case Process2EditPart.VISUAL_ID:
			return getProcess_3018Text(view);
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return getRequirementRefinedRequirement_4054Text(view);
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return getRequirementSpecifiedFeature_4052Text(view);
		case Performance2EditPart.VISUAL_ID:
			return getPerformance_3011Text(view);
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			return getRequirementRealizedMethod_4050Text(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006Text(view);
		case Hardware2EditPart.VISUAL_ID:
			return getHardware_3010Text(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2035Text(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017Text(view);
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000Text(view);
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return getKnowledgeSpace_2044Text(view);
		case ResultsOutput2EditPart.VISUAL_ID:
			return getResultsOutput_3017Text(view);
		case InputDataReading2EditPart.VISUAL_ID:
			return getInputDataReading_3019Text(view);
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getFeatureExcludedFeatures_4032Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009Text(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2005Text(view);
		case Requirement2EditPart.VISUAL_ID:
			return getRequirement_3012Text(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016Text(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2039Text(view);
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getFeatureRequiredInterfaces_4023Text(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_3009Text(view);
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getNumericalMethodPerformance_4017Text(view);
		case DataFlowSpecifiedProcessEditPart.VISUAL_ID:
			return getDataFlowSpecifiedProcess_4056Text(view);
		case DataProcessSpaceEditPart.VISUAL_ID:
			return getDataProcessSpace_2046Text(view);
		case RequirementSpace2EditPart.VISUAL_ID:
			return getRequirementSpace_3015Text(view);
		case SoftwareInterface2EditPart.VISUAL_ID:
			return getSoftwareInterface_3013Text(view);
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_3003Text(view);
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getMathematicalModelNumericalMethods_4011Text(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012Text(view);
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return getFeatureSuperFeature_4053Text(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2040Text(view);
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getScientificProblemInfluencedFeature_4008Text(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2038Text(view);
		case DataDefinition2EditPart.VISUAL_ID:
			return getDataDefinition_3007Text(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010Text(view);
		case ScientificProblem2EditPart.VISUAL_ID:
			return getScientificProblem_3001Text(view);
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return getKnowledgeSpace_3005Text(view);
		case DataFlow2EditPart.VISUAL_ID:
			return getDataFlow_3008Text(view);
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getNumericalMethodDependencies_4015Text(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015Text(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2036Text(view);
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getFeatureProvidedInterfaces_4024Text(view);
		case ProcessSuccessorEditPart.VISUAL_ID:
			return getProcessSuccessor_4047Text(view);
		case DataProcessSpace2EditPart.VISUAL_ID:
			return getDataProcessSpace_3022Text(view);
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getFeatureDependencies_4026Text(view);
		case StatusMonitoring2EditPart.VISUAL_ID:
			return getStatusMonitoring_3016Text(view);
		}
		return getUnknownElementText(view);
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
	private String getDataHandling_2037Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataHandling_2037,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataHandlingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5078); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematicalModel_2005Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModel_2005,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(MathematicalModelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
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
	private String getDataFlowSpecifiedProcess_4056Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.DataFlowSpecifiedProcess_4056, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel20EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6054); //$NON-NLS-1$
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
	private String getDataFlow_2016Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataFlow_2016,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(DataFlowNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
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
	private String getDataDefinition_2017Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataDefinition_2017,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataDefinitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatusMonitoring_3016Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.StatusMonitoring_3016,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(StatusMonitoringName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5127); //$NON-NLS-1$
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
	private String getDataDefinition_3007Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataDefinition_3007,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataDefinitionName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5102); //$NON-NLS-1$
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
	private String getMathematicalModelNumericalMethods_4011Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModelNumericalMethods_4011,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematicalModelDependencies_4012Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModelDependencies_4012,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6010); //$NON-NLS-1$
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
	private String getMathematicalModelRefinedModel_4058Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModelRefinedModel_4058,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6056); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataHandling_3021Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataHandling_3021,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataHandlingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5137); //$NON-NLS-1$
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
	private String getNumericalMethodPerformance_4017Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethodPerformance_4017,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataDefinitionDefinedRequirement_4055Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(
						ScrmElementTypes.DataDefinitionDefinedRequirement_4055,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel19EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6053); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getErrorHandling_3020Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ErrorHandling_3020,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ErrorHandlingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5135); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataProcessSpace_3022Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataProcessSpace_3022,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataProcessSpaceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5141); //$NON-NLS-1$
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
	private String getResultsOutput_3017Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ResultsOutput_3017,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ResultsOutputName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5129); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputDataReading_3019Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.InputDataReading_3019,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(InputDataReadingName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5133); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataFlow_3008Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataFlow_3008,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(DataFlowName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5108); //$NON-NLS-1$
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
	private String getProcess_3018Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Process_3018,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(ProcessName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5131); //$NON-NLS-1$
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
	private String getRequirementRealizedMethod_4050Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.RequirementRealizedMethod_4050,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel8EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6048); //$NON-NLS-1$
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
	private String getMathematicalModelRepresentedProblem_4048Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModelRepresentedProblem_4048,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6046); //$NON-NLS-1$
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
	private String getMathematicalModel_3003Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModel_3003,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(MathematicalModelName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5093); //$NON-NLS-1$
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
