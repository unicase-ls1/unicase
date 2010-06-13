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
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;

import urml.danger.DangerPackage;
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
	public static final IElementType Feature_2005 = getElementType("org.unicase.urml.ui.diagram.Feature_2005"); //$NON-NLS-1$

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
	public static final IElementType Stakeholder_4001 = getElementType("org.unicase.urml.ui.diagram.Stakeholder_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FeatureParentFeature_4002 = getElementType("org.unicase.urml.ui.diagram.FeatureParentFeature_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StakeholderGoals_4003 = getElementType("org.unicase.urml.ui.diagram.StakeholderGoals_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType GoalRealizedFeatures_4004 = getElementType("org.unicase.urml.ui.diagram.GoalRealizedFeatures_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequirementImplementingServices_4005 = getElementType("org.unicase.urml.ui.diagram.RequirementImplementingServices_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FeatureDetailingFunctionalRequirements_4006 = getElementType("org.unicase.urml.ui.diagram.FeatureDetailingFunctionalRequirements_4006"); //$NON-NLS-1$

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

			elements.put(Feature_2005, UrmlPackage.eINSTANCE.getFeature());

			elements.put(Service_2007, ServicePackage.eINSTANCE.getService());

			elements.put(NonFunctionalRequirement_2008, RequirementPackage.eINSTANCE.getNonFunctionalRequirement());

			elements.put(Danger_2009, DangerPackage.eINSTANCE.getDanger());

			elements.put(Actor_2010, UsecasePackage.eINSTANCE.getActor());

			elements.put(Stakeholder_4001, UrmlPackage.eINSTANCE.getStakeholder());

			elements.put(FeatureParentFeature_4002, UrmlPackage.eINSTANCE.getFeature_ParentFeature());

			elements.put(StakeholderGoals_4003, UrmlPackage.eINSTANCE.getStakeholder_Goals());

			elements.put(GoalRealizedFeatures_4004, GoalPackage.eINSTANCE.getGoal_RealizedFeatures());

			elements.put(RequirementImplementingServices_4005, RequirementPackage.eINSTANCE
				.getRequirement_ImplementingServices());

			elements.put(FeatureDetailingFunctionalRequirements_4006, UrmlPackage.eINSTANCE
				.getFeature_DetailingFunctionalRequirements());
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
			KNOWN_ELEMENT_TYPES.add(Feature_2005);
			KNOWN_ELEMENT_TYPES.add(Service_2007);
			KNOWN_ELEMENT_TYPES.add(NonFunctionalRequirement_2008);
			KNOWN_ELEMENT_TYPES.add(Danger_2009);
			KNOWN_ELEMENT_TYPES.add(Actor_2010);
			KNOWN_ELEMENT_TYPES.add(Stakeholder_4001);
			KNOWN_ELEMENT_TYPES.add(FeatureParentFeature_4002);
			KNOWN_ELEMENT_TYPES.add(StakeholderGoals_4003);
			KNOWN_ELEMENT_TYPES.add(GoalRealizedFeatures_4004);
			KNOWN_ELEMENT_TYPES.add(RequirementImplementingServices_4005);
			KNOWN_ELEMENT_TYPES.add(FeatureDetailingFunctionalRequirements_4006);
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
			return Feature_2005;
		case ServiceEditPart.VISUAL_ID:
			return Service_2007;
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return NonFunctionalRequirement_2008;
		case DangerEditPart.VISUAL_ID:
			return Danger_2009;
		case ActorEditPart.VISUAL_ID:
			return Actor_2010;
		case Stakeholder2EditPart.VISUAL_ID:
			return Stakeholder_4001;
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return FeatureParentFeature_4002;
		case StakeholderGoalsEditPart.VISUAL_ID:
			return StakeholderGoals_4003;
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return GoalRealizedFeatures_4004;
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return RequirementImplementingServices_4005;
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return FeatureDetailingFunctionalRequirements_4006;
		}
		return null;
	}

}
