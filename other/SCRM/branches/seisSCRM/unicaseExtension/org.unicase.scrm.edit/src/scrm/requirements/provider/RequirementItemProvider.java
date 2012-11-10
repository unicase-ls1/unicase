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
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessFactory;

/**
 * This is the item provider adapter for a {@link scrm.requirements.Requirement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementItemProvider(AdapterFactory adapterFactory) {
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

			addRefinementsPropertyDescriptor(object);
			addRefinedRequirementPropertyDescriptor(object);
			addSpecifiedFeaturePropertyDescriptor(object);
			addHandlingDataPropertyDescriptor(object);
			addRealizedMethodPropertyDescriptor(object);
			addProvidedInterfacePropertyDescriptor(object);
			addRequiredInterfacePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Refinements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_refinements_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_refinements_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Refined Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinedRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_refinedRequirement_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_refinedRequirement_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REFINED_REQUIREMENT,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Specified Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecifiedFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_specifiedFeature_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_specifiedFeature_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__SPECIFIED_FEATURE,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Handling Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHandlingDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_handlingData_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_handlingData_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__HANDLING_DATA, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Realized Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizedMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_realizedMethod_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_realizedMethod_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REALIZED_METHOD,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Provided Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_providedInterface_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_providedInterface_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__PROVIDED_INTERFACE,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Required Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_requiredInterface_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_requiredInterface_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REQUIRED_INTERFACE,
				true, false, true, null, null, null));
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
					.add(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS);
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
	 * This returns Requirement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/Requirement"));
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

		switch (notification.getFeatureID(Requirement.class)) {
		case RequirementsPackage.REQUIREMENT__REFINEMENTS:
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
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createSolver()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createMeshCreation()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createPreProcessing()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createPostProcessing()));
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
