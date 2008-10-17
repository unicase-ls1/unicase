/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.provider;

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
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.TaskFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateDeleteOperationItemProvider extends
		AbstractOperationItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateDeleteOperationItemProvider(AdapterFactory adapterFactory) {
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

			addDeletePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_CreateDeleteOperation_delete_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CreateDeleteOperation_delete_feature",
						"_UI_CreateDeleteOperation_type"),
				OperationsPackage.Literals.CREATE_DELETE_OPERATION__DELETE,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CreateDeleteOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/CreateDeleteOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CreateDeleteOperation) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_CreateDeleteOperation_type")
				: getString("_UI_CreateDeleteOperation_type") + " " + label;
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

		switch (notification.getFeatureID(CreateDeleteOperation.class)) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
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

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						DiagramFactory.eINSTANCE.createMEDiagram()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createClass()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createPackage()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createAssociation()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createAttribute()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createMethod()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createMethodArgument()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ClassesFactory.eINSTANCE.createDependency()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE
								.createNonFunctionalRequirement()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE
								.createFunctionalRequirement()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createUseCase()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createScenario()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createActor()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createActorInstance()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createStep()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createSystemFunction()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RequirementFactory.eINSTANCE.createUserTask()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ChangeFactory.eINSTANCE.createModelChangePackage()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ChangeFactory.eINSTANCE.createMergingProposal()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ChangeFactory.eINSTANCE.createMergingSolution()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ComponentFactory.eINSTANCE.createComponent()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ComponentFactory.eINSTANCE.createComponentService()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						ComponentFactory.eINSTANCE.createDeploymentNode()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						MeetingFactory.eINSTANCE
								.createCompositeMeetingSection()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
						MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));
	}

}
