package org.unicase.rap.ui.viewers;

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
import org.unicase.model.ModelPackage;
import org.unicase.workspace.ProjectSpace;

/**
 * Provides a table like overview of all available projects.
 * TODO: currently only observes a single EMF store server
 * @author emueller
 *
 */
public class ProjectsTableViewer extends AbstractETableViewer implements SelectionListener {

	private List<SelectionListener> listeners;
	
	public ProjectsTableViewer(Composite composite) {
		super(composite);	
		listeners = new ArrayList<SelectionListener>();
		getTable().addSelectionListener((SelectionListener) this);
	}
	
	public void setInput(List<ProjectSpace> projectSpaces) {
		WritableList emfList = new WritableList(Realm.getDefault(), projectSpaces, ProjectSpace.class);
		super.setInput(emfList);
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

	}

	public void widgetDefaultSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.data.toString());
	}

	public void widgetSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.item.getData().toString());	
		for (SelectionListener l : listeners) {
			l.widgetSelected(e);
		}
	}

	@Override
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(ModelPackage.Literals.PROJECT.eContainmentFeature());
		return list;
	}
	
	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}
}
