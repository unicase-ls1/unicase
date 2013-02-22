/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.storyboard.part;

import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class StoryboardNewDiagramFileWizard extends Wizard {

	/**
	 * @generated
	 */
	private WizardNewFileCreationPage myFileCreationPage;

	/**
	 * @generated
	 */
	private org.unicase.uiModeling.storyboard.part.ModelElementSelectionPage diagramRootElementSelectionPage;

	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	public StoryboardNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot,
		TransactionalEditingDomain editingDomain) {
		assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
		assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
		assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

		myFileCreationPage = new WizardNewFileCreationPage(
			org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_CreationPageName,
			StructuredSelection.EMPTY);
		myFileCreationPage
			.setTitle(org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_CreationPageTitle);
		myFileCreationPage.setDescription(NLS.bind(
			org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_CreationPageDescription,
			org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID));
		IPath filePath;
		String fileName = URI.decode(domainModelURI.trimFileExtension().lastSegment());
		if (domainModelURI.isPlatformResource()) {
			filePath = new Path(domainModelURI.trimSegments(1).toPlatformString(true));
		} else if (domainModelURI.isFile()) {
			filePath = new Path(domainModelURI.trimSegments(1).toFileString());
		} else {
			// TODO : use some default path
			throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); //$NON-NLS-1$
		}
		myFileCreationPage.setContainerFullPath(filePath);
		myFileCreationPage.setFileName(org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorUtil
			.getUniqueFileName(filePath, fileName, "storyboard_diagram")); //$NON-NLS-1$

		diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(
			org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageName);
		diagramRootElementSelectionPage
			.setTitle(org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageTitle);
		diagramRootElementSelectionPage
			.setDescription(org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageDescription);
		diagramRootElementSelectionPage.setModelElement(diagramRoot);

		myEditingDomain = editingDomain;
	}

	/**
	 * @generated
	 */
	public void addPages() {
		addPage(myFileCreationPage);
		addPage(diagramRootElementSelectionPage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		LinkedList<IFile> affectedFiles = new LinkedList<IFile>();
		IFile diagramFile = myFileCreationPage.createNewFile();
		org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorUtil.setCharset(diagramFile);
		affectedFiles.add(diagramFile);
		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		ResourceSet resourceSet = myEditingDomain.getResourceSet();
		final Resource diagramResource = resourceSet.createResource(diagramModelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
			org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_InitDiagramCommand,
			affectedFiles) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
				int diagramVID = org.unicase.uiModeling.storyboard.part.StoryboardVisualIDRegistry
					.getDiagramVisualID(diagramRootElementSelectionPage.getModelElement());
				if (diagramVID != org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.VISUAL_ID) {
					return CommandResult
						.newErrorCommandResult(org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_IncorrectRootError);
				}
				Diagram diagram = ViewService.createDiagram(diagramRootElementSelectionPage.getModelElement(),
					org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID,
					org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			diagramResource.save(org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorUtil.getSaveOptions());
			org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorUtil.openDiagram(diagramResource);
		} catch (ExecutionException e) {
			org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance().logError(
				"Unable to create model and diagram", e); //$NON-NLS-1$
		} catch (IOException ex) {
			org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance().logError(
				"Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
		} catch (PartInitException ex) {
			org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance().logError(
				"Unable to open editor", ex); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * @generated
	 */
	private static class DiagramRootElementSelectionPage extends
		org.unicase.uiModeling.storyboard.part.ModelElementSelectionPage {

		/**
		 * @generated
		 */
		protected DiagramRootElementSelectionPage(String pageName) {
			super(pageName);
		}

		/**
		 * @generated
		 */
		protected String getSelectionTitle() {
			return org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageSelectionTitle;
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			if (selectedModelElement == null) {
				setErrorMessage(org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
				return false;
			}
			boolean result = ViewService.getInstance().provides(
				new CreateDiagramViewOperation(new EObjectAdapter(selectedModelElement),
					org.unicase.uiModeling.storyboard.edit.parts.StoryboardEditPart.MODEL_ID,
					org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
			setErrorMessage(result ? null
				: org.unicase.uiModeling.storyboard.part.Messages.StoryboardNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
			return result;
		}
	}
}
