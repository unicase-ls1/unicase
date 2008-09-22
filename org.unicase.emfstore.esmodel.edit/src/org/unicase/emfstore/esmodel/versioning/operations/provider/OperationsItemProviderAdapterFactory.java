/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsItemProviderAdapterFactory extends
		OperationsAdapterFactory implements ComposeableAdapterFactory,
		IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeOperationItemProvider compositeOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeOperationAdapter() {
		if (compositeOperationItemProvider == null) {
			compositeOperationItemProvider = new CompositeOperationItemProvider(
					this);
		}

		return compositeOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateDeleteOperationItemProvider createDeleteOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateDeleteOperationAdapter() {
		if (createDeleteOperationItemProvider == null) {
			createDeleteOperationItemProvider = new CreateDeleteOperationItemProvider(
					this);
		}

		return createDeleteOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeOperationItemProvider attributeOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeOperationAdapter() {
		if (attributeOperationItemProvider == null) {
			attributeOperationItemProvider = new AttributeOperationItemProvider(
					this);
		}

		return attributeOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleReferenceOperationItemProvider singleReferenceOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSingleReferenceOperationAdapter() {
		if (singleReferenceOperationItemProvider == null) {
			singleReferenceOperationItemProvider = new SingleReferenceOperationItemProvider(
					this);
		}

		return singleReferenceOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiReferenceOperationItemProvider multiReferenceOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceOperationAdapter() {
		if (multiReferenceOperationItemProvider == null) {
			multiReferenceOperationItemProvider = new MultiReferenceOperationItemProvider(
					this);
		}

		return multiReferenceOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiReferenceMoveOperationItemProvider multiReferenceMoveOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceMoveOperationAdapter() {
		if (multiReferenceMoveOperationItemProvider == null) {
			multiReferenceMoveOperationItemProvider = new MultiReferenceMoveOperationItemProvider(
					this);
		}

		return multiReferenceMoveOperationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(
			ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class)
					|| (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (compositeOperationItemProvider != null)
			compositeOperationItemProvider.dispose();
		if (createDeleteOperationItemProvider != null)
			createDeleteOperationItemProvider.dispose();
		if (attributeOperationItemProvider != null)
			attributeOperationItemProvider.dispose();
		if (singleReferenceOperationItemProvider != null)
			singleReferenceOperationItemProvider.dispose();
		if (multiReferenceOperationItemProvider != null)
			multiReferenceOperationItemProvider.dispose();
		if (multiReferenceMoveOperationItemProvider != null)
			multiReferenceMoveOperationItemProvider.dispose();
	}

}
