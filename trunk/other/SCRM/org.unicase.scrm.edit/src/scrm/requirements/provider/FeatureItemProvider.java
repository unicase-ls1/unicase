/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.provider;


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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.ScrmPackage;

import scrm.provider.ScrmEditPlugin;

import scrm.requirements.Feature;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;

import scrm.requirements.dataProcessing.DataProcessingFactory;

/**
 * This is the item provider adapter for a {@link scrm.requirements.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider
	extends ItemProviderAdapter
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
	public FeatureItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addIdentifierPropertyDescriptor(object);
			addUsedKnowledgePropertyDescriptor(object);
			addRequiredFeaturesPropertyDescriptor(object);
			addRequiringFeaturesPropertyDescriptor(object);
			addExcludedFeaturesPropertyDescriptor(object);
			addExcludingFeaturesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SCRMModelElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SCRMModelElement_name_feature", "_UI_SCRMModelElement_type"),
				 ScrmPackage.Literals.SCRM_MODEL_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SCRMModelElement_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SCRMModelElement_description_feature", "_UI_SCRMModelElement_type"),
				 ScrmPackage.Literals.SCRM_MODEL_ELEMENT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SCRMModelElement_identifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SCRMModelElement_identifier_feature", "_UI_SCRMModelElement_type"),
				 ScrmPackage.Literals.SCRM_MODEL_ELEMENT__IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Used Knowledge feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsedKnowledgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IRequirement_usedKnowledge_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IRequirement_usedKnowledge_feature", "_UI_IRequirement_type"),
				 RequirementsPackage.Literals.IREQUIREMENT__USED_KNOWLEDGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_requiredFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_requiredFeatures_feature", "_UI_Feature_type"),
				 RequirementsPackage.Literals.FEATURE__REQUIRED_FEATURES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requiring Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_requiringFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_requiringFeatures_feature", "_UI_Feature_type"),
				 RequirementsPackage.Literals.FEATURE__REQUIRING_FEATURES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Excluded Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludedFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_excludedFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_excludedFeatures_feature", "_UI_Feature_type"),
				 RequirementsPackage.Literals.FEATURE__EXCLUDED_FEATURES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Excluding Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludingFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_excludingFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_excludingFeatures_feature", "_UI_Feature_type"),
				 RequirementsPackage.Literals.FEATURE__EXCLUDING_FEATURES,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__CONSTRAINTS);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__DEPENDENCIES);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__REQUIRED_USER_INTERFACE);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__PROVIDED_USER_INTERFACES);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__REQUIRED_SOFTWARE_INTERFACE);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__PROVIDED_SOFTWARE_INTERFACES);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS);
			childrenFeatures.add(RequirementsPackage.Literals.FEATURE__SUB_FEATURES);
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
	 * This returns Feature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Feature"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Feature)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Feature_type") :
			getString("_UI_Feature_type") + " " + label;
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

		switch (notification.getFeatureID(Feature.class)) {
			case RequirementsPackage.FEATURE__NAME:
			case RequirementsPackage.FEATURE__DESCRIPTION:
			case RequirementsPackage.FEATURE__IDENTIFIER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RequirementsPackage.FEATURE__CONSTRAINTS:
			case RequirementsPackage.FEATURE__DEPENDENCIES:
			case RequirementsPackage.FEATURE__REQUIRED_USER_INTERFACE:
			case RequirementsPackage.FEATURE__PROVIDED_USER_INTERFACES:
			case RequirementsPackage.FEATURE__REQUIRED_SOFTWARE_INTERFACE:
			case RequirementsPackage.FEATURE__PROVIDED_SOFTWARE_INTERFACES:
			case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
			case RequirementsPackage.FEATURE__SUB_FEATURES:
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
				(RequirementsPackage.Literals.FEATURE__CONSTRAINTS,
				 RequirementsFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DEPENDENCIES,
				 RequirementsFactory.eINSTANCE.createHardware()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__REQUIRED_USER_INTERFACE,
				 RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__PROVIDED_USER_INTERFACES,
				 RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__REQUIRED_SOFTWARE_INTERFACE,
				 RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__PROVIDED_SOFTWARE_INTERFACES,
				 RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.FEATURE__SUB_FEATURES,
				 RequirementsFactory.eINSTANCE.createFeature()));
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
			childFeature == RequirementsPackage.Literals.FEATURE__REQUIRED_USER_INTERFACE ||
			childFeature == RequirementsPackage.Literals.FEATURE__PROVIDED_USER_INTERFACES ||
			childFeature == RequirementsPackage.Literals.FEATURE__REQUIRED_SOFTWARE_INTERFACE ||
			childFeature == RequirementsPackage.Literals.FEATURE__PROVIDED_SOFTWARE_INTERFACES;

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
