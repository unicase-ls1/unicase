package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

public class SingleReferenceConflict extends Conflict {

	public SingleReferenceConflict(List<AbstractOperation> myOperations,
			List<AbstractOperation> theirOperations,
			DecisionManager decisionManager) {
		super(myOperations, theirOperations, decisionManager);
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), getMyOperation()
				.getFeatureName(), getDecisionManager().getAuthorForOperation(
				getTheirOperation()));
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "You have changed the reference [reference] of [modelelement] to [myvalue]."
				+ "This reference was set to [theirvalue] on the repository. Please decide!";
		ConflictDescription conflictDescription = new ConflictDescription(
				description);
		conflictDescription.add("reference", getMyOperation().getFeatureName());
		conflictDescription.add("modelelement", getDecisionManager()
				.getModelElement(getMyOperation().getModelElementId()));
		ModelElement myNewValue = getDecisionManager().getModelElement(
				getMyOperation().getNewValue());
		conflictDescription.add("myvalue", (myNewValue == null) ? "(unset)"
				: myNewValue);
		ModelElement theirNewValue = getDecisionManager().getModelElement(
				getTheirOperation().getNewValue());
		conflictDescription.add("theirvalue",
				(theirNewValue == null) ? "(unset)" : theirNewValue);

		conflictDescription.setImage("singleref.gif");

		return conflictDescription;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {

		// My Option
		ModelElementId newValue = getMyOperation().getNewValue();
		ConflictOption myOption = new ConflictOption(
				(newValue == null) ? "(unset)" : getDecisionManager()
						.getModelElementName(newValue), OptionType.MyOperation);
		myOption.addOperations(operationsA);

		// Their Option
		ModelElementId theirNewValue = getTheirOperation().getNewValue();
		ConflictOption theirOption = new ConflictOption(
				(theirNewValue == null) ? "(unset)" : getDecisionManager()
						.getModelElementName(theirNewValue),
				OptionType.TheirOperation);
		theirOption.addOperations(operationsB);

		options.add(myOption);
		options.add(theirOption);
	}

	public SingleReferenceOperation getMyOperation() {
		return (SingleReferenceOperation) operationsA.get(0);
	}

	public SingleReferenceOperation getTheirOperation() {
		return (SingleReferenceOperation) operationsB.get(0);
	}

}
