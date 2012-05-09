package org.unicase.papyrus.diagram;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.wizard.Wizard;

public class ExportUMLWizard extends Wizard {

	private final Project project;
	private ExportUMLWizardPage filePage;

	public ExportUMLWizard(Project project) {
		super();
		this.project = project;
	}

	public void addPages() {
		filePage = new ExportUMLWizardPage(project, "Export UML");
		addPage(filePage);
	}

	@Override
	public boolean performFinish() {
		if (filePage.getFormat().equals("ecore")) {
			exportToEcore();
		}

		return true;
	}

	/**
	 * Export the {@link org.eclipse.uml2.uml.Package uml Packages} selected in the WizardPage to the selected
	 * destination folder
	 */
	private void exportToEcore() {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet
			.createResource(URI.createURI(computeFileURI(filePage.getDestinationDir())));

		List<org.eclipse.uml2.uml.Package> packages = filePage.getPackages();
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

	/**
	 * Check if the file "model.ecore" already exists in the export folder, if so increment a number at the end of the
	 * file.
	 * 
	 * @param chosenPath the export folder
	 * @return the complete export path with filename
	 */
	private String computeFileURI(String chosenPath) {
		String path = chosenPath + "/model.ecore";

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		int i = 1;
		while (root.findMember(path) != null) {
			i++;
			path = chosenPath + "/model_" + i + ".ecore";
		}

		return path;
	}
}
