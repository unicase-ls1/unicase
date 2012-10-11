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
import org.unicase.model.ModelFactory;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.util.UtilFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.Project} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ProjectItemProvider extends org.unicase.metamodel.provider.ProjectItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectItemProvider(AdapterFactory adapterFactory) {
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
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			ModelFactory.eINSTANCE.createProject()));

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
			DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			DocumentFactory.eINSTANCE.createCompositeSection()));

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
			RationaleFactory.eINSTANCE.createAudioComment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createCompositeMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			AttachmentFactory.eINSTANCE.createUrlAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			AttachmentFactory.eINSTANCE.createFileAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			AttachmentFactory.eINSTANCE.createPatchAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			ModelFactory.eINSTANCE.createProject()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			OrganizationFactory.eINSTANCE.createUser()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			OrganizationFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			TaskFactory.eINSTANCE.createActionItem()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			TaskFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			TaskFactory.eINSTANCE.createMilestone()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			DocumentFactory.eINSTANCE.createLeafSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			DocumentFactory.eINSTANCE.createCompositeSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createIssue()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createProposal()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createCriterion()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createAssessment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createComment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			RationaleFactory.eINSTANCE.createAudioComment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			BugFactory.eINSTANCE.createBugReport()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			MeetingFactory.eINSTANCE.createMeeting()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			MeetingFactory.eINSTANCE.createCompositeMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			MeetingFactory.eINSTANCE.createIssueMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			MeetingFactory.eINSTANCE.createWorkItemMeetingSection()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			AttachmentFactory.eINSTANCE.createUrlAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			AttachmentFactory.eINSTANCE.createFileAttachment()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS,
			AttachmentFactory.eINSTANCE.createPatchAttachment()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS
			|| childFeature == MetamodelPackage.Literals.PROJECT__CUT_ELEMENTS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
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
		return ModelEditPlugin.INSTANCE;
	}

}
