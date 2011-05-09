/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase.provider;


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

import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecaseFactory;
import org.unicase.model.usecase.UsecasePackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.usecase.UseCase} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UseCaseItemProvider
	extends org.unicase.model.requirement.provider.UseCaseItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Blend out unwanted features
	 */
	@Override
	protected void addPreconditionPropertyDescriptor(Object object) {
	}
	
	@Override
	protected void addIncludedUseCasesPropertyDescriptor(Object object) {
	}
	
	@Override
	protected void addExtendedUseCasesPropertyDescriptor(Object object) {
	}
	
	@Override
	protected void addPostconditionPropertyDescriptor(Object object) {
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

			addActorStepsPropertyDescriptor(object);
			addPreconPropertyDescriptor(object);
			addPostconPropertyDescriptor(object);
			addRulPropertyDescriptor(object);
			addExcPropertyDescriptor(object);
			addUseCasesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Actor Steps feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActorStepsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_actorSteps_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_actorSteps_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__ACTOR_STEPS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	@Override
	protected void addUseCaseStepsPropertyDescriptor(Object object) {
		//do nothing as old use case steps should not be visible
	}
	
	/**
	 * This adds a property descriptor for the Precon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected void addPreconPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_precon_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_precon_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__PRECON,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postcon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected void addPostconPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_postcon_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_postcon_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__POSTCON,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rul feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected void addRulPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_rul_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_rul_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__RUL,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected void addExcPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_exc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_exc_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__EXC,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Cases feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseCasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCase_useCases_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCase_useCases_feature", "_UI_UseCase_type"),
				 UsecasePackage.Literals.USE_CASE__USE_CASES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns UseCase.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UseCase"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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

		switch (notification.getFeatureID(UseCase.class)) {
			case UsecasePackage.USE_CASE__ACTOR_STEPS:
			case UsecasePackage.USE_CASE__SYSTEM_STEPS:
			case UsecasePackage.USE_CASE__PRECON:
			case UsecasePackage.USE_CASE__POSTCON:
			case UsecasePackage.USE_CASE__RUL:
			case UsecasePackage.USE_CASE__EXC:
			case UsecasePackage.USE_CASE__SYNC:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UsecaseEditPlugin.INSTANCE;
	}

}
