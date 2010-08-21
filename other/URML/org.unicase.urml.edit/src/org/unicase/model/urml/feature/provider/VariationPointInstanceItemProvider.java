/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.provider;

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
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.urml.provider.UrmlEditPlugin;
import org.unicase.model.urml.provider.UrmlModelElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.urml.feature.VariationPointInstance} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class VariationPointInstanceItemProvider extends UrmlModelElementItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPointInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addVariationPointPropertyDescriptor(object);
			addProductsPropertyDescriptor(object);
			addSelectedFeaturesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Variation Point feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVariationPointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_VariationPointInstance_variationPoint_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_VariationPointInstance_variationPoint_feature",
				"_UI_VariationPointInstance_type"), FeaturePackage.Literals.VARIATION_POINT_INSTANCE__VARIATION_POINT,
			true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Products feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProductsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_VariationPointInstance_products_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_VariationPointInstance_products_feature",
				"_UI_VariationPointInstance_type"), FeaturePackage.Literals.VARIATION_POINT_INSTANCE__PRODUCTS, true,
			false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Selected Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSelectedFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_VariationPointInstance_selectedFeatures_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_VariationPointInstance_selectedFeatures_feature",
				"_UI_VariationPointInstance_type"),
			FeaturePackage.Literals.VARIATION_POINT_INSTANCE__SELECTED_FEATURES, true, false, true, null, null, null));
	}

	/**
	 * This returns VariationPointInstance.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VariationPointInstance"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VariationPointInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_VariationPointInstance_type")
			: getString("_UI_VariationPointInstance_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UrmlEditPlugin.INSTANCE;
	}

}
