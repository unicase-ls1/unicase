/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.provider;

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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.FeatureFactory;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.provider.UrmlEditPlugin;
import org.unicase.model.urml.provider.UrmlModelElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.urml.feature.AbstractFeature} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractFeatureItemProvider extends UrmlModelElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractFeatureItemProvider(AdapterFactory adapterFactory) {
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

			addGoalsPropertyDescriptor(object);
			addDetailingFunctionalRequirementsPropertyDescriptor(object);
			addConstrainingNonFunctionalRequirementsPropertyDescriptor(object);
			addDetailingUseCasesPropertyDescriptor(object);
			addExcludingFeaturesPropertyDescriptor(object);
			addExcludedFeaturesPropertyDescriptor(object);
			addRequiringFeaturesPropertyDescriptor(object);
			addRequiredFeaturesPropertyDescriptor(object);
			addVariationPointInstancesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Goals feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGoalsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_goals_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_AbstractFeature_goals_feature", "_UI_AbstractFeature_type"),
			FeaturePackage.Literals.ABSTRACT_FEATURE__GOALS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Detailing Functional Requirements feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDetailingFunctionalRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_AbstractFeature_detailingFunctionalRequirements_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_AbstractFeature_detailingFunctionalRequirements_feature",
				"_UI_AbstractFeature_type"),
			FeaturePackage.Literals.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS, true, false, true, null, null,
			null));
	}

	/**
	 * This adds a property descriptor for the Constraining Non Functional Requirements feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConstrainingNonFunctionalRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_AbstractFeature_constrainingNonFunctionalRequirements_feature"), getString(
				"_UI_PropertyDescriptor_description",
				"_UI_AbstractFeature_constrainingNonFunctionalRequirements_feature", "_UI_AbstractFeature_type"),
			FeaturePackage.Literals.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS, true, false, true,
			null, null, null));
	}

	/**
	 * This adds a property descriptor for the Detailing Use Cases feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addDetailingUseCasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_detailingUseCases_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractFeature_detailingUseCases_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__DETAILING_USE_CASES, true,
			false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Excluding Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExcludingFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_excludingFeatures_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractFeature_excludingFeatures_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__EXCLUDING_FEATURES, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Excluded Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExcludedFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_excludedFeatures_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractFeature_excludedFeatures_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__EXCLUDED_FEATURES, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Requiring Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRequiringFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_requiringFeatures_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractFeature_requiringFeatures_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__REQUIRING_FEATURES, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Required Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRequiredFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractFeature_requiredFeatures_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractFeature_requiredFeatures_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__REQUIRED_FEATURES, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Variation Point Instances feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVariationPointInstancesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_AbstractFeature_variationPointInstances_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_AbstractFeature_variationPointInstances_feature",
				"_UI_AbstractFeature_type"), FeaturePackage.Literals.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES, true,
			false, true, null, null, null));
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
			childrenFeatures.add(FeaturePackage.Literals.ABSTRACT_FEATURE__SUB_FEATURES);
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
	 * This returns AbstractFeature.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractFeature"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractFeature) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_AbstractFeature_type")
			: getString("_UI_AbstractFeature_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractFeature.class)) {
		case FeaturePackage.ABSTRACT_FEATURE__SUB_FEATURES:
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

		newChildDescriptors.add(createChildParameter(FeaturePackage.Literals.ABSTRACT_FEATURE__SUB_FEATURES,
			FeatureFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add(createChildParameter(FeaturePackage.Literals.ABSTRACT_FEATURE__SUB_FEATURES,
			FeatureFactory.eINSTANCE.createVariationPoint()));
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
