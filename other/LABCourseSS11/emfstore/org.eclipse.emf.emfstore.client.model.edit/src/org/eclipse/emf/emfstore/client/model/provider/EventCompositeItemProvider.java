/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.client.model.EventComposite;
import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.emfstore.client.model.EventComposite} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EventCompositeItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EventCompositeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.EVENT_COMPOSITE__EVENTS);
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
	 * This returns EventComposite.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/EventComposite"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_EventComposite_type");
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

		switch (notification.getFeatureID(EventComposite.class)) {
		case ModelPackage.EVENT_COMPOSITE__EVENTS:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createReadEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createMergeEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createCheckoutEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createExceptionEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createPluginStartEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createUpdateEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createAnnotationEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createRevertEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createShowHistoryEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createPerspectiveEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createDNDEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createLinkEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createTraceEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createNavigatorCreateEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createPluginFocusEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createPresentationSwitchEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createUndoEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createValidate()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createShowChangesEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createNotificationReadEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createNotificationGenerationEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createNotificationIgnoreEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createURLEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createMergeChoiceEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				EventsFactory.eINSTANCE.createMergeGlobalChoiceEvent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.EVENT_COMPOSITE__EVENTS,
				ServerFactory.eINSTANCE.createProjectUpdatedEvent()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ClientModelEditPlugin.INSTANCE;
	}

}
