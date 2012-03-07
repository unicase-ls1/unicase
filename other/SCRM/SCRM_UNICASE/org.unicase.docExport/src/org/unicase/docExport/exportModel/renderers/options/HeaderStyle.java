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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Header Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getHeaderStyle()
 * @model
 * @generated
 */
public enum HeaderStyle implements Enumerator {
	/**
	 * The '<em><b>ONLY TEXT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ONLY_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	ONLY_TEXT(0, "ONLY_TEXT", "only header text"), /**
	 * The '<em><b>TEXT AND LOGO</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TEXT_AND_LOGO_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_AND_LOGO(1, "TEXT_AND_LOGO", "text and logo");

	/**
	 * The '<em><b>ONLY TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONLY TEXT</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONLY_TEXT
	 * @model literal="only header text"
	 * @generated
	 * @ordered
	 */
	public static final int ONLY_TEXT_VALUE = 0;

	/**
	 * The '<em><b>TEXT AND LOGO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEXT AND LOGO</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_AND_LOGO
	 * @model literal="text and logo"
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_AND_LOGO_VALUE = 1;

	/**
	 * An array of all the '<em><b>Header Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final HeaderStyle[] VALUES_ARRAY = new HeaderStyle[] {
			ONLY_TEXT,
			TEXT_AND_LOGO,
		};

	/**
	 * A public read-only list of all the '<em><b>Header Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<HeaderStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Header Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static HeaderStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HeaderStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Header Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static HeaderStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HeaderStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Header Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static HeaderStyle get(int value) {
		switch (value) {
			case ONLY_TEXT_VALUE: return ONLY_TEXT;
			case TEXT_AND_LOGO_VALUE: return TEXT_AND_LOGO;
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
	private HeaderStyle(int value, String name, String literal) {
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

} // HeaderStyle
