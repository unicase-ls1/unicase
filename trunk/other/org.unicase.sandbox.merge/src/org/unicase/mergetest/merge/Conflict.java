package org.unicase.mergetest.merge;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public abstract class Conflict {

	private final AbstractOperation theirOperation;
	private final AbstractOperation myOperation;
	private final DecisionManager decisionManager;

	public Conflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager) {
				this.myOperation = myOperation;
				this.theirOperation = theirOperation;
				this.decisionManager = decisionManager;
	}

	
	public DecisionManager getDecisionManager() {
		return decisionManager;
	}
	
	public AbstractOperation getTheirOperation() {
		return theirOperation;
	}


	public AbstractOperation getMyOperation() {
		return myOperation;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	public String getName() {
		return getDecisionManager().getModelElementName(getMyOperation().getModelElementId());
	}
	
	public String getConflictDescription() {
		return "";
	}

	abstract List<String> getOptions();


	public String getOptionDescription() {
		return "";
	}
}
