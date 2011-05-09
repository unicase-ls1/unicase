package org.unicase.mergetest.merge.conflict;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.util.DecisionUtil;

public class ConflictOption {

	private final String option;
	private final OptionType type;
	private String detailProvider;
	private List<AbstractOperation> operations;

	public enum OptionType {
		MyOperation, TheirOperation, Issue, Custom
	};

	public ConflictOption(String option, OptionType type) {
		this.option = option;
		this.type = type;
		operations = new ArrayList<AbstractOperation>();
	}

	public String getOptionLabel() {
		return option;
	}
	
	public String getStrippedOptionLabel() {
		return DecisionUtil.stripNewLine(getOptionLabel());
	}
	
	public String getFullOptionLabel() {
		return option;
	}
	
	public OptionType getType() {
		return type;
	}

	public void addOperations(List<AbstractOperation> ops) {
		operations.addAll(ops);
	}
	
	public List<AbstractOperation> getOperations() {
		return operations;
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
