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

public class CompositeConflict extends Conflict {

	private final boolean meCausing;

	public CompositeConflict(List<AbstractOperation> composite,
			List<AbstractOperation> other, DecisionManager decisionManager,
			boolean meCausing) {
		super(composite, other, decisionManager, false);
		this.meCausing = meCausing;
		init();
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getCompositeOperation().getModelElementId()), "", "Jürgen");
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "";
		if (meCausing) {
			description = "A change on the [opposite] element from the repository conflicts with your \"[compdescription]\" operation.";
		} else {
			description = "Your change on the [opposite] element conflicts with the \"[compdescription]\" operation from the repository.";
		}
		ConflictDescription desc = new ConflictDescription(description);
		desc.add("compdescription", getCompositeOperation().getDescription());
		desc.add("opposite", getDecisionManager().getModelElementName(
				getOtherOperation().getModelElementId()));

		desc.setImage("composite.gif");

		return desc;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = null;
		ConflictOption theirOption = null;
		if (meCausing) {
			myOption = new ConflictOption(getCompositeOperation().getCompositeName(), OptionType.MyOperation);
			myOption.addOperations(operationsA);
			
			theirOption = new ConflictOption("Change related to "
					+ getDecisionManager().getModelElementName(
							getOtherOperation().getModelElementId()),
					OptionType.TheirOperation);
			theirOption.addOperations(operationsB);
		} else {
			myOption = new ConflictOption("Change related to "
					+ getDecisionManager().getModelElementName(
							getOtherOperation().getModelElementId()),
					OptionType.MyOperation);
			myOption.addOperations(operationsB);
			
			theirOption = new ConflictOption(getCompositeOperation().getCompositeName(), OptionType.TheirOperation);
			theirOption.addOperations(operationsA);
		}
		options.add(myOption);
		options.add(theirOption);
	}

	public CompositeOperation getCompositeOperation() {
		return (CompositeOperation) ((meCausing) ? operationsA.get(0) : operationsB.get(0));
	}

	public AbstractOperation getOtherOperation() {
		return (!meCausing) ? operationsA.get(0) : operationsB.get(0);
	}
}
