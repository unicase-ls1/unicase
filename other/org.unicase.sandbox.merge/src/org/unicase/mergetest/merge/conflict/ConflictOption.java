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
	
	public String getFullOptionLabel() {
		return option;
	}
	
	public OptionType getType() {
		return type;
	}

	public boolean isDetailsProvider() {
		return getDetailProvider()!=null;
	}

	public void setDetailProvider(String detailProvider) {
		this.detailProvider = detailProvider;
	}

	public String getDetailProvider() {
		return detailProvider;
	}
}
