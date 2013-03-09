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

public class SetConstraintCommand extends AbstractTransactionalCommand {

	private View view;
	private EStructuralFeature feature;
	private Object value;

	public SetConstraintCommand(View view, EStructuralFeature feature, Object value) {
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
