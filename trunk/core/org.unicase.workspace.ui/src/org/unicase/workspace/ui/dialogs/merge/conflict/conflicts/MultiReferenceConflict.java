package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class MultiReferenceConflict extends Conflict {

	private final boolean meAdding;

	public MultiReferenceConflict(List<AbstractOperation> addingOperation, List<AbstractOperation> removingOperation,
		DecisionManager decisionManager, boolean meAdding) {
		super(addingOperation, removingOperation, decisionManager, false);
		this.meAdding = meAdding;
		init();
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(getMyOperation().getModelElementId()),
			getMyOperation().getFeatureName(), getDecisionManager().getAuthorForOperation(getTheirOperation()));
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "";
		if (meAdding) {
			description = "You have added [target] to the [featurename]" + " reference of the [element]."
				+ " This item was removed on the repository.";
		} else {
			description = "The [target] was added to the [featurename] reference"
				+ " of the [element] on the repository." + " You chose to remove it, please decide.";
		}
		ConflictDescription confDescription = new ConflictDescription(description);
		confDescription.add("element", getDecisionManager().getModelElement(getMyOperation().getModelElementId()));
		confDescription.add("featurename", getMyOperation().getFeatureName());
		confDescription.add("target", getDecisionManager().getModelElement(
			getMyOperation().getReferencedModelElements().get(0)));

		confDescription.setImage("multiref.gif");

		return confDescription;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = null;
		ConflictOption theirOption = null;
		if (meAdding) {
			ModelElement target = getDecisionManager().getModelElement(
				getMyOperation().getReferencedModelElements().get(0));
			myOption = new ConflictOption("Add " + DecisionUtil.getClassAndName(target), OptionType.MyOperation);
			myOption.addOperations(getAddingOperations());

			theirOption = new ConflictOption("Remove " + DecisionUtil.getClassAndName(target),
				OptionType.TheirOperation);
			theirOption.addOperations(getRemovingOperations());
		} else {
			ModelElement target = getDecisionManager().getModelElement(
				getMyOperation().getReferencedModelElements().get(0));
			myOption = new ConflictOption("Remove " + DecisionUtil.getClassAndName(target), OptionType.MyOperation);
			myOption.addOperations(getRemovingOperations());

			theirOption = new ConflictOption("Add " + DecisionUtil.getClassAndName(target), OptionType.TheirOperation);
			theirOption.addOperations(getAddingOperations());
		}
		options.add(myOption);
		options.add(theirOption);
	}

	private MultiReferenceOperation getMyOperation() {
		return (meAdding) ? getAddingOperation() : getRemovingOperation();
	}

	private MultiReferenceOperation getTheirOperation() {
		return (!meAdding) ? getAddingOperation() : getRemovingOperation();
	}

	private MultiReferenceOperation getAddingOperation() {
		return (MultiReferenceOperation) operationsA.get(0);
	}

	private MultiReferenceOperation getRemovingOperation() {
		return (MultiReferenceOperation) operationsB.get(0);
	}

	private List<AbstractOperation> getAddingOperations() {
		return operationsA;
	}

	private List<AbstractOperation> getRemovingOperations() {
		return operationsB;
	}
}
