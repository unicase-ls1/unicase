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
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;

public class MultiReferenceSetConflict extends Conflict {

	private final boolean myMultiRef;

	/**
	 * Default constructor.
	 * 
	 * @param multiRef multireference in conflict
	 * @param multiRefSet multireference set in conflict
	 * @param decisionManager decisionmanager
	 * @param myMultiRef is my multireference
	 */
	public MultiReferenceSetConflict(List<AbstractOperation> multiRef, List<AbstractOperation> multiRefSet,
		DecisionManager decisionManager, boolean myMultiRef) {
		super(multiRef, multiRefSet, decisionManager);
		this.myMultiRef = myMultiRef;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictContext()
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(getMyOperation().getModelElementId()),
			getMyOperation().getFeatureName(), getDecisionManager().getAuthorForOperation(getTheirOperation()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictDescription()
	 */
	@Override
	protected ConflictDescription initConflictDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictOptions(java.util.List)
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		// TODO Auto-generated method stub

	}

	private FeatureOperation getMyOperation() {
		return (myMultiRef) ? getMultiOperation() : getSetOperation();
	}

	private FeatureOperation getTheirOperation() {
		return (!myMultiRef) ? getMultiOperation() : getSetOperation();
	}

	private MultiReferenceOperation getMultiOperation() {
		return (MultiReferenceOperation) operationsA.get(0);
	}

	private MultiReferenceSetOperation getSetOperation() {
		return (MultiReferenceSetOperation) operationsB.get(0);
	}

}
