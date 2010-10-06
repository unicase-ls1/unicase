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

import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.getClassAndName;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class MultiReferenceSetSetConflict extends Conflict {

	private boolean containmentConflict;

	public MultiReferenceSetSetConflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
		DecisionManager decisionManager) {
		super(opsA, opsB, decisionManager, true, false);
		// is this rule enough?
		containmentConflict = getMyOperation().getModelElementId().equals(getTheirOperation().getModelElementId());
		init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictDescription()
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription description) {
		String txt = "";
		if (!containmentConflict) {
			txt = "You have set the value [value] to the [feature] reference of [modelelement], it was set to [ovalue] on the repository";
		} else {
			txt = "You have moved the element [value] to [modelelement], it was moved to [othercontainer] on the repository.";
		}

		description.add("value", getMyOperation(MultiReferenceSetOperation.class).getNewValue());
		description.add("ovalue", getTheirOperation(MultiReferenceSetOperation.class).getNewValue());
		description.add("othercontainer", getTheirOperation().getModelElementId());
		description.setDescription(txt);
		description.setImage("multiref.gif");
		return description;
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption("", OptionType.MyOperation);
		myOption.addOperations(getMyOperations());
		ConflictOption theirOption = new ConflictOption("", OptionType.TheirOperation);
		theirOption.addOperations(getTheirOperations());

		if (!containmentConflict) {
			myOption.setOptionLabel(DecisionUtil.getClassAndName(getDecisionManager().getModelElement(
				getMyOperation(MultiReferenceSetOperation.class).getNewValue())));
			theirOption.setOptionLabel(DecisionUtil.getClassAndName(getDecisionManager().getModelElement(
				getTheirOperation(MultiReferenceSetOperation.class).getNewValue())));
		} else {
			ModelElement target = getDecisionManager().getModelElement(
				getMyOperation(MultiReferenceSetOperation.class).getNewValue());

			myOption.setOptionLabel("Move " + getClassAndName(target) + "to"
				+ getClassAndName(getDecisionManager().getModelElement(getMyOperation().getModelElementId())));
			theirOption.setOptionLabel("Move " + getClassAndName(target) + " to"
				+ getClassAndName(getDecisionManager().getModelElement(getTheirOperation().getModelElementId())));
		}

		options.add(myOption);
		options.add(theirOption);
	}
}
