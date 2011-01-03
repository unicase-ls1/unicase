/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.provider;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.activity.ActivityFactory;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.profile.ProfileFactory;
import org.unicase.model.provider.AttachmentItemProvider;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.state.StateFactory;
import org.unicase.model.task.TaskFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.diagram.MEDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MEDiagramItemProvider extends AttachmentItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MEDiagramItemProvider(AdapterFactory adapterFactory) {
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

			addElementsPropertyDescriptor(object);
			//addDiagramLayoutPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Elements feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_MEDiagram_elements_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_MEDiagram_elements_feature",
								"_UI_MEDiagram_type"),
						DiagramPackage.Literals.ME_DIAGRAM__ELEMENTS, true,
						false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Diagram Layout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	protected void addDiagramLayoutPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add(createItemPropertyDescriptor(
//				((ComposeableAdapterFactory) adapterFactory)
//						.getRootAdapterFactory(),
//				getResourceLocator(),
//				getString("_UI_MEDiagram_diagramLayout_feature"),
//				getString("_UI_PropertyDescriptor_description",
//						"_UI_MEDiagram_diagramLayout_feature",
//						"_UI_MEDiagram_type"),
//				DiagramPackage.Literals.ME_DIAGRAM__DIAGRAM_LAYOUT, true,
//				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
//				null));
//	}

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
					.add(DiagramPackage.Literals.ME_DIAGRAM__GMFDIAGRAM);
			childrenFeatures
					.add(DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS);
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
	 * This returns MEDiagram.gif. <!-- begin-user-doc --> returns different icons for different diagram types
	 * 
	 * @param object th object to get the image for
	 * @return the image object <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		String imgStr = "full/obj16/MEDiagram";
		return overlayImage(object, getResourceLocator().getImage(imgStr));
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

		switch (notification.getFeatureID(MEDiagram.class)) {
		case DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
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
				DiagramPackage.Literals.ME_DIAGRAM__GMFDIAGRAM,
				NotationFactory.eINSTANCE.createDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__GMFDIAGRAM,
				NotationFactory.eINSTANCE.createStandardDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createClassDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createUseCaseDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createComponentDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createStateDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createActivityDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DiagramFactory.eINSTANCE.createWorkItemDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createMethodArgument()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createDependency()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ClassesFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createNonFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createScenario()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createActorInstance()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createStep()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createSystemFunction()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createUserTask()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createWorkspace()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingProposal()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingSolution()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponentService()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ComponentFactory.eINSTANCE.createDeploymentNode()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				MeetingFactory.eINSTANCE.createCompositeMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				StateFactory.eINSTANCE.createState()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				StateFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				StateFactory.eINSTANCE.createStateInitial()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				StateFactory.eINSTANCE.createStateEnd()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				AttachmentFactory.eINSTANCE.createUrlAttachment()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				AttachmentFactory.eINSTANCE.createFileAttachment()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				AttachmentFactory.eINSTANCE.createPatchAttachment()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ProfileFactory.eINSTANCE.createProfile()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ProfileFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ProfileFactory.eINSTANCE.createStereotypeInstance()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ProfileFactory.eINSTANCE.createStereotypeAttributeSimple()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ProfileFactory.eINSTANCE
						.createStereotypeAttributeInstanceString()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createFork()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createBranch()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createActivityInitial()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ActivityFactory.eINSTANCE.createActivityEnd()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == ModelPackage.Literals.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES
				|| childFeature == DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS
				|| childFeature == ModelPackage.Literals.UNICASE_MODEL_ELEMENT__COMMENTS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DiagramEditPlugin.INSTANCE;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		// JH Auto-generated method stub
		return super.getChildren(object);
	}

}
