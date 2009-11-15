package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;

public class DeleteConflict extends Conflict {

	private final boolean myDelete;

	public DeleteConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager,
			boolean myDelete) {
		this.myDelete = myDelete;
	}

	@Override
	public ConflictDescription initConflictDescription() {
		return null;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		if (myDelete) {
			options.add(new ConflictOption("Revert Deletion",
					OptionType.MyOperation));
			options.add(new ConflictOption("Deny Other Change",
					OptionType.TheirOperation));
		} else {
			options.add(new ConflictOption("Deny My Change",
					OptionType.MyOperation));
			options.add(new ConflictOption("Revert Deletion",
					OptionType.TheirOperation));
		}
	}
	
	@Override
	public ConflictContext initConflictContext() {
//		return new ConflictContext(getDecisionManager().getModelElement(
//				getMyOperation().getModelElementId()), "Description", "Jürgen");
	return null;
	}
	
}
