/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.provider.UnicaseModelElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.classes.Association} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssociationItemProvider extends UnicaseModelElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addSourceMultiplicityPropertyDescriptor(object);
			addTargetMultiplicityPropertyDescriptor(object);
			addSourceRolePropertyDescriptor(object);
			addTargetRolePropertyDescriptor(object);
			addTransientPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_source_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_source_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__SOURCE, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_target_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_target_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__TARGET, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Association_type_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_Association_type_feature",
								"_UI_Association_type"),
						ClassesPackage.Literals.ASSOCIATION__TYPE, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
						null, null));
	}

	/**
	 * This adds a property descriptor for the Source Multiplicity feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addSourceMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_sourceMultiplicity_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_sourceMultiplicity_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__SOURCE_MULTIPLICITY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Target Multiplicity feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addTargetMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_targetMultiplicity_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_targetMultiplicity_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__TARGET_MULTIPLICITY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Source Role feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_sourceRole_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_sourceRole_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__SOURCE_ROLE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Target Role feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_targetRole_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_targetRole_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__TARGET_ROLE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Transient feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Association_transient_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Association_transient_feature",
						"_UI_Association_type"),
				ClassesPackage.Literals.ASSOCIATION__TRANSIENT, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns Association.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @param object The association
	 * @return The association image
	 */
	@Override
	public Object getImage(Object object) {

		Object overlayImage = null;

		AssociationType type = ((Association) object).getType();
		if (type == AssociationType.AGGREGATION) {
			overlayImage = overlayImage(object,
					getResourceLocator().getImage("full/obj16/Aggregation"));
		} else if (type == AssociationType.COMPOSITION) {
			overlayImage = overlayImage(object,
					getResourceLocator().getImage("full/obj16/Composition"));
		} else if (type == AssociationType.DIRECTED_ASSOCIATION) {
			overlayImage = overlayImage(
					object,
					getResourceLocator().getImage(
							"full/obj16/Directed_Association"));
		} else if (type == AssociationType.UNDIRECTED_ASSOCIATION) {
			overlayImage = overlayImage(object,
					getResourceLocator().getImage("full/obj16/Association"));
		} else {
			overlayImage = overlayImage(object,
					getResourceLocator().getImage("full/obj16/Association"));
		}

		return overlayImage;
	}

	/**
	 * {@inheritDoc} This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof Association) {
			Association association = (Association) object;
			Class source = association.getSource();
			Class target = association.getTarget();
			if (source == null && target == null) {
				return super.getText(object);
			}
			String sourceString = "(not set)";
			if (source != null && source.getName().trim().length() > 0) {
				sourceString = source.getName();
			}
			String targetString = "(not set)";
			if (target != null && target.getName().trim().length() > 0) {
				targetString = target.getName();
			}
			return super.getText(object) + " [" + sourceString + " => "
					+ targetString + "]";
		}
		return super.getText(object);
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

		switch (notification.getFeatureID(Association.class)) {
		case ClassesPackage.ASSOCIATION__TYPE:
		case ClassesPackage.ASSOCIATION__SOURCE_MULTIPLICITY:
		case ClassesPackage.ASSOCIATION__TARGET_MULTIPLICITY:
		case ClassesPackage.ASSOCIATION__SOURCE_ROLE:
		case ClassesPackage.ASSOCIATION__TARGET_ROLE:
		case ClassesPackage.ASSOCIATION__TRANSIENT:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
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
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
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
