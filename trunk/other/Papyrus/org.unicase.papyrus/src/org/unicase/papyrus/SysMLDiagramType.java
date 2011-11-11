/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sys ML Diagram Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.unicase.papyrus.PapyrusPackage#getSysMLDiagramType()
 * @model
 * @generated
 */
public enum SysMLDiagramType implements Enumerator {
	/**
	 * The '<em><b>No Diagram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	NO_DIAGRAM(0, "NoDiagram", "NoDiagram"),

	/**
	 * The '<em><b>Parametric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARAMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETRIC(1, "Parametric", "Parametric"),

	/**
	 * The '<em><b>Block Definition</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_DEFINITION_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCK_DEFINITION(2, "BlockDefinition", "BlockDefinition"),

	/**
	 * The '<em><b>Requirement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENT_VALUE
	 * @generated
	 * @ordered
	 */
	REQUIREMENT(3, "Requirement", "Requirement"),

	/**
	 * The '<em><b>Internal Block</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNAL_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	INTERNAL_BLOCK(4, "InternalBlock", "InternalBlock");

	/**
	 * The '<em><b>No Diagram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No Diagram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_DIAGRAM
	 * @model name="NoDiagram"
	 * @generated
	 * @ordered
	 */
	public static final int NO_DIAGRAM_VALUE = 0;

	/**
	 * The '<em><b>Parametric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parametric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETRIC
	 * @model name="Parametric"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETRIC_VALUE = 1;

	/**
	 * The '<em><b>Block Definition</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Block Definition</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOCK_DEFINITION
	 * @model name="BlockDefinition"
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_DEFINITION_VALUE = 2;

	/**
	 * The '<em><b>Requirement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Requirement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENT
	 * @model name="Requirement"
	 * @generated
	 * @ordered
	 */
	public static final int REQUIREMENT_VALUE = 3;

	/**
	 * The '<em><b>Internal Block</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Internal Block</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERNAL_BLOCK
	 * @model name="InternalBlock"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_BLOCK_VALUE = 4;

	/**
	 * An array of all the '<em><b>Sys ML Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SysMLDiagramType[] VALUES_ARRAY = new SysMLDiagramType[] {
			NO_DIAGRAM, PARAMETRIC, BLOCK_DEFINITION, REQUIREMENT,
			INTERNAL_BLOCK, };

	/**
	 * A public read-only list of all the '<em><b>Sys ML Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SysMLDiagramType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sys ML Diagram Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SysMLDiagramType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SysMLDiagramType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sys ML Diagram Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SysMLDiagramType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SysMLDiagramType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sys ML Diagram Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SysMLDiagramType get(int value) {
		switch (value) {
		case NO_DIAGRAM_VALUE:
			return NO_DIAGRAM;
		case PARAMETRIC_VALUE:
			return PARAMETRIC;
		case BLOCK_DEFINITION_VALUE:
			return BLOCK_DEFINITION;
		case REQUIREMENT_VALUE:
			return REQUIREMENT;
		case INTERNAL_BLOCK_VALUE:
			return INTERNAL_BLOCK;
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
	private SysMLDiagramType(int value, String name, String literal) {
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

} //SysMLDiagramType
