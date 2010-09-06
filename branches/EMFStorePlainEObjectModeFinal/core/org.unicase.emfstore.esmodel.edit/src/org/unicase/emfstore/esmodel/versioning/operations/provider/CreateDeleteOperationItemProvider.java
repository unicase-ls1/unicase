/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
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
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerFactory;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.metamodel.MetamodelFactory;

/**
 * This is the item provider adapter for a
 * {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class CreateDeleteOperationItemProvider extends AbstractOperationItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CreateDeleteOperationItemProvider(AdapterFactory adapterFactory) {
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

			addDeletePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Delete feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_CreateDeleteOperation_delete_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CreateDeleteOperation_delete_feature",
				"_UI_CreateDeleteOperation_type"), OperationsPackage.Literals.CREATE_DELETE_OPERATION__DELETE, true,
			false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT);
			childrenFeatures.add(OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS);
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

	/**
	 * This returns CreateDeleteOperation.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CreateDeleteOperation"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CreateDeleteOperation) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_CreateDeleteOperation_type")
			: getString("_UI_CreateDeleteOperation_type") + " " + label;
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

		switch (notification.getFeatureID(CreateDeleteOperation.class)) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
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

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiAttributeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiAttributeSetOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiReferenceSetOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createDiagramLayoutOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createOperationId()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createOperationGroup()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			OperationsFactory.eINSTANCE.createModelElementGroup()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createProjectHistory()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createProjectInfo()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createSessionId()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createServerSpace()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createProjectId()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createVersionInfo()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EsmodelFactory.eINSTANCE.createClientVersionInfo()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createTagVersionSpec()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createDateVersionSpec()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createPrimaryVersionSpec()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createLogMessage()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createChangePackage()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createHistoryInfo()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createHistoryQuery()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createVersion()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createHeadVersionSpec()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			VersioningFactory.eINSTANCE.createVersionProperty()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createReadEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createMergeEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createCheckoutEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createExceptionEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createPluginStartEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createUpdateEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createAnnotationEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createRevertEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createShowHistoryEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createPerspectiveEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createDNDEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createLinkEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createTraceEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createNavigatorCreateEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createPluginFocusEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createPresentationSwitchEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createUndoEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createValidate()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createShowChangesEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createNotificationReadEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createNotificationGenerationEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createNotificationIgnoreEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createURLEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createMergeChoiceEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			EventsFactory.eINSTANCE.createMergeGlobalChoiceEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			ServerFactory.eINSTANCE.createProjectUpdatedEvent()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			AccesscontrolFactory.eINSTANCE.createACOrgUnit()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			AccesscontrolFactory.eINSTANCE.createACUser()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			AccesscontrolFactory.eINSTANCE.createACGroup()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			AccesscontrolFactory.eINSTANCE.createACOrgUnitId()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			AccesscontrolFactory.eINSTANCE.createOrgUnitProperty()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			RolesFactory.eINSTANCE.createReaderRole()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			RolesFactory.eINSTANCE.createWriterRole()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			RolesFactory.eINSTANCE.createProjectAdminRole()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			RolesFactory.eINSTANCE.createServerAdmin()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			NotificationFactory.eINSTANCE.createESNotification()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			UrlFactory.eINSTANCE.createServerUrl()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			UrlFactory.eINSTANCE.createProjectUrlFragment()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			UrlFactory.eINSTANCE.createModelElementUrlFragment()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			UrlFactory.eINSTANCE.createModelElementUrl()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			MetamodelFactory.eINSTANCE.createProject()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			MetamodelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
			MetamodelFactory.eINSTANCE.createModelVersion()));

		newChildDescriptors.add(createChildParameter(
			OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS, OperationsFactory.eINSTANCE
				.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(
			OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS, OperationsFactory.eINSTANCE
				.createMultiReferenceSetOperation()));

		newChildDescriptors.add(createChildParameter(
			OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS, OperationsFactory.eINSTANCE
				.createMultiReferenceOperation()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT
			|| childFeature == OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
