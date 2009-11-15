package org.unicase.mergetest.merge.conflict;

import java.util.ArrayList;
import java.util.List;

import org.unicase.mergetest.merge.DecisionManager;

public abstract class Conflict {

	private DecisionManager decisionManager;
	private ArrayList<ConflictOption> options;
	private ConflictOption solution;
	private ConflictContext conflictContext;
	private ConflictDescription conflictDescription;

	protected void init(DecisionManager decisionManager) {
		this.decisionManager = decisionManager;
		options = new ArrayList<ConflictOption>();
		initConflictOptions(options);
		initDefaultConflictOptions(options);
		conflictContext = initConflictContext();
		conflictDescription = initConflictDescription();
	}

	private void initDefaultConflictOptions(ArrayList<ConflictOption> options2) {
		options.add(new ConflictOption("Create Issue",
				ConflictOption.OptionType.Issue));
		initConflictContext();
	}

	abstract protected void initConflictOptions(List<ConflictOption> options);

	protected abstract ConflictDescription initConflictDescription();

	protected abstract ConflictContext initConflictContext();

	public ConflictContext getConflictContext() {
		return conflictContext;
	}

	public ConflictDescription getConflictDescription() {
		return conflictDescription;
	}

	public List<ConflictOption> getOptions() {
		return options;
	}

	public boolean isResolved() {
		return (solution != null);
	}

	public boolean hasDetails() {
		for (ConflictOption option : getOptions()) {
			if (option.isDetailsProvider() == true) {
				return true;
			}
		}
		return false;
	}

	public void setSolution(ConflictOption conflictOption) {
		solution = conflictOption;
	}

	public DecisionManager getDecisionManager() {
		return decisionManager;
	}

	public ConflictOption getSolution() {
		return solution;
	}
}
