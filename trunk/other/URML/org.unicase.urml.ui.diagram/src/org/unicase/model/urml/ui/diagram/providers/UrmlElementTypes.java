package org.unicase.model.urml.ui.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureRequieredFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementSubFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference3EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReference4EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalReferenceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalSubGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementSubNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceSubServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointVarietyEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;

import urml.danger.DangerPackage;
import urml.feature.FeaturePackage;
import urml.feature.provider.AbstractFeatureItemProvider;
import urml.feature.provider.FeatureItemProviderAdapterFactory;
import urml.goal.GoalPackage;
import urml.requirement.RequirementPackage;
import urml.service.ServicePackage;
import urml.usecase.UsecasePackage;

/**
 * @generated
 */
public class UrmlElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UrmlElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType URMLDiagram_1000 = getElementType("org.unicase.urml.ui.diagram.URMLDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Stakeholder_2002 = getElementType("org.unicase.urml.ui.diagram.Stakeholder_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Goal_2001 = getElementType("org.unicase.urml.ui.diagram.Goal_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionalRequirement_2006 = getElementType("org.unicase.urml.ui.diagram.FunctionalRequirement_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Feature_2012 = getElementType("org.unicase.urml.ui.diagram.Feature_2012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Service_2007 = getElementType("org.unicase.urml.ui.diagram.Service_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NonFunctionalRequirement_2008 = getElementType("org.unicase.urml.ui.diagram.NonFunctionalRequirement_2008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Danger_2009 = getElementType("org.unicase.urml.ui.diagram.Danger_2009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_2010 = getElementType("org.unicase.urml.ui.diagram.Actor_2010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProceduralMitigation_2011 = getElementType("org.unicase.urml.ui.diagram.ProceduralMitigation_2011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VariationPoint_2013 = getElementType("org.unicase.urml.ui.diagram.VariationPoint_2013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VariationPointInstance_2014 = getElementType("org.unicase.urml.ui.diagram.VariationPointInstance_2014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Product_2015 = getElementType("org.unicase.urml.ui.diagram.Product_2015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StakeholderGoals_4008 = getElementType("org.unicase.urml.ui.diagram.StakeholderGoals_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AbstractFeatureSubFeatures_4034 = getElementType("org.unicase.urml.ui.diagram.AbstractFeatureSubFeatures_4034"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AbstractFeatureDetailingFunctionalRequirements_4035 = getElementType("org.unicase.urml.ui.diagram.AbstractFeatureDetailingFunctionalRequirements_4035"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AbstractFeatureConstrainingNonFunctionalRequirements_4036 = getElementType("org.unicase.urml.ui.diagram.AbstractFeatureConstrainingNonFunctionalRequirements_4036"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AbstractFeatureRequieredFeatures_4037 = getElementType("org.unicase.urml.ui.diagram.AbstractFeatureRequieredFeatures_4037"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AbstractFeatureExcludedFeatures_4038 = getElementType("org.unicase.urml.ui.diagram.AbstractFeatureExcludedFeatures_4038"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalRealizedFeatures_4004 = getElementType("org.unicase.urml.ui.diagram.GoalRealizedFeatures_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalSubGoals_4018 = getElementType("org.unicase.urml.ui.diagram.GoalSubGoals_4018"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalReference_4016 = getElementType("org.unicase.urml.ui.diagram.GoalReference_4016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalReference_4023 = getElementType("org.unicase.urml.ui.diagram.GoalReference_4023"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalReference_4024 = getElementType("org.unicase.urml.ui.diagram.GoalReference_4024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GoalReference_4025 = getElementType("org.unicase.urml.ui.diagram.GoalReference_4025"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementImplementingServices_4005 = getElementType("org.unicase.urml.ui.diagram.RequirementImplementingServices_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NonFunctionalRequirementSubNonFunctionalRequirements_4043 = getElementType("org.unicase.urml.ui.diagram.NonFunctionalRequirementSubNonFunctionalRequirements_4043"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionalRequirementSubFunctionalRequirements_4044 = getElementType("org.unicase.urml.ui.diagram.FunctionalRequirementSubFunctionalRequirements_4044"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MitigationMitigatedDangers_4012 = getElementType("org.unicase.urml.ui.diagram.MitigationMitigatedDangers_4012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DangerHarmedAssets_4013 = getElementType("org.unicase.urml.ui.diagram.DangerHarmedAssets_4013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AssetTriggeredDangers_4017 = getElementType("org.unicase.urml.ui.diagram.AssetTriggeredDangers_4017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ServiceSubServices_4022 = getElementType("org.unicase.urml.ui.diagram.ServiceSubServices_4022"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VariationPointVariety_4042 = getElementType("org.unicase.urml.ui.diagram.VariationPointVariety_4042"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VariationPointInstanceVariationPoint_4033 = getElementType("org.unicase.urml.ui.diagram.VariationPointInstanceVariationPoint_4033"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VariationPointInstanceSelectedFeatures_4040 = getElementType("org.unicase.urml.ui.diagram.VariationPointInstanceSelectedFeatures_4040"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProductVariationPointInstances_4032 = getElementType("org.unicase.urml.ui.diagram.ProductVariationPointInstances_4032"); //$NON-NLS-1$

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
	 * @generated NOT
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
			/* user code */
			// TODO : check implementation efficiency
			else if (eContainingClass.getName().equals("AbstractFeature")) {
				FeatureItemProviderAdapterFactory factory = new FeatureItemProviderAdapterFactory();
				AbstractFeatureItemProvider provider = (AbstractFeatureItemProvider) factory
					.createAbstractFeatureAdapter();
				return ExtendedImageRegistry.getInstance().getImageDescriptor(provider.getImage(new Object()));
			}
			/* user code */
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UrmlDiagramEditorPlugin.getInstance().getItemImageDescriptor(
					eClass.getEPackage().getEFactoryInstance().create(eClass));
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
			elements = new IdentityHashMap();

			elements.put(URMLDiagram_1000, UrmlPackage.eINSTANCE.getURMLDiagram());

			elements.put(Stakeholder_2002, UrmlPackage.eINSTANCE.getStakeholder());

			elements.put(Goal_2001, GoalPackage.eINSTANCE.getGoal());

			elements.put(FunctionalRequirement_2006, RequirementPackage.eINSTANCE.getFunctionalRequirement());

			elements.put(Feature_2012, FeaturePackage.eINSTANCE.getFeature());

			elements.put(Service_2007, ServicePackage.eINSTANCE.getService());

			elements.put(NonFunctionalRequirement_2008, RequirementPackage.eINSTANCE.getNonFunctionalRequirement());

			elements.put(Danger_2009, DangerPackage.eINSTANCE.getDanger());

			elements.put(Actor_2010, UsecasePackage.eINSTANCE.getActor());

			elements.put(ProceduralMitigation_2011, DangerPackage.eINSTANCE.getProceduralMitigation());

			elements.put(VariationPoint_2013, FeaturePackage.eINSTANCE.getVariationPoint());

			elements.put(VariationPointInstance_2014, FeaturePackage.eINSTANCE.getVariationPointInstance());

			elements.put(Product_2015, FeaturePackage.eINSTANCE.getProduct());

			elements.put(StakeholderGoals_4008, UrmlPackage.eINSTANCE.getStakeholder_Goals());

			elements.put(AbstractFeatureSubFeatures_4034, FeaturePackage.eINSTANCE.getAbstractFeature_SubFeatures());

			elements.put(AbstractFeatureDetailingFunctionalRequirements_4035, FeaturePackage.eINSTANCE
				.getAbstractFeature_DetailingFunctionalRequirements());

			elements.put(AbstractFeatureConstrainingNonFunctionalRequirements_4036, FeaturePackage.eINSTANCE
				.getAbstractFeature_ConstrainingNonFunctionalRequirements());

			elements.put(AbstractFeatureRequieredFeatures_4037, FeaturePackage.eINSTANCE
				.getAbstractFeature_RequieredFeatures());

			elements.put(AbstractFeatureExcludedFeatures_4038, FeaturePackage.eINSTANCE
				.getAbstractFeature_ExcludedFeatures());

			elements.put(GoalRealizedFeatures_4004, GoalPackage.eINSTANCE.getGoal_RealizedFeatures());

			elements.put(GoalSubGoals_4018, GoalPackage.eINSTANCE.getGoal_SubGoals());

			elements.put(GoalReference_4016, GoalPackage.eINSTANCE.getGoalReference());

			elements.put(GoalReference_4023, GoalPackage.eINSTANCE.getGoalReference());

			elements.put(GoalReference_4024, GoalPackage.eINSTANCE.getGoalReference());

			elements.put(GoalReference_4025, GoalPackage.eINSTANCE.getGoalReference());

			elements.put(RequirementImplementingServices_4005, RequirementPackage.eINSTANCE
				.getRequirement_ImplementingServices());

			elements.put(NonFunctionalRequirementSubNonFunctionalRequirements_4043, RequirementPackage.eINSTANCE
				.getNonFunctionalRequirement_SubNonFunctionalRequirements());

			elements.put(FunctionalRequirementSubFunctionalRequirements_4044, RequirementPackage.eINSTANCE
				.getFunctionalRequirement_SubFunctionalRequirements());

			elements.put(MitigationMitigatedDangers_4012, DangerPackage.eINSTANCE.getMitigation_MitigatedDangers());

			elements.put(DangerHarmedAssets_4013, DangerPackage.eINSTANCE.getDanger_HarmedAssets());

			elements.put(AssetTriggeredDangers_4017, DangerPackage.eINSTANCE.getAsset_TriggeredDangers());

			elements.put(ServiceSubServices_4022, ServicePackage.eINSTANCE.getService_SubServices());

			elements.put(VariationPointVariety_4042, FeaturePackage.eINSTANCE.getVariationPoint_Variety());

			elements.put(VariationPointInstanceVariationPoint_4033, FeaturePackage.eINSTANCE
				.getVariationPointInstance_VariationPoint());

			elements.put(VariationPointInstanceSelectedFeatures_4040, FeaturePackage.eINSTANCE
				.getVariationPointInstance_SelectedFeatures());

			elements.put(ProductVariationPointInstances_4032, FeaturePackage.eINSTANCE
				.getProduct_VariationPointInstances());
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
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(URMLDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Stakeholder_2002);
			KNOWN_ELEMENT_TYPES.add(Goal_2001);
			KNOWN_ELEMENT_TYPES.add(FunctionalRequirement_2006);
			KNOWN_ELEMENT_TYPES.add(Feature_2012);
			KNOWN_ELEMENT_TYPES.add(Service_2007);
			KNOWN_ELEMENT_TYPES.add(NonFunctionalRequirement_2008);
			KNOWN_ELEMENT_TYPES.add(Danger_2009);
			KNOWN_ELEMENT_TYPES.add(Actor_2010);
			KNOWN_ELEMENT_TYPES.add(ProceduralMitigation_2011);
			KNOWN_ELEMENT_TYPES.add(VariationPoint_2013);
			KNOWN_ELEMENT_TYPES.add(VariationPointInstance_2014);
			KNOWN_ELEMENT_TYPES.add(Product_2015);
			KNOWN_ELEMENT_TYPES.add(StakeholderGoals_4008);
			KNOWN_ELEMENT_TYPES.add(AbstractFeatureSubFeatures_4034);
			KNOWN_ELEMENT_TYPES.add(AbstractFeatureDetailingFunctionalRequirements_4035);
			KNOWN_ELEMENT_TYPES.add(AbstractFeatureConstrainingNonFunctionalRequirements_4036);
			KNOWN_ELEMENT_TYPES.add(AbstractFeatureRequieredFeatures_4037);
			KNOWN_ELEMENT_TYPES.add(AbstractFeatureExcludedFeatures_4038);
			KNOWN_ELEMENT_TYPES.add(GoalRealizedFeatures_4004);
			KNOWN_ELEMENT_TYPES.add(GoalSubGoals_4018);
			KNOWN_ELEMENT_TYPES.add(GoalReference_4016);
			KNOWN_ELEMENT_TYPES.add(GoalReference_4023);
			KNOWN_ELEMENT_TYPES.add(GoalReference_4024);
			KNOWN_ELEMENT_TYPES.add(GoalReference_4025);
			KNOWN_ELEMENT_TYPES.add(RequirementImplementingServices_4005);
			KNOWN_ELEMENT_TYPES.add(NonFunctionalRequirementSubNonFunctionalRequirements_4043);
			KNOWN_ELEMENT_TYPES.add(FunctionalRequirementSubFunctionalRequirements_4044);
			KNOWN_ELEMENT_TYPES.add(MitigationMitigatedDangers_4012);
			KNOWN_ELEMENT_TYPES.add(DangerHarmedAssets_4013);
			KNOWN_ELEMENT_TYPES.add(AssetTriggeredDangers_4017);
			KNOWN_ELEMENT_TYPES.add(ServiceSubServices_4022);
			KNOWN_ELEMENT_TYPES.add(VariationPointVariety_4042);
			KNOWN_ELEMENT_TYPES.add(VariationPointInstanceVariationPoint_4033);
			KNOWN_ELEMENT_TYPES.add(VariationPointInstanceSelectedFeatures_4040);
			KNOWN_ELEMENT_TYPES.add(ProductVariationPointInstances_4032);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case URMLDiagramEditPart.VISUAL_ID:
			return URMLDiagram_1000;
		case StakeholderEditPart.VISUAL_ID:
			return Stakeholder_2002;
		case GoalEditPart.VISUAL_ID:
			return Goal_2001;
		case FunctionalRequirementEditPart.VISUAL_ID:
			return FunctionalRequirement_2006;
		case FeatureEditPart.VISUAL_ID:
			return Feature_2012;
		case ServiceEditPart.VISUAL_ID:
			return Service_2007;
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return NonFunctionalRequirement_2008;
		case DangerEditPart.VISUAL_ID:
			return Danger_2009;
		case ActorEditPart.VISUAL_ID:
			return Actor_2010;
		case ProceduralMitigationEditPart.VISUAL_ID:
			return ProceduralMitigation_2011;
		case VariationPointEditPart.VISUAL_ID:
			return VariationPoint_2013;
		case VariationPointInstanceEditPart.VISUAL_ID:
			return VariationPointInstance_2014;
		case ProductEditPart.VISUAL_ID:
			return Product_2015;
		case StakeholderGoalsEditPart.VISUAL_ID:
			return StakeholderGoals_4008;
		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
			return AbstractFeatureSubFeatures_4034;
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return AbstractFeatureDetailingFunctionalRequirements_4035;
		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return AbstractFeatureConstrainingNonFunctionalRequirements_4036;
		case AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID:
			return AbstractFeatureRequieredFeatures_4037;
		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
			return AbstractFeatureExcludedFeatures_4038;
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return GoalRealizedFeatures_4004;
		case GoalSubGoalsEditPart.VISUAL_ID:
			return GoalSubGoals_4018;
		case GoalReferenceEditPart.VISUAL_ID:
			return GoalReference_4016;
		case GoalReference2EditPart.VISUAL_ID:
			return GoalReference_4023;
		case GoalReference3EditPart.VISUAL_ID:
			return GoalReference_4024;
		case GoalReference4EditPart.VISUAL_ID:
			return GoalReference_4025;
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return RequirementImplementingServices_4005;
		case NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID:
			return NonFunctionalRequirementSubNonFunctionalRequirements_4043;
		case FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID:
			return FunctionalRequirementSubFunctionalRequirements_4044;
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return MitigationMitigatedDangers_4012;
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return DangerHarmedAssets_4013;
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			return AssetTriggeredDangers_4017;
		case ServiceSubServicesEditPart.VISUAL_ID:
			return ServiceSubServices_4022;
		case VariationPointVarietyEditPart.VISUAL_ID:
			return VariationPointVariety_4042;
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			return VariationPointInstanceVariationPoint_4033;
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			return VariationPointInstanceSelectedFeatures_4040;
		case ProductVariationPointInstancesEditPart.VISUAL_ID:
			return ProductVariationPointInstances_4032;
		}
		return null;
	}

}
