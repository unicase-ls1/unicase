/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecp.editor.MESuggestedSelectionDialog;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Handler for exporting Papyrus UML models to EMF ecore-files and eventually to corresponding genmodel-files. This
 * handler will prompt the user to select the Papyrus models first and afterwards a location to save the generated files
 * to. Using this information, this handler will generate the files from the models using {@link PapyrusImporter}.
 * 
 * @author mharut
 */
public class ExportUMLHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project project = validateSelection(event);

		if (project != null) {
			WizardDialog wizard = new WizardDialog(Display.getCurrent().getActiveShell(), new ExportUMLWizard(project));
			wizard.open();
			return null;
		}
		
		// compute packages that the user can select		
		EList<org.eclipse.uml2.uml.Package> allPackages = new BasicEList<org.eclipse.uml2.uml.Package>();
		List<EObject> selectableElements = new ArrayList<EObject>(allPackages.size());

		project.getAllModelElementsbyClass(UMLPackage.eINSTANCE.getPackage(), allPackages, true);
		for (Package umlPackage : allPackages) {
			selectableElements.add(umlPackage);
		}
		
		// prompt the user to select packages
		MESuggestedSelectionDialog selectionDialog = new MESuggestedSelectionDialog("Package Selection",
			"Please select the packages you would like to export.", true, UMLFactory.eINSTANCE.createPackage(),
			UMLPackage.eINSTANCE.getPackage_PackagedElement(), selectableElements);
		if(selectionDialog.open() != Dialog.OK) {
			return null;
		}
		Collection<EObject> modelElements = selectionDialog.getModelElements();
		List<org.eclipse.uml2.uml.Package> packages = new ArrayList<org.eclipse.uml2.uml.Package>(modelElements.size());
		
		// add the selected packages
		for (EObject eObject : selectionDialog.getModelElements()) {
			if (eObject instanceof org.eclipse.uml2.uml.Package) {
				packages.add((Package) eObject);
			}
		}

		SaveAsDialog saveDialog = new SaveAsDialog(Display.getCurrent().getActiveShell());

		if (saveDialog.open() != Dialog.OK) {
			return null;
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet.createResource(URI.createURI(computeFileURI(saveDialog.getResult())));

		PapyrusImporter importer = new PapyrusImporter(packages);
		Monitor monitor = new BasicMonitor();
		importer.doComputeEPackages(monitor);

		modelResource.getContents().addAll(importer.getEPackages());

		try {
			modelResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String computeFileURI(IPath path) {
		String stringPath = path.toString();
		if(stringPath.endsWith(".ecore")) {
			return stringPath;
		} else {
			return stringPath.concat(".ecore");
		}
	}

	private Project validateSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			Object element = iss.getFirstElement();
			if (element instanceof Project) {
				return (Project) element;
			} else if (element instanceof ProjectSpace) {
				return ((ProjectSpace) element).getProject();
			} else if (element instanceof EObject) {
				return ModelUtil.getProject((EObject) element);
			}
		}

		throw new IllegalArgumentException("Invalid selection! Please select a Project or any contained model element!");
	}

}
