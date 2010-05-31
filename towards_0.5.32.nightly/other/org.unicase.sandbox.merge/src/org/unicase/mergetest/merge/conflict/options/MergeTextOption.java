package org.unicase.mergetest.merge.conflict.options;

import java.util.ArrayList;
import java.util.List;

import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.util.DecisionConfig;

public class MergeTextOption extends ConflictOption {

	private List<ConflictOption> list;

	public MergeTextOption() {
		super("Select Edited/Merged Value", OptionType.Custom);
		list = new ArrayList<ConflictOption>();
		setDetailProvider(DecisionConfig.WIDGET_MULTILINE_EDITABLE);
	}
	
	public void add(ConflictOption option) {
		list.add(option);
	}

	@Override
	public String getFullOptionLabel() {
		String result ="";
		for(ConflictOption option : list) {
			result += " "+option.getFullOptionLabel();
		}
		return result;
	}
	
}
