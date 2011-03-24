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

import static org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionUtil.getClassAndName;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.DecisionManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictDescription;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;

public class MultiReferenceSetConflict extends Conflict {

	private boolean containmentConflict;

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
		super(multiRef, multiRefSet, decisionManager, myMultiRef, false);
		containmentConflict = ((MultiReferenceOperation) getLeftOperation()).isAdd()
			&& !getLeftOperation().getModelElementId().equals(getRightOperation().getModelElementId());
		init();
	}

	/**
	 * LEFT MultiRef, Right MultiRefSet
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict#initConflictDescription()
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription description) {

		if (containmentConflict) {
			description
				.setDescription("You have moved [target] to the [feature] reference of [modelelement], on the repository it was moved to [othercontainer].");
		} else if (isLeftMy()) {
			description
				.setDescription("You have removed [target] from the [feature] reference of [modelelement], which was set in the repository");
		} else {
			description
				.setDescription("You have set [target] in the [feature] reference of [modelelement], which was removed in the repository.");
		}

		description.add("target", isLeftMy() ? getMyOperation(MultiReferenceOperation.class)
			.getReferencedModelElements().get(0) : getMyOperation(MultiReferenceSetOperation.class).getNewValue());
		description.add("othercontainer", getLeftOperation().getModelElementId());
		description.setImage("multiref.gif");

		return description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict#initConflictOptions(java.util.List)
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption("", OptionType.MyOperation);
		myOption.addOperations(getMyOperations());
		ConflictOption theirOption = new ConflictOption("", OptionType.TheirOperation);
		theirOption.addOperations(getTheirOperations());

		if (containmentConflict) {
			EObject target = getDecisionManager().getModelElement(
				((MultiReferenceOperation) getLeftOperation()).getReferencedModelElements().get(0));

			myOption.setOptionLabel("Move " + getClassAndName(target) + "to"
				+ getClassAndName(getDecisionManager().getModelElement(getMyOperation().getModelElementId())));
			theirOption.setOptionLabel("Move " + getClassAndName(target) + " to"
				+ getClassAndName(getDecisionManager().getModelElement(getTheirOperation().getModelElementId())));

		} else if (isLeftMy()) {
			EObject target = getDecisionManager().getModelElement(
				getMyOperation(MultiReferenceOperation.class).getReferencedModelElements().get(0));

			myOption.setOptionLabel("Remove " + DecisionUtil.getClassAndName(target));
			theirOption.setOptionLabel("Set " + DecisionUtil.getClassAndName(target));
		} else {
			EObject target = getDecisionManager().getModelElement(
				getTheirOperation(MultiReferenceOperation.class).getReferencedModelElements().get(0));

			myOption.setOptionLabel("Set " + DecisionUtil.getClassAndName(target));
			theirOption.setOptionLabel("Remove " + DecisionUtil.getClassAndName(target));
		}

		options.add(myOption);
		options.add(theirOption);

	}
}
