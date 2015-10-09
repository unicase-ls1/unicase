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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Appendix Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAppendixStyle()
 * @model
 * @generated
 */
public enum AppendixStyle implements Enumerator {
	/**
	 * The '<em><b>HIDE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #HIDE_VALUE
	 * @generated
	 * @ordered
	 */
	HIDE(0, "HIDE", "hide"),

	/**
	 * The '<em><b>SHOW FLAT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SHOW_FLAT_VALUE
	 * @generated
	 * @ordered
	 */
	SHOW_FLAT(1, "SHOW_FLAT", "show flat"),

	/**
	 * The '<em><b>SHOW RECURSIVE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SHOW_RECURSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	SHOW_RECURSIVE(2, "SHOW_RECURSIVE", "show recursive");

	/**
	 * The '<em><b>HIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIDE</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIDE
	 * @model literal="hide"
	 * @generated
	 * @ordered
	 */
	public static final int HIDE_VALUE = 0;

	/**
	 * The '<em><b>SHOW FLAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHOW FLAT</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOW_FLAT
	 * @model literal="show flat"
	 * @generated
	 * @ordered
	 */
	public static final int SHOW_FLAT_VALUE = 1;

	/**
	 * The '<em><b>SHOW RECURSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHOW RECURSIVE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOW_RECURSIVE
	 * @model literal="show recursive"
	 * @generated
	 * @ordered
	 */
	public static final int SHOW_RECURSIVE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Appendix Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final AppendixStyle[] VALUES_ARRAY = new AppendixStyle[] {
			HIDE,
			SHOW_FLAT,
			SHOW_RECURSIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Appendix Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<AppendixStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Appendix Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppendixStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AppendixStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Appendix Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static AppendixStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AppendixStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Appendix Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppendixStyle get(int value) {
		switch (value) {
			case HIDE_VALUE: return HIDE;
			case SHOW_FLAT_VALUE: return SHOW_FLAT;
			case SHOW_RECURSIVE_VALUE: return SHOW_RECURSIVE;
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
	private AppendixStyle(int value, String name, String literal) {
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

} // AppendixStyle
