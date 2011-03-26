/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.notification.provider;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.server.model.provider.EsmodelEditPlugin;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.provider.IdentifiableElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.notification.ESNotification} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ESNotificationItemProvider extends IdentifiableElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ESNotificationItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addMessagePropertyDescriptor(object);
			addDetailsPropertyDescriptor(object);
			addSeenPropertyDescriptor(object);
			addCreationDatePropertyDescriptor(object);
			addProviderPropertyDescriptor(object);
			addSenderPropertyDescriptor(object);
			addRecipientPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_name_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_name_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__NAME, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Sender feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSenderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_sender_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_sender_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__SENDER, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Recipient feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRecipientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_recipient_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_recipient_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__RECIPIENT, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Message feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_message_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_message_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__MESSAGE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Details feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDetailsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_details_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_details_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__DETAILS, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Seen feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSeenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_seen_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_seen_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__SEEN, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Creation Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCreationDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_creationDate_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_creationDate_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__CREATION_DATE, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Provider feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ESNotification_provider_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ESNotification_provider_feature",
				"_UI_ESNotification_type"), NotificationPackage.Literals.ES_NOTIFICATION__PROVIDER, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(NotificationPackage.Literals.ES_NOTIFICATION__PROJECT);
			childrenFeatures.add(NotificationPackage.Literals.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS);
			childrenFeatures.add(NotificationPackage.Literals.ES_NOTIFICATION__RELATED_OPERATIONS);
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
	 * This returns ESNotification.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ESNotification"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ESNotification) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ESNotification_type")
			: getString("_UI_ESNotification_type") + " " + label;
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

		switch (notification.getFeatureID(ESNotification.class)) {
		case NotificationPackage.ES_NOTIFICATION__NAME:
		case NotificationPackage.ES_NOTIFICATION__MESSAGE:
		case NotificationPackage.ES_NOTIFICATION__DETAILS:
		case NotificationPackage.ES_NOTIFICATION__SEEN:
		case NotificationPackage.ES_NOTIFICATION__CREATION_DATE:
		case NotificationPackage.ES_NOTIFICATION__PROVIDER:
		case NotificationPackage.ES_NOTIFICATION__SENDER:
		case NotificationPackage.ES_NOTIFICATION__RECIPIENT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case NotificationPackage.ES_NOTIFICATION__PROJECT:
		case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
		case NotificationPackage.ES_NOTIFICATION__RELATED_OPERATIONS:
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

		newChildDescriptors.add(createChildParameter(NotificationPackage.Literals.ES_NOTIFICATION__PROJECT,
			EsmodelFactory.eINSTANCE.createProjectId()));

		newChildDescriptors.add(createChildParameter(
			NotificationPackage.Literals.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS,
			MetamodelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add(createChildParameter(NotificationPackage.Literals.ES_NOTIFICATION__RELATED_OPERATIONS,
			OperationsFactory.eINSTANCE.createOperationId()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EsmodelEditPlugin.INSTANCE;
	}

}
