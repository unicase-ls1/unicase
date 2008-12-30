package org.unicase.ui.common.diagram;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.Action;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.commands.DeleteFromViewCommand;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 */
public class DeleteFromDiagramAction extends Action {

	/**
	 * This method deletes the diagram element from the diagram's elements list.
	 * 
	 * @see org.eclipse.jface.action#run()
	 */
	@Override
	public void run() {
		EditPart selectedElement = (EditPart) ActionHelper.getSelection();
		ICommand command = null;
		View view = (View) selectedElement.getModel();
		if (view instanceof NodeImpl) {
			DestroyElementRequest destroy = new DestroyElementRequest(WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain(), view.getElement(), false);
			IElementType type = ElementTypeRegistry.getInstance().getElementType(destroy.getEditHelperContext());
			command = (type != null) ? new DeleteFromViewCommand(destroy, selectedElement) : null;
		} else if (view instanceof EdgeImpl) {

			DestroyReferenceRequest req = new DestroyReferenceRequest(((EdgeImpl) view).getSource().getElement(), null,
				((EdgeImpl) view).getTarget().getElement(), false);
			command = new DestroyReferenceCommand(req);

		}

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
