/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Font Family</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getFontFamily()
 * @model
 * @generated
 */
public enum FontFamily implements Enumerator {
	/**
	 * The '<em><b>SANS SERIF</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SANS_SERIF_VALUE
	 * @generated
	 * @ordered
	 */
	SANS_SERIF(0, "SANS_SERIF", "sans-serif"), /**
	 * The '<em><b>SERIF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERIF_VALUE
	 * @generated
	 * @ordered
	 */
	SERIF(1, "SERIF", "serif"), /**
	 * The '<em><b>TIMES NEW ROMAN</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #TIMES_NEW_ROMAN_VALUE
	 * @generated
	 * @ordered
	 */
	TIMES_NEW_ROMAN(2, "TIMES_NEW_ROMAN", "Times"), /**
	 * The '<em><b>HELVETICA</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #HELVETICA_VALUE
	 * @generated
	 * @ordered
	 */
	HELVETICA(3, "HELVETICA", "Helvetica"), /**
	 * The '<em><b>COURIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COURIER_VALUE
	 * @generated
	 * @ordered
	 */
	COURIER(4, "COURIER", "Courier");

	/**
	 * The '<em><b>SANS SERIF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SANS SERIF</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SANS_SERIF
	 * @model literal="sans-serif"
	 * @generated
	 * @ordered
	 */
	public static final int SANS_SERIF_VALUE = 0;

	/**
	 * The '<em><b>SERIF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERIF</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERIF
	 * @model literal="serif"
	 * @generated
	 * @ordered
	 */
	public static final int SERIF_VALUE = 1;

	/**
	 * The '<em><b>TIMES NEW ROMAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMES NEW ROMAN</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMES_NEW_ROMAN
	 * @model literal="Times"
	 * @generated
	 * @ordered
	 */
	public static final int TIMES_NEW_ROMAN_VALUE = 2;

	/**
	 * The '<em><b>HELVETICA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HELVETICA</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HELVETICA
	 * @model literal="Helvetica"
	 * @generated
	 * @ordered
	 */
	public static final int HELVETICA_VALUE = 3;

	/**
	 * The '<em><b>COURIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COURIER</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COURIER
	 * @model literal="Courier"
	 * @generated
	 * @ordered
	 */
	public static final int COURIER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Font Family</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final FontFamily[] VALUES_ARRAY = new FontFamily[] {
			SANS_SERIF,
			SERIF,
			TIMES_NEW_ROMAN,
			HELVETICA,
			COURIER,
		};

	/**
	 * A public read-only list of all the '<em><b>Font Family</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<FontFamily> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static FontFamily get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontFamily result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static FontFamily getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontFamily result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static FontFamily get(int value) {
		switch (value) {
			case SANS_SERIF_VALUE: return SANS_SERIF;
			case SERIF_VALUE: return SERIF;
			case TIMES_NEW_ROMAN_VALUE: return TIMES_NEW_ROMAN;
			case HELVETICA_VALUE: return HELVETICA;
			case COURIER_VALUE: return COURIER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private FontFamily(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // FontFamily
