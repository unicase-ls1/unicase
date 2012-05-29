/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.codegeneration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;

/**
 * This Wizard helps generating code from uml models
 */
public class UML2CodeWizard extends Wizard {

	private final List<org.eclipse.uml2.uml.Package> packages;
	private UML2CodeWizardPage filePage;

	/**
	 * Constructor
	 * 
	 * @param packages a list of uml packges to export, currently only the first one is used
	 */
	public UML2CodeWizard(List<org.eclipse.uml2.uml.Package> packages) {
		super();
		this.packages = packages;
	}

	/**
	 * Add wizard pages.
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		filePage = new UML2CodeWizardPage();
		addPage(filePage);
	}

	@Override
	public boolean performFinish() {
		if (filePage.getFormat().equals("ecore")) {
			return exportToEcore();
		} else if (filePage.getFormat().equals("Java")) {
			return exportJava();
		}

		return false;
	}

	/**
	 * Export the {@link org.eclipse.uml2.uml.Package uml Packages} selected in the WizardPage to the selected
	 * destination folder.
	 * 
	 * @return true, if the ecore was successfully exported
	 */
	private boolean exportToEcore() {
		String fileName = computeFileName(packages);
		String path = filePage.getDestinationDir() + "/" + fileName;

		// Check if resource already exists and ask if it should be overwritten
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root.findMember(path) != null
			&& !MessageDialog.openQuestion(getShell(), "File already exists", "The file \"" + path
				+ "\" already exists.\nOverwrite it?")) {
			return false;
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet.createResource(URI.createURI(path));

		Monitor monitor = new BasicMonitor();

		modelResource.getContents().addAll(convertUmlToEPackages(packages, monitor));

		try {
			modelResource.save(null);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Create a fileName from the names of the given packages and append it to the chosenPath.
	 * 
	 * @param chosenPath the export folder
	 * @param packages the packages that will be exported
	 * @return the complete export path with filename
	 */
	private String computeFileName(List<org.eclipse.uml2.uml.Package> packages) {
		// make a suitable fileName from the packageNames (usually only one
		// package)
		String fileName = "";
		for (org.eclipse.uml2.uml.Package p : packages) {
			fileName += p.getName() + "_";
		}
		if (fileName.length() > 0) {
			fileName = fileName.substring(0, fileName.length() - 1);
		}

		String path = fileName + ".ecore";

		return path;
	}

	private boolean exportJava() {
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource dest = root.findMember(filePage.getDestinationDir());
				File targetFolder = dest.getLocation().toFile();

				GenerateJava generator;
				try {
					generator = new GenerateJava(packages.get(0), targetFolder, new ArrayList<String>());
					generator.doGenerate(BasicMonitor.toMonitor(monitor));
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					dest.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		};
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}

	private List<EPackage> convertUmlToEPackages(List<org.eclipse.uml2.uml.Package> umlPackages, Monitor monitor) {
		PapyrusImporter importer = new PapyrusImporter(umlPackages);
		importer.doComputeEPackages(monitor);
		return importer.getEPackages();
	}
}
