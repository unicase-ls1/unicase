package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;

public class MultiReferenceConflict extends Conflict {

	public MultiReferenceConflict(MultiReferenceOperation mySubOp,
			MultiReferenceOperation theirSubOp) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ConflictContext initConflictContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		// TODO Auto-generated method stub

	}

}
