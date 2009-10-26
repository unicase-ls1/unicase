package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

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
	List<String> getOptions() {
		ArrayList<String> result = new ArrayList<String>();
		
		if(myDelete) {
			result.add("Revert Deletion");
			result.add("Deny Other Change");
		} else {
			result.add("Deny My Change");
			result.add("Revert Deletion");
		}
		
		return result;
	}

}
