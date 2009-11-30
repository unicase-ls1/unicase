/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>UBorder Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getUBorderStyle()
 * @model
 * @generated
 */
public enum UBorderStyle implements Enumerator {
	/**
	 * The '<em><b>HIDDEN</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #HIDDEN_VALUE
	 * @generated
	 * @ordered
	 */
	HIDDEN(0, "HIDDEN", "hidden"), /**
	 * The '<em><b>DOTTED</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #DOTTED_VALUE
	 * @generated
	 * @ordered
	 */
	DOTTED(1, "DOTTED", "dotted"),

	/**
	 * The '<em><b>DASHED</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DASHED_VALUE
	 * @generated
	 * @ordered
	 */
	DASHED(2, "DASHED", "dashed"),

	/**
	 * The '<em><b>DOUBLE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE(3, "DOUBLE", "double"),

	/**
	 * The '<em><b>GROOVE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #GROOVE_VALUE
	 * @generated
	 * @ordered
	 */
	GROOVE(4, "GROOVE", "groove"),

	/**
	 * The '<em><b>RIDGE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #RIDGE_VALUE
	 * @generated
	 * @ordered
	 */
	RIDGE(5, "RIDGE", "ridge"),

	/**
	 * The '<em><b>INSET</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #INSET_VALUE
	 * @generated
	 * @ordered
	 */
	INSET(6, "INSET", "inset"),

	/**
	 * The '<em><b>OUTSET</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #OUTSET_VALUE
	 * @generated
	 * @ordered
	 */
	OUTSET(7, "OUTSET", "outset"), /**
	 * The '<em><b>SOLID</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #SOLID_VALUE
	 * @generated
	 * @ordered
	 */
	SOLID(8, "SOLID", "solid");

	/**
	 * The '<em><b>HIDDEN</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIDDEN</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #HIDDEN
	 * @model literal="hidden"
	 * @generated
	 * @ordered
	 */
	public static final int HIDDEN_VALUE = 0;

	/**
	 * The '<em><b>DOTTED</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOTTED</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DOTTED
	 * @model literal="dotted"
	 * @generated
	 * @ordered
	 */
	public static final int DOTTED_VALUE = 1;

	/**
	 * The '<em><b>DASHED</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DASHED</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DASHED
	 * @model literal="dashed"
	 * @generated
	 * @ordered
	 */
	public static final int DASHED_VALUE = 2;

	/**
	 * The '<em><b>DOUBLE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DOUBLE
	 * @model literal="double"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_VALUE = 3;

	/**
	 * The '<em><b>GROOVE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GROOVE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GROOVE
	 * @model literal="groove"
	 * @generated
	 * @ordered
	 */
	public static final int GROOVE_VALUE = 4;

	/**
	 * The '<em><b>RIDGE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RIDGE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #RIDGE
	 * @model literal="ridge"
	 * @generated
	 * @ordered
	 */
	public static final int RIDGE_VALUE = 5;

	/**
	 * The '<em><b>INSET</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSET</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INSET
	 * @model literal="inset"
	 * @generated
	 * @ordered
	 */
	public static final int INSET_VALUE = 6;

	/**
	 * The '<em><b>OUTSET</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTSET</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OUTSET
	 * @model literal="outset"
	 * @generated
	 * @ordered
	 */
	public static final int OUTSET_VALUE = 7;

	/**
	 * The '<em><b>SOLID</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLID</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SOLID
	 * @model literal="solid"
	 * @generated
	 * @ordered
	 */
	public static final int SOLID_VALUE = 8;

	/**
	 * An array of all the '<em><b>UBorder Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final UBorderStyle[] VALUES_ARRAY = new UBorderStyle[] { HIDDEN, DOTTED, DASHED, DOUBLE, GROOVE,
		RIDGE, INSET, OUTSET, SOLID, };

	/**
	 * A public read-only list of all the '<em><b>UBorder Style</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<UBorderStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>UBorder Style</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UBorderStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UBorderStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UBorder Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static UBorderStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UBorderStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UBorder Style</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UBorderStyle get(int value) {
		switch (value) {
		case HIDDEN_VALUE:
			return HIDDEN;
		case DOTTED_VALUE:
			return DOTTED;
		case DASHED_VALUE:
			return DASHED;
		case DOUBLE_VALUE:
			return DOUBLE;
		case GROOVE_VALUE:
			return GROOVE;
		case RIDGE_VALUE:
			return RIDGE;
		case INSET_VALUE:
			return INSET;
		case OUTSET_VALUE:
			return OUTSET;
		case SOLID_VALUE:
			return SOLID;
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
	private UBorderStyle(int value, String name, String literal) {
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

} // UBorderStyle
