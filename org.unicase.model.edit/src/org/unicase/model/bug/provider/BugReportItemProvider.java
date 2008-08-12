/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug.provider;

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
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.provider.AnnotationItemProvider;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.task.TaskPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.bug.BugReport} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class BugReportItemProvider extends AnnotationItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BugReportItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addContainingWorkpackagePropertyDescriptor(object);
			addAssociatedChangePackagesPropertyDescriptor(object);
			addPredecessorsPropertyDescriptor(object);
			addSuccessorsPropertyDescriptor(object);
			addStepsToReproducePropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
			addAssignedToPropertyDescriptor(object);
			addResolutionPropertyDescriptor(object);
			addSeverityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Containing Workpackage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainingWorkpackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_WorkItem_containingWorkpackage_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_containingWorkpackage_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Associated Change Packages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssociatedChangePackagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_WorkItem_associatedChangePackages_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_associatedChangePackages_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Predecessors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPredecessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_WorkItem_predecessors_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_WorkItem_predecessors_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__PREDECESSORS, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Successors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(), getResourceLocator(),
						getString("_UI_WorkItem_successors_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_WorkItem_successors_feature",
								"_UI_WorkItem_type"),
						TaskPackage.Literals.WORK_ITEM__SUCCESSORS, true,
						false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Steps To Reproduce feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStepsToReproducePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BugReport_stepsToReproduce_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_BugReport_stepsToReproduce_feature",
						"_UI_BugReport_type"),
				BugPackage.Literals.BUG_REPORT__STEPS_TO_REPRODUCE, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Status feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BugReport_Status_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_BugReport_Status_feature", "_UI_BugReport_type"),
				BugPackage.Literals.BUG_REPORT__STATUS, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Assigned To feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAssignedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BugReport_assignedTo_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_BugReport_assignedTo_feature",
						"_UI_BugReport_type"),
				BugPackage.Literals.BUG_REPORT__ASSIGNED_TO, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Resolution feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addResolutionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BugReport_resolution_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_BugReport_resolution_feature",
						"_UI_BugReport_type"),
				BugPackage.Literals.BUG_REPORT__RESOLUTION, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Severity feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSeverityPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(), getResourceLocator(),
						getString("_UI_BugReport_severity_feature"), getString(
								"_UI_PropertyDescriptor_description",
								"_UI_BugReport_severity_feature",
								"_UI_BugReport_type"),
						BugPackage.Literals.BUG_REPORT__SEVERITY, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
						null, null));
	}

	/**
	 * This returns BugReport.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/BugReport"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(BugReport.class)) {
		case BugPackage.BUG_REPORT__STATUS:
		case BugPackage.BUG_REPORT__SEVERITY:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
