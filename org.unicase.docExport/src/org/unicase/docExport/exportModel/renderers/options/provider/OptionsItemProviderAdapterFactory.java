/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.provider;

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
import org.unicase.docExport.exportModel.renderers.options.util.OptionsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class OptionsItemProviderAdapterFactory extends OptionsAdapterFactory implements ComposeableAdapterFactory,
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
	public OptionsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SingleReferenceAttributeOptionItemProvider singleReferenceAttributeOptionItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createSingleReferenceAttributeOptionAdapter() {
		if (singleReferenceAttributeOptionItemProvider == null) {
			singleReferenceAttributeOptionItemProvider = new SingleReferenceAttributeOptionItemProvider(this);
		}

		return singleReferenceAttributeOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceAttributeOptionItemProvider multiReferenceAttributeOptionItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceAttributeOptionAdapter() {
		if (multiReferenceAttributeOptionItemProvider == null) {
			multiReferenceAttributeOptionItemProvider = new MultiReferenceAttributeOptionItemProvider(this);
		}

		return multiReferenceAttributeOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReferenceOptionItemProvider referenceOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createReferenceOptionAdapter() {
		if (referenceOptionItemProvider == null) {
			referenceOptionItemProvider = new ReferenceOptionItemProvider(this);
		}

		return referenceOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StringAttributeOptionItemProvider stringAttributeOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createStringAttributeOptionAdapter() {
		if (stringAttributeOptionItemProvider == null) {
			stringAttributeOptionItemProvider = new StringAttributeOptionItemProvider(this);
		}

		return stringAttributeOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected LayoutOptionsItemProvider layoutOptionsItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createLayoutOptionsAdapter() {
		if (layoutOptionsItemProvider == null) {
			layoutOptionsItemProvider = new LayoutOptionsItemProvider(this);
		}

		return layoutOptionsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.ListOption} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ListOptionItemProvider listOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.ListOption}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createListOptionAdapter() {
		if (listOptionItemProvider == null) {
			listOptionItemProvider = new ListOptionItemProvider(this);
		}

		return listOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TextOptionItemProvider textOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.TextOption}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTextOptionAdapter() {
		if (textOptionItemProvider == null) {
			textOptionItemProvider = new TextOptionItemProvider(this);
		}

		return textOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.UColor} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected UColorItemProvider uColorItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.UColor}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createUColorAdapter() {
		if (uColorItemProvider == null) {
			uColorItemProvider = new UColorItemProvider(this);
		}

		return uColorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BoxModelOptionItemProvider boxModelOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBoxModelOptionAdapter() {
		if (boxModelOptionItemProvider == null) {
			boxModelOptionItemProvider = new BoxModelOptionItemProvider(this);
		}

		return boxModelOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.SectionOption} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected SectionOptionItemProvider sectionOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.SectionOption}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createSectionOptionAdapter() {
		if (sectionOptionItemProvider == null) {
			sectionOptionItemProvider = new SectionOptionItemProvider(this);
		}

		return sectionOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BooleanAttributeOptionItemProvider booleanAttributeOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBooleanAttributeOptionAdapter() {
		if (booleanAttributeOptionItemProvider == null) {
			booleanAttributeOptionItemProvider = new BooleanAttributeOptionItemProvider(this);
		}

		return booleanAttributeOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DateAttributeOptionItemProvider dateAttributeOptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createDateAttributeOptionAdapter() {
		if (dateAttributeOptionItemProvider == null) {
			dateAttributeOptionItemProvider = new DateAttributeOptionItemProvider(this);
		}

		return dateAttributeOptionItemProvider;
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
		if (singleReferenceAttributeOptionItemProvider != null)
			singleReferenceAttributeOptionItemProvider.dispose();
		if (multiReferenceAttributeOptionItemProvider != null)
			multiReferenceAttributeOptionItemProvider.dispose();
		if (referenceOptionItemProvider != null)
			referenceOptionItemProvider.dispose();
		if (stringAttributeOptionItemProvider != null)
			stringAttributeOptionItemProvider.dispose();
		if (layoutOptionsItemProvider != null)
			layoutOptionsItemProvider.dispose();
		if (listOptionItemProvider != null)
			listOptionItemProvider.dispose();
		if (textOptionItemProvider != null)
			textOptionItemProvider.dispose();
		if (uColorItemProvider != null)
			uColorItemProvider.dispose();
		if (boxModelOptionItemProvider != null)
			boxModelOptionItemProvider.dispose();
		if (sectionOptionItemProvider != null)
			sectionOptionItemProvider.dispose();
		if (booleanAttributeOptionItemProvider != null)
			booleanAttributeOptionItemProvider.dispose();
		if (dateAttributeOptionItemProvider != null)
			dateAttributeOptionItemProvider.dispose();
	}

}
