/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/*
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Eval Status</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.unicase.model.hazard.HazardPackage#getEvalStatus()
 * @model
 * @generated
 */
public enum EvalStatus implements Enumerator {
	/**
	 * The '<em><b>New</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @generated
	 * @ordered
	 */
	NEW(0, "New", "New"),

	/**
	 * The '<em><b>Evaluated</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #EVALUATED_VALUE
	 * @generated
	 * @ordered
	 */
	EVALUATED(1, "Evaluated", "Evaluated"),

	/**
	 * The '<em><b>Unkown</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #UNKOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKOWN(2, "Unkown", "Unkown");

	/**
	 * The '<em><b>New</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>New</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW
	 * @model name="New"
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE = 0;

	/**
	 * The '<em><b>Evaluated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Evaluated</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVALUATED
	 * @model name="Evaluated"
	 * @generated
	 * @ordered
	 */
	public static final int EVALUATED_VALUE = 1;

	/**
	 * The '<em><b>Unkown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unkown</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKOWN
	 * @model name="Unkown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKOWN_VALUE = 2;

	/**
	 * An array of all the '<em><b>Eval Status</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final EvalStatus[] VALUES_ARRAY = new EvalStatus[] { NEW, EVALUATED, UNKOWN, };

	/**
	 * A public read-only list of all the '<em><b>Eval Status</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final List<EvalStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Eval Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static EvalStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EvalStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Eval Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static EvalStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EvalStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Eval Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static EvalStatus get(int value) {
		switch (value) {
		case NEW_VALUE:
			return NEW;
		case EVALUATED_VALUE:
			return EVALUATED;
		case UNKOWN_VALUE:
			return UNKOWN;
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
	private EvalStatus(int value, String name, String literal) {
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

} // EvalStatus
