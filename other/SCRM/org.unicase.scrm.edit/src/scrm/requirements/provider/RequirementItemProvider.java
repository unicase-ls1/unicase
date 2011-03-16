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

import scrm.requirements.dataProcessing.DataProcessingFactory;

/**
 * This is the item provider adapter for a {@link scrm.requirements.Requirement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementItemProvider
	extends SCRMModelElementItemProvider
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

			addRealizedMethodPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Realized Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizedMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Requirement_realizedMethod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Requirement_realizedMethod_feature", "_UI_Requirement_type"),
				 RequirementsPackage.Literals.REQUIREMENT__REALIZED_METHOD,
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
			childrenFeatures.add(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS);
			childrenFeatures.add(RequirementsPackage.Literals.REQUIREMENT__DEFINING_DATA);
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
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Requirement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Requirement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Requirement_type") :
			getString("_UI_Requirement_type") + " " + label;
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
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
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
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 RequirementsFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 RequirementsFactory.eINSTANCE.createDataFlow()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 RequirementsFactory.eINSTANCE.createDataDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 DataProcessingFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 DataProcessingFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 DataProcessingFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 DataProcessingFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				 DataProcessingFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add
			(createChildParameter
				(RequirementsPackage.Literals.REQUIREMENT__DEFINING_DATA,
				 RequirementsFactory.eINSTANCE.createDataDefinition()));
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
			childFeature == RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS ||
			childFeature == RequirementsPackage.Literals.REQUIREMENT__DEFINING_DATA;

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
