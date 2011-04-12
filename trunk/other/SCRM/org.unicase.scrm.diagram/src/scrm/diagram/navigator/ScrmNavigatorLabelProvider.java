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
		case ProcessDataFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Process?dataFlow", ScrmElementTypes.ProcessDataFlow_4040); //$NON-NLS-1$
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?representingModel", ScrmElementTypes.ScientificProblemRepresentingModel_4006); //$NON-NLS-1$
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?realizingRequirement", ScrmElementTypes.NumericalMethodRealizingRequirement_4016); //$NON-NLS-1$
		case ProcessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Process", ScrmElementTypes.Process_2014); //$NON-NLS-1$
		case Feature2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_4029); //$NON-NLS-1$
		case MathematicalModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?MathematicalModel", ScrmElementTypes.MathematicalModel_2005); //$NON-NLS-1$
		case FeatureConstraintsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?constraints", ScrmElementTypes.FeatureConstraints_4025); //$NON-NLS-1$
		case NumericalMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_2006); //$NON-NLS-1$
		case MathematicalModel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel", ScrmElementTypes.MathematicalModel_4004); //$NON-NLS-1$
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredInterfaces", ScrmElementTypes.FeatureRequiredInterfaces_4023); //$NON-NLS-1$
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?numericalMethods", ScrmElementTypes.MathematicalModelNumericalMethods_4011); //$NON-NLS-1$
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?SoftwareInterface", ScrmElementTypes.SoftwareInterface_2013); //$NON-NLS-1$
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?providedInterfaces", ScrmElementTypes.FeatureProvidedInterfaces_4024); //$NON-NLS-1$
		case SCRMDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/scrm?SCRMDiagram", ScrmElementTypes.SCRMDiagram_1000); //$NON-NLS-1$
		case RequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement", ScrmElementTypes.Requirement_4036); //$NON-NLS-1$
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?requiredFeatures", ScrmElementTypes.FeatureRequiredFeatures_4030); //$NON-NLS-1$
		case ConstraintEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Constraint", ScrmElementTypes.Constraint_2011); //$NON-NLS-1$
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?dependencies", ScrmElementTypes.FeatureDependencies_4026); //$NON-NLS-1$
		case DataDefinitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?DataDefinition", ScrmElementTypes.DataDefinition_2017); //$NON-NLS-1$
		case ErrorHandlingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/dataProcessing?ErrorHandling", ScrmElementTypes.ErrorHandling_2026); //$NON-NLS-1$
		case StatusMonitoringEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/dataProcessing?StatusMonitoring", ScrmElementTypes.StatusMonitoring_2027); //$NON-NLS-1$
		case InputDataReadingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/dataProcessing?InputDataReading", ScrmElementTypes.InputDataReading_2023); //$NON-NLS-1$
		case DataHandlingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/dataProcessing?DataHandling", ScrmElementTypes.DataHandling_2024); //$NON-NLS-1$
		case ScientificProblemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?ScientificProblem", ScrmElementTypes.ScientificProblem_2007); //$NON-NLS-1$
		case ScientificProblemSolvingMethodsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?solvingMethods", ScrmElementTypes.ScientificProblemSolvingMethods_4041); //$NON-NLS-1$
		case ResultsOutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/dataProcessing?ResultsOutput", ScrmElementTypes.ResultsOutput_2025); //$NON-NLS-1$
		case HardwareEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Hardware", ScrmElementTypes.Hardware_2010); //$NON-NLS-1$
		case PerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Performance", ScrmElementTypes.Performance_2015); //$NON-NLS-1$
		case UserInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?UserInterface", ScrmElementTypes.UserInterface_2012); //$NON-NLS-1$
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?dependencies", ScrmElementTypes.NumericalMethodDependencies_4015); //$NON-NLS-1$
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?performance", ScrmElementTypes.NumericalMethodPerformance_4017); //$NON-NLS-1$
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?excludedFeatures", ScrmElementTypes.FeatureExcludedFeatures_4032); //$NON-NLS-1$
		case DataFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?DataFlow", ScrmElementTypes.DataFlow_2016); //$NON-NLS-1$
		case FeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/requirements?Feature", ScrmElementTypes.Feature_2009); //$NON-NLS-1$
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Feature?detailedRequirements", ScrmElementTypes.FeatureDetailedRequirements_4027); //$NON-NLS-1$
		case AssumptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?Assumption", ScrmElementTypes.Assumption_2008); //$NON-NLS-1$
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?MathematicalModel?dependencies", ScrmElementTypes.MathematicalModelDependencies_4012); //$NON-NLS-1$
		case RequirementDefiningDataEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/requirements?Requirement?definingData", ScrmElementTypes.RequirementDefiningData_4038); //$NON-NLS-1$
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/scrm/knowledge?ScientificProblem?influencedFeature", ScrmElementTypes.ScientificProblemInfluencedFeature_4008); //$NON-NLS-1$
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
		case ProcessDataFlowEditPart.VISUAL_ID:
			return getProcessDataFlow_4040Text(view);
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return getScientificProblemRepresentingModel_4006Text(view);
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return getNumericalMethodRealizingRequirement_4016Text(view);
		case ProcessEditPart.VISUAL_ID:
			return getProcess_2014Text(view);
		case Feature2EditPart.VISUAL_ID:
			return getFeature_4029Text(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2005Text(view);
		case FeatureConstraintsEditPart.VISUAL_ID:
			return getFeatureConstraints_4025Text(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2006Text(view);
		case MathematicalModel2EditPart.VISUAL_ID:
			return getMathematicalModel_4004Text(view);
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return getFeatureRequiredInterfaces_4023Text(view);
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return getMathematicalModelNumericalMethods_4011Text(view);
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return getSoftwareInterface_2013Text(view);
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return getFeatureProvidedInterfaces_4024Text(view);
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000Text(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_4036Text(view);
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getFeatureRequiredFeatures_4030Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011Text(view);
		case FeatureDependenciesEditPart.VISUAL_ID:
			return getFeatureDependencies_4026Text(view);
		case DataDefinitionEditPart.VISUAL_ID:
			return getDataDefinition_2017Text(view);
		case ErrorHandlingEditPart.VISUAL_ID:
			return getErrorHandling_2026Text(view);
		case StatusMonitoringEditPart.VISUAL_ID:
			return getStatusMonitoring_2027Text(view);
		case InputDataReadingEditPart.VISUAL_ID:
			return getInputDataReading_2023Text(view);
		case DataHandlingEditPart.VISUAL_ID:
			return getDataHandling_2024Text(view);
		case ScientificProblemEditPart.VISUAL_ID:
			return getScientificProblem_2007Text(view);
		case ScientificProblemSolvingMethodsEditPart.VISUAL_ID:
			return getScientificProblemSolvingMethods_4041Text(view);
		case ResultsOutputEditPart.VISUAL_ID:
			return getResultsOutput_2025Text(view);
		case HardwareEditPart.VISUAL_ID:
			return getHardware_2010Text(view);
		case PerformanceEditPart.VISUAL_ID:
			return getPerformance_2015Text(view);
		case UserInterfaceEditPart.VISUAL_ID:
			return getUserInterface_2012Text(view);
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return getNumericalMethodDependencies_4015Text(view);
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return getNumericalMethodPerformance_4017Text(view);
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getFeatureExcludedFeatures_4032Text(view);
		case DataFlowEditPart.VISUAL_ID:
			return getDataFlow_2016Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2009Text(view);
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			return getFeatureDetailedRequirements_4027Text(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_2008Text(view);
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return getMathematicalModelDependencies_4012Text(view);
		case RequirementDefiningDataEditPart.VISUAL_ID:
			return getRequirementDefiningData_4038Text(view);
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return getScientificProblemInfluencedFeature_4008Text(view);
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
	private String getInputDataReading_2023Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.InputDataReading_2023,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(InputDataReadingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5050); //$NON-NLS-1$
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
	private String getErrorHandling_2026Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ErrorHandling_2026,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ErrorHandlingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5056); //$NON-NLS-1$
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
	private String getDataHandling_2024Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.DataHandling_2024,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(DataHandlingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5052); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResultsOutput_2025Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ResultsOutput_2025,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(ResultsOutputNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5054); //$NON-NLS-1$
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
	private String getProcess_2014Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.Process_2014,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(ProcessNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
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
	private String getScientificProblemRepresentingModel_4006Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblemRepresentingModel_4006,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStatusMonitoring_2027Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.StatusMonitoring_2027,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry
						.getType(StatusMonitoringNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5058); //$NON-NLS-1$
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
	private String getMathematicalModel_4004Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.MathematicalModel_4004,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getScientificProblemSolvingMethods_4041Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.ScientificProblemSolvingMethods_4041,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6039); //$NON-NLS-1$
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
	private String getNumericalMethodRealizingRequirement_4016Text(View view) {
		IParser parser = ScrmParserProvider.getParser(
				ScrmElementTypes.NumericalMethodRealizingRequirement_4016,
				view.getElement() != null ? view.getElement() : view,
				ScrmVisualIDRegistry.getType(WrappingLabel8EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6014); //$NON-NLS-1$
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
	private String getFeatureConstraints_4025Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureConstraints_4025, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel12EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6023); //$NON-NLS-1$
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
	private String getFeatureDetailedRequirements_4027Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.FeatureDetailedRequirements_4027,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel14EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeature_4029Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Feature_4029,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel15EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6027); //$NON-NLS-1$
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
	private String getRequirement_4036Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.Requirement_4036,
						view.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel18EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementDefiningData_4038Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.RequirementDefiningData_4038, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel19EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProcessDataFlow_4040Text(View view) {
		IParser parser = ScrmParserProvider
				.getParser(ScrmElementTypes.ProcessDataFlow_4040, view
						.getElement() != null ? view.getElement() : view,
						ScrmVisualIDRegistry
								.getType(WrappingLabel20EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6038); //$NON-NLS-1$
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
