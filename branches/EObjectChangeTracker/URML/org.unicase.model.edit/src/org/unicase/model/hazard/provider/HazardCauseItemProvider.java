/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard.provider;

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
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.provider.ModelElementItemProvider;

/*
 * This is the item provider adapter for a {@link org.unicase.model.hazard.HazardCause} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HazardCauseItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HazardCauseItemProvider(AdapterFactory adapterFactory) {
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

			addHazardsPropertyDescriptor(object);
			addHazardousModelElementsPropertyDescriptor(object);
			addEvaluationStatusPropertyDescriptor(object);
			addLikelihoodPropertyDescriptor(object);
			addMitigationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hazards feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHazardsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_HazardCause_hazards_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_HazardCause_hazards_feature", "_UI_HazardCause_type"),
			HazardPackage.Literals.HAZARD_CAUSE__HAZARDS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Hazardous Model Elements feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addHazardousModelElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_HazardCause_hazardousModelElements_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_HazardCause_hazardousModelElements_feature",
				"_UI_HazardCause_type"), HazardPackage.Literals.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Evaluation Status feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEvaluationStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_HazardCause_evaluationStatus_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_HazardCause_evaluationStatus_feature",
				"_UI_HazardCause_type"), HazardPackage.Literals.HAZARD_CAUSE__EVALUATION_STATUS, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Likelihood feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLikelihoodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_HazardCause_likelihood_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_HazardCause_likelihood_feature", "_UI_HazardCause_type"),
			HazardPackage.Literals.HAZARD_CAUSE__LIKELIHOOD, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Mitigations feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMitigationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_HazardCause_mitigations_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_HazardCause_mitigations_feature",
				"_UI_HazardCause_type"), HazardPackage.Literals.HAZARD_CAUSE__MITIGATIONS, true, false, true, null,
			null, null));
	}

	/**
	 * This returns HazardCause.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/HazardCause"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((HazardCause) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_HazardCause_type")
			: getString("_UI_HazardCause_type") + " " + label;
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

		switch (notification.getFeatureID(HazardCause.class)) {
		case HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS:
		case HazardPackage.HAZARD_CAUSE__LIKELIHOOD:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
