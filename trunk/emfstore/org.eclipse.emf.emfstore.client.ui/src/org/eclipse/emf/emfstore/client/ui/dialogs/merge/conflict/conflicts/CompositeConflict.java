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

import org.eclipse.emf.emfstore.client.ui.dialogs.merge.DecisionManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictContext;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictDescription;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionConfig;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;

/**
 * Conflict {@link CompositeOperation} involved.
 * 
 * @author wesendon
 */
public class CompositeConflict extends Conflict {

	/**
	 * Default constructor.
	 * 
	 * @param composite list of operations, with leading conflicting {@link CompositeOperation}
	 * @param other list operations which conflict with composite
	 * @param decisionManager decisionmanager
	 * @param meCausing true, if composite caused by merging user
	 */
	public CompositeConflict(List<AbstractOperation> composite, List<AbstractOperation> other,
		DecisionManager decisionManager, boolean meCausing) {
		super(composite, other, decisionManager, meCausing, false);
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
			descriptionTxt = "A change on the [opposite] from the repository conflicts with your operation \"[compdescription]\".";
		} else {
			descriptionTxt = "Your change on the [opposite] conflicts with the operation \"[compdescription]\" from the repository.";
		}
		description.setDescription(descriptionTxt);

		description.add("compdescription", getLeftOperation());
		description.add("opposite", getDecisionManager().getModelElement(getRightOperation().getModelElementId()));

		description.setImage("composite.gif");

		return description;
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

		String composite = ((CompositeOperation) getLeftOperation()).getCompositeName();
		String other = "Change related to "
			+ DecisionUtil.getClassAndName(getDecisionManager()
				.getModelElement(getRightOperation().getModelElementId()));

		if (isLeftMy()) {
			myOption.setOptionLabel(composite);

			theirOption.setOptionLabel(other);
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption.setOptionLabel(other);
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);

			theirOption.setOptionLabel(composite);
		}
		options.add(myOption);
		options.add(theirOption);
	}
}
