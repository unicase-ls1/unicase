package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;

public class DeleteConflict extends Conflict<AbstractOperation,AbstractOperation> {

	private final boolean myDelete;

	public DeleteConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager,
			boolean myDelete) {
		super(myOperation, theirOperation, decisionManager);
		this.myDelete = myDelete;
	}

	public ConflictDescription getConflictDescription() {
//		String result = "";
//		if (myDelete) {
//			result = "You have deleted an element which conflicts with ";
//		} else {
//			result = "A deletion from the repository conflicts with your ";
//		}
//
//		AbstractOperation op = (myDelete)?getTheirOperation():getMyOperation();
//		
//		if (op instanceof CompositeOperation) {
//			return result + "ReferenceOperation";
//		}
//		return result + (op.getClass().getSimpleName());
		return null;
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
	public ConflictContext getContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), "Description", "Jürgen");
	}

}
