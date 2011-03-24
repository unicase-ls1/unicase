/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceFactory;
import org.eclipse.emf.emfstore.client.model.WorkspacePackage;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerFactory;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.provider.IdentifiableElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.emfstore.client.model.ProjectSpace} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProjectSpaceItemProvider extends IdentifiableElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectSpaceItemProvider(AdapterFactory adapterFactory) {
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

			addProjectPropertyDescriptor(object);
			addProjectNamePropertyDescriptor(object);
			addProjectDescriptionPropertyDescriptor(object);
			addUsersessionPropertyDescriptor(object);
			addLastUpdatedPropertyDescriptor(object);
			addResourceCountPropertyDescriptor(object);
			addDirtyPropertyDescriptor(object);
			addOldLogMessagesPropertyDescriptor(object);
			addNotificationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Project feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ProjectSpace_project_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_project_feature",
					"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__PROJECT, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Project Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_projectName_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_projectName_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_NAME, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Project Description feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addProjectDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_projectDescription_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_projectDescription_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_DESCRIPTION, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Usersession feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addUsersessionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_usersession_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_usersession_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__USERSESSION, true, false, true,
			null, null, null));
	}

	/**
	 * This adds a property descriptor for the Last Updated feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLastUpdatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_lastUpdated_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_lastUpdated_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__LAST_UPDATED, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Resource Count feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addResourceCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_resourceCount_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_resourceCount_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__RESOURCE_COUNT, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Dirty feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDirtyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_ProjectSpace_dirty_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_dirty_feature", "_UI_ProjectSpace_type"),
			WorkspacePackage.Literals.PROJECT_SPACE__DIRTY, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Old Log Messages feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addOldLogMessagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_oldLogMessages_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_oldLogMessages_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__OLD_LOG_MESSAGES, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Notifications feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNotificationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectSpace_notifications_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectSpace_notifications_feature",
				"_UI_ProjectSpace_type"), WorkspacePackage.Literals.PROJECT_SPACE__NOTIFICATIONS, true, false, true,
			null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_ID);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__BASE_VERSION);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__LOCAL_OPERATIONS);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__EVENT_COMPOSITE);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__NOTIFICATION_COMPOSITE);
			childrenFeatures.add(WorkspacePackage.Literals.PROJECT_SPACE__WAITING_UPLOADS);
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
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("prj_obj.gif");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getText(java.lang.Object)
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) object;
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(projectSpace.getProjectName());
			// if (projectSpace.getBaseVersion() != null) {
			// stringBuilder.append("@");
			// stringBuilder.append(projectSpace.getBaseVersion()
			// .getIdentifier());
			// } else {
			// stringBuilder.append("(Not shared)");
			// }
			String string = stringBuilder.toString();
			return string;
		}
		return getString("_UI_ProjectSpace_type");
	}

	// end of custom code

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

		switch (notification.getFeatureID(ProjectSpace.class)) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
		case WorkspacePackage.PROJECT_SPACE__WAITING_UPLOADS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
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

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT,
			MetamodelFactory.eINSTANCE.createProject()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_ID,
			EsmodelFactory.eINSTANCE.createProjectId()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createReadEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createMergeEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createCheckoutEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createExceptionEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createPluginStartEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createUpdateEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createAnnotationEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createRevertEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createShowHistoryEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createPerspectiveEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createDNDEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createLinkEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createTraceEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createNavigatorCreateEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createPluginFocusEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createPresentationSwitchEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createUndoEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createValidate()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createShowChangesEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createNotificationReadEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createNotificationGenerationEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createNotificationIgnoreEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createURLEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createMergeChoiceEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			EventsFactory.eINSTANCE.createMergeGlobalChoiceEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENTS,
			ServerFactory.eINSTANCE.createProjectUpdatedEvent()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__BASE_VERSION,
			VersioningFactory.eINSTANCE.createPrimaryVersionSpec()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__LOCAL_OPERATIONS,
			WorkspaceFactory.eINSTANCE.createOperationComposite()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__EVENT_COMPOSITE,
			WorkspaceFactory.eINSTANCE.createEventComposite()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__NOTIFICATION_COMPOSITE,
			WorkspaceFactory.eINSTANCE.createNotificationComposite()));

		newChildDescriptors.add(createChildParameter(WorkspacePackage.Literals.PROJECT_SPACE__WAITING_UPLOADS,
			EsmodelFactory.eINSTANCE.createFileIdentifier()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return WorkspaceEditPlugin.INSTANCE;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof ProjectSpace) {
			final Project project = ((ProjectSpace) object).getProject();
			if (project == null) {
				return Collections.EMPTY_LIST;
			}
			// TODO: Check for better way
			return project.getModelElements();
		}
		return new ArrayList<Object>();

	}

}
