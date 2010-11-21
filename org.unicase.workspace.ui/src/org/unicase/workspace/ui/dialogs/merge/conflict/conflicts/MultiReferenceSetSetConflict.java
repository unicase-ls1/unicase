/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

// BEGIN COMPLEX CODE
//
// WORK IN PROGRESS !
//

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;

public class MultiReferenceSetSetConflict extends Conflict {

	public MultiReferenceSetSetConflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
		DecisionManager decisionManager) {
		super(opsA, opsB, decisionManager);
	}

	@Override
	protected ConflictContext initConflictContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		// TODO Auto-generated method stub

	}

}
