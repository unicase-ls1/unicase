package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;

public class IssueOption extends ConflictOption {

	public IssueOption(String option) {
		super(option, OptionType.Issue);
	}

	@Override
	public boolean hasExtraAction() {
		return true;
	}

	@Override
	public boolean optionChosen() {
		String label = getOptionLabel();
		InputDialog inputDialog = new InputDialog(Display.getCurrent()
				.getActiveShell(), "Issue Name",
				"Please enter a name for the issue", (label == null) ? ""
						: label, null);
		inputDialog.setBlockOnOpen(true);
		int open = inputDialog.open();
		if (open == 0) {
			setOptionLabel(inputDialog.getValue());
			return true;
		}
		return false;
	}
}
