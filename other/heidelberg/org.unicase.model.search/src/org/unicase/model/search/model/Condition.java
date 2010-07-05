package org.unicase.model.search.model;

public class Condition {
	
	private String condition;
	private String field;
	private String operator;
	private String value;
	
	public Condition() {
		this.condition = "AND";
		this.field = "name";
		this.operator = "==";
		this.value = "";
	}
	
	public Condition(String condition, String field, String operator,
			String value) {
		super();
		this.condition = condition;
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
