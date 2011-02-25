/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enum Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.unicase.model.testspec.TestspecPackage#getEnumType()
 * @model
 * @generated
 */
public enum EnumType implements Enumerator {
	/**
     * The '<em><b>Unit</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #UNIT_VALUE
     * @generated
     * @ordered
     */
	UNIT(0, "unit", "unit"),

	/**
     * The '<em><b>System</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SYSTEM_VALUE
     * @generated
     * @ordered
     */
	SYSTEM(1, "system", "system"),

	/**
     * The '<em><b>Integration</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INTEGRATION_VALUE
     * @generated
     * @ordered
     */
	INTEGRATION(2, "integration", "integration");

	/**
     * The '<em><b>Unit</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #UNIT
     * @model name="unit"
     * @generated
     * @ordered
     */
	public static final int UNIT_VALUE = 0;

	/**
     * The '<em><b>System</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SYSTEM
     * @model name="system"
     * @generated
     * @ordered
     */
	public static final int SYSTEM_VALUE = 1;

	/**
     * The '<em><b>Integration</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integration</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INTEGRATION
     * @model name="integration"
     * @generated
     * @ordered
     */
	public static final int INTEGRATION_VALUE = 2;

	/**
     * An array of all the '<em><b>Enum Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final EnumType[] VALUES_ARRAY =
		new EnumType[] {
            UNIT,
            SYSTEM,
            INTEGRATION,
        };

	/**
     * A public read-only list of all the '<em><b>Enum Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<EnumType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Enum Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EnumType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EnumType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Enum Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EnumType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EnumType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Enum Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EnumType get(int value) {
        switch (value) {
            case UNIT_VALUE: return UNIT;
            case SYSTEM_VALUE: return SYSTEM;
            case INTEGRATION_VALUE: return INTEGRATION;
        }
        return null;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EnumType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //EnumType
