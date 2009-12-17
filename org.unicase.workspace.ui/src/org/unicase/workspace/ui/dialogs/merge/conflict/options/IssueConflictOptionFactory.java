package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOptionFactory;

public class IssueConflictOptionFactory implements CustomConflictOptionFactory {

	public CustomConflictOption createCustomConflictOption(Conflict conflict) {
		if (!isApplicableConflict(conflict)) {
			return null;
		}
		IssueOption issueOption = new IssueOption();
		issueOption.setConflict(conflict);
		return issueOption;
	}

	public boolean isApplicableConflict(Conflict conflict) {
		return true;
	}

}
