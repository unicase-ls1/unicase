/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class ModelCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected org.unicase.ui.diagram.usecaseDiagram.part.ModelCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected org.unicase.ui.diagram.usecaseDiagram.part.ModelCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(
			boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizardTitle);
		setDefaultPageImageDescriptor(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewDiagramWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new org.unicase.ui.diagram.usecaseDiagram.part.ModelCreationWizardPage(
				"DiagramModelFile", getSelection(), "Usecase_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
				.setTitle(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new org.unicase.ui.diagram.usecaseDiagram.part.ModelCreationWizardPage(
				"DomainModelFile", getSelection(), "model") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length()
							- ".Usecase_diagram".length()); //$NON-NLS-1$
					setFileName(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(),
									fileName, "model")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
				.setTitle(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage
				.setDescription(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				diagram = org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(),
								domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorUtil
								.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog
								.openError(
										getContainer().getShell(),
										org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizardOpenEditorError,
										null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog
						.openError(
								getContainer().getShell(),
								org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelCreationWizardCreationError,
								null, ((CoreException) e.getTargetException())
										.getStatus());
			} else {
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.getInstance()
						.logError(
								"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
