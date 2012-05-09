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
import org.eclipse.jface.dialogs.MessageDialog;
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
			return exportToEcore();
		}

		return false;
	}

	/**
	 * Export the {@link org.eclipse.uml2.uml.Package uml Packages} selected in the WizardPage to the selected
	 * destination folder
	 * 
	 * @return true, if the ecore was successfully exported
	 */
	private boolean exportToEcore() {
		List<org.eclipse.uml2.uml.Package> packages = filePage.getPackages();

		String path = computeFileURI(filePage.getDestinationDir(), packages);

		// Check if resource already exists and ask if it should be overwritten
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root.findMember(path) != null
			&& !MessageDialog.openQuestion(getShell(), "File already exists", "The file \"" + path
				+ "\" already exists.\nOverwrite it?")) {
			return false;
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet.createResource(URI.createURI(path));

		PapyrusImporter importer = new PapyrusImporter(packages);
		Monitor monitor = new BasicMonitor();
		importer.doComputeEPackages(monitor);

		modelResource.getContents().addAll(importer.getEPackages());

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
	private String computeFileURI(String chosenPath, List<org.eclipse.uml2.uml.Package> packages) {
		// make a suitable fileName from the packageNames (usually only one package)
		String fileName = "";
		for (org.eclipse.uml2.uml.Package p : packages) {
			fileName += p.getName() + "_";
		}
		if (fileName.length() > 0) {
			fileName = fileName.substring(0, fileName.length() - 1);
		}

		String path = chosenPath + "/" + fileName + ".ecore";

		return path;
	}
}
