package org.unicase.papyrus.diagram;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.wizard.Wizard;

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
		return true;
	}

}
