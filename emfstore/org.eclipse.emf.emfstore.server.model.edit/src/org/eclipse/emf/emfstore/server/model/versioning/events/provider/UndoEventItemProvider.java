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
package org.eclipse.emf.emfstore.server.model.versioning.events.provider;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent}
 * object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class UndoEventItemProvider extends EventItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UndoEventItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EventsPackage.Literals.UNDO_EVENT__OPERATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns UndoEvent.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UndoEvent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Date labelValue = ((UndoEvent)object).getTimestamp();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_UndoEvent_type") :
			getString("_UI_UndoEvent_type") + " " + label;
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

		switch (notification.getFeatureID(UndoEvent.class)) {
			case EventsPackage.UNDO_EVENT__OPERATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiAttributeOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiAttributeSetOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiReferenceSetOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.UNDO_EVENT__OPERATION,
				 OperationsFactory.eINSTANCE.createDiagramLayoutOperation()));
	}

}
