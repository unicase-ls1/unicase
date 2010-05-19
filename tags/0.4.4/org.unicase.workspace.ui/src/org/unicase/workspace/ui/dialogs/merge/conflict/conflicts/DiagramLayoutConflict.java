package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

public class DiagramLayoutConflict extends AttributeConflict {

	public DiagramLayoutConflict(List<AbstractOperation> myOperations,
			List<AbstractOperation> theirOperations,
			DecisionManager decisionManager) {
		super(myOperations, theirOperations, decisionManager);
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		ConflictDescription description = super.initConflictDescription();
		description
				.setDescription("The diagram layout of [modelelement], which you have edited, was edited on the repository as well.");
		return description;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		super.initOptionsWithOutMerge(options, false);
		for (ConflictOption op : options) {
			if (op.getType().equals(OptionType.MyOperation)) {
				op.setOptionLabel("Retain your Layout");
			} else if (op.getType().equals(OptionType.TheirOperation)) {
				op.setOptionLabel("Drop your Layout");
			}
		}
	}

}
