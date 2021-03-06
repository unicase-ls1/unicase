/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * Conflict {@link CompositeOperation} involved.
 * 
 * @author wesendon
 */
public class CompositeConflict extends Conflict {

	private final boolean meCausing;

	/**
	 * Default constructor.
	 * 
	 * @param composite
	 *            list of operations, with leading conflicting
	 *            {@link CompositeOperation}
	 * @param other
	 *            list operations which conflict with composite
	 * @param decisionManager
	 *            decisionmanager
	 * @param meCausing
	 *            true, if composite caused by merging user
	 */
	public CompositeConflict(List<AbstractOperation> composite,
			List<AbstractOperation> other, DecisionManager decisionManager,
			boolean meCausing) {
		super(composite, other, decisionManager, false);
		this.meCausing = meCausing;
		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getCompositeOperation().getModelElementId()), "",
				getDecisionManager().getAuthorForOperation(getTheirOperation()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "";
		if (meCausing) {
			description = "A change on the [opposite] from the repository conflicts with your operation \"[compdescription]\".";
		} else {
			description = "Your change on the [opposite] conflicts with the operation \"[compdescription]\" from the repository.";
		}
		ConflictDescription desc = new ConflictDescription(description);
		desc.add("compdescription", getCompositeOperation());
		desc.add("opposite", getDecisionManager().getModelElement(
				getOtherOperation().getModelElementId()));

		desc.setImage("composite.gif");

		return desc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = null;
		ConflictOption theirOption = null;
		if (meCausing) {
			String compName = getCompositeOperation().getCompositeName();
			myOption = new ConflictOption((compName == null) ? "" : compName,
					OptionType.MyOperation);
			myOption.addOperations(operationsA);

			theirOption = new ConflictOption("Change related to "
					+ DecisionUtil.getClassAndName(getDecisionManager()
							.getModelElement(
									getOtherOperation().getModelElementId())),
					OptionType.TheirOperation);
			theirOption.addOperations(operationsB);
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption = new ConflictOption("Change related to "
					+ DecisionUtil.getClassAndName(getDecisionManager()
							.getModelElement(
									getOtherOperation().getModelElementId())),
					OptionType.MyOperation);
			myOption.addOperations(operationsB);
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);

			String compName = getCompositeOperation().getCompositeName();
			theirOption = new ConflictOption(
					(compName == null) ? "" : compName,
					OptionType.TheirOperation);
			theirOption.addOperations(operationsA);
		}
		options.add(myOption);
		options.add(theirOption);
	}

	private CompositeOperation getCompositeOperation() {
		return (CompositeOperation) operationsA.get(0);
	}

	private AbstractOperation getTheirOperation() {
		return (!meCausing) ? operationsA.get(0) : operationsB.get(0);
	}

	private AbstractOperation getOtherOperation() {
		return operationsB.get(0);
	}
}
