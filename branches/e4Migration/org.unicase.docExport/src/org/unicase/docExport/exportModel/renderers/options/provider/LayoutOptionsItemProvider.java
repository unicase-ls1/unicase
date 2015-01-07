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
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class LayoutOptionsItemProvider extends RendererOptionItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LayoutOptionsItemProvider(AdapterFactory adapterFactory) {
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

			addHideAnnotationsPropertyDescriptor(object);
			addHideAttachmentsPropertyDescriptor(object);
			addHideIncomingDocumentReferencesPropertyDescriptor(object);
			addHideModelElementImagesPropertyDescriptor(object);
			addHeaderTextPropertyDescriptor(object);
			addFooterTextPropertyDescriptor(object);
			addSectionOptionPropertyDescriptor(object);
			addSectionFontSizeDecreaseStepPropertyDescriptor(object);
			addShowModelElementTypeInSectionTitlePropertyDescriptor(object);
			addAppendixStylePropertyDescriptor(object);
			addLogoImagePropertyDescriptor(object);
			addFooterShowDocumentTitlePropertyDescriptor(object);
			addPageCitationStylePropertyDescriptor(object);
			addHeaderStylePropertyDescriptor(object);
			addLogoWidthPropertyDescriptor(object);
			addLogoHeightPropertyDescriptor(object);
			addLogoOnCoverPagePropertyDescriptor(object);
			addHideTableOfContentsPropertyDescriptor(object);
			addHideHeaderAndFooterOnCoverPagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hide Annotations feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHideAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_hideAnnotations_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideAnnotations_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_ANNOTATIONS, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hide Attachments feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHideAttachmentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_hideAttachments_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideAttachments_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_ATTACHMENTS, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hide Incoming Document References feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHideIncomingDocumentReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_hideIncomingDocumentReferences_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideIncomingDocumentReferences_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES,
			true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hide Model Element Images feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHideModelElementImagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_hideModelElementImages_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideModelElementImages_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES, true,
			false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Header Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHeaderTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_headerText_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_headerText_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HEADER_TEXT, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Footer Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFooterTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_footerText_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_footerText_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__FOOTER_TEXT, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Section Option feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSectionOptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_sectionOption_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_sectionOption_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__SECTION_OPTION, true, false, true,
			null, null, null));
	}

	/**
	 * This adds a property descriptor for the Section Font Size Decrease Step feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSectionFontSizeDecreaseStepPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_sectionFontSizeDecreaseStep_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_sectionFontSizeDecreaseStep_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP,
			true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Show Model Element Type In Section Title feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addShowModelElementTypeInSectionTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_showModelElementTypeInSectionTitle_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_showModelElementTypeInSectionTitle_feature",
				"_UI_LayoutOptions_type"),
			OptionsPackage.Literals.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Appendix Style feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAppendixStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_appendixStyle_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_appendixStyle_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__APPENDIX_STYLE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Logo Image feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLogoImagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_logoImage_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_logoImage_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__LOGO_IMAGE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Footer Show Document Title feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFooterShowDocumentTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_footerShowDocumentTitle_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_footerShowDocumentTitle_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE, true,
			false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Page Citation Style feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addPageCitationStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_pageCitationStyle_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_pageCitationStyle_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__PAGE_CITATION_STYLE, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Header Style feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHeaderStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_headerStyle_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_headerStyle_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HEADER_STYLE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Logo Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLogoWidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_logoWidth_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_logoWidth_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__LOGO_WIDTH, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Logo Height feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLogoHeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_logoHeight_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_logoHeight_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__LOGO_HEIGHT, true, false, false,
			ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Logo On Cover Page feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLogoOnCoverPagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_logoOnCoverPage_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_logoOnCoverPage_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hide Table Of Contents feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addHideTableOfContentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_LayoutOptions_hideTableOfContents_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideTableOfContents_feature",
				"_UI_LayoutOptions_type"), OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Hide Header And Footer On Cover Page feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHideHeaderAndFooterOnCoverPagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_LayoutOptions_hideHeaderAndFooterOnCoverPage_feature"), getString(
				"_UI_PropertyDescriptor_description", "_UI_LayoutOptions_hideHeaderAndFooterOnCoverPage_feature",
				"_UI_LayoutOptions_type"),
			OptionsPackage.Literals.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE, true, false, false,
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
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__HEADER_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__SECTION_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION);
			childrenFeatures.add(OptionsPackage.Literals.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION);
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
	 * This returns LayoutOptions.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LayoutOptions"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LayoutOptions) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_LayoutOptions_type")
			: getString("_UI_LayoutOptions_type") + " " + label;
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

		switch (notification.getFeatureID(LayoutOptions.class)) {
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
		case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT:
		case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT:
		case OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP:
		case OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE:
		case OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE:
		case OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE:
		case OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE:
		case OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE:
		case OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE:
		case OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH:
		case OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT:
		case OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE:
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS:
		case OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
		case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
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

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.LAYOUT_OPTIONS__HEADER_TEXT_OPTION,
			OptionsFactory.eINSTANCE.createTextOption()));

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION,
			OptionsFactory.eINSTANCE.createTextOption()));

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.LAYOUT_OPTIONS__SECTION_TEXT_OPTION,
			OptionsFactory.eINSTANCE.createTextOption()));

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION,
			OptionsFactory.eINSTANCE.createTextOption()));

		newChildDescriptors.add(createChildParameter(
			OptionsPackage.Literals.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION, OptionsFactory.eINSTANCE
				.createTextOption()));

		newChildDescriptors.add(createChildParameter(OptionsPackage.Literals.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION,
			OptionsFactory.eINSTANCE.createTextOption()));

		newChildDescriptors.add(createChildParameter(
			OptionsPackage.Literals.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION, OptionsFactory.eINSTANCE
				.createTextOption()));
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

		boolean qualify = childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__HEADER_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__SECTION_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION
			|| childFeature == OptionsPackage.Literals.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
