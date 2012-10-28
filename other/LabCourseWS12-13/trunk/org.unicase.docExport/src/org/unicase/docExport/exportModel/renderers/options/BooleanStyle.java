/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Boolean Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBooleanStyle()
 * @model
 * @generated
 */
public enum BooleanStyle implements Enumerator {
	/**
	 * The '<em><b>IMAGE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
	IMAGE(0, "IMAGE", "image"),

	/**
	 * The '<em><b>YES NO</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #YES_NO_VALUE
	 * @generated
	 * @ordered
	 */
	YES_NO(0, "YES_NO", "yes_no"),

	/**
	 * The '<em><b>TRUE FALSE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TRUE_FALSE_VALUE
	 * @generated
	 * @ordered
	 */
	TRUE_FALSE(0, "TRUE_FALSE", "true_false"),

	/**
	 * The '<em><b>NUMBERS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMBERS_VALUE
	 * @generated
	 * @ordered
	 */
	NUMBERS(0, "NUMBERS", "numbers");

	/**
	 * The '<em><b>IMAGE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMAGE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #IMAGE
	 * @model literal="image"
	 * @generated
	 * @ordered
	 */
	public static final int IMAGE_VALUE = 0;

	/**
	 * The '<em><b>YES NO</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>YES NO</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #YES_NO
	 * @model literal="yes_no"
	 * @generated
	 * @ordered
	 */
	public static final int YES_NO_VALUE = 0;

	/**
	 * The '<em><b>TRUE FALSE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRUE FALSE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TRUE_FALSE
	 * @model literal="true_false"
	 * @generated
	 * @ordered
	 */
	public static final int TRUE_FALSE_VALUE = 0;

	/**
	 * The '<em><b>NUMBERS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMBERS</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMBERS
	 * @model literal="numbers"
	 * @generated
	 * @ordered
	 */
	public static final int NUMBERS_VALUE = 0;

	/**
	 * An array of all the '<em><b>Boolean Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final BooleanStyle[] VALUES_ARRAY = new BooleanStyle[] { IMAGE, YES_NO, TRUE_FALSE, NUMBERS, };

	/**
	 * A public read-only list of all the '<em><b>Boolean Style</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<BooleanStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Boolean Style</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BooleanStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BooleanStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Boolean Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static BooleanStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BooleanStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Boolean Style</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BooleanStyle get(int value) {
		switch (value) {
		case IMAGE_VALUE:
			return IMAGE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private BooleanStyle(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // BooleanStyle
