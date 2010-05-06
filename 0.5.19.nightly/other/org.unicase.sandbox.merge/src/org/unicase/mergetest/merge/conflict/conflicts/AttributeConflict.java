package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.options.MergeTextOption;
import org.unicase.mergetest.merge.util.DecisionConfig;

public class AttributeConflict extends Conflict {

	public AttributeConflict(List<AbstractOperation> myOperations,
			List<AbstractOperation> theirOperations,
			DecisionManager decisionManager) {
		super(myOperations, theirOperations, decisionManager);
	}

	public AttributeOperation getMyOperation() {
		return (AttributeOperation) operationsA.get(0);
	}

	public AttributeOperation getTheirOperation() {
		return (AttributeOperation) operationsB.get(0);
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
		String myNewValue = getMyOperation().getNewValue().toString();
		ConflictOption myOption = new ConflictOption(
				(myNewValue == null || myNewValue.length() < 1) ? "(unset)"
						: myNewValue, ConflictOption.OptionType.MyOperation);
		myOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		myOption.addOperations(operationsA);
		options.add(myOption);

		String theirNewValue = getTheirOperation().getNewValue().toString();
		ConflictOption theirOption = new ConflictOption(
				(theirNewValue == null || theirNewValue.length() < 1) ? "(unset)"
						: theirNewValue, ConflictOption.OptionType.TheirOperation);
		theirOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		theirOption.addOperations(operationsB);
		options.add(theirOption);

		MergeTextOption mergeOption = new MergeTextOption();
		mergeOption.add(myOption);
		mergeOption.add(theirOption);
		
		//TODO figure out options
		
		options.add(mergeOption);
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), getMyOperation()
				.getFeatureName(), "Jürgen");
	}
}
