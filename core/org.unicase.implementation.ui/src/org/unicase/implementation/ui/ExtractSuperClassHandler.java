package org.unicase.implementation.ui;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.Project;
import org.unicase.model.implementation.IClass;
import org.unicase.workspace.util.SemanticCommand;

public class ExtractSuperClassHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			List<IClass> subClasses = SelectionHelper
					.getSelectedElements(structuredSelection);

			ExtractSuperClassOperation operation = OperationsFactory.eINSTANCE
					.createExtractSuperClassOperation();
			operation.getSubClasses().addAll(OperationHelper.getIds(subClasses));
			operation.setCompositeName(operation.eClass().getName());
			operation.setCompositeDescription(operation.eClass().getName());

			Project project = subClasses.get(0).getProject();
			ExecuteOperationDialog dialog = new ExecuteOperationDialog(
					operation, project);

			if (dialog.open() == IDialogConstants.OK_ID) {
				operation.setModelElementId(operation.getTargetPackage(project)
						.getModelElementId());

				new SemanticCommand(project, operation).run();
			}
		}

		return null;
	}

}
