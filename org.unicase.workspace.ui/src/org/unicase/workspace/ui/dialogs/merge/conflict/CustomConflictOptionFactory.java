package org.unicase.workspace.ui.dialogs.merge.conflict;

public interface CustomConflictOptionFactory {

	boolean isApplicableConflict(Conflict conflict);

	CustomConflictOption createCustomConflictOption(Conflict conflict);

}
