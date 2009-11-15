package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.options.MergeTextOption;
import org.unicase.mergetest.merge.util.DecisionConfig;

public class AttributeConflict extends Conflict {

	private AttributeOperation myOperation;
	private AttributeOperation theirOperation;

	public AttributeConflict(AttributeOperation myOperation,
			AttributeOperation theirOperation, DecisionManager decisionManager) {
		this.myOperation = myOperation;
		this.theirOperation = theirOperation;
		init(decisionManager);
	}

	public AttributeOperation getMyOperation() {
		return myOperation;
	}

	public AttributeOperation getTheirOperation() {
		return theirOperation;
	}

	protected ConflictDescription initConflictDescription() {
		ConflictDescription conflictDescription = new ConflictDescription(
				"You changed the [attribute] attribute of [modelelement] to [myvalue]."
						+ " This attribute was changed to [theirvalue] on the repository."
						+ " Please decide which value you want to keep.");

		conflictDescription.add("attribute", getMyOperation().getFeatureName());
		conflictDescription.add("modelelement", getDecisionManager()
				.getModelElement(getMyOperation().getModelElementId()));
		conflictDescription.add("myvalue", getMyOperation().getNewValue());
		conflictDescription
				.add("theirvalue", getTheirOperation().getNewValue());
		
		conflictDescription.setImage("attribute.gif");

		return conflictDescription;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption(getMyOperation().getNewValue()
				.toString(), ConflictOption.OptionType.MyOperation);
		myOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		options.add(myOption);
		
		ConflictOption theirOption = new ConflictOption(getTheirOperation().getNewValue()
				.toString(), ConflictOption.OptionType.TheirOperation);
		theirOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		options.add(theirOption);
		
		MergeTextOption mergeOption = new MergeTextOption();
		mergeOption.add(myOption);
		mergeOption.add(theirOption);
		options.add(mergeOption);
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), getMyOperation()
				.getFeatureName(), "Jürgen");
	}
}
