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

	private final AbstractOperation deletingOperation;
	private final List<AbstractOperation> listOfDeleted;
	private final boolean meCausingDelete;

	public DeletionConflict(AbstractOperation deletingOperation,
			List<AbstractOperation> listOfDeleted, boolean meCausingDelete, DecisionManager decisionManager) {
		this.deletingOperation = deletingOperation;
		this.listOfDeleted = listOfDeleted;
		this.meCausingDelete = meCausingDelete;
		init(decisionManager);
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getMyOperation().getModelElementId()), "", "Jürgen");
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
		conflictDescription.add("modelelement", getDecisionManager().getModelElementName(deletingOperation.getModelElementId()));
		conflictDescription.add("firstother", getDecisionManager().getModelElementName(listOfDeleted.get(0).getModelElementId()));
		
		conflictDescription.add("otherinvolved", generateOthers());
		
		conflictDescription.setImage("delete.gif");

		return conflictDescription;
	}

	private String generateOthers() {
		if(listOfDeleted.size()>1) {
			return " and "+(listOfDeleted.size()-1)+" other elements";
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

			theirOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.MyOperation);
			theirOption.addOperations(listOfDeleted);
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.MyOperation);
			myOption.addOperations(listOfDeleted);
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
			
			theirOption = new ConflictOption(generateDeleteMessage(),
					ConflictOption.OptionType.TheirOperation);
		}
		options.add(myOption);
		options.add(theirOption);
	}

	private String generateKeepMessage() {
		String result = "Recover "
				+ getDecisionManager().getModelElementName(
						listOfDeleted.get(0).getModelElementId());
		if (listOfDeleted.size() > 1) {
			result += "and " + (listOfDeleted.size() - 1) + "other Elements";
		}
		return result;
	}

	private String generateDeleteMessage() {
		return "Delete "
				+ getDecisionManager().getModelElementName(
						deletingOperation.getModelElementId());
	}

	private AbstractOperation getMyOperation() {
		return (meCausingDelete) ? deletingOperation : listOfDeleted.get(0);
	}

}
