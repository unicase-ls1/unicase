/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.knowledge.KnowledgeFactory;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.MathematicalModel;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;

import scrm.requirements.RequirementsFactory;

import scrm.requirements.dataProcessing.DataProcessingFactory;

/**
 * This is the item provider adapter for a {@link scrm.knowledge.MathematicalModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MathematicalModelItemProvider
	extends SCRMModelElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNumericalMethodsPropertyDescriptor(object);
			addTheoryPropertyDescriptor(object);
			addMathematicalExpressionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Numerical Methods feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumericalMethodsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MathematicalModel_numericalMethods_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MathematicalModel_numericalMethods_feature", "_UI_MathematicalModel_type"),
				 KnowledgePackage.Literals.MATHEMATICAL_MODEL__NUMERICAL_METHODS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Theory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTheoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MathematicalModel_theory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MathematicalModel_theory_feature", "_UI_MathematicalModel_type"),
				 KnowledgePackage.Literals.MATHEMATICAL_MODEL__THEORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mathematical Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMathematicalExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MathematicalModel_mathematicalExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MathematicalModel_mathematicalExpression_feature", "_UI_MathematicalModel_type"),
				 KnowledgePackage.Literals.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS);
			childrenFeatures.add(KnowledgePackage.Literals.MATHEMATICAL_MODEL__REFINEMENTS);
			childrenFeatures.add(KnowledgePackage.Literals.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS);
			childrenFeatures.add(KnowledgePackage.Literals.MATHEMATICAL_MODEL__DEPENDENCIES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MathematicalModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MathematicalModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MathematicalModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MathematicalModel_type") :
			getString("_UI_MathematicalModel_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MathematicalModel.class)) {
			case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
			case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
			case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createHardware()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createDataFlow()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createDataDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.MATHEMATICAL_MODEL__REFINEMENTS,
				 KnowledgeFactory.eINSTANCE.createMathematicalModel()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS,
				 KnowledgeFactory.eINSTANCE.createMathematicalModel()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.MATHEMATICAL_MODEL__DEPENDENCIES,
				 KnowledgeFactory.eINSTANCE.createAssumption()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == KnowledgePackage.Literals.MATHEMATICAL_MODEL__REFINEMENTS ||
			childFeature == KnowledgePackage.Literals.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ScrmEditPlugin.INSTANCE;
	}

}
