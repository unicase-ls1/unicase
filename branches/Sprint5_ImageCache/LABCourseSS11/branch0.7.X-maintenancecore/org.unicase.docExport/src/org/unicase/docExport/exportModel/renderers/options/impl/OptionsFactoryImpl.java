/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanStyle;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateStyle;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OptionsFactoryImpl extends EFactoryImpl implements OptionsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OptionsFactory init() {
		try {
			OptionsFactory theOptionsFactory = (OptionsFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/docExport/exportModel/renderers/options");
			if (theOptionsFactory != null) {
				return theOptionsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OptionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OptionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION:
			return createSingleReferenceAttributeOption();
		case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION:
			return createMultiReferenceAttributeOption();
		case OptionsPackage.REFERENCE_OPTION:
			return createReferenceOption();
		case OptionsPackage.STRING_ATTRIBUTE_OPTION:
			return createStringAttributeOption();
		case OptionsPackage.LAYOUT_OPTIONS:
			return createLayoutOptions();
		case OptionsPackage.LIST_OPTION:
			return createListOption();
		case OptionsPackage.TEXT_OPTION:
			return createTextOption();
		case OptionsPackage.UCOLOR:
			return createUColor();
		case OptionsPackage.BOX_MODEL_OPTION:
			return createBoxModelOption();
		case OptionsPackage.SECTION_OPTION:
			return createSectionOption();
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION:
			return createBooleanAttributeOption();
		case OptionsPackage.DATE_ATTRIBUTE_OPTION:
			return createDateAttributeOption();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case OptionsPackage.PAGE_CITATION_STYLE:
			return createPageCitationStyleFromString(eDataType, initialValue);
		case OptionsPackage.HEADER_STYLE:
			return createHeaderStyleFromString(eDataType, initialValue);
		case OptionsPackage.APPENDIX_STYLE:
			return createAppendixStyleFromString(eDataType, initialValue);
		case OptionsPackage.FONT_FAMILY:
			return createFontFamilyFromString(eDataType, initialValue);
		case OptionsPackage.LIST_STYLE:
			return createListStyleFromString(eDataType, initialValue);
		case OptionsPackage.UBORDER_STYLE:
			return createUBorderStyleFromString(eDataType, initialValue);
		case OptionsPackage.SECTION_NUMBERING_STYLE:
			return createSectionNumberingStyleFromString(eDataType, initialValue);
		case OptionsPackage.TEXT_ALIGN:
			return createTextAlignFromString(eDataType, initialValue);
		case OptionsPackage.BOOLEAN_STYLE:
			return createBooleanStyleFromString(eDataType, initialValue);
		case OptionsPackage.DATE_STYLE:
			return createDateStyleFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case OptionsPackage.PAGE_CITATION_STYLE:
			return convertPageCitationStyleToString(eDataType, instanceValue);
		case OptionsPackage.HEADER_STYLE:
			return convertHeaderStyleToString(eDataType, instanceValue);
		case OptionsPackage.APPENDIX_STYLE:
			return convertAppendixStyleToString(eDataType, instanceValue);
		case OptionsPackage.FONT_FAMILY:
			return convertFontFamilyToString(eDataType, instanceValue);
		case OptionsPackage.LIST_STYLE:
			return convertListStyleToString(eDataType, instanceValue);
		case OptionsPackage.UBORDER_STYLE:
			return convertUBorderStyleToString(eDataType, instanceValue);
		case OptionsPackage.SECTION_NUMBERING_STYLE:
			return convertSectionNumberingStyleToString(eDataType, instanceValue);
		case OptionsPackage.TEXT_ALIGN:
			return convertTextAlignToString(eDataType, instanceValue);
		case OptionsPackage.BOOLEAN_STYLE:
			return convertBooleanStyleToString(eDataType, instanceValue);
		case OptionsPackage.DATE_STYLE:
			return convertDateStyleToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleReferenceAttributeOption createSingleReferenceAttributeOption() {
		SingleReferenceAttributeOptionImpl singleReferenceAttributeOption = new SingleReferenceAttributeOptionImpl();
		return singleReferenceAttributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceAttributeOption createMultiReferenceAttributeOption() {
		MultiReferenceAttributeOptionImpl multiReferenceAttributeOption = new MultiReferenceAttributeOptionImpl();
		return multiReferenceAttributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceOption createReferenceOption() {
		ReferenceOptionImpl referenceOption = new ReferenceOptionImpl();
		return referenceOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringAttributeOption createStringAttributeOption() {
		StringAttributeOptionImpl stringAttributeOption = new StringAttributeOptionImpl();
		return stringAttributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LayoutOptions createLayoutOptions() {
		LayoutOptionsImpl layoutOptions = new LayoutOptionsImpl();
		return layoutOptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ListOption createListOption() {
		ListOptionImpl listOption = new ListOptionImpl();
		return listOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TextOption createTextOption() {
		TextOptionImpl textOption = new TextOptionImpl();
		return textOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UColor createUColor() {
		UColorImpl uColor = new UColorImpl();
		return uColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BoxModelOption createBoxModelOption() {
		BoxModelOptionImpl boxModelOption = new BoxModelOptionImpl();
		return boxModelOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SectionOption createSectionOption() {
		SectionOptionImpl sectionOption = new SectionOptionImpl();
		return sectionOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanAttributeOption createBooleanAttributeOption() {
		BooleanAttributeOptionImpl booleanAttributeOption = new BooleanAttributeOptionImpl();
		return booleanAttributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DateAttributeOption createDateAttributeOption() {
		DateAttributeOptionImpl dateAttributeOption = new DateAttributeOptionImpl();
		return dateAttributeOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PageCitationStyle createPageCitationStyleFromString(EDataType eDataType, String initialValue) {
		PageCitationStyle result = PageCitationStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertPageCitationStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HeaderStyle createHeaderStyleFromString(EDataType eDataType, String initialValue) {
		HeaderStyle result = HeaderStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertHeaderStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AppendixStyle createAppendixStyleFromString(EDataType eDataType, String initialValue) {
		AppendixStyle result = AppendixStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertAppendixStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FontFamily createFontFamilyFromString(EDataType eDataType, String initialValue) {
		FontFamily result = FontFamily.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFontFamilyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ListStyle createListStyleFromString(EDataType eDataType, String initialValue) {
		ListStyle result = ListStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertListStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UBorderStyle createUBorderStyleFromString(EDataType eDataType, String initialValue) {
		UBorderStyle result = UBorderStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUBorderStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SectionNumberingStyle createSectionNumberingStyleFromString(EDataType eDataType, String initialValue) {
		SectionNumberingStyle result = SectionNumberingStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertSectionNumberingStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TextAlign createTextAlignFromString(EDataType eDataType, String initialValue) {
		TextAlign result = TextAlign.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTextAlignToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanStyle createBooleanStyleFromString(EDataType eDataType, String initialValue) {
		BooleanStyle result = BooleanStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBooleanStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DateStyle createDateStyleFromString(EDataType eDataType, String initialValue) {
		DateStyle result = DateStyle.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDateStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OptionsPackage getOptionsPackage() {
		return (OptionsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OptionsPackage getPackage() {
		return OptionsPackage.eINSTANCE;
	}

} // OptionsFactoryImpl
