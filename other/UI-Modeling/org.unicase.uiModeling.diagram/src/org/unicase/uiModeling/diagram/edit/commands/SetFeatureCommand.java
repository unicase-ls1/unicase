package org.unicase.uiModeling.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This command sets a constraint for a view in a GMF diagram.
 * 
 * @author mharut
 */
public class SetFeatureCommand extends AbstractTransactionalCommand {

	/**
	 * The view to set the feature for.
	 */
	private View view;
	/**
	 * The feature to set.
	 */
	private EStructuralFeature feature;
	/**
	 * The value to set the feature to.
	 */
	private Object value;

	/**
	 * Initializes this command by specifying the view to adjust, the feature to set and its new value.
	 * 
	 * @param view the view to set the feature for
	 * @param feature the feature to set
	 * @param value the value to set the feature to
	 */
	public SetFeatureCommand(View view, EStructuralFeature feature, Object value) {
		super(TransactionUtil.getEditingDomain(view), "Set View Constraints", null);
		this.view = view;
		this.feature = feature;
		this.value = value;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ViewUtil.setStructuralFeatureValue(view, feature, value);

		return CommandResult.newOKCommandResult();
	}

}
