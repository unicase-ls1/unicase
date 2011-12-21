/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

/**
 * Container for {@link MultiReferenceConflict} and
 * {@link SingleReferenceConflict}.
 * 
 * @author wesendon
 */
public class ReferenceConflict extends Conflict {

	private final Conflict conflict;

	/**
	 * Default constructor.
	 * 
	 * @param conflict
	 *            underlying conflict, {@link MultiReferenceConflict} or
	 *            {@link SingleReferenceConflict}
	 * @param myOps
	 *            list of my operations
	 * @param theirOps
	 *            list of their operations
	 */
	public ReferenceConflict(Conflict conflict, List<AbstractOperation> myOps,
			List<AbstractOperation> theirOps) {
		super(myOps, theirOps, conflict.getDecisionManager(), false);
		if (!(conflict instanceof SingleReferenceConflict || conflict instanceof MultiReferenceConflict)) {
			throw new IllegalStateException("Only reference conflicts allowed.");
		}
		this.conflict = conflict;
		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean allowOtherOptions() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return conflict.getConflictContext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription() {
		return conflict.getConflictDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		for (ConflictOption option : conflict.getOptions()) {
			if (option.getType() == OptionType.MyOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(operationsA);
			} else if (option.getType() == OptionType.TheirOperation) {
				option.getOperations().clear();
				option.getOperations().addAll(operationsB);
			}
			options.add(option);
		}
	}

}
