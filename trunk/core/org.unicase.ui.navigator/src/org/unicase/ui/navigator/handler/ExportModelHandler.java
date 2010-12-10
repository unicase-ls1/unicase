/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.PreferenceHelper;
import org.unicase.ui.util.UiUtil;

/**
 * Handles the export of ModelElements from a project.
 */
public class ExportModelHandler extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project Files (*.ucm)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucm", "*.*" };

	private static final String EXPORT_MODEL_PATH = "org.unicase.workspace.ui.exportModelPath";

	private EditingDomain domain;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final List<EObject> exportModelElements = getSelfContainedModelElementTree(event);

		if (exportModelElements.size() > 0) {

			String filePath = getFilePathByFileDialog(UiUtil.getNameForModelElement(exportModelElements.get(0)));

			if (filePath == null) {
				return null;
			}

			PreferenceHelper.setPreference(EXPORT_MODEL_PATH, new File(filePath).getParent());

			runCommand(exportModelElements, filePath);

		}

		return null;
	}

	private void runCommand(final List<EObject> exportModelElements, String filePath) {
		final File file = new File(filePath);

		final URI uri = URI.createFileURI(filePath);

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		new ECPCommand(domain, exportModelElements.get(0)) {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export modelelement...", 100);
					progressDialog.getProgressMonitor().worked(10);
					saveEObjectToResource(exportModelElements, uri);
					MessageDialog.openInformation(null, "Export", "Exported modelelement to file " + file.getName());
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e.getMessage(), e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}.run();
	}

	private List<EObject> getSelfContainedModelElementTree(ExecutionEvent event) {
		List<EObject> result = new ArrayList<EObject>();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strucSel = null;
		EObject copyModelElement = null;

		if (selection != null && selection instanceof IStructuredSelection) {
			strucSel = (IStructuredSelection) selection;
			Object firstElement = strucSel.getFirstElement();
			if (firstElement instanceof EObject) {
				domain = AdapterFactoryEditingDomain.getEditingDomainFor(firstElement);
				// TODO: ChainSaw - check whether specific clone functionality of ModelUtil is needed here
				copyModelElement = EcoreUtil.copy((EObject) firstElement);
				// copyModelElement = ModelUtil.clone((EObject) firstElement);

				// only export the rootnode makes xml with references, otherwise (see (commented) line two) the children
				// will be "real" nested as containments of the node (is not necessary)
				result.add(copyModelElement);
				// result.addAll(copyModelElement.getAllContainedModelElements());

			} else {
				// do nothing System.out.println("NOT A MODELELEMENT");
			}
		}

		return result;
	}

	private String getFilePathByFileDialog(String modelElementName) {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(FILTER_NAMES);
		dialog.setFilterExtensions(FILTER_EXTS);
		String initialPath = PreferenceHelper.getPreference(EXPORT_MODEL_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		dialog.setOverwrite(true);

		try {
			// String initialFileName = projectSpace.getProjectName() + "@"
			// + projectSpace.getBaseVersion().getIdentifier() + ".ucp";
			String initialFileName = "ModelElement_" + modelElementName + ".ucm";
			dialog.setFileName(initialFileName);

		} catch (NullPointerException e) {
			// do nothing
		}

		String filePath = dialog.open();

		return filePath;
	}

	/**
	 * Save a list of EObjects to the resource with the given URI.
	 * 
	 * @param eObjects the EObjects to be saved
	 * @param resourceURI the URI of the resource, which should be used to save the EObjects
	 * @throws IOException if saving to the resource fails
	 */
	public void saveEObjectToResource(List<? extends EObject> eObjects, URI resourceURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(resourceURI);
		EList<EObject> contents = resource.getContents();

		for (EObject eObject : eObjects) {
			contents.add(eObject);
		}

		contents.addAll(eObjects);
		resource.save(null);
	}

	/**
	 * Save an EObject to a resource.
	 * 
	 * @param eObject the object
	 * @param resourceURI the resources URI
	 * @throws IOException if saving to the resource fails.
	 */
	public void saveEObjectToResource(EObject eObject, URI resourceURI) throws IOException {
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		saveEObjectToResource(list, resourceURI);
	}
}
