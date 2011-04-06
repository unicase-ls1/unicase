/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.DecisionManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictContext;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictDescription;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionConfig;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Conflict with an {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation} involved.
 * 
 * @author wesendon
 */
public class DeletionConflict extends Conflict {

	/**
	 * Default constructor.
	 * 
	 * @param deletingOperation list of operations, with leading deleting operations
	 * @param deletedOperations list of operation
	 * @param meCausingDelete true, if deleting operation was generated by merging user
	 * @param decisionManager decisionmanager
	 */
	public DeletionConflict(List<AbstractOperation> deletingOperation, List<AbstractOperation> deletedOperations,
		boolean meCausingDelete, DecisionManager decisionManager) {
		super(deletingOperation, deletedOperations, decisionManager, meCausingDelete, false);
		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager(), getLeftOperation(), getTheirOperation());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription(ConflictDescription description) {
		String descriptionTxt = "";

		if (isLeftMy()) {
			descriptionTxt = "You have deleted the [modelelement]."
				+ " This deletion conflicts with a change on the [firstother]" + " element" + generateOthers()
				+ ". Please choose an option.";
		} else {
			descriptionTxt = "The [modelelement] was deleted on the repository which conflicts with"
				+ " the change on your [firstother]" + generateOthers() + ". Please choose an option.";
		}

		description.setDescription(descriptionTxt);
		description.add("modelelement", getLeftOperation().getModelElementId());
		description.add("firstother", getRightOperation().getModelElementId());
		description.add("otherinvolved", generateOthers());
		description.setImage("delete.gif");

		return description;
	}

	private String generateOthers() {
		if (getRightOperations().size() > 1) {
			return " and " + (getRightOperations().size() - 1) + " other elements";
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = new ConflictOption("", OptionType.MyOperation);
		myOption.addOperations(getMyOperations());
		ConflictOption theirOption = new ConflictOption("", OptionType.TheirOperation);
		theirOption.addOperations(getTheirOperations());

		if (isLeftMy()) {
			myOption.setOptionLabel(deleteMsg());
			theirOption.setOptionLabel(keepMsg());
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption.setOptionLabel(keepMsg());
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
			theirOption.setOptionLabel(deleteMsg());
		}

		options.add(myOption);
		options.add(theirOption);
	}

	private String keepMsg() {
		EObject modelElement = getDecisionManager().getModelElement(getRightOperation().getModelElementId());
		String result = "Recover " + DecisionUtil.getClassAndName(modelElement);
		result += generateOthers();
		return result;
	}

	private String deleteMsg() {
		EObject modelElement = getDecisionManager().getModelElement(getLeftOperation().getModelElementId());
		return "Delete " + DecisionUtil.getClassAndName(modelElement);
	}
}
