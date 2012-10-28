/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.provider;

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
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class BoxModelOptionItemProvider extends RendererOptionItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BoxModelOptionItemProvider(AdapterFactory adapterFactory) {
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

			addMarginPropertyDescriptor(object);
			addMarginTopPropertyDescriptor(object);
			addMarginLeftPropertyDescriptor(object);
			addMarginBottomPropertyDescriptor(object);
			addMarginRightPropertyDescriptor(object);
			addBorderPropertyDescriptor(object);
			addBorderTopPropertyDescriptor(object);
			addBorderLeftPropertyDescriptor(object);
			addBorderBottomPropertyDescriptor(object);
			addBorderRightPropertyDescriptor(object);
			addBorderStylePropertyDescriptor(object);
			addPaddingPropertyDescriptor(object);
			addPaddingTopPropertyDescriptor(object);
			addPaddingLeftPropertyDescriptor(object);
			addPaddingBottomPropertyDescriptor(object);
			addPaddingRightPropertyDescriptor(object);
			addBackgroundColorPropertyDescriptor(object);
			addKeepTogetherPropertyDescriptor(object);
			addKeepWithPreviousPropertyDescriptor(object);
			addKeepWithNextPropertyDescriptor(object);
			addBreakBeforePropertyDescriptor(object);
			addWidthPropertyDescriptor(object);
			addBreakAfterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Margin feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarginPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_margin_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_BoxModelOption_margin_feature", "_UI_BoxModelOption_type"),
			OptionsPackage.Literals.BOX_MODEL_OPTION__MARGIN, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Margin Top feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarginTopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_marginTop_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_marginTop_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__MARGIN_TOP, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Margin Left feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarginLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_marginLeft_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_marginLeft_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__MARGIN_LEFT, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Margin Bottom feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarginBottomPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_marginBottom_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_marginBottom_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__MARGIN_BOTTOM, true, false,
			false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Margin Right feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMarginRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_marginRight_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_marginRight_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__MARGIN_RIGHT, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_border_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_BoxModelOption_border_feature", "_UI_BoxModelOption_type"),
			OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border Top feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderTopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_borderTop_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_borderTop_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_TOP, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border Left feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_borderLeft_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_borderLeft_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_LEFT, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border Bottom feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderBottomPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_borderBottom_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_borderBottom_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_BOTTOM, true, false,
			false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border Right feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_borderRight_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_borderRight_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_RIGHT, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Border Style feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_borderStyle_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_borderStyle_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_STYLE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Padding feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPaddingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_padding_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_BoxModelOption_padding_feature", "_UI_BoxModelOption_type"),
			OptionsPackage.Literals.BOX_MODEL_OPTION__PADDING, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Padding Top feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPaddingTopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_paddingTop_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_paddingTop_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__PADDING_TOP, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Padding Left feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPaddingLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_paddingLeft_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_paddingLeft_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__PADDING_LEFT, true, false, false,
			ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Padding Bottom feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPaddingBottomPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_paddingBottom_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_paddingBottom_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__PADDING_BOTTOM, true, false,
			false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Padding Right feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPaddingRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_paddingRight_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_paddingRight_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__PADDING_RIGHT, true, false,
			false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Background Color feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBackgroundColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_backgroundColor_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_backgroundColor_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BACKGROUND_COLOR, true, false,
			true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Keep Together feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addKeepTogetherPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_keepTogether_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_keepTogether_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__KEEP_TOGETHER, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Keep With Previous feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addKeepWithPreviousPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_keepWithPrevious_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_keepWithPrevious_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Keep With Next feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addKeepWithNextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_keepWithNext_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_keepWithNext_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__KEEP_WITH_NEXT, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Break Before feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBreakBeforePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_breakBefore_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_breakBefore_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BREAK_BEFORE, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addWidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_width_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_BoxModelOption_width_feature", "_UI_BoxModelOption_type"),
			OptionsPackage.Literals.BOX_MODEL_OPTION__WIDTH, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Break After feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBreakAfterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_BoxModelOption_breakAfter_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_BoxModelOption_breakAfter_feature",
				"_UI_BoxModelOption_type"), OptionsPackage.Literals.BOX_MODEL_OPTION__BREAK_AFTER, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_COLOR);
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
	 * This returns BoxModelOption.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BoxModelOption"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BoxModelOption) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_BoxModelOption_type")
			: getString("_UI_BoxModelOption_type") + " " + label;
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

		switch (notification.getFeatureID(BoxModelOption.class)) {
		case OptionsPackage.BOX_MODEL_OPTION__MARGIN:
		case OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP:
		case OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT:
		case OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM:
		case OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT:
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE:
		case OptionsPackage.BOX_MODEL_OPTION__PADDING:
		case OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP:
		case OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT:
		case OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM:
		case OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT:
		case OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER:
		case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS:
		case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT:
		case OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE:
		case OptionsPackage.BOX_MODEL_OPTION__WIDTH:
		case OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
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

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.BOX_MODEL_OPTION__BORDER_COLOR,
			OptionsFactory.eINSTANCE.createUColor()));
	}

}
