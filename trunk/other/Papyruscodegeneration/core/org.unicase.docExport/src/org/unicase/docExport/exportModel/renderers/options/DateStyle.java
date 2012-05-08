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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Date Style</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getDateStyle()
 * @model
 * @generated
 */
public enum DateStyle implements Enumerator {
	/**
	 * The '<em><b>NICE1</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NICE1_VALUE
	 * @generated
	 * @ordered
	 */
	NICE1(0, "NICE1", "NICE1"),

	/**
	 * The '<em><b>FULL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #FULL_VALUE
	 * @generated
	 * @ordered
	 */
	FULL(1, "FULL", "FULL"),

	/**
	 * The '<em><b>NUMERIC TIME WITH SECONDS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_TIME_WITH_SECONDS_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_TIME_WITH_SECONDS(2, "NUMERIC_TIME_WITH_SECONDS", "NUMERIC_TIME_WITH_SECONDS"),

	/**
	 * The '<em><b>NUMERIC TIME</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_TIME(3, "NUMERIC_TIME", "NUMERIC_TIME"),

	/**
	 * The '<em><b>NUMERIC DAY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_DAY_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_DAY(4, "NUMERIC_DAY", "NUMERIC_DAY"),

	/**
	 * The '<em><b>NUMERIC MONTH</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_MONTH_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_MONTH(5, "NUMERIC_MONTH", "NUMERIC_MONTH"),

	/**
	 * The '<em><b>NUMERIC YEAR</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_YEAR_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_YEAR(6, "NUMERIC_YEAR", "NUMERIC_YEAR");

	/**
	 * The '<em><b>NICE1</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NICE1</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NICE1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NICE1_VALUE = 0;

	/**
	 * The '<em><b>FULL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FULL</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FULL_VALUE = 1;

	/**
	 * The '<em><b>NUMERIC TIME WITH SECONDS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMERIC TIME WITH SECONDS</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_TIME_WITH_SECONDS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_TIME_WITH_SECONDS_VALUE = 2;

	/**
	 * The '<em><b>NUMERIC TIME</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMERIC TIME</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_TIME_VALUE = 3;

	/**
	 * The '<em><b>NUMERIC DAY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMERIC DAY</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_DAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_DAY_VALUE = 4;

	/**
	 * The '<em><b>NUMERIC MONTH</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMERIC MONTH</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_MONTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_MONTH_VALUE = 5;

	/**
	 * The '<em><b>NUMERIC YEAR</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMERIC YEAR</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NUMERIC_YEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_YEAR_VALUE = 6;

	/**
	 * An array of all the '<em><b>Date Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DateStyle[] VALUES_ARRAY = new DateStyle[] { NICE1, FULL, NUMERIC_TIME_WITH_SECONDS,
		NUMERIC_TIME, NUMERIC_DAY, NUMERIC_MONTH, NUMERIC_YEAR, };

	/**
	 * A public read-only list of all the '<em><b>Date Style</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<DateStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Date Style</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static DateStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DateStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Date Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static DateStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DateStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Date Style</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static DateStyle get(int value) {
		switch (value) {
		case NICE1_VALUE:
			return NICE1;
		case FULL_VALUE:
			return FULL;
		case NUMERIC_TIME_WITH_SECONDS_VALUE:
			return NUMERIC_TIME_WITH_SECONDS;
		case NUMERIC_TIME_VALUE:
			return NUMERIC_TIME;
		case NUMERIC_DAY_VALUE:
			return NUMERIC_DAY;
		case NUMERIC_MONTH_VALUE:
			return NUMERIC_MONTH;
		case NUMERIC_YEAR_VALUE:
			return NUMERIC_YEAR;
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
	private DateStyle(int value, String name, String literal) {
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

} // DateStyle
