package org.unicase.ui.web.tabs;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.ui.web.views.AbstractETableViewer;
import org.unicase.workspace.ProjectSpace;

public abstract class AbstractProjectListView extends AbstractETableViewer implements ProjectChangeObserver {
	
	private ProjectSpace projectSpace;

	public AbstractProjectListView(ProjectSpace projectSpace, Composite parent) {
		super(parent);
		this.projectSpace = projectSpace;
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	// TODO: where do we call this?
	public abstract ArrayList<EStructuralFeature> getFeatureList();
	

	/**
	 * 
	 * @param project
	 * @param modelElement
	 */
	public abstract void update(Project project, ModelElement modelElement);
	
	public void refreshView() {
		// do nothing, since there's another update method
	}
	
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	public Project getProject() {
		return projectSpace.getProject();
	}
	
	@Override
	protected void init() {
		super.init();
		getProject().addProjectChangeObserver(this);
	}
	
	public void modelElementAdded(Project project, ModelElement modelElement) {
		update(project, modelElement);
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		update(project, modelElement);
	}

}
