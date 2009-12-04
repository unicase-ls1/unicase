/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Merge Choice Selection</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceSelection()
 * @model
 * @generated
 */
public enum MergeChoiceSelection implements Enumerator {
	/**
	 * The '<em><b>Mine</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #MINE_VALUE
	 * @generated
	 * @ordered
	 */
	MINE(0, "Mine", "Mine"),

	/**
	 * The '<em><b>Their</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #THEIR_VALUE
	 * @generated
	 * @ordered
	 */
	THEIR(1, "Their", "Their"),

	/**
	 * The '<em><b>Issue</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ISSUE_VALUE
	 * @generated
	 * @ordered
	 */
	ISSUE(2, "Issue", "Issue"),

	/**
	 * The '<em><b>All Mine</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ALL_MINE_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_MINE(3, "AllMine", "AllMine"),

	/**
	 * The '<em><b>All Their</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ALL_THEIR_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_THEIR(4, "AllTheir", "AllTheir"),

	/**
	 * The '<em><b>Cancel</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CANCEL_VALUE
	 * @generated
	 * @ordered
	 */
	CANCEL(5, "Cancel", "Cancel"),

	/**
	 * The '<em><b>OK Not Finished</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #OK_NOT_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	OK_NOT_FINISHED(6, "OKNotFinished", "OKNotFinished"),

	/**
	 * The '<em><b>OK Finished</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #OK_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	OK_FINISHED(7, "OKFinished", "OKFinished");

	/**
	 * The '<em><b>Mine</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mine</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MINE
	 * @model name="Mine"
	 * @generated
	 * @ordered
	 */
	public static final int MINE_VALUE = 0;

	/**
	 * The '<em><b>Their</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Their</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #THEIR
	 * @model name="Their"
	 * @generated
	 * @ordered
	 */
	public static final int THEIR_VALUE = 1;

	/**
	 * The '<em><b>Issue</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Issue</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ISSUE
	 * @model name="Issue"
	 * @generated
	 * @ordered
	 */
	public static final int ISSUE_VALUE = 2;

	/**
	 * The '<em><b>All Mine</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All Mine</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ALL_MINE
	 * @model name="AllMine"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_MINE_VALUE = 3;

	/**
	 * The '<em><b>All Their</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All Their</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ALL_THEIR
	 * @model name="AllTheir"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_THEIR_VALUE = 4;

	/**
	 * The '<em><b>Cancel</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cancel</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CANCEL
	 * @model name="Cancel"
	 * @generated
	 * @ordered
	 */
	public static final int CANCEL_VALUE = 5;

	/**
	 * The '<em><b>OK Not Finished</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OK Not Finished</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OK_NOT_FINISHED
	 * @model name="OKNotFinished"
	 * @generated
	 * @ordered
	 */
	public static final int OK_NOT_FINISHED_VALUE = 6;

	/**
	 * The '<em><b>OK Finished</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OK Finished</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OK_FINISHED
	 * @model name="OKFinished"
	 * @generated
	 * @ordered
	 */
	public static final int OK_FINISHED_VALUE = 7;

	/**
	 * An array of all the '<em><b>Merge Choice Selection</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private static final MergeChoiceSelection[] VALUES_ARRAY = new MergeChoiceSelection[] { MINE, THEIR, ISSUE,
		ALL_MINE, ALL_THEIR, CANCEL, OK_NOT_FINISHED, OK_FINISHED, };

	/**
	 * A public read-only list of all the '<em><b>Merge Choice Selection</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<MergeChoiceSelection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Merge Choice Selection</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static MergeChoiceSelection get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MergeChoiceSelection result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Merge Choice Selection</b></em>' literal with the specified name. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static MergeChoiceSelection getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MergeChoiceSelection result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Merge Choice Selection</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static MergeChoiceSelection get(int value) {
		switch (value) {
		case MINE_VALUE:
			return MINE;
		case THEIR_VALUE:
			return THEIR;
		case ISSUE_VALUE:
			return ISSUE;
		case ALL_MINE_VALUE:
			return ALL_MINE;
		case ALL_THEIR_VALUE:
			return ALL_THEIR;
		case CANCEL_VALUE:
			return CANCEL;
		case OK_NOT_FINISHED_VALUE:
			return OK_NOT_FINISHED;
		case OK_FINISHED_VALUE:
			return OK_FINISHED;
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
	private MergeChoiceSelection(int value, String name, String literal) {
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

} // MergeChoiceSelection
