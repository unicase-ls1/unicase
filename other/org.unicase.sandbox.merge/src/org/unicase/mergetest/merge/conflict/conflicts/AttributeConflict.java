package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;

public class AttributeConflict extends
		Conflict<AttributeOperation, AttributeOperation> {

	public AttributeConflict(AttributeOperation myOperation,
			AttributeOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
	}

	public ConflictDescription getConflictDescription() {
		ConflictDescription conflictDescription = new ConflictDescription(
				"You changed the [attribute] attribute of [modelelement] to [myvalue]."
						+ " This attribute was changed to [theirvalue] on the repository.");

		conflictDescription.add("attribute", getMyOperation().getFeatureName());
		conflictDescription.add("modelelement", getDecisionManager()
				.getModelElement(getMyOperation().getModelElementId()));
		conflictDescription.add("myvalue", getMyOperation().getNewValue());
		conflictDescription
				.add("theirvalue", getTheirOperation().getNewValue());

		return conflictDescription;
	}

	@Override
	public boolean hasAdditionalInformation() {
		return true;
	}

	@Override
	protected void initOptions(List<ConflictOption> options) {
		options.add(new ConflictOption(getMyOperation().getNewValue()
				.toString(), ConflictOption.OptionType.MyOperation));
		options.add(new ConflictOption(getTheirOperation().getNewValue()
				.toString(), ConflictOption.OptionType.TheirOperation));
	}

	@Override
	public ConflictContext getContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), getMyOperation()
				.getFeatureName(), "Jürgen");
	}
}
