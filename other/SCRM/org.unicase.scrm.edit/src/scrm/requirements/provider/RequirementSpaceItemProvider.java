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

import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessFactory;

/**
 * This is the item provider adapter for a {@link scrm.requirements.RequirementSpace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementSpaceItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpaceItemProvider(AdapterFactory adapterFactory) {
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
			addContainedInformationofRequirementsPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Contained Informationof Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedInformationofRequirementsPropertyDescriptor(
			Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_RequirementSpace_containedInformationofRequirements_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_RequirementSpace_containedInformationofRequirements_feature",
								"_UI_RequirementSpace_type"),
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						true, false, false, null, null, null));
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
					.add(RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS);
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
	 * This returns RequirementSpace.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/RequirementSpace"));
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

		switch (notification.getFeatureID(RequirementSpace.class)) {
		case RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS:
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

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createRequirementSpace()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createFeature()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createHardware()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createConstraint()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createDataFlow()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						RequirementsFactory.eINSTANCE.createDataDefinition()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createProcess()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors
				.add(createChildParameter(
						RequirementsPackage.Literals.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
						DataProcessFactory.eINSTANCE.createDataProcessSpace()));
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
