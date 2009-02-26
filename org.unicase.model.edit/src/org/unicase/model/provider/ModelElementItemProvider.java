/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.profile.ProfileFactory;

/*
 * This is the item provider adapter for a {@link org.unicase.model.ModelElement} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ModelElementItemProvider extends IdentifiableElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addAnnotationsPropertyDescriptor(object);
			addAttachmentsPropertyDescriptor(object);
			addIncomingDocumentReferencesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_name_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_ModelElement_name_feature", "_UI_ModelElement_type"),
			ModelPackage.Literals.MODEL_ELEMENT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_description_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ModelElement_description_feature",
				"_UI_ModelElement_type"), ModelPackage.Literals.MODEL_ELEMENT__DESCRIPTION, true, true, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Annotations feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_annotations_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ModelElement_annotations_feature",
				"_UI_ModelElement_type"), ModelPackage.Literals.MODEL_ELEMENT__ANNOTATIONS, true, false, true, null,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Attachments feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAttachmentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_attachments_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ModelElement_attachments_feature",
				"_UI_ModelElement_type"), ModelPackage.Literals.MODEL_ELEMENT__ATTACHMENTS, true, false, true, null,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Incoming Document References feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addIncomingDocumentReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_ModelElement_incomingDocumentReferences_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_ModelElement_incomingDocumentReferences_feature",
				"_UI_ModelElement_type"), ModelPackage.Literals.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES, true,
			false, true, null, null, null));
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
			childrenFeatures.add(ModelPackage.Literals.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES);
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
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		String label = ((ModelElement) object).getName();
		return label == null || label.length() == 0 ? "unnamed" + getString("_UI_ModelElement_type") : label;
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

		switch (notification.getFeatureID(ModelElement.class)) {
		case ModelPackage.MODEL_ELEMENT__NAME:
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
		case ModelPackage.MODEL_ELEMENT__CREATOR:
		case ModelPackage.MODEL_ELEMENT__CREATION_DATE:
		case ModelPackage.MODEL_ELEMENT__STATE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
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

		newChildDescriptors.add(createChildParameter(ModelPackage.Literals.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES,
			ProfileFactory.eINSTANCE.createStereotypeInstance()));
	}

	/**
	 * @return the ImageDescriptor for this class.
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/ModelElement");
	}

}
