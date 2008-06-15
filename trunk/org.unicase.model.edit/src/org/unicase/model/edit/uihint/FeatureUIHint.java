package org.unicase.model.edit.uihint;

public class FeatureUIHint {

	public static final String TEXT_AREA = "TEXT_AREA";
	private static final String NONE = "NONE";
	String label;
	public String type;

	public FeatureUIHint(String label) {
		this.label = label;
		type = NONE;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
