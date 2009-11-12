package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
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
		String result = "";
		if (myDelete) {
			result = "You have deleted an element which conflicts with ";
		} else {
			result = "A deletion from the repository conflicts with your ";
		}

		AbstractOperation op = (myDelete)?getTheirOperation():getMyOperation();
		
		if (op instanceof CompositeOperation) {
			return result + "ReferenceOperation";
		}
		return result + (op.getClass().getSimpleName());
	}

	@Override
	protected void initOptions(List<ConflictOption> options) {
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
	public String getOptionDescription() {
		return "select";
	}

}
