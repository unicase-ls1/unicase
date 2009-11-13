package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.DecisionManager;

public class AttributeConflict extends
		Conflict<AttributeOperation, AttributeOperation> {

	public AttributeConflict(AttributeOperation myOperation,
			AttributeOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
	}

	@Override
	public String getConflictDescription() {
		return "An attribute of this ModelElement conflcits";
	}

	@Override
	public String getOptionDescription() {
		return "Attribute '" + getMyOperation().getFeatureName() + "'";
	}

	@Override
	public boolean hasAdditionalInformation() {
		return true;
	}

	@Override
	protected void initOptions(List<ConflictOption> options) {
		options.add(new ConflictOption(getMyOperation()
				.getNewValue().toString(),
				ConflictOption.OptionType.MyOperation));
		options.add(new ConflictOption(
				getTheirOperation().getNewValue()
						.toString(), ConflictOption.OptionType.TheirOperation));
	}
}
