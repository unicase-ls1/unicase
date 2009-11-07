package org.unicase.mergetest.merge.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;

public abstract class Conflict {

	private final AbstractOperation theirOperation;
	private final AbstractOperation myOperation;
	private final DecisionManager decisionManager;
	private boolean isResolved;

	public Conflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager) {
				this.myOperation = myOperation;
				this.theirOperation = theirOperation;
				this.decisionManager = decisionManager;
				isResolved=false;
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

	public abstract List<String> getOptions();


	public String getOptionDescription() {
		return "";
	}


	public void setSolution(int optionIndex) {
		setResolved(true);
	}
	
	
	public boolean isResolved() {
		return isResolved;
	}


	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}


	public boolean hasAdditionalInformation() {
		return false;
	}
	
}
