package org.unicase.mergetest.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictContext;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.util.DecisionConfig;

public class DeletionConflict extends Conflict {

	private final boolean meCausingDelete;

	public DeletionConflict(List<AbstractOperation> deletingOperation,
			List<AbstractOperation> deletedOperations, boolean meCausingDelete,
			DecisionManager decisionManager) {
		super(deletingOperation, deletedOperations, decisionManager,false);
		this.meCausingDelete = meCausingDelete;
		init();
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getDeletingOperation().getModelElementId()), "", "Jürgen");
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "";

		if (meCausingDelete) {
			description = "You have delted the element [modelelement]."
					+ " This deletion conflicts with the change on [firstother]"
					+ " element"+generateOthers()+". Either confirm your delete or keep"
					+ " the changes from the repository.";
		} else {
			description = "The element [modelelement] was deleted on the repository which conflicts with"
					+ " the change on your element [firstother]"+generateOthers()+"."
					+ "Deny the deletion or drop your changes.";
		}

		ConflictDescription conflictDescription = new ConflictDescription(
				description);
		conflictDescription.add("modelelement", getDecisionManager().getModelElementName(getDeletingOperation().getModelElementId()));
		conflictDescription.add("firstother", getDecisionManager().getModelElementName(getDeletedOperations().get(0).getModelElementId()));
		
		conflictDescription.add("otherinvolved", generateOthers());
		
		conflictDescription.setImage("delete.gif");

		return conflictDescription;
	}

	private String generateOthers() {
		if(getDeletedOperations().size()>1) {
			return " and "+(getDeletedOperations().size()-1)+" other elements";
		}
		return "";
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = null;
		ConflictOption theirOption = null;
		if (meCausingDelete) {
			myOption = new ConflictOption(generateDeleteMessage(),
					ConflictOption.OptionType.MyOperation);
			myOption.addOperations(getDeletingOperations());
			
			theirOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.MyOperation);
			theirOption.addOperations(getDeletedOperations());
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.MyOperation);
			myOption.addOperations(getDeletedOperations());
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
			
			theirOption = new ConflictOption(generateDeleteMessage(),
					ConflictOption.OptionType.TheirOperation);
			theirOption.addOperations(getDeletingOperations());
		}
		options.add(myOption);
		options.add(theirOption);
	}

	private String generateKeepMessage() {
		String result = "Recover "
				+ getDecisionManager().getModelElementName(
						getDeletedOperations().get(0).getModelElementId());
		if (getDeletedOperations().size() > 1) {
			result += " and " + (getDeletedOperations().size() - 1) + "other elements";
		}
		return result;
	}

	private String generateDeleteMessage() {
		return "Delete "
				+ getDecisionManager().getModelElementName(
						getDeletingOperation().getModelElementId());
	}

	private AbstractOperation getDeletingOperation() {
		return operationsA.get(0);
	}
	
	private List<AbstractOperation> getDeletingOperations() {
		return operationsA;
	}
	
	private List<AbstractOperation> getDeletedOperations() {
		return operationsB;
	}
}
