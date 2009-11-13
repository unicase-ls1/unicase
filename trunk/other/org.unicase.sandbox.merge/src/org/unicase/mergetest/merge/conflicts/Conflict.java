package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;

public abstract class Conflict<MyOp extends AbstractOperation, TheirOp extends AbstractOperation> {

	private final TheirOp theirOperation;
	private final MyOp myOperation;
	private final DecisionManager decisionManager;
	private ArrayList<ConflictOption> options;
	private ConflictOption solution;

	public Conflict(MyOp myOperation, TheirOp theirOperation,
			DecisionManager decisionManager) {
		this.myOperation = myOperation;
		this.theirOperation = theirOperation;
		this.decisionManager = decisionManager;
		initOptions();
	}

	private void initOptions() {
		options = new ArrayList<ConflictOption>();
		initOptions(options);
	}

	abstract protected void initOptions(List<ConflictOption> options);

	public DecisionManager getDecisionManager() {
		return decisionManager;
	}

	public TheirOp getTheirOperation() {
		return theirOperation;
	}

	public MyOp getMyOperation() {
		return myOperation;
	}

	public String getName() {
		return getDecisionManager().getModelElementName(
				getMyOperation().getModelElementId());
	}

	public abstract String getConflictDescription();

	public List<ConflictOption> getOptions() {
		return options;
	}

	public abstract String getOptionDescription();

	public boolean isResolved() {
		return (solution != null);
	}

	public boolean hasAdditionalInformation() {
		return false;
	}

	public void setSolution(ConflictOption conflictOption) {
		solution = conflictOption;
	}

	public ConflictContext getContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), "Description", "Jürgen");
	}
}
