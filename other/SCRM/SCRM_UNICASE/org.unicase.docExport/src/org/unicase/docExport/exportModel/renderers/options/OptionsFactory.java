/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage
 * @generated
 */
public interface OptionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OptionsFactory eINSTANCE = org.unicase.docExport.exportModel.renderers.options.impl.OptionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Single Reference Attribute Option</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Single Reference Attribute Option</em>'.
	 * @generated
	 */
	SingleReferenceAttributeOption createSingleReferenceAttributeOption();

	/**
	 * Returns a new object of class '<em>Multi Reference Attribute Option</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Multi Reference Attribute Option</em>'.
	 * @generated
	 */
	MultiReferenceAttributeOption createMultiReferenceAttributeOption();

	/**
	 * Returns a new object of class '<em>Reference Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Option</em>'.
	 * @generated
	 */
	ReferenceOption createReferenceOption();

	/**
	 * Returns a new object of class '<em>String Attribute Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>String Attribute Option</em>'.
	 * @generated
	 */
	StringAttributeOption createStringAttributeOption();

	/**
	 * Returns a new object of class '<em>Layout Options</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout Options</em>'.
	 * @generated
	 */
	LayoutOptions createLayoutOptions();

	/**
	 * Returns a new object of class '<em>List Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>List Option</em>'.
	 * @generated
	 */
	ListOption createListOption();

	/**
	 * Returns a new object of class '<em>Text Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Option</em>'.
	 * @generated
	 */
	TextOption createTextOption();

	/**
	 * Returns a new object of class '<em>UColor</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>UColor</em>'.
	 * @generated
	 */
	UColor createUColor();

	/**
	 * Returns a new object of class '<em>Box Model Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Box Model Option</em>'.
	 * @generated
	 */
	BoxModelOption createBoxModelOption();

	/**
	 * Returns a new object of class '<em>Section Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Section Option</em>'.
	 * @generated
	 */
	SectionOption createSectionOption();

	/**
	 * Returns a new object of class '<em>Boolean Attribute Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Attribute Option</em>'.
	 * @generated
	 */
	BooleanAttributeOption createBooleanAttributeOption();

	/**
	 * Returns a new object of class '<em>Date Attribute Option</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Date Attribute Option</em>'.
	 * @generated
	 */
	DateAttributeOption createDateAttributeOption();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OptionsPackage getOptionsPackage();

} // OptionsFactory
