/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.provider;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.docExport.exportModel.provider.ExportModelEditPlugin;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ModelElementRendererItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementRendererItemProvider(AdapterFactory adapterFactory) {
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

			addTemplatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Template feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElementRenderer_template_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ModelElementRenderer_template_feature",
				"_UI_ModelElementRenderer_type"), RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__TEMPLATE, true,
			false, true, null, null, null));
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
			childrenFeatures.add(RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS);
			childrenFeatures.add(RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING);
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
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ModelElementRenderer_type");
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

		switch (notification.getFeatureID(ModelElementRenderer.class)) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
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

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createSingleReferenceAttributeOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createMultiReferenceAttributeOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createReferenceOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createStringAttributeOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createLayoutOptions()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createListOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createTextOption()));

		newChildDescriptors
			.add(createChildParameter(RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS,
				OptionsFactory.eINSTANCE.createUColor()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createBoxModelOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createSectionOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createBooleanAttributeOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS, OptionsFactory.eINSTANCE
				.createDateAttributeOption()));

		newChildDescriptors.add(createChildParameter(
			RenderersPackage.Literals.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING, RenderersFactory.eINSTANCE
				.createAttributeRendererMapping()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ExportModelEditPlugin.INSTANCE;
	}

}
