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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>List Style</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getListStyle()
 * @model
 * @generated
 */
public enum ListStyle implements Enumerator {
	/**
	 * The '<em><b>BULLETED</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BULLETED_VALUE
	 * @generated
	 * @ordered
	 */
	BULLETED(0, "BULLETED", "bulleted"), /**
	 * The '<em><b>JUST NEW LINES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUST_NEW_LINES_VALUE
	 * @generated
	 * @ordered
	 */
	JUST_NEW_LINES(1, "JUST_NEW_LINES", "just new lines"), /**
	 * The '<em><b>SEPERATED LIST</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SEPERATED_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	SEPERATED_LIST(2, "SEPERATED_LIST", "seperated list"), /**
	 * The '<em><b>NUMBERED</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #NUMBERED_VALUE
	 * @generated
	 * @ordered
	 */
	NUMBERED(3, "NUMBERED", "numbered"), /**
	 * The '<em><b>ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	ALPHA(4, "ALPHA", "alpha"), /**
	 * The '<em><b>TABLE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE(5, "TABLE", "table");

	/**
	 * The '<em><b>BULLETED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BULLETED</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BULLETED
	 * @model literal="bulleted"
	 * @generated
	 * @ordered
	 */
	public static final int BULLETED_VALUE = 0;

	/**
	 * The '<em><b>JUST NEW LINES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JUST NEW LINES</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JUST_NEW_LINES
	 * @model literal="just new lines"
	 * @generated
	 * @ordered
	 */
	public static final int JUST_NEW_LINES_VALUE = 1;

	/**
	 * The '<em><b>SEPERATED LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEPERATED LIST</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEPERATED_LIST
	 * @model literal="seperated list"
	 * @generated
	 * @ordered
	 */
	public static final int SEPERATED_LIST_VALUE = 2;

	/**
	 * The '<em><b>NUMBERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMBERED</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NUMBERED
	 * @model literal="numbered"
	 * @generated
	 * @ordered
	 */
	public static final int NUMBERED_VALUE = 3;

	/**
	 * The '<em><b>ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALPHA</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALPHA
	 * @model literal="alpha"
	 * @generated
	 * @ordered
	 */
	public static final int ALPHA_VALUE = 4;

	/**
	 * The '<em><b>TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TABLE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE
	 * @model literal="table"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_VALUE = 5;

	/**
	 * An array of all the '<em><b>List Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final ListStyle[] VALUES_ARRAY = new ListStyle[] {
			BULLETED,
			JUST_NEW_LINES,
			SEPERATED_LIST,
			NUMBERED,
			ALPHA,
			TABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>List Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<ListStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>List Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ListStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ListStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>List Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ListStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ListStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>List Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ListStyle get(int value) {
		switch (value) {
			case BULLETED_VALUE: return BULLETED;
			case JUST_NEW_LINES_VALUE: return JUST_NEW_LINES;
			case SEPERATED_LIST_VALUE: return SEPERATED_LIST;
			case NUMBERED_VALUE: return NUMBERED;
			case ALPHA_VALUE: return ALPHA;
			case TABLE_VALUE: return TABLE;
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
	private ListStyle(int value, String name, String literal) {
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

} // ListStyle
