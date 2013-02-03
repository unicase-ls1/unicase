/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Button Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.wireframe.WireframePackage#getButtonStyle()
 * @model
 * @generated
 */
public enum ButtonStyle implements Enumerator {
	/**
	 * The '<em><b>Point Left</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #POINT_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	POINT_LEFT(0, "PointLeft", "Point Left"),

	/**
	 * The '<em><b>Square</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SQUARE_VALUE
	 * @generated
	 * @ordered
	 */
	SQUARE(1, "Square", "Square"),

	/**
	 * The '<em><b>Point Right</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #POINT_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	POINT_RIGHT(2, "PointRight", "Point Right");

	/**
	 * The '<em><b>Point Left</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Point Left</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POINT_LEFT
	 * @model name="PointLeft" literal="Point Left"
	 * @generated
	 * @ordered
	 */
	public static final int POINT_LEFT_VALUE = 0;

	/**
	 * The '<em><b>Square</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Square</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SQUARE
	 * @model name="Square"
	 * @generated
	 * @ordered
	 */
	public static final int SQUARE_VALUE = 1;

	/**
	 * The '<em><b>Point Right</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Point Right</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POINT_RIGHT
	 * @model name="PointRight" literal="Point Right"
	 * @generated
	 * @ordered
	 */
	public static final int POINT_RIGHT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Button Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final ButtonStyle[] VALUES_ARRAY = new ButtonStyle[] { POINT_LEFT, SQUARE, POINT_RIGHT, };

	/**
	 * A public read-only list of all the '<em><b>Button Style</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<ButtonStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Button Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ButtonStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ButtonStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Button Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ButtonStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ButtonStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Button Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ButtonStyle get(int value) {
		switch (value) {
		case POINT_LEFT_VALUE:
			return POINT_LEFT;
		case SQUARE_VALUE:
			return SQUARE;
		case POINT_RIGHT_VALUE:
			return POINT_RIGHT;
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
	private ButtonStyle(int value, String name, String literal) {
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

} // ButtonStyle
