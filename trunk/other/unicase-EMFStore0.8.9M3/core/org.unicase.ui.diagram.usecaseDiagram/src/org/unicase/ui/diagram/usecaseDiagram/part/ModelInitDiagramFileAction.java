/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @generated
 */
public class ModelInitDiagramFileAction implements
		IWorkbenchWindowActionDelegate {

	/**
	 * @generated
	 */
	private IWorkbenchWindow window;

	/**
	 * @generated
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	/**
	 * @generated
	 */
	public void dispose() {
		window = null;
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * @generated
	 */
	private Shell getShell() {
		return window.getShell();
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		Resource resource = org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorUtil
				.openModel(
						getShell(),
						org.unicase.ui.diagram.usecaseDiagram.part.Messages.InitDiagramFile_OpenModelFileDialogTitle,
						editingDomain);
		if (resource == null || resource.getContents().isEmpty()) {
			return;
		}
		EObject diagramRoot = (EObject) resource.getContents().get(0);
		Wizard wizard = new org.unicase.ui.diagram.usecaseDiagram.part.ModelNewDiagramFileWizard(
				resource.getURI(), diagramRoot, editingDomain);
		wizard
				.setWindowTitle(NLS
						.bind(
								org.unicase.ui.diagram.usecaseDiagram.part.Messages.InitDiagramFile_WizardTitle,
								org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID));
		org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorUtil
				.runWizard(getShell(), wizard, "InitDiagramFile"); //$NON-NLS-1$
	}
}
