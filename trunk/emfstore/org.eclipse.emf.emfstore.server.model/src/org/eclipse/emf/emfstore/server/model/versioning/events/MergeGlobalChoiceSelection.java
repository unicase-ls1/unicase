/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Merge Global Choice Selection</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeGlobalChoiceSelection()
 * @model
 * @generated
 */
public enum MergeGlobalChoiceSelection implements Enumerator {
	/**
	 * The '<em><b>All Mine</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ALL_MINE_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_MINE(0, "AllMine", "AllMine"),

	/**
	 * The '<em><b>All Their</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ALL_THEIR_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_THEIR(1, "AllTheir", "AllTheir"),

	/**
	 * The '<em><b>Cancel</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #CANCEL_VALUE
	 * @generated
	 * @ordered
	 */
	CANCEL(2, "Cancel", "Cancel"),

	/**
	 * The '<em><b>OK Not Finished</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OK_NOT_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	OK_NOT_FINISHED(3, "OKNotFinished", "OKNotFinished"),

	/**
	 * The '<em><b>OK Finished</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OK_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	OK_FINISHED(4, "OKFinished", "OKFinished");

	/**
	 * The '<em><b>All Mine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All Mine</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_MINE
	 * @model name="AllMine"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_MINE_VALUE = 0;

	/**
	 * The '<em><b>All Their</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All Their</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_THEIR
	 * @model name="AllTheir"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_THEIR_VALUE = 1;

	/**
	 * The '<em><b>Cancel</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cancel</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANCEL
	 * @model name="Cancel"
	 * @generated
	 * @ordered
	 */
	public static final int CANCEL_VALUE = 2;

	/**
	 * The '<em><b>OK Not Finished</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OK Not Finished</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OK_NOT_FINISHED
	 * @model name="OKNotFinished"
	 * @generated
	 * @ordered
	 */
	public static final int OK_NOT_FINISHED_VALUE = 3;

	/**
	 * The '<em><b>OK Finished</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OK Finished</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OK_FINISHED
	 * @model name="OKFinished"
	 * @generated
	 * @ordered
	 */
	public static final int OK_FINISHED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Merge Global Choice Selection</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final MergeGlobalChoiceSelection[] VALUES_ARRAY = new MergeGlobalChoiceSelection[] {
			ALL_MINE,
			ALL_THEIR,
			CANCEL,
			OK_NOT_FINISHED,
			OK_FINISHED,
		};

	/**
	 * A public read-only list of all the '<em><b>Merge Global Choice Selection</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<MergeGlobalChoiceSelection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Merge Global Choice Selection</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static MergeGlobalChoiceSelection get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MergeGlobalChoiceSelection result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Merge Global Choice Selection</b></em>' literal with the specified name.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public static MergeGlobalChoiceSelection getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MergeGlobalChoiceSelection result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Merge Global Choice Selection</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static MergeGlobalChoiceSelection get(int value) {
		switch (value) {
			case ALL_MINE_VALUE: return ALL_MINE;
			case ALL_THEIR_VALUE: return ALL_THEIR;
			case CANCEL_VALUE: return CANCEL;
			case OK_NOT_FINISHED_VALUE: return OK_NOT_FINISHED;
			case OK_FINISHED_VALUE: return OK_FINISHED;
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
	private MergeGlobalChoiceSelection(int value, String name, String literal) {
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

} // MergeGlobalChoiceSelection
