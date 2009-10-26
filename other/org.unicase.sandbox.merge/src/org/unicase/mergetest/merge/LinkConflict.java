package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

public class LinkConflict extends Conflict {

	private AbstractOperation myOperation;
	private AbstractOperation theirOperation;

	public LinkConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);

		if(myOperation instanceof CompositeOperation){
			this.myOperation = ((CompositeOperation) myOperation).getMainOperation();
		} else {
			this.myOperation = myOperation;
		}
		if(theirOperation instanceof CompositeOperation) {
//			for(AbstractOperation theirOp : ((CompositeOperation) theirOperation).getSubOperations()) {
//				if(getDecisionManager().getConflictDetector().doConflict(myOperation, theirOp)) {
//					this.theirOperation = theirOp;
//				}
//			}
			this.theirOperation = ((CompositeOperation) theirOperation).getMainOperation();
		} else {
			this.theirOperation = theirOperation;
		}
	}

	@Override
	public String getName() {
		return getDecisionManager().getModelElementName(myOperation.getModelElementId());
	}
	
	@Override
	public String getConflictDescription() {
		return "A link of this ModelElement has been edited.";
	}
	
	@Override
	public String getOptionDescription() {
		if(myOperation instanceof SingleReferenceOperation) {
			return ((SingleReferenceOperation) myOperation).getFeatureName();
		} else if(myOperation instanceof MultiReferenceOperation) {
			return ((MultiReferenceOperation) myOperation).getFeatureName();
		}
		return "";
	}
	
	@Override
	List<String> getOptions() {
		ArrayList<String> options = new ArrayList<String>();
		
		options.add(getDecisionManager().getModelElementName(myOperation.getModelElementId()));
		options.add(getDecisionManager().getModelElementName(theirOperation.getModelElementId()));
		
		return options;
	}
}
