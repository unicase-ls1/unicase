/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * Conflict for two attribute operations.
 * 
 * @author wesendon
 */
public class AttributeConflict extends Conflict {

	/**
	 * Default constructor.
	 * 
	 * @param myOperations myOperations, with leading {@link AttributeOperation}
	 * @param theirOperations theirOperations, with leading {@link AttributeOperation}
	 * @param decisionManager decisionmanager
	 */
	public AttributeConflict(List<AbstractOperation> myOperations, List<AbstractOperation> theirOperations,
		DecisionManager decisionManager) {
		super(myOperations, theirOperations, decisionManager);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictDescription initConflictDescription() {
		ConflictDescription conflictDescription = new ConflictDescription(
			"You have changed the [attribute] attribute of [modelelement] to [myvalue]."
				+ " This attribute was changed to [theirvalue] on the repository."
		/* + " Please decide which value you want to keep." */);

		conflictDescription.add("attribute", getMyOperation().getFeatureName());
		ModelElement modelElement = getDecisionManager().getModelElement(getMyOperation().getModelElementId());
		// conflictDescription.add("type", modelElement.eClass().getName());
		conflictDescription.add("modelelement", modelElement);
		conflictDescription.add("myvalue", getMyOperation().getNewValue());
		conflictDescription.add("theirvalue", getTheirOperation().getNewValue());

		conflictDescription.setImage("attribute.gif");

		return conflictDescription;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		initOptionsWithOutMerge(options, true);
	}

	/**
	 * Allows to init options, without adding a merge text option.
	 * 
	 * @param options list of options
	 * @param withMerge true, if merge text option ({@link MergeTextOption}) should be added
	 */
	protected void initOptionsWithOutMerge(List<ConflictOption> options, boolean withMerge) {
		String myNewValue = getMyOperation().getNewValue().toString();
		ConflictOption myOption = new ConflictOption((myNewValue == null || myNewValue.length() < 1) ? "(unset)"
			: myNewValue, ConflictOption.OptionType.MyOperation);
		myOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		myOption.addOperations(operationsA);
		options.add(myOption);

		String theirNewValue = getTheirOperation().getNewValue().toString();
		ConflictOption theirOption = new ConflictOption(
			(theirNewValue == null || theirNewValue.length() < 1) ? "(unset)" : theirNewValue,
			ConflictOption.OptionType.TheirOperation);
		theirOption.setDetailProvider(DecisionConfig.WIDGET_MULTILINE);
		theirOption.addOperations(operationsB);
		options.add(theirOption);

		if (withMerge && DecisionUtil.detailsNeeded(this)) {
			MergeTextOption mergeOption = new MergeTextOption();
			mergeOption.add(myOption);
			mergeOption.add(theirOption);
			options.add(mergeOption);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(getMyOperation().getModelElementId()),
			getMyOperation().getFeatureName(), getDecisionManager().getAuthorForOperation(getTheirOperation()));
	}

	private AttributeOperation getMyOperation() {
		return (AttributeOperation) operationsA.get(0);
	}

	private AttributeOperation getTheirOperation() {
		return (AttributeOperation) operationsB.get(0);
	}
}
