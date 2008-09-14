/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.diagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.unicase.model.diagram.DiagramPackage#getDiagramType()
 * @model
 * @generated
 */
public enum DiagramType implements Enumerator {
	/**
	 * The '<em><b>CLASS DIAGRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASS_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_DIAGRAM(0, "CLASS_DIAGRAM", "Class Diagram"),

	/**
	 * The '<em><b>USECASE DIAGRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USECASE_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	USECASE_DIAGRAM(1, "USECASE_DIAGRAM", "Usecase Diagram"),

	/**
	 * The '<em><b>COMPONENT DIAGRAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	COMPONENT_DIAGRAM(2, "COMPONENT_DIAGRAM", "Component Diagram");

	/**
	 * The '<em><b>CLASS DIAGRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASS DIAGRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASS_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_DIAGRAM_VALUE = 0;

	/**
	 * The '<em><b>USECASE DIAGRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USECASE DIAGRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USECASE_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USECASE_DIAGRAM_VALUE = 1;

	/**
	 * The '<em><b>COMPONENT DIAGRAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPONENT DIAGRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_DIAGRAM_VALUE = 2;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DiagramType[] VALUES_ARRAY = new DiagramType[] {
			CLASS_DIAGRAM, USECASE_DIAGRAM, COMPONENT_DIAGRAM, };

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DiagramType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DiagramType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DiagramType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramType get(int value) {
		switch (value) {
		case CLASS_DIAGRAM_VALUE:
			return CLASS_DIAGRAM;
		case USECASE_DIAGRAM_VALUE:
			return USECASE_DIAGRAM;
		case COMPONENT_DIAGRAM_VALUE:
			return COMPONENT_DIAGRAM;
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
	private DiagramType(int value, String name, String literal) {
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

} //DiagramType
