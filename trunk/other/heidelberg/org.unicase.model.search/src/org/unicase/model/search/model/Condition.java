package org.unicase.model.search.model;

import java.io.Serializable;

import org.eclipse.emf.ecore.EReference;

/**
 * Represents one condition of the search.
 * @author Markus Fischer
 *
 */
public class Condition implements Serializable {
	
	public static final String CONDITION_AND = "AND";
	public static final String CONDITION_OR = "OR";
	public static final String CONDITION_NOT = "NOT";
	public static final String OPERATOR_EQUAL = "equal";
	public static final String OPERATOR_NOT_EQUAL = "not equal";
	public static final String OPERATOR_IS_NULL = "no value set";
	public static final String OPERATOR_NOT_NULL = "value set";
	
	private static final long serialVersionUID = -615750795492367510L;
	
	private String condition;
	private String field;
	private transient EReference reference;
	private String operator;
	private String value;
	
	/**
	 * Creates a new condition.
	 * @param condition the condition 
	 * @param field the field
	 * @param reference the EReference Object
	 * @param operator an operator value
	 * @param value a string value
	 */
	public Condition(String condition, String field, EReference reference, String operator,
			String value) {
		super();
		this.condition = condition;
		this.field = field;
		this.reference = reference;
		this.operator = operator;
		this.value = value;
	}
	
	/**
	 * Creates a new condition, Default-Constructor.
	 */
	public Condition() {
		super();
		this.condition = CONDITION_AND;
		this.field = null;
		this.reference = null;
		this.operator = OPERATOR_EQUAL;
		this.value = "";
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Sets a new condition.
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets a new field.
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Sets a new operator.
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets a new value.
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the reference object
	 */
	public EReference getReference() {
		return reference;
	}

	/**
	 * Sets a new reference object.
	 * @param reference
	 */
	public void setReference(EReference reference) {
		this.reference = reference;
	}
	
}
