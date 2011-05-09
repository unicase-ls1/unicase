/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting.provider;


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
import org.unicase.model.provider.UnicaseModelElementItemProvider;

import org.unicase.model.simplemeeting.SimpleMeeting;
import org.unicase.model.simplemeeting.SimplemeetingPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.simplemeeting.SimpleMeeting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleMeetingItemProvider
	extends UnicaseModelElementItemProvider
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
	public SimpleMeetingItemProvider(AdapterFactory adapterFactory) {
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
			addStarttimePropertyDescriptor(object);
			addEndtimePropertyDescriptor(object);
			addFacilitatorPropertyDescriptor(object);
			addMinutetakerPropertyDescriptor(object);
			addTimekeeperPropertyDescriptor(object);
			addParticipantsPropertyDescriptor(object);
			addStatusItemsPropertyDescriptor(object);
			addDiscussionItemsPropertyDescriptor(object);
			addIdentifiedItemsPropertyDescriptor(object);
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
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_location_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_location_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__LOCATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Starttime feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStarttimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_starttime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_starttime_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__STARTTIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endtime feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndtimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_endtime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_endtime_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__ENDTIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facilitator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacilitatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_facilitator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_facilitator_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__FACILITATOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minutetaker feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinutetakerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_minutetaker_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_minutetaker_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__MINUTETAKER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Timekeeper feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimekeeperPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_timekeeper_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_timekeeper_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__TIMEKEEPER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Participants feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_participants_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_participants_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__PARTICIPANTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Status Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_statusItems_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_statusItems_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__STATUS_ITEMS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Discussion Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiscussionItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_discussionItems_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_discussionItems_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__DISCUSSION_ITEMS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identified Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifiedItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleMeeting_identifiedItems_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleMeeting_identifiedItems_feature", "_UI_SimpleMeeting_type"),
				 SimplemeetingPackage.Literals.SIMPLE_MEETING__IDENTIFIED_ITEMS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SimpleMeeting.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimpleMeeting"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	/**@Override
	public String getText(Object object) {
		String label = ((SimpleMeeting)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SimpleMeeting_type") :
			getString("_UI_SimpleMeeting_type") + " " + label;
	}
*/
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

		switch (notification.getFeatureID(SimpleMeeting.class)) {
			case SimplemeetingPackage.SIMPLE_MEETING__LOCATION:
			case SimplemeetingPackage.SIMPLE_MEETING__STARTTIME:
			case SimplemeetingPackage.SIMPLE_MEETING__ENDTIME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SimplemeetingEditPlugin.INSTANCE;
	}

}
