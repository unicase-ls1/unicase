/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.unicase.model.urml.feature.FeatureFactory;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.VariationPoint;

/**
 * This is the item provider adapter for a {@link org.unicase.model.urml.feature.VariationPoint} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class VariationPointItemProvider extends AbstractFeatureItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPointItemProvider(AdapterFactory adapterFactory) {
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

			addOptionalSubFeaturesPropertyDescriptor(object);
			addMultiplicityPropertyDescriptor(object);
			addInstancesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Optional Sub Features feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addOptionalSubFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_VariationPoint_optionalSubFeatures_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_VariationPoint_optionalSubFeatures_feature",
				"_UI_VariationPoint_type"), FeaturePackage.Literals.VARIATION_POINT__OPTIONAL_SUB_FEATURES, true,
			false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Multiplicity feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_VariationPoint_multiplicity_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_VariationPoint_multiplicity_feature",
				"_UI_VariationPoint_type"), FeaturePackage.Literals.VARIATION_POINT__MULTIPLICITY, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Instances feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInstancesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_VariationPoint_instances_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_VariationPoint_instances_feature",
				"_UI_VariationPoint_type"), FeaturePackage.Literals.VARIATION_POINT__INSTANCES, true, false, true,
			null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FeaturePackage.Literals.VARIATION_POINT__OPTIONAL_SUB_FEATURES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns VariationPoint.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VariationPoint"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VariationPoint) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_VariationPoint_type")
			: getString("_UI_VariationPoint_type") + " " + label;
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

		switch (notification.getFeatureID(VariationPoint.class)) {
		case FeaturePackage.VARIATION_POINT__MULTIPLICITY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
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

		newChildDescriptors.add(createChildParameter(FeaturePackage.Literals.VARIATION_POINT__OPTIONAL_SUB_FEATURES,
			FeatureFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add(createChildParameter(FeaturePackage.Literals.VARIATION_POINT__OPTIONAL_SUB_FEATURES,
			FeatureFactory.eINSTANCE.createVariationPoint()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == FeaturePackage.Literals.ABSTRACT_FEATURE__SUB_FEATURES
			|| childFeature == FeaturePackage.Literals.VARIATION_POINT__OPTIONAL_SUB_FEATURES;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
