package org.unicase.mergetest.merge.conflicts;

public class ConflictOption {

	private final String option;
	private final OptionType type;

	public enum OptionType {MyOperation, TheirOperation};
	
	public ConflictOption(String option, OptionType type) {
		this.option = option;
		this.type = type;
	}

	public String getOptionLabel() {
		return option.substring(0, option.length()<20?option.length():20);
	}

	public String getFullOptionLabel() {
		return option;
	}
}
