package org.unicase.ui.web.tabs;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;

public class ProjectListView extends AbstractListView {

	public ProjectListView(ProjectSpace projectSpace, Composite composite) {
		super(projectSpace, composite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<EStructuralFeature> getFeatureList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListInput(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub
		
	}

}
