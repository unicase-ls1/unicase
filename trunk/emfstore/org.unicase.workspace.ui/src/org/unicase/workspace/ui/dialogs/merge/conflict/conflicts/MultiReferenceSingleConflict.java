/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.getClassAndName;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

/**
 * @author wesendon
 */
public class MultiReferenceSingleConflict extends Conflict {

	/**
	 * Default constructor.
	 * 
	 * @param leftOperations multi ref
	 * @param rightOperations single ref
	 * @param decisionManager decision maanger
	 * @param multiLeft multi is lef
	 */
	public MultiReferenceSingleConflict(List<AbstractOperation> leftOperations,
		List<AbstractOperation> rightOperations, DecisionManager decisionManager, boolean multiLeft) {
		super(leftOperations, rightOperations, decisionManager, multiLeft, true);
	}

	/**
	 * LEFT: MultiReference, RIGHT: SingleReference
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictDescription(org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription)
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription description) {
		String descriptionTxt = "You have moved [target] to the [feature] reference of [modelelement], on the repository it was moved to [othercontainer].";

		description.setDescription(descriptionTxt);
		description.add("target", ((MultiReferenceOperation) getLeftOperation()).getReferencedModelElements().get(0));
		description.add("othercontainer", getTheirOperation().getModelElementId());

		description.setImage("multiref.gif");
		return description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.Conflict#initConflictOptions(java.util.List)
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption("", OptionType.MyOperation);
		myOption.addOperations(getMyOperations());
		ConflictOption theirOption = new ConflictOption("", OptionType.TheirOperation);
		theirOption.addOperations(getTheirOperations());

		EObject target = getDecisionManager().getModelElement(
			((MultiReferenceOperation) getLeftOperation()).getReferencedModelElements().get(0));

		myOption.setOptionLabel("Move " + getClassAndName(target) + "to"
			+ getClassAndName(getDecisionManager().getModelElement(getMyOperation().getModelElementId())));
		theirOption.setOptionLabel("Move " + getClassAndName(target) + " to"
			+ getClassAndName(getDecisionManager().getModelElement(getTheirOperation().getModelElementId())));

		options.add(myOption);
		options.add(theirOption);
	}

}
