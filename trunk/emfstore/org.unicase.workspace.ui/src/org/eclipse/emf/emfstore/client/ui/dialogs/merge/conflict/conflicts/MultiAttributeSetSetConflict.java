/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.conflicts;

// BEGIN COMPLEX CODE
//
// WORK IN PROGRESS !
//

import java.util.List;

import org.eclipse.emf.emfstore.client.ui.dialogs.merge.DecisionManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictDescription;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public class MultiAttributeSetSetConflict extends Conflict {

	public MultiAttributeSetSetConflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
		DecisionManager decisionManager) {
		super(opsA, opsB, decisionManager);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict#initConflictDescription()
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription description) {

		description
			.setDescription("You have changed an element from the [feature] attribute of [modelelement], which was changed in the repository");

		return description;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption("", OptionType.MyOperation);
		myOption.addOperations(getMyOperations());
		ConflictOption theirOption = new ConflictOption("", OptionType.TheirOperation);
		theirOption.addOperations(getTheirOperations());

		myOption.setOptionLabel("Keep my element");
		theirOption.setOptionLabel("Keep their element");

		options.add(myOption);
		options.add(theirOption);
	}

}
