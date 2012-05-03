package org.unicase.papyrus.diagram;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ExportUMLWizard extends Wizard {
	
	private final Project project;
	
	public ExportUMLWizard(Project project) {
		super();
		this.project = project;
	}
	
	public void addPages() {
		addPage(new ExportUMLWizardPage(project, "Export UML"));
	}

	@Override
	public boolean performFinish() {
		
		
		if(ExportUMLWizardPage.getFormat().equals("ecore")){
			exportToEcore();
		}

		return true;
	}
	
	private void exportToEcore(){
		ResourceSet resourceSet = new ResourceSetImpl();
        Resource modelResource = resourceSet.createResource(URI.createURI(computeFileURI(ExportUMLWizardPage.getDestinationDir()+"model")));

        List<org.eclipse.uml2.uml.Package> packages = ExportUMLWizardPage.getPackages();
        PapyrusImporter importer = new PapyrusImporter(packages);
        Monitor monitor = new BasicMonitor();
        importer.doComputeEPackages(monitor);

        modelResource.getContents().addAll(importer.getEPackages());

        try {
                modelResource.save(null);
        } catch (IOException e) {
                e.printStackTrace();
        }
		
	}
	
	private String computeFileURI(String chosenPath) {

		// check if the file already exists on the disk
		// if it already exists create a new path by incrementing an index at the end of the name
		File file = new File(chosenPath+".ecore");
		int i = 1;
		while(file.exists()){
			chosenPath += i;
			i++;
			file = new File(chosenPath+".ecore");
		}
		
		// add the extension for ecore files
		chosenPath += ".ecore";
		
		String path = new File(chosenPath).toURI().toString();
        if(path.endsWith(".ecore")) {
                return path;
        } else {
                return path.concat(".ecore");
  
        }
  }

}
