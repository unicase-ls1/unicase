package org.unicase.ui.web.projectview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.web.views.AbstractETableViewer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class ProjectsTableViewer extends AbstractETableViewer implements SelectionListener {

	public ProjectsTableViewer(Composite composite) {
		super(composite);	
		getTable().addSelectionListener((SelectionListener) this);
	}

	public void refreshView() {
		List<ProjectSpace> spaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();

		// the case of first time of input setting to table
		WritableList emfList = new WritableList(Realm.getDefault(),
				spaces, ModelElement.class);
		setInput(emfList);
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

	}

	public void widgetDefaultSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.getID());	
	}

	public void widgetSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.getID());	
	}

	@Override
	public ArrayList<EStructuralFeature> getFeaturesList() {
		// TODO Auto-generated method stub
		return null;
	}
}
