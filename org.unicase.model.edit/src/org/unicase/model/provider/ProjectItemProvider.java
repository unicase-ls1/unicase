/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.activity.ActivityFactory;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.profile.ProfileFactory;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.state.StateFactory;
import org.unicase.model.task.TaskFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.Project} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ProjectItemProvider extends org.unicase.metamodel.provider.ProjectItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * This returns Project.gif. <!-- begin-user-doc --> <!-- end-user-doc --> {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
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
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			DiagramFactory.eINSTANCE.createMEDiagram()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createMethodArgument()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createDependency()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ClassesFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createNonFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createScenario()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createActorInstance()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createStep()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createSystemFunction()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createUserTask()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RequirementFactory.eINSTANCE.createWorkspace()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ChangeFactory.eINSTANCE.createMergingProposal()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ChangeFactory.eINSTANCE.createMergingSolution()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ComponentFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ComponentFactory.eINSTANCE.createComponentService()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ComponentFactory.eINSTANCE.createDeploymentNode()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createCompositeMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			StateFactory.eINSTANCE.createState()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			StateFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			StateFactory.eINSTANCE.createStateInitial()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			StateFactory.eINSTANCE.createStateEnd()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			AttachmentFactory.eINSTANCE.createUrlAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			AttachmentFactory.eINSTANCE.createFileAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ProfileFactory.eINSTANCE.createProfile()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ProfileFactory.eINSTANCE.createStereotype()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ProfileFactory.eINSTANCE.createStereotypeInstance()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ProfileFactory.eINSTANCE.createStereotypeAttributeSimple()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ProfileFactory.eINSTANCE.createStereotypeAttributeInstanceString()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createFork()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createBranch()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createActivityInitial()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ActivityFactory.eINSTANCE.createActivityEnd()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
