package org.unicase.workspace.ui.dialogs.merge.conflict;

public abstract class CustomConflictOption extends ConflictOption {

	public CustomConflictOption(String option) {
		super(option, OptionType.Custom);
	}

	public String getOptionPrefix() {
		return null;
	}
}
