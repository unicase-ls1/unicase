/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.workspace.util.SemanticCommand;

/**
 * Handler to execute an operation.
 * 
 * @author herrmi
 */
public abstract class OperationHandlerBase extends AbstractHandler {

	/**
	 * Type of the operation.
	 */
	private final EClass operationClass;

	/**
	 * First parameter of the operation.
	 */
	private final EReference firstParameter;

	/**
	 * Constructor.
	 * 
	 * @param operationClass Type of the operation
	 */
	protected OperationHandlerBase(EClass operationClass) {
		this.operationClass = operationClass;
		this.firstParameter = operationClass.getEReferences().get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			SemanticCompositeOperation operation = (SemanticCompositeOperation) EcoreUtil.create(operationClass);

			ModelElement element = null;
			if (firstParameter.isMany()) {
				List<? extends ModelElement> elements = (List<? extends ModelElement>) SelectionHelper
					.getSelectedElements(structuredSelection);
				element = elements.get(0);
				operation.eSet(firstParameter, OperationHelper.getIds(elements));
			} else {
				element = (ModelElement) SelectionHelper.getSelectedElement(structuredSelection);
				operation.eSet(firstParameter, OperationHelper.getId(element));
			}
			operation.setCompositeName(operation.eClass().getName());
			operation.setCompositeDescription(operation.eClass().getName());

			Project project = element.getProject();
			ExecuteOperationDialog dialog = new ExecuteOperationDialog(operation, project);

			if (dialog.open() == IDialogConstants.OK_ID) {
				operation.setModelElementId(element.getModelElementId());

				new SemanticCommand(project, operation).run();
			}
		}

		return null;
	}
}
