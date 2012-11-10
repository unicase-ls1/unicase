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

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.UserInterface;

/**
 * This is the item provider adapter for a {@link scrm.requirements.UserInterface} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UserInterfaceItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInterfaceItemProvider(AdapterFactory adapterFactory) {
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

			addProvidingFeaturesPropertyDescriptor(object);
			addRequiringFeaturesPropertyDescriptor(object);
			addProvidingDataPropertyDescriptor(object);
			addRequiringDataPropertyDescriptor(object);
			addDetailsOfProvidingFunctionsAndPropertiesPropertyDescriptor(object);
			addDetailsOfRequiringFunctionsAndPropertiesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Providing Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidingFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Interface_providingFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Interface_providingFeatures_feature",
						"_UI_Interface_type"),
				RequirementsPackage.Literals.INTERFACE__PROVIDING_FEATURES,
				true, false, true, null, null, null));
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
	 * This returns UserInterface.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/UserInterface"));
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
