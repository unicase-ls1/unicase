/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.provider;

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
import org.unicase.emfstore.esmodel.util.EsmodelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EsmodelItemProviderAdapterFactory extends EsmodelAdapterFactory implements ComposeableAdapterFactory,
	IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EsmodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.ProjectHistory} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectHistoryItemProvider projectHistoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.ProjectHistory}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createProjectHistoryAdapter() {
		if (projectHistoryItemProvider == null) {
			projectHistoryItemProvider = new ProjectHistoryItemProvider(this);
		}

		return projectHistoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.ProjectInfo} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectInfoItemProvider projectInfoItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.ProjectInfo}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createProjectInfoAdapter() {
		if (projectInfoItemProvider == null) {
			projectInfoItemProvider = new ProjectInfoItemProvider(this);
		}

		return projectInfoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.SessionId} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SessionIdItemProvider sessionIdItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.SessionId}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createSessionIdAdapter() {
		if (sessionIdItemProvider == null) {
			sessionIdItemProvider = new SessionIdItemProvider(this);
		}

		return sessionIdItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.ServerSpace} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServerSpaceItemProvider serverSpaceItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.ServerSpace}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createServerSpaceAdapter() {
		if (serverSpaceItemProvider == null) {
			serverSpaceItemProvider = new ServerSpaceItemProvider(this);
		}

		return serverSpaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.ProjectId} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectIdItemProvider projectIdItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.ProjectId}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createProjectIdAdapter() {
		if (projectIdItemProvider == null) {
			projectIdItemProvider = new ProjectIdItemProvider(this);
		}

		return projectIdItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.VersionInfo} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VersionInfoItemProvider versionInfoItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.VersionInfo}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createVersionInfoAdapter() {
		if (versionInfoItemProvider == null) {
			versionInfoItemProvider = new VersionInfoItemProvider(this);
		}

		return versionInfoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.ClientVersionInfo}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClientVersionInfoItemProvider clientVersionInfoItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.ClientVersionInfo}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createClientVersionInfoAdapter() {
		if (clientVersionInfoItemProvider == null) {
			clientVersionInfoItemProvider = new ClientVersionInfoItemProvider(this);
		}

		return clientVersionInfoItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (projectHistoryItemProvider != null)
			projectHistoryItemProvider.dispose();
		if (projectInfoItemProvider != null)
			projectInfoItemProvider.dispose();
		if (sessionIdItemProvider != null)
			sessionIdItemProvider.dispose();
		if (serverSpaceItemProvider != null)
			serverSpaceItemProvider.dispose();
		if (projectIdItemProvider != null)
			projectIdItemProvider.dispose();
		if (versionInfoItemProvider != null)
			versionInfoItemProvider.dispose();
		if (clientVersionInfoItemProvider != null)
			clientVersionInfoItemProvider.dispose();
	}

}
