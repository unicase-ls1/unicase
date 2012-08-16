package scrm.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import scrm.ScrmPackage;
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
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.knowledge.KnowledgePackage;
import scrm.requirements.RequirementsPackage;

/**
 * @generated
 */
public class ScrmElementTypes {

	/**
	 * @generated
	 */
	private ScrmElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType SCRMDiagram_1000 = getElementType("org.unicase.scrm.diagram.SCRMDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblem_2007 = getElementType("org.unicase.scrm.diagram.ScientificProblem_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModel_2047 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModel_2047"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethod_2006 = getElementType("org.unicase.scrm.diagram.NumericalMethod_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Assumption_2008 = getElementType("org.unicase.scrm.diagram.Assumption_2008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Requirement_2034 = getElementType("org.unicase.scrm.diagram.Requirement_2034"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Feature_2009 = getElementType("org.unicase.scrm.diagram.Feature_2009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Hardware_2010 = getElementType("org.unicase.scrm.diagram.Hardware_2010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Constraint_2011 = getElementType("org.unicase.scrm.diagram.Constraint_2011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UserInterface_2012 = getElementType("org.unicase.scrm.diagram.UserInterface_2012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SoftwareInterface_2013 = getElementType("org.unicase.scrm.diagram.SoftwareInterface_2013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Performance_2015 = getElementType("org.unicase.scrm.diagram.Performance_2015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Process_2035 = getElementType("org.unicase.scrm.diagram.Process_2035"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputDataReading_2036 = getElementType("org.unicase.scrm.diagram.InputDataReading_2036"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ResultsOutput_2038 = getElementType("org.unicase.scrm.diagram.ResultsOutput_2038"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ErrorHandling_2039 = getElementType("org.unicase.scrm.diagram.ErrorHandling_2039"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StatusMonitoring_2040 = getElementType("org.unicase.scrm.diagram.StatusMonitoring_2040"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Solver_2048 = getElementType("org.unicase.scrm.diagram.Solver_2048"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MeshCreation_2049 = getElementType("org.unicase.scrm.diagram.MeshCreation_2049"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PreProcessing_2050 = getElementType("org.unicase.scrm.diagram.PreProcessing_2050"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PostProcessing_2051 = getElementType("org.unicase.scrm.diagram.PostProcessing_2051"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinition_2052 = getElementType("org.unicase.scrm.diagram.DataDefinition_2052"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SeismicSource_2053 = getElementType("org.unicase.scrm.diagram.SeismicSource_2053"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComputationalMesh_2054 = getElementType("org.unicase.scrm.diagram.ComputationalMesh_2054"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SyntheticSeismogram_2055 = getElementType("org.unicase.scrm.diagram.SyntheticSeismogram_2055"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Station_2056 = getElementType("org.unicase.scrm.diagram.Station_2056"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ControlParameter_2057 = getElementType("org.unicase.scrm.diagram.ControlParameter_2057"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType KnowledgeSpace_2044 = getElementType("org.unicase.scrm.diagram.KnowledgeSpace_2044"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementSpace_2045 = getElementType("org.unicase.scrm.diagram.RequirementSpace_2045"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataProcessSpace_2046 = getElementType("org.unicase.scrm.diagram.DataProcessSpace_2046"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblem_3001 = getElementType("org.unicase.scrm.diagram.ScientificProblem_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethod_3002 = getElementType("org.unicase.scrm.diagram.NumericalMethod_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModel_3030 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModel_3030"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Assumption_3004 = getElementType("org.unicase.scrm.diagram.Assumption_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType KnowledgeSpace_3005 = getElementType("org.unicase.scrm.diagram.KnowledgeSpace_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Requirement_3012 = getElementType("org.unicase.scrm.diagram.Requirement_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Feature_3009 = getElementType("org.unicase.scrm.diagram.Feature_3009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Hardware_3010 = getElementType("org.unicase.scrm.diagram.Hardware_3010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Constraint_3006 = getElementType("org.unicase.scrm.diagram.Constraint_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UserInterface_3014 = getElementType("org.unicase.scrm.diagram.UserInterface_3014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SoftwareInterface_3013 = getElementType("org.unicase.scrm.diagram.SoftwareInterface_3013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Performance_3011 = getElementType("org.unicase.scrm.diagram.Performance_3011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Process_3025 = getElementType("org.unicase.scrm.diagram.Process_3025"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputDataReading_3026 = getElementType("org.unicase.scrm.diagram.InputDataReading_3026"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ResultsOutput_3024 = getElementType("org.unicase.scrm.diagram.ResultsOutput_3024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ErrorHandling_3027 = getElementType("org.unicase.scrm.diagram.ErrorHandling_3027"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StatusMonitoring_3023 = getElementType("org.unicase.scrm.diagram.StatusMonitoring_3023"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Solver_3031 = getElementType("org.unicase.scrm.diagram.Solver_3031"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MeshCreation_3032 = getElementType("org.unicase.scrm.diagram.MeshCreation_3032"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PreProcessing_3033 = getElementType("org.unicase.scrm.diagram.PreProcessing_3033"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PostProcessing_3034 = getElementType("org.unicase.scrm.diagram.PostProcessing_3034"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinition_3035 = getElementType("org.unicase.scrm.diagram.DataDefinition_3035"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SeismicSource_3036 = getElementType("org.unicase.scrm.diagram.SeismicSource_3036"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComputationalMesh_3037 = getElementType("org.unicase.scrm.diagram.ComputationalMesh_3037"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SyntheticSeismogram_3038 = getElementType("org.unicase.scrm.diagram.SyntheticSeismogram_3038"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Station_3039 = getElementType("org.unicase.scrm.diagram.Station_3039"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ControlParameter_3040 = getElementType("org.unicase.scrm.diagram.ControlParameter_3040"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementSpace_3015 = getElementType("org.unicase.scrm.diagram.RequirementSpace_3015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataProcessSpace_3029 = getElementType("org.unicase.scrm.diagram.DataProcessSpace_3029"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemRepresentingModel_4063 = getElementType("org.unicase.scrm.diagram.ScientificProblemRepresentingModel_4063"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemInfluencedFeature_4008 = getElementType("org.unicase.scrm.diagram.ScientificProblemInfluencedFeature_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModelRefinements_4064 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModelRefinements_4064"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModelUsedInNumericalMethods_4065 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModelUsedInNumericalMethods_4065"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModelDependencies_4066 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModelDependencies_4066"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mathematical_GeophysicalModelInvolvedData_4067 = getElementType("org.unicase.scrm.diagram.Mathematical_GeophysicalModelInvolvedData_4067"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodSolvedProblem_4057 = getElementType("org.unicase.scrm.diagram.NumericalMethodSolvedProblem_4057"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodDependencies_4015 = getElementType("org.unicase.scrm.diagram.NumericalMethodDependencies_4015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodRealizingRequirement_4068 = getElementType("org.unicase.scrm.diagram.NumericalMethodRealizingRequirement_4068"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodPerformance_4069 = getElementType("org.unicase.scrm.diagram.NumericalMethodPerformance_4069"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InterfaceDetailsOfProvidingFunctionsAndProperties_4070 = getElementType("org.unicase.scrm.diagram.InterfaceDetailsOfProvidingFunctionsAndProperties_4070"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InterfaceDetailsOfRequiringFunctionsAndProperties_4071 = getElementType("org.unicase.scrm.diagram.InterfaceDetailsOfRequiringFunctionsAndProperties_4071"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementRefinedRequirement_4054 = getElementType("org.unicase.scrm.diagram.RequirementRefinedRequirement_4054"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementSpecifiedFeature_4052 = getElementType("org.unicase.scrm.diagram.RequirementSpecifiedFeature_4052"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementProvidedInterface_4072 = getElementType("org.unicase.scrm.diagram.RequirementProvidedInterface_4072"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementRequiredInterface_4073 = getElementType("org.unicase.scrm.diagram.RequirementRequiredInterface_4073"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureSuperFeature_4053 = getElementType("org.unicase.scrm.diagram.FeatureSuperFeature_4053"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureDependencies_4026 = getElementType("org.unicase.scrm.diagram.FeatureDependencies_4026"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureRequiredInterfaces_4023 = getElementType("org.unicase.scrm.diagram.FeatureRequiredInterfaces_4023"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureProvidedInterfaces_4024 = getElementType("org.unicase.scrm.diagram.FeatureProvidedInterfaces_4024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureRequiredFeatures_4030 = getElementType("org.unicase.scrm.diagram.FeatureRequiredFeatures_4030"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureExcludedFeatures_4032 = getElementType("org.unicase.scrm.diagram.FeatureExcludedFeatures_4032"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintRestrictedFeature_4051 = getElementType("org.unicase.scrm.diagram.ConstraintRestrictedFeature_4051"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PerformanceHardware_4074 = getElementType("org.unicase.scrm.diagram.PerformanceHardware_4074"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProcessSuccessor_4047 = getElementType("org.unicase.scrm.diagram.ProcessSuccessor_4047"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ErrorHandlingHandledProcess_4061 = getElementType("org.unicase.scrm.diagram.ErrorHandlingHandledProcess_4061"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StatusMonitoringMonitoredProcess_4062 = getElementType("org.unicase.scrm.diagram.StatusMonitoringMonitoredProcess_4062"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinitionDefinedRequirement_4075 = getElementType("org.unicase.scrm.diagram.DataDefinitionDefinedRequirement_4075"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinitionProvidedInterface_4076 = getElementType("org.unicase.scrm.diagram.DataDefinitionProvidedInterface_4076"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinitionRequiredInterface_4077 = getElementType("org.unicase.scrm.diagram.DataDefinitionRequiredInterface_4077"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ControlParameterControlledProcess_4078 = getElementType("org.unicase.scrm.diagram.ControlParameterControlledProcess_4078"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return ScrmDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated NOT
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(SCRMDiagram_1000,
					ScrmPackage.eINSTANCE.getSCRMDiagram());

			elements.put(ScientificProblem_2007,
					KnowledgePackage.eINSTANCE.getScientificProblem());

			elements.put(Mathematical_GeophysicalModel_2047,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel());

			elements.put(NumericalMethod_2006,
					KnowledgePackage.eINSTANCE.getNumericalMethod());

			elements.put(Assumption_2008,
					KnowledgePackage.eINSTANCE.getAssumption());

			elements.put(Requirement_2034,
					RequirementsPackage.eINSTANCE.getRequirement());

			elements.put(Feature_2009,
					RequirementsPackage.eINSTANCE.getFeature());

			elements.put(Hardware_2010,
					RequirementsPackage.eINSTANCE.getHardware());

			elements.put(Constraint_2011,
					RequirementsPackage.eINSTANCE.getConstraint());

			elements.put(UserInterface_2012,
					RequirementsPackage.eINSTANCE.getUserInterface());

			elements.put(SoftwareInterface_2013,
					RequirementsPackage.eINSTANCE.getSoftwareInterface());

			elements.put(Performance_2015,
					RequirementsPackage.eINSTANCE.getPerformance());

			elements.put(Process_2035,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess());

			elements.put(InputDataReading_2036,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getInputDataReading());

			elements.put(ResultsOutput_2038,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getResultsOutput());

			elements.put(ErrorHandling_2039,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getErrorHandling());

			elements.put(StatusMonitoring_2040,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getStatusMonitoring());

			elements.put(Solver_2048,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getSolver());

			elements.put(MeshCreation_2049,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getMeshCreation());

			elements.put(PreProcessing_2050,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getPreProcessing());

			elements.put(PostProcessing_2051,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getPostProcessing());

			elements.put(DataDefinition_2052,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getDataDefinition());

			elements.put(SeismicSource_2053,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getSeismicSource());

			elements.put(ComputationalMesh_2054,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getComputationalMesh());

			elements.put(SyntheticSeismogram_2055,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getSyntheticSeismogram());

			elements.put(Station_2056,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getStation());

			elements.put(ControlParameter_2057,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getControlParameter());

			elements.put(KnowledgeSpace_2044,
					KnowledgePackage.eINSTANCE.getKnowledgeSpace());

			elements.put(RequirementSpace_2045,
					RequirementsPackage.eINSTANCE.getRequirementSpace());

			elements.put(DataProcessSpace_2046,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getDataProcessSpace());

			elements.put(ScientificProblem_3001,
					KnowledgePackage.eINSTANCE.getScientificProblem());

			elements.put(NumericalMethod_3002,
					KnowledgePackage.eINSTANCE.getNumericalMethod());

			elements.put(Mathematical_GeophysicalModel_3030,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel());

			elements.put(Assumption_3004,
					KnowledgePackage.eINSTANCE.getAssumption());

			elements.put(KnowledgeSpace_3005,
					KnowledgePackage.eINSTANCE.getKnowledgeSpace());

			elements.put(Requirement_3012,
					RequirementsPackage.eINSTANCE.getRequirement());

			elements.put(Feature_3009,
					RequirementsPackage.eINSTANCE.getFeature());

			elements.put(Hardware_3010,
					RequirementsPackage.eINSTANCE.getHardware());

			elements.put(Constraint_3006,
					RequirementsPackage.eINSTANCE.getConstraint());

			elements.put(UserInterface_3014,
					RequirementsPackage.eINSTANCE.getUserInterface());

			elements.put(SoftwareInterface_3013,
					RequirementsPackage.eINSTANCE.getSoftwareInterface());

			elements.put(Performance_3011,
					RequirementsPackage.eINSTANCE.getPerformance());

			elements.put(Process_3025,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess());

			elements.put(InputDataReading_3026,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getInputDataReading());

			elements.put(ResultsOutput_3024,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getResultsOutput());

			elements.put(ErrorHandling_3027,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getErrorHandling());

			elements.put(StatusMonitoring_3023,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getStatusMonitoring());

			elements.put(Solver_3031,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getSolver());

			elements.put(MeshCreation_3032,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getMeshCreation());

			elements.put(PreProcessing_3033,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getPreProcessing());

			elements.put(PostProcessing_3034,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getPostProcessing());

			elements.put(DataDefinition_3035,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getDataDefinition());

			elements.put(SeismicSource_3036,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getSeismicSource());

			elements.put(ComputationalMesh_3037,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getComputationalMesh());

			elements.put(SyntheticSeismogram_3038,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getSyntheticSeismogram());

			elements.put(Station_3039,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getStation());

			elements.put(ControlParameter_3040,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getControlParameter());

			elements.put(RequirementSpace_3015,
					RequirementsPackage.eINSTANCE.getRequirementSpace());

			elements.put(DataProcessSpace_3029,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getDataProcessSpace());

			elements.put(ScientificProblemRepresentingModel_4063,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_RepresentingModel());

			elements.put(ScientificProblemInfluencedFeature_4008,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_InfluencedFeature());

			elements.put(Mathematical_GeophysicalModelRefinements_4064,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel_Refinements());

			elements.put(
					Mathematical_GeophysicalModelUsedInNumericalMethods_4065,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel_UsedInNumericalMethods());

			elements.put(Mathematical_GeophysicalModelDependencies_4066,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel_Dependencies());

			elements.put(Mathematical_GeophysicalModelInvolvedData_4067,
					KnowledgePackage.eINSTANCE
							.getMathematical_GeophysicalModel_InvolvedData());

			elements.put(NumericalMethodSolvedProblem_4057,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_SolvedProblem());

			elements.put(NumericalMethodDependencies_4015,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_Dependencies());

			elements.put(NumericalMethodRealizingRequirement_4068,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_RealizingRequirement());

			elements.put(NumericalMethodPerformance_4069,
					KnowledgePackage.eINSTANCE.getNumericalMethod_Performance());

			elements.put(
					InterfaceDetailsOfProvidingFunctionsAndProperties_4070,
					RequirementsPackage.eINSTANCE
							.getInterface_DetailsOfProvidingFunctionsAndProperties());

			elements.put(
					InterfaceDetailsOfRequiringFunctionsAndProperties_4071,
					RequirementsPackage.eINSTANCE
							.getInterface_DetailsOfRequiringFunctionsAndProperties());

			elements.put(RequirementRefinedRequirement_4054,
					RequirementsPackage.eINSTANCE
							.getRequirement_RefinedRequirement());

			elements.put(RequirementSpecifiedFeature_4052,
					RequirementsPackage.eINSTANCE
							.getRequirement_SpecifiedFeature());

			elements.put(RequirementProvidedInterface_4072,
					RequirementsPackage.eINSTANCE
							.getRequirement_ProvidedInterface());

			elements.put(RequirementRequiredInterface_4073,
					RequirementsPackage.eINSTANCE
							.getRequirement_RequiredInterface());

			elements.put(FeatureSuperFeature_4053,
					RequirementsPackage.eINSTANCE.getFeature_SuperFeature());

			elements.put(FeatureDependencies_4026,
					RequirementsPackage.eINSTANCE.getFeature_Dependencies());

			elements.put(FeatureRequiredInterfaces_4023,
					RequirementsPackage.eINSTANCE
							.getFeature_RequiredInterfaces());

			elements.put(FeatureProvidedInterfaces_4024,
					RequirementsPackage.eINSTANCE
							.getFeature_ProvidedInterfaces());

			elements.put(FeatureRequiredFeatures_4030,
					RequirementsPackage.eINSTANCE.getFeature_RequiredFeatures());

			elements.put(FeatureExcludedFeatures_4032,
					RequirementsPackage.eINSTANCE.getFeature_ExcludedFeatures());

			elements.put(ConstraintRestrictedFeature_4051,
					RequirementsPackage.eINSTANCE
							.getConstraint_RestrictedFeature());

			elements.put(PerformanceHardware_4074,
					RequirementsPackage.eINSTANCE.getPerformance_Hardware());

			elements.put(ProcessSuccessor_4047,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess_Successor());

			elements.put(ErrorHandlingHandledProcess_4061,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getErrorHandling_HandledProcess());

			elements.put(StatusMonitoringMonitoredProcess_4062,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getStatusMonitoring_MonitoredProcess());

			elements.put(DataDefinitionDefinedRequirement_4075,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getDataDefinition_DefinedRequirement());

			elements.put(DataDefinitionProvidedInterface_4076,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getDataDefinition_ProvidedInterface());

			elements.put(DataDefinitionRequiredInterface_4077,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getDataDefinition_RequiredInterface());

			elements.put(ControlParameterControlledProcess_4078,
					scrm.requirements.dataObject.DataObjectPackage.eINSTANCE
							.getControlParameter_ControlledProcess());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated NOT
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(SCRMDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(ScientificProblem_2007);
			KNOWN_ELEMENT_TYPES.add(Mathematical_GeophysicalModel_2047);
			KNOWN_ELEMENT_TYPES.add(NumericalMethod_2006);
			KNOWN_ELEMENT_TYPES.add(Assumption_2008);
			KNOWN_ELEMENT_TYPES.add(Requirement_2034);
			KNOWN_ELEMENT_TYPES.add(Feature_2009);
			KNOWN_ELEMENT_TYPES.add(Hardware_2010);
			KNOWN_ELEMENT_TYPES.add(Constraint_2011);
			KNOWN_ELEMENT_TYPES.add(UserInterface_2012);
			KNOWN_ELEMENT_TYPES.add(SoftwareInterface_2013);
			KNOWN_ELEMENT_TYPES.add(Performance_2015);
			KNOWN_ELEMENT_TYPES.add(Process_2035);
			KNOWN_ELEMENT_TYPES.add(InputDataReading_2036);
			KNOWN_ELEMENT_TYPES.add(ResultsOutput_2038);
			KNOWN_ELEMENT_TYPES.add(ErrorHandling_2039);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoring_2040);
			KNOWN_ELEMENT_TYPES.add(Solver_2048);
			KNOWN_ELEMENT_TYPES.add(MeshCreation_2049);
			KNOWN_ELEMENT_TYPES.add(PreProcessing_2050);
			KNOWN_ELEMENT_TYPES.add(PostProcessing_2051);
			KNOWN_ELEMENT_TYPES.add(DataDefinition_2052);
			KNOWN_ELEMENT_TYPES.add(SeismicSource_2053);
			KNOWN_ELEMENT_TYPES.add(ComputationalMesh_2054);
			KNOWN_ELEMENT_TYPES.add(SyntheticSeismogram_2055);
			KNOWN_ELEMENT_TYPES.add(Station_2056);
			KNOWN_ELEMENT_TYPES.add(ControlParameter_2057);
			KNOWN_ELEMENT_TYPES.add(KnowledgeSpace_2044);
			KNOWN_ELEMENT_TYPES.add(RequirementSpace_2045);
			KNOWN_ELEMENT_TYPES.add(DataProcessSpace_2046);
			KNOWN_ELEMENT_TYPES.add(ScientificProblem_3001);
			KNOWN_ELEMENT_TYPES.add(NumericalMethod_3002);
			KNOWN_ELEMENT_TYPES.add(Mathematical_GeophysicalModel_3030);
			KNOWN_ELEMENT_TYPES.add(Assumption_3004);
			KNOWN_ELEMENT_TYPES.add(KnowledgeSpace_3005);
			KNOWN_ELEMENT_TYPES.add(Requirement_3012);
			KNOWN_ELEMENT_TYPES.add(Feature_3009);
			KNOWN_ELEMENT_TYPES.add(Hardware_3010);
			KNOWN_ELEMENT_TYPES.add(Constraint_3006);
			KNOWN_ELEMENT_TYPES.add(UserInterface_3014);
			KNOWN_ELEMENT_TYPES.add(SoftwareInterface_3013);
			KNOWN_ELEMENT_TYPES.add(Performance_3011);
			KNOWN_ELEMENT_TYPES.add(Process_3025);
			KNOWN_ELEMENT_TYPES.add(InputDataReading_3026);
			KNOWN_ELEMENT_TYPES.add(ResultsOutput_3024);
			KNOWN_ELEMENT_TYPES.add(ErrorHandling_3027);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoring_3023);
			KNOWN_ELEMENT_TYPES.add(Solver_3031);
			KNOWN_ELEMENT_TYPES.add(MeshCreation_3032);
			KNOWN_ELEMENT_TYPES.add(PreProcessing_3033);
			KNOWN_ELEMENT_TYPES.add(PostProcessing_3034);
			KNOWN_ELEMENT_TYPES.add(DataDefinition_3035);
			KNOWN_ELEMENT_TYPES.add(SeismicSource_3036);
			KNOWN_ELEMENT_TYPES.add(ComputationalMesh_3037);
			KNOWN_ELEMENT_TYPES.add(SyntheticSeismogram_3038);
			KNOWN_ELEMENT_TYPES.add(Station_3039);
			KNOWN_ELEMENT_TYPES.add(ControlParameter_3040);
			KNOWN_ELEMENT_TYPES.add(RequirementSpace_3015);
			KNOWN_ELEMENT_TYPES.add(DataProcessSpace_3029);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemRepresentingModel_4063);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemInfluencedFeature_4008);
			KNOWN_ELEMENT_TYPES
					.add(Mathematical_GeophysicalModelRefinements_4064);
			KNOWN_ELEMENT_TYPES
					.add(Mathematical_GeophysicalModelUsedInNumericalMethods_4065);
			KNOWN_ELEMENT_TYPES
					.add(Mathematical_GeophysicalModelDependencies_4066);
			KNOWN_ELEMENT_TYPES
					.add(Mathematical_GeophysicalModelInvolvedData_4067);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodSolvedProblem_4057);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodDependencies_4015);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodRealizingRequirement_4068);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodPerformance_4069);
			KNOWN_ELEMENT_TYPES
					.add(InterfaceDetailsOfProvidingFunctionsAndProperties_4070);
			KNOWN_ELEMENT_TYPES
					.add(InterfaceDetailsOfRequiringFunctionsAndProperties_4071);
			KNOWN_ELEMENT_TYPES.add(RequirementRefinedRequirement_4054);
			KNOWN_ELEMENT_TYPES.add(RequirementSpecifiedFeature_4052);
			KNOWN_ELEMENT_TYPES.add(RequirementProvidedInterface_4072);
			KNOWN_ELEMENT_TYPES.add(RequirementRequiredInterface_4073);
			KNOWN_ELEMENT_TYPES.add(FeatureSuperFeature_4053);
			KNOWN_ELEMENT_TYPES.add(FeatureDependencies_4026);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredInterfaces_4023);
			KNOWN_ELEMENT_TYPES.add(FeatureProvidedInterfaces_4024);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredFeatures_4030);
			KNOWN_ELEMENT_TYPES.add(FeatureExcludedFeatures_4032);
			KNOWN_ELEMENT_TYPES.add(ConstraintRestrictedFeature_4051);
			KNOWN_ELEMENT_TYPES.add(PerformanceHardware_4074);
			KNOWN_ELEMENT_TYPES.add(ProcessSuccessor_4047);
			KNOWN_ELEMENT_TYPES.add(ErrorHandlingHandledProcess_4061);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoringMonitoredProcess_4062);
			KNOWN_ELEMENT_TYPES.add(DataDefinitionDefinedRequirement_4075);
			KNOWN_ELEMENT_TYPES.add(DataDefinitionProvidedInterface_4076);
			KNOWN_ELEMENT_TYPES.add(DataDefinitionRequiredInterface_4077);
			KNOWN_ELEMENT_TYPES.add(ControlParameterControlledProcess_4078);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated NOT
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return SCRMDiagram_1000;
		case ScientificProblemEditPart.VISUAL_ID:
			return ScientificProblem_2007;
		case Mathematical_GeophysicalModelEditPart.VISUAL_ID:
			return Mathematical_GeophysicalModel_2047;
		case NumericalMethodEditPart.VISUAL_ID:
			return NumericalMethod_2006;
		case AssumptionEditPart.VISUAL_ID:
			return Assumption_2008;
		case RequirementEditPart.VISUAL_ID:
			return Requirement_2034;
		case FeatureEditPart.VISUAL_ID:
			return Feature_2009;
		case HardwareEditPart.VISUAL_ID:
			return Hardware_2010;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2011;
		case UserInterfaceEditPart.VISUAL_ID:
			return UserInterface_2012;
		case SoftwareInterfaceEditPart.VISUAL_ID:
			return SoftwareInterface_2013;
		case PerformanceEditPart.VISUAL_ID:
			return Performance_2015;
		case ProcessEditPart.VISUAL_ID:
			return Process_2035;
		case InputDataReadingEditPart.VISUAL_ID:
			return InputDataReading_2036;
		case ResultsOutputEditPart.VISUAL_ID:
			return ResultsOutput_2038;
		case ErrorHandlingEditPart.VISUAL_ID:
			return ErrorHandling_2039;
		case StatusMonitoringEditPart.VISUAL_ID:
			return StatusMonitoring_2040;
		case SolverEditPart.VISUAL_ID:
			return Solver_2048;
		case MeshCreationEditPart.VISUAL_ID:
			return MeshCreation_2049;
		case PreProcessingEditPart.VISUAL_ID:
			return PreProcessing_2050;
		case PostProcessingEditPart.VISUAL_ID:
			return PostProcessing_2051;
		case DataDefinitionEditPart.VISUAL_ID:
			return DataDefinition_2052;
		case SeismicSourceEditPart.VISUAL_ID:
			return SeismicSource_2053;
		case ComputationalMeshEditPart.VISUAL_ID:
			return ComputationalMesh_2054;
		case SyntheticSeismogramEditPart.VISUAL_ID:
			return SyntheticSeismogram_2055;
		case StationEditPart.VISUAL_ID:
			return Station_2056;
		case ControlParameterEditPart.VISUAL_ID:
			return ControlParameter_2057;
		case KnowledgeSpaceEditPart.VISUAL_ID:
			return KnowledgeSpace_2044;
		case RequirementSpaceEditPart.VISUAL_ID:
			return RequirementSpace_2045;
		case DataProcessSpaceEditPart.VISUAL_ID:
			return DataProcessSpace_2046;
		case ScientificProblem2EditPart.VISUAL_ID:
			return ScientificProblem_3001;
		case NumericalMethod2EditPart.VISUAL_ID:
			return NumericalMethod_3002;
		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID:
			return Mathematical_GeophysicalModel_3030;
		case Assumption2EditPart.VISUAL_ID:
			return Assumption_3004;
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return KnowledgeSpace_3005;
		case Requirement2EditPart.VISUAL_ID:
			return Requirement_3012;
		case Feature2EditPart.VISUAL_ID:
			return Feature_3009;
		case Hardware2EditPart.VISUAL_ID:
			return Hardware_3010;
		case Constraint2EditPart.VISUAL_ID:
			return Constraint_3006;
		case UserInterface2EditPart.VISUAL_ID:
			return UserInterface_3014;
		case SoftwareInterface2EditPart.VISUAL_ID:
			return SoftwareInterface_3013;
		case Performance2EditPart.VISUAL_ID:
			return Performance_3011;
		case Process2EditPart.VISUAL_ID:
			return Process_3025;
		case InputDataReading2EditPart.VISUAL_ID:
			return InputDataReading_3026;
		case ResultsOutput2EditPart.VISUAL_ID:
			return ResultsOutput_3024;
		case ErrorHandling2EditPart.VISUAL_ID:
			return ErrorHandling_3027;
		case StatusMonitoring2EditPart.VISUAL_ID:
			return StatusMonitoring_3023;
		case Solver2EditPart.VISUAL_ID:
			return Solver_3031;
		case MeshCreation2EditPart.VISUAL_ID:
			return MeshCreation_3032;
		case PreProcessing2EditPart.VISUAL_ID:
			return PreProcessing_3033;
		case PostProcessing2EditPart.VISUAL_ID:
			return PostProcessing_3034;
		case DataDefinition2EditPart.VISUAL_ID:
			return DataDefinition_3035;
		case SeismicSource2EditPart.VISUAL_ID:
			return SeismicSource_3036;
		case ComputationalMesh2EditPart.VISUAL_ID:
			return ComputationalMesh_3037;
		case SyntheticSeismogram2EditPart.VISUAL_ID:
			return SyntheticSeismogram_3038;
		case Station2EditPart.VISUAL_ID:
			return Station_3039;
		case ControlParameter2EditPart.VISUAL_ID:
			return ControlParameter_3040;
		case RequirementSpace2EditPart.VISUAL_ID:
			return RequirementSpace_3015;
		case DataProcessSpace2EditPart.VISUAL_ID:
			return DataProcessSpace_3029;
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return ScientificProblemRepresentingModel_4063;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return ScientificProblemInfluencedFeature_4008;
		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID:
			return Mathematical_GeophysicalModelRefinements_4064;
		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID:
			return Mathematical_GeophysicalModelUsedInNumericalMethods_4065;
		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID:
			return Mathematical_GeophysicalModelDependencies_4066;
		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID:
			return Mathematical_GeophysicalModelInvolvedData_4067;
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return NumericalMethodSolvedProblem_4057;
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return NumericalMethodDependencies_4015;
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return NumericalMethodRealizingRequirement_4068;
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return NumericalMethodPerformance_4069;
		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID:
			return InterfaceDetailsOfProvidingFunctionsAndProperties_4070;
		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID:
			return InterfaceDetailsOfRequiringFunctionsAndProperties_4071;
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return RequirementRefinedRequirement_4054;
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return RequirementSpecifiedFeature_4052;
		case RequirementProvidedInterfaceEditPart.VISUAL_ID:
			return RequirementProvidedInterface_4072;
		case RequirementRequiredInterfaceEditPart.VISUAL_ID:
			return RequirementRequiredInterface_4073;
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return FeatureSuperFeature_4053;
		case FeatureDependenciesEditPart.VISUAL_ID:
			return FeatureDependencies_4026;
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return FeatureRequiredInterfaces_4023;
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return FeatureProvidedInterfaces_4024;
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return FeatureRequiredFeatures_4030;
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return FeatureExcludedFeatures_4032;
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return ConstraintRestrictedFeature_4051;
		case PerformanceHardwareEditPart.VISUAL_ID:
			return PerformanceHardware_4074;
		case ProcessSuccessorEditPart.VISUAL_ID:
			return ProcessSuccessor_4047;
		case ErrorHandlingHandledProcessEditPart.VISUAL_ID:
			return ErrorHandlingHandledProcess_4061;
		case StatusMonitoringMonitoredProcessEditPart.VISUAL_ID:
			return StatusMonitoringMonitoredProcess_4062;
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return DataDefinitionDefinedRequirement_4075;
		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID:
			return DataDefinitionProvidedInterface_4076;
		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID:
			return DataDefinitionRequiredInterface_4077;
		case ControlParameterControlledProcessEditPart.VISUAL_ID:
			return ControlParameterControlledProcess_4078;
		}
		return null;
	}

}
