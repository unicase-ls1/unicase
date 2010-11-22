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
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

public class MultiAttributeConflict extends Conflict {

	private final boolean myAdd;

	public MultiAttributeConflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
		DecisionManager decisionManager, boolean myAdd) {
		super(opsA, opsB, decisionManager);
		this.myAdd = myAdd;
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
		ConflictDescription conflictDescription = new ConflictDescription("Multiattribute Conflict");
		conflictDescription.setImage("attribute.gif");
		return conflictDescription;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictOptions(java.util.List)
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption my = new ConflictOption(getLabel(true), OptionType.MyOperation);
		my.getOperations().addAll((myAdd) ? operationsA : operationsB);

		ConflictOption their = new ConflictOption(getLabel(false), OptionType.TheirOperation);
		their.getOperations().addAll((!myAdd) ? operationsA : operationsB);

		options.add(my);
		options.add(their);
	}

	private String getLabel(boolean you) {
		return ((myAdd && you || (!myAdd && !you)) ? "Add" : "Remove") + " ";
	}

	private MultiAttributeOperation getMyOperation() {
		return (myAdd) ? getAdding() : getRemoving();
	}

	private MultiAttributeOperation getTheirOperation() {
		return (!myAdd) ? getAdding() : getRemoving();
	}

	private MultiAttributeOperation getAdding() {
		return (MultiAttributeOperation) operationsA.get(0);
	}

	private MultiAttributeOperation getRemoving() {
		return (MultiAttributeOperation) operationsB.get(0);
	}
}
