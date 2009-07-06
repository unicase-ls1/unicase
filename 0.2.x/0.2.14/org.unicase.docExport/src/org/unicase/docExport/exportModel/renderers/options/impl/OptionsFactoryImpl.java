/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.docExport.exportModel.renderers.options.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptionsFactoryImpl extends EFactoryImpl implements OptionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptionsFactory init() {
		try {
			OptionsFactory theOptionsFactory = (OptionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/docExport/exportModel/renderers/options"); 
			if (theOptionsFactory != null) {
				return theOptionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OptionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION: return createSingleReferenceAttributeOption();
			case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION: return createMultiReferenceAttributeOption();
			case OptionsPackage.REFERENCE_OPTION: return createReferenceOption();
			case OptionsPackage.STRING_ATTRIBUTE_OPTION: return createStringAttributeOption();
			case OptionsPackage.LAYOUT_OPTIONS: return createLayoutOptions();
			case OptionsPackage.LIST_OPTION: return createListOption();
			case OptionsPackage.TEXT_OPTION: return createTextOption();
			case OptionsPackage.UCOLOR: return createUColor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OptionsPackage.FONT_FAMILY:
				return createFontFamilyFromString(eDataType, initialValue);
			case OptionsPackage.LIST_STYLE:
				return createListStyleFromString(eDataType, initialValue);
			case OptionsPackage.PAGE_NUMBERING_STYLE:
				return createPageNumberingStyleFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OptionsPackage.FONT_FAMILY:
				return convertFontFamilyToString(eDataType, instanceValue);
			case OptionsPackage.LIST_STYLE:
				return convertListStyleToString(eDataType, instanceValue);
			case OptionsPackage.PAGE_NUMBERING_STYLE:
				return convertPageNumberingStyleToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleReferenceAttributeOption createSingleReferenceAttributeOption() {
		SingleReferenceAttributeOptionImpl singleReferenceAttributeOption = new SingleReferenceAttributeOptionImpl();
		return singleReferenceAttributeOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiReferenceAttributeOption createMultiReferenceAttributeOption() {
		MultiReferenceAttributeOptionImpl multiReferenceAttributeOption = new MultiReferenceAttributeOptionImpl();
		return multiReferenceAttributeOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceOption createReferenceOption() {
		ReferenceOptionImpl referenceOption = new ReferenceOptionImpl();
		return referenceOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAttributeOption createStringAttributeOption() {
		StringAttributeOptionImpl stringAttributeOption = new StringAttributeOptionImpl();
		return stringAttributeOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutOptions createLayoutOptions() {
		LayoutOptionsImpl layoutOptions = new LayoutOptionsImpl();
		return layoutOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOption createListOption() {
		ListOptionImpl listOption = new ListOptionImpl();
		return listOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption createTextOption() {
		TextOptionImpl textOption = new TextOptionImpl();
		return textOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UColor createUColor() {
		UColorImpl uColor = new UColorImpl();
		return uColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontFamily createFontFamilyFromString(EDataType eDataType, String initialValue) {
		FontFamily result = FontFamily.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFontFamilyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListStyle createListStyleFromString(EDataType eDataType, String initialValue) {
		ListStyle result = ListStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageNumberingStyle createPageNumberingStyleFromString(EDataType eDataType, String initialValue) {
		PageNumberingStyle result = PageNumberingStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPageNumberingStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsPackage getOptionsPackage() {
		return (OptionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OptionsPackage getPackage() {
		return OptionsPackage.eINSTANCE;
	}

} //OptionsFactoryImpl
