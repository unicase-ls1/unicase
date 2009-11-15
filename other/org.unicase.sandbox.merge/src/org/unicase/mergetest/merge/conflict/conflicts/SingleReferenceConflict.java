package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;

public class SingleReferenceConflict extends Conflict {

	private SingleReferenceOperation myOperation;
	private SingleReferenceOperation theirOperation;

	public SingleReferenceConflict(SingleReferenceOperation myOperation,
			SingleReferenceOperation theirOperation,DecisionManager decisionManager) {
		this.myOperation = myOperation;
		this.theirOperation = theirOperation;
		init(decisionManager);
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), getMyOperation()
				.getFeatureName(), "Jürgen");
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "You have changed the reference [reference] of [modelelement] to [myvalue]"
			+ "This reference was set to [theirvalue] on the repository. Please decide!";
		ConflictDescription conflictDescription = new ConflictDescription(description);
		conflictDescription.add("reference", getMyOperation().getFeatureName());
		conflictDescription.add("modelelement", getDecisionManager().getModelElement(getMyOperation().getModelElementId()));
		conflictDescription.add("myvalue", getDecisionManager().getModelElement(getMyOperation().getNewValue()));
		conflictDescription.add("theirvalue", getDecisionManager().getModelElement(getTheirOperation().getNewValue()));
		
		conflictDescription.setImage("singleref.gif");
		
		return conflictDescription;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		options.add(new ConflictOption(getDecisionManager()
				.getModelElementName((getMyOperation()).getNewValue()),
				OptionType.MyOperation));

		options.add(new ConflictOption(getDecisionManager()
				.getModelElementName(getTheirOperation().getNewValue()),
				OptionType.TheirOperation));
	}

	public SingleReferenceOperation getMyOperation() {
		return myOperation;
	}

	public SingleReferenceOperation getTheirOperation() {
		return theirOperation;
	}

}
