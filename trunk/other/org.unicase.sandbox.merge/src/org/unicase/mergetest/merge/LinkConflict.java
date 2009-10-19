package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public class LinkConflict extends Conflict {

	public LinkConflict(AbstractOperation myOperation,
			AbstractOperation theirOperation, DecisionManager decisionManager) {
		super(myOperation, theirOperation, decisionManager);
	}

	@Override
	List<String> getOptions() {
		ArrayList<String> options = new ArrayList<String>();
		
		options.add("my");
		options.add("their");
		
		return options;
	}

}
