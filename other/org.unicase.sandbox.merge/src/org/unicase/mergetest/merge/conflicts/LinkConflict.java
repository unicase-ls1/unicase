package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflicts.ConflictOption.OptionType;

public class LinkConflict extends Conflict {

	private String conflictDescription;
	private String optionDescription;
	private AbstractOperation myOperation;
	private AbstractOperation theirOperation;

	public LinkConflict(CompositeOperation myOperation,
			CompositeOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
	}

	@Override
	protected void initOptions(List<ConflictOption> options) {
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
			options.add(new ConflictOption(getDecisionManager()
					.getModelElementName(
							((SingleReferenceOperation) myOperation)
									.getNewValue()), OptionType.MyOperation));

			options.add(new ConflictOption(getDecisionManager()
					.getModelElementName(
							((SingleReferenceOperation) theirOperation)
									.getNewValue()), OptionType.TheirOperation));

		} else if (myOperation instanceof MultiReferenceOperation) {
			optionDescription = "Reference '"
					+ ((MultiReferenceOperation) myOperation).getFeatureName()
					+ "'";
			if (((MultiReferenceOperation) myOperation).isAdd()) {
				conflictDescription = "An Element you've added, was removed in the repository";

				options.add(new ConflictOption("Add "
						+ getDecisionManager().getModelElementName(
								((MultiReferenceOperation) myOperation)
										.getReferencedModelElements().get(0)),
						OptionType.MyOperation));

				options.add(new ConflictOption("Remove "
						+ getDecisionManager().getModelElementName(
								((MultiReferenceOperation) theirOperation)
										.getReferencedModelElements().get(0)),
						OptionType.TheirOperation));
			} else {
				conflictDescription = "An Element you've removed, was added in the repository";

				options.add(new ConflictOption("Remove "
						+ getDecisionManager().getModelElementName(
								((MultiReferenceOperation) myOperation)
										.getReferencedModelElements().get(0)),
						OptionType.MyOperation));

				options.add(new ConflictOption("Add "
						+ getDecisionManager().getModelElementName(
								((MultiReferenceOperation) theirOperation)
										.getReferencedModelElements().get(0)),
						OptionType.TheirOperation));
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
}