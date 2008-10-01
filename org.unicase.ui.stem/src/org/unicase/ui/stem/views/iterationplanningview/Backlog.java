package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.model.Project;

public class Backlog extends EObjectImpl {

	private Project project;

	public Backlog(Project project) {
		this.setProject(project);
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	

}
