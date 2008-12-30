package org.unicase.ui.common.diagram;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.commands.DeleteFromViewCommand;
import org.unicase.workspace.WorkspaceManager;

public class DeleteFromDiagramAction extends Action {

	@Override
	public void run() {
		EditPart selectedElement = (EditPart) ActionHelper.getSelection();
		DestroyElementRequest destroy = new DestroyElementRequest(WorkspaceManager.getInstance().getCurrentWorkspace()
			.getEditingDomain(), ((View) selectedElement.getModel()).getElement(), false);
		IElementType type = ElementTypeRegistry.getInstance().getElementType(destroy.getEditHelperContext());
		ICommand command = (type != null) ? new DeleteFromViewCommand(destroy, selectedElement) : null;
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
