package org.unicase.uiModeling.diagram.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;

public class QuickSelectEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		EditPart editPart = getTargetEditPart(request);
		EObject element = EditPartUtility.getElement(editPart);
		if (element instanceof RadioButton) {
			return new ICommandProxy(new SetRadioSelectionCommand((RadioButton) element));
		}
		return null;
	}

	public static class SetRadioSelectionCommand extends AbstractTransactionalCommand {

		private final RadioButton button;

		public SetRadioSelectionCommand(RadioButton button) {
			super(TransactionUtil.getEditingDomain(button), "Set Selected Radio Button", null);
			this.button = button;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
			RadioGroup group = button.getGroup();
			if (group != null) {
				RadioButton selected = group.getSelectedItem();
				if (selected == button) {
					group.setSelectedItem(null);
				} else {
					group.setSelectedItem(button);
				}
			}
			return CommandResult.newOKCommandResult();
		}

	}

}
