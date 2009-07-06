/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.state.StateFactory;
import org.unicase.model.task.TaskFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.Project} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ProjectItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.PROJECT__MODEL_ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Project.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * {@inheritDoc}
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/folder_database.png"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> .<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		return "Orphans";
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Project.class)) {
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
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
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				DiagramFactory.eINSTANCE.createMEDiagram()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createClass()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createMethodArgument()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ClassesFactory.eINSTANCE.createDependency()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createNonFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createScenario()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createActorInstance()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createStep()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createSystemFunction()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RequirementFactory.eINSTANCE.createUserTask()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createModelChangePackage()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingIssue()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingProposal()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ChangeFactory.eINSTANCE.createMergingSolution()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createComponentService()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				ComponentFactory.eINSTANCE.createDeploymentNode()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				MeetingFactory.eINSTANCE.createCompositeMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				StateFactory.eINSTANCE.createState()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				StateFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add(createChildParameter(
				ModelPackage.Literals.PROJECT__MODEL_ELEMENTS,
				AttachmentFactory.eINSTANCE.createUrlAttachment()));
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
	
	
	

	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof Project) 
		{	
			final Project project = (Project) object;
			final Collection<ModelElement> ret = new ArrayList<ModelElement>(); 
			EObject econtainer = null;
			EList<ModelElement> allmes = project.getAllModelElements();
			for ( ModelElement temp : allmes ) 
			{
				econtainer = temp.eContainer();
				if ( (econtainer instanceof Project)  && !(temp instanceof CompositeSection) ) 
				{	
					ret.add(temp); 	 
				}

			} 
			return ret;
		} else {	
			return super.getChildren(object);
		}
	}
	
	
	
	
}
