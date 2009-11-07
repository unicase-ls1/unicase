package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.mergetest.merge.DecisionManager;

public class LinkConflict extends Conflict {

	private String conflictDescription;
	private String optionDescription;
	private AbstractOperation myOperation;
	private AbstractOperation theirOperation;
	private ArrayList<String> options;

	public LinkConflict(CompositeOperation myOperation,
			CompositeOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
		options = new ArrayList<String>();
		init();
	}

	private void init() {
		for (AbstractOperation myOp : ((CompositeOperation) getMyOperation())
				.getSubOperations()) {
			for (AbstractOperation theirOp : ((CompositeOperation) getTheirOperation())
					.getSubOperations()) {
				if (getDecisionManager().getConflictDetector().doConflict(myOp,
						theirOp)) {
					this.myOperation = myOp;
					this.theirOperation = theirOp;
					break;
				}
			}
		}
		if (myOperation instanceof SingleReferenceOperation) {
			conflictDescription = "Another ModelElement was referenced to your Element.";
			optionDescription = "Reference '"
					+ ((SingleReferenceOperation) myOperation).getFeatureName()
					+ "'";
			options.add(getDecisionManager().getModelElementName(
					((SingleReferenceOperation) myOperation).getNewValue()));
			options.add(getDecisionManager().getModelElementName(
					((SingleReferenceOperation) theirOperation).getNewValue()));
		} else if (myOperation instanceof MultiReferenceOperation) {
			optionDescription = "Reference '"
					+ ((MultiReferenceOperation) myOperation).getFeatureName()
					+ "'";
			if (((MultiReferenceOperation) myOperation).isAdd()) {
				conflictDescription = "An Element you've added, was removed in the repository";
				options.add("Add "+getDecisionManager().getModelElementName(
						((MultiReferenceOperation) myOperation)
								.getReferencedModelElements().get(0)));
				options.add("Remove "+getDecisionManager().getModelElementName(
						((MultiReferenceOperation) theirOperation)
								.getReferencedModelElements().get(0)));
			} else {
				conflictDescription = "An Element you've removed, was added in the repository";
				options.add("Remove "+getDecisionManager().getModelElementName(
						((MultiReferenceOperation) myOperation)
								.getReferencedModelElements().get(0)));
				options.add("Add "+getDecisionManager().getModelElementName(
						((MultiReferenceOperation) theirOperation)
								.getReferencedModelElements().get(0)));
			}
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public String getConflictDescription() {
		return conflictDescription;
	}

	@Override
	public String getOptionDescription() {
		return optionDescription;
	}

	@Override
	public List<String> getOptions() {
		return options;
	}
}
