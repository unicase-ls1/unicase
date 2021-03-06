package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;

public class ReferenceConflict extends Conflict {

	private final Conflict conflict;

	public ReferenceConflict(Conflict conflict, List<AbstractOperation> myOps, List<AbstractOperation> theirOps) {
		super(myOps, theirOps, conflict.getDecisionManager(),false);
		if(!(conflict instanceof SingleReferenceConflict || conflict instanceof MultiReferenceConflict)) {
			throw new IllegalStateException("Only reference conflicts allowed.");
		}
		this.conflict = conflict;
		init();
	}
	
	@Override
	protected boolean allowOtherOptions() {
		return false;
	}
	
	@Override
	protected ConflictContext initConflictContext() {
		return conflict.getConflictContext();
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		return conflict.getConflictDescription();
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		for(ConflictOption option : conflict.getOptions()) {
			if(option.getType()==OptionType.MyOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(operationsA);
			} else if(option.getType()==OptionType.TheirOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(operationsB);
			}
			options.add(option);
		}
	}

}
