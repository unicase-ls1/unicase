/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.provider;


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

import org.unicase.model.LeafSection;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.organization.OrganizationFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.LeafSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LeafSectionItemProvider
	extends ModelElementItemProvider
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
	public LeafSectionItemProvider(AdapterFactory adapterFactory) {
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

			addElementClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Element Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LeafSection_elementClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LeafSection_elementClass_feature", "_UI_LeafSection_type"),
				 ModelPackage.Literals.LEAF_SECTION__ELEMENT_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS);
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
	 * This returns LeafSection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LeafSection"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LeafSection)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LeafSection_type") :
			getString("_UI_LeafSection_type") + " " + label;
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

		switch (notification.getFeatureID(LeafSection.class)) {
			case ModelPackage.LEAF_SECTION__ELEMENT_CLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.LEAF_SECTION__MODEL_ELEMENTS:
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
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 ModelFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 ModelFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 ModelFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 OrganizationFactory.eINSTANCE.createOrgUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.LEAF_SECTION__MODEL_ELEMENTS,
				 DiagramFactory.eINSTANCE.createDiagram()));
	}


}
