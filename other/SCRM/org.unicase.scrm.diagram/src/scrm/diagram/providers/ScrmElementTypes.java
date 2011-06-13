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
	public static final IElementType Process_2035 = getElementType("org.unicase.scrm.diagram.Process_2035"); //$NON-NLS-1$

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
	public static final IElementType InputDataReading_2036 = getElementType("org.unicase.scrm.diagram.InputDataReading_2036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataHandling_2037 = getElementType("org.unicase.scrm.diagram.DataHandling_2037"); //$NON-NLS-1$

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
	public static final IElementType Requirement_2034 = getElementType("org.unicase.scrm.diagram.Requirement_2034"); //$NON-NLS-1$

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
	public static final IElementType MathematicalModel_3003 = getElementType("org.unicase.scrm.diagram.MathematicalModel_3003"); //$NON-NLS-1$

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
	public static final IElementType Constraint_3006 = getElementType("org.unicase.scrm.diagram.Constraint_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataDefinition_3007 = getElementType("org.unicase.scrm.diagram.DataDefinition_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataFlow_3008 = getElementType("org.unicase.scrm.diagram.DataFlow_3008"); //$NON-NLS-1$

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
	public static final IElementType Performance_3011 = getElementType("org.unicase.scrm.diagram.Performance_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Requirement_3012 = getElementType("org.unicase.scrm.diagram.Requirement_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SoftwareInterface_3013 = getElementType("org.unicase.scrm.diagram.SoftwareInterface_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UserInterface_3014 = getElementType("org.unicase.scrm.diagram.UserInterface_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequirementSpace_3015 = getElementType("org.unicase.scrm.diagram.RequirementSpace_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StatusMonitoring_3016 = getElementType("org.unicase.scrm.diagram.StatusMonitoring_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ResultsOutput_3017 = getElementType("org.unicase.scrm.diagram.ResultsOutput_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Process_3018 = getElementType("org.unicase.scrm.diagram.Process_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputDataReading_3019 = getElementType("org.unicase.scrm.diagram.InputDataReading_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ErrorHandling_3020 = getElementType("org.unicase.scrm.diagram.ErrorHandling_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataHandling_3021 = getElementType("org.unicase.scrm.diagram.DataHandling_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataProcessSpace_3022 = getElementType("org.unicase.scrm.diagram.DataProcessSpace_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ScientificProblemInfluencedFeature_4008 = getElementType("org.unicase.scrm.diagram.ScientificProblemInfluencedFeature_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MathematicalModelRefinedModel_4058 = getElementType("org.unicase.scrm.diagram.MathematicalModelRefinedModel_4058"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MathematicalModelRepresentedProblem_4048 = getElementType("org.unicase.scrm.diagram.MathematicalModelRepresentedProblem_4048"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NumericalMethodSolvedProblem_4057 = getElementType("org.unicase.scrm.diagram.NumericalMethodSolvedProblem_4057"); //$NON-NLS-1$

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
	public static final IElementType RequirementRealizedMethod_4050 = getElementType("org.unicase.scrm.diagram.RequirementRealizedMethod_4050"); //$NON-NLS-1$

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
	public static final IElementType ConstraintRestrictedFeature_4051 = getElementType("org.unicase.scrm.diagram.ConstraintRestrictedFeature_4051"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FeatureDependencies_4026 = getElementType("org.unicase.scrm.diagram.FeatureDependencies_4026"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementSpecifiedFeature_4052 = getElementType("org.unicase.scrm.diagram.RequirementSpecifiedFeature_4052"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FeatureSuperFeature_4053 = getElementType("org.unicase.scrm.diagram.FeatureSuperFeature_4053"); //$NON-NLS-1$

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
	public static final IElementType RequirementRefinedRequirement_4054 = getElementType("org.unicase.scrm.diagram.RequirementRefinedRequirement_4054"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataDefinitionDefinedRequirement_4055 = getElementType("org.unicase.scrm.diagram.DataDefinitionDefinedRequirement_4055"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataFlowSpecifiedProcess_4056 = getElementType("org.unicase.scrm.diagram.DataFlowSpecifiedProcess_4056"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProcessSuccessor_4047 = getElementType("org.unicase.scrm.diagram.ProcessSuccessor_4047"); //$NON-NLS-1$

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

			elements.put(Process_2035,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess());

			elements.put(Performance_2015,
					RequirementsPackage.eINSTANCE.getPerformance());

			elements.put(DataFlow_2016,
					RequirementsPackage.eINSTANCE.getDataFlow());

			elements.put(DataDefinition_2017,
					RequirementsPackage.eINSTANCE.getDataDefinition());

			elements.put(InputDataReading_2036,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getInputDataReading());

			elements.put(DataHandling_2037,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getDataHandling());

			elements.put(ResultsOutput_2038,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getResultsOutput());

			elements.put(ErrorHandling_2039,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getErrorHandling());

			elements.put(StatusMonitoring_2040,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getStatusMonitoring());

			elements.put(Requirement_2034,
					RequirementsPackage.eINSTANCE.getRequirement());

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

			elements.put(MathematicalModel_3003,
					KnowledgePackage.eINSTANCE.getMathematicalModel());

			elements.put(Assumption_3004,
					KnowledgePackage.eINSTANCE.getAssumption());

			elements.put(KnowledgeSpace_3005,
					KnowledgePackage.eINSTANCE.getKnowledgeSpace());

			elements.put(Constraint_3006,
					RequirementsPackage.eINSTANCE.getConstraint());

			elements.put(DataDefinition_3007,
					RequirementsPackage.eINSTANCE.getDataDefinition());

			elements.put(DataFlow_3008,
					RequirementsPackage.eINSTANCE.getDataFlow());

			elements.put(Feature_3009,
					RequirementsPackage.eINSTANCE.getFeature());

			elements.put(Hardware_3010,
					RequirementsPackage.eINSTANCE.getHardware());

			elements.put(Performance_3011,
					RequirementsPackage.eINSTANCE.getPerformance());

			elements.put(Requirement_3012,
					RequirementsPackage.eINSTANCE.getRequirement());

			elements.put(SoftwareInterface_3013,
					RequirementsPackage.eINSTANCE.getSoftwareInterface());

			elements.put(UserInterface_3014,
					RequirementsPackage.eINSTANCE.getUserInterface());

			elements.put(RequirementSpace_3015,
					RequirementsPackage.eINSTANCE.getRequirementSpace());

			elements.put(StatusMonitoring_3016,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getStatusMonitoring());

			elements.put(ResultsOutput_3017,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getResultsOutput());

			elements.put(Process_3018,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess());

			elements.put(InputDataReading_3019,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getInputDataReading());

			elements.put(ErrorHandling_3020,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getErrorHandling());

			elements.put(DataHandling_3021,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getDataHandling());

			elements.put(DataProcessSpace_3022,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getDataProcessSpace());

			elements.put(MathematicalModelRepresentedProblem_4048,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_RepresentedProblem());

			elements.put(NumericalMethodSolvedProblem_4057,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_SolvedProblem());

			elements.put(ScientificProblemInfluencedFeature_4008,
					KnowledgePackage.eINSTANCE
							.getScientificProblem_InfluencedFeature());

			elements.put(MathematicalModelRefinedModel_4058,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_RefinedModel());

			elements.put(MathematicalModelNumericalMethods_4011,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_NumericalMethods());

			elements.put(MathematicalModelDependencies_4012,
					KnowledgePackage.eINSTANCE
							.getMathematicalModel_Dependencies());

			elements.put(NumericalMethodDependencies_4015,
					KnowledgePackage.eINSTANCE
							.getNumericalMethod_Dependencies());

			elements.put(RequirementRealizedMethod_4050,
					RequirementsPackage.eINSTANCE
							.getRequirement_RealizedMethod());

			elements.put(NumericalMethodPerformance_4017,
					KnowledgePackage.eINSTANCE.getNumericalMethod_Performance());

			elements.put(FeatureRequiredInterfaces_4023,
					RequirementsPackage.eINSTANCE
							.getFeature_RequiredInterfaces());

			elements.put(FeatureProvidedInterfaces_4024,
					RequirementsPackage.eINSTANCE
							.getFeature_ProvidedInterfaces());

			elements.put(ConstraintRestrictedFeature_4051,
					RequirementsPackage.eINSTANCE
							.getConstraint_RestrictedFeature());

			elements.put(FeatureDependencies_4026,
					RequirementsPackage.eINSTANCE.getFeature_Dependencies());

			elements.put(RequirementSpecifiedFeature_4052,
					RequirementsPackage.eINSTANCE
							.getRequirement_SpecifiedFeature());

			elements.put(FeatureSuperFeature_4053,
					RequirementsPackage.eINSTANCE.getFeature_SuperFeature());

			elements.put(FeatureRequiredFeatures_4030,
					RequirementsPackage.eINSTANCE.getFeature_RequiredFeatures());

			elements.put(FeatureExcludedFeatures_4032,
					RequirementsPackage.eINSTANCE.getFeature_ExcludedFeatures());

			elements.put(RequirementRefinedRequirement_4054,
					RequirementsPackage.eINSTANCE
							.getRequirement_RefinedRequirement());

			elements.put(DataDefinitionDefinedRequirement_4055,
					RequirementsPackage.eINSTANCE
							.getDataDefinition_DefinedRequirement());

			elements.put(DataFlowSpecifiedProcess_4056,
					RequirementsPackage.eINSTANCE
							.getDataFlow_SpecifiedProcess());

			elements.put(ProcessSuccessor_4047,
					scrm.requirements.dataProcess.DataProcessPackage.eINSTANCE
							.getProcess_Successor());
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
			KNOWN_ELEMENT_TYPES.add(Process_2035);
			KNOWN_ELEMENT_TYPES.add(Performance_2015);
			KNOWN_ELEMENT_TYPES.add(DataFlow_2016);
			KNOWN_ELEMENT_TYPES.add(DataDefinition_2017);
			KNOWN_ELEMENT_TYPES.add(InputDataReading_2036);
			KNOWN_ELEMENT_TYPES.add(DataHandling_2037);
			KNOWN_ELEMENT_TYPES.add(ResultsOutput_2038);
			KNOWN_ELEMENT_TYPES.add(ErrorHandling_2039);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoring_2040);
			KNOWN_ELEMENT_TYPES.add(Requirement_2034);
			KNOWN_ELEMENT_TYPES.add(KnowledgeSpace_2044);
			KNOWN_ELEMENT_TYPES.add(RequirementSpace_2045);
			KNOWN_ELEMENT_TYPES.add(DataProcessSpace_2046);
			KNOWN_ELEMENT_TYPES.add(ScientificProblem_3001);
			KNOWN_ELEMENT_TYPES.add(NumericalMethod_3002);
			KNOWN_ELEMENT_TYPES.add(MathematicalModel_3003);
			KNOWN_ELEMENT_TYPES.add(Assumption_3004);
			KNOWN_ELEMENT_TYPES.add(KnowledgeSpace_3005);
			KNOWN_ELEMENT_TYPES.add(Constraint_3006);
			KNOWN_ELEMENT_TYPES.add(DataDefinition_3007);
			KNOWN_ELEMENT_TYPES.add(DataFlow_3008);
			KNOWN_ELEMENT_TYPES.add(Feature_3009);
			KNOWN_ELEMENT_TYPES.add(Hardware_3010);
			KNOWN_ELEMENT_TYPES.add(Performance_3011);
			KNOWN_ELEMENT_TYPES.add(Requirement_3012);
			KNOWN_ELEMENT_TYPES.add(SoftwareInterface_3013);
			KNOWN_ELEMENT_TYPES.add(UserInterface_3014);
			KNOWN_ELEMENT_TYPES.add(RequirementSpace_3015);
			KNOWN_ELEMENT_TYPES.add(StatusMonitoring_3016);
			KNOWN_ELEMENT_TYPES.add(ResultsOutput_3017);
			KNOWN_ELEMENT_TYPES.add(Process_3018);
			KNOWN_ELEMENT_TYPES.add(InputDataReading_3019);
			KNOWN_ELEMENT_TYPES.add(ErrorHandling_3020);
			KNOWN_ELEMENT_TYPES.add(DataHandling_3021);
			KNOWN_ELEMENT_TYPES.add(DataProcessSpace_3022);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelRepresentedProblem_4048);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodSolvedProblem_4057);
			KNOWN_ELEMENT_TYPES.add(ScientificProblemInfluencedFeature_4008);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelRefinedModel_4058);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelNumericalMethods_4011);
			KNOWN_ELEMENT_TYPES.add(MathematicalModelDependencies_4012);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodDependencies_4015);
			KNOWN_ELEMENT_TYPES.add(RequirementRealizedMethod_4050);
			KNOWN_ELEMENT_TYPES.add(NumericalMethodPerformance_4017);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredInterfaces_4023);
			KNOWN_ELEMENT_TYPES.add(FeatureProvidedInterfaces_4024);
			KNOWN_ELEMENT_TYPES.add(ConstraintRestrictedFeature_4051);
			KNOWN_ELEMENT_TYPES.add(FeatureDependencies_4026);
			KNOWN_ELEMENT_TYPES.add(RequirementSpecifiedFeature_4052);
			KNOWN_ELEMENT_TYPES.add(FeatureSuperFeature_4053);
			KNOWN_ELEMENT_TYPES.add(FeatureRequiredFeatures_4030);
			KNOWN_ELEMENT_TYPES.add(FeatureExcludedFeatures_4032);
			KNOWN_ELEMENT_TYPES.add(RequirementRefinedRequirement_4054);
			KNOWN_ELEMENT_TYPES.add(DataDefinitionDefinedRequirement_4055);
			KNOWN_ELEMENT_TYPES.add(DataFlowSpecifiedProcess_4056);
			KNOWN_ELEMENT_TYPES.add(ProcessSuccessor_4047);
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
			return Process_2035;
		case PerformanceEditPart.VISUAL_ID:
			return Performance_2015;
		case DataFlowEditPart.VISUAL_ID:
			return DataFlow_2016;
		case DataDefinitionEditPart.VISUAL_ID:
			return DataDefinition_2017;
		case InputDataReadingEditPart.VISUAL_ID:
			return InputDataReading_2036;
		case DataHandlingEditPart.VISUAL_ID:
			return DataHandling_2037;
		case ResultsOutputEditPart.VISUAL_ID:
			return ResultsOutput_2038;
		case ErrorHandlingEditPart.VISUAL_ID:
			return ErrorHandling_2039;
		case StatusMonitoringEditPart.VISUAL_ID:
			return StatusMonitoring_2040;
		case RequirementEditPart.VISUAL_ID:
			return Requirement_2034;
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
		case MathematicalModel2EditPart.VISUAL_ID:
			return MathematicalModel_3003;
		case Assumption2EditPart.VISUAL_ID:
			return Assumption_3004;
		case KnowledgeSpace2EditPart.VISUAL_ID:
			return KnowledgeSpace_3005;
		case Constraint2EditPart.VISUAL_ID:
			return Constraint_3006;
		case DataDefinition2EditPart.VISUAL_ID:
			return DataDefinition_3007;
		case DataFlow2EditPart.VISUAL_ID:
			return DataFlow_3008;
		case Feature2EditPart.VISUAL_ID:
			return Feature_3009;
		case Hardware2EditPart.VISUAL_ID:
			return Hardware_3010;
		case Performance2EditPart.VISUAL_ID:
			return Performance_3011;
		case Requirement2EditPart.VISUAL_ID:
			return Requirement_3012;
		case SoftwareInterface2EditPart.VISUAL_ID:
			return SoftwareInterface_3013;
		case UserInterface2EditPart.VISUAL_ID:
			return UserInterface_3014;
		case RequirementSpace2EditPart.VISUAL_ID:
			return RequirementSpace_3015;
		case StatusMonitoring2EditPart.VISUAL_ID:
			return StatusMonitoring_3016;
		case ResultsOutput2EditPart.VISUAL_ID:
			return ResultsOutput_3017;
		case Process2EditPart.VISUAL_ID:
			return Process_3018;
		case InputDataReading2EditPart.VISUAL_ID:
			return InputDataReading_3019;
		case ErrorHandling2EditPart.VISUAL_ID:
			return ErrorHandling_3020;
		case DataHandling2EditPart.VISUAL_ID:
			return DataHandling_3021;
		case DataProcessSpace2EditPart.VISUAL_ID:
			return DataProcessSpace_3022;
		case MathematicalModelRepresentedProblemEditPart.VISUAL_ID:
			return MathematicalModelRepresentedProblem_4048;
		case NumericalMethodSolvedProblemEditPart.VISUAL_ID:
			return NumericalMethodSolvedProblem_4057;
		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
			return ScientificProblemInfluencedFeature_4008;
		case MathematicalModelRefinedModelEditPart.VISUAL_ID:
			return MathematicalModelRefinedModel_4058;
		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
			return MathematicalModelNumericalMethods_4011;
		case MathematicalModelDependenciesEditPart.VISUAL_ID:
			return MathematicalModelDependencies_4012;
		case NumericalMethodDependenciesEditPart.VISUAL_ID:
			return NumericalMethodDependencies_4015;
		case RequirementRealizedMethodEditPart.VISUAL_ID:
			return RequirementRealizedMethod_4050;
		case NumericalMethodPerformanceEditPart.VISUAL_ID:
			return NumericalMethodPerformance_4017;
		case FeatureRequiredInterfacesEditPart.VISUAL_ID:
			return FeatureRequiredInterfaces_4023;
		case FeatureProvidedInterfacesEditPart.VISUAL_ID:
			return FeatureProvidedInterfaces_4024;
		case ConstraintRestrictedFeatureEditPart.VISUAL_ID:
			return ConstraintRestrictedFeature_4051;
		case FeatureDependenciesEditPart.VISUAL_ID:
			return FeatureDependencies_4026;
		case RequirementSpecifiedFeatureEditPart.VISUAL_ID:
			return RequirementSpecifiedFeature_4052;
		case FeatureSuperFeatureEditPart.VISUAL_ID:
			return FeatureSuperFeature_4053;
		case FeatureRequiredFeaturesEditPart.VISUAL_ID:
			return FeatureRequiredFeatures_4030;
		case FeatureExcludedFeaturesEditPart.VISUAL_ID:
			return FeatureExcludedFeatures_4032;
		case RequirementRefinedRequirementEditPart.VISUAL_ID:
			return RequirementRefinedRequirement_4054;
		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID:
			return DataDefinitionDefinedRequirement_4055;
		case DataFlowSpecifiedProcessEditPart.VISUAL_ID:
			return DataFlowSpecifiedProcess_4056;
		case ProcessSuccessorEditPart.VISUAL_ID:
			return ProcessSuccessor_4047;
		}
		return null;
	}

}
