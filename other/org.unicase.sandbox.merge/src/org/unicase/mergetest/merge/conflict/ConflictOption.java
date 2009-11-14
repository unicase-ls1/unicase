package org.unicase.mergetest.merge.conflict;

public class ConflictOption {

	private final String option;
	private final OptionType type;

	public enum OptionType {
		MyOperation, TheirOperation
	};

	public ConflictOption(String option, OptionType type) {
		this.option = option;
		this.type = type;
	}

	public String getOptionLabel() {
		return option;
	}
	
	public OptionType getType() {
		return type;
	}

	public String getFullOptionLabel() {
		return option;
	}
}
