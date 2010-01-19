package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;

public class MergeTextOption extends ConflictOption {

	private List<ConflictOption> list;
	private String text;

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
		String result = "";
		for (ConflictOption option : list) {
			result += " " + option.getFullOptionLabel();
		}
		return result;
	}

	@Override
	public List<AbstractOperation> getOperations() {
		if (text != null) {
			for (ConflictOption option : list) {
				if (option.getType().equals(OptionType.MyOperation)) {
					if (option.getOperations().size() == 0) {
						continue;
					}
					AbstractOperation tmp = option.getOperations().get(0);
					if (tmp instanceof AttributeOperation) {
						option.getOperations().remove(0);
						AttributeOperation mergedOp = (AttributeOperation) EcoreUtil.copy(tmp);
						mergedOp.setIdentifier(EcoreUtil.generateUUID());
						mergedOp.setNewValue(text);
						option.getOperations().add(0, mergedOp);
						return option.getOperations();
					}
				}
			}
		}

		return super.getOperations();
	}

	public void setMergedText(String text) {
		this.text = text;
	}

	public String getMergedText() {
		return text;
	}
}
