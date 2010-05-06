/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

/**
 * Conflict between two
 * {@link org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation}
 * . Special case of {@link AttributeConflict}.
 * 
 * @author wesendon
 */
public class DiagramLayoutConflict extends AttributeConflict {

	/**
	 * Default constructor.
	 * 
	 * @param myOperations
	 *            list of my operations
	 * @param theirOperations
	 *            list of their operations
	 * @param decisionManager
	 *            decisionmanager
	 */
	public DiagramLayoutConflict(List<AbstractOperation> myOperations,
			List<AbstractOperation> theirOperations,
			DecisionManager decisionManager) {
		super(myOperations, theirOperations, decisionManager);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription() {
		ConflictDescription description = super.initConflictDescription();
		description
				.setDescription("The diagram layout of [modelelement], which you have edited, was edited on the repository as well.");
		return description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		super.initOptionsWithOutMerge(options, false);
		for (ConflictOption op : options) {
			if (op.getType().equals(OptionType.MyOperation)) {
				op.setOptionLabel("Retain your Layout");
			} else if (op.getType().equals(OptionType.TheirOperation)) {
				op.setOptionLabel("Drop your Layout");
			}
		}
	}

}
