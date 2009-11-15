package org.unicase.mergetest.merge.conflict;

public class ConflictOption {

	private final String option;
	private final OptionType type;
	private String detailProvider;

	public enum OptionType {
		MyOperation, TheirOperation, Issue, Custom
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

	public boolean isDetailsProvider() {
		return detailProvider!=null;
	}
	
	public void setDetailsProvider(String id) {
		this.detailProvider = id;
		
	}
}
