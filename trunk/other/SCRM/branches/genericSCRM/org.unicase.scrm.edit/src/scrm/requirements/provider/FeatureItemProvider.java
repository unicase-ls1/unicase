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
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;
import scrm.requirements.Feature;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessFactory;

/**
 * This is the item provider adapter for a {@link scrm.requirements.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider extends SCRMModelElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
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

			addContainingRequirementSpacePropertyDescriptor(object);
			addDetailedRequirementsPropertyDescriptor(object);
			addSubFeaturesPropertyDescriptor(object);
			addConstraintsPropertyDescriptor(object);
			addDependenciesPropertyDescriptor(object);
			addRequiredInterfacesPropertyDescriptor(object);
			addProvidedInterfacesPropertyDescriptor(object);
			addInfluencingProblemPropertyDescriptor(object);
			addRequiredFeaturesPropertyDescriptor(object);
			addRequiringFeaturesPropertyDescriptor(object);
			addExcludedFeaturesPropertyDescriptor(object);
			addExcludingFeaturesPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Detailed Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDetailedRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_detailedRequirements_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_detailedRequirements_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sub Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_subFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_subFeatures_feature", "_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__SUB_FEATURES, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Constraints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_constraints_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_constraints_feature", "_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__CONSTRAINTS, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Feature_dependencies_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_Feature_dependencies_feature",
								"_UI_Feature_type"),
						RequirementsPackage.Literals.FEATURE__DEPENDENCIES,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Required Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_requiredInterfaces_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_requiredInterfaces_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__REQUIRED_INTERFACES,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Provided Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_providedInterfaces_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_providedInterfaces_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__PROVIDED_INTERFACES,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Influencing Problem feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInfluencingProblemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_influencingProblem_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_influencingProblem_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__INFLUENCING_PROBLEM,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Required Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_requiredFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_requiredFeatures_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__REQUIRED_FEATURES, true,
				false, true, null, null, null));
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
				getString("_UI_Feature_requiringFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_requiringFeatures_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__REQUIRING_FEATURES, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Excluded Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludedFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_excludedFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_excludedFeatures_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__EXCLUDED_FEATURES, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Excluding Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludingFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feature_excludingFeatures_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Feature_excludingFeatures_feature",
						"_UI_Feature_type"),
				RequirementsPackage.Literals.FEATURE__EXCLUDING_FEATURES, true,
				false, true, null, null, null));
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS);
			childrenFeatures
					.add(RequirementsPackage.Literals.FEATURE__SUB_FEATURES);
			childrenFeatures
					.add(RequirementsPackage.Literals.FEATURE__PROVIDED_INTERFACES);
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
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/Feature"));
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

		switch (notification.getFeatureID(Feature.class)) {
		case RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS:
		case RequirementsPackage.FEATURE__SUB_FEATURES:
		case RequirementsPackage.FEATURE__PROVIDED_INTERFACES:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__DETAILED_REQUIREMENTS,
				DataProcessFactory.eINSTANCE.createDataProcessSpace()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__SUB_FEATURES,
				RequirementsFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__PROVIDED_INTERFACES,
				RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.FEATURE__PROVIDED_INTERFACES,
				RequirementsFactory.eINSTANCE.createSoftwareInterface()));
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
