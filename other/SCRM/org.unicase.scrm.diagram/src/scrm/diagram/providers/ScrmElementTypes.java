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
	public static final IElementType MathematicalModel_2005 = getElementType("org.unicase.scrm.diagram.MathematicalModel_2005"); //$NON-NLS-1$
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
	public static final IElementType Process_2014 = getElementType("org.unicase.scrm.diagram.Process_2014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Performance_2015 = getElementType("org.unicase.scrm.diagram.Performance_2015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataFlow_2016 = getElementType("org.unicase.scrm.diagram.DataFlow_2016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataDefinition_2017 = getElementType("org.unicase.scrm.diagram.DataDefinition_2017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputDataReading_2018 = getElementType("org.unicase.scrm.diagram.InputDataReading_2018"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataHandling_2019 = getElementType("org.unicase.scrm.diagram.DataHandling_2019"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ResultsOutput_2020 = getElementType("org.unicase.scrm.diagram.ResultsOutput_2020"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ErrorHandling_2021 = getElementType("org.unicase.scrm.diagram.ErrorHandling_2021"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StatusMonitoring_2022 = getElementType("org.unicase.scrm.diagram.StatusMonitoring_2022"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificKnowledgeRequirements_4005 = getElementType("org.unicase.scrm.diagram.ScientificKnowledgeRequirements_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemRepresentingModel_4006 = getElementType("org.unicase.scrm.diagram.ScientificProblemRepresentingModel_4006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemSolvingMethods_4041 = getElementType("org.unicase.scrm.diagram.ScientificProblemSolvingMethods_4041"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemInfluencedFeature_4008 = getElementType("org.unicase.scrm.diagram.ScientificProblemInfluencedFeature_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModel_4004 = getElementType("org.unicase.scrm.diagram.MathematicalModel_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModel_4010 = getElementType("org.unicase.scrm.diagram.MathematicalModel_4010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModelNumericalMethods_4011 = getElementType("org.unicase.scrm.diagram.MathematicalModelNumericalMethods_4011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModelDependencies_4012 = getElementType("org.unicase.scrm.diagram.MathematicalModelDependencies_4012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodDependencies_4015 = getElementType("org.unicase.scrm.diagram.NumericalMethodDependencies_4015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodRealizingRequirement_4016 = getElementType("org.unicase.scrm.diagram.NumericalMethodRealizingRequirement_4016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodPerformance_4017 = getElementType("org.unicase.scrm.diagram.NumericalMethodPerformance_4017"); //$NON-NLS-1$
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
	public static final IElementType FeatureConstraints_4025 = getElementType("org.unicase.scrm.diagram.FeatureConstraints_4025"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureDependencies_4026 = getElementType("org.unicase.scrm.diagram.FeatureDependencies_4026"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureDetailedRequirements_4027 = getElementType("org.unicase.scrm.diagram.FeatureDetailedRequirements_4027"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Feature_4029 = getElementType("org.unicase.scrm.diagram.Feature_4029"); //$NON-NLS-1$
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
	public static final IElementType Requirement_4036 = getElementType("org.unicase.scrm.diagram.Requirement_4036"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementDefiningData_4038 = getElementType("org.unicase.scrm.diagram.RequirementDefiningData_4038"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProcessDataFlow_4040 = getElementType("org.unicase.scrm.diagram.ProcessDataFlow_4040"); //$NON-NLS-1$

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
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(SCRMDiagram_1000,
					ScrmPackage.eINSTANCE.getSCRMDiagram());

			elements.put(ScientificProblem_2007,
					KnowledgePackage.eINSTANCE.getScientificProblem());

			elements.put(MathematicalModel_2005,
					KnowledgePackage.eINSTANCE.getMathematicalModel());

			elements.put(NumericalMethod_2006,
					KnowledgePackage.eINSTANCE.getNumericalMethod());

			elements.put(Assumption_2008,
					KnowledgePackage.eINSTANCE.getAssumption());

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

			elements.put(Process_2014,
					RequirementsPackage.eINSTANCE.getProcess());

			elements.put(Performance_2015,
					RequirementsPackage.eINSTANCE.getPerformance());

			elements.put(DataFlow_2016,
					RequirementsPackage.eINSTANCE.getDataFlow());

			elements.put(DataDefinition_2017,
					RequirementsPackage.eINSTANCE.getDataDefinition());

			elements.put(
					InputDataReading_2018,
					scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
							.getInputDataReading());

			elements.put(
					DataHandling_2019,
					scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
							.getDataHandling());

			elements.put(
					ResultsOutput_2020,
					scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
							.getResultsOutput());

			elements.put(
					ErrorHandling_2021,
					scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
							.getErrorHandling());

			elements.put(
					StatusMonitoring_2022,
					scrm.requirements.dataProcessing.DataProcessingPackage.eINSTANCE
							.getStatusMonitoring());

			elements.put(ScientificKnowledgeRequirements_4005,
					KnowledgePackage.eINSTANCE
							.getScientificKnowledge_Requirements());

			elements.put(ScientificProblemRepresentingModel_4006,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_RepresentingModel());

			elements.put(ScientificProblemSolvingMethods_4041,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_SolvingMethods());

			elements.put(ScientificProblemInfluencedFeature_4008,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_InfluencedFeature());

			elements.put(MathematicalModel_4004,
					KnowledgePackage.eINSTANCE.getMathematicalModel());

			elements.put(MathematicalModel_4010,
					KnowledgePackage.eINSTANCE.getMathematicalModel());

			elements.put(MathematicalModelNumericalMethods_4011,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_NumericalMethods());

			elements.put(MathematicalModelDependencies_4012,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_Dependencies());

			elements.put(NumericalMethodDependencies_4015,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_Dependencies());

			elements.put(NumericalMethodRealizingRequirement_4016,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_RealizingRequirement());

			elements.put(NumericalMethodPerformance_4017,
					KnowledgePackage.eINSTANCE.getNumericalMethod_Performance());

			elements.put(FeatureRequiredInterfaces_4023,
					RequirementsPackage.eINSTANCE
							.getFeature_RequiredInterfaces());

			elements.put(FeatureProvidedInterfaces_4024,
					RequirementsPackage.eINSTANCE
							.getFeature_ProvidedInterfaces());

			elements.put(FeatureConstraints_4025,
					RequirementsPackage.eINSTANCE.getFeature_Constraints());

			elements.put(FeatureDependencies_4026,
					RequirementsPackage.eINSTANCE.getFeature_Dependencies());

			elements.put(FeatureDetailedRequirements_4027,
					RequirementsPackage.eINSTANCE
							.getFeature_DetailedRequirements());

			elements.put(Feature_4029,
					RequirementsPackage.eINSTANCE.getFeature());

			elements.put(FeatureRequiredFeatures_4030,
					RequirementsPackage.eINSTANCE.getFeature_RequiredFeatures());

			elements.put(FeatureExcludedFeatures_4032,
					RequirementsPackage.eINSTANCE.getFeature_ExcludedFeatures());

			elements.put(Requirement_4036,
					RequirementsPackage.eINSTANCE.getRequirement());

			elements.put(RequirementDefiningData_4038,
					RequirementsPackage.eINSTANCE.getRequirement_DefiningData());

			elements.put(ProcessDataFlow_4040,
					RequirementsPackage.eINSTANCE.getProcess_DataFlow());
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
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(SCRMDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(ScientificProblem_2007);
			KNOWN_ELEMENT_TYPES.add(MathematicalModel_2005);
			KNOWN_ELEMENT_TYPES.add(NumericalMethod_2006);
			KNOWN_ELEMENT_TYPES.add(Assumption_2008);
			KNOWN_ELEMENT_TYPES.add(Feature_2009);
			KNOWN_ELEMENT_TYPES.add(Hardware_2010);
			KNOWN_ELEMENT_TYPES.add(Constraint_2011);
			KNOWN_ELEMENT_TYPES.add(UserInterface_2012);
			KNOWN_ELEMENT_TYPES.add(SoftwareInterface_2013);
			KNOWN_ELEMENT_TYPES.add(Process_2014);
			KNOWN_ELEMENT_TYPES.add(Performance_2015);
			KNOWN_ELEMENT_TYPES.add(DataFlow_2016);
			KNOWN_ELEMENT_TYPES.add(DataDefinition_2017);
			KNOWN_ELEMENT_TYPES.add(InputDataReading_2018);
			KNOWN_ELEMENT_TYPES.add(DataHandling_2019);
			KNOWN_ELEMENT_TYPES.add(ResultsOutput_2020);
			KNOWN_ELEMENT_TYPES.add(ErrorHandling_2021);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoring_2022);
			KNOWN_ELEMENT_TYPES.add(ScientificKnowledgeRequirements_4005);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemRepresentingModel_4006);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemSolvingMethods_4041);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemInfluencedFeature_4008);
			KNOWN_ELEMENT_TYPES.add(MathematicalModel_4004);
			KNOWN_ELEMENT_TYPES.add(MathematicalModel_4010);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelNumericalMethods_4011);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelDependencies_4012);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodDependencies_4015);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodRealizingRequirement_4016);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodPerformance_4017);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredInterfaces_4023);
			KNOWN_ELEMENT_TYPES.add(FeatureProvidedInterfaces_4024);
			KNOWN_ELEMENT_TYPES.add(FeatureConstraints_4025);
			KNOWN_ELEMENT_TYPES.add(FeatureDependencies_4026);
			KNOWN_ELEMENT_TYPES.add(FeatureDetailedRequirements_4027);
			KNOWN_ELEMENT_TYPES.add(Feature_4029);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredFeatures_4030);
			KNOWN_ELEMENT_TYPES.add(FeatureExcludedFeatures_4032);
			KNOWN_ELEMENT_TYPES.add(Requirement_4036);
			KNOWN_ELEMENT_TYPES.add(RequirementDefiningData_4038);
			KNOWN_ELEMENT_TYPES.add(ProcessDataFlow_4040);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return SCRMDiagram_1000;
		case ScientificProblemEditPart.VISUAL_ID:
			return ScientificProblem_2007;
		case MathematicalModelEditPart.VISUAL_ID:
			return MathematicalModel_2005;
		case NumericalMethodEditPart.VISUAL_ID:
			return NumericalMethod_2006;
		case AssumptionEditPart.VISUAL_ID:
			return Assumption_2008;
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
		case ProcessEditPart.VISUAL_ID:
			return Process_2014;
		case PerformanceEditPart.VISUAL_ID:
			return Performance_2015;
		case DataFlowEditPart.VISUAL_ID:
			return DataFlow_2016;
		case DataDefinitionEditPart.VISUAL_ID:
			return DataDefinition_2017;
		case InputDataReadingEditPart.VISUAL_ID:
			return InputDataReading_2018;
		case DataHandlingEditPart.VISUAL_ID:
			return DataHandling_2019;
		case ResultsOutputEditPart.VISUAL_ID:
			return ResultsOutput_2020;
		case ErrorHandlingEditPart.VISUAL_ID:
			return ErrorHandling_2021;
		case StatusMonitoringEditPart.VISUAL_ID:
			return StatusMonitoring_2022;
		case ScientificKnowledgeRequirementsEditPart.VISUAL_ID:
			return ScientificKnowledgeRequirements_4005;
		case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
			return ScientificProblemRepresentingModel_4006;
		case ScientificProblemSolvingMethodsEditPart.VISUAL_ID:
			return ScientificProblemSolvingMethods_4041;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return ScientificProblemInfluencedFeature_4008;
		case MathematicalModel2EditPart.VISUAL_ID:
			return MathematicalModel_4004;
		case MathematicalModel3EditPart.VISUAL_ID:
			return MathematicalModel_4010;
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return MathematicalModelNumericalMethods_4011;
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return MathematicalModelDependencies_4012;
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return NumericalMethodDependencies_4015;
		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
			return NumericalMethodRealizingRequirement_4016;
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return NumericalMethodPerformance_4017;
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return FeatureRequiredInterfaces_4023;
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return FeatureProvidedInterfaces_4024;
		case FeatureConstraintsEditPart.VISUAL_ID:
			return FeatureConstraints_4025;
		case FeatureDependenciesEditPart.VISUAL_ID:
			return FeatureDependencies_4026;
		case FeatureDetailedRequirementsEditPart.VISUAL_ID:
			return FeatureDetailedRequirements_4027;
		case Feature2EditPart.VISUAL_ID:
			return Feature_4029;
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return FeatureRequiredFeatures_4030;
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return FeatureExcludedFeatures_4032;
		case RequirementEditPart.VISUAL_ID:
			return Requirement_4036;
		case RequirementDefiningDataEditPart.VISUAL_ID:
			return RequirementDefiningData_4038;
		case ProcessDataFlowEditPart.VISUAL_ID:
			return ProcessDataFlow_4040;
		}
		return null;
	}

}
