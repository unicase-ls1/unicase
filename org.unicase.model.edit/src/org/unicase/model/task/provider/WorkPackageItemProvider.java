/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.provider.AnnotationItemProvider;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.task.WorkPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkPackageItemProvider extends AnnotationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackageItemProvider(AdapterFactory adapterFactory) {
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

			addContainingWorkpackagePropertyDescriptor(object);
			addPredecessorsPropertyDescriptor(object);
			addSuccessorsPropertyDescriptor(object);
			addAssigneePropertyDescriptor(object);
			addReviewerPropertyDescriptor(object);
			addParticipantsPropertyDescriptor(object);
			addDueDatePropertyDescriptor(object);
			addEstimatePropertyDescriptor(object);
			addEffortPropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addResolvedPropertyDescriptor(object);
			addIncludingReleasesPropertyDescriptor(object);
			addContainedWorkItemsPropertyDescriptor(object);
			addStartDatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Containing Workpackage feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addContainingWorkpackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_containingWorkpackage_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_containingWorkpackage_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Predecessors feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPredecessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_predecessors_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_predecessors_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__PREDECESSORS, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Successors feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WorkItem_successors_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_WorkItem_successors_feature",
								"_UI_WorkItem_type"),
						TaskPackage.Literals.WORK_ITEM__SUCCESSORS, true,
						false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Contained Work Items feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addContainedWorkItemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkPackage_containedWorkItems_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkPackage_containedWorkItems_feature",
						"_UI_WorkPackage_type"),
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Start Date feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkPackage_startDate_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkPackage_startDate_feature",
						"_UI_WorkPackage_type"),
				TaskPackage.Literals.WORK_PACKAGE__START_DATE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Assignee feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssigneePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_assignee_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_assignee_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__ASSIGNEE, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Reviewer feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReviewerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_reviewer_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_reviewer_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__REVIEWER, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Participants feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_participants_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_participants_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__PARTICIPANTS, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Due Date feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDueDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_dueDate_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_dueDate_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__DUE_DATE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Estimate feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEstimatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_estimate_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_estimate_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__ESTIMATE, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Effort feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEffortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_effort_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_effort_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__EFFORT, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_priority_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_priority_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__PRIORITY, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Resolved feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_resolved_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_resolved_feature", "_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__RESOLVED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Including Releases feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncludingReleasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_WorkItem_includingReleases_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkItem_includingReleases_feature",
						"_UI_WorkItem_type"),
				TaskPackage.Literals.WORK_ITEM__INCLUDING_RELEASES, true,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS);
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
	 * This returns WorkPackage.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/WorkPackage"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc --> {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
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

		switch (notification.getFeatureID(WorkPackage.class)) {
		case TaskPackage.WORK_PACKAGE__DUE_DATE:
		case TaskPackage.WORK_PACKAGE__ESTIMATE:
		case TaskPackage.WORK_PACKAGE__EFFORT:
		case TaskPackage.WORK_PACKAGE__PRIORITY:
		case TaskPackage.WORK_PACKAGE__RESOLVED:
		case TaskPackage.WORK_PACKAGE__START_DATE:
		case TaskPackage.WORK_PACKAGE__END_DATE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
				BugFactory.eINSTANCE.createBugReport()));
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
