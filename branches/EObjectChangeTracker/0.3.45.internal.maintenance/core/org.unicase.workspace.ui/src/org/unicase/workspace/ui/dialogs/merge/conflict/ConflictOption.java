package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class ConflictOption {

	private String option;
	private OptionType type;
	private String detailProvider;
	private List<AbstractOperation> operations;

	public enum OptionType {
		MyOperation, TheirOperation, Custom
	};

	public ConflictOption(String option, OptionType type) {
		this.option = option;
		this.type = type;
		operations = new ArrayList<AbstractOperation>();
	}

	public String getOptionLabel() {
		return option;
	}

	public void setOptionLabel(String option) {
		this.option = option;
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
		return getDetailProvider() != null;
	}

	public void setDetailProvider(String detailProvider) {
		this.detailProvider = detailProvider;
	}

	public String getDetailProvider() {
		return detailProvider;
	}

	public boolean hasExtraOptionAction() {
		return false;
	}

	/**
	 * Called if Option is chosen in the UI.
	 * 
	 * @return if true, Option will be updated
	 */
	public boolean optionChosen() {
		return false;
	}

	public boolean hasExtraResultAction() {
		return false;
	}

	public void callResultAction() {

	}
}
