package org.unicase.mergetest.merge.conflicts;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.DecisionManager;

public class AttributeConflict extends Conflict {

	public AttributeConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
	}

	@Override
	public List<String> getOptions() {
		ArrayList<String> options = new ArrayList<String>();
		
		options.add(((AttributeOperation)getMyOperation()).getNewValue().toString());
		options.add(((AttributeOperation)getTheirOperation()).getNewValue().toString());
		
		return options;
	}

	@Override
	public String getConflictDescription() {
		return "An attribute of this ModelElement conflcits";
	}
	
	@Override
	public String getOptionDescription() {
		return "Attribute '"+((AttributeOperation) getMyOperation()).getFeatureName()+"'";
	}
	
	@Override
	public boolean hasAdditionalInformation() {
		return true;
	}
}
