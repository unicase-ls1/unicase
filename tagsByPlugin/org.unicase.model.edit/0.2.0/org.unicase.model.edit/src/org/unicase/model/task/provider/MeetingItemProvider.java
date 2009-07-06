/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.provider;

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
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.provider.ModelElementItemProvider;
import org.unicase.model.task.Meeting;
import org.unicase.model.task.TaskPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.task.Meeting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MeetingItemProvider extends ModelElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeetingItemProvider(AdapterFactory adapterFactory) {
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

			addLocationPropertyDescriptor(object);
			addTimePropertyDescriptor(object);
			addPurposePropertyDescriptor(object);
			addFacilitatorPropertyDescriptor(object);
			addScribePropertyDescriptor(object);
			addParticipantsPropertyDescriptor(object);
			addInformationExchangePropertyDescriptor(object);
			addDiscussedActionItemsPropertyDescriptor(object);
			addDiscussedIssuesPropertyDescriptor(object);
			addIdentifiedActionItemsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_location_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_location_feature", "_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__LOCATION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_time_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_time_feature", "_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__TIME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Purpose feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPurposePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_purpose_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_purpose_feature", "_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__PURPOSE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Facilitator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacilitatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_facilitator_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_facilitator_feature", "_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__FACILITATOR, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Scribe feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScribePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_scribe_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_scribe_feature", "_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__SCRIBE, true, false, true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Participants feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(), getResourceLocator(),
						getString("_UI_Meeting_participants_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_Meeting_participants_feature",
								"_UI_Meeting_type"),
						TaskPackage.Literals.MEETING__PARTICIPANTS, true,
						false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Information Exchange feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInformationExchangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_informationExchange_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Meeting_informationExchange_feature",
						"_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__INFORMATION_EXCHANGE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Discussed Action Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiscussedActionItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_discussedActionItems_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Meeting_discussedActionItems_feature",
						"_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__DISCUSSED_ACTION_ITEMS, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Discussed Issues feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiscussedIssuesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_discussedIssues_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_Meeting_discussedIssues_feature",
						"_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__DISCUSSED_ISSUES, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Identified Action Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifiedActionItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Meeting_identifiedActionItems_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Meeting_identifiedActionItems_feature",
						"_UI_Meeting_type"),
				TaskPackage.Literals.MEETING__IDENTIFIED_ACTION_ITEMS, true,
				false, true, null, null, null));
	}

	/**
	 * This returns Meeting.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/Meeting"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Meeting) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Meeting_type")
				: getString("_UI_Meeting_type") + " " + label;
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

		switch (notification.getFeatureID(Meeting.class)) {
		case TaskPackage.MEETING__LOCATION:
		case TaskPackage.MEETING__TIME:
		case TaskPackage.MEETING__PURPOSE:
		case TaskPackage.MEETING__INFORMATION_EXCHANGE:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
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
		return ModelEditPlugin.INSTANCE;
	}

}
