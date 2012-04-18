/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.util.SemanticCommand;

/**
 * Handler to execute an operation.
 * 
 * @author herrmi
 */
public abstract class OperationHandlerBase extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.isEmpty()) {
				return null;
			}

			SemanticCompositeOperation operation = initOperation(structuredSelection);
			operation.setCompositeName(EcoreUtil.getAnnotation(operation.eClass(), OperationsPackage.eNS_URI, "label"));
			operation.setCompositeDescription(EcoreUtil.getAnnotation(operation.eClass(), OperationsPackage.eNS_URI,
				"description"));

			Project project = getProject(structuredSelection);
			ExecuteOperationDialog dialog = new ExecuteOperationDialog(operation, project);
			if (dialog.open() == IDialogConstants.OK_ID) {
				ModelElementId id = MetamodelFactory.eINSTANCE.createModelElementId();
				id.setId(getModelElementId(operation).getId());
				operation.setModelElementId(id);
				new SemanticCommand(project, operation).run();
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private ModelElementId getModelElementId(SemanticCompositeOperation operation) {
		EStructuralFeature feature = operation.eClass().getEStructuralFeatures().get(0);
		if (feature.isMany()) {
			return ((List<ModelElementId>) operation.eGet(feature)).get(0);
		} else {
			return (ModelElementId) operation.eGet(feature);
		}
	}

	/**
	 * To be implemented by sub classes to assemble operation based on the selection.
	 * 
	 * @param structuredSelection Selection
	 * @return the semantic operation
	 */
	protected abstract SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection);

	private Project getProject(IStructuredSelection structuredSelection) {
		List<Object> elements = SelectionHelper.getSelectedElements(structuredSelection);
		for (Object element : elements) {
			if (element instanceof EObject) {
				return ModelUtil.getProject((EObject) element);
			}
		}
		return null;
	}
}
