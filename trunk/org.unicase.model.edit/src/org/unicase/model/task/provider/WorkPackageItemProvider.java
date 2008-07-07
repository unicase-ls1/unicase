/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.ModelFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.provider.AnnotationItemProvider;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.provider.ModelElementItemProvider;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.task.WorkPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkPackageItemProvider extends ModelElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkPackageItemProvider(AdapterFactory adapterFactory) {
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

			addContainedModelElementsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Contained Model Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedModelElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_WorkPackage_containedModelElements_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_WorkPackage_containedModelElements_feature",
						"_UI_WorkPackage_type"),
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				true, false, false, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS);
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
	 * This returns WorkPackage.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/WorkPackage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((WorkPackage) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_WorkPackage_type")
				: getString("_UI_WorkPackage_type") + " " + label;
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

		switch (notification.getFeatureID(WorkPackage.class)) {
		case TaskPackage.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ModelFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				OrganizationFactory.eINSTANCE.createOrgUnit()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				DiagramFactory.eINSTANCE.createMEDiagram()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createNonFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createScenario()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createActorInstance()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createStep()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createModelChangePackage()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingProposal()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingSolution()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				BugFactory.eINSTANCE.createBugResolution()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponentService()));

		newChildDescriptors.add(createChildParameter(
				TaskPackage.Literals.WORK_PACKAGE__CONTAINED_MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createDeploymentNode()));
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
