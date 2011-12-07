/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Diagram Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scrm.ScrmPackage#getDiagramType()
 * @model
 * @generated
 */
public enum DiagramType implements Enumerator {
	/**
	 * The '<em><b>Default Diagram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT_DIAGRAM(0, "DefaultDiagram", "DefaultDiagram"),

	/**
	 * The '<em><b>Knowledge Diagram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KNOWLEDGE_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	KNOWLEDGE_DIAGRAM(1, "KnowledgeDiagram", ""),

	/**
	 * The '<em><b>Requirements Diagram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENTS_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	REQUIREMENTS_DIAGRAM(2, "RequirementsDiagram", "RequirementsDiagram"),

	/**
	 * The '<em><b>Data Process Diagram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_PROCESS_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_PROCESS_DIAGRAM(3, "DataProcessDiagram", "DataProcessDiagram");

	/**
	 * The '<em><b>Default Diagram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Default Diagram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_DIAGRAM
	 * @model name="DefaultDiagram"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_DIAGRAM_VALUE = 0;

	/**
	 * The '<em><b>Knowledge Diagram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Knowledge Diagram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KNOWLEDGE_DIAGRAM
	 * @model name="KnowledgeDiagram" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int KNOWLEDGE_DIAGRAM_VALUE = 1;

	/**
	 * The '<em><b>Requirements Diagram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Requirements Diagram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENTS_DIAGRAM
	 * @model name="RequirementsDiagram"
	 * @generated
	 * @ordered
	 */
	public static final int REQUIREMENTS_DIAGRAM_VALUE = 2;

	/**
	 * The '<em><b>Data Process Diagram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data Process Diagram</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_PROCESS_DIAGRAM
	 * @model name="DataProcessDiagram"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_PROCESS_DIAGRAM_VALUE = 3;

	/**
	 * An array of all the '<em><b>Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DiagramType[] VALUES_ARRAY = new DiagramType[] {
			DEFAULT_DIAGRAM, KNOWLEDGE_DIAGRAM, REQUIREMENTS_DIAGRAM,
			DATA_PROCESS_DIAGRAM, };

	/**
	 * A public read-only list of all the '<em><b>Diagram Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DiagramType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Diagram Type</b></em>' literal with the specified literal value.
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
	 * Returns the '<em><b>Diagram Type</b></em>' literal with the specified name.
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
	 * Returns the '<em><b>Diagram Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramType get(int value) {
		switch (value) {
		case DEFAULT_DIAGRAM_VALUE:
			return DEFAULT_DIAGRAM;
		case KNOWLEDGE_DIAGRAM_VALUE:
			return KNOWLEDGE_DIAGRAM;
		case REQUIREMENTS_DIAGRAM_VALUE:
			return REQUIREMENTS_DIAGRAM;
		case DATA_PROCESS_DIAGRAM_VALUE:
			return DATA_PROCESS_DIAGRAM;
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
