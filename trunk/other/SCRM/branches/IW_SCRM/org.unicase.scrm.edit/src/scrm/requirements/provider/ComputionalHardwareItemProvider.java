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
import scrm.requirements.ComputionalHardware;
import scrm.requirements.RequirementsPackage;

/**
 * This is the item provider adapter for a {@link scrm.requirements.ComputionalHardware} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputionalHardwareItemProvider extends
		SCRMModelElementItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputionalHardwareItemProvider(AdapterFactory adapterFactory) {
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

			addDependingFeaturePropertyDescriptor(object);
			addProcessorPropertyDescriptor(object);
			addPlatformPropertyDescriptor(object);
			addMemoryPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Depending Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependingFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ComputionalHardware_dependingFeature_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ComputionalHardware_dependingFeature_feature",
								"_UI_ComputionalHardware_type"),
						RequirementsPackage.Literals.COMPUTIONAL_HARDWARE__DEPENDING_FEATURE,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Processor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ComputionalHardware_processor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputionalHardware_processor_feature",
						"_UI_ComputionalHardware_type"),
				RequirementsPackage.Literals.COMPUTIONAL_HARDWARE__PROCESSOR,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Platform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPlatformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ComputionalHardware_platform_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputionalHardware_platform_feature",
						"_UI_ComputionalHardware_type"),
				RequirementsPackage.Literals.COMPUTIONAL_HARDWARE__PLATFORM,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Memory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ComputionalHardware_memory_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputionalHardware_memory_feature",
						"_UI_ComputionalHardware_type"),
				RequirementsPackage.Literals.COMPUTIONAL_HARDWARE__MEMORY,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This returns ComputionalHardware.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ComputionalHardware"));
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

		switch (notification.getFeatureID(ComputionalHardware.class)) {
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PROCESSOR:
		case RequirementsPackage.COMPUTIONAL_HARDWARE__PLATFORM:
		case RequirementsPackage.COMPUTIONAL_HARDWARE__MEMORY:
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
