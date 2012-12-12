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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;

/**
 * This is the item provider adapter for a {@link scrm.requirements.SoftwareInterface} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SoftwareInterfaceItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInterfaceItemProvider(AdapterFactory adapterFactory) {
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

			addContainingRequirementSpacePropertyDescriptor(object);
			addProvidingFeaturePropertyDescriptor(object);
			addRequiringFeaturesPropertyDescriptor(object);
			addProvidingDataPropertyDescriptor(object);
			addRequiringDataPropertyDescriptor(object);
			addDetailsOfProvidingFunctionsAndPropertiesPropertyDescriptor(object);
			addDetailsOfRequiringFunctionsAndPropertiesPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Containing Requirement Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainingRequirementSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_IRequirement_containingRequirementSpace_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_IRequirement_containingRequirementSpace_feature",
								"_UI_IRequirement_type"),
						RequirementsPackage.Literals.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Providing Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidingFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Interface_providingFeature_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Interface_providingFeature_feature",
						"_UI_Interface_type"),
				RequirementsPackage.Literals.INTERFACE__PROVIDING_FEATURE,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Requiring Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Interface_requiringFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Interface_requiringFeatures_feature",
						"_UI_Interface_type"),
				RequirementsPackage.Literals.INTERFACE__REQUIRING_FEATURES,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Providing Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidingDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Interface_providingData_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Interface_providingData_feature",
						"_UI_Interface_type"),
				RequirementsPackage.Literals.INTERFACE__PROVIDING_DATA, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Requiring Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiringDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Interface_requiringData_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Interface_requiringData_feature",
						"_UI_Interface_type"),
				RequirementsPackage.Literals.INTERFACE__REQUIRING_DATA, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Details Of Providing Functions And Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDetailsOfProvidingFunctionsAndPropertiesPropertyDescriptor(
			Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Interface_detailsOfProvidingFunctionsAndProperties_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_Interface_detailsOfProvidingFunctionsAndProperties_feature",
								"_UI_Interface_type"),
						RequirementsPackage.Literals.INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Details Of Requiring Functions And Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDetailsOfRequiringFunctionsAndPropertiesPropertyDescriptor(
			Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Interface_detailsOfRequiringFunctionsAndProperties_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_Interface_detailsOfRequiringFunctionsAndProperties_feature",
								"_UI_Interface_type"),
						RequirementsPackage.Literals.INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SoftwareInterface_version_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SoftwareInterface_version_feature",
						"_UI_SoftwareInterface_type"),
				RequirementsPackage.Literals.SOFTWARE_INTERFACE__VERSION, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This returns SoftwareInterface.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/SoftwareInterface"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: return name attribute without EClass-name
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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

		switch (notification.getFeatureID(SoftwareInterface.class)) {
		case RequirementsPackage.SOFTWARE_INTERFACE__VERSION:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
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
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
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
