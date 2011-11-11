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
 * A representation of the literals of the enumeration '<em><b>UML Diagram Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.unicase.papyrus.PapyrusPackage#getUMLDiagramType()
 * @model
 * @generated
 */
public enum UMLDiagramType implements Enumerator {
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
	 * The '<em><b>Activity</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVITY_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVITY(1, "Activity", "Activity"),

	/**
	 * The '<em><b>Class</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS(2, "Class", "Class"),

	/**
	 * The '<em><b>Communication</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMUNICATION_VALUE
	 * @generated
	 * @ordered
	 */
	COMMUNICATION(3, "Communication", "Communication"),

	/**
	 * The '<em><b>Composite</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_VALUE
	 * @generated
	 * @ordered
	 */
	COMPOSITE(4, "Composite", "Composite"),

	/**
	 * The '<em><b>Package</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	PACKAGE(5, "Package", "Package"),

	/**
	 * The '<em><b>Sequence</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	SEQUENCE(6, "Sequence", "Sequence"),

	/**
	 * The '<em><b>State Machine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_MACHINE(7, "StateMachine", "StateMachine"),

	/**
	 * The '<em><b>Use Case</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_CASE_VALUE
	 * @generated
	 * @ordered
	 */
	USE_CASE(8, "UseCase", "UseCase");

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
	 * The '<em><b>Activity</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Activity</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVITY
	 * @model name="Activity"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVITY_VALUE = 1;

	/**
	 * The '<em><b>Class</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Class</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASS
	 * @model name="Class"
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_VALUE = 2;

	/**
	 * The '<em><b>Communication</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Communication</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMUNICATION
	 * @model name="Communication"
	 * @generated
	 * @ordered
	 */
	public static final int COMMUNICATION_VALUE = 3;

	/**
	 * The '<em><b>Composite</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Composite</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE
	 * @model name="Composite"
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_VALUE = 4;

	/**
	 * The '<em><b>Package</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PACKAGE
	 * @model name="Package"
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_VALUE = 5;

	/**
	 * The '<em><b>Sequence</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sequence</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @model name="Sequence"
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_VALUE = 6;

	/**
	 * The '<em><b>State Machine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>State Machine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE_MACHINE
	 * @model name="StateMachine"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_MACHINE_VALUE = 7;

	/**
	 * The '<em><b>Use Case</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Use Case</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE_CASE
	 * @model name="UseCase"
	 * @generated
	 * @ordered
	 */
	public static final int USE_CASE_VALUE = 8;

	/**
	 * An array of all the '<em><b>UML Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UMLDiagramType[] VALUES_ARRAY = new UMLDiagramType[] {
			NO_DIAGRAM, ACTIVITY, CLASS, COMMUNICATION, COMPOSITE, PACKAGE,
			SEQUENCE, STATE_MACHINE, USE_CASE, };

	/**
	 * A public read-only list of all the '<em><b>UML Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UMLDiagramType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>UML Diagram Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLDiagramType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UMLDiagramType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UML Diagram Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLDiagramType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UMLDiagramType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UML Diagram Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLDiagramType get(int value) {
		switch (value) {
		case NO_DIAGRAM_VALUE:
			return NO_DIAGRAM;
		case ACTIVITY_VALUE:
			return ACTIVITY;
		case CLASS_VALUE:
			return CLASS;
		case COMMUNICATION_VALUE:
			return COMMUNICATION;
		case COMPOSITE_VALUE:
			return COMPOSITE;
		case PACKAGE_VALUE:
			return PACKAGE;
		case SEQUENCE_VALUE:
			return SEQUENCE;
		case STATE_MACHINE_VALUE:
			return STATE_MACHINE;
		case USE_CASE_VALUE:
			return USE_CASE;
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
	private UMLDiagramType(int value, String name, String literal) {
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

} //UMLDiagramType
