package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflicts.ConflictOption.OptionType;

public class DeleteConflict extends Conflict {

	private final boolean myDelete;

	public DeleteConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager,
			boolean myDelete) {
		super(myOperation, theirOperation, decisionManager);
		this.myDelete = myDelete;
	}

	@Override
	public String getConflictDescription() {
		if(myDelete) {
			return "You have deleted an element which causes a conflict.";
		} else {
			return "A deletion from the repository conflicts with one of your operations.";
		}
	}

	@Override
	protected void initOptions(List<ConflictOption> options) {
		if(myDelete) {
			options.add(new ConflictOption("Revert Deletion",OptionType.MyOperation));
			options.add(new ConflictOption("Deny Other Change",OptionType.TheirOperation));
		} else {
			options.add(new ConflictOption("Deny My Change",OptionType.MyOperation));
			options.add(new ConflictOption("Revert Deletion",OptionType.TheirOperation));
		}
	}

	@Override
	public String getOptionDescription() {
		return "select";
	}

}
