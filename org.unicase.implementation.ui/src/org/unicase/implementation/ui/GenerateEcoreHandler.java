/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.implementation.operations.util.EcoreGenerator;
import org.unicase.implementation.operations.util.NotSelfContainedException;
import org.unicase.model.classes.Package;

/**
 * Handler for the command to generate Ecore from the implementation model.
 * 
 * @author herrmi
 */
public class GenerateEcoreHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			List<Package> packages = getPackages(structuredSelection);
			reduce(packages);

			try {
				generateEcore(packages);
			} catch (NotSelfContainedException e) {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Error",
					"The selected packages are not self contained.");
			}
		}

		return null;
	}

	/**
	 * Get the selected implementation packages.
	 */
	@SuppressWarnings("unchecked")
	private List<Package> getPackages(IStructuredSelection structuredSelection) {
		List<Package> packages = new ArrayList<Package>();
		for (Iterator i = structuredSelection.iterator(); i.hasNext();) {
			packages.add((Package) i.next());
		}
		return packages;
	}

	/**
	 * Generate and save and Ecore model from the implementation packages.
	 */
	private void generateEcore(List<Package> packages) {
		EcoreGenerator generator = new EcoreGenerator();
		List<EPackage> ePackages = generator.generate(packages);

		FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
		dialog.setFilterExtensions(new String[] { "*.ecore" });
		String path = dialog.open();
		if (path != null) {
			ResourceSet resourceSet = new ResourceSetImpl();
			URI uri = URI.createFileURI(new File(path).getAbsolutePath());
			Resource resource = resourceSet.createResource(uri);
			resource.getContents().addAll(ePackages);
			try {
				resource.save(null);
			} catch (IOException e) {
				// ignore
			}
		}
	}

	/**
	 * Remove packages which are contained by others.
	 */
	private void reduce(List<Package> packages) {
		for (Iterator<Package> i = packages.iterator(); i.hasNext();) {
			Package p = i.next();
			if (contains(p.getParentPackage(), packages)) {
				i.remove();
			}
		}
	}

	/**
	 * Check whether a package is contained in a number of packages.
	 */
	private boolean contains(Package p, List<Package> packages) {
		while (p != null) {
			if (packages.contains(p)) {
				return true;
			}
			p = p.getParentPackage();
		}
		return false;
	}
}
