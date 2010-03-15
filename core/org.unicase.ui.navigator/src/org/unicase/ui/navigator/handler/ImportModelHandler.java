/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigator.dialogs.ImportResourcesDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.ModelElementWrapperDescriptor;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handles the import of ModelElements into a project.
 */
public class ImportModelHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		if (projectSpace == null) {
			return null;
		}

		// collect the list of uris to import
		List<URI> uris = collectURIsToImport(event);

		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();

		// iterate all the resources and import them
		for (final org.eclipse.emf.common.util.URI uri : uris) {
			final Resource resource = resourceSet.getResource(uri, true);

			new UnicaseCommand() {
				@Override
				protected void doRun() {

					EList<EObject> contents = resource.getContents();
					if (contents.size() > 0) {
						for (int i = 0; i < contents.size(); i++) {
							// run the import command
							runImport(projectSpace, uri, (ModelElement) EcoreUtil.copy(contents.get(i)), i);
						}
					}
				}
			}.run();
		}
		MessageDialog.openInformation(null, "Import Model Elements", "Model ELements imported");
		return null;
	}

	/**
	 * Collects all URIs to import using the import dialog.
	 * 
	 * @param event
	 * @return
	 */
	private List<URI> collectURIsToImport(ExecutionEvent event) {
		ImportResourcesDialog dialog = new ImportResourcesDialog(HandlerUtil.getActiveShell(event), "Import model",
			SWT.MULTI);
		dialog.setBlockOnOpen(true);
		dialog.create();
		int result = dialog.open();

		return result == Dialog.OK ? dialog.getURIs() : new ArrayList<URI>();
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
		final ModelElement element, final int resourceIndex) {

		// try to find a wrapper for the element which will be added to the project
		ModelElement wrapper = ModelElementWrapperDescriptor.getInstance().wrapForImport(projectSpace.getProject(),
			element, uri, resourceIndex);

		// if no wrapper could be created, use the element itself to add it to the project
		if (wrapper == null) {
			wrapper = element;
		}

		// add the wrapper or the element itself to the project
		// copy wrapper to reset model element ids
		projectSpace.getProject().addModelElement(ModelUtil.copy(wrapper));
	}
}
