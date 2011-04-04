/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.emfstorebridge.actions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.CommonUtil;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * Action for adding XMI files to workspace.
 * 
 * @author koegel
 */
public class ImportXMIAction implements IActionDelegate {

	private ISelection selection;

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project Files (*.ucm)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucm", "*.*" };

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (selection instanceof TreeSelection) {
			WorkspaceManager.init();
			final Object firstElement = ((TreeSelection) selection).getFirstElement();
			new EMFStoreCommand() {

				@Override
				protected void doRun() {
					runImport(firstElement);
				}
			}.run();
		}

	}

	private void runImport(Object firstElement) {
		if (firstElement instanceof IFile) {
			CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI.getWorkbench().getDisplay()
				.getActiveShell(), null);

			dialog.open();

			final ProjectSpace projectSpace = dialog.getProjectSpace();

			IFile file = (IFile) firstElement;

			final URI fileURI = URI.createFileURI(file.getRawLocationURI().getPath());

			// create resource set and resource
			ResourceSet resourceSet = new ResourceSetImpl();

			final Resource resource = resourceSet.getResource(fileURI, true);

			final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());

			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					importFile(projectSpace, fileURI, resource, progressDialog);
				}

			}.run();

			return;
		}
	}

	private void importFile(final ProjectSpace projectSpace, final URI fileURI, final Resource resource,
		final ProgressMonitorDialog progressDialog) {
		try {
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Import model...", 100);

			Set<EObject> importElements = validation(resource);

			if (importElements.size() > 0) {
				int i = 0;
				for (EObject eObject : importElements) {
					// run the import command
					runImport(projectSpace, fileURI, EcoreUtil.copy(eObject), i);
					progressDialog.getProgressMonitor().worked(10);
					i++;
				}
			}
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			ModelUtil.logException(e);
			// END SUPRESS CATCH EXCEPTION
		} finally {
			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
	}

	// Validates if the EObjects can be imported
	private Set<EObject> validation(Resource resource) {
		Set<EObject> childrenSet = new HashSet<EObject>();
		Set<EObject> rootNodes = new HashSet<EObject>();

		EList<EObject> rootContent = resource.getContents();

		for (EObject rootNode : rootContent) {
			TreeIterator<EObject> contents = rootNode.eAllContents();
			// 1. Run: Put all children in set
			while (contents.hasNext()) {
				EObject content = contents.next();
				if (!(content instanceof EObject)) {
					// TODO: Report to Console //System.out.println(content +
					// " is not a ModelElement and can not be imported");
					continue;
				}
				childrenSet.add(content);
			}
		}

		// 2. Run: Check if RootNodes are children -> set.contains(RootNode) -- no: RootNode in rootNode-Set -- yes:
		// Drop RootNode, will be imported as a child
		for (EObject rootNode : rootContent) {

			if (!(rootNode instanceof EObject)) {
				// No report to Console, because Run 1 will do this
				continue;
			}

			if (!childrenSet.contains(rootNode)) {
				rootNodes.add(rootNode);
			}
		}

		// 3. Check if RootNodes are SelfContained -- yes: import -- no: error
		Set<EObject> notSelfContained = new HashSet<EObject>();
		for (EObject rootNode : rootNodes) {
			if (!CommonUtil.isSelfContained(rootNode)) {
				// TODO: Report to Console //System.out.println(rootNode + " is not selfcontained");
				notSelfContained.add(rootNode);
			}
		}
		rootNodes.removeAll(notSelfContained);

		return rootNodes;
	}

	/**
	 * Runs the import command.
	 * 
	 * @param projectSpace - the projectSpace where the element should be imported in.
	 * @param uri - the uri of the resource.
	 * @param element - the modelElement to import.
	 * @param resourceIndex - the index of the element inside the eResource.
	 */
	private void runImport(final ProjectSpace projectSpace, final org.eclipse.emf.common.util.URI uri,
		final EObject element, final int resourceIndex) {

		// TODO: PlainEObjectMode
		// try to find a wrapper for the element which will be added to the project
		// ModelElement wrapper = ModelElementWrapperDescriptor.getInstance().wrapForImport(projectSpace.getProject(),
		// element, uri, resourceIndex);

		// if no wrapper could be created, use the element itself to add it to the project
		// if (wrapper == null) {
		// wrapper = element;
		// }

		// add the wrapper or the element itself to the project
		// copy wrapper to reset model element ids
		projectSpace.getProject().addModelElement(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

	}

}
